/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import com.google.gson.Gson;
import gob.peam.administracion.beans.Modulo;
import gob.peam.administracion.dao.ModuloDao;
import gob.peam.administracion.dao.SesionDao;
import java.io.IOException;
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
@WebServlet(name = "Modulo", urlPatterns = {"/Modulo"})
public class ModuloServlet extends HttpServlet {

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
                case "ListarModulos":
                    listarModulos(request, response);
                    break;
                case "ListarModulosForPermisos":
                    listarModulosForPermisos(request, response);
                    break;
                case "InsertarModulo":
                    insertarModulo(request, response);
                    break;
                case "BuscarModulo":
                    buscarModulo(request, response);
                    break;
                case "ActualizarModulo":
                    actualizarModulo(request, response);
                    break;
                case "EliminarModulo":
                    eliminarModulo(request, response);
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

    private void listarModulos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ModuloDao dao = new ModuloDao();
        Gson g = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        HashMap hm = new HashMap();
        hm.put("query", "%" + query + "%");
        hm.put("limit", limit);
        hm.put("start", start);
        List<Modulo> list = dao.listarModulos(hm);
        hm.put("modulos", list);
        hm.put("total", dao.listarTotalModulos(hm));
        hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void insertarModulo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ModuloDao dao = new ModuloDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        Modulo m = new Modulo();
        m.setDescripcion(request.getParameter("descripcion").trim().toUpperCase());
        m.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
        m.setNombre(request.getParameter("nombre").trim().toUpperCase());
        m.setUrl(request.getParameter("url").trim());
        if (dao.existeModulo(m.getNombre())) {
            hm.put("success", false);
            hm.put("msg", "El M&oacute;dulo Ya Existe en Otro Registro");
        } else {
            if (dao.insertarModulo(m)) {
                hm.put("success", true);
                hm.put("msg", "El M&oacute;dulo se Inserto correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo un Problema al Insertar al M&oacute;dulo");
            }
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void buscarModulo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ModuloDao dao = new ModuloDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        Modulo m = dao.buscarModulo(Integer.parseInt(request.getParameter("id")));
        hm.put("modulo", m);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void actualizarModulo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ModuloDao dao = new ModuloDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        Modulo modulo = new Modulo();
        modulo.setDescripcion(request.getParameter("descripcion").trim().toUpperCase());
        modulo.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
        modulo.setIdModulo(Integer.parseInt(request.getParameter("idModulo")));
        modulo.setNombre(request.getParameter("nombre").trim().toUpperCase());
        modulo.setUrl(request.getParameter("url").trim());
        Modulo m = dao.buscarModuloPorNombre(modulo.getNombre());
        if (m != null) {
            if (m.getIdModulo() == modulo.getIdModulo()) {
                if (dao.actualizarModulo(modulo)) {
                    hm.put("success", true);
                    hm.put("msg", "La actualizaci&oacute;n del M&oacute;dulo se Realiz&oacute; Correctamente");
                } else {
                    hm.put("success", false);
                    hm.put("msg", "Hubo un Problema al actualizar el M&oacute;dulo");
                }
            } else {
                hm.put("success", false);
                hm.put("msg", "El M&oacute;dulo Ya se Encuentra en Otro Registro");
            }
        } else {
            if (dao.actualizarModulo(modulo)) {
                hm.put("success", true);
                hm.put("msg", "La actualizaci&oacute;n del M&oacute;dulo se Realiz&oacute; Correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo un Problema al actualizar el M&oacute;dulo");
            }
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void eliminarModulo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ModuloDao dao = new ModuloDao();
        HashMap hm = new HashMap();
        Gson g = new Gson();
        if (!dao.hasChildrenModulo(Integer.parseInt(request.getParameter("idModulo")))) {
            if (dao.eliminarModulo(Integer.parseInt(request.getParameter("idModulo")))) {
                hm.put("success", true);
                hm.put("msg", "El M&oacute;dulo se Eliminó correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo Un Problema al Eliminar El M&oacute;dulo");
            }
        } else {
            hm.put("success", false);
            hm.put("msg", "El M&oacute;dulo Tiene SubM&oacute;dulos Asignados");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void listarModulosForPermisos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ModuloDao dao = new ModuloDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        List<Modulo> list = dao.listarModulosForPermisos();
        hm.put("modulos", list);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }
}