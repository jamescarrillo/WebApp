package gob.peam.servlet;

import com.google.gson.Gson;
import gob.peam.administracion.dao.UsuarioDao;
import gob.peam.beans.Destacado;
import gob.peam.dao.DestacadoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mvilchez
 */
@WebServlet(name = "DestacadoServlet", urlPatterns = {"/Destacado"})
public class DestacadoServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -4634880771247916346L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String respuesta = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (respuesta) {

            case "InsertarDestacado":
                insertarDestacado(request, response);
                break;

            case "ActualizarDestacado":
                actualizarDestacado(request, response);
                break;

            case "EliminarDestacado":
                eliminarDestacado(request, response);
                break;

            case "PublicarDestacado":
                publicarDestacado(request, response);
                break;
            case "GetNotice":
                getNoticia(request, response);
                break;
            case "ListarDestacadoForAdmin":
                listarDestacadoForAdmin(request, response);
                break;
            case "DestacadoForWeb":
                destacadoForWeb(request, response);
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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

    private void insertarDestacado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("application/json;charset=UTF-8");
            Gson g = new Gson();
            DestacadoDao dao = new DestacadoDao();
            Destacado destacado = new Destacado();
            destacado.setEstado(true);
            destacado.setContenido(request.getParameter("contenido"));
            destacado.setAnho(request.getParameter("fecha").toString().split("/")[2]);
            destacado.setFecha(request.getParameter("fecha").split("/")[2] + "-" + request.getParameter("fecha").split("/")[1] + "-" + request.getParameter("fecha").split("/")[0]);
            destacado.setUrl(request.getParameter("url"));
            destacado.setFoto(request.getParameter("foto"));
            destacado.setTitulo(request.getParameter("titulo"));
            destacado.setFechaEditado(new Date(new java.util.Date().getTime()));
            destacado.setFechaCreado(new Date(new java.util.Date().getTime()));
            destacado.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
            destacado.setCreadoPor(Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
            destacado.setEditadoPor(Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
            HashMap hm = new HashMap();
            if (dao.insertarDestacado(destacado)) {
                hm.put("success", true);
                hm.put("msg", "Destacado se ingreso correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Destacado no se ingreso correctamente, comuniquese con el administrador del sistema");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void actualizarDestacado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("application/json;charset=UTF-8");
            Gson g = new Gson();
            HashMap hm = new HashMap();
            DestacadoDao dao = new DestacadoDao();
            Destacado destacado = new Destacado();
            destacado.setId(Integer.parseInt(request.getParameter("id").toString()));
            destacado.setContenido(request.getParameter("contenido"));
            destacado.setAnho(request.getParameter("fecha").toString().split("/")[2]);
            destacado.setFecha(request.getParameter("fecha").split("/")[2] + "-" + request.getParameter("fecha").split("/")[1] + "-" + request.getParameter("fecha").split("/")[0]);
            destacado.setUrl(request.getParameter("url"));
            destacado.setFoto(request.getParameter("foto"));
            destacado.setTitulo(request.getParameter("titulo"));
            destacado.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
            destacado.setFechaEditado(new Date(new java.util.Date().getTime()));
            destacado.setEditadoPor(Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
            if (dao.actualizarDestacado(destacado)) {
                hm.put("success", true);
                hm.put("msg", "Destacado se actualiz&oacute; correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Destacado no se actualiz&oacute; correctamente, comuniquese con el administrador del sistema");
            }
            response.getWriter().print(g.toJson(hm));
        }
    }

    private void eliminarDestacado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            DestacadoDao destacadoDao = new DestacadoDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (destacadoDao.eliminarDestacado(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "Destacado se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar la nota de prensa");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void publicarDestacado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            DestacadoDao destacadoDao = new DestacadoDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (destacadoDao.publicarDestacado(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "Destacado se publicó correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema en la publicación del destacado");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void getNoticia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            Integer id = Integer.parseInt(request.getParameter("id").toString());
            DestacadoDao dao = new DestacadoDao();
            Destacado destacado = dao.getDestacadoForAdmin(id);
            HashMap hm = new HashMap();
            Gson g = new Gson();
            hm.put("destacado", destacado);
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void listarDestacadoForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            DestacadoDao destacadoDao = new DestacadoDao();
            String filtro = request.getParameter("filtro").toString();
            int limit = request.getParameter("limit") == null ? 6 : Integer.parseInt(request.getParameter("limit"));
            int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
            UsuarioDao usuarioDao = new UsuarioDao();
            try {
                HashMap hm = new HashMap();
                hm.put("filtro", "%" + filtro.toUpperCase() + "%");
                hm.put("limit", limit);
                hm.put("start", start);
                List<Destacado> destacados = destacadoDao.listDestacadoForAdmin(hm);
                Integer total = destacadoDao.listTotalDestacadoForAdmin("%" + filtro.toUpperCase() + "%");
                String dest = null;
                out.print("<div id ='total' style='width: 100%;'>Total de Registros: " + total + " </div>");
                for (Destacado destacado : destacados) {
                    String result = "";
                    dest = destacado.getContenido().replaceAll("\\<.*?>", "");
                    result += "<div data=" + total + " class='notice ui-widget ui-widget-content ui-corner-all'>";
                    result += "<div class='notice-head'>";
                    result += "<h2 alt='" + destacado.getTitulo() + "' class='notice-htitulo'>" + destacado.getTitulo().substring(0, destacado.getTitulo().length() > 90 ? 90 : destacado.getTitulo().length()) + "</h2>";
                    result += "<h2 class='notice-hfecha'>" + destacado.getFecha() + "</h2>";
                    result += "</div>";
                    result += "<div class='notice-description'>";
                    result += "<p>" + dest.substring(0, dest.length() > 150 ? 150 : dest.length()) + " ...</p>";
                    result += "</div>";
                    result += "<div class='notice-tools'  data='" + destacado.getId() + "'>";
                    result += "<span class='notice-tsubido'><p>Subido Por: <b>" + usuarioDao.buscarUsuarioPorId(destacado.getEditadoPor()).getLogin() + "</b></p></span>";
                    result += "<span class='notice-tbutton' id='" + destacado.getId() + "' style='display:none;'>";
                    result += "<a role='a' dir='imprimir' class='ver'>Visualizar</a>";
                    result += "<a role='a' dir='editar' class='editar'>Editar</a>";
                    result += "<a role='a' dir='eliminar' class='eliminar'>Eliminar</a>";
                    if (destacado.isEstado()) {
                        result += "<!--<a role='a' dir='publicar' class='anular'>Ocultar</a>-->";
                    } else {
                        result += "<a role='a' dir='publicar' class='publicar'>Publicar</a>";
                    }
                    result += "</span>";
                    result += "</div>";
                    result += "</div>";
                    out.print(result);
                }
            } catch (Exception e) {
                out.print(e);
            } finally {
                out.close();
            }
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void destacadoForWeb(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DestacadoDao dao = new DestacadoDao();
        Gson gson = new Gson();
        try {
            HashMap hm = new HashMap();
            java.sql.Date d = new java.sql.Date(new java.util.Date().getTime());
            hm.put("anho", String.valueOf(d.getYear() + 1900));
            hm.put("order", "desc");
            hm.put("limit", 5);
            List<Destacado> list = dao.destacadoForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            out.print(gson.toJson(outHash));
        } finally {
            out.close();
        }
    }

}
