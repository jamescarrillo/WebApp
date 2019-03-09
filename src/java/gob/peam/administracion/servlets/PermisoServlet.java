/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import com.google.gson.Gson;
import gob.peam.administracion.beans.Permisos;
import gob.peam.administracion.dao.PermisosDao;
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
@WebServlet(name = "Permiso", urlPatterns = {"/Permiso"})
public class PermisoServlet extends HttpServlet {

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
                case "ListarPermisosPorModuloAndRol":
                    listarPermisosPorModuloAndRol(request, response);
                    break;
                case "InsertarPermisos":
                    insertarPermisos(request, response);
                    break;
                case "BuscarPermisoPorUsuario":
                    buscarPermisoPorUsuario(request, response);
                    break;
                case "RegistroIdSubmodulo":
                    registroIdSubmodulo(request, response);
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

    private void listarPermisosPorModuloAndRol(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PermisosDao dao = new PermisosDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        Integer idModulo = Integer.parseInt(request.getParameter("idModulo"));
        Integer idRol = Integer.parseInt(request.getParameter("idRol"));
        hm.put("idModulo", idModulo);
        hm.put("idRol", idRol);
        List<Permisos> permisoses = dao.listarPermisosPorSubModulo(hm);
        hm = new HashMap();
        hm.put("permisos", permisoses);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

   private void buscarPermisoPorUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PermisosDao dao = new PermisosDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        
        hm.put("idSubModulo", "".equals(request.getParameter("subId")) ? "1" : request.getParameter("subId"));
        
        hm.put("usuaLogin", request.getSession().getAttribute("user").toString());
        hm.put("permiso", dao.buscarPermisoPorUsuario(hm));
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }
    
    private void registroIdSubmodulo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("idSubModulo", request.getParameter("id"));
    }
    
    private void insertarPermisos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        Gson g = new Gson();
        PermisosDao dao = new PermisosDao();
        Collection list = g.fromJson(request.getParameter("permisos"), Collection.class);
        List<Permisos> permisoses = new ArrayList();
        for (Object object : list) {
            Permisos p = g.fromJson(g.toJson(object), Permisos.class);
            permisoses.add(p);
        }
        //ahora lo que tenemos que hacer el consultar e insertar o actualizar
        HashMap hm = new HashMap();
        if (dao.insertarPermisos(permisoses)) {
            hm.put("success", true);
            hm.put("msg", "Los Permisos se Asignaron Correctamente");
        } else {
            hm.put("success", false);
            hm.put("msg", "Hubo un Probema al Asignar los Permisos");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }


}
