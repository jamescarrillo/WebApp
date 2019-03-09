/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import gob.peam.administracion.beans.Thema;
import gob.peam.administracion.dao.ThemaDao;
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
 * @author alabajos
 */
@WebServlet(name = "TemasServlet", urlPatterns = {"/Temas"})
public class TemasServlet extends HttpServlet {

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
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action) {
            case "":
                index(request, response);
                break;
            case "ListarEstilos":
                listarEstilos(request, response);
                break;
            case "insertarEstilo":
                insertarEstilo(request, response);
                break;
            case "actualizarEstilo":
                actualizarEstilo(request, response);
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
        request.getRequestDispatcher("./WEB-INF/intranet/web/temas.jsp").forward(request, response);
    }

    private void insertarEstilo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HashMap h = new HashMap();
        h.put("usuaId", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        h.put("moduId", Integer.parseInt(request.getSession().getAttribute("idModulo").toString()));
        h.put("theId", 10);
        new ThemaDao().insertarThema(h);
    }

    private void actualizarEstilo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HashMap h = new HashMap();
        h.put("usuaId", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        h.put("moduId", Integer.parseInt(request.getSession().getAttribute("idModulo").toString()));
        h.put("theId", Integer.parseInt(request.getParameter("idThema")));
        new ThemaDao().actualizarThema(h);
    }

    private void listarEstilos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ThemaDao thema = new ThemaDao();
        List<Thema> data = thema.estiloPorUsuarioyModulo();
        String estilo;
        estilo = "";
        HashMap h = new HashMap();
        h.put("usuaId", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        h.put("moduId", Integer.parseInt(request.getSession().getAttribute("idModulo").toString()));
        Thema activo = thema.buscarEstiloPorUsuarioyModulo(h);
        Integer id = 1;
        try {
            id = activo.getTheId();
        } catch (NullPointerException ex) {
                h.put("theId", 1);
                new ThemaDao().insertarThema(h);
        }
        for (Thema temas : data) {
            if (id != temas.getTheId()) {
                estilo += "<div class='thumbnail' ><img src='./resources/images/themeGallery/" + temas.getTheImg() + "' /><table><tbody><tr><th style='text-align:right'><input type='radio'  id='" + temas.getTheId() + "' dir='editar' role='input' class='estilos' name='temas' /></th><td>"+ temas.getTheNombre() +"</td></tr></tbody></table></div>";
            } else {
                estilo += "<div class='thumbnail' ><img src='./resources/images/themeGallery/" + temas.getTheImg() + "' /><table><tbody><tr><th style='text-align:right'><input type='radio' checked='checked' id='" + temas.getTheId() + "' dir='editar' role='input'  class='estilos' name='temas' /></th><td>"+ temas.getTheNombre() +"</td></tr></tbody></table></div>";
            }
        }
        estilo += "";
        out.print(estilo);
    }
}
