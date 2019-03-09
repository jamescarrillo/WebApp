/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import com.google.gson.Gson;
import gob.peam.administracion.beans.Sesion;
import gob.peam.administracion.beans.Usuario;
import gob.peam.administracion.dao.EntidadDao;
import gob.peam.administracion.dao.PeriodoDao;
import gob.peam.administracion.dao.SesionDao;
import gob.peam.administracion.dao.UsuarioDao;
import gob.peam.helpers.Encriptar;
import gob.peam.security.WebAppBindingListener;
import java.io.IOException;
import java.util.HashMap;
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
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/Usuario"})
public class UsuarioServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1816755134720281712L;

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
        if (request.getParameter("action") == null) {
            index(request, response);
        } else {
            switch (request.getParameter("action")) {
                case "connect":
                    login(request, response);
                    break;
                case "disconnect":
                    logout(request, response);
                    break;
                case "DesactivarUsuario":
                    desactivarUsuario(request, response);
                    break;
                case "ActivarUsuario":
                    activarUsuario(request, response);
                    break;
                case "EliminarUsuario":
                    eliminarUsuario(request, response);
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

    //@SuppressWarnings({"unchecked", "rawtypes"})
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
         response.setContentType("text/html;charset=UTF-8");

        String login = request.getParameter("login") == null ? "" : request.getParameter("login").toUpperCase().trim();
        String password = request.getParameter("password") == null ? "" : request.getParameter("password");
        String captcha = request.getParameter("captcha") == null ? "" : request.getParameter("captcha");
        UsuarioDao usuarioDao = new UsuarioDao();
        Gson gson = new Gson();
        HashMap hm = new HashMap();

        Usuario usuario = usuarioDao.buscarUsuarioPorLogin(login);
        if (usuario == null) {
            hm.put("success", false);
            hm.put("msg", "No Existe el Usuario");
        } else {
            try {
                
                if (usuario.getClave().equals(Encriptar.md5(Encriptar.md5(Encriptar.md5(password.trim()))))) {
                    
                    if (request.getSession().getAttribute("captcha").equals(captcha)) {
                        
                        request.getSession().setAttribute("iddependencia", usuario.getPersona().getDependencia().getIdDependencia());
                        
                        request.getSession().setAttribute("ip", request.getRemoteAddr());
                        request.getSession().setAttribute("idUsuario", usuario.getIdUsuario());
                        request.getSession().setAttribute("Binding", new WebAppBindingListener());
                         
                        request.getSession().setAttribute("user", usuario.getLogin());
                        request.getSession().setAttribute("nombre", usuario.getPersona().toString());
                        request.getSession().setAttribute("nombreUsuario", usuario.getPersona().getNombre());
                        request.getSession().setAttribute("apellidoPaterno", usuario.getPersona().getApellidoPaterno());
                        request.getSession().setAttribute("apellidoMaterno", usuario.getPersona().getApellidoMaterno());
                        request.getSession().setAttribute("usuaId", usuario.getIdUsuario());
                        request.getSession().setAttribute("loginusuario", usuario.getLogin());
                        request.getSession().setAttribute("dniusuario", usuario.getPersona().getDni());
                        
                        EntidadDao entidadDao = new EntidadDao();
                        request.getSession().setAttribute("idEntidad", entidadDao.seleccionarEntidad().getIdEntidad());
                        
                        PeriodoDao periodoDao = new PeriodoDao();
                        request.getSession().setAttribute("anio", periodoDao.buscarPeriodoActivo().getAnio());
                        SesionDao sesionDao = new SesionDao();
                        Sesion s = sesionDao.buscarSesion(request.getSession().getId());
                        request.getSession().setAttribute("sesiKey", s.getSesiKey());
                        
                        if (s == null) {
                            hm.put("success", true);
                            hm.put("msg", "./Intranet");
                        } else if (s.isSesiEstado()) {
                            hm.put("success", true);
                            hm.put("msg", "./Intranet");
                        } else {
                            hm.put("success", true);
                            hm.put("msg", "./Intranet");
                        }
                    } else {
                        hm.put("success", false);
                        hm.put("msg", "Ingrese Correctamente el Captcha");
                    }
                } else {
                    hm.put("success", false);
                    hm.put("msg", "Su contraseña es incorrecto");
                }
            } catch (Exception ex) {
                Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("Binding");
        response.sendRedirect("./Intranet");
    }

    private void desactivarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SesionDao sesionDao = new SesionDao();
        if (!sesionDao.verificarSesion(request, response)) {
            response.sendRedirect("./Intranet");
        } else {
            UsuarioDao dao = new UsuarioDao();
            HashMap hm = new HashMap();
            Gson g = new Gson();
            if (dao.desactivarUsuario(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", true);
                hm.put("msg", "El Usuario se Desactivo Correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo un Problema al Desactivar El Usuario");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void activarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SesionDao sesionDao = new SesionDao();
        if (!sesionDao.verificarSesion(request, response)) {
            response.sendRedirect("./Intranet");
        } else {
            UsuarioDao dao = new UsuarioDao();
            HashMap hm = new HashMap();
            Gson g = new Gson();
            if (dao.activarUsuario(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", true);
                hm.put("msg", "El Usuario se activo Correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo un Problema al activar El Usuario");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SesionDao sesionDao = new SesionDao();
        if (!sesionDao.verificarSesion(request, response)) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            UsuarioDao dao = new UsuarioDao();

            HashMap hm = new HashMap();
            Gson g = new Gson();
            if (!dao.existeUsuarioParaEliminar(Integer.parseInt(request.getParameter("usua_id")))) {
                if (dao.eliminarUsuario(Integer.parseInt(request.getParameter("usua_id")))) {
                    hm.put("success", true);
                    hm.put("msg", "El Usuario se Eliminó correctamente");
                } else {
                    hm.put("success", false);
                    hm.put("msg", "Hubo Un Problema al Eliminar El Usuario");
                }
            } else {
                hm.put("success", false);
                hm.put("msg", "El Usuario Esta Asignado a una Dependencia, Primero Desasigne el Usuario de la Dependencia");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void index(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
