/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.servlet;

import com.google.gson.Gson;
import gob.peam.dao.GlosarioDao;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jprada
 */
@WebServlet(name = "Glosario", urlPatterns = {"/Glosario"})
public class GlosarioServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 5259212568245581992L;

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
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("action") == null) {
            index(request, response);
        }
        switch (request.getParameter("action")) {
            case "":
                index(request, response);
                break;
            case "Glosario":
                HashMap hm = new HashMap();
                String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
                int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
                int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
                hm.put("query", "%" + query + "%");
                hm.put("limit", limit);
                hm.put("start", start);
                hm.put("items", new GlosarioDao().listItemsWeb(hm));
                hm.put("total", new GlosarioDao().listTotalWeb(hm));
                hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
                response.getWriter().print(new Gson().toJson(hm));
                break;


        }
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

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/glosario/index.jsp").forward(request, response);
    }
}
