/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import com.google.gson.Gson;
import gob.peam.administracion.beans.Etiqueta;
import gob.peam.administracion.beans.Modulo;
import gob.peam.administracion.beans.SubModulo;
import gob.peam.administracion.dao.SesionDao;
import gob.peam.administracion.dao.SubModuloDao;
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
@WebServlet(name = "SubModulo", urlPatterns = {"/SubModulo"})
public class SubModuloServlet extends HttpServlet {

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
                case "ListarSubModulosPorModulo":
                    listarSubModuloPorModulo(request, response);
                    break;
                case "InsertarSubModulo":
                    insertarSubModulo(request, response);
                    break;
                case "BuscarSubModulo":
                    buscarSubModulo(request, response);
                    break;
                case "ActualizarSubModulo":
                    actualizarSubModulo(request, response);
                    break;
                case "EliminarSubModulo":
                    eliminarSubModulo(request, response);
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

    private void listarSubModuloPorModulo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        SubModuloDao dao = new SubModuloDao();
        Gson g = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        int idModulo = Integer.parseInt(request.getParameter("idModulo"));
        HashMap hm = new HashMap();
        hm.put("query", "%" + query + "%");
        hm.put("limit", limit);
        hm.put("idModulo", idModulo);
        hm.put("start", start);
        List<SubModulo> list = dao.listarSubModulosForModulo(hm);
        hm.put("subModulos", list);
        hm.put("total", dao.listarTotalSubModulosForModulo(hm));
        hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void insertarSubModulo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        SubModuloDao dao = new SubModuloDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        SubModulo m = new SubModulo();
        m.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
        m.setNombre(request.getParameter("nombre").trim().toUpperCase());
        m.setUrl(request.getParameter("url").trim());
        Etiqueta etiqueta = new Etiqueta();
        etiqueta.setIdEtiqueta(Integer.parseInt(request.getParameter("idEtiqueta")));
        m.setEtiqueta(etiqueta);
        Modulo modulo = new Modulo();
        modulo.setIdModulo(Integer.parseInt(request.getParameter("idModulo")));
        m.setModulo(modulo);
        if (dao.existeSubModulo(m.getNombre())) {
            hm.put("success", false);
            hm.put("msg", "El SubM&oacute;dulo Ya Existe en Otro Registro");
        } else {
            if (dao.insertarSubModulo(m)) {
                hm.put("success", true);
                hm.put("msg", "El SubM&oacute;dulo se Inserto correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo un Problema al Insertar al SubM&oacute;dulo");
            }
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void buscarSubModulo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        SubModuloDao dao = new SubModuloDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        SubModulo m = dao.buscarSubModulo(Integer.parseInt(request.getParameter("id")));
        hm.put("subModulo", m);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void actualizarSubModulo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        SubModuloDao dao = new SubModuloDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        SubModulo subModulo = new SubModulo();
        subModulo.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
        subModulo.setIdSubModulo(Integer.parseInt(request.getParameter("idSubModulo")));
        subModulo.setNombre(request.getParameter("nombre").trim().toUpperCase());
        subModulo.setUrl(request.getParameter("url").trim());
        Etiqueta etiqueta = new Etiqueta();
        etiqueta.setIdEtiqueta(Integer.parseInt(request.getParameter("idEtiqueta")));
        subModulo.setEtiqueta(etiqueta);
        Modulo modulo = new Modulo();
        modulo.setIdModulo(Integer.parseInt(request.getParameter("idModulo")));
        subModulo.setModulo(modulo);
        SubModulo m = dao.buscarSubModuloPorNombre(subModulo.getNombre());
        if (m != null) {
            if (m.getIdSubModulo() == subModulo.getIdSubModulo()) {
                if (dao.actualizarSubModulo(subModulo)) {
                    hm.put("success", true);
                    hm.put("msg", "La actualizaci&oacute;n del SubM&oacute;dulo se Realiz&oacute; Correctamente");
                } else {
                    hm.put("success", false);
                    hm.put("msg", "Hubo un Problema al actualizar el SubM&oacute;dulo");
                }
            } else {
                hm.put("success", false);
                hm.put("msg", "El SubM&oacute;dulo Ya se Encuentra en Otro Registro");
            }
        } else {
            if (dao.actualizarSubModulo(subModulo)) {
                hm.put("success", true);
                hm.put("msg", "La actualizaci&oacute;n del SubM&oacute;dulo se Realiz&oacute; Correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo un Problema al actualizar el SubM&oacute;dulo");
            }
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void eliminarSubModulo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        SubModuloDao dao = new SubModuloDao();
        HashMap hm = new HashMap();
        Gson g = new Gson();
        if (!dao.hasChildrenSubModulo(Integer.parseInt(request.getParameter("idSubModulo")))) {
            if (dao.eliminarSubModulo(Integer.parseInt(request.getParameter("idSubModulo")))) {
                hm.put("success", true);
                hm.put("msg", "El SubM&oacute;dulo se Eliminó correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo Un Problema al Eliminar El SubM&oacute;dulo");
            }
        } else {
            hm.put("success", false);
            hm.put("msg", "El SubM&oacute;dulo Tiene Dependencias con Permisos del Sistema");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }
}
