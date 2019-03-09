/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import com.google.gson.Gson;
import gob.peam.administracion.beans.Grupo;
import gob.peam.administracion.beans.Persona;
import gob.peam.administracion.beans.Usuario;
import gob.peam.administracion.dao.PersonaDao;
import gob.peam.administracion.dao.SesionDao;
import gob.peam.administracion.dao.UsuarioDao;
import gob.peam.helpers.Encriptar;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jpgprog84
 */
@WebServlet(name = "Personal", urlPatterns = {"/Personal"})
public class PersonalServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 5697820263141544386L;

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
            SesionDao sesionDao = new SesionDao();
        if (!sesionDao.verificarSesion(request, response)) {
            response.sendRedirect("./Login");
        } else {
            String action = request.getParameter("action") == null ? "" : request.getParameter("action");
            switch (action) {
                /*  case "":
                 break;*/
                case "InsertarPersona":
                    try {
                        insertarPersona(request, response);
                    } catch (Exception ex) {
                        Logger.getLogger(PersonalServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "BuscarPersona":
                    buscarPersona(request, response);
                    break;
                case "ActualizarSoloPersona":
                    actualizarSoloPersona(request, response);
                    break;
                case "ActualizarPersona":
                    try {
                        actualizarPersona(request, response);
                    } catch (Exception ex) {
                        Logger.getLogger(PersonalServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "EliminarPersona":
                    eliminarPersona(request, response);
                    break;
                case "ListarPersonas":
                    listarPersonas(request, response);
                    break;
                case "ListarEmpleados":
                    listarEmpleados(request, response);
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

//    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        ModuloDao dao = new ModuloDao();
//        request.setAttribute("modulos", dao.listarModulosForMenus());
//        EntidadDao entidadDao = new EntidadDao();
//        request.setAttribute("entidad", entidadDao.seleccionarEntidad().getNombre());
//        request.getRequestDispatcher("./WEB-INF/Administracion/personal.jsp").forward(request, response);
//    }
    private void insertarPersona(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PersonaDao dao = new PersonaDao();
        Gson g = new Gson();
        Persona p = new Persona();
        p.setApellidoMaterno(request.getParameter("apellidoMaterno").toString().trim().toUpperCase());
        p.setApellidoPaterno(request.getParameter("apellidoPaterno").toString().trim().toUpperCase());
        p.setDni(request.getParameter("dni"));
        p.setCargo(request.getParameter("cargo"));
        p.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
        p.setNombre(request.getParameter("nombre").toString().trim().toUpperCase());
        String[] iniciales = request.getParameter("nombre").toString().trim().toUpperCase().split(" ");
        String concatenar = "";
        for (Integer i = 0; i < iniciales.length; i++) {
            concatenar += iniciales[i].substring(0, 1);
        }
        concatenar += request.getParameter("apellidoPaterno").toString().trim().toUpperCase().substring(0, 1);
        concatenar += request.getParameter("apellidoMaterno").toString().trim().toUpperCase().substring(0, 1);
        p.setIniciales(concatenar.toUpperCase().trim());
        Usuario u = null;
        if (Boolean.parseBoolean(request.getParameter("user")) == true) {
            u = new Usuario();
            u.setClave(Encriptar.md5(Encriptar.md5(Encriptar.md5(request.getParameter("pwd").toString()))));
            u.setEstado(Boolean.parseBoolean(request.getParameter("estadoUsuario")));
            u.setLogin(request.getParameter("login").toString().toUpperCase().trim());
            Grupo grupo = new Grupo();
            grupo.setIdGrupo(Integer.parseInt(request.getParameter("idGrupo")));
            u.setGrupo(grupo);
        }
        HashMap hm = dao.insertarPersona(p, u, Boolean.parseBoolean(request.getParameter("user")));
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void buscarPersona(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonaDao dao = new PersonaDao();
        UsuarioDao usuarioDao = new UsuarioDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        hm.put("persona", dao.buscarPersona(Integer.parseInt(request.getParameter("id"))));
        hm.put("usuario", usuarioDao.buscarUsuarioPorPersona(Integer.parseInt(request.getParameter("id"))));
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void actualizarSoloPersona(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonaDao dao = new PersonaDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        Persona p = new Persona();
        p.setApellidoMaterno(request.getParameter("apellidoMaterno").trim().toUpperCase());
        p.setApellidoPaterno(request.getParameter("apellidoPaterno").trim().toUpperCase());
        p.setDni(request.getParameter("dni"));
        p.setCargo(request.getParameter("cargo"));
        p.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
        p.setIdPersona(Integer.parseInt(request.getParameter("idPersona")));
        p.setNombre(request.getParameter("nombre").trim().toUpperCase());
        String[] iniciales = request.getParameter("nombre").toString().trim().toUpperCase().split(" ");
        String concatenar = "";
        for (Integer i = 0; i < iniciales.length; i++) {
            concatenar += iniciales[i].substring(0, 1);
        }
        concatenar += request.getParameter("apellidoPaterno").toString().trim().toUpperCase().substring(0, 1);
        concatenar += request.getParameter("apellidoMaterno").toString().trim().toUpperCase().substring(0, 1);
        p.setIniciales(concatenar.toUpperCase().trim());
        Persona temp = dao.buscarPersonaPorDni(request.getParameter("dni"));
        if (temp == null) {
            if (dao.actualizarPersona(p)) {
                hm.put("success", true);
                hm.put("msg", "La Persona Se Actualizó Correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo un Problema a la Hora de Actualizar La Persona");
            }
        } else {
            if (temp.getIdPersona() == p.getIdPersona()) {
                if (dao.actualizarPersona(p)) {
                    hm.put("success", true);
                    hm.put("msg", "La Persona Se Actualizó Correctamente");
                } else {
                    hm.put("success", false);
                    hm.put("msg", "Hubo un Problema a la Hora de Actualizar La Persona");
                }
            } else {
                hm.put("success", false);
                hm.put("msg", "La Persona Ya se Encuentra En otro Registro");
            }
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void actualizarPersona(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        PersonaDao dao = new PersonaDao();
        Gson g = new Gson();
        Persona p = new Persona();
        p.setIdPersona(Integer.parseInt(request.getParameter("idPersona")));
        p.setApellidoMaterno(request.getParameter("apellidoMaterno").toString().trim().toUpperCase());
        p.setApellidoPaterno(request.getParameter("apellidoPaterno").toString().trim().toUpperCase());
        p.setDni(request.getParameter("dni"));
        p.setEstado(true);
        p.setNombre(request.getParameter("nombre").toString().trim().toUpperCase());
        String[] iniciales = request.getParameter("nombre").toString().trim().toUpperCase().split(" ");
        String concatenar = "";
        for (Integer i = 0; i < iniciales.length; i++) {
            concatenar += iniciales[i].substring(0, 1);
        }
        concatenar += request.getParameter("apellidoPaterno").toString().trim().toUpperCase().substring(0, 1);
        concatenar += request.getParameter("apellidoMaterno").toString().trim().toUpperCase().substring(0, 1);
        p.setIniciales(concatenar.toUpperCase().trim());
        Usuario u = null;
        if (Boolean.parseBoolean(request.getParameter("user")) == true) {
            u = new Usuario();
            u.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
            u.setClave(Encriptar.md5(Encriptar.md5(Encriptar.md5(request.getParameter("pwd").toString()))));
            u.setEstado(true);
            u.setPersona(p);
            u.setLogin(request.getParameter("login").toString().toUpperCase().trim());
            Grupo grupo = new Grupo();
            grupo.setIdGrupo(Integer.parseInt(request.getParameter("idGrupo")));
            u.setGrupo(grupo);
        }
        HashMap hm = dao.actualizarComplexPersona(p, u, Boolean.parseBoolean(request.getParameter("user")));
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void eliminarPersona(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonaDao dao = new PersonaDao();
        HashMap hm = new HashMap();
        Gson g = new Gson();
        if (!dao.existePersonaParaEliminar(Integer.parseInt(request.getParameter("idPersona")))) {
            if (dao.eliminarPersona(Integer.parseInt(request.getParameter("idPersona")))) {
                hm.put("success", true);
                hm.put("msg", "La Persona se Eliminó correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo Un Problema al Eliminar La Persona");
            }
        } else {
            hm.put("success", false);
            hm.put("msg", "La Persona Tiene un Usuario Asignado, Primero elimine el Usuario");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void listarPersonas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonaDao dao = new PersonaDao();
        Gson g = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        HashMap hm = new HashMap();
        hm.put("query", "%" + query + "%");
        hm.put("limit", limit);
        hm.put("start", start);
        List<Persona> list = dao.listarPersonas(hm);
        hm.put("personas", list);
        hm.put("total", dao.listarTotalPersonas(hm));
        hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void listarEmpleados(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonaDao dao = new PersonaDao();
        Gson g = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        HashMap hm = new HashMap();
        hm.put("query", "%" + query + "%");
        hm.put("limit", limit);
        hm.put("start", start);
        List<Persona> list = dao.listarEmpleados(hm);
        hm.put("empleados", list);
        hm.put("total", dao.listarTotalEmpleados(hm));
        hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }
}
