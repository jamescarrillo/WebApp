/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import com.google.gson.Gson;
import gob.peam.administracion.beans.Grupo;
import gob.peam.administracion.dao.GrupoDao;
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
@WebServlet(name = "Grupo", urlPatterns = {"/Grupo"})
public class GrupoServlet extends HttpServlet {

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
                case "ListarGrupoForCombo":
                    listarGrupoForCombo(request, response);
                    break;
                case "ListarGrupos":
                    listarGrupos(request, response);
                    break;
                case "InsertarGrupo":
                    insertarGrupo(request, response);
                    break;
                case "ActualizarGrupo":
                    actualizarGrupo(request, response);
                    break;
                case "EliminarGrupo":
                    eliminarGrupo(request, response);
                    break;
                case "BuscarGrupo":
                    buscarGrupo(request, response);
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

    private void listarGrupoForCombo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        GrupoDao dao = new GrupoDao();
        String result = "<option value='0'>SELECCIONAR GRUPO</option>";
        for (Grupo grupo : dao.listarGrupos()) {
            result += "<option value='" + grupo.getIdGrupo() + "'>" + grupo.getNombre() + "</option>";
        }
        response.getWriter().print(result);
    }

    private void insertarGrupo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        HashMap hm = new HashMap();
        Gson g = new Gson();
        GrupoDao dao = new GrupoDao();
        Grupo grupo = new Grupo();
        grupo.setNombre(request.getParameter("nombre").toUpperCase().trim());
        grupo.setEstado(true);
        if (dao.existeGrupo(grupo.getNombre())) {
            hm.put("success", false);
            hm.put("msg", "Ya Existe el Grupo");
        } else {
            if (dao.insertarGrupo(grupo) != null) {
                hm.put("success", true);
                hm.put("id", grupo.getIdGrupo());
                hm.put("msg", "Se Ingreso Correctamente el Grupo");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo un Problema al Insertar el Grupo");
            }
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void actualizarGrupo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        HashMap hm = new HashMap();
        Gson g = new Gson();
        GrupoDao dao = new GrupoDao();
        Grupo grupo = new Grupo();
        grupo.setIdGrupo(Integer.parseInt(request.getParameter("idGrupo")));
        grupo.setNombre(request.getParameter("nombre").trim().toUpperCase());
        grupo.setEstado(true);
        Grupo temp = dao.buscarGrupo(grupo.getNombre());
        if (temp == null) {
            //no existe actualizamos
            if (dao.actualizarGrupo(grupo)) {
                hm.put("success", true);
                hm.put("msg", "El Grupo se Actualizó Correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo Problemas a la hora de Actualizar el Grupo");
            }
        } else {
            if (temp.getIdGrupo() == grupo.getIdGrupo()) {
                if (dao.actualizarGrupo(grupo)) {
                    hm.put("success", true);
                    hm.put("msg", "El Grupo se Actualizó Correctamente");
                } else {
                    hm.put("success", false);
                    hm.put("msg", "Hubo Problemas a la hora de Actualizar el Grupo");
                }
            } else {
                hm.put("success", false);
                hm.put("msg", "El Nombre del Grupo Ya Se Encuentra En Otro Registro");
            }
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void eliminarGrupo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        HashMap hm = new HashMap();
        Gson g = new Gson();
        GrupoDao dao = new GrupoDao();
        if (dao.tieneDependencias(Integer.parseInt(request.getParameter("id")))) {
            hm.put("success", false);
            hm.put("msg", "No se Puede Eliminar por que Otros Dependen de El");
        } else {
            if (dao.eliminarGrupo(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", true);
                hm.put("msg", "Se Eliminó Correctamente el Grupo");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo Problemas a la hora de Eliminar el Grupo");
            }
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void listarGrupos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        GrupoDao dao = new GrupoDao();
        Gson g = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        HashMap hm = new HashMap();
        hm.put("query", "%" + query + "%");
        hm.put("limit", limit);
        hm.put("start", start);
        List<Grupo> list = dao.listarGrupos(hm);
        hm.put("grupos", list);
        hm.put("total", dao.listarTotalGrupos(hm));
        hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void buscarGrupo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        GrupoDao dao = new GrupoDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        Grupo grupo = dao.buscarGrupoPorId(Integer.parseInt(request.getParameter("id")));
        hm.put("grupo", grupo);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }
}
