/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import com.google.gson.Gson;
import gob.peam.administracion.beans.Rol;
import gob.peam.administracion.dao.RolDao;
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
@WebServlet(name = "Rol", urlPatterns = {"/Rol"})
public class RolServlet extends HttpServlet {

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
                case "ListarRoles":
                    listarRoles(request, response);
                    break;
                case "ListarRolesPorGrupo":
                    listarRolesPorGrupo(request, response);
                    break;
                case "ListarRolesSinGrupo":
                    listarRolesSinGrupo(request, response);
                    break;
                case "InsertarRol":
                    insertarRol(request, response);
                    break;
                case "BuscarRol":
                    buscarRol(request, response);
                    break;
                case "ActualizarRol":
                    actualizarRol(request, response);
                    break;
                case "EliminarRol":
                    eliminarRol(request, response);
                    break;
                case "InsertarPerfil":
                    insertarPerfil(request, response);
                    break;
                case "EliminarPerfil":
                    eliminarPerfil(request, response);
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

    private void listarRoles(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        RolDao dao = new RolDao();
        Gson g = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        HashMap hm = new HashMap();
        hm.put("query", "%" + query + "%");
        hm.put("limit", limit);
        hm.put("start", start);
        List<Rol> list = dao.listarRoles(hm);
        hm.put("roles", list);
        hm.put("total", dao.listarTotalRoles(hm));
        hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void insertarRol(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        RolDao dao = new RolDao();
        Gson g = new Gson();
        Rol r = new Rol();
        HashMap hm = new HashMap();
        r.setNombre(request.getParameter("nombre").trim().toUpperCase());
        r.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
        if (dao.existeRol(r.getNombre())) {
            hm.put("success", false);
            hm.put("msg", "El Rol Ya Existe en Otro Registro");
        } else {
            if (dao.insertarModulo(r)) {
                hm.put("success", true);
                hm.put("msg", "El Rol se Inserto correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo un Problema al Insertar al Rol");
            }
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void buscarRol(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        RolDao dao = new RolDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        Rol r = dao.buscarRol(Integer.parseInt(request.getParameter("id")));
        hm.put("rol", r);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void actualizarRol(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        RolDao dao = new RolDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        Rol rol = new Rol();
        rol.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
        rol.setIdRol(Integer.parseInt(request.getParameter("idRol")));
        rol.setNombre(request.getParameter("nombre").trim().toUpperCase());
        Rol r = dao.buscarRolPorNombre(rol.getNombre());
        if (r != null) {
            if (r.getIdRol() == rol.getIdRol()) {
                if (dao.actualizarRol(rol)) {
                    hm.put("success", true);
                    hm.put("msg", "La actualizaci&oacute;n del Rol se Realiz&oacute; Correctamente");
                } else {
                    hm.put("success", false);
                    hm.put("msg", "Hubo un Problema al actualizar el Rol");
                }
            } else {
                hm.put("success", false);
                hm.put("msg", "El M&oacute;dulo Ya se Encuentra en Otro Registro");
            }
        } else {
            if (dao.actualizarRol(rol)) {
                hm.put("success", true);
                hm.put("msg", "La actualizaci&oacute;n del Rol se Realiz&oacute; Correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo un Problema al actualizar el Rol");
            }
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void eliminarRol(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        RolDao dao = new RolDao();
        HashMap hm = new HashMap();
        Gson g = new Gson();
        if (!dao.hasChildrenRol(Integer.parseInt(request.getParameter("idRol")))) {
            if (dao.eliminarRol(Integer.parseInt(request.getParameter("idRol")))) {
                hm.put("success", true);
                hm.put("msg", "El Rol se Eliminó correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo Un Problema al Eliminar El Rol");
            }
        } else {
            hm.put("success", false);
            hm.put("msg", "El Rol Tiene SubM&oacute;dulos Asignados");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void listarRolesPorGrupo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        RolDao dao = new RolDao();
        Gson g = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        int idGrupo = Integer.parseInt(request.getParameter("idGrupo"));
        HashMap hm = new HashMap();
        hm.put("query", "%" + query + "%");
        hm.put("limit", limit);
        hm.put("idGrupo", idGrupo);
        hm.put("start", start);
        List<Rol> list = dao.listarRolesPorGrupo(hm);
        hm.put("roles", list);
        hm.put("total", dao.listarTotalRolesPorGrupo(hm));
        hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void listarRolesSinGrupo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        RolDao dao = new RolDao();
        Gson g = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        int idGrupo = Integer.parseInt(request.getParameter("idGrupo"));
        HashMap hm = new HashMap();
        hm.put("query", "%" + query + "%");
        hm.put("limit", limit);
        hm.put("idGrupo", idGrupo);
        hm.put("start", start);
        List<Rol> list = dao.listarRolesSinGrupo(hm);
        hm.put("perfiles", list);
        hm.put("total", dao.listarTotalRolesSinGrupo(hm));
        hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void insertarPerfil(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        RolDao dao = new RolDao();
        HashMap hm = new HashMap();
        Gson g = new Gson();
        hm.put("idGrupo", Integer.parseInt(request.getParameter("idGrupo")));
        hm.put("idRol", Integer.parseInt(request.getParameter("idRol")));
        if (dao.insertarPerfil(hm)) {
            hm = new HashMap();
            hm.put("success", true);
            hm.put("msg", "El Rol se Asign&oacute; correctamente");
        } else {
            hm = new HashMap();
            hm.put("success", false);
            hm.put("msg", "Hubo un Problema a la Hora de Asignar el Rol");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void eliminarPerfil(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        RolDao dao = new RolDao();
        HashMap hm = new HashMap();
        Gson g = new Gson();
        hm.put("idGrupo", Integer.parseInt(request.getParameter("idGrupo")));
        hm.put("idRol", Integer.parseInt(request.getParameter("idRol")));
        if (dao.eliminarPerfil(hm)) {
            hm = new HashMap();
            hm.put("success", true);
            hm.put("msg", "El Rol se Desasign&oacute correctamente");
        } else {
            hm = new HashMap();
            hm.put("success", false);
            hm.put("msg", "Hubo un Problema a la Hora de desasignar el Rol");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }
}
