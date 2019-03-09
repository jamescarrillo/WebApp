/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.servlet;

import com.google.gson.Gson;
import gob.peam.administracion.dao.UsuarioDao;
import gob.peam.beans.Anuncio;
import gob.peam.beans.Multimedia;
import gob.peam.beans.NotaPrensa;
import gob.peam.beans.Publicacion;
import gob.peam.dao.AnuncioDao;
import gob.peam.dao.MultimediaDao;
import gob.peam.dao.NotaPrensaDao;
import gob.peam.dao.PublicacionDao;
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
 * @author jprada
 */
@WebServlet(name = "Publicaciones", urlPatterns = {"/Publicaciones"})
public class PublicacionesServlet extends HttpServlet {

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
            case "":
                index(request, response);
                break;
            case "NotaPrensaForNotice":
                notaPrensaForNotice(request, response);
                break;
            case "NotaPrensa":
                notaPrensa(request, response);
                break;
            case "NoticiasMultimedia":
                noticiasMultimedia(request, response);
                break;
            case "MemoriasAnuales":
                memoriasAnuales(request, response);
                break;
            case "Comunicados":
                comunicados(request, response);
                break;
            case "Articulos":
                articulos(request, response);
                break;
            case "OtrasPublicaciones":
                otrasPublicaciones(request, response);
                break;
            case "ListarAnhosNotaPrensa":
                listarAnhosNotaPrensa(request, response);
                break;
            case "ListarNotaPrensaForWeb":
                listarNotaPrensaForWeb(request, response);
                break;
            case "ListarMultimediaForWeb":
                listarMultimediaForWeb(request, response);
                break;
            case "MultimediaForNotice":
                multimediaForNotice(request, response);
                break;
            case "MultimediasForNotice":
                multimediasForNotice(request, response);
                break;
            case "ListarNotaPrensaForAdmin":
                listarNotaPrensaForAdmin(request, response);
                break;
            case "ListarMultimediaForAdmin":
                listarMultimediaForAdmin(request, response);
                break;
            case "ListarAnuncioForAdmin":
                listarAnuncioForAdmin(request, response);
                break;
            case "InsertarNotaPrensa":
                insertarNotaPrensa(request, response);
                break;
            case "InsertarMultimedia":
                insertarMultimedia(request, response);
                break;
            case "InsertarAnuncio":
                insertarAnuncio(request, response);
                break;
            case "GetNotice":
                getNoticia(request, response);
                break;
            case "GetMultimedia":
                getMultimedia(request, response);
                break;
            case "GetAnuncio":
                getAnuncio(request, response);
                break;
            case "GetAnuncioForWeb":
                getAnuncioForWeb(request, response);
                break;
            case "ActualizarNotaPrensa":
                actualizarNotaPrensa(request, response);
                break;
            case "EliminarNotaPrensa":
                eliminarNotaPrensa(request, response);
                break;
            case "PublicarNotaPrensa":
                publicarNotaPrensa(request, response);
                break;
            case "PublicarMultimedia":
                publicarMultimedia(request, response);
                break;
            case "PublicarAnuncio":
                publicarAnuncio(request, response);
                break;
            case "ActualizarMultimedia":
                actualizarMultimedia(request, response);
                break;
            case "ActualizarAnuncio":
                actualizarAnuncio(request, response);
                break;
            case "EliminarMultimedia":
                eliminarMultimedia(request, response);
                break;
            case "EliminarAnuncio":
                eliminarAnuncio(request, response);
                break;
            case "PaginaNotaPrensaPrint":
                PaginaNotaPrensaPrint(request, response);
                break;
            case "PaginaComunicadoPrint":
                PaginaComunicadoPrint(request, response);
                break;
            case "ListarAnhosAnuncio":
                listarAnhosAnuncio(request, response);
                break;
            case "ListarAnuncioForWeb":
                listarAnuncioForWeb(request, response);
                break;
            case "ListarPublicacionForWeb":
                listarPublicacionForWeb(request, response);
                break;
            case "PredefinirMultimedia":
                predefinirMultimedia(request, response);
                break;
            case "CerrarAnuncioForWeb":
                cerrarAnuncioForWeb(request, response);
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

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/publicaciones/index.jsp").forward(request, response);
    }

    private void comunicados(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/publicaciones/comunicados.jsp").forward(request, response);
    }

    private void PaginaComunicadoPrint(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/publicaciones/printComunicado.jsp").forward(request, response);
    }

    private void PaginaNotaPrensaPrint(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/publicaciones/printNotaPrensa.jsp").forward(request, response);
    }

    private void notaPrensa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/publicaciones/notaPrensa.jsp").forward(request, response);
    }

    private void noticiasMultimedia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/publicaciones/noticiasMultimedia.jsp").forward(request, response);
    }

    private void memoriasAnuales(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/publicaciones/memoriasAnuales.jsp").forward(request, response);
    }

    private void articulos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/publicaciones/articulos.jsp").forward(request, response);
    }

    private void otrasPublicaciones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/publicaciones/otrasPublicaciones.jsp").forward(request, response);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void listarAnhosNotaPrensa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        NotaPrensaDao notaPrensaDao = new NotaPrensaDao();
        Gson gson = new Gson();
        HashMap hm = new HashMap();
        hm.put("anhos", notaPrensaDao.listAnhosNotaPrensaForWeb());
        response.getWriter().print(gson.toJson(hm));
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void notaPrensaForNotice(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        NotaPrensaDao notaPrensaDao = new NotaPrensaDao();
        Gson gson = new Gson();
        try {
            HashMap hm = new HashMap();
            java.sql.Date d = new java.sql.Date(new java.util.Date().getTime());
            hm.put("anho", String.valueOf(d.getYear() + 1900));
            hm.put("order", "desc");
            hm.put("limit", 7);
            List<NotaPrensa> list = notaPrensaDao.listNotaPrensaForNotice(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            out.print(gson.toJson(outHash));
        } finally {
            out.close();
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void listarNotaPrensaForWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        NotaPrensaDao notaPrensaDao = new NotaPrensaDao();
        Gson gson = new Gson();
        int limit = request.getParameter("limit") == null ? 6 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anho", request.getParameter("anho").trim());
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<NotaPrensa> list = notaPrensaDao.listarNotaPrensaForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", notaPrensaDao.listTotalNotaPrensaForWeb(hm));
            out.print(gson.toJson(outHash));
        } finally {
            out.close();
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void listarMultimediaForWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MultimediaDao multimediaDao = new MultimediaDao();
        Gson gson = new Gson();
        int limit = request.getParameter("limit") == null ? 6 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            HashMap outHash = new HashMap();
            outHash.put("items", multimediaDao.listarMultimediaForWeb(hm));
            outHash.put("total", multimediaDao.listTotalMultimediaForWeb(hm));
            out.print(gson.toJson(outHash));
        } finally {
            out.close();
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void listarMultimediaForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            MultimediaDao multimediaDao = new MultimediaDao();
            UsuarioDao usuarioDao = new UsuarioDao();
            String filtro = request.getParameter("filtro").toString();
            int limit = request.getParameter("limit") == null ? 6 : Integer.parseInt(request.getParameter("limit"));
            int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
            try {
                HashMap hm = new HashMap();
                hm.put("filtro", "%" + filtro.toUpperCase() + "%");
                hm.put("limit", limit);
                hm.put("start", start);
                List<Multimedia> list = multimediaDao.listMultimediaAdmin(hm);
                Integer total = multimediaDao.listTotalMultimediaForAdmin("%" + filtro.toUpperCase() + "%");
                out.print("<div id ='total' style='width: 100%;'>Total de Registros: " + total + " </div>");
                for (Multimedia multi : list) {
                    String result = "";
                    result += "<div data=" + total + " class='notice ui-widget ui-widget-content ui-corner-all'>";
                    result += "<div class='notice-head'>";
                    result += "<h2 alt='" + multi.getTitulo() + "' class='notice-htitulo'>" + multi.getTitulo().substring(0, multi.getTitulo().length() > 90 ? 90 : multi.getTitulo().length()) + "</h2>";
                    result += "<h2 class='notice-hfecha'>" + multi.getFecha() + "</h2>";
                    result += "</div>";
                    result += "<div class='notice-description'>";
                    result += "<p>" + multi.getFuente().substring(0, multi.getFuente().length() > 150 ? 150 : multi.getFuente().length()) + " ...</p>";
                    result += "</div>";
                    result += "<div class='notice-tools'  data='" + multi.getId() + "'>";
                    result += "<span class='notice-tsubido'><p>Subido Por: <b>" + usuarioDao.buscarUsuarioPorId(multi.getUsuario()).getLogin() + "</b></p></span>";
                    result += "<span class='notice-tbutton' style='display:none;'>";
                    if (multi.isDefecto()) {
                        result += "<a role='a' dir='editar' class='default' rel='false'>Prederteminado</a>";
                    } else {
                        result += "<a role='a' dir='editar' class='default-d' rel='true'>Prederteminado</a>";
                    }
                    result += "<a role='a' dir='editar' class='editar'>Editar</a>";
                    result += "<a role='a' dir='eliminar' class='eliminar'>Eliminar</a>";
                    if (multi.isEstado()) {
                        result += "<a role='a' class='anular'>Ocultar</a>";
                    } else {
                        result += "<a role='a' dir='publicar' class='publicar'>Publicar</a>";
                    }
                    result += "</span>";
                    result += "</div>";
                    result += "</div>";
                    out.print(result);
                }
            } catch (Exception e) {
                out.print(e.getMessage());
            } finally {
                out.close();
            }
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void listarAnuncioForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            AnuncioDao anuncioDao = new AnuncioDao();
            String filtro = request.getParameter("filtro").toString();
            int limit = request.getParameter("limit") == null ? 6 : Integer.parseInt(request.getParameter("limit"));
            int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
            try {
                HashMap hm = new HashMap();
                hm.put("filtro", "%" + filtro.toUpperCase() + "%");
                hm.put("limit", limit);
                hm.put("start", start);
                List<Anuncio> list = anuncioDao.listAnuncioAdmin(hm);
                Integer total = anuncioDao.listTotalAnuncioForAdmin("%" + filtro.toUpperCase() + "%");
                String[] array = new String[10];
                array[1] = "Comunicado";
                array[2] = "Convocatoria";
                array[3] = "Saludo";
                array[4] = "Otros";
                out.print("<div id ='total' style='width: 100%;'>Total de Registros: " + total + " </div>");
                for (Anuncio anu : list) {
                    String result = "";
                    String contenido = anu.getContenido().replaceAll("\\<.*?\\>", "");
                    result += "<div data=" + total + " class='notice ui-widget ui-widget-content ui-corner-all'>";
                    result += "<div class='notice-head'>";
                    result += "<h2 alt='" + anu.getTitulo() + "' class='notice-htitulo'>" + anu.getTitulo().substring(0, anu.getTitulo().length() > 90 ? 90 : anu.getTitulo().length()) + "</h2>";
                    result += "<h2 class='notice-hfecha'>" + anu.getAnuFechaInicio() + "/ " + anu.getAnuFechaFin() + "</h2>";
                    result += "</div>";
                    result += "<div class='notice-description'>";
                    result += "<p>" + contenido.substring(0, contenido.length() > 150 ? 150 : contenido.length()) + " ...</p>";
                    result += "</div>";
                    result += "<div class='notice-tools'  data='" + anu.getAnuId() + "'>";
                    result += "<span class='notice-tsubido'><p>Tipo: <b>" + array[anu.getTipo()] + "</b></p></span>";
                    result += "<span class='notice-tbutton' style='display:none;'>";
                    result += "<a role='a' dir='imprimir' class='ver'>Visualizar</a>";
                    result += "<a class='editar'>Editar</a>";
                    result += "<a class='eliminar'>Eliminar</a>";
                    if (anu.getEstado()) {
                        result += "<a class='anular'>Ocultar</a>";
                    } else {
                        result += "<a class='publicar'>Publicar</a>";
                    }

                    result += "</span>";
                    result += "</div>";
                    result += "</div>";
                    out.print(result);
                }

            } catch (Exception e) {
                out.print(e.getMessage());
            } finally {
                out.close();
            }
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void multimediaForNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MultimediaDao multimediaDao = new MultimediaDao();
        int limit = request.getParameter("limit") == null ? 1 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        Gson gson = new Gson();
        try {
            HashMap hm = new HashMap();
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            Multimedia multimedia = multimediaDao.listMultimediaForNotice(hm);
            HashMap outHash = new HashMap();
            outHash.put("multimedia", multimedia);
            outHash.put("total", multimediaDao.listTotalMultimediaForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void multimediasForNotice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MultimediaDao multimediaDao = new MultimediaDao();
        int limit = request.getParameter("limit") == null ? 2 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        Gson gson = new Gson();
        try {
            HashMap hm = new HashMap();
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<Multimedia> multimedia = multimediaDao.listMultimediasForNotice(hm);
            HashMap outHash = new HashMap();
            outHash.put("multimedia", multimedia);
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void listarNotaPrensaForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            NotaPrensaDao notaPrensaDao = new NotaPrensaDao();
            String filtro = request.getParameter("filtro").toString();
            int limit = request.getParameter("limit") == null ? 6 : Integer.parseInt(request.getParameter("limit"));
            int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
            UsuarioDao usuarioDao = new UsuarioDao();
            try {
                HashMap hm = new HashMap();
                hm.put("filtro", "%" + filtro.toUpperCase() + "%");
                hm.put("limit", limit);
                hm.put("start", start);
                List<NotaPrensa> notaPrensas = notaPrensaDao.listNotaPrensaForAdmin(hm);
                Integer total = notaPrensaDao.listTotalNotaPrensaForAdmin("%" + filtro.toUpperCase() + "%");
                String nota = null;
                out.print("<div id ='total' style='width: 100%;'>Total de Registros: " + total + " </div>");
                for (NotaPrensa notaPrensa : notaPrensas) {

                    String result = "";
                    nota = notaPrensa.getContenido().replaceAll("\\<.*?>", "");
                    result += "<div data=" + total + " class='notice ui-widget ui-widget-content ui-corner-all'>";
                    result += "<div class='notice-head'>";
                    result += "<h2 alt='" + notaPrensa.getTitulo() + "' class='notice-htitulo'>" + notaPrensa.getTitulo().substring(0, notaPrensa.getTitulo().length() > 90 ? 90 : notaPrensa.getTitulo().length()) + "</h2>";
                    result += "<h2 class='notice-hfecha'>" + notaPrensa.getFecha() + "</h2>";
                    result += "</div>";
                    result += "<div class='notice-description'>";
                    result += "<p>" + nota.substring(0, nota.length() > 150 ? 150 : nota.length()) + " ...</p>";
                    result += "</div>";
                    result += "<div class='notice-tools'  data='" + notaPrensa.getId() + "'>";
                    result += "<span class='notice-tsubido'><p>Subido Por: <b>" + usuarioDao.buscarUsuarioPorId(notaPrensa.getUsuario()).getLogin() + "</b></p></span>";
                    result += "<span class='notice-tbutton' id='" + notaPrensa.getId() + "' style='display:none;'>";
                    result += "<a role='a' dir='imprimir' class='ver'>Visualizar</a>";
                    result += "<a role='a' dir='editar' class='editar'>Editar</a>";
                    result += "<a role='a' dir='eliminar' class='eliminar'>Eliminar</a>";
                    if (notaPrensa.isEstado()) {
                        result += "<a role='a' dir='publicar' class='anular'>Ocultar</a>";
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

    private void insertarNotaPrensa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("application/json;charset=UTF-8");
            Gson g = new Gson();
            NotaPrensaDao dao = new NotaPrensaDao();
            NotaPrensa notaPrensa = new NotaPrensa();
            notaPrensa.setEstado(true);
            notaPrensa.setContenido(request.getParameter("contenido"));
            notaPrensa.setAnho(request.getParameter("fecha").toString().split("/")[2]);
            notaPrensa.setFecha(request.getParameter("fecha").split("/")[2] + "-" + request.getParameter("fecha").split("/")[1] + "-" + request.getParameter("fecha").split("/")[0]);
            notaPrensa.setFuente(request.getParameter("fuente"));
            notaPrensa.setFoto(request.getParameter("foto"));
            notaPrensa.setTitulo(request.getParameter("titulo"));
            notaPrensa.setFechaActualizacion(new Date(new java.util.Date().getTime()));
            notaPrensa.setFechaCreacion(new Date(new java.util.Date().getTime()));
            notaPrensa.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
            notaPrensa.setUsuario(Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
            HashMap hm = new HashMap();
            if (dao.insertarNotaPrensa(notaPrensa)) {
                hm.put("success", true);
                hm.put("msg", "La nota de prensa se ingreso correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "La nota de prensa no se ingreso correctamente, comuniquese con el administrador del sistema");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void insertarMultimedia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("application/json;charset=UTF-8");
            Gson g = new Gson();
            MultimediaDao dao = new MultimediaDao();
            Multimedia multimedia = new Multimedia();
            multimedia.setEstado(true);
            multimedia.setFecha(request.getParameter("fecha").split("/")[2] + "-" + request.getParameter("fecha").split("/")[1] + "-" + request.getParameter("fecha").split("/")[0]);
            multimedia.setFuente(request.getParameter("fuente"));
            multimedia.setTitulo(request.getParameter("titulo"));
            multimedia.setEstado(Boolean.parseBoolean(request.getParameter("estado")));

            multimedia.setUsuario(Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
            HashMap hm = new HashMap();
            if (dao.insertarMultimedia(multimedia)) {
                hm.put("success", true);
                hm.put("msg", "La multimedia se ingreso correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "La multimedia no se ingreso correctamente, comuniquese con el administrador del sistema");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void insertarAnuncio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("application/json;charset=UTF-8");
            Gson g = new Gson();
            AnuncioDao dao = new AnuncioDao();
            Anuncio anuncio = new Anuncio();
            anuncio.setEstado(true);

            anuncio.setAnuFechaInicio(request.getParameter("fechaInicio").split("/")[2] + "-" + request.getParameter("fechaInicio").split("/")[1] + "-" + request.getParameter("fechaInicio").split("/")[0]);
            anuncio.setAnuFechaFin(request.getParameter("fechaFin").split("/")[2] + "-" + request.getParameter("fechaFin").split("/")[1] + "-" + request.getParameter("fechaFin").split("/")[0]);
            anuncio.setTipo(Integer.parseInt(request.getParameter("tipo")));
            anuncio.setTitulo(request.getParameter("titulo"));
            anuncio.setContenido(request.getParameter("contenido"));
            anuncio.setEstado(Boolean.parseBoolean(request.getParameter("estado")));

            HashMap hm = new HashMap();
            if (dao.insertarAnuncio(anuncio)) {
                hm.put("success", true);
                hm.put("msg", "El anuncio se ingreso correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "El anuncio no se ingreso correctamente, comuniquese con el administrador del sistema");
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
            NotaPrensaDao dao = new NotaPrensaDao();
            NotaPrensa notaPrensa = dao.getNotaPrensaForAdmin(id);
            HashMap hm = new HashMap();
            Gson g = new Gson();
            hm.put("notaPrensa", notaPrensa);
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void getMultimedia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            Integer id = Integer.parseInt(request.getParameter("id").toString());

            MultimediaDao dao = new MultimediaDao();
            Multimedia multimedia = dao.getMultimediaAdmin(id);
            HashMap hm = new HashMap();
            Gson g = new Gson();
            hm.put("multimedia", multimedia);
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void getAnuncio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            Integer id = Integer.parseInt(request.getParameter("id").toString());
            AnuncioDao dao = new AnuncioDao();
            Anuncio anuncio = dao.getAnuncioAdmin(id);
            HashMap hm = new HashMap();
            Gson g = new Gson();
            hm.put("anuncio", anuncio);
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void cerrarAnuncioForWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("anuncio").equals("x")) {
            request.getSession().setAttribute("anuncio", "o");
        }
    }

    private void getAnuncioForWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        {
            try {
                if (request.getSession().getAttribute("anuncio").equals("")) {
                }
            } catch (NullPointerException e) {
                request.getSession().setAttribute("anuncio", "x");
            }
            String fecha = (new Date(new java.util.Date().getTime())).toString();
            AnuncioDao dao = new AnuncioDao();
            Anuncio anuncio = dao.getAnuncioforWeb(fecha);
            HashMap hm = new HashMap();
            Gson g = new Gson();
            hm.put("estado", request.getSession().getAttribute("anuncio"));
            hm.put("anuncio", anuncio);
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void actualizarNotaPrensa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("application/json;charset=UTF-8");
            Gson g = new Gson();
            HashMap hm = new HashMap();
            NotaPrensaDao dao = new NotaPrensaDao();
            NotaPrensa notaPrensa = new NotaPrensa();
            notaPrensa.setId(Integer.parseInt(request.getParameter("id").toString()));
            notaPrensa.setContenido(request.getParameter("contenido"));
            notaPrensa.setAnho(request.getParameter("fecha").toString().split("/")[2]);
            notaPrensa.setFecha(request.getParameter("fecha").split("/")[2] + "-" + request.getParameter("fecha").split("/")[1] + "-" + request.getParameter("fecha").split("/")[0]);
            notaPrensa.setFuente(request.getParameter("fuente"));
            notaPrensa.setFoto(request.getParameter("foto"));
            notaPrensa.setTitulo(request.getParameter("titulo"));
            notaPrensa.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
            notaPrensa.setFechaActualizacion(new Date(new java.util.Date().getTime()));
            if (dao.actualizarNotaPrensa(notaPrensa)) {
                hm.put("success", true);
                hm.put("msg", "La nota de prensa se actualiz&oacute; correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "La nota de prensa no se actualiz&oacute; correctamente, comuniquese con el administrador del sistema");
            }
            response.getWriter().print(g.toJson(hm));
        }
    }

    private void eliminarNotaPrensa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            NotaPrensaDao notaPrensaDao = new NotaPrensaDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (notaPrensaDao.eliminarNotaPrensa(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "La nota de prensa se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar la nota de prensa");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void publicarNotaPrensa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            NotaPrensaDao notaPrensaDao = new NotaPrensaDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (notaPrensaDao.publicarNotaPrensa(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "La nota de prensa se publicó correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema en la publicación de la nota de prensa");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void publicarMultimedia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            MultimediaDao multimediaDao = new MultimediaDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (multimediaDao.publicarMultimedia(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "La noticia multimedia se publicó correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema en la publicación de la noticia multimedia");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void publicarAnuncio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            AnuncioDao anuncioDao = new AnuncioDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (anuncioDao.publicarAnuncio(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "El anuncio se publicó correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema en la publicación del anuncio");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void eliminarMultimedia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            MultimediaDao multimediaDao = new MultimediaDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (multimediaDao.eliminarMultimedia(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "La Multimedia se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar la Multimedia");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void eliminarAnuncio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            AnuncioDao anuncioDao = new AnuncioDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (anuncioDao.eliminarAnuncio(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "El Anuncio se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar el Anuncio");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void actualizarAnuncio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            Gson g = new Gson();
            HashMap hm = new HashMap();
            AnuncioDao dao = new AnuncioDao();
            Anuncio anuncio = new Anuncio();
            anuncio.setAnuFechaInicio(request.getParameter("fechaInicio").split("/")[2] + "-" + request.getParameter("fechaInicio").split("/")[1] + "-" + request.getParameter("fechaInicio").split("/")[0]);
            anuncio.setAnuFechaFin(request.getParameter("fechaFin").split("/")[2] + "-" + request.getParameter("fechaFin").split("/")[1] + "-" + request.getParameter("fechaFin").split("/")[0]);
            anuncio.setTipo(Integer.parseInt(request.getParameter("tipo")));
            anuncio.setTitulo(request.getParameter("titulo"));
            anuncio.setContenido(request.getParameter("contenido"));
            anuncio.setAnuId(Integer.parseInt(request.getParameter("id")));
            anuncio.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
            if (dao.actualizarAnuncio(anuncio)) {
                hm.put("success", true);
                hm.put("msg", "El Anuncio se actualiz&oacute; correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "El Anuncio  no se actualiz&oacute; correctamente, comuniquese con el administrador del sistema");
            }
            response.getWriter().print(g.toJson(hm));
        }
    }

    private void actualizarMultimedia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("application/json;charset=UTF-8");
            Gson g = new Gson();
            HashMap hm = new HashMap();
            MultimediaDao dao = new MultimediaDao();
            Multimedia multimedia = new Multimedia();
            multimedia.setId(Integer.parseInt(request.getParameter("id").toString()));
            multimedia.setFecha(request.getParameter("fecha").split("/")[2] + "-" + request.getParameter("fecha").split("/")[1] + "-" + request.getParameter("fecha").split("/")[0]);
            multimedia.setFuente(request.getParameter("fuente"));
            multimedia.setEstado(false);
            multimedia.setTitulo(request.getParameter("titulo"));
            multimedia.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
            if (dao.actualizarMultimedia(multimedia)) {
                hm.put("success", true);
                hm.put("msg", "La noticia multimedia se actualiz&oacute; correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "La noticia multimedia  no se actualiz&oacute; correctamente, comuniquese con el administrador del sistema");
            }
            response.getWriter().print(g.toJson(hm));
        }
    }

    private void listarAnhosAnuncio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        AnuncioDao dao = new AnuncioDao();
        String opciones = "";
        for (String object : dao.listAnhosAnuncioForWeb()) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    private void predefinirMultimedia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MultimediaDao dao = new MultimediaDao();
        Multimedia bean = new Multimedia();
        bean.setId(request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id")));
        bean.setDefecto(request.getParameter("value") == null ? true : Boolean.parseBoolean(request.getParameter("value")));
        dao.predefinirMultimedia(bean);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void listarAnuncioForWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        AnuncioDao dao = new AnuncioDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<Anuncio> list = dao.listarAnuncioForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", dao.listTotalAnuncioForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }

    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void listarPublicacionForWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PublicacionDao dao = new PublicacionDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        int tipo = request.getParameter("tipo") == null ? 0 : Integer.parseInt(request.getParameter("tipo"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("tipo", tipo);
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<Publicacion> list = dao.listarPublicacionForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", dao.listTotalPublicacionForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }
}
