/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import com.google.gson.Gson;
import gob.peam.administracion.beans.ParametroDocumento;
import gob.peam.administracion.dao.ParametroDocumentoDao;
import gob.peam.administracion.dao.SesionDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jpgprog84
 */
@WebServlet(name = "ParametroDocumentoServlet", urlPatterns = {"/ParametroDocumento"})
public class ParametroDocumentoServlet extends HttpServlet {

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
                case "ActualizarParametros":
                    actualizarParametros(request, response);
                    break;
                case "BuscarParametro":
                    buscarParametro(request, response);
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

    private void actualizarParametros(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        Gson g = new Gson();
        ParametroDocumentoDao dao = new ParametroDocumentoDao();
        Collection list = g.fromJson(request.getParameter("parametrosDocumento"), Collection.class);
        List<ParametroDocumento> parametroDocumentos = new ArrayList();
        for (Object object : list) {
            ParametroDocumento p = g.fromJson(g.toJson(object), ParametroDocumento.class);
            parametroDocumentos.add(p);
        }
        //ahora lo que tenemos que hacer el consultar e insertar o actualizar
        HashMap hm = new HashMap();
        if (dao.actualizarParametroDocumento(parametroDocumentos)) {
            hm.put("success", true);
            hm.put("msg", "Los Parametros de los Documentos se Actualizaron Correctamente");
        } else {
            hm.put("success", false);
            hm.put("msg", "Hubo un Probema al Actualizar  los Parametros de los Documentos");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void buscarParametro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ParametroDocumentoDao dao = new ParametroDocumentoDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        Integer tipoDocumento = Integer.parseInt(request.getParameter("tipoDocumento"));
        ParametroDocumento pd = dao.buscarParametroDocumento(tipoDocumento);
        hm.put("parametroDocumento", pd);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }
}
