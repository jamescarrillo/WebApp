/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gob.peam.beans.*;
import gob.peam.dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "Convocatoria", urlPatterns = {"/Convocatoria"})
public class ConvocatoriaServlet extends HttpServlet {

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
        String anho;
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action) {
            case "":
                index(request, response);
                break;
            case "ListarConvocatoriaBien":
                listarConvocatoriaBien(request, response);
                break;
            case "ListarConvocatoriaBienForWeb":
                listarConvocatoriaBienForWeb(request, response);
                break;
            case "ListarCalendarioConvocatoria":
                listarCalendarioConvocatoria(request, response);
                break;
            case "InsertarConvocatoriaBien":
                insertarConvocatoriaBien(request, response);
                break;
            case "BuscarConvocatoriaBien":
                buscarConvocatoriaBien(request, response);
                break;
            case "ActualizarConvocatoriaBien":
                actualizarConvocatoriaBien(request, response);
                break;
            case "ActualizarCalendarioConvocatoria":
                actualizarCalendarioConvocatoria(request, response);
                break;
            case "eliminarConvocatoriaBien":
                eliminarConvocatoriaBien(request, response);
                break;
            case "estadoConvocatoriaBien":
                estadoConvocatoriaBien(request, response);
                break;
            case "ListarActividad":
                listarActividad(request, response);
                break;
            case "buscarCalendarioConvocatoria":
                buscarCalendarioConvocatoria(request, response);
                break;
            case "insertarCalendarioConvocatoria":
                insertarCalendarioConvocatoria(request, response);
                break;
            case "listarCalendarioConvocatoriaForWeb":
                listarCalendarioConvocatoriaForWeb(request, response);
                break;
            case "ActualizarFinalObra":
                actualizarFinalObra(request, response);
                break;
            case "GetDocumento":
                getDocumento(request, response);
                break;

            case "Documentos":
                HashMap hm = new HashMap();
                hm.put("query", (String) "%" + request.getParameter("query") + "%" == null ? "" : "%" + request.getParameter("query").trim().replace('$', '&') + "%");
                hm.put("limit", request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit")));
                hm.put("start", request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start")));
                hm.put("anho", request.getParameter("anho") == null ? "" : request.getParameter("anho").trim());
                hm.put("cateId", Integer.parseInt(request.getParameter("cate_id")));
                hm.put("items", new ResolucionObraDao().listItemsWeb(hm));
                hm.put("total", new ResolucionObraDao().listTotalWeb(hm));
                hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
                response.getWriter().print(new Gson().toJson(hm));
                break;

            case "Declaracion":
                HashMap hmx = new HashMap();
                hmx.put("query", (String) "%" + request.getParameter("query") + "%" == null ? "" : "%" + request.getParameter("query").trim().replace('$', '&') + "%");
                hmx.put("limit", request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit")));
                hmx.put("start", request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start")));
                hmx.put("anho", request.getParameter("anho") == null ? "" : request.getParameter("anho").trim());
                hmx.put("cateId", Integer.parseInt(request.getParameter("cate_id")));
                hmx.put("items", new DeclaracionDao().listItemsWeb(hmx));
                hmx.put("total", new ResolucionObraDao().listTotalWeb(hmx));
                hmx.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
                response.getWriter().print(new Gson().toJson(hmx));
                break;

            case "ListarAnhosDocumentos":
                String opciones = "";
                for (String object : new ResolucionObraDao().listAnhosForWeb(Integer.parseInt(request.getParameter("cate_id")))) {
                    opciones += "<option>" + object + "</option>";
                }
                response.getWriter().print(opciones);
                break;
            case "ActualizarExonerado":
                actualizarExonerado(request, response);
                break;
            case "GetExoneracion":
                getExonerado(request, response);
                break;
            case "GetPenalidad":
                getPenalidad(request, response);
                break;
            case "ActualizarPenalidad":
                actualizarPenalidad(request, response);
                break;
            case "ListarExoneradoForWeb":
                listarExoneradoForWeb(request, response);
                break;
            case "ListarPenalidadForWeb":
                listarPenalidadForWeb(request, response);
                break;
            case "ListarAnhosExonerado":
                anho = "";
                for (Anho anhos : new ExoneradoDao().getAnhos()) {
                    anho += "<option>" + anhos.getAnho() + "</option>";
                }
                response.getWriter().print(anho);
                break;
            case "ListarAnhosPenalidad":
                anho = "";
                for (Anho anhos : new PenalidadDao().getAnhos()) {
                    anho += "<option>" + anhos.getAnho() + "</option>";
                }
                response.getWriter().print(anho);
                break;

            case "Publicar":
                new ResolucionObraDao().publicar(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("cate_id")));
                break;
                
            case "Sincronizar":
                for(ResolucionGerencial r: new ArcDigDao().temporal()){
                    new ResolucionObraDao().updateTemporal(r);
                }
            break;
        }
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.getRequestDispatcher("./WEB-INF/intranet/web/index.jsp").forward(request, response);

    }

    private void listarConvocatoriaBien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ConvocatoriaDao dao = new ConvocatoriaDao();
        Gson g = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();

        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        int filtro = request.getParameter("filtro") == null ? 0 : Integer.parseInt(request.getParameter("filtro"));
        HashMap hm = new HashMap();
        hm.put("query", "%" + query + "%");
        hm.put("limit", limit);
        hm.put("start", start);
        switch (filtro) {
            case 0:
                hm.put("filtro", "");
                break;
            default:
                hm.put("filtro", " and tipo = '" + filtro + "' ");
                break;
        }
        List<ConvocatoriaBien> list = dao.listarConvocatoriaBienForAdmin(hm);
        hm.put("items", list);
        hm.put("total", dao.listarTotalConvocatoriaBienForAdmin(hm));
        hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void listarExoneradoForWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        Gson g = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        HashMap hm = new HashMap();
        hm.put("query", (String) "%" + request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&') + "%");
        hm.put("limit", request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit")));
        hm.put("start", request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start")));
        hm.put("anho", request.getParameter("anho") == null ? "" : request.getParameter("anho").trim());
        hm.put("items", new ExoneradoDao().listItemsWeb(hm));
        hm.put("total", new ExoneradoDao().listTotalWeb(hm));
        hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        response.getWriter().print(g.toJson(hm));

    }

    private void listarPenalidadForWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        Gson g = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        HashMap hm = new HashMap();
        hm.put("query", (String) "%" + request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&') + "%");
        hm.put("limit", request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit")));
        hm.put("start", request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start")));
        hm.put("anho", request.getParameter("anho") == null ? "" : request.getParameter("anho").trim());
        hm.put("items", new PenalidadDao().listItemsWeb(hm));
        hm.put("total", new PenalidadDao().listTotalWeb(hm));
        hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        response.getWriter().print(g.toJson(hm));
    }

    private void listarConvocatoriaBienForWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ConvocatoriaDao dao = new ConvocatoriaDao();
        Gson g = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();

        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        HashMap hm = new HashMap();
        hm.put("query", "%" + query + "%");
        hm.put("limit", limit);
        hm.put("start", start);
        List<ConvocatoriaBien> list = dao.listarConvocatoriaBienForWeb(hm);
        hm.put("items", list);
        hm.put("total", dao.listarTotalConvocatoriaBienForWeb(hm));
        hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void insertarConvocatoriaBien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ConvocatoriaDao dao = new ConvocatoriaDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        ConvocatoriaBien m = new ConvocatoriaBien();
        String[] s = request.getParameter("txtFecha").split("/");
        int anios = Integer.parseInt(s[2].toString()) - 1900;
        int meses = Integer.parseInt(s[1].toString()) - 1;
        int dias = Integer.parseInt(s[0].toString());

        m.setFecha(new Date(anios, meses, dias));
        m.setAnho(String.valueOf(anios));
        m.setTitulo(request.getParameter("txtTitulo"));
        m.setReferencia(request.getParameter("txtSintesisConvocatoria"));
        m.setTipo(Integer.parseInt(request.getParameter("cmbObjeto")));
        m.setValReferencial(request.getParameter("txtValorReferencial"));
        m.setCostParticipacion(request.getParameter("txtCostoParticipacion"));
        m.setLugRegParticipante(request.getParameter("txtLugarRegParticipantes"));
        m.setEstado(Boolean.parseBoolean(request.getParameter("txtEstadoConvocatoria")));
        m.setBasesFile(request.getParameter("file_1"));
        m.setResEjectFile(request.getParameter("file_2"));
        m.setAbsConObserFile(request.getParameter("file_3"));
        m.setAbsConsultFile(request.getParameter("file_4"));
        m.setAbsObservaFile(request.getParameter("file_5"));
        m.setProEntiFile(request.getParameter("file_6"));
        m.setProOsceFile(request.getParameter("file_7"));
        m.setBasInteFile(request.getParameter("file_8"));
        m.setActEvalTecFile(request.getParameter("file_9"));
        m.setCuaCompaFile(request.getParameter("file_10"));
        m.setActaBuenaProFile(request.getParameter("file_11"));
        m.setNotiSusFile(request.getParameter("file_12"));
        m.setResRecEntiFile(request.getParameter("file_13"));
        m.setResRecTribFile(request.getParameter("file_14"));
        m.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
        m.setProceso(Integer.parseInt(request.getParameter("txtProceso")));

        if (dao.insertarConvocatoriaBien(m)) {
            hm.put("success", true);
            hm.put("msg", "La Convocatoria se Inserto correctamente");
        } else {
            hm.put("success", false);
            hm.put("msg", "Hubo un Problema al Insertar la Convocatoria");
        }

        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void buscarConvocatoriaBien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ConvocatoriaDao dao = new ConvocatoriaDao();
        Gson g = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        HashMap hm = new HashMap();
        ConvocatoriaBien m = dao.buscarConvocatoriaBien(Integer.parseInt(request.getParameter("id")));
        hm.put("convocatoria", m);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void buscarCalendarioConvocatoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        CalendarioConvocatoriaDao dao = new CalendarioConvocatoriaDao();
        CalendarioConvocatoria m = dao.buscarCalendarioConvocatoria(Integer.parseInt(request.getParameter("id")));
        HashMap hm = new HashMap();
        hm.put("calendario", m);
        Gson g = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void actualizarConvocatoriaBien(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ConvocatoriaDao dao = new ConvocatoriaDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        ConvocatoriaBien c = new ConvocatoriaBien();
        c.setTitulo(request.getParameter("txtTitulo"));
        c.setReferencia(request.getParameter("txtSintesisConvocatoria"));
        c.setTipo(Integer.parseInt(request.getParameter("cmbObjeto")));
        c.setValReferencial(request.getParameter("txtValorReferencial"));
        c.setCostParticipacion(request.getParameter("txtCostoParticipacion"));
        c.setLugRegParticipante(request.getParameter("txtLugarRegParticipantes"));
        String[] s = request.getParameter("txtFecha").split("/");
        int anios = Integer.parseInt(s[2].toString()) - 1900;
        int meses = Integer.parseInt(s[1].toString()) - 1;
        int dias = Integer.parseInt(s[0].toString());

        c.setFecha(new Date(anios, meses, dias));
        c.setAnho(String.valueOf(anios));
        c.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
        c.setProceso(Integer.parseInt(request.getParameter("txtProceso")));

        c.setBasesFile(request.getParameter("file_1"));
        c.setResEjectFile(request.getParameter("file_2"));
        c.setAbsConObserFile(request.getParameter("file_3"));
        c.setAbsConsultFile(request.getParameter("file_4"));
        c.setAbsObservaFile(request.getParameter("file_5"));
        c.setProEntiFile(request.getParameter("file_6"));
        c.setProOsceFile(request.getParameter("file_7"));
        c.setBasInteFile(request.getParameter("file_8"));
        c.setActEvalTecFile(request.getParameter("file_9"));
        c.setCuaCompaFile(request.getParameter("file_10"));
        c.setActaBuenaProFile(request.getParameter("file_11"));
        c.setNotiSusFile(request.getParameter("file_12"));
        c.setResRecEntiFile(request.getParameter("file_13"));
        c.setResRecTribFile(request.getParameter("file_14"));
        c.setConvoId(Integer.parseInt(request.getParameter("idConvocatoria")));
        if (dao.actualizarConvocatoriaBien(c)) {
            hm.put("success", true);
            hm.put("msg",
                    "La actualizaci&oacute;n de la convocatoria se Realiz&oacute; Correctamente ");
        } else {
            hm.put("success ", false);
            hm.put("msg", "Hubo un Problema al actualizar la convocatoria");
        }

        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void actualizarCalendarioConvocatoria(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        CalendarioConvocatoriaDao dao = new CalendarioConvocatoriaDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        CalendarioConvocatoria c = new CalendarioConvocatoria();
        String[] s = request.getParameter("txtFechaInicio").split("/");
        int anios = Integer.parseInt(s[2].toString()) - 1900;
        int meses = Integer.parseInt(s[1].toString()) - 1;
        int dias = Integer.parseInt(s[0].toString());
        java.sql.Date fecha1 = new Date(anios, meses, dias);
        c.setFechaInicio(fecha1);

        s = request.getParameter("txtFechaFin").split("/");
        anios = Integer.parseInt(s[2].toString()) - 1900;
        meses = Integer.parseInt(s[1].toString()) - 1;
        dias = Integer.parseInt(s[0].toString());
        java.sql.Date fecha2 = new Date(anios, meses, dias);
        c.setFechaFin(fecha2);

        c.setEstado(Boolean.parseBoolean(request.getParameter("txtEstadoActividad")));
        c.setActiId(Integer.parseInt(request.getParameter("cmbnombreActividad")));
        c.setId(Integer.parseInt(request.getParameter("idCalendario")));

        if (dao.actualizarCalendarioConvocatoriaPers(c)) {
            hm.put("success", true);
            hm.put("msg", "La actualizaci&oacute;n de la actividad se Realiz&oacute; Correctamente ");
        } else {
            hm.put("success ", false);
            hm.put("msg", "Hubo un Problema al actualizar la actividad");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void listarActividad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ActividadDao dao = new ActividadDao();
        String result = "";
        Integer convoId = Integer.parseInt(request.getParameter("idConvocatoria"));
        Integer actiId = request.getParameter("idActividad") == null ? 0 : Integer.parseInt(request.getParameter("idActividad"));

        HashMap h = new HashMap();
        h.put("convoId", convoId);
        if (actiId != 0) {
            h.put("filter", "and acti_id != " + actiId);
        } else {
            h.put("filter", "");
        }
        for (Actividad actividad : dao.listarActividad(h)) {
            result += "<option value='" + actividad.getActiId() + "'>" + actividad.getDescripcion() + "</option>";
        }
        response.getWriter().print(result);
    }

    private void insertarCalendarioConvocatoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        HashMap hm = new HashMap();
        Gson g = new Gson();

        CalendarioConvocatoriaDao dao = new CalendarioConvocatoriaDao();
        CalendarioConvocatoria c = new CalendarioConvocatoria();

        String[] s = request.getParameter("txtFechaInicio").split("/");
        int anios = Integer.parseInt(s[2].toString()) - 1900;
        int meses = Integer.parseInt(s[1].toString()) - 1;
        int dias = Integer.parseInt(s[0].toString());
        java.sql.Date fecha1 = new Date(anios, meses, dias);
        c.setFechaInicio(fecha1);

        s = request.getParameter("txtFechaFin").split("/");
        anios = Integer.parseInt(s[2].toString()) - 1900;
        meses = Integer.parseInt(s[1].toString()) - 1;
        dias = Integer.parseInt(s[0].toString());
        java.sql.Date fecha2 = new Date(anios, meses, dias);
        c.setFechaFin(fecha2);
        c.setEstado(Boolean.parseBoolean(request.getParameter("txtEstadoActividad")));
        c.setConvoId(Integer.parseInt(request.getParameter("idConvocatoria")));
        c.setActiId(Integer.parseInt(request.getParameter("cmbnombreActividad")));


        if (dao.insertarCalendarioConvocatoria(c) != false) {
            hm.put("success", true);
            hm.put("msg", "Se Ingreso Correctamente la Actividad");
        } else {
            hm.put("success", false);
            hm.put("msg", "Hubo un Problema al Insertar la Actividad");
        }

        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void listarCalendarioConvocatoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json ");

        CalendarioConvocatoriaDao dao = new CalendarioConvocatoriaDao();
        Gson g = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        int id = request.getParameter("idConvocatoria") == null ? 0 : Integer.parseInt(request.getParameter("idConvocatoria"));
        HashMap hm = new HashMap();
        hm.put("query", "%" + query + "%");
        hm.put("limit", limit);
        hm.put("start", start);
        hm.put("convoId", id);

        List<CalendarioConvocatoria> list = dao.listarCalendarioConvocatoriaForAdmin(hm);
        hm.put("calendario", list);
        hm.put("total", dao.listarTotalConvocatoriaBienForAdmin(hm));
        hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = g.toJson(hm);

        response.getWriter().print(arg);
    }

    private void listarCalendarioConvocatoriaForWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        CalendarioConvocatoriaDao calendario = new CalendarioConvocatoriaDao();
        try {
            List<CalendarioConvocatoria> dato = calendario.listarCalendarioConvocatoriaForWeb(Integer.parseInt(request.getParameter("convo_id")));
            String result = null;
            for (CalendarioConvocatoria cronograma : dato) {
                result = "<tr><td>" + cronograma.getActividad().getDescripcion() + "</td><td align='center'>" + cronograma.getFechaInicio().toString().split("-")[2] + "/" + cronograma.getFechaInicio().toString().split("-")[1] + "/" + cronograma.getFechaInicio().toString().split("-")[0] + "</td><td align='center'>" + cronograma.getFechaFin().toString().split("-")[2] + "/" + cronograma.getFechaFin().toString().split("-")[1] + "/" + cronograma.getFechaFin().toString().split("-")[0] + "</td></tr>";
                out.print(result);
            }
            if (dato.isEmpty()) {
                out.print("<tr><td colspan='3' style='text-align: center; height: 50px;'>¡Aun No Se A Programado Un Cronograma!, Vuelva A Intentar Más Tarde</td></tr>");
            }
        } catch (Exception e) {
            out.print(e.getMessage());
        } finally {
            out.close();
        }
    }

    private void estadoConvocatoriaBien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ConvocatoriaDao dao = new ConvocatoriaDao();
        HashMap hm = new HashMap();
        HashMap p = new HashMap();
        Gson g = new Gson();
        Boolean estado = false;
        if ("false".equals(request.getParameter("estado"))) {
            estado = true;
        }
        p.put("estado", estado);
        p.put("convoId", Integer.parseInt(request.getParameter("idConvocatoria")));
        if (dao.estadoConvocatoriaBien(p)) {
            hm.put("success", true);
            hm.put("msg", "La convocatoria se Cambió de Estado ");
        } else {
            hm.put("success ", false);
            hm.put("msg", "Hubo Un Problema al cambiar el estado ");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void eliminarConvocatoriaBien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ConvocatoriaDao dao = new ConvocatoriaDao();
        HashMap hm = new HashMap();
        Gson g = new Gson();
        if (!dao.hasChildrenConvocatoriaBien(Integer.parseInt(request.getParameter("idConvocatoria")))) {
            if (dao.eliminarConvocatoriaBien(Integer.parseInt(request.getParameter("idConvocatoria")))) {
                hm.put("success", true);
                hm.put("msg", "La Convocatoria se Eliminó correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo Un Problema al Eliminar La Convocatoria");
            }
        } else {
            hm.put("success", false);
            hm.put("msg", "El La Convocatoria Tiene Cronograma de Actividades Asignados");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

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

    ////OTROOSSS
    private void actualizarFinalObra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson g = new Gson();
        HashMap hm = new HashMap();
        ResolucionGerencial bean = new ResolucionGerencial();

        Boolean flag = true;
        if ("0".equals(request.getParameter("op"))) {
            bean = new ArcDigDao().obtenerBean(Integer.parseInt(request.getParameter("id")));

            bean.setTitulo(bean.getTitulo().replace(".PDF", ""));
            bean.setFechaDocx(bean.getFecha());
            bean.setActivo(true);
            bean.setEstado(false);
            bean.setCateId(Integer.parseInt(request.getParameter("cate_id")));
            
            flag = new ResolucionObraDao().insert(bean);
        } else {
            bean.setTitulo(request.getParameter("titulo") == null ? "" : request.getParameter("titulo"));
            bean.setId(request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id")));
            bean.setResumen(request.getParameter("descripcion") == null ? "" : request.getParameter("descripcion"));
            bean.setCateId(Integer.parseInt(request.getParameter("cate_id")));
            
            flag = new ResolucionObraDao().update(bean);
        }
        hm.put("success", flag);
        if (flag) {
            hm.put("msg", "La Operaci&#243;n Fu&#233; Exitoso");
        } else {
            hm.put("msg", "Ya hay un registro con este Nombre");
        }

        hm.put("success", flag);
        response.getWriter().print(g.toJson(hm));
    }

    private void getDocumento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        Gson g = new Gson();
        try {
            ResolucionGerencial bean = new ResolucionObraDao().obtenerBean(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("cate_id")));
            response.getWriter().print(g.toJson(bean));
        } catch (NullPointerException ex) {
            response.getWriter().print("Intento Fallido");
        }
    }

    private void actualizarExonerado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson g = new Gson();
        HashMap hm = new HashMap();
        Exonerado bean = new Exonerado();
        Boolean flag = true;
        try {
            bean.setFecha(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fecha")));
            bean.setAnho(request.getParameter("fecha").split("/")[2]);
            bean.setCausa(request.getParameter("causa"));
            bean.setObjeto(request.getParameter("objeto"));
            bean.setDescripcion(request.getParameter("descripcion"));
            bean.setMonto(request.getParameter("monto"));
            bean.setContratista(request.getParameter("contratista"));
            bean.setRuc(request.getParameter("ruc"));
            bean.setUrl(request.getParameter("url"));
            bean.setId(Integer.parseInt(request.getParameter("id")));
            bean.setNroExonerado(request.getParameter("nro_exonerado"));

            if ("0".equals(request.getParameter("op"))) {
                flag = new ExoneradoDao().insert(bean);
            } else {
                flag = new ExoneradoDao().update(bean);
            }
            if (flag) {
                hm.put("msg", "La Operaci&#243;n Fu&#233; Exitoso");
            } else {
                hm.put("msg", "Ya hay un registro con este Nombre");
            }
        } catch (ParseException ex) {
            hm.put("msg", "El formato de Fecha Ingresado no  es la correcta intente con dia/mes/año");
            flag = false;
        }

        hm.put("success", flag);
        response.getWriter().print(g.toJson(hm));
    }

    private void getExonerado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        Gson g = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        try {
            Exonerado bean = new ExoneradoDao().obtenerBean(Integer.parseInt(request.getParameter("id")));
            response.getWriter().print(g.toJson(bean));
        } catch (NullPointerException ex) {
            response.getWriter().print("Intento Fallido");
        }
    }

    private void actualizarPenalidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson g = new Gson();
        HashMap hm = new HashMap();
        Penalidad bean = new Penalidad();
        Boolean flag = true;


        bean.setAnho(request.getParameter("anho"));
        bean.setMontoContrato(request.getParameter("monto_contrato"));
        bean.setObjeto(request.getParameter("objeto"));
        bean.setNroProceso(request.getParameter("nro_proceso"));
        bean.setMontoPenalidad(request.getParameter("monto_penalidad"));
        bean.setContratista(request.getParameter("contratista"));
        bean.setRuc(request.getParameter("ruc"));
        bean.setNroContrato(request.getParameter("nro_contrato"));
        bean.setTipo(request.getParameter("tipo"));

        bean.setId(Integer.parseInt(request.getParameter("id")));

        if ("0".equals(request.getParameter("op"))) {
            flag = new PenalidadDao().insert(bean);
        } else {
            flag = new PenalidadDao().update(bean);
        }
        if (flag) {
            hm.put("msg", "La Operaci&#243;n Fu&#233; Exitoso");
        } else {
            hm.put("msg", "Ya hay un registro con este Nombre");
        }


        hm.put("success", flag);
        response.getWriter().print(g.toJson(hm));
    }

    private void getPenalidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        Gson g = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        try {
            Penalidad bean = new PenalidadDao().obtenerBean(Integer.parseInt(request.getParameter("id")));
            response.getWriter().print(g.toJson(bean));
        } catch (NullPointerException ex) {
            response.getWriter().print("Intento Fallido");
        }
    }
}
