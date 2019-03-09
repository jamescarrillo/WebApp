/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gob.peam.administracion.dao.SesionDao;
import gob.peam.beans.*;
import gob.peam.dao.ActividadDao;
import gob.peam.dao.CalendarioConvocatoriaDao;
import gob.peam.dao.ConvocatoriaDao;
import gob.peam.dao.DocumentoConvocatoriaDao;
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
@WebServlet(name = "ConvocatoriaPers", urlPatterns = {"/ConvocatoriaPers"})
public class ConvocatoriaPersServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (action) {
            case "":
                index(request, response);
                break;
            case "ListarConvocatoriaPers":
                listarConvocatoriaPers(request, response);
                break;
            case "ListarCalendarioConvocatoriaPers":
                listarCalendarioConvocatoriaPers(request, response);
                break;
            case "InsertarConvocatoriaPers":
                insertarConvocatoriaPers(request, response);
                break;
            case "InsertarNombreActividad":
                insertarNombreActividad(request, response);
                break;
            case "InsertarDocumentoPers":
                insertarDocumentoPers(request, response);
                break;
            case "BuscarConvocatoriaPers":
                buscarConvocatoriaPers(request, response);
                break;
            case "ActualizarConvocatoriaPers":
                actualizarConvocatoriaPers(request, response);
                break;
            case "ActualizarCalendarioConvocatoriaPers":
                actualizarCalendarioConvocatoriaPers(request, response);
                break;
            case "ActualizarNombreActividad":
                actualizarNombreActividad(request, response);
                break;
            case "eliminarConvocatoriaPers":
                eliminarConvocatoriaPers(request, response);
                break;
            case "estadoConvocatoriaPers":
                estadoConvocatoriaPers(request, response);
                break;
            case "ListarActividadPers":
                listarActividadPers(request, response);
                break;
            case "buscarCalendarioConvocatoriaPers":
                buscarCalendarioConvocatoriaPers(request, response);
                break;
            case "insertarCalendarioConvocatoriaPers":
                insertarCalendarioConvocatoriaPers(request, response);
                break;
            case "insertarPlazaConvocatoria":
                insertarPlazaConvocatoria(request, response);
                break;
            case "listarCalendarioConvocatoriaPersForWeb":
                listarCalendarioConvocatoriaPersForWeb(request, response);
                break;
            case "listarDocumentoConvocatoria":
                listarDocumentoConvocatoria(request, response);
                break;
            case "listarDocumentoConvocatoriaForWeb":
                listarDocumentoConvocatoriaForWeb(request, response);
                break;
            case "listarPlazaConvocatoriaForAdmin":
                listarPlazaConvocatoriaForAdmin(request, response);
                break;
            case "listarPlazaConvocatoriaForWeb":
                listarPlazaConvocatoriaForWeb(request, response);
                break;
            case "EliminarNombreActividad":
                eliminarNombreActividad(request, response);
                break;
            case "EliminarCalendarioConvocatoria":
                eliminarCalendarioConvocatoria(request, response);
                break;
            case "EliminarDocumentoConvocatoria":
                eliminarDocumentoConvocatoria(request, response);
                break;
            case "EliminarPlazaConvocatoria":
                eliminarPlazaConvocatoria(request, response);
                break;
            case "ModificarPlazaConvocatoria":
                modificarPlazaConvocatoria(request, response);
                break;
            case "ConvocatoriaPers":
                convocatoriaPers(request, response);
                break;
        }
    }

    /**
     * ****************************************Convocatoria
     * PErSonal************************************************************
     */
    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!new SesionDao().verificarSesion(request, response)) {
            response.sendRedirect("./Login");
        } else {
            request.getRequestDispatcher("./WEB-INF/intranet/web/convocatoriapers.jsp").forward(request, response);
        }
    }

    private void convocatoriaPers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./WEB-INF/convocatorias/convocatoria.jsp").forward(request, response);
    }

    private void listarDocumentoConvocatoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DocumentoConvocatoriaDao dao = new DocumentoConvocatoriaDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        int id = request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id"));

        HashMap hm = new HashMap();
        hm.put("actiId", id);
        hm.put("query", "%" + query + "%");
        hm.put("order", "desc");
        hm.put("limit", limit);
        hm.put("start", start);
        List<DocumentoConvocatoria> list = dao.listDocumentoConvocotariaForAdmin(hm);
        HashMap outHash = new HashMap();
        outHash.put("items", list);
        outHash.put("total", dao.listTotalDocumentoConvocatoriaForAdmin(hm));
        outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = gson.toJson(outHash);
        out.print(arg);
    }

    private void listarConvocatoriaPers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        ConvocatoriaDao dao = new ConvocatoriaDao();
        Gson g = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        HashMap hm = new HashMap();
        hm.put("query", "%" + query + "%");
        hm.put("limit", limit);
        hm.put("start", start);
        List<ConvocatoriaPers> list = dao.listarConvocatoriaPersForAdmin(hm);
        hm.put("items", list);
        hm.put("total", dao.listarTotalConvocatoriaPersForAdmin(hm));
        hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void insertarConvocatoriaPers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        ConvocatoriaDao dao = new ConvocatoriaDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        ConvocatoriaPers m = new ConvocatoriaPers();
        Date d = new Date(new java.util.Date().getTime());
        m.setAnho(String.valueOf(d.getYear() + 1900));
        m.setFecha(d);
        m.setDescripcion(request.getParameter("txtSintesisConvocatoriaPers"));
        m.setConvocatoria(request.getParameter("txtConvocatoriaPers"));
        m.setEstado(Boolean.parseBoolean(request.getParameter("txtEstadoConvocatoriaPers")));

        if (dao.insertarConvocatoriaPers(m)) {
            hm.put("success", true);
            hm.put("msg", "La Convocatoria se insert&oacute; correctamente");
        } else {
            hm.put("success", false);
            hm.put("msg", "Hubo un problema al insertar la convocatoria");
        }

        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void insertarDocumentoPers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        DocumentoConvocatoriaDao dao = new DocumentoConvocatoriaDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        DocumentoConvocatoria m = new DocumentoConvocatoria();

        m.setNombre(request.getParameter("titulo"));
        m.setUrlFile(request.getParameter("archivo"));
        m.setEstado(true);
        m.setId(Integer.parseInt(request.getParameter("codigo")));
        if (dao.insertarDocumentoConvocatoria(m)) {
            hm.put("success", true);
            hm.put("msg", "La convocatoria se insert&oacute; correctamente");
        } else {
            hm.put("success", false);
            hm.put("msg", "Hubo un problema al insertar la convocatoria");
        }

        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void buscarConvocatoriaPers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        ConvocatoriaDao dao = new ConvocatoriaDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        ConvocatoriaPers m = dao.buscarConvocatoriaPers(Integer.parseInt(request.getParameter("id")));
        hm.put("convocatoria", m);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void buscarCalendarioConvocatoriaPers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        CalendarioConvocatoriaDao dao = new CalendarioConvocatoriaDao();
        CalendarioConvocatoria m = dao.buscarCalendarioConvocatoriaPers(Integer.parseInt(request.getParameter("id")));
        HashMap hm = new HashMap();
        hm.put("calendario", m);
        Gson g = new Gson();
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void actualizarConvocatoriaPers(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        ConvocatoriaDao dao = new ConvocatoriaDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        ConvocatoriaPers m = new ConvocatoriaPers();
        Date d = new Date(new java.util.Date().getTime());
        m.setAnho(String.valueOf(d.getYear() + 1900));
        m.setFecha(d);
        m.setDescripcion(request.getParameter("txtSintesisConvocatoriaPers"));
        m.setConvocatoria(request.getParameter("txtConvocatoriaPers"));
        m.setEstado(Boolean.parseBoolean(request.getParameter("txtEstadoConvocatoriaPers")));
        m.setCoperId(Integer.parseInt(request.getParameter("idConvocatoriaPers")));
        if (dao.actualizarConvocatoriaPers(m)) {
            hm.put("success", true);
            hm.put("msg",
                    "La actualizaci&oacute;n de la convocatoria se realiz&oacute; Correctamente ");
        } else {
            hm.put("success ", false);
            hm.put("msg", "Hubo un problema al actualizar la convocatoria");
        }

        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void actualizarCalendarioConvocatoriaPers(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
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
            hm.put("msg", "La actualizaci&oacute;n de la actividad se realiz&oacute; correctamente ");
        } else {
            hm.put("success ", false);
            hm.put("msg", "Hubo un problema al actualizar la actividad");
        }

        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void listarActividadPers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ActividadDao dao = new ActividadDao();
        String result = "";
        Integer coperId = Integer.parseInt(request.getParameter("idConvocatoriaPers"));
        Integer actiId = request.getParameter("idActividad") == null ? 0 : Integer.parseInt(request.getParameter("idActividad"));

        HashMap h = new HashMap();
        h.put("coperId", coperId);
        if (actiId != 0) {
            h.put("filter", "and acti_id != " + actiId);
        } else {
            h.put("filter", "");
        }
        for (Actividad actividad : dao.listarActividadPers(h)) {
            result += "<option value='" + actividad.getActiId() + "'>" + actividad.getDescripcion() + "</option>";
        }
        response.getWriter().print(result);
    }

    private void insertarCalendarioConvocatoriaPers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
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
        c.setConvoId(Integer.parseInt(request.getParameter("idConvocatoriaPers")));
        c.setActiId(Integer.parseInt(request.getParameter("cmbnombreActividad")));

        if (dao.insertarCalendarioConvocatoriaPers(c) != false) {
            hm.put("success", true);
            hm.put("msg", "Se ingreso correctamente la actividad");
        } else {
            hm.put("success", false);
            hm.put("msg", "Hubo un problema al insertar la actividad");
        }

        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void insertarPlazaConvocatoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        HashMap hm = new HashMap();
        Gson g = new Gson();
        ConvocatoriaDao dao = new ConvocatoriaDao();
        PlazaConvocatoria c = new PlazaConvocatoria();
        c.setCargo(request.getParameter("txtCargo"));
        c.setIngreMensual(request.getParameter("txtCostoMensual"));
        c.setModalidad(request.getParameter("txtModalidad"));
        c.setIngreMensual(request.getParameter("txtCostoMensual"));
        c.setNroPlaza(1);
        c.setCoperId(Integer.parseInt(request.getParameter("idConvocatoriaPers")));
        c.setEstado(true);

        if (dao.insertarPlazaConvocatoria(c) != false) {
            hm.put("success", true);
            hm.put("msg", "Se ingreso correctamente la plaza");
        } else {
            hm.put("success", false);
            hm.put("msg", "Hubo un problema al insertar la plaza");
        }

        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void insertarNombreActividad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        HashMap hm = new HashMap();
        Gson g = new Gson();
        ActividadDao dao = new ActividadDao();
        Actividad a = new Actividad();
        a.setDescripcion(request.getParameter("descripcion"));
        a.setActiTipo(Integer.parseInt(request.getParameter("tipo")));
        if (dao.insertarActividadPers(a) != false) {
            hm.put("success", true);
            hm.put("msg", "Se ingreso correctamente la actividad");
        } else {
            hm.put("success", false);
            hm.put("msg", "Hubo un problema al insertar la actividad");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void actualizarNombreActividad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        HashMap hm = new HashMap();
        Gson g = new Gson();
        ActividadDao dao = new ActividadDao();
        Actividad a = new Actividad();
        a.setDescripcion(request.getParameter("descripcion"));
        a.setActiId(Integer.parseInt(request.getParameter("id")));
        if (dao.actualizarActividad(a) != false) {
            hm.put("success", true);
            hm.put("msg", "Se actualizo correctamente la actividad");
        } else {
            hm.put("success", false);
            hm.put("msg", "Hubo un problema al actualizar la actividad");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void listarCalendarioConvocatoriaPers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");

        CalendarioConvocatoriaDao dao = new CalendarioConvocatoriaDao();
        Gson g = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        int id = request.getParameter("idConvocatoriaPers") == null ? 0 : Integer.parseInt(request.getParameter("idConvocatoriaPers"));
        HashMap hm = new HashMap();
        hm.put("query", "%" + query + "%");
        hm.put("limit", limit);
        hm.put("start", start);
        hm.put("coperId", id);

        List<CalendarioConvocatoria> list = dao.listarCalendarioConvocatoriaPersForAdmin(hm);
        hm.put("calendario", list);
        hm.put("total", dao.listarTotalConvocatoriaPersForAdmin(hm));
        hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = g.toJson(hm);

        response.getWriter().print(arg);
    }

    private void listarPlazaConvocatoriaForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        ConvocatoriaDao dao = new ConvocatoriaDao();
        Gson g = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").toUpperCase().trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        int id = request.getParameter("idConvocatoriaPers") == null ? 0 : Integer.parseInt(request.getParameter("idConvocatoriaPers"));
        HashMap hm = new HashMap();
        hm.put("query", "%" + query + "%");
        hm.put("limit", limit);
        hm.put("start", start);
        hm.put("coperId", id);

        List<PlazaConvocatoria> list = dao.listarPlazaConvocatoriaForAdmin(hm);
        hm.put("plaza", list);
        hm.put("total", dao.listarTotalPlazaConvocatoriaForAdmin(hm));
        hm.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = g.toJson(hm);

        response.getWriter().print(arg);
    }

    private void listarCalendarioConvocatoriaPersForWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        CalendarioConvocatoriaDao calendario = new CalendarioConvocatoriaDao();
        try {
            List<CalendarioConvocatoria> dato = calendario.listarCalendarioConvocatoriaPersForWeb(Integer.parseInt(request.getParameter("convo_id")));
            String result = null;
            DocumentoConvocatoriaDao doc = new DocumentoConvocatoriaDao();
            Integer index_z = 0;
            String clase = "green";
            String nombre = "ver docs";
            for (CalendarioConvocatoria cronograma : dato) {
                if (doc.TotalDocumentoConvocatoriaForWeb(cronograma.getId()) == 0) {
                    clase = "gray";
                    nombre = "vacio";
                } else {
                    clase = "green";
                    nombre = "ver docs";
                }

                result = "<tr><td width='35%'>" + cronograma.getActividad().getDescripcion() + "</td><td width='20%' style='text-align: center'>" + cronograma.getFechaInicio().toString().split("-")[2] + "/" + cronograma.getFechaInicio().toString().split("-")[1] + "/" + cronograma.getFechaInicio().toString().split("-")[0] + "</td><td width='20%' style='text-align: center'>" + cronograma.getFechaFin().toString().split("-")[2] + "/" + cronograma.getFechaFin().toString().split("-")[1] + "/" + cronograma.getFechaFin().toString().split("-")[0] + "</td><td width='30%' style='text-align: center'><label data-index='" + index_z + "' style='cursor:pointer;  text-align:center;' data='" + cronograma.getId() + "' title='Click para ver los Documentos en la tabla inferior' class='detal button " + clase + "'>" + nombre + "</label></td></tr>";
                index_z++;
                out.print(result);
            }
            if (dato.isEmpty()) {
                out.print("<tr><td colspan='5' style='text-align: center; height: 50px;'>¡Aun no se ha programado un cronograma! Vuelva a intentar más tarde</td></tr>");
            }
        } catch (Exception e) {
            out.print(e.getMessage());
        } finally {
            out.close();
        }
    }

    private void listarPlazaConvocatoriaForWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ConvocatoriaDao dao = new ConvocatoriaDao();
        try {
            List<PlazaConvocatoria> dato = dao.listarTotalPlazaConvocatoriaForWeb(request.getParameter("coper_id") == null ? 0 : Integer.parseInt(request.getParameter("coper_id")));
            String result = null;
            Integer index_z = 0;
            for (PlazaConvocatoria p : dato) {
                result = "<tbody><tr><th colspan=2 style='color: #fff;'>Plaza</th></tr><tr><td>Cargo: </td><td>" + p.getCargo() + "</td></tr>"
                        + "<tr><td>Ingreso Mensual: </td><td>" + p.getIngreMensual() + "</td></tr>"
                        + "<tr><td>Modalidad: </td><td>" + p.getModalidad() + "</td></tr>"
                        + "<tr><td>Vacantes: </td><td>" + p.getNroPlaza() + "</td></tr></tbody>";
                index_z++;
                out.print(result);
            }
        } catch (Exception e) {
            out.print(e.getMessage());
        } finally {
            out.close();
        }
    }

    private void listarDocumentoConvocatoriaForWeb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DocumentoConvocatoriaDao doc = new DocumentoConvocatoriaDao();
        try {
            List<DocumentoConvocatoria> dato = doc.listarDocumentoConvocatoriaForWeb(request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id")));
            String result = "";

            for (DocumentoConvocatoria doco : dato) {
                result = "<tr><td>" + doco.getNombre() + "</td><td style='text-align: center;'><a class='green button' title='Descargar archivo haciendo click' target='_blank' href='archivos/" + doco.getUrlFile() + "' >Descargar</a></td></tr>";
                out.print(result);
            }
            if (result.isEmpty()) {
                out.print("<tr><td colspan='2' style='text-align: center; height: 50px;'>¡Aun no se han subido documentos! Vuelva a intentar más tarde</td></tr>");
            }
        } catch (Exception e) {
            out.print(e.getMessage());
        }

    }

    private void estadoConvocatoriaPers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        ConvocatoriaDao dao = new ConvocatoriaDao();
        HashMap hm = new HashMap();
        HashMap p = new HashMap();
        Gson g = new Gson();
        Boolean estado = false;
        if ("false".equals(request.getParameter("estado"))) {
            estado = true;
        }
        p.put("estado", estado);
        p.put("coperId", Integer.parseInt(request.getParameter("idConvocatoriaPers")));
        if (dao.estadoConvocatoriaPers(p)) {
            hm.put("success", true);
            hm.put("msg", "La convocatoria se cambió de estado ");
        } else {
            hm.put("success ", false);
            hm.put("msg", "Hubo un problema al cambiar el estado ");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void eliminarConvocatoriaPers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        ConvocatoriaDao dao = new ConvocatoriaDao();
        HashMap hm = new HashMap();
        Gson g = new Gson();
        if (!dao.hasChildrenConvocatoriaPers(Integer.parseInt(request.getParameter("id")))) {
            if (dao.eliminarConvocatoriaPers(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", true);
                hm.put("msg", "La convocatoria se eliminó correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo un problema al eliminar la convocatoria");
            }
        } else {
            hm.put("success", false);
            hm.put("msg", "La Convocatoria tiene cronograma de actividades asignados (dependencias)");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void eliminarNombreActividad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        ActividadDao dao = new ActividadDao();
        HashMap hm = new HashMap();
        Gson g = new Gson();
        if (dao.eliminarActividad(Integer.parseInt(request.getParameter("id")))) {
            hm.put("success", true);
            hm.put("msg", "La actividad se eliminó correctamente");
        } else {
            hm.put("success", false);
            hm.put("msg", "No se puede eliminar porque tiene Dependencias");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void eliminarCalendarioConvocatoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        CalendarioConvocatoriaDao dao = new CalendarioConvocatoriaDao();
        HashMap hm = new HashMap();
        Gson g = new Gson();
        hm.put("id", Integer.parseInt(request.getParameter("id")));
        hm.put("tipo", Integer.parseInt(request.getParameter("tipo")));

        if (dao.eliminarCalendarioConvocatoria(hm)) {
            hm.put("success", true);
            hm.put("msg", "La atividad de la convocatoria se eliminó correctamente");
        } else {
            hm.put("success", false);
            hm.put("msg", "No se puede eliminar tiene Dependencias");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void eliminarDocumentoConvocatoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        DocumentoConvocatoriaDao dao = new DocumentoConvocatoriaDao();
        HashMap hm = new HashMap();
        Gson g = new Gson();
        if (dao.eliminarDocumentoConvocatoria(Integer.parseInt(request.getParameter("id")))) {
            hm.put("success", true);
            hm.put("msg", "El documento de la actividad se eliminó correctamente");
        } else {
            hm.put("success", false);
            hm.put("msg", "No se puede eliminar, Error");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void eliminarPlazaConvocatoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        ConvocatoriaDao dao = new ConvocatoriaDao();
        HashMap hm = new HashMap();
        Gson g = new Gson();
        if (dao.eliminarPlazaConvocatoria(Integer.parseInt(request.getParameter("id")))) {
            hm.put("success", true);
            hm.put("msg", "La Plaza se eliminó correctamente");
        } else {
            hm.put("success", false);
            hm.put("msg", "No se puede eliminar, Error");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void modificarPlazaConvocatoria(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        ConvocatoriaDao dao = new ConvocatoriaDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();

        PlazaConvocatoria bean = new PlazaConvocatoria();

        bean.setPuesId(request.getParameter("idPlaza") == null ? 0 : Integer.parseInt(request.getParameter("idPlaza")));
        bean.setCargo(request.getParameter("txtCargo") == null ? "" : request.getParameter("txtCargo"));
        bean.setModalidad(request.getParameter("txtModalidad") == null ? "" : request.getParameter("txtModalidad"));
        bean.setIngreMensual(request.getParameter("txtCostoMensual") == null ? "" : request.getParameter("txtCostoMensual"));
        bean.setNroPlaza(request.getParameter("txtNroPlaza") == null ? 1 : Integer.parseInt(request.getParameter("txtNroPlaza")));
        if (dao.actualizarPlazaPers(bean)) {
            hm.put("success", true);
            hm.put("msg", "La actualizaci&oacute;n de la plaza se realiz&oacute; correctamente ");
        } else {
            hm.put("success ", false);
            hm.put("msg", "Hubo un problema al actualizar la plaza");
        }

        String arg = g.toJson(hm);
        response.getWriter().print(arg);
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
}
