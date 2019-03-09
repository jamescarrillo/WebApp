/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import com.google.gson.Gson;
import gob.peam.administracion.beans.Correlativo;
import gob.peam.administracion.dao.CorrelativoDao;
import gob.peam.administracion.dao.SesionDao;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jpgprog84
 */
@WebServlet(name = "CorrelativoServlet", urlPatterns = {"/Correlativo"})
public class CorrelativoServlet extends HttpServlet {

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
          SesionDao sesionDao = new SesionDao();
        if (!sesionDao.verificarSesion(request, response)) {
            response.sendRedirect("./Login");
        } else {
            String action = request.getParameter("action") == null ? "" : request.getParameter("action");
            switch (action) {
                case "ActualizarCorrelativo":
                    actualizarCorrelativo(request, response);
                    break;
                case "BuscarCorrelativo":
                    buscarCorrelativo(request, response);
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

    private void actualizarCorrelativo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        Gson g = new Gson();
        HashMap hm = new HashMap();
        CorrelativoDao dao = new CorrelativoDao();
        Correlativo correlativo = new Correlativo();
        correlativo.setTiemAnio(request.getSession().getAttribute("anio").toString());
        correlativo.setCorrCotizacion(request.getParameter("corrCotizacion"));
        correlativo.setCorrCotizacionContrato(request.getParameter("corrCotizacionContrato"));
        correlativo.setCorrCotizacionDirecta(request.getParameter("corrCotizacionDirecta"));
        correlativo.setCorrExpediente(request.getParameter("corrExpediente"));
        correlativo.setCorrNotaIngreso(request.getParameter("corrNotaIngreso"));
        correlativo.setCorrNotaSalida(request.getParameter("corrNotaSalida"));
        correlativo.setCorrRequerimiento(request.getParameter("corrRequerimiento"));
        if (dao.actualizarCorrelativo(correlativo)) {
            hm.put("success", true);
            hm.put("msg", "Los Parametros de los Documentos se Actualizaron Correctamente");
        } else {
            hm.put("success", false);
            hm.put("msg", "Hubo un Probema al Actualizar  los Parametros de los Documentos");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void buscarCorrelativo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        CorrelativoDao dao = new CorrelativoDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        Correlativo correlativo = dao.buscarCorrelativo(request.getSession().getAttribute("anio").toString());
        hm.put("correlativo", correlativo);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }
}
