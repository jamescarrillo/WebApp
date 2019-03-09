/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gob.peam.beans.ConvocatoriaPers;
import gob.peam.dao.ConvocatoriaDao;
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
@WebServlet(name = "Convocatorias", urlPatterns = {"/Convocatorias"})
public class ConvocatoriasServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1025526538477418250L;

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String respuesta = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (respuesta) {
            case "":
                index(request, response);
                break;
            case "convocatoria":
                convocatoriaBien(request, response);
                break;
            case "Comites":
                comites(request, response);
                break;
            case "Exonerado":
                exonerado(request, response);
                break;

            case "listconvocatoriapers":
                listarConvocatoriasPers(request, response);
                break;
        }
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/convocatorias/index.jsp").forward(request, response);
    }

    private void convocatoriaBien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/convocatorias/convocatoriabien.jsp").forward(request, response);
    }

    private void comites(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/convocatorias/comites.jsp").forward(request, response);
    }

    private void exonerado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/convocatorias/exonerado.jsp").forward(request, response);
    }

    private void listarConvocatoriasPers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ConvocatoriaDao convocatoriaDao = new ConvocatoriaDao();
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        String flag = request.getParameter("flag") == null ? "true" : request.getParameter("flag");
        HashMap hm = new HashMap();
        //hm.put("anio", request.getParameter("anho"));
        hm.put("query", "%" + query + "%");
        hm.put("ruta", "concat('./Convocatoria?action=listconvocatoria&id=',id) ruta");
        hm.put("order", "asc");

        hm.put("flag", "and estado=" + flag);

        hm.put("limit", limit);
        hm.put("start", start);
        List<ConvocatoriaPers> list = convocatoriaDao.listConvocatoriaPersForWeb(hm);
        HashMap outHash = new HashMap();
        outHash.put("items", list);
        outHash.put("total", convocatoriaDao.listTotalConvocatoriaPersForWeb(hm));
        outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = gson.toJson(outHash);
        out.print(arg);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
}
