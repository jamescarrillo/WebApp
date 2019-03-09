/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import com.google.gson.Gson;
import gob.peam.administracion.beans.Cargo;
import gob.peam.administracion.beans.Dependencia;
import gob.peam.administracion.beans.Persona;
import gob.peam.administracion.dao.DependenciaDao;
import gob.peam.administracion.dao.PersonaDao;
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
@WebServlet(name = "DependenciaServlet", urlPatterns = {"/Dependencia"})
public class DependenciaServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -5232003163006571262L;

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
           SesionDao sesionDao = new SesionDao();
        if (!sesionDao.verificarSesion(request, response)) {
            response.sendRedirect("./Login");
        } else {
            String action = request.getParameter("action") == null ? "" : request.getParameter("action");
            switch (action) {
                /* case "":
                 index(request, response);
                 break;*/
                case "ListarDependencias":
                    listarDependencias(request, response);
                    break;
                case "ListarDependenciasForCombo":
                    listarDependenciasforCombo(request, response);
                    break;
                case "InsertarDependencia":
                    insertarDependencia(request, response);
                    break;
                case "BuscarRepresentante":
                    buscarRepresentante(request, response);
                    break;
                case "BuscarDependencia":
                    buscarDependencia(request, response);
                    break;
                case "ActualizarDependencia":
                    actualizarDependencia(request, response);
                    break;
                case "EliminarDependencia":
                    eliminarDependencia(request, response);
                    break;
                case "ListarTrabajadoresPorDependencia":
                    listarTrabajadoresPorDependencia(request, response);
                    break;
               
                case "ActualizarRepresentante":
                    actualizarRepresentante(request, response);
                    break;
         
                case "InsertarTrabajadorEnDependencia":
                    insertarTrabajadorEnDependencia(request, response);
                    break;
                case "EliminarTrabajadorEnDependencia":
                    eliminarTrabajadorEnDependencia(request,response);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void listarDependencias(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=UTF-8");
        DependenciaDao dependenciaDao = new DependenciaDao();
        Integer nivel = Integer.parseInt(request.getParameter("level").toString());
        Integer padre = Integer.parseInt(request.getParameter("padre").toString());
        Gson gson = new Gson();
        HashMap hashMap = new HashMap();
        hashMap.put("nivel", nivel);
        hashMap.put("padre", padre);
        HashMap hm = new HashMap();
        hm.put("dependencias", dependenciaDao.listarDependencias(hashMap));
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void listarDependenciasforCombo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        DependenciaDao dependenciaDao = new DependenciaDao();
        List<Dependencia> dependencias = dependenciaDao.listarDependenciasForCombo();
        String resultado = "<option parent='0' level='-1' value='0'>NINGUNO</option>";
        for (Dependencia dependencia : dependencias) {
            resultado += "<option parent='" + dependencia.getIdDependencia() + "' level='" + dependencia.getNivel() + "' value='" + dependencia.getIdDependencia() + "'>" + dependencia.getNombre() + "</option>";
        }
        response.getWriter().print(resultado);
    }

    private void insertarDependencia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        DependenciaDao dao = new DependenciaDao();
        Gson gson = new Gson();
        HashMap hm = new HashMap();
        Dependencia d = new Dependencia();
        d.setAbreviatura(request.getParameter("abreviatura").toUpperCase());
        d.setEstado(true);
        d.setNivel(Integer.parseInt(request.getParameter("nivel")));
        d.setNombre(request.getParameter("nombre").toUpperCase());
        d.setPadre(Integer.parseInt(request.getParameter("padre")));
        if (dao.insertarDependencia(d)) {
            hm.put("success", true);
            hm.put("msg", "Se ingreso correctamente la dependencia");
        } else {
            hm.put("success", false);
            hm.put("msg", "Hubo un Problema al ingresar la dependencia, consulte con su administrador");
        }
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void buscarRepresentante(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        DependenciaDao dao = new DependenciaDao();
        Persona persona = dao.seleccionarRepresentante(Integer.parseInt(request.getParameter("depe_id")));
        Gson g = new Gson();
        HashMap hm = new HashMap();
        hm.put("representante", persona);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void buscarDependencia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        DependenciaDao dao = new DependenciaDao();
        Dependencia d = dao.buscarDependencia(Integer.parseInt(request.getParameter("depe_id")));
        Gson g = new Gson();
        HashMap hm = new HashMap();
        hm.put("dependencia", d);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void actualizarDependencia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        DependenciaDao dao = new DependenciaDao();
        Gson gson = new Gson();
        HashMap hm = new HashMap();
        Dependencia d = new Dependencia();
        d.setAbreviatura(request.getParameter("abreviatura").toUpperCase());
        d.setIdDependencia(Integer.parseInt(request.getParameter("id")));
        d.setNivel(Integer.parseInt(request.getParameter("nivel")));
        d.setNombre(request.getParameter("nombre").toUpperCase());
        d.setPadre(Integer.parseInt(request.getParameter("padre")));
        if (dao.actualizarDependencia(d)) {
            hm.put("success", true);
            hm.put("msg", "Se actualizo correctamente la dependencia");
        } else {
            hm.put("success", false);
            hm.put("msg", "Hubo un Problema al actualizar la dependencia, consulte con su administrador");
        }
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void eliminarDependencia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        DependenciaDao dao = new DependenciaDao();
        Gson gson = new Gson();
        HashMap hm = new HashMap();
        Integer id = Integer.parseInt(request.getParameter("depe_id"));
        if (dao.totalSubDependencias(id) > 0) {
            hm.put("success", false);
            hm.put("msg", "No se puede eliminar la dependencia por que tiene areas dependientes, primero elimine las dependencias hijas");
        } else {
            if (dao.eliminarDependencia(id)) {
                hm.put("success", true);
                hm.put("msg", "Se elimino correctamente la dependencia");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo un Problema al actualizar la dependencia, consulte con su administrador");
            }
        }
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void listarTrabajadoresPorDependencia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonaDao dao = new PersonaDao();
        Gson g = new Gson();
        Integer depe_id = Integer.parseInt(request.getParameter("depe_id"));
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        HashMap hm = new HashMap();
        hm.put("query", "%" + query + "%");
        hm.put("depe_id", depe_id);
        hm.put("limit", limit);
        hm.put("start", start);
        List<Persona> personas = dao.listarPersonasForDependencia(hm);
        Integer total = dao.listarTotalPersonaForDependencia(hm);
        hm = new HashMap();
        hm.put("items", personas);
        hm.put("total", total);
        hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void actualizarRepresentante(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        DependenciaDao dao = new DependenciaDao();
        Gson gson = new Gson();
        HashMap hm = new HashMap();
        Cargo cargo = new Cargo();
        Dependencia d = new Dependencia();
        d.setIdDependencia(Integer.parseInt(request.getParameter("depe_id").toString()));
        cargo.setEstado(true);
        cargo.setDependencia(d);
        Persona p = new Persona();
        p.setIdPersona(Integer.parseInt(request.getParameter("carg_responsable").toString()));
        cargo.setResponsable(p);

        if (dao.actualizarCargo(cargo)) {
            hm.put("success", true);
            hm.put("msg", "Se actualizo correctamente el cargo");
        } else {
            hm.put("success", false);
            hm.put("msg", "Hubo un Problema al actualizar el cargo, consulte con su administrador");
        }
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

   
    private void insertarTrabajadorEnDependencia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        DependenciaDao dao = new DependenciaDao();
        Gson gson = new Gson();
        HashMap hm = new HashMap();
        hm.put("idDependencia", Integer.parseInt(request.getParameter("dependencia")));
        hm.put("idPersona", Integer.parseInt(request.getParameter("persona")));
        if (dao.insertarTrabajadorEnDependencia(hm)) {
            hm = new HashMap();
            hm.put("success", true);
            hm.put("msg", "Se Agrego el Trabajador a la Dependencia");
        } else {
            hm = new HashMap();
            hm.put("success", false);
            hm.put("msg", "Hubo un Problema al agregar al Trabajador a la Dependencia, consulte con su administrador");
        }
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void eliminarTrabajadorEnDependencia(HttpServletRequest request, HttpServletResponse response) throws IOException {
       response.setContentType("text/html;charset=UTF-8");
        DependenciaDao dao = new DependenciaDao();
        Gson gson = new Gson();
        HashMap hm = new HashMap();
        hm.put("idDependencia", Integer.parseInt(request.getParameter("dependencia")));
        hm.put("idPersona", Integer.parseInt(request.getParameter("persona")));
        if (dao.eliminarTrabajadorEnDependencia(hm)) {
            hm = new HashMap();
            hm.put("success", true);
            hm.put("msg", "Se Elimin&oacute; el Trabajador de la Dependencia");
        } else {
            hm = new HashMap();
            hm.put("success", false);
            hm.put("msg", "Hubo un Problema al Eliminar al Trabajador de la Dependencia, consulte con su administrador");
        }
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }
}
