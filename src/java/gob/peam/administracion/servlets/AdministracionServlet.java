/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import gob.peam.administracion.dao.EtiquetaDao;
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
@WebServlet(name = "Administracion", urlPatterns = {"/Administracion"})
public class AdministracionServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 7218930533554580879L;

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
                case "":
                    index(request, response);
                    break;
                case "Entidad":
                    entidad(request, response);
                    break;
                case "Dependencia":
                    dependencia(request, response);
                    break;
                case "Personal":
                    personal(request, response);
                    break;
                case "Modulo":
                    modulo(request, response);
                    break;
                case "Grupos":
                    grupos(request, response);
                    break;
                case "Roles":
                    roles(request, response);
                    break;
                case "Periodo":
                    periodo(request, response);
                    break;
                case "Prefijo":
                    prefijo(request, response);
                    break;
                case "ParametrosDocumento":
                    parametrosDocumento(request, response);
                    break;
                case "Correlativo":
                    correlativo(request, response);
                    break;
                case "Sesiones":
                    sesiones(request, response);
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed"
    // desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a class='active'>Administraci&oacute;n</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        EtiquetaDao dao = new EtiquetaDao();
        request.setAttribute("gadgets", dao.listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/index.jsp").forward(request, response);
    }

    private void entidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./Administracion'>Administraci&oacute;n</a>|<a class='active'>Entidad</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        EtiquetaDao dao = new EtiquetaDao();
        request.setAttribute("gadgets", dao.listarMenusPorUsuarioyModulo(hm));
        //request.setAttribute("opcion", "ul1-ent");
        request.setAttribute("uri", request.getQueryString());
        request.getRequestDispatcher("./WEB-INF/Administracion/entidad.jsp").forward(request, response);
    }

    private void dependencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./Administracion'>Administraci&oacute;n</a>|<a class='active'>Dependencia</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        EtiquetaDao dao = new EtiquetaDao();
        request.setAttribute("gadgets", dao.listarMenusPorUsuarioyModulo(hm));
//        EntidadDao entidadDao = new EntidadDao();
//        request.setAttribute("entidad", entidadDao.seleccionarEntidad().getNombre());
        request.setAttribute("uri", request.getQueryString());
        request.getRequestDispatcher("./WEB-INF/Administracion/dependencia.jsp").forward(request, response);
    }

    private void personal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./Administracion'>Administraci&oacute;n</a>|<a class='active'>Personal</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        EtiquetaDao dao = new EtiquetaDao();
        request.setAttribute("gadgets", dao.listarMenusPorUsuarioyModulo(hm));
        request.setAttribute("uri", request.getQueryString());
        request.getRequestDispatcher("./WEB-INF/Administracion/personal.jsp").forward(request, response);
    }

    private void modulo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./Administracion'>Administraci&oacute;n</a>|<a class='active'>M&oacute;dulo</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        EtiquetaDao dao = new EtiquetaDao();
        request.setAttribute("gadgets", dao.listarMenusPorUsuarioyModulo(hm));
//        EntidadDao entidadDao = new EntidadDao();
//        request.setAttribute("entidad", entidadDao.seleccionarEntidad().getNombre());
        request.setAttribute("uri", request.getQueryString());
        request.getRequestDispatcher("./WEB-INF/Administracion/modulo.jsp").forward(request, response);
    }

    private void grupos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./Administracion'>Administraci&oacute;n</a>|<a class='active'>Grupos</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        EtiquetaDao dao = new EtiquetaDao();
        request.setAttribute("gadgets", dao.listarMenusPorUsuarioyModulo(hm));
//        EntidadDao entidadDao = new EntidadDao();
//        request.setAttribute("entidad", entidadDao.seleccionarEntidad().getNombre());
        request.setAttribute("uri", request.getQueryString());
        request.getRequestDispatcher("./WEB-INF/Administracion/grupos.jsp").forward(request, response);
    }

    private void roles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./Administracion'>Administraci&oacute;n</a>|<a class='active'>Roles</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        EtiquetaDao dao = new EtiquetaDao();
        request.setAttribute("gadgets", dao.listarMenusPorUsuarioyModulo(hm));
        //EntidadDao entidadDao = new EntidadDao();
        //request.setAttribute("entidad", entidadDao.seleccionarEntidad().getNombre());
        request.setAttribute("uri", request.getQueryString());
        request.getRequestDispatcher("./WEB-INF/Administracion/roles.jsp").forward(request, response);
    }

    private void periodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./Administracion'>Administraci&oacute;n</a>|<a class='active'>Periodo</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        EtiquetaDao dao = new EtiquetaDao();
        request.setAttribute("gadgets", dao.listarMenusPorUsuarioyModulo(hm));
        request.setAttribute("uri", request.getQueryString());
        request.getRequestDispatcher("./WEB-INF/Administracion/periodo.jsp").forward(request, response);
    }

    private void prefijo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./Administracion'>Administraci&oacute;n</a>|<a class='active'>Roles</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        EtiquetaDao dao = new EtiquetaDao();
        request.setAttribute("gadgets", dao.listarMenusPorUsuarioyModulo(hm));
        //EntidadDao entidadDao = new EntidadDao();
        //request.setAttribute("entidad", entidadDao.seleccionarEntidad().getNombre());
        request.setAttribute("uri", request.getQueryString());
        request.getRequestDispatcher("./WEB-INF/Administracion/prefijo.jsp").forward(request, response);
    }

    private void parametrosDocumento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./Administracion'>Administraci&oacute;n</a>|<a class='active'>Par&aacute;metros de Documento</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        EtiquetaDao dao = new EtiquetaDao();
        request.setAttribute("gadgets", dao.listarMenusPorUsuarioyModulo(hm));
        request.setAttribute("uri", request.getQueryString());
        request.getRequestDispatcher("./WEB-INF/Administracion/parametrosDocumento.jsp").forward(request, response);
    }

    private void correlativo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./Administracion'>Administraci&oacute;n</a>|<a class='active'>Correlativo</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        EtiquetaDao dao = new EtiquetaDao();
        request.setAttribute("gadgets", dao.listarMenusPorUsuarioyModulo(hm));
        request.setAttribute("uri", request.getQueryString());
        request.getRequestDispatcher("./WEB-INF/Administracion/correlativo.jsp").forward(request, response);
    }

    private void sesiones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./Administracion'>Administraci&oacute;n</a>|<a class='active'>Sesiones</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        EtiquetaDao dao = new EtiquetaDao();
        request.setAttribute("gadgets", dao.listarMenusPorUsuarioyModulo(hm));
        request.setAttribute("uri", request.getQueryString());
        request.getRequestDispatcher("./WEB-INF/Administracion/sesiones.jsp").forward(request, response);
    }
}
