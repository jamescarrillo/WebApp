/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.servlet;

import com.google.gson.Gson;
import gob.peam.beans.DirectorioTelefonico;
import gob.peam.dao.DirectorioTelefonicoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jprada
 */
@WebServlet(name = "LaInstitucion", urlPatterns = {"/LaInstitucion"})
public class InstitucionServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -5561384507654722413L;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String respuesta = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (respuesta) {
            case "":
                index(request, response);
                break;
            case "Vision":
                vision(request, response);
                break;
            case "QuienesSomos":
                quienesSomos(request, response);
                break;
            case "Objetivo":
                objetivo(request, response);
                break;
            case "Ubicacion":
                ubicacion(request, response);
                break;
            case "Estructura":
                estructura(request, response);
                break;
            case "Directorio":
                directorio(request, response);
                break;
            case "ListarDirectorioTelefonico":
                listarDirectorioTelefonico(request, response);
                break;
            case "ActualizarDirectorio":
                actualizarDirectorio(request, response);
                break;
            case "GetDirectorio":
                getDirectorio(request, response);
                break;
            case "Etica":
                etica(request, response);
                break;
        }

    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void listarDirectorioTelefonico(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DirectorioTelefonicoDao directorioTelefonicoDao = new DirectorioTelefonicoDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("query", "%" + query.toUpperCase() + "%");
            hm.put("order", "asc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<DirectorioTelefonico> list = directorioTelefonicoDao.listarDirectorioTelefonicoForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", directorioTelefonicoDao.listTotalDirectorioTelefonicoForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void directorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/institucion/directorio.jsp").forward(request, response);
    }

    private void estructura(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/institucion/estructura.jsp").forward(request, response);
    }

    private void ubicacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/institucion/ubicacion.jsp").forward(request, response);
    }

    private void objetivo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/institucion/objetivo.jsp").forward(request, response);
    }

    private void quienesSomos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/institucion/quienesSomos.jsp").forward(request, response);
    }

    private void vision(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/institucion/vision.jsp").forward(request, response);
    }
    
     private void etica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/institucion/etica.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed"
    // desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/institucion/index.jsp").forward(request, response);
    }

    private void actualizarDirectorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson g = new Gson();
        HashMap hm = new HashMap();
        DirectorioTelefonico bean = new DirectorioTelefonico();
        bean.setOficina(request.getParameter("oficina") == null ? "" : request.getParameter("oficina"));
        bean.setId(request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id")));
        bean.setSeccion(request.getParameter("seccion") == null ? "" : request.getParameter("seccion"));
        bean.setAnexo(request.getParameter("anexo") == null ? "" : request.getParameter("anexo").toUpperCase());
        Boolean flag = true;
        if ("0".equals(request.getParameter("op"))) {
            flag = new DirectorioTelefonicoDao().insert(bean);
        } else {
            flag = new DirectorioTelefonicoDao().update(bean);
        }
        if (flag) {
            hm.put("msg", "La Operaci&#243;n Fu&#233; Exitoso");
        } else {
            hm.put("msg", "Ya hay un registro con este Nombre");
        }

        hm.put("success", flag);
        response.getWriter().print(g.toJson(hm));
    }

    private void getDirectorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        Gson g = new Gson();
        try {
            DirectorioTelefonico bean = new DirectorioTelefonicoDao().obtenerBean(Integer.parseInt(request.getParameter("id")));
            response.getWriter().print(g.toJson(bean));
        } catch (NullPointerException ex) {
            response.getWriter().print("Intento Fallido");
        }
    }
}
