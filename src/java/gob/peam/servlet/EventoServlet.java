package gob.peam.servlet;

import com.google.gson.Gson;
import gob.peam.administracion.dao.UsuarioDao;
import gob.peam.beans.Evento;
import gob.peam.dao.EventoDao;
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
@WebServlet(name = "EventoServlet", urlPatterns = {"/Evento"})
public class EventoServlet extends HttpServlet {

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

            case "InsertarEvento":
                insertarEvento(request, response);
                break;

            case "ActualizarEvento":
                actualizarEvento(request, response);
                break;

            case "EliminarEvento":
                eliminarEvento(request, response);
                break;

            case "PublicarEvento":
                publicarEvento(request, response);
                break;
            case "GetNotice":
                getNoticia(request, response);
                break;
            case "ListarEventoForAdmin":
                listarEventoForAdmin(request, response);
                break;
            case "EventoForWeb":
                eventoForWeb(request, response);
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

    private void insertarEvento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("application/json;charset=UTF-8");
            Gson g = new Gson();
            EventoDao dao = new EventoDao();
            Evento evento = new Evento();
            evento.setEstado(true);
            evento.setAnho(request.getParameter("fecha").toString().split("/")[2]);
            evento.setFecha(request.getParameter("fecha").split("/")[2] + "-" + request.getParameter("fecha").split("/")[1] + "-" + request.getParameter("fecha").split("/")[0]);
            evento.setFoto(request.getParameter("foto"));
            evento.setArea(Integer.parseInt(request.getParameter("area")));
            evento.setTitulo(request.getParameter("titulo"));
            evento.setFechaEditado(new Date(new java.util.Date().getTime()));
            evento.setFechaCreado(new Date(new java.util.Date().getTime()));
            evento.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
            evento.setCreadoPor(Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
            evento.setEditadoPor(Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
            evento.setLink(request.getParameter("link"));
            HashMap hm = new HashMap();
            if (dao.insertarEvento(evento)) {
                hm.put("success", true);
                hm.put("msg", "Evento se ingreso correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Evento no se ingreso correctamente, comuniquese con el administrador del sistema");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void actualizarEvento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("application/json;charset=UTF-8");
            Gson g = new Gson();
            HashMap hm = new HashMap();
            EventoDao dao = new EventoDao();
            Evento evento = new Evento();
            evento.setId(Integer.parseInt(request.getParameter("id").toString()));
            evento.setAnho(request.getParameter("fecha").toString().split("/")[2]);
            evento.setFecha(request.getParameter("fecha").split("/")[2] + "-" + request.getParameter("fecha").split("/")[1] + "-" + request.getParameter("fecha").split("/")[0]);
            evento.setFoto(request.getParameter("foto"));
            evento.setArea(Integer.parseInt(request.getParameter("area")));
            evento.setTitulo(request.getParameter("titulo"));
            evento.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
            evento.setFechaEditado(new Date(new java.util.Date().getTime()));
            evento.setEditadoPor(Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
            evento.setLink(request.getParameter("link"));
            if (dao.actualizarEvento(evento)) {
                hm.put("success", true);
                hm.put("msg", "Evento se actualiz&oacute; correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Evento no se actualiz&oacute; correctamente, comuniquese con el administrador del sistema");
            }
            response.getWriter().print(g.toJson(hm));
        }
    }

    private void eliminarEvento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            EventoDao eventoDao = new EventoDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (eventoDao.eliminarEvento(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "Evento se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar la nota de prensa");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void publicarEvento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            EventoDao eventoDao = new EventoDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (eventoDao.publicarEvento(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "Evento se publicó correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema en la publicación del evento");
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
            EventoDao dao = new EventoDao();
            Evento evento = dao.getEventoForAdmin(id);
            HashMap hm = new HashMap();
            Gson g = new Gson();
            hm.put("evento", evento);
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void listarEventoForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            EventoDao eventoDao = new EventoDao();
            String filtro = request.getParameter("filtro").toString();
            int limit = request.getParameter("limit") == null ? 6 : Integer.parseInt(request.getParameter("limit"));
            int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
            UsuarioDao usuarioDao = new UsuarioDao();
            try {
                HashMap hm = new HashMap();
                hm.put("filtro", "%" + filtro.toUpperCase() + "%");
                hm.put("limit", limit);
                hm.put("start", start);
                List<Evento> eventos = eventoDao.listEventoForAdmin(hm);
                Integer total = eventoDao.listTotalEventoForAdmin("%" + filtro.toUpperCase() + "%");
                out.print("<div id ='total' style='width: 100%;'>Total de Registros: " + total + " </div>");
                for (Evento evento : eventos) {
                    String result = "";
                    result += "<div data=" + total + " class='notice ui-widget ui-widget-content ui-corner-all'>";
                    result += "<div class='notice-head'>";
                    result += "<h2 alt='" + evento.getTitulo() + "' class='notice-htitulo'>" + evento.getTitulo().substring(0, evento.getTitulo().length() > 90 ? 90 : evento.getTitulo().length()) + "</h2>";
                    result += "<h2 class='notice-hfecha'>" + evento.getFecha() + "</h2>";
                    result += "</div>";
                    result += "<div class='notice-tools'  data='" + evento.getId() + "'>";
                    result += "<span class='notice-tsubido'><p>Subido Por: <b>" + usuarioDao.buscarUsuarioPorId(evento.getEditadoPor()).getLogin() + "</b></p></span>";
                    result += "<span class='notice-tbutton' id='" + evento.getId() + "' style='display:none;'>";
                    result += "<a role='a' dir='imprimir' class='ver'>Visualizar</a>";
                    result += "<a role='a' dir='editar' class='editar'>Editar</a>";
                    result += "<a role='a' dir='eliminar' class='eliminar'>Eliminar</a>";
                    if (evento.isEstado()) {
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
    private void eventoForWeb(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        EventoDao dao = new EventoDao();
        Gson gson = new Gson();
        try {
            HashMap hm = new HashMap();
            java.sql.Date d = new java.sql.Date(new java.util.Date().getTime());
            hm.put("anho", String.valueOf(d.getYear() + 1900));
            hm.put("area", Integer.parseInt(request.getParameter("area")));
            hm.put("order", "desc");
            hm.put("limit", 10);
            List<Evento> list = dao.eventoForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            out.print(gson.toJson(outHash));
        } finally {
            out.close();
        }
    }

}
