package gob.peam.servlet;

import com.google.gson.Gson;
import gob.peam.administracion.dao.UsuarioDao;
import gob.peam.beans.Estudio;
import gob.peam.dao.EstudioDao;
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
@WebServlet(name = "EstudioServlet", urlPatterns = {"/Estudio"})
public class EstudioServlet extends HttpServlet {

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
            case "InsertarEstudio":
                insertarEstudio(request, response);
                break;
            case "ActualizarEstudio":
                actualizarEstudio(request, response);
                break;
            case "EliminarEstudio":
                eliminarEstudio(request, response);
                break;
            case "PublicarEstudio":
                publicarEstudio(request, response);
                break;
            case "GetNotice":
                getNoticia(request, response);
                break;
            case "GetNoticeAlways":
                getNoticiaAlways(request, response);
                break;
            case "ListarEstudioForAdmin":
                listarEstudioForAdmin(request, response);
                break;
            case "EstudioForWeb":
                estudioForWeb(request, response);
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

    private void insertarEstudio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("application/json;charset=UTF-8");
            Gson g = new Gson();
            EstudioDao dao = new EstudioDao();
            Estudio estudio = new Estudio();
            estudio.setEstado(true);
            estudio.setAnho(request.getParameter("fecha").toString().split("/")[2]);
            estudio.setFecha(request.getParameter("fecha").split("/")[2] + "-" + request.getParameter("fecha").split("/")[1] + "-" + request.getParameter("fecha").split("/")[0]);
            estudio.setFoto(request.getParameter("foto"));
            estudio.setTitulo(request.getParameter("titulo"));
            estudio.setSnip(request.getParameter("snip"));
            estudio.setObjetivo(request.getParameter("objetivo"));
            if (request.getParameter("cantidadBeneficiarios") != "") {
                estudio.setCantidadBeneficiarios(Integer.parseInt(request.getParameter("cantidadBeneficiarios")));
            } else {
                estudio.setCantidadBeneficiarios(null);
            }
            estudio.setCaracteristicasBeneficiarios(request.getParameter("caracteristicasBeneficiarios"));
            estudio.setLugar(request.getParameter("lugar"));
            estudio.setMapa(request.getParameter("mapa"));
            estudio.setSeguimiento(request.getParameter("seguimiento"));
            estudio.setFechaEditado(new Date(new java.util.Date().getTime()));
            estudio.setFechaCreado(new Date(new java.util.Date().getTime()));
            estudio.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
            estudio.setCreadoPor(Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
            estudio.setEditadoPor(Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
            HashMap hm = new HashMap();
            if (dao.insertarEstudio(estudio)) {
                hm.put("success", true);
                hm.put("msg", "Estudio se ingreso correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Estudio no se ingreso correctamente, comuniquese con el administrador del sistema");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void actualizarEstudio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("application/json;charset=UTF-8");
            Gson g = new Gson();
            HashMap hm = new HashMap();
            EstudioDao dao = new EstudioDao();
            Estudio estudio = new Estudio();
            estudio.setId(Integer.parseInt(request.getParameter("id").toString()));
            estudio.setAnho(request.getParameter("fecha").toString().split("/")[2]);
            estudio.setFecha(request.getParameter("fecha").split("/")[2] + "-" + request.getParameter("fecha").split("/")[1] + "-" + request.getParameter("fecha").split("/")[0]);
            estudio.setFoto(request.getParameter("foto"));
            estudio.setTitulo(request.getParameter("titulo"));
            estudio.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
            estudio.setSnip(request.getParameter("snip"));
            estudio.setObjetivo(request.getParameter("objetivo"));
            if (request.getParameter("cantidadBeneficiarios") != "") {
                estudio.setCantidadBeneficiarios(Integer.parseInt(request.getParameter("cantidadBeneficiarios")));
            } else {
                estudio.setCantidadBeneficiarios(null);
            } 
            estudio.setCaracteristicasBeneficiarios(request.getParameter("caracteristicasBeneficiarios"));
            estudio.setLugar(request.getParameter("lugar"));
            estudio.setMapa(request.getParameter("mapa"));
            estudio.setSeguimiento(request.getParameter("seguimiento"));
            estudio.setFechaEditado(new Date(new java.util.Date().getTime()));
            estudio.setEditadoPor(Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
            if (dao.actualizarEstudio(estudio)) {
                hm.put("success", true);
                hm.put("msg", "Estudio se actualiz&oacute; correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Estudio no se actualiz&oacute; correctamente, comuniquese con el administrador del sistema");
            }
            response.getWriter().print(g.toJson(hm));
        }
    }

    private void eliminarEstudio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            EstudioDao estudioDao = new EstudioDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (estudioDao.eliminarEstudio(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "Estudio se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar la nota de prensa");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void publicarEstudio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            EstudioDao estudioDao = new EstudioDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (estudioDao.publicarEstudio(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "Estudio se publicó correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema en la publicación del estudio");
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
            EstudioDao dao = new EstudioDao();
            Estudio estudio = dao.getEstudioForAdmin(id);
            HashMap hm = new HashMap();
            Gson g = new Gson();
            hm.put("estudio", estudio);
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void getNoticiaAlways(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        Integer id = Integer.parseInt(request.getParameter("id").toString());
        EstudioDao dao = new EstudioDao();
        Estudio estudio = dao.getEstudioForAdmin(id);
        HashMap hm = new HashMap();
        Gson g = new Gson();
        hm.put("estudio", estudio);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void listarEstudioForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            EstudioDao estudioDao = new EstudioDao();
            String filtro = request.getParameter("filtro").toString();
            int limit = request.getParameter("limit") == null ? 6 : Integer.parseInt(request.getParameter("limit"));
            int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
            UsuarioDao usuarioDao = new UsuarioDao();
            try {
                HashMap hm = new HashMap();
                hm.put("filtro", "%" + filtro.toUpperCase() + "%");
                hm.put("limit", limit);
                hm.put("start", start);
                List<Estudio> estudios = estudioDao.listEstudioForAdmin(hm);
                Integer total = estudioDao.listTotalEstudioForAdmin("%" + filtro.toUpperCase() + "%");
                out.print("<div id ='total' style='width: 100%;'>Total de Registros: " + total + " </div>");
                for (Estudio estudio : estudios) {
                    String result = "";
                    String nota = estudio.getObjetivo().replaceAll("\\<.*?>", "");
                    result += "<div data=" + total + " class='notice ui-widget ui-widget-content ui-corner-all'>";
                    result += "<div class='notice-head'>";
                    result += "<h2 alt='" + estudio.getTitulo() + "' class='notice-htitulo'>" + estudio.getTitulo().substring(0, estudio.getTitulo().length() > 90 ? 90 : estudio.getTitulo().length()) + "</h2>";
                    result += "<h2 class='notice-hfecha'>" + estudio.getFecha() + "</h2>";
                    result += "</div>";
                    result += "<div class='notice-description'>";
                    result += "<p>" + nota.substring(0, nota.length() > 150 ? 150 : nota.length()) + " ...</p>";
                    result += "</div>";
                    result += "<div class='notice-tools'  data='" + estudio.getId() + "'>";
                    result += "<span class='notice-tsubido'><p>Subido Por: <b>" + usuarioDao.buscarUsuarioPorId(estudio.getEditadoPor()).getLogin() + "</b></p></span>";
                    result += "<span class='notice-tbutton' id='" + estudio.getId() + "' style='display:none;'>";
                    result += "<a role='a' dir='imprimir' class='ver'>Visualizar</a>";
                    result += "<a role='a' dir='editar' class='editar'>Editar</a>";
                    result += "<a role='a' dir='eliminar' class='eliminar'>Eliminar</a>";
                    if (estudio.isEstado()) {
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
    private void estudioForWeb(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        EstudioDao dao = new EstudioDao();
        Gson gson = new Gson();
        try {
            HashMap hm = new HashMap();
            java.sql.Date d = new java.sql.Date(new java.util.Date().getTime());
            hm.put("anho", String.valueOf(d.getYear() + 1900));
            hm.put("order", "desc");
            hm.put("limit", 3);
            List<Estudio> list = dao.estudioForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            out.print(gson.toJson(outHash));
        } finally {
            out.close();
        }
    }

}
