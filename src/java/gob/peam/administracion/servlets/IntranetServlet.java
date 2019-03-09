/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import gob.peam.administracion.dao.ModuloDao;
import gob.peam.administracion.dao.SesionDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jpgprog84
 */
@WebServlet(name = "Intranet", urlPatterns = {"/Intranet"})
public class IntranetServlet extends HttpServlet {

    private static final long serialVersionUID = 8326534055234264474L;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        SesionDao sesionDao = new SesionDao();
        if (!sesionDao.verificarSesion(request, response)) {
            response.sendRedirect("login.jsp");
        } else {
            String action = request.getParameter("action") == null ? "" : request.getParameter("action");
            switch (action) {
                case "":
                    index(request, response);
                    break;
                case "Redirect":
                    redirect(request);
                    break;
            }
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
        request.setAttribute("navigation", "");
        ModuloDao dao = new ModuloDao();
        request.setAttribute("gadgets", dao.listarModulosPorUsuario(Integer.parseInt(request.getSession().getAttribute("idUsuario").toString())));
        request.getRequestDispatcher("./WEB-INF/intranet/intranet.jsp").forward(request, response);
    }

    private void redirect(HttpServletRequest request) throws ServletException, IOException {
        request.getSession().setAttribute("idModulo", request.getParameter("idModulo"));
    }
}
