package gob.peam.administracion.servlets;

import com.google.gson.Gson;
import gob.peam.beans.Configuracion;
import gob.peam.dao.ConfiguracionDao;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Configuracion
 */
@WebServlet("/DocumentosGestion")
public class DocumentosGestionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocumentosGestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action) {
            case "":
                index(request, response);
                break;
            case "ActualizarConfiguracion":
                actualizarConfiguracion(request, response);
        }

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        processRequest(request, response);
    }

    private void actualizarConfiguracion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson g = new Gson();
        Configuracion config = g.fromJson(request.getParameter("configuracion"), Configuracion.class);
        ConfiguracionDao dao = new ConfiguracionDao();
        HashMap hm = new HashMap();
        if (dao.actualizarConfiguracion(config)) {
            hm.put("success", true);
            hm.put("msg", "La configuración se actualiz&oacute; correctamente");
        } else {
            hm.put("success", false);
            hm.put("msg", "La configuración no se actualiz&oacute; correctamente, comuniquese con el administrador del sistema!!!");
        }
        String msg = g.toJson(hm);
        response.getWriter().print(msg);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ConfiguracionDao dao = new ConfiguracionDao();
        request.setAttribute("configuracion", dao.configuracionForWeb());
        request.getRequestDispatcher("./WEB-INF/intranet/web/documentosGestion.jsp").forward(request, response);
    }
}
