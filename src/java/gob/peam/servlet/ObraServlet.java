package gob.peam.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gob.peam.administracion.dao.UsuarioDao;
import gob.peam.beans.Obra;
import gob.peam.dao.ObraDao;
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
@WebServlet(name = "ObraServlet", urlPatterns = {"/Obra"})
public class ObraServlet extends HttpServlet {

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

            case "InsertarObra":
                insertarObra(request, response);
                break;

            case "ActualizarObra":
                actualizarObra(request, response);
                break;

            case "EliminarObra":
                eliminarObra(request, response);
                break;

            case "PublicarObra":
                publicarObra(request, response);
                break;
            case "GetNotice":
                getNoticia(request, response);
                break;
            case "GetNoticeAlways":
                getNoticiaAlways(request, response);
                break;
            case "ListarObraForAdmin":
                listarObraForAdmin(request, response);
                break;
            case "ObraForWeb":
                obraForWeb(request, response);
                break;
            case "ListarAnhos":
                listarAnhos(request, response);
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

    private void listarAnhos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ObraDao obraDao = new ObraDao();
        String opciones = "";
        HashMap hm = new HashMap();
        hm.put("area", Integer.parseInt(request.getParameter("area")));
        for (String object : obraDao.getListAnioForWeb(hm)) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    private void insertarObra(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("application/json;charset=UTF-8");
            Gson g = new Gson();
            ObraDao dao = new ObraDao();
            Obra obra = new Obra();
            obra.setEstado(true);
            obra.setAnho(request.getParameter("fechaInicio").toString().split("/")[2]);
            obra.setMes(request.getParameter("fechaInicio").toString().split("/")[1]);
            obra.setFechaInicio(request.getParameter("fechaInicio").split("/")[2] + "-" + request.getParameter("fechaInicio").split("/")[1] + "-" + request.getParameter("fechaInicio").split("/")[0]);
            obra.setFechaFin(request.getParameter("fechaFin").split("/")[2] + "-" + request.getParameter("fechaFin").split("/")[1] + "-" + request.getParameter("fechaFin").split("/")[0]);
            obra.setFechaEditado(new Date(new java.util.Date().getTime()));
            obra.setFechaCreado(new Date(new java.util.Date().getTime()));
            obra.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
            obra.setCreadoPor(Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
            obra.setEditadoPor(Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
            obra.setDescripcion(request.getParameter("descripcion"));
            obra.setMontoInversion(Double.parseDouble(request.getParameter("montoInversion")));
            obra.setMontoGastado(Double.parseDouble(request.getParameter("montoGastado")));
            obra.setTiempoEjecucion(Integer.parseInt(request.getParameter("tiempoEjecucion")));
            obra.setModalidadEjecucion(request.getParameter("modalidadEjecucion"));
            obra.setSeguimiento(request.getParameter("seguimiento"));
            obra.setUbicacion(request.getParameter("ubicacion"));
            obra.setContratista(request.getParameter("contratista"));
            obra.setSupervisor(request.getParameter("supervisor"));
            obra.setResidente(request.getParameter("residente"));
            obra.setAvanceFisico(Double.parseDouble(request.getParameter("avanceFisico")));
            obra.setArea(Integer.parseInt(request.getParameter("area")));
            obra.setGaleria(request.getParameter("galeria"));
            obra.setFoto(request.getParameter("foto"));
            obra.setMesActualizacion(request.getParameter("mesActualizacion"));
            obra.setAnhoActualizacion(request.getParameter("anhoActualizacion"));
            obra.setSnip(request.getParameter("snip"));
            obra.setInfobras(request.getParameter("infobras"));
            obra.setLeyenda(request.getParameter("leyenda"));
            obra.setObservacion(request.getParameter("observacion"));
            HashMap hm = new HashMap();
            if (dao.insertarObra(obra)) {
                hm.put("success", true);
                hm.put("msg", "Obra se ingreso correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Obra no se ingreso correctamente, comuniquese con el administrador del sistema");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void actualizarObra(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("application/json;charset=UTF-8");
            Gson g = new Gson();
            HashMap hm = new HashMap();
            ObraDao dao = new ObraDao();
            Obra obra = new Obra();
            obra.setId(Integer.parseInt(request.getParameter("id").toString()));
            obra.setAnho(request.getParameter("fechaInicio").toString().split("/")[2]);
            obra.setMes(request.getParameter("fechaInicio").toString().split("/")[1]);
            obra.setFechaInicio(request.getParameter("fechaInicio").split("/")[2] + "-" + request.getParameter("fechaInicio").split("/")[1] + "-" + request.getParameter("fechaInicio").split("/")[0]);
            obra.setFechaFin(request.getParameter("fechaFin").split("/")[2] + "-" + request.getParameter("fechaFin").split("/")[1] + "-" + request.getParameter("fechaFin").split("/")[0]);
            obra.setFechaEditado(new Date(new java.util.Date().getTime()));
            obra.setFechaCreado(new Date(new java.util.Date().getTime()));
            obra.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
            obra.setCreadoPor(Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
            obra.setEditadoPor(Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
            obra.setDescripcion(request.getParameter("descripcion"));
            obra.setMontoInversion(Double.parseDouble(request.getParameter("montoInversion")));
            obra.setMontoGastado(Double.parseDouble(request.getParameter("montoGastado")));
            obra.setTiempoEjecucion(Integer.parseInt(request.getParameter("tiempoEjecucion")));
            obra.setModalidadEjecucion(request.getParameter("modalidadEjecucion"));
            obra.setSeguimiento(request.getParameter("seguimiento"));
            obra.setUbicacion(request.getParameter("ubicacion"));
            obra.setContratista(request.getParameter("contratista"));
            obra.setSupervisor(request.getParameter("supervisor"));
            obra.setResidente(request.getParameter("residente"));
            obra.setAvanceFisico(Double.parseDouble(request.getParameter("avanceFisico")));
            obra.setArea(Integer.parseInt(request.getParameter("area")));
            obra.setGaleria(request.getParameter("galeria"));
            obra.setFoto(request.getParameter("foto"));
            obra.setMesActualizacion(request.getParameter("mesActualizacion"));
            obra.setAnhoActualizacion(request.getParameter("anhoActualizacion"));
            obra.setSnip(request.getParameter("snip"));
            obra.setInfobras(request.getParameter("infobras"));
            obra.setLeyenda(request.getParameter("leyenda"));
            obra.setObservacion(request.getParameter("observacion"));
            if (dao.actualizarObra(obra)) {
                hm.put("success", true);
                hm.put("msg", "Obra se actualiz&oacute; correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Obra no se actualiz&oacute; correctamente, comuniquese con el administrador del sistema");
            }
            response.getWriter().print(g.toJson(hm));
        }
    }

    private void eliminarObra(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            ObraDao obraDao = new ObraDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (obraDao.eliminarObra(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "Obra se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar la nota de prensa");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void publicarObra(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            ObraDao obraDao = new ObraDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (obraDao.publicarObra(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "Obra se publicó correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema en la publicación del obra");
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
            ObraDao dao = new ObraDao();
            Obra obra = dao.getObraForAdmin(id);
            HashMap hm = new HashMap();
            Gson g = new Gson();
            hm.put("obra", obra);
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void getNoticiaAlways(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        Integer id = Integer.parseInt(request.getParameter("id").toString());
        ObraDao dao = new ObraDao();
        Obra obra = dao.getObraForAdmin(id);
        HashMap hm = new HashMap();
        Gson g = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        hm.put("obra", obra);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void listarObraForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            ObraDao obraDao = new ObraDao();
            String filtro = request.getParameter("filtro").toString();
            int limit = request.getParameter("limit") == null ? 6 : Integer.parseInt(request.getParameter("limit"));
            int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
            UsuarioDao usuarioDao = new UsuarioDao();
            try {
                HashMap hm = new HashMap();
                hm.put("filtro", "%" + filtro.toUpperCase() + "%");
                hm.put("limit", limit);
                hm.put("start", start);
                List<Obra> obras = obraDao.listObraForAdmin(hm);
                Integer total = obraDao.listTotalObraForAdmin("%" + filtro.toUpperCase() + "%");
                out.print("<div id ='total' style='width: 100%;'>Total de Registros: " + total + " </div>");
                for (Obra obra : obras) {
                    String result = "";
                    result += "<div data=" + total + " class='notice ui-widget ui-widget-content ui-corner-all'>";
                    result += "<div class='notice-head'>";
                    result += "<h2 alt='" + obra.getDescripcion() + "' class='notice-htitulo'>" + obra.getDescripcion().substring(0, obra.getDescripcion().length() > 90 ? 90 : obra.getDescripcion().length()) + "</h2>";
                    result += "<h2 class='notice-hfecha'>" + obra.getFechaInicio() + "</h2>";
                    result += "</div>";
                    result += "<div class='notice-tools'  data='" + obra.getId() + "'>";
                    result += "<span class='notice-tsubido'><p>Subido Por: <b>" + usuarioDao.buscarUsuarioPorId(obra.getEditadoPor()).getLogin() + "</b></p></span>";
                    result += "<span class='notice-tbutton' id='" + obra.getId() + "' style='display:none;'>";
                    result += "<a role='a' dir='imprimir' class='ver'>Visualizar</a>";
                    result += "<a role='a' dir='editar' class='editar'>Editar</a>";
                    result += "<a role='a' dir='eliminar' class='eliminar'>Eliminar</a>";
                    if (obra.isEstado()) {
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

    private void obraForWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ObraDao obraDao = new ObraDao();
        Gson gson = new Gson();
        String filtro = request.getParameter("filtro").toString();
        int limit = request.getParameter("limit") == null ? 5 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("filtro", "%" + filtro.toUpperCase() + "%");
            hm.put("limit", limit);
            hm.put("start", start);
            hm.put("anho", request.getParameter("anho"));
            hm.put("area", Integer.parseInt(request.getParameter("area")));
            if (request.getParameter("seguimiento").equals("Todos")) {
                hm.put("seguimiento", null);
            } else {
                hm.put("seguimiento", request.getParameter("seguimiento"));
            }
            List<Obra> obras = obraDao.listObraForWeb(hm);
            Integer total = obraDao.listTotalObraForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", obras);
            outHash.put("total", total);
            out.print(gson.toJson(outHash));
        } catch (Exception e) {
            out.print(e);
        } finally {
            out.close();
        }
    }

    /* @SuppressWarnings({"rawtypes", "unchecked"})
     private void obraForWeb(HttpServletRequest request,
     HttpServletResponse response) throws ServletException, IOException {
     response.setContentType("application/json;charset=UTF-8");
     PrintWriter out = response.getWriter();
     ObraDao dao = new ObraDao();
     Gson gson = new Gson();
     try {
     HashMap hm = new HashMap();
     java.sql.Date d = new java.sql.Date(new java.util.Date().getTime());
     hm.put("anho", String.valueOf(d.getYear() + 1900));
     hm.put("order", "desc");
     hm.put("limit", 5);
     List<Obra> list = dao.obraForWeb(hm);
     HashMap outHash = new HashMap();
     outHash.put("items", list);
     out.print(gson.toJson(outHash));
     } finally {
     out.close();
     }
     }*/
}
