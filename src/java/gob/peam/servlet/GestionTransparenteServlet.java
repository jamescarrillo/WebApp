/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gob.peam.beans.*;
import gob.peam.dao.*;
import java.io.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author jprada
 */
@WebServlet(name = "GestionTransparente", urlPatterns = {"/GestionTransparente"})
public class GestionTransparenteServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String respuesta = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (respuesta) {
            case "":
                index(request, response);
                break;
            case "AdquisicionesContrataciones":
                adquisicionesContrataciones(request, response);
                break;
            case "RecursosHumanos":
                recursosHumanos(request, response);
                break;
            case "AgendaInstitucional":
                agendaInstitucional(request, response);
                break;
            case "infoAdicional":
                infoAdicional(request, response);
                break;
            case "DocumentoGestion":
                documentoGestion(request, response);
                break;
            case "DocumentoGestionAdmin":
                documentoGestionAdmin(request, response);
                break;
            case "NormasDirectivas":
                normasDirectivas(request, response);
                break;
            case "NormaDirectiva":
                normaDirectiva(request, response);
                break;
            case "NormaDirectivaAdmin":
                normaDirectivaAdmin(request, response);
                break;
            case "PresupuestoFinanzas":
                presupuestoFinanzas(request, response);
                break;
            case "ResolucionesGerenciales":
                resolucionesGerenciales(request, response);
                break;
            case "ResolucionGerencial":
                resolucionGerencial(request, response);
                break;
            case "ResolucionGerencialAdmin":
                resolucionGerencialAdmin(request, response);
                break;
            case "ProyectoInversion":
                proyectoInversion(request, response);
                break;
            case "ListarViaticos":
                listarViaticos(request, response);
                break;
            case "ListarViaticosForAdmin":
                listarViaticosForAdmin(request, response);
                break;
            case "ComprasBienes":
                comprasBienes(request, response);
                break;
            case "ComprasBienesForAdmin":
                comprasBienesForAdmin(request, response);
                break;
            case "ComprasServicios":
                comprasServicios(request, response);
                break;
            case "ComprasServiciosForAdmin":
                comprasServiciosForAdmin(request, response);
                break;
            case "Publicidad":
                publicidad(request, response);
                break;
            case "PublicidadForAdmin":
                publicidadForAdmin(request, response);
                break;
            case "Telefonia":
                telefonia(request, response);
                break;
            case "Vehiculo":
                vehiculo(request, response);
                break;
            case "Proveedor":
                proveedor(request, response);
                break;
            case "PersonalPlanilla":
                personalPlanilla(request, response);
                break;
            case "PersonalSNP":
                personalSNP(request, response);
                break;
            case "PersonalCAS":
                personalCAS(request, response);
                break;
            case "PersonalCategoria":
                personalCategoria(request, response);
                break;
            case "Funcionario":
                funcionario(request, response);
                break;
            case "FuncionarioDirectorio":
                funcionarioDirectorio(request, response);
                break;
            case "Directivo":
                directivo(request, response);
                break;
            case "ListarAnhosComprasBienes":
                listarAnhosComprasBienes(request, response);
                break;
            case "ListarAnhosComprasServicios":
                listarAnhosComprasServicios(request, response);
                break;
            case "ListarAnhosPublicidad":
                listarAnhosPublicidad(request, response);
                break;
            case "ListarAnhosTelefonia":
                listarAnhosTelefonia(request, response);
                break;
            case "ListarAnhosVehiculo":
                listarAnhosVehiculo(request, response);
                break;
            case "ListarAnhosProveedor":
                listarAnhosProveedor(request, response);
                break;
            case "ListarAnhosPersonalPlanilla":
                listarAnhosPersonalPlanilla(request, response);
                break;
            /*case "ListarAnhosPersonalPlanilla2":
                listarAnhosPersonalPlanilla2(request, response);
                break;*/
            case "ListarAnhosPersonalSNP":
                listarAnhosPersonalSNP(request, response);
                break;
            case "ListarAnhosPersonalCAS":
                listarAnhosPersonalCAS(request, response);
                break;
            case "ListarAnhosPersonalCategoria":
                listarAnhosPersonalCategoria(request, response);
                break;
            case "ListarAnhosPersonalDis":
                listarAnhosPersonalDis(request, response);
                break;
            case "ListarAnhosResolucionGerencial":
                listarAnhosResolucionGerencial(request, response);
                break;
            case "ListarAnhosViatico":
                listarAnhosViatico(request, response);
                break;
            case "ListarAnhosPresupuesto":
                listarAnhosPresupuesto(request, response);
                break;
            case "ListarAnhosFinanza":
                listarAnhosFinanza(request, response);
                break;
            case "ListarMesPresupuesto":
                listarMesPresupuesto(request, response);
                break;
            case "ListarMesOrdenCompra":
                listarMesOrdenCompra(request, response);
                break;
            case "ListarMesOrdenServicio":
                ListarMesOrdenServicio(request, response);
                break;
            case "ListarMesViatico":
                ListarMesViatico(request, response);
                break;
            case "ListarMesTelefonia":
                ListarMesTelefonia(request, response);
                break;
            case "ListarMesVehiculo":
                ListarMesVehiculo(request, response);
                break;
            case "ListarTrimestreProveedor":
                ListarTrimestreProveedor(request, response);
                break;
            case "ListarTrimestrePersonal":
                ListarTrimestrePersonal(request, response);
                break;
           case "ListarTrimestrePersonal2":
                ListarTrimestrePersonal2(request, response);
               break;
            case "ListarTrimestreCategoria":
                ListarTrimestreCategoria(request, response);
                break;

            case "ListarAgendaInstitucional":
                listarAgenda(request, response);
                break;
            case "getFuncionarioForFlowChart":
                getFuncionarioForFlowChart(request, response);
                break;
            case "verResolucion":
                verResolucion(request, response);
                break;
            case "verDocumentosGestion":
                verDocumentosGestion(request, response);
                break;
            case "verNormaDirectiva":
                verNormaDirectiva(request, response);
                break;
            case "verDocumentosGestionPublico":
                verDocumentoGestionPublico(request, response);
                break;
            case "insertDocumentosGestionPublico":
                insertDocumentosGestionPublico(request, response);
                break;
            case "SincronizarDoc":
                sincronizarDoc(request, response);
                break;
            case "listarCategoriaDocumento":
                listarCategoriaDocumentoGestion(request, response);
                break;
            case "listarPresupuesto":
                listarPresupuesto(request, response);
                break;
            case "listarFinanza":
                listarFinanza(request, response);
                break;
            case "CargarArchivo":
                cargarArchivo(request, response);
                break;
            case "ImportarComprasBienes":
                importarComprasBienes(request, response);
                break;
            case "VolcarTemporalOrden":
                volcarTemporalOrden(request, response);
                break;
            case "VolcarTemporalServicio":
                volcarTemporalServicio(request, response);
                break;
            case "ImportarServicios":
                importarServicios(request, response);
                break;
            case "ImportarPublicidad":
                importarPublicidad(request, response);
                break;
            case "VolcarTemporalPublicidad":
                volcarTemporalPublicidad(request, response);
                break;
            case "ImportarTelefonia":
                importarTelefonia(request, response);
                break;
            case "VolcarTemporalTelefonia":
                volcarTemporalTelefonia(request, response);
                break;
            case "ImportarVehiculo":
                importarVehiculo(request, response);
                break;
            case "VolcarTemporalVehiculo":
                volcarTemporalVehiculo(request, response);
                break;
            case "ImportarProveedor":
                importarProveedor(request, response);
                break;
            case "VolcarTemporalProveedor":
                volcarTemporalProveedor(request, response);
                break;
            case "VolcarTemporalViatico":
                volcarTemporalViatico(request, response);
                break;
            case "ImportarViatico":
                importarViatico(request, response);
                break;
            case "insertPIA":
                insertPIA(request, response);
                break;
            case "activarPresupuesto":
                activarPresupuesto(request, response);
                break;
            case "eliminarPresupuesto":
                eliminarPresupuesto(request, response);
                break;
            case "PresupuestoFinanzasArcDig":
                presupuestoFinanzasArcDig(request, response);
                break;
            case "ActualizarFinanzas":
                actualizarFinanzas(request, response);
                break;
            case "ActualizarPublicaciones":
                actualizarPublicaciones(request, response);
                break;
            case "activarFinanza":
                activarFinanza(request, response);
                break;
            case "eliminarFinanza":
                eliminarFinanza(request, response);
                break;
            case "insertEFF":
                insertEFF(request, response);
                break;
            case "insertMEMO":
                insertMEMO(request, response);
                break;
            case "EliminarOrdenCompra":
                eliminarOrdenCompra(request, response);
                break;
            case "EliminarOrdenServicio":
                eliminarOrdenServicio(request, response);
                break;
            case "EliminarTelefonia":
                eliminarTelefonia(request, response);
                break;
            case "EliminarProveedor":
                eliminarProveedor(request, response);
                break;
            case "EliminarPublicidad":
                eliminarPublicidad(request, response);
                break;
            case "EliminarVehiculo":
                eliminarVehiculo(request, response);
                break;
            case "EliminarViatico":
                eliminarViatico(request, response);
                break;
            case "EliminarPublicicaciones":
                eliminarPublicaciones(request, response);
                break;
            case "eliminarDocumento":
                eliminarResolucion(request, response);
                break;
            case "ObtenerGerente":
                obtenerGerente(request, response);
                break;
            case "ListarAgendaForAdmin":
                listarAgendaForAdmin(request, response);
                break;
            case "ActualizarActividadAgenda":
                actualizarActividadAgenda(request, response);
                break;
            case "BuscarActividadAgenda":
                buscarActividadAgenda(request, response);
                break;
            case "EliminarActividadAgenda":
                eliminarActividadAgenda(request, response);
                break;
            case "EstadoActividadAgenda":
                estadoActividadAgenda(request, response);
                break;
            case "ListarFuncionarioForAdmin":
                listarFuncionarioForAdmin(request, response);
                break;
            case "ActualizarFuncionario":
                actualizarFuncionario(request, response);
                break;
            case "BuscarFuncionario":
                buscarFuncionario(request, response);
                break;
            case "EliminarFuncionario":
                eliminarFuncionario(request, response);
                break;
            case "EstadoFuncionario":
                estadoFuncionario(request, response);
                break;
            case "ListarDirectivoForAdmin":
                listarDirectivoForAdmin(request, response);
                break;
            case "ActualizarDirectivo":
                actualizarDirectivo(request, response);
                break;
            case "BuscarDirectivo":
                buscarDirectivo(request, response);
                break;
            case "EliminarDirectivo":
                eliminarDirectivo(request, response);
                break;
            case "EstadoDirectivo":
                estadoDirectivo(request, response);
                break;
            case "ListarPersonalForAdmin":
                listarPersonalForAdmin(request, response);
                break;
            case "ListarPersonalForDis":
                listarPersonalForDis(request, response);
                break;
            case "ImportarPersonalPlanilla":
                importarPersonal(request, response);
                break;
            case "VolcarTemporalPersonal":
                volcarTemporalPersonal(request, response);
                break;
            case "EliminarPersonal":
                eliminarPersonal(request, response);
                break;
            case "PersonalPrint":
                personalPrint(request, response);
                break;
            case "ImportarPersonalLocador":
                importarPersonalLocador(request, response);
                break;
            case "ImportarPersonalCAS":
                importarPersonalCAS(request, response);
                break;
            case "ImportarPersonalCategoria":
                importarPersonalCategoria(request, response);
                break;
            case "VolcarTemporalPersonalCategoria":
                volcarTemporalPersonalCategoria(request, response);
                break;
            case "EliminarPersonalCategoria":
                eliminarPersonalCategoria(request, response);
                break;
            case "TelefoniaForAdmin":
                telefoniaForAdmin(request, response);
                break;
            case "VehiculoForAdmin":
                vehiculoForAdmin(request, response);
                break;
            case "ActualizarGlosario":
                actualizarGlosario(request, response);
                break;
            case "GetGlosario":
                getGlosario(request, response);
                break;
            case "ActualizarSB":
                actualizarSB(request, response);
                break;
            case "GetSaldoBalance":
                getSaldoBalance(request, response);
                break;
            case "PublicarSB":
                new FinanzaDao().publicar(Integer.parseInt(request.getParameter("id")));
                break;
                //Nuevo contenido
                 case "LastAgendaInstitucional":
                lastAgenda(request, response);
                break;
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void getFuncionarioForFlowChart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        try {
            HashMap outHash = new HashMap();
            outHash.put("funcionario", funcionarioDao.getFuncionarioFowFlowchart(request.getParameter("organigrama").trim().toUpperCase()));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void obtenerGerente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        try {
            String arg = funcionarioDao.getGerenteForWeb();
            out.print(arg);
        } finally {
            out.close();
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
        request.getRequestDispatcher("./WEB-INF/transparencia/index.jsp").forward(request, response);
    }

    private void adquisicionesContrataciones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/transparencia/contratacion.jsp").forward(request, response);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void comprasBienes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        OrdenCompraDao compraDao = new OrdenCompraDao();
        Gson gson = new Gson();

        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("mes", request.getParameter("mes"));
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<OrdenCompra> list = compraDao.listOrdenCompraForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", compraDao.listTotalOrdenCompraForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void comprasBienesForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        OrdenCompraDao compraDao = new OrdenCompraDao();
        Gson gson = new Gson();

        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<OrdenCompra> list = compraDao.listOrdenCompraForAdmin(hm);
            HashMap outHash = new HashMap();
            outHash.put("ordenCompra", list);
            outHash.put("total", compraDao.listTotalOrdenCompraForAdmin(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void listarAnhosComprasBienes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        OrdenCompraDao compraDao = new OrdenCompraDao();
        String opciones = "";
        for (String object : compraDao.listAnhosCompraForWeb()) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    private void listarAnhosComprasServicios(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        OrdenServicioDao servicioDao = new OrdenServicioDao();
        String opciones = "";
        for (String object : servicioDao.listAnhosServicioForWeb()) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void comprasServicios(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        OrdenServicioDao servicioDao = new OrdenServicioDao();
        Gson gson = new Gson();

        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("mes", request.getParameter("mes"));
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<OrdenServicio> list = servicioDao.listOrdenServicioForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", servicioDao.listTotalOrdenServicioForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void comprasServiciosForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        OrdenServicioDao servicioDao = new OrdenServicioDao();
        Gson gson = new Gson();

        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<OrdenServicio> list = servicioDao.listOrdenServicioForAdmin(hm);
            HashMap outHash = new HashMap();
            outHash.put("servicio", list);
            outHash.put("total", servicioDao.listTotalOrdenServicioForAdmin(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void listarAnhosPublicidad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PublicidadDao publicidadDao = new PublicidadDao();
        String opciones = "";
        for (String object : publicidadDao.listAnhosPublicidadForWeb()) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void publicidad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PublicidadDao publicidadDao = new PublicidadDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<Publicidad> list = publicidadDao.listPublicidadForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", publicidadDao.listTotalPublicidadForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void publicidadForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PublicidadDao publicidadDao = new PublicidadDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<Publicidad> list = publicidadDao.listPublicidadForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", publicidadDao.listTotalPublicidadForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void listarAnhosTelefonia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        TelefoniaDao telefoniaDao = new TelefoniaDao();
        String opciones = "";
        for (String object : telefoniaDao.listAnhosTelefoniaForWeb()) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void telefonia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        TelefoniaDao telefoniaDao = new TelefoniaDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("mes", request.getParameter("mes"));
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<Telefonia> list = telefoniaDao.listTelefoniaForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", telefoniaDao.listTotalTelefoniaForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0
                    : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void telefoniaForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        TelefoniaDao telefoniaDao = new TelefoniaDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("mes", request.getParameter("mes"));
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<Telefonia> list = telefoniaDao.listTelefoniaForAdmin(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", telefoniaDao.listTotalTelefoniaForAdmin(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0
                    : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void listarAnhosVehiculo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        VehiculoDao vehiculoDao = new VehiculoDao();
        String opciones = "";
        for (String object : vehiculoDao.listAnhosVehiculoForWeb()) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void vehiculo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        VehiculoDao vehiculoDao = new VehiculoDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("mes", request.getParameter("mes"));
            hm.put("limit", limit);
            hm.put("start", start);
            List<Vehiculo> list = vehiculoDao.listVehiculoForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", vehiculoDao.listTotalVehiculoForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0
                    : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void vehiculoForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        VehiculoDao vehiculoDao = new VehiculoDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("mes", request.getParameter("mes"));
            hm.put("limit", limit);
            hm.put("start", start);
            List<Vehiculo> list = vehiculoDao.listVehiculoForAdmin(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", vehiculoDao.listTotalVehiculoForAdmin(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0
                    : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void listarAnhosProveedor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProveedorDao proveedorDao = new ProveedorDao();
        String opciones = "";
        for (String object : proveedorDao.listAnhosProveedorForWeb()) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void proveedor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ProveedorDao proveedorDao = new ProveedorDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("trimestre", request.getParameter("trimestre") == null ? "" : request.getParameter("trimestre"));

            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            HashMap outHash = new HashMap();
            if (hm.get("trimestre") != "") {
                outHash.put("items", proveedorDao.listProveedorForWeb(hm));
                outHash.put("total", proveedorDao.listTotalProveedorForWeb(hm));
            } else {
                outHash.put("items", proveedorDao.listProveedorForAdmin(hm));
                outHash.put("total", proveedorDao.listTotalProveedorForAdmin(hm));
            }
            outHash.put("pagina", request.getParameter("current") == null ? 0
                    : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void recursosHumanos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/transparencia/rrhh.jsp").forward(request, response);
    }

    private void listarAnhosPersonalPlanilla(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonalDao personalPlanillaDao = new PersonalDao();
        String opciones = "";
        for (String object : personalPlanillaDao.listAnhoPersonalForWeb(Integer.parseInt(request.getParameter("tipo")))) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }
    
  /*  private void listarAnhosPersonalPlanilla2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonalDao personalPlanillaDao = new PersonalDao();
        String opciones = "";
        for (String object : personalPlanillaDao.listAnhoPersonalForWeb2(Integer.parseInt(request.getParameter("tipo")))) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }*/

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void personalPlanilla(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PersonalPlanillaDao personalPlanillaDao = new PersonalPlanillaDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("query", "%" + query + "%");
            hm.put("order", "asc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<PersonalPlanilla> list = personalPlanillaDao.listPersonalPlanillaForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total",
                    personalPlanillaDao.listTotalPersonalPlanillaForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void personalSNP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PersonalSNPDao personalSNPDao = new PersonalSNPDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("query", "%" + query + "%");
            hm.put("order", "asc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<PersonalSNP> list = personalSNPDao.listPersonalSNPForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", personalSNPDao.listTotalPersonalSNPForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void listarAnhosPersonalSNP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonalSNPDao personalSNPDao = new PersonalSNPDao();
        String opciones = "";
        for (String object : personalSNPDao.listAnhosPersonalSNPForWeb()) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void personalCAS(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PersonalCASDao personalCASDao = new PersonalCASDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("query", "%" + query + "%");
            hm.put("order", "asc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<PersonalCAS> list = personalCASDao.listPersonalCASForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", personalCASDao.listTotalPersonalCASForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void listarAnhosPersonalCAS(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonalCASDao personalCASDao = new PersonalCASDao();
        String opciones = "";
        for (String object : personalCASDao.listAnhosPersonalCASForWeb()) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }
    
    /**/
    @SuppressWarnings({"unchecked", "rawtypes"})
    private void personalDis(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PersonalDisDao personalDisDao = new PersonalDisDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("query", "%" + query + "%");
            hm.put("order", "asc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<PersonalDis> list = personalDisDao.listPersonalDisForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", personalDisDao.listTotalPersonalDisForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void listarAnhosPersonalDis(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonalDisDao personalDisDao = new PersonalDisDao();
        String opciones = "";
        for (String object : personalDisDao.listAnhosPersonalDisForWeb()) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }
    /**/
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    private void directivo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DirectivoDao directivoDao = new DirectivoDao();
        Gson gson = new Gson();
        try {
            List<Directivo> list = directivoDao.listDirectivoForWeb();
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void funcionario(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        FuncionarioDao directivoDao = new FuncionarioDao();
        Gson gson = new Gson();
        try {
            List<Funcionario> list = directivoDao.listFuncionarioForWeb();
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void funcionarioDirectorio(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        FuncionarioDao directivoDao = new FuncionarioDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("query", "%" + query + "%");
            hm.put("order", "asc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<Funcionario> list = directivoDao.listFuncionarioDirectorioForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", directivoDao.listFuncionarioDirectorioTotalForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void listarAnhosPersonalCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonalCategoriaDao personalCategoriaDao = new PersonalCategoriaDao();
        String opciones = "";
        for (String object : personalCategoriaDao.listAnhosPersonalCategoriaForWeb()) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void personalCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PersonalCategoriaDao personalCategoriaDao = new PersonalCategoriaDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("trimestre", request.getParameter("trimestre") == null ? 0 : Integer.parseInt(request.getParameter("trimestre")));
            hm.put("query", "%" + query + "%");
            hm.put("order", "asc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<PersonalCategoria> list = personalCategoriaDao.listPersonalCategoriaForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", personalCategoriaDao.listTotalPersonalCategoriaForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void agendaInstitucional(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/transparencia/agenda.jsp").forward(request, response);
    }

    private void infoAdicional(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/transparencia/infoAdicional.jsp").forward(request, response);
    }

    private void normasDirectivas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/transparencia/normasDirectivas.jsp").forward(request, response);
    }

    private void presupuestoFinanzas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/transparencia/presupuestoFinanzas.jsp").forward(request, response);
    }

    private void resolucionesGerenciales(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/transparencia/resolucionesGerenciales.jsp").forward(request, response);
    }

    private void proyectoInversion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/transparencia/proyectos.jsp").forward(request, response);
    }

    private void listarAnhosResolucionGerencial(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ResolucionGerencialDao resolucionGerencialDao = new ResolucionGerencialDao();
        String opciones = "";
        for (String object : resolucionGerencialDao.listAnhosResolucionGerencialForWeb()) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    private void listarCategoriaDocumentoGestion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DocumentoGestionDao documentoGestionDao = new DocumentoGestionDao();
        HashMap h = new HashMap();

        h.put("tido_id", Integer.parseInt(request.getParameter("tipo")));
        List<CategoriaDocumento> list = null;
        list = documentoGestionDao.listCategoriaDocumento(h);
        Gson gson = new Gson();
        HashMap hashMapOut = new HashMap();
        hashMapOut.put("items", list);
        String arg = gson.toJson(hashMapOut);
        out.print(arg);
    }

    private void sincronizarDoc(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Gson gson = new Gson();
        DocumentoGestionDao datadao = new DocumentoGestionDao();

        String arg = gson.toJson(datadao.sincronizarDocumentos(Integer.parseInt(request.getParameter("id"))));
        out.print(arg);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void resolucionGerencial(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ResolucionGerencialDao resolucionGerencialDao = new ResolucionGerencialDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<ResolucionGerencial> list = resolucionGerencialDao.listResolucionGerencialForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", resolucionGerencialDao.listTotalResolucionGerencialForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void resolucionGerencialAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ResolucionGerencialDao resolucionGerencialDao = new ResolucionGerencialDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));

        HashMap hm = new HashMap();
        hm.put("anio", request.getParameter("anho"));
        hm.put("query", "%" + query + "%");
        hm.put("order", "desc");
        hm.put("limit", limit);
        hm.put("start", start);
        List<ResolucionGerencial> list = resolucionGerencialDao.listResolucionGerencialForAdmin(hm);
        HashMap outHash = new HashMap();
        outHash.put("items", list);
        outHash.put("total", resolucionGerencialDao.listTotalResolucionGerencialForAdmin(hm));
        outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = gson.toJson(outHash);
        out.print(arg);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void listarAgenda(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        AgendaDao agendaDao = new AgendaDao();
        Gson gson = new Gson();
        String yyyy = request.getParameter("anho");
        String mm = request.getParameter("mes");
        String dd = request.getParameter("dia");
        if (Integer.parseInt(dd) < 10) {
            dd = "0" + dd;
        }
        if (Integer.parseInt(mm) < 10) {
            mm = "0" + mm;
        }
        try {
            HashMap hm = new HashMap();
            hm.put("fechaFiltro", yyyy + '-' + mm + '-' + dd);
            hm.put("tipo", Integer.parseInt(request.getParameter("tipo")));

            HashMap outHash = new HashMap();
            outHash.put("items", agendaDao.listAgendaDayForWeb(hm));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    private void lastAgenda(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        AgendaDao agendaDao = new AgendaDao();
        Gson gson = new Gson();
       
        try {
            HashMap hm = new HashMap();
            hm.put("tipo", Integer.parseInt(request.getParameter("tipo")));
            HashMap outHash = new HashMap();
            outHash.put("agenda", agendaDao.lastAgendaForWeb(hm));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void listarAnhosViatico(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ViaticoDao viaticoDao = new ViaticoDao();
        String opciones = "";
        for (String object : viaticoDao.listAnhosViaticoForWeb()) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void listarViaticos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ViaticoDao viaticoDao = new ViaticoDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("query", "%" + query + "%");
            hm.put("mes", request.getParameter("mes"));
            hm.put("order", "asc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<Viatico> list = viaticoDao.listViaticoForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", viaticoDao.listTotalViaticoForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void listarViaticosForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ViaticoDao viaticoDao = new ViaticoDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("anio", request.getParameter("anho"));
            hm.put("query", "%" + query + "%");

            hm.put("order", "asc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<Viatico> list = viaticoDao.listViaticoForAdmin(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", viaticoDao.listTotalViaticoForAdmin(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void verDocumentoGestionPublico(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        PrintWriter out = response.getWriter();
        DocumentoGestionDao dataDao = new DocumentoGestionDao();
        Documentos dataBean = dataDao.buscarDocumentoGestionForWeb(id);
        Gson gson = new Gson();
        HashMap hm = new HashMap();
        try {
            hm.put("cateId", dataBean.getCateId());
            hm.put("descripcion", dataBean.getDescripcion());
            hm.put("resumen", dataBean.getResumen());
            hm.put("fechaDocx", dataBean.getFecha());
            hm.put("activo", dataBean.getActivo());
            String arg = gson.toJson(hm);

            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void verResolucion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        response.sendRedirect("http://lib.peam.gob.pe:8081/ArcDig/OriArc.pdf?id=" + id);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void documentoGestion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DocumentoGestionDao documentoGestionDao = new DocumentoGestionDao();
        Gson gson = new Gson();
        String filter = request.getParameter("cateId") == null ? "" : request.getParameter("cateId") == "" ? "" : "and cate_id = " + Integer.parseInt(request.getParameter("cateId"));
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));

        HashMap hm = new HashMap();
        hm.put("filter", filter);
        hm.put("query", "%" + query + "%");
        hm.put("order", "asc");
        hm.put("limit", limit);
        hm.put("start", start);
        List<DocumentoGestion> list = documentoGestionDao.listDocumentoGestionForWeb(hm);
        HashMap outHash = new HashMap();
        outHash.put("items", list);
        outHash.put("total", documentoGestionDao.listTotalDocumentoGestionForWeb(hm));
        outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = gson.toJson(outHash);
        out.print(arg);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void documentoGestionAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DocumentoGestionDao documentoGestionDao = new DocumentoGestionDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));

        HashMap hm = new HashMap();
        hm.put("query", "%" + query + "%");
        hm.put("order", "asc");
        hm.put("limit", limit);
        hm.put("start", start);
        List<DocumentoGestion> list = documentoGestionDao.listDocumentoGestionForAdmin(hm);
        HashMap outHash = new HashMap();
        outHash.put("items", list);
        outHash.put("total", documentoGestionDao.listTotalDocumentoGestionForAdmin(hm));
        outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = gson.toJson(outHash);
        out.print(arg);
    }

    private void verDocumentosGestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        response.sendRedirect("http://lib.peam.gob.pe:8081/ArcDig/OriArc.pdf?id=" + id);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void normaDirectiva(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        NormaDirectivaDao normasDirectivasDao = new NormaDirectivaDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("query", "%" + query + "%");
            hm.put("order", "asc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<NormaDirectiva> list = normasDirectivasDao.listNormasDirectivasForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", normasDirectivasDao.listTotalNormasDirectivasForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void normaDirectivaAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        NormaDirectivaDao normasDirectivasDao = new NormaDirectivaDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        HashMap hm = new HashMap();
        hm.put("query", "%" + query + "%");
        hm.put("order", "asc");
        hm.put("limit", limit);
        hm.put("start", start);
        List<NormaDirectiva> list = normasDirectivasDao.listNormasDirectivasForAdmin(hm);
        HashMap outHash = new HashMap();
        outHash.put("items", list);
        outHash.put("total", normasDirectivasDao.listTotalNormasDirectivasForAdmin(hm));
        outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
        String arg = gson.toJson(outHash);
        out.print(arg);
    }

    private void verNormaDirectiva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        response.sendRedirect("http://lib.peam.gob.pe:8081/ArcDig/OriArc.pdf?id=" + id);
    }

    private void insertDocumentosGestionPublico(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");
            Gson g = new Gson();
            String msn = null;
            String title = null;
            String image = null;
            HashMap hm = new HashMap();
            int cate = request.getParameter("CmbCateDocument") == null ? 0 : Integer.parseInt(request.getParameter("CmbCateDocument"));
            int tidoid = request.getParameter("tidoid") == null ? 0 : Integer.parseInt(request.getParameter("tidoid"));
            DocumentoGestionDao dao = new DocumentoGestionDao();
            Documentos dataBean = new Documentos();
            dataBean.setId(Integer.parseInt(request.getParameter("id").toString()));
            dataBean.setDescripcion(request.getParameter("descripcion"));
            dataBean.setTitulo(request.getParameter("titulo"));
            dataBean.setResumen(request.getParameter("resumen"));
            dataBean.setOrigenArchivo(request.getParameter("origenArchivo"));
            dataBean.setTidoId(tidoid);
            dataBean.setFechaDocx(request.getParameter("fechadocx"));
            dataBean.setCateId(cate);
            dataBean.setEstado(true);
            if ("false".equals(request.getParameter("activocheck"))) {
                dataBean.setActivo(false);
            } else {
                dataBean.setActivo(true);
            }
            //dataBean.setActivo(Boolean.parseBoolean(request.getParameter("activocheck")));
            if (!"0".equals(request.getParameter("tidoid"))) {
                if (dao.insertDocumentoGestionPublico(dataBean)) {
                    image = "./resources/images/dialog-information.png";
                    title = "La Operación Fué Un Exito!";
                    msn = "Se Ha Publicado el Documento de Gestion con exito de nombre: <br/>" + request.getParameter("titulo");
                } else {
                    image = "./resources/images/dialog-warning.png";
                    title = "La Operación Falló!";
                    msn = "No se Pudo Publicar el Documento de Gestion, itentelo mas tarde";
                }
            } else if (dao.actualizarDocumentoGestionPublico(dataBean)) {
                image = "./resources/images/dialog-information.png";
                title = "La Operación Fué Un Exito!";
                msn = "Se Ha Actualizado el Documento de Gestión con exito de nombre: <br/>" + request.getParameter("titulo");
            } else {
                image = "./resources/images/dialog-warning.png";
                title = "La Operación Falló!";
                msn = "No se Pudo Actualizar el Documento de Gestion, itentelo mas tarde";
            }

            Gson gson = new Gson();
            HashMap hashMapOut = new HashMap();
            hashMapOut.put("msn", msn);
            hashMapOut.put("title", title);
            hashMapOut.put("image", image);
            String arg = gson.toJson(hashMapOut);
            out.print(arg);
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void listarPresupuesto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PresupuestoDao dao = new PresupuestoDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        int tipo = request.getParameter("tipo") == null ? 0 : Integer.parseInt(request.getParameter("tipo"));
        String qAnho = request.getParameter("anho") == null ? "" : "".equals(request.getParameter("anho")) ? "" : " and anho = '" + request.getParameter("anho") + "'";
        String qMes = request.getParameter("mes") == null ? "" : "".equals(request.getParameter("mes")) ? "" : " and substring(cast(fecha_aprobacion as character(10)) from 6)::character(2) = '" + request.getParameter("mes") + "'";
        if (tipo == 1) {
            qAnho = "";
            qMes = "";
        }
        try {
            HashMap hm = new HashMap();
            hm.put("anho", qAnho);
            hm.put("mes", qMes);
            hm.put("tipo", tipo);
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<Presupuesto> list = dao.listarPresupuestoForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", dao.listTotalPresupuestoForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void listarAnhosPresupuesto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PresupuestoDao dao = new PresupuestoDao();
        String opciones = "";
        for (String object : dao.listAnhosPresupuestoForWeb()) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    private void listarMesPresupuesto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PresupuestoDao dao = new PresupuestoDao();
        String anho = request.getParameter("anho") == null ? "" : "".equals(request.getParameter("anho")) ? "" : request.getParameter("anho");
        String opciones = "";
        for (String object : dao.listMesPresupuestoForWeb(anho)) {
            opciones += "<option>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    private void listarMesOrdenCompra(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        OrdenCompraDao dao = new OrdenCompraDao();
        String anho = request.getParameter("anho") == null ? "" : "".equals(request.getParameter("anho")) ? "" : request.getParameter("anho");
        String opciones = "";
        for (String object : dao.listMesOrdenCompraForWeb(anho)) {
            opciones += "<option class='mesComprasBienes'>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    private void ListarMesOrdenServicio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        OrdenServicioDao dao = new OrdenServicioDao();
        String anho = request.getParameter("anho") == null ? "" : "".equals(request.getParameter("anho")) ? "" : request.getParameter("anho");
        String opciones = "";
        for (String object : dao.listMesOrdenServicioForWeb(anho)) {
            opciones += "<option class='mesComprasServicios'>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    private void ListarMesTelefonia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        TelefoniaDao dao = new TelefoniaDao();
        String anho = request.getParameter("anho") == null ? "" : "".equals(request.getParameter("anho")) ? "" : request.getParameter("anho");
        String opciones = "";
        for (String object : dao.listMesTelefoniaForWeb(anho)) {
            opciones += "<option class='mesTelefonia'>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    private void ListarMesViatico(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ViaticoDao dao = new ViaticoDao();
        String anho = request.getParameter("anho") == null ? "" : "".equals(request.getParameter("anho")) ? "" : request.getParameter("anho");
        String opciones = "";
        for (String object : dao.listMesViaticoForWeb(anho)) {
            opciones += "<option class='mesViatico'>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }
    
  /* private void ListarMesPersonal(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonalDao dao = new PersonalDao();
        String anho = request.getParameter("anho") == null ? "" : "".equals(request.getParameter("anho")) ? "" : request.getParameter("anho");
        String opciones = "";
        for (String object : dao.listMesPersonalForWeb(anho)) {
            opciones += "<option class='mesPersonal'>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }*/
    
    

    private void ListarMesVehiculo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        VehiculoDao dao = new VehiculoDao();
        String anho = request.getParameter("anho") == null ? "" : "".equals(request.getParameter("anho")) ? "" : request.getParameter("anho");
        String opciones = "";
        for (String object : dao.listMesVehiculoForWeb(anho)) {
            opciones += "<option class='mesVehiculo'>" + object + "</option>";
        }
        response.getWriter().print(opciones);
    }

    private void ListarTrimestreProveedor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProveedorDao dao = new ProveedorDao();
        String anho = request.getParameter("anho") == null ? "" : "".equals(request.getParameter("anho")) ? "" : request.getParameter("anho");
        String opciones = "";
        String trimestre = "";
        
        for (String object : dao.listTrimestreProveedorForWeb(anho)) {

            switch (object) {
                case "1":
                    trimestre = "Primer";
                    break;
                case "2":
                    trimestre = "Segundo";
                    break;
                case "3":
                    trimestre = "Tercer";
                    break;
                case "4":
                    trimestre = "Cuarto";
                    break;
            }
            opciones += "<option value=" + object + ">" + trimestre + "</option>";
        }
        response.getWriter().print(opciones);
    }

    private void ListarTrimestrePersonal2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonalDao dao = new PersonalDao();
        String anho = request.getParameter("anho") == null ? "" : "".equals(request.getParameter("anho")) ? "" : request.getParameter("anho");
        Integer tipo = request.getParameter("tipo") == null ? 0 : Integer.parseInt(request.getParameter("tipo"));
        Integer num;
        HashMap hm = new HashMap();
        hm.put("anho", anho);
        hm.put("tipo", tipo);

        String opciones = "";
        String trimestre = "";
        num = Integer.parseInt(anho);
        
        //if ("2016".equals(request.getParameter("anho"))) {
         if (num<2016) {  
            for (String object : dao.listTrimestrePersonalForWeb(hm)) {
            switch (object) {
                case "1":
                    trimestre = "Primer Trimestre";
                    break;
                case "2":
                    trimestre = "Segundo Trimestre";
                    break;
                case "3":
                    trimestre = "Tercer Trimestre";
                    break;
                case "4":
                    trimestre = "Cuarto Trimestre";
                    break;                
                    
            }
            opciones += "<option value=" + object + ">" + trimestre + "</option>";
            } 
            response.getWriter().print(opciones);
        } else {
            for (String object : dao.listMesPersonalForWeb(hm)) {
            switch (object) {
                case "1":
                    trimestre = "Enero";
                    break;
                case "2":
                    trimestre = "Febrero";
                    break;
                case "3":
                    trimestre = "Marzo";
                    break;
                case "4":
                    trimestre = "Abril";
                    break;
                case "5":
                    trimestre = "Mayo";
                    break;
                case "6":
                    trimestre = "Junio";
                    break;
                case "7":
                    trimestre = "Julio";
                    break;
                case "8":
                    trimestre = "Agosto";
                    break;
                case "9":
                    trimestre = "Setiembre";
                    break;
                case "10":
                    trimestre = "Octubre";
                    break;
                case "11":
                    trimestre = "Noviembre";
                    break;
                case "12":
                    trimestre = "Diciembre";
                    break;
                    
            }
            opciones += "<option value=" + object + ">" + trimestre + "</option>";
            
        }
        response.getWriter().print(opciones);
    }
    }
    private void ListarTrimestrePersonal(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonalDao dao = new PersonalDao();
        String anho = request.getParameter("anho") == null ? "" : "".equals(request.getParameter("anho")) ? "" : request.getParameter("anho");
        Integer tipo = request.getParameter("tipo") == null ? 0 : Integer.parseInt(request.getParameter("tipo"));
        //Integer num;
        HashMap hm = new HashMap();
        hm.put("anho", anho);
        hm.put("tipo", tipo);

        String opciones = "";
        String trimestre = "";
        //num = Integer.parseInt(anho);
        
        //if ("2016".equals(request.getParameter("anho"))) {
         //if (num<2016) {  
            for (String object : dao.listTrimestrePersonalForWeb(hm)) {
            switch (object) {
                case "1":
                    trimestre = "Primer";
                    break;
                case "2":
                    trimestre = "Segundo";
                    break;
                case "3":
                    trimestre = "Tercer";
                    break;
                case "4":
                    trimestre = "Cuarto";
                    break;                
                    
            }
            opciones += "<option value=" + object + ">" + trimestre + "</option>";
            } 
            response.getWriter().print(opciones);
         
              
    
    }
  private void ListarMesPersonal(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonalDao dao = new PersonalDao();
        String anho = request.getParameter("anho") == null ? "" : "".equals(request.getParameter("anho")) ? "" : request.getParameter("anho");
        Integer tipo = request.getParameter("tipo") == null ? 0 : Integer.parseInt(request.getParameter("tipo"));
        HashMap hm = new HashMap();
        hm.put("anho", anho);
        hm.put("tipo", tipo);

        String opciones = "";
        String trimestre = "";
        for (String object : dao.listMesPersonalForWeb(hm)) {
            switch (object) {
                case "1":
                    trimestre = "Enero";
                    break;
                case "2":
                    trimestre = "Febrero";
                    break;
                case "3":
                    trimestre = "Marzo";
                    break;
                case "4":
                    trimestre = "Abril";
                    break;
                case "5":
                    trimestre = "Mayo";
                    break;
                case "6":
                    trimestre = "Junio";
                    break;
                case "7":
                    trimestre = "Julio";
                    break;
                case "8":
                    trimestre = "Agosto";
                    break;
                case "9":
                    trimestre = "Setiembre";
                    break;
                case "10":
                    trimestre = "Octubre";
                    break;
                case "11":
                    trimestre = "Noviembre";
                    break;
                case "12":
                    trimestre = "Diciembre";
                    break;
                    
            }
            opciones += "<option value=" + object + ">" + trimestre + "</option>";
        }
        response.getWriter().print(opciones);
    }
   
    
    
    private void ListarTrimestreCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PersonalCategoriaDao dao = new PersonalCategoriaDao();
        String anho = request.getParameter("anho") == null ? "" : "".equals(request.getParameter("anho")) ? "" : request.getParameter("anho");
        Integer tipo = request.getParameter("tipo") == null ? 0 : Integer.parseInt(request.getParameter("tipo"));
        HashMap hm = new HashMap();
        hm.put("anho", anho);
        hm.put("tipo", tipo);

        String opciones = "";
        String trimestre = "";
        for (String object : dao.listTrimestreCategoriaForWeb(hm)) {
            switch (object) {
                case "1":
                    trimestre = "Primer";
                    break;
                case "2":
                    trimestre = "Segundo";
                    break;
                case "3":
                    trimestre = "Tercer";
                    break;
                case "4":
                    trimestre = "Cuarto";
                    break;
            }
            opciones += "<option value=" + object + ">" + trimestre + "</option>";
        }
        response.getWriter().print(opciones);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void listarFinanza(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        FinanzaDao dao = new FinanzaDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        int tipo = request.getParameter("tipo") == null ? 0 : Integer.parseInt(request.getParameter("tipo"));
        String qAnho = request.getParameter("anho") == null ? "" : "".equals(request.getParameter("anho")) ? "" : " and anho = '" + request.getParameter("anho") + "'";
        String qMes = request.getParameter("mes") == null ? "" : "".equals(request.getParameter("mes")) ? "" : " and substring(cast(fecha_aprobacion as character(10)) from 6)::character(2) = '" + request.getParameter("mes") + "'";

        try {
            HashMap hm = new HashMap();
            hm.put("anho", qAnho);
            hm.put("mes", qMes);
            hm.put("tipo", tipo);
            hm.put("query", "%" + query + "%");
            hm.put("order", "asc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<Finanza> list = dao.listarFinanzaForWeb(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", dao.listTotalFinanzaForWeb(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void listarAnhosFinanza(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        FinanzaDao dao = new FinanzaDao();
        String opciones = "";
        for (Anho anho : dao.listAnhosFinanzaForWeb(Integer.parseInt(request.getParameter("tipo")))) {
            opciones += "<option>" + anho.getAnho() + "</option>";
        }
        response.getWriter().print(opciones);
    }

    private void importarComprasBienes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String rutaTemporal = getServletContext().getRealPath("/") + "tmp/" + request.getSession().getId() + ".xls";
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(rutaTemporal));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator iterator = sheet.rowIterator();
            List<OrdenCompra> listTpbs = new ArrayList<>();
            OrdenCompraDao orden = new OrdenCompraDao();
            String flag = "";
            HashMap outHash = new HashMap();
            Gson gson = new Gson();
            while (iterator.hasNext()) {//recorremos fila por fila
                HSSFRow row = (HSSFRow) iterator.next();
                if (row.getRowNum() != 0) {//comparamos que no sea la cabecera
                    listTpbs.add(OrdenCompra.load(row));
                } else {
                    try {
                        if ((!"".equals(row.getCell(6).toString()))) {
                            flag = "1";
                            if ((!"".equals(row.getCell(7).toString()))) {
                                outHash.put("errors", 1);
                                outHash.put("items", "");
                                out.print(gson.toJson(outHash));
                                return;
                            }
                        }
                    } catch (NullPointerException ex) {
                        if ("0".equals(flag)) {
                            outHash.put("errors", 1);
                            outHash.put("items", "");
                            out.print(gson.toJson(outHash));
                            return;
                        }
                    }
                }
            }
            if (listTpbs.size() > 0) {//aqui importamos el presupuesto temporal
                HashMap hm = new HashMap();
                List<OrdenCompra> list = orden.importarComprasBienes(listTpbs);
                outHash.put("errors", 0);
                outHash.put("items", list);
                String arg = gson.toJson(outHash);
                out.print(arg);
            }
        } catch (IOException ex) {
            Logger.getLogger(GestionTransparenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void volcarTemporalOrden(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        OrdenCompraDao orden = new OrdenCompraDao();
        HashMap h = new HashMap();
        h.put("anho", request.getParameter("anho") == null ? "" : request.getParameter("anho"));
        h.put("mes", request.getParameter("mes") == null ? "" : request.getParameter("mes"));
        h.put("fuenteFinanciamiento", request.getParameter("fuente") == null ? "" : request.getParameter("fuente"));
        h.put("fecha", request.getParameter("fecha"));
        h.put("proveedor", request.getParameter("proveedor") == null ? "" : request.getParameter("proveedor"));
        h.put("nro", request.getParameter("nro") == null ? "" : request.getParameter("nro"));
        h.put("monto", request.getParameter("monto") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("monto"))));
        h.put("financiamiento", request.getParameter("financiamiento") == null ? "" : request.getParameter("financiamiento"));
        h.put("nroSiaf", request.getParameter("nroSiaf") == null ? "" : request.getParameter("nroSiaf"));
        orden.addItemOrdenCompra(h);
    }

    private void cargarArchivo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String t = request.getParameter("t") == null ? "" : request.getParameter("t");
        FileItemFactory file_factory = new DiskFileItemFactory();// FileItemFactory es una interfaz para crear FileItem
        ServletFileUpload servlet_up = new ServletFileUpload(file_factory); //ServletFileUpload esta clase convierte los input file a FileItem

        try {
            List items = servlet_up.parseRequest(request);
            for (int i = 0; i < items.size(); i++) {
                FileItem item = (FileItem) items.get(i); //FileItem representa un archivo en memoria que puede ser pasado al disco duro
                String rutaTemporal = getServletContext().getRealPath("/") + "tmp/";
                request.getSession().setAttribute("cambioImagen", false);
                if (!item.isFormField()) {
                    if (!item.getContentType().equals("application/vnd.ms-excel")) {
                        response.getWriter().print("<div id='" + t + "' data='no'>Debe Seleccionar el Archivo Correcto</div>");
                    } else {
                        File archivo_server = new File(rutaTemporal + request.getSession().getId() + ".xls");
                        request.getSession().setAttribute("cambioImagen", true);
                        try {
                            item.write(archivo_server);
                        } catch (Exception ex) {
                            Logger.getLogger(GestionTransparenteServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        response.getWriter().print("<div id='" + t + "' data='yes'>Archivo Correcto</div>");
                    }
                }
            }
        } catch (FileUploadException ex) {
            Logger.getLogger(GestionTransparenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void importarServicios(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String rutaTemporal = getServletContext().getRealPath("/") + "tmp/" + request.getSession().getId() + ".xls";
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(rutaTemporal));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator iterator = sheet.rowIterator();
            List<OrdenServicio> listTpbs = new ArrayList<>();
            OrdenServicioDao orden = new OrdenServicioDao();
            String flag = "0";
            HashMap outHash = new HashMap();
            Gson gson = new Gson();
            while (iterator.hasNext()) {//recorremos fila por fila
                HSSFRow row = (HSSFRow) iterator.next();
                if (row.getRowNum() != 0) {//comparamos que no sea la cabecera
                    listTpbs.add(OrdenServicio.load(row));
                } else {
                    try {
                        if ((!"".equals(row.getCell(6).toString()))) {
                            flag = "1";
                            if ((!"".equals(row.getCell(7).toString()))) {
                                outHash.put("errors", 1);
                                outHash.put("items", "");
                                out.print(gson.toJson(outHash));
                                return;
                            }
                        }
                    } catch (NullPointerException ex) {
                        if ("0".equals(flag)) {
                            outHash.put("errors", 1);
                            outHash.put("items", "");
                            out.print(gson.toJson(outHash));
                            return;
                        }
                    }
                }
            }
            if (listTpbs.size() > 0) {//aqui importamos el presupuesto temporal
                List<OrdenServicio> list = orden.importarServicio(listTpbs);
                outHash.put("errors", 0);
                outHash.put("items", list);
                String arg = gson.toJson(outHash);
                out.print(arg);
            }
        } catch (IOException ex) {
            Logger.getLogger(GestionTransparenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void volcarTemporalServicio(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        OrdenServicioDao orden = new OrdenServicioDao();
        HashMap h = new HashMap();
        h.put("anho", request.getParameter("anho") == null ? "" : request.getParameter("anho"));
        h.put("mes", request.getParameter("mes") == null ? "" : request.getParameter("mes"));
        h.put("fuenteFinanciamiento", request.getParameter("fuente") == null ? "" : request.getParameter("fuente"));
        h.put("fecha", request.getParameter("fecha"));
        h.put("proveedor", request.getParameter("proveedor") == null ? "" : request.getParameter("proveedor"));
        h.put("nro", request.getParameter("nro") == null ? "" : request.getParameter("nro"));
        h.put("monto", request.getParameter("monto") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("monto"))));
        h.put("financiamiento", request.getParameter("financiamiento") == null ? "" : request.getParameter("financiamiento"));
        h.put("nroSiaf", request.getParameter("nroSiaf") == null ? "" : request.getParameter("nroSiaf"));
        orden.addItemServicio(h);
    }

    private void importarPublicidad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String rutaTemporal = getServletContext().getRealPath("/") + "tmp/" + request.getSession().getId() + ".xls";
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(rutaTemporal));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator iterator = sheet.rowIterator();
            List<Publicidad> listTpbs = new ArrayList<>();
            PublicidadDao publi = new PublicidadDao();
            HashMap outHash = new HashMap();
            String flag = "0";
            Gson gson = new Gson();
            while (iterator.hasNext()) {//recorremos fila por fila
                HSSFRow row = (HSSFRow) iterator.next();
                if (row.getRowNum() != 0) {//comparamos que no sea la cabecera
                    listTpbs.add(Publicidad.load(row));
                } else {
                    try {
                        if ((!"".equals(row.getCell(12).toString()))) {
                            flag = "1";
                            if ((!"".equals(row.getCell(13).toString()))) {
                                outHash.put("errors", 1);
                                outHash.put("items", "");
                                out.print(gson.toJson(outHash));
                                return;
                            }
                        }
                    } catch (NullPointerException ex) {
                        if ("0".equals(flag)) {
                            outHash.put("errors", 1);
                            outHash.put("items", "");
                            out.print(gson.toJson(outHash));
                            return;
                        }
                    }
                }
            }
            if (listTpbs.size() > 0) {//aqui importamos  temporal
                List<Publicidad> list = publi.importarPublicidad(listTpbs);
                outHash.put("errors", 0);
                outHash.put("items", list);
                String arg = gson.toJson(outHash);
                out.print(arg);
            }
        } catch (IOException ex) {
            Logger.getLogger(GestionTransparenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void volcarTemporalPublicidad(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        PublicidadDao publici = new PublicidadDao();
        HashMap h = new HashMap();
        h.put("anho", request.getParameter("anho") == null ? "" : request.getParameter("anho"));
        h.put("contrato", request.getParameter("contrato") == null ? "" : request.getParameter("contrato"));
        h.put("objetoContrato", request.getParameter("objeto") == null ? "" : request.getParameter("objeto"));
        h.put("fuenteFinanciamiento", request.getParameter("fuente") == null ? "" : request.getParameter("fuente"));
        h.put("ruc", request.getParameter("ruc") == null ? "" : request.getParameter("ruc"));
        h.put("penalidad", request.getParameter("penalidad") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("penalidad"))));
        h.put("costoFinal", request.getParameter("costofinal") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("costofinal"))));
        h.put("proveedor", request.getParameter("proveedor") == null ? "" : request.getParameter("proveedor"));
        h.put("bienesServicios", request.getParameter("bienes") == null ? "" : request.getParameter("bienes"));
        h.put("valorReferencial", request.getParameter("valorReferencial") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("valorReferencial"))));
        h.put("montoContrato", request.getParameter("montoContrato") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("montoContrato"))));
        h.put("proceso", request.getParameter("proceso") == null ? "" : request.getParameter("proceso"));
        h.put("observaciones", request.getParameter("observaciones") == null ? "" : request.getParameter("observaciones"));
        publici.addItemPublicidad(h);
    }

    private void importarTelefonia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String rutaTemporal = getServletContext().getRealPath("/") + "tmp/" + request.getSession().getId() + ".xls";
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(rutaTemporal));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator iterator = sheet.rowIterator();
            List<Telefonia> listTpbs = new ArrayList<>();
            TelefoniaDao tele = new TelefoniaDao();
            HashMap outHash = new HashMap();
            Gson gson = new Gson();
            String flag = "0";
            while (iterator.hasNext()) {//recorremos fila por fila
                HSSFRow row = (HSSFRow) iterator.next();
                if (row.getRowNum() != 0) {//comparamos que no sea la cabecera
                    listTpbs.add(Telefonia.load(row));
                } else {
                    try {
                        if ((!"".equals(row.getCell(7).toString()))) {
                            flag = "1";
                            if ((!"".equals(row.getCell(8).toString()))) {
                                outHash.put("errors", 1);
                                outHash.put("items", "");
                                out.print(gson.toJson(outHash));
                                return;
                            }
                        }
                    } catch (NullPointerException ex) {
                        if ("0".equals(flag)) {
                            outHash.put("errors", 1);
                            outHash.put("items", "");
                            out.print(gson.toJson(outHash));
                            return;
                        }
                    }
                }
            }
            if (listTpbs.size() > 0) {//aqui importamos el presupuesto temporal
                List<Telefonia> list = tele.importarTelefonia(listTpbs);
                outHash.put("errors", 0);
                outHash.put("items", list);
                String arg = gson.toJson(outHash);
                out.print(arg);
            }
        } catch (IOException ex) {
            Logger.getLogger(GestionTransparenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void volcarTemporalTelefonia(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        TelefoniaDao telefonia = new TelefoniaDao();
        HashMap h = new HashMap();
        h.put("anho", request.getParameter("anho") == null ? "" : request.getParameter("anho"));
        h.put("mes", request.getParameter("mes") == null ? "" : request.getParameter("mes"));
        h.put("areaOficina", request.getParameter("area") == null ? "" : request.getParameter("area"));
        h.put("asignadoA", request.getParameter("asignacion") == null ? "" : request.getParameter("asignacion"));
        h.put("cargoActividad", request.getParameter("cargo") == null ? "" : request.getParameter("cargo"));
        h.put("tipo", request.getParameter("tipo") == null ? "" : request.getParameter("tipo"));
        h.put("numero", request.getParameter("numero") == null ? "" : request.getParameter("numero"));
        h.put("importe", request.getParameter("importe") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("importe"))));
        telefonia.addItemTelefonia(h);
    }

    private void importarVehiculo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String rutaTemporal = getServletContext().getRealPath("/") + "tmp/" + request.getSession().getId() + ".xls";
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(rutaTemporal));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator iterator = sheet.rowIterator();
            List<Vehiculo> listTpbs = new ArrayList<>();
            VehiculoDao tele = new VehiculoDao();
            HashMap outHash = new HashMap();
            Gson gson = new Gson();
            String flag = "0";
            while (iterator.hasNext()) {//recorremos fila por fila
                HSSFRow row = (HSSFRow) iterator.next();
                if (row.getRowNum() != 0) {//comparamos que no sea la cabecera
                    listTpbs.add(Vehiculo.load(row));
                } else {
                    try {
                        if ((!"".equals(row.getCell(11).toString()))) {
                            flag = "1";
                            if ((!"".equals(row.getCell(12).toString()))) {
                                outHash.put("errors", 1);
                                outHash.put("items", "");
                                out.print(gson.toJson(outHash));
                                return;
                            }
                        }
                    } catch (NullPointerException ex) {
                        if ("0".equals(flag)) {
                            outHash.put("errors", 1);
                            outHash.put("items", "");
                            out.print(gson.toJson(outHash));
                            return;
                        }
                    }
                }
            }
            if (listTpbs.size() > 0) {//aqui importamos el presupuesto temporal
                List<Vehiculo> list = tele.importarVehiculo(listTpbs);
                outHash.put("errors", 0);
                outHash.put("items", list);
                String arg = gson.toJson(outHash);
                out.print(arg);
            }
        } catch (IOException ex) {
            Logger.getLogger(GestionTransparenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void volcarTemporalVehiculo(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        VehiculoDao vehiculo = new VehiculoDao();
        HashMap h = new HashMap();
        h.put("anho", request.getParameter("anho") == null ? "" : request.getParameter("anho"));
        h.put("mes", request.getParameter("mes") == null ? "" : request.getParameter("mes"));
        h.put("tipoClase", request.getParameter("tipoClase") == null ? "" : request.getParameter("tipoClase"));
        h.put("claseVehiculo", request.getParameter("claseVehiculo") == null ? "" : request.getParameter("claseVehiculo"));
        h.put("asignadoA", request.getParameter("asignadoA") == null ? "" : request.getParameter("asignadoA"));
        h.put("cargoActividad", request.getParameter("cargoActividad") == null ? "" : request.getParameter("cargoActividad"));
        h.put("tipoCombustible", request.getParameter("tipoCombustible") == null ? "" : request.getParameter("tipoCombustible"));
        h.put("recorridoKm", request.getParameter("recorridoKm") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("recorridoKm"))));
        h.put("costoCombustible", request.getParameter("costoCombustible") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("costoCombustible"))));
        h.put("soatFechaVencimiento", request.getParameter("fecha") == null ? "0001-01-01" : request.getParameter("fecha"));
        h.put("placa", request.getParameter("placa") == null ? "" : request.getParameter("placa"));
        h.put("observaciones", request.getParameter("observaciones") == null ? "" : request.getParameter("observaciones"));
        vehiculo.addItemVehiculo(h);
    }

    private void importarProveedor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String rutaTemporal = getServletContext().getRealPath("/") + "tmp/" + request.getSession().getId() + ".xls";
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(rutaTemporal));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator iterator = sheet.rowIterator();
            List<Proveedor> listTpbs = new ArrayList<>();
            ProveedorDao tele = new ProveedorDao();
            HashMap outHash = new HashMap();
            Gson gson = new Gson();
            String flag = "0";

            while (iterator.hasNext()) {
                HSSFRow row = (HSSFRow) iterator.next();
                if (row.getRowNum() != 0) {
                    listTpbs.add(Proveedor.load(row));
                } else {
                    try {
                        if ((!"".equals(row.getCell(4).toString()))) {
                            flag = "1";
                            if ((!"".equals(row.getCell(5).toString()))) {
                                outHash.put("errors", 1);
                                outHash.put("items", "");
                                out.print(gson.toJson(outHash));
                                return;
                            }
                        }
                    } catch (NullPointerException ex) {
                        if ("0".equals(flag)) {
                            outHash.put("errors", 1);
                            outHash.put("items", "");
                            out.print(gson.toJson(outHash));
                            return;
                        }
                    }
                }
            }
            if (listTpbs.size() > 0) {
                List<Proveedor> list = tele.importarProveedor(listTpbs);
                outHash.put("errors", 0);
                outHash.put("items", list);
                String arg = gson.toJson(outHash);
                out.print(arg);
            }
        } catch (IOException ex) {
            Logger.getLogger(GestionTransparenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void volcarTemporalProveedor(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        ProveedorDao proveedor = new ProveedorDao();
        HashMap h = new HashMap();
        h.put("anho", request.getParameter("anho") == null ? "" : request.getParameter("anho"));
        h.put("trimestre", request.getParameter("trimestre") == null ? "" : request.getParameter("trimestre"));
        h.put("ruc", request.getParameter("ruc") == null ? "" : request.getParameter("ruc"));
        h.put("proveedor", request.getParameter("proveedor") == null ? "" : request.getParameter("proveedor"));
        h.put("importe", request.getParameter("importe") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("importe"))));
        proveedor.addItemProveedor(h);
    }

    private void importarViatico(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String rutaTemporal = getServletContext().getRealPath("/") + "tmp/" + request.getSession().getId() + ".xls";
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(rutaTemporal));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator iterator = sheet.rowIterator();
            List<Viatico> listTpbs = new ArrayList<>();
            ViaticoDao via = new ViaticoDao();
            HashMap outHash = new HashMap();
            Gson gson = new Gson();
            String flag = "0";
            while (iterator.hasNext()) {
                HSSFRow row = (HSSFRow) iterator.next();
                if (row.getRowNum() != 0) {
                    listTpbs.add(Viatico.load(row));
                } else {
                    try {
                        if ((!"".equals(row.getCell(13).toString()))) {
                            flag = "1";
                            if ((!"".equals(row.getCell(14).toString()))) {
                                outHash.put("errors", 1);
                                outHash.put("items", "");
                                out.print(gson.toJson(outHash));
                                return;
                            }
                        }
                    } catch (NullPointerException ex) {
                        if ("0".equals(flag)) {
                            outHash.put("errors", 1);
                            outHash.put("items", "");
                            out.print(gson.toJson(outHash));
                            return;
                        }
                    }
                }
            }
            if (listTpbs.size() > 0) {
                List<Viatico> list = via.importarViatico(listTpbs);
                outHash.put("errors", 0);
                outHash.put("items", list);
                String arg = gson.toJson(outHash);
                out.print(arg);
            }
        } catch (IOException ex) {
            Logger.getLogger(GestionTransparenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void volcarTemporalViatico(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ViaticoDao viatico = new ViaticoDao();
        HashMap h = new HashMap();
        h.put("anho", request.getParameter("anho") == null ? "" : request.getParameter("anho"));
        h.put("mes", request.getParameter("anho") == null ? "" : request.getParameter("mes"));
        h.put("tipoViatico", request.getParameter("tipoViatico") == null ? "" : request.getParameter("tipoViatico"));
        h.put("modalidad", request.getParameter("modalidad") == null ? "" : request.getParameter("modalidad"));
        h.put("areaOficina", request.getParameter("areaOficina") == null ? "" : request.getParameter("areaOficina"));
        h.put("usuarios", request.getParameter("usuarios") == null ? "" : request.getParameter("usuarios"));
        h.put("fuenteFinanciamiento", request.getParameter("fuenteFinanciamiento") == null ? "" : request.getParameter("fuenteFinanciamiento"));
        h.put("fechaSalida", request.getParameter("fechaSalida") == null ? "" : request.getParameter("fechaSalida"));
        h.put("fechaRetorno", request.getParameter("fechaRetorno") == null ? "" : request.getParameter("fechaRetorno"));
        h.put("ruta", request.getParameter("ruta") == null ? "" : request.getParameter("ruta"));
        h.put("autorizacionViaje", request.getParameter("autorizacionViaje") == null ? "" : request.getParameter("autorizacionViaje"));
        h.put("costoPasajes", request.getParameter("costoPasajes") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("costoPasajes"))));
        h.put("viaticos", request.getParameter("viaticos") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("viaticos"))));
        viatico.addItemViatico(h);
        Gson g = new Gson();
        PrintWriter out = response.getWriter();
        String arg = g.toJson(h);
        out.print(arg);
    }

    private void insertPIA(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");
            Gson g = new Gson();
            String msn = null;
            String title = null;
            String image = null;

            HashMap hm = new HashMap();
            PresupuestoDao dao = new PresupuestoDao();
            Presupuesto dataBean = new Presupuesto();
            int id = 0;
            if (!"".equals(request.getParameter("id"))) {
                id = Integer.parseInt(request.getParameter("id"));
            }
            String[] s = request.getParameter("fecha").split("/");
            int anios = Integer.parseInt(s[2].toString()) - 1900;
            int meses = Integer.parseInt(s[1].toString()) - 1;
            int dias = Integer.parseInt(s[0].toString());
            java.sql.Date fecha1 = new Date(anios, meses, dias);
            dataBean.setFechaAprobacion(fecha1.toString());
            dataBean.setDescripcion(request.getParameter("descripcion"));
            dataBean.setResolucionAprobacion(request.getParameter("aprobado"));
            dataBean.setAnho(s[2].toString());
            dataBean.setUbicacion(request.getParameter("archivo"));
            dataBean.setId(id);
            dataBean.setDocuId(Integer.parseInt(request.getParameter("arcDigId")));
            dataBean.setTipo(Integer.parseInt(request.getParameter("tabla")));

            dataBean.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
            if ("0".equals(request.getParameter("opt"))) {
                if (dao.insertarPresupuesto(dataBean)) {
                    image = "./resources/images/dialog-information.png";
                    title = "La Operación Fué Un Exito!";
                    msn = "Se Ha Publicado una Nueva PIA con exito de nombre: <br/>" + request.getParameter("titulo");
                } else {
                    image = "./resources/images/dialog-warning.png";
                    title = "La Operación Falló!";
                    msn = "No se Pudo Publicar el PIA,  itentelo mas tarde";
                }
            } else if (dao.actualizarPresupuesto(dataBean)) {
                image = "./resources/images/dialog-information.png";
                title = "La Operación Fué Un Exito!";
                msn = "Se Ha Actualizado el PIA con exito de nombre: <br/>" + request.getParameter("titulo");
            } else {
                image = "./resources/images/dialog-warning.png";
                title = "La Operación Falló!";
                msn = "No se Pudo Actualizar el PIA, itentelo mas tarde";
            }
            Gson gson = new Gson();
            HashMap hashMapOut = new HashMap();
            hashMapOut.put("msn", msn);
            hashMapOut.put("title", title);
            hashMapOut.put("image", image);
            String arg = gson.toJson(hashMapOut);
            out.print(arg);
        }
    }

    private void insertEFF(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");
            Gson g = new Gson();
            String msn = null;
            String title = null;
            String image = null;

            HashMap hm = new HashMap();
            FinanzaDao dao = new FinanzaDao();
            Finanza dataBean = new Finanza();
            int id = 0;
            if (!"".equals(request.getParameter("id"))) {
                id = Integer.parseInt(request.getParameter("id"));
            }
            String[] s = request.getParameter("fecha").split("/");

            dataBean.setDescripcion(request.getParameter("descripcion"));
            dataBean.setAnho(s[2].toString());
            dataBean.setMes(s[1].toString());
            dataBean.setUbicacion("");
            dataBean.setId(id);
            dataBean.setDocuId(Integer.parseInt(request.getParameter("arcDigId")));
            dataBean.setTipo(Integer.parseInt(request.getParameter("tabla")));

            dataBean.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
            if ("0".equals(request.getParameter("opt"))) {
                if (dao.insertarFinanza(dataBean)) {
                    image = "./resources/images/dialog-information.png";
                    title = "La Operación Fué Un Exito!";
                    msn = "Se Ha Publicado una Nueva Finanza con exito de nombre: <br/>" + request.getParameter("titulo");
                } else {
                    image = "./resources/images/dialog-warning.png";
                    title = "La Operación Falló!";
                    msn = "No se Pudo Publicar el Finanza,  itentelo mas tarde";
                }
            } else if (dao.actualizarFinanza(dataBean)) {
                image = "./resources/images/dialog-information.png";
                title = "La Operación Fué Un Exito!";
                msn = "Se Ha Actualizado el Finanza con exito de nombre: <br/>" + request.getParameter("titulo");
            } else {
                image = "./resources/images/dialog-warning.png";
                title = "La Operación Falló!";
                msn = "No se Pudo Actualizar el Finanza, itentelo mas tarde";
            }
            Gson gson = new Gson();
            HashMap hashMapOut = new HashMap();
            hashMapOut.put("msn", msn);
            hashMapOut.put("title", title);
            hashMapOut.put("image", image);
            String arg = gson.toJson(hashMapOut);
            out.print(arg);
        }
    }

    private void actualizarSB(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            Gson g = new Gson();
            HashMap hm = new HashMap();
            Finanza bean = new Finanza();

            Boolean flag = true;
            if ("0".equals(request.getParameter("op"))) {
                ResolucionGerencial doc = new ArcDigDao().obtenerBean(Integer.parseInt(request.getParameter("id")));
                bean.setDescripcion(doc.getResumen());
                bean.setAnho(doc.getFecha().toString().split("/")[2]);
                bean.setMes(doc.getFecha().toString().split("/")[1]);
                bean.setFecha(doc.getFecha());
                bean.setUbicacion("");
                bean.setDocuId(doc.getId());
                bean.setTipo(Integer.parseInt(request.getParameter("tipo")));
                bean.setEstado(false);
                new FinanzaDao().insertarFinanza(bean);
            } else {
                bean.setDescripcion(request.getParameter("descripcion"));
                bean.setAnho(request.getParameter("fecha").toString().split("/")[2]);
                bean.setMes(request.getParameter("fecha").toString().split("/")[1]);
                bean.setId(Integer.parseInt(request.getParameter("id")));
                new FinanzaDao().actualizarFinanza(bean);
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
    }

    private void activarPresupuesto(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        PresupuestoDao dao = new PresupuestoDao();
        HashMap h = new HashMap();
        h.put("tipo", request.getParameter("tipo") == null ? 0 : Integer.parseInt(request.getParameter("tipo")));
        h.put("codigo", request.getParameter("codigo") == null ? 0 : Integer.parseInt(request.getParameter("codigo")));
        h.put("act", request.getParameter("act") == null ? true : Boolean.parseBoolean(request.getParameter("act")));
        dao.activarPresupuesto(h);
    }

    private void eliminarPresupuesto(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        PresupuestoDao dao = new PresupuestoDao();
        HashMap h = new HashMap();
        int id = request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id"));
        dao.eliminarPresupuesto(id);
    }

    private void activarFinanza(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        FinanzaDao dao = new FinanzaDao();
        HashMap h = new HashMap();
        h.put("tipo", request.getParameter("tipo") == null ? 0 : Integer.parseInt(request.getParameter("tipo")));
        h.put("codigo", request.getParameter("codigo") == null ? 0 : Integer.parseInt(request.getParameter("codigo")));
        h.put("act", request.getParameter("act") == null ? true : Boolean.parseBoolean(request.getParameter("act")));
        dao.activarFinanza(h);
    }

    private void eliminarFinanza(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        FinanzaDao dao = new FinanzaDao();
        int id = request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id"));
        dao.eliminarFinanza(id);
    }

    private void eliminarOrdenCompra(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            OrdenCompraDao dao = new OrdenCompraDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (dao.eliminarOrdenCompra(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "La Orden de Compra se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar la Orden de Compra");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void eliminarOrdenServicio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            OrdenServicioDao dao = new OrdenServicioDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (dao.eliminarOrdenServicio(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "La Orden de Servicio se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar la Orden de Servicio");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void eliminarTelefonia(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            TelefoniaDao dao = new TelefoniaDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (dao.eliminarTelefonia(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "La Telefonia se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar la Telefonia");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void eliminarVehiculo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            VehiculoDao dao = new VehiculoDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (dao.eliminarVehiculo(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "El Registro Vehicular se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar el Registro Vehicular");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void eliminarViatico(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            ViaticoDao dao = new ViaticoDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (dao.eliminarViatico(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "El Registro Viatico se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar el Registro Viatico");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void eliminarProveedor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            ProveedorDao dao = new ProveedorDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (dao.eliminarProveedor(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "El Proveedor se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar El Proveedor");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void eliminarPublicidad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            PublicidadDao dao = new PublicidadDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (dao.eliminarPublicidad(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "El Registro Publicitario se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar El Registro Publicitario");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void presupuestoFinanzasArcDig(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ResolucionGerencialDao resolucionGerencialDao = new ResolucionGerencialDao();
        Gson gson = new Gson();
        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            if (!"".equals(request.getParameter("anho"))) {
                hm.put("filter", "trim(substring(docu_fecha_docx from 7))=" + request.getParameter("anho"));
            }

            hm.put("tipo", Integer.parseInt(request.getParameter("tipo")));
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<ResolucionGerencial> list = resolucionGerencialDao.listPresupuestoFinanzas(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", resolucionGerencialDao.listTotalPresupuestoFinanzas(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void actualizarFinanzas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ResolucionGerencialDao resolucionGerencialDao = new ResolucionGerencialDao();
        try {
            HashMap hm = new HashMap();
            hm.put("tipo", Integer.parseInt(request.getParameter("tipo")));
            switch (request.getParameter("tipo")) {
                case "19":
                    hm.put("tipo_f", 1);
                    break;
                case "15":
                    hm.put("tipo_f", 2);
                    break;
                case "16":
                    hm.put("tipo_f", 3);
                    break;
                case "17":
                    hm.put("tipo_f", 4);
                    break;
            }
            FinanzaDao dao = new FinanzaDao();
            for (ResolucionGerencial object : resolucionGerencialDao.listActualizarFinanzas(hm)) {
                hm.put("anho", "".equals(object.getFecha().trim()) ? "0" : object.getFecha().split("/")[2]);
                hm.put("mes", "".equals(object.getFecha().trim()) ? "0" : object.getFecha().split("/")[1]);
                hm.put("tituloFormato", object.getTitulo().replace(".PDF", ""));
                hm.put("descripcion", object.getResumen());
                hm.put("docuId", object.getId());
                dao.addItemFinanza(hm);
            }
        } finally {
            out.close();
        }
    }

    private void actualizarPublicaciones(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ResolucionGerencialDao resolucionGerencialDao = new ResolucionGerencialDao();
        try {
            HashMap hm = new HashMap();
            hm.put("tipo", Integer.parseInt(request.getParameter("tipo")));
            switch (request.getParameter("tipo")) {
                case "20":
                    hm.put("tipoP", 1);
                    break;
                case "21":
                    hm.put("tipoP", 3);
                    break;
                case "16":
                    hm.put("tipoP", 3);
                    break;
                case "17":
                    hm.put("tipoP", 4);
                    break;
            }
            PublicacionDao dao = new PublicacionDao();
            for (ResolucionGerencial object : resolucionGerencialDao.listActualizarFinanzas(hm)) {
                hm.put("anho", "".equals(object.getFecha().trim()) ? "0" : object.getFecha().split("/")[2]);
                hm.put("mes", "".equals(object.getFecha().trim()) ? "0" : object.getFecha().split("/")[1]);
                hm.put("titulo", object.getTitulo().replace(".PDF", ""));
                hm.put("descripcion", object.getResumen());
                hm.put("docuId", object.getId());
                dao.addItemPublicacion(hm);
            }
        } finally {
            out.close();
        }
    }

    private void insertMEMO(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");
            Gson g = new Gson();
            String msn = null;
            String title = null;
            String image = null;

            HashMap hm = new HashMap();
            PublicacionDao dao = new PublicacionDao();
            Publicacion dataBean = new Publicacion();
            int id = 0;
            if (!"".equals(request.getParameter("id"))) {
                id = Integer.parseInt(request.getParameter("id"));
            }
            String[] s = request.getParameter("fecha").split("/");

            dataBean.setDescripcion(request.getParameter("descripcion"));
            dataBean.setAnho(s[2].toString());
            dataBean.setId(id);
            dataBean.setDocuId(Integer.parseInt(request.getParameter("arcDigId")));
            dataBean.setTipo(Integer.parseInt(request.getParameter("tabla")));
            dataBean.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
            dataBean.setTitulo(request.getParameter("titulo"));
            if ("0".equals(request.getParameter("opt"))) {
                if (dao.insertarPublicaciones(dataBean)) {
                    image = "./resources/images/dialog-information.png";
                    title = "La Operación Fué Un Exito!";
                    msn = "Se Ha Publicado una Nueva Publicacion con exito de nombre: <br/>" + request.getParameter("titulo");
                } else {
                    image = "./resources/images/dialog-warning.png";
                    title = "La Operación Falló!";
                    msn = "No se Pudo Publicar la Publicacion,  itentelo mas tarde";
                }
            } else if (dao.actualizarPublicaciones(dataBean)) {
                image = "./resources/images/dialog-information.png";
                title = "La Operación Fué Un Exito!";
                msn = "Se Ha Actualizado La Publicacion con exito de nombre: <br/>" + request.getParameter("titulo");
            } else {
                image = "./resources/images/dialog-warning.png";
                title = "La Operación Falló!";
                msn = "No se Pudo Actualizar la Publicacion, itentelo mas tarde";
            }
            Gson gson = new Gson();
            HashMap hashMapOut = new HashMap();
            hashMapOut.put("msn", msn);
            hashMapOut.put("title", title);
            hashMapOut.put("image", image);
            String arg = gson.toJson(hashMapOut);
            out.print(arg);
        }
    }

    private void eliminarPublicaciones(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            PublicacionDao dao = new PublicacionDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (dao.eliminarPublicaciones(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "la Publicacion se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar La Publicacion");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void listarAgendaForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        AgendaDao dao = new AgendaDao();
        Gson gson = new Gson();

        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        String filtro = request.getParameter("filtro") == null ? "1" : request.getParameter("filtro");
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("tipo", Integer.parseInt(request.getParameter("tipo")));
            String fechaFiltro = request.getParameter("fechaFiltro").split("/")[2] + "-" + request.getParameter("fechaFiltro").split("/")[1] + "-" + request.getParameter("fechaFiltro").split("/")[0];
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);

            switch (filtro) {
                case "1":
                    hm.put("filtro", "and fecha_inicio = '" + fechaFiltro + "'");
                    break;
                case "2":
                    hm.put("filtro", "and SUBSTR((cast(fecha_inicio as character varying)),0,8) = '" + request.getParameter("fechaFiltro").split("/")[2] + "-" + request.getParameter("fechaFiltro").split("/")[1] + "'");
                    break;
                case "3":
                    hm.put("filtro", "and SUBSTR((cast(fecha_inicio as character varying)),0,5) =  '" + request.getParameter("fechaFiltro").split("/")[2] + "'");
                    break;
                default:
                    hm.put("filtro", "");
                    break;


            }
            List<Agenda> list = dao.listAgendaForAdmin(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", dao.listTotalAgendaForAdmin(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void actualizarActividadAgenda(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");

            HashMap hm = new HashMap();
            hm.put("actividad", request.getParameter("txtActividad").toUpperCase());
            hm.put("ciudad", request.getParameter("txtCiudad").toUpperCase());
            hm.put("fechaInicio", request.getParameter("txtFecha"));
            hm.put("horaInicio", request.getParameter("txtHora"));
            hm.put("horaFinal", request.getParameter("txtHoraFinal"));
            hm.put("lugar", request.getParameter("txtLugar").toUpperCase());
            hm.put("tipo", Integer.parseInt(request.getParameter("txtTipo")));
            hm.put("id", request.getParameter("codigo") == null ? 0 : Integer.parseInt(request.getParameter("codigo")));

            if ("false".equals(request.getParameter("txtEstado"))) {
                hm.put("estado", false);
            } else {
                hm.put("estado", true);
            }
            AgendaDao dao = new AgendaDao();

            hm.put("msg", "La Convocatoria se Inserto correctamente");

            if ("0".equals(request.getParameter("opt"))) {
                if (dao.insertarActividadAgenda(hm)) {
                    hm.put("success", true);
                    hm.put("msg", "Se Ha Guardado Correctamente La Actividad Programada Para Su Agenda En La Fecha: " + request.getParameter("txtFecha"));
                } else {
                    hm.put("success", false);
                    hm.put("msg", "No Se Puedo Guardar Itentelo Mas Tarde");
                }
            } else if (dao.actualizarActividadAgenda(hm)) {
                hm.put("success", true);
                hm.put("msg", "Se Ha Modificado Correctamente La Actividad Programada Para Su Agenda de La Fecha: " + request.getParameter("txtFecha"));
            } else {
                hm.put("success", false);
                hm.put("msg", "No Se Puedo Guardar Itentelo Mas Tarde");
            }

            Gson gson = new Gson();
            String arg = gson.toJson(hm);

            out.print(arg);
        }
    }

    private void buscarActividadAgenda(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            AgendaDao dao = new AgendaDao();
            Agenda m = dao.buscarActividadAgenda(Integer.parseInt(request.getParameter("id")));
            HashMap hm = new HashMap();
            hm.put("actividad", m);
            Gson g = new Gson();
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void eliminarActividadAgenda(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            AgendaDao dao = new AgendaDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (dao.eliminarActividadAgenda(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "la Actividad se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar La actividad");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void estadoActividadAgenda(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        AgendaDao dao = new AgendaDao();
        HashMap hm = new HashMap();
        HashMap p = new HashMap();
        Gson g = new Gson();
        Boolean estado = false;
        if ("false".equals(request.getParameter("estado"))) {
            estado = true;
        }
        p.put("estado", estado);
        p.put("id", Integer.parseInt(request.getParameter("id")));
        if (dao.estadoActividadAgenda(p)) {
            hm.put("success", true);
            hm.put("msg", "La Actividad de la Agenda Cambió su Estado ");
        } else {
            hm.put("success ", false);
            hm.put("msg", "Hubo Un Problema al cambiar el estado ");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void listarFuncionarioForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        FuncionarioDao dao = new FuncionarioDao();
        Gson gson = new Gson();

        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<Funcionario> list = dao.listFuncionarioForAdmin(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", dao.listTotalFuncionarioForAdmin(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }

    }

    private void actualizarFuncionario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");

            HashMap hm = new HashMap();

            hm.put("nombresApellidos", request.getParameter("txtNombre").trim());
            hm.put("cargo", request.getParameter("txtCargo").trim());
            hm.put("hojaVida", request.getParameter("txtCurriculum").trim());
            hm.put("numeroDni", request.getParameter("txtDNI").trim());
            hm.put("eMail", request.getParameter("txtEmail").trim());
            hm.put("fax", request.getParameter("txtFax").trim());
            hm.put("telefono", request.getParameter("txtTelefono").trim());
            hm.put("fechaDesignacion", request.getParameter("txtFecha").trim());
            hm.put("nivelRemunerativo", request.getParameter("txtNivel").trim());
            hm.put("regimenLaboral", request.getParameter("txtRegimen").trim());
            hm.put("resolucion", request.getParameter("txtResolucion").trim());
            hm.put("foto", request.getParameter("txtFoto").trim());
            hm.put("profesion", request.getParameter("txtProfesion").trim());
            hm.put("retribucionMensual", "".equals(request.getParameter("txtRetribucion")) ? 0.0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("txtRetribucion").trim())));
            hm.put("organigrama", request.getParameter("txtOrganigrama").trim());
            hm.put("destacado", request.getParameter("txtDestacado") == null ? false : true);
            hm.put("estado", request.getParameter("txtEstado") == null ? false : true);
            /*
             * if ("false".equals(request.getParameter("txtDestacado"))){
             * hm.put("destacado", false); }else { hm.put("destacado", true); }
             * if ("false".equals(request.getParameter("txtEstado"))) {
             * hm.put("estado", false); } else { hm.put("estado", true); }
             */
            FuncionarioDao dao = new FuncionarioDao();

            if ("0".equals(request.getParameter("opt"))) {
                if (dao.insertarFuncionario(hm)) {
                    hm.put("success", true);
                    hm.put("msg", "Se Ha Guardado Correctamente Al Funcionario : " + request.getParameter("txtNombre"));
                } else {
                    hm.put("success", false);
                    hm.put("msg", "No Se Puedo Guardar Itentelo Mas Tarde");
                }
            } else {
                hm.put("id", request.getParameter("codigo") == null ? 0 : Integer.parseInt(request.getParameter("codigo")));
                if (dao.actualizarFuncionario(hm)) {
                    hm.put("success", true);
                    hm.put("msg", "Se Ha Modificado Correctamente los Datos del Funcionario: " + request.getParameter("txtNombre"));
                } else {
                    hm.put("success", false);
                    hm.put("msg", "No Se Puedo Guardar Itentelo Mas Tarde");
                }
            }
            Gson gson = new Gson();
            String arg = gson.toJson(hm);

            out.print(arg);
        }
    }

    private void buscarFuncionario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            FuncionarioDao dao = new FuncionarioDao();
            Funcionario m = dao.buscarFuncionario(Integer.parseInt(request.getParameter("id")));
            HashMap hm = new HashMap();
            hm.put("funcionario", m);
            Gson g = new Gson();
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void eliminarFuncionario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            FuncionarioDao dao = new FuncionarioDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (dao.eliminarFuncionario(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "El Funcionario se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar el funcionario");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void estadoFuncionario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        FuncionarioDao dao = new FuncionarioDao();
        HashMap hm = new HashMap();
        HashMap p = new HashMap();
        Gson g = new Gson();
        Boolean estado = false;
        if ("false".equals(request.getParameter("estado"))) {
            estado = true;
        }
        p.put("estado", estado);
        p.put("id", Integer.parseInt(request.getParameter("id")));
        if (dao.estadoFuncionario(p)) {
            hm.put("success", true);
            hm.put("msg", "El funcionario de la Agenda Cambió su Estado ");
        } else {
            hm.put("success ", false);
            hm.put("msg", "Hubo Un Problema al cambiar el estado ");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void listarDirectivoForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DirectivoDao dao = new DirectivoDao();
        Gson gson = new Gson();

        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<Directivo> list = dao.listDirectivoForAdmin(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", dao.listTotalDirectivoForAdmin(hm));
            outHash.put("pagina", request.getParameter("current") == "" ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }

    }

    private void actualizarDirectivo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");

            HashMap hm = new HashMap();

            hm.put("nombresApellidos", request.getParameter("txtNombre").trim());
            hm.put("cargo", request.getParameter("txtCargo").trim());
            hm.put("hojaVida", request.getParameter("txtCurriculum").trim());
            hm.put("numeroDni", request.getParameter("txtDNI").trim());
            hm.put("eMail", request.getParameter("txtEmail").trim());
            hm.put("fax", request.getParameter("txtFax").trim());
            hm.put("telefono", request.getParameter("txtTelefono").trim());
            hm.put("fechaDesignacion", request.getParameter("txtFecha").trim());
            hm.put("nivelRemunerativo", request.getParameter("txtNivel").trim());
            hm.put("regimenLaboral", request.getParameter("txtRegimen").trim());
            hm.put("resolucion", request.getParameter("txtResolucion").trim());
            hm.put("foto", request.getParameter("txtFoto").trim());
            hm.put("profesion", request.getParameter("txtProfesion").trim());
            hm.put("retribucionMensual", "".equals(request.getParameter("txtRetribucion")) ? 0.0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("txtRetribucion").trim())));
            hm.put("institucion", request.getParameter("txtInstitucion").trim());

            if ("false".equals(request.getParameter("txtEstado"))) {
                hm.put("estado", false);
            } else {
                hm.put("estado", true);
            }
            DirectivoDao dao = new DirectivoDao();

            if ("0".equals(request.getParameter("opt"))) {
                if (dao.insertarDirectivo(hm)) {
                    hm.put("success", true);
                    hm.put("msg", "Se Ha Guardado Correctamente Al Directivo : " + request.getParameter("txtNombre"));
                } else {
                    hm.put("success", false);
                    hm.put("msg", "No Se Puedo Guardar Itentelo Mas Tarde");
                }
            } else {
                hm.put("id", request.getParameter("codigo") == null ? 0 : Integer.parseInt(request.getParameter("codigo")));
                if (dao.actualizarDirectivo(hm)) {

                    hm.put("success", true);
                    hm.put("msg", "Se Ha Modificado Correctamente los Datos del Directivo: " + request.getParameter("txtNombre"));
                } else {
                    hm.put("success", false);
                    hm.put("msg", "No Se Puedo Guardar Itentelo Mas Tarde");
                }
            }

            Gson gson = new Gson();
            String arg = gson.toJson(hm);

            out.print(arg);
        }
    }

    private void buscarDirectivo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            DirectivoDao dao = new DirectivoDao();
            Directivo m = dao.buscarDirectivo(Integer.parseInt(request.getParameter("id")));
            HashMap hm = new HashMap();
            hm.put("funcionario", m);
            Gson g = new Gson();
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void eliminarDirectivo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            DirectivoDao dao = new DirectivoDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (dao.eliminarDirectivo(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "El Directivo se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar el funcionario");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void estadoDirectivo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        DirectivoDao dao = new DirectivoDao();
        HashMap hm = new HashMap();
        HashMap p = new HashMap();
        Gson g = new Gson();
        Boolean estado = false;
        if ("false".equals(request.getParameter("estado"))) {
            estado = true;
        }
        p.put("estado", estado);
        p.put("id", Integer.parseInt(request.getParameter("id")));
        if (dao.estadoDirectivo(p)) {
            hm.put("success", true);
            hm.put("msg", "El Directivo de la Agenda Cambió su Estado ");
        } else {
            hm.put("success ", false);
            hm.put("msg", "Hubo Un Problema al cambiar el estado ");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void importarPersonal(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String rutaTemporal = getServletContext().getRealPath("/") + "tmp/" + request.getSession().getId() + ".xls";
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(rutaTemporal));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator iterator = sheet.rowIterator();
            List<Personal> listTpbs = new ArrayList<>();
            PersonalDao personal = new PersonalDao();
            HashMap outHash = new HashMap();
            Gson gson = new Gson();
            String flag = "0";
            while (iterator.hasNext()) {//recorremos fila por fila
                HSSFRow row = (HSSFRow) iterator.next();
                if (row.getRowNum() != 0) {//comparamos que no sea la cabecera
                    listTpbs.add(Personal.loadPlanilla(row));
                } else {
                    try {
                        if ((!"".equals(row.getCell(15).toString()))) {
                            flag = "1";
                            if ((!"".equals(row.getCell(16).toString()))) {
                                outHash.put("errors", 1);
                                outHash.put("items", "");
                                out.print(gson.toJson(outHash));
                                return;
                            }
                        }
                    } catch (NullPointerException ex) {
                        if ("0".equals(flag)) {
                            outHash.put("errors", 1);
                            outHash.put("items", "");
                            out.print(gson.toJson(outHash));
                            return;
                        }
                    }
                }
            }
            if (listTpbs.size() > 0) {//aqui importamos el presupuesto temporal
                HashMap hm = new HashMap();
                List<Personal> list = personal.importarPersonal(listTpbs);
                outHash.put("errors", 0);
                outHash.put("items", list);
                String arg = gson.toJson(outHash);
                out.print(arg);
            }
        } catch (IOException ex) {
            Logger.getLogger(GestionTransparenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void volcarTemporalPersonal(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        PersonalDao personal = new PersonalDao();
        HashMap h = new HashMap();

        h.put("anho", request.getParameter("anho") == null ? "" : request.getParameter("anho"));
        h.put("trimestre", request.getParameter("trimestre") == null ? 0 : Integer.parseInt(request.getParameter("trimestre")));
        h.put("apellidosNombres", request.getParameter("apellidosNombres") == null ? "" : request.getParameter("apellidosNombres"));
        h.put("cargo", request.getParameter("cargo") == null ? "" : request.getParameter("cargo"));
        h.put("codigoFormato", request.getParameter("codigoFormato") == null ? "" : request.getParameter("codigoFormato"));
        h.put("pension", request.getParameter("pension") == null ? "" : request.getParameter("pension"));
        h.put("remuneracionMensual", request.getParameter("remuneracionMensual") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("remuneracionMensual"))));
        h.put("beneficios", request.getParameter("beneficios") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("beneficios"))));
        h.put("ingresoTotal", request.getParameter("ingresoTotal") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("ingresoTotal"))));
        h.put("financiamiento", request.getParameter("financiamiento") == null ? "" : request.getParameter("financiamiento"));
        h.put("fechaIngreso", request.getParameter("fechaIngreso") == null ? "" : request.getParameter("fechaIngreso"));
        h.put("fechaCede", request.getParameter("fechaCede") == null ? "" : request.getParameter("fechaCede"));
        h.put("numeroDni", request.getParameter("numeroDni") == null ? "" : request.getParameter("numeroDni"));
        h.put("codigoCivil", request.getParameter("codigoCivil") == null ? "" : request.getParameter("codigoCivil"));
        h.put("oficinaArea", request.getParameter("oficinaArea") == null ? "" : request.getParameter("oficinaArea"));
        h.put("tipo", request.getParameter("tipo") == null ? 0 : Integer.parseInt(request.getParameter("tipo")));
        h.put("categoria", request.getParameter("categoria") == null ? "" : request.getParameter("categoria"));
        h.put("observacion", request.getParameter("observacion") == null ? "" : request.getParameter("observacion"));
        h.put("bonificacionQuinqu", request.getParameter("bonificacionQuinqu") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("bonificacionQuinqu"))));
        personal.addItemPersonal(h);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void listarPersonalForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        PersonalDao dao = new PersonalDao();
        Gson gson = new Gson();

        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("tipo", Integer.parseInt(request.getParameter("tipo")));
            hm.put("anio", request.getParameter("anho"));
            hm.put("trimestre", request.getParameter("trimestre") == null ? 0 : Integer.parseInt(request.getParameter("trimestre")));
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<Personal> list = dao.listPersonalForAdmin(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", dao.listTotalPersonalForAdmin(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }

    private void listarPersonalForDis(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        PersonalDao dao = new PersonalDao();
        Gson gson = new Gson();

        String query = request.getParameter("query") == null ? "" : request.getParameter("query").trim().replace('$', '&');
        int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        try {
            HashMap hm = new HashMap();
            hm.put("tipo", Integer.parseInt(request.getParameter("tipo")));
            hm.put("anio", request.getParameter("anho"));
            hm.put("trimestre", request.getParameter("trimestre") == null ? 0 : Integer.parseInt(request.getParameter("trimestre")));
            hm.put("query", "%" + query + "%");
            hm.put("order", "desc");
            hm.put("limit", limit);
            hm.put("start", start);
            List<Personal> list = dao.listPersonalForDis(hm);
            HashMap outHash = new HashMap();
            outHash.put("items", list);
            outHash.put("total", dao.listTotalPersonalForDis(hm));
            outHash.put("pagina", request.getParameter("current") == null ? 0 : Integer.parseInt(request.getParameter("current")));
            String arg = gson.toJson(outHash);
            out.print(arg);
        } finally {
            out.close();
        }
    }
    
    private void eliminarPersonal(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            PersonalDao dao = new PersonalDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (dao.eliminarPersonal(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "El Personal se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar el Personal");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    //Print en PDF 
    private void personalPrint(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            //PrintWriter out = response.getWriter();
            int tipo = Integer.parseInt(request.getParameter("tipo"));
            byte[] bs = crearReporte(tipo);
            response.setContentType("application/pdf");
            response.setContentLength(bs.length);
            ServletOutputStream ouputStream = response.getOutputStream();
            ouputStream.write(bs, 0, bs.length);
            ouputStream.flush();
            ouputStream.close();
        } catch (JRException ex) {
            Logger.getLogger(PublicacionesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PublicacionesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PublicacionesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public byte[] crearReporte(Integer tipo) throws JRException, SQLException, ServletException, ClassNotFoundException {
        Connection conn = null;
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/arguz_WebApp", "arguz", "3v0luc10n@tusideas***");
        ServletContext srvcon = getServletContext();
        String rutafisica = srvcon.getRealPath("//reportes//");
        String rutaLogo = srvcon.getRealPath("//reportes//banner.jpg");
        JasperReport masterReport = (JasperReport) JRLoader.loadObject(rutafisica + "/personal.jasper");
        Map parametro = new HashMap();
        parametro.put("p_tipo", tipo);
        parametro.put("ruta_logo", rutaLogo);
        JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conn);
        conn.close();
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

    private void importarPersonalLocador(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String rutaTemporal = getServletContext().getRealPath("/") + "tmp/" + request.getSession().getId() + ".xls";
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(rutaTemporal));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator iterator = sheet.rowIterator();
            List<Personal> listTpbs = new ArrayList<>();
            PersonalDao personal = new PersonalDao();
            String flag = "0";
            HashMap outHash = new HashMap();
            Gson gson = new Gson();

            while (iterator.hasNext()) {//recorremos fila por fila
                HSSFRow row = (HSSFRow) iterator.next();
                if (row.getRowNum() != 0) {//comparamos que no sea la cabecera
                    listTpbs.add(Personal.loadLocador(row));
                } else {
                    try {
                        if ((!"".equals(row.getCell(11).toString()))) {
                            flag = "1";
                            if ((!"".equals(row.getCell(12).toString()))) {
                                outHash.put("errors", 1);
                                outHash.put("items", "");
                                out.print(gson.toJson(outHash));
                                return;
                            }
                        }
                    } catch (NullPointerException ex) {
                        if ("0".equals(flag)) {
                            outHash.put("errors", 1);
                            outHash.put("items", "");
                            out.print(gson.toJson(outHash));
                            return;
                        }
                    }
                }
            }
            if (listTpbs.size() > 0) {//aqui importamos el presupuesto temporal
                HashMap hm = new HashMap();
                List<Personal> list = personal.importarPersonal(listTpbs);
                outHash.put("errors", 0);
                outHash.put("items", list);
                String arg = gson.toJson(outHash);
                out.print(arg);
            }
        } catch (IOException ex) {
            Logger.getLogger(GestionTransparenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void importarPersonalCAS(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String rutaTemporal = getServletContext().getRealPath("/") + "tmp/" + request.getSession().getId() + ".xls";
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(rutaTemporal));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator iterator = sheet.rowIterator();
            List<Personal> listTpbs = new ArrayList<>();
            PersonalDao personal = new PersonalDao();
            HashMap outHash = new HashMap();
            Gson gson = new Gson();
            String flag = "0";
            while (iterator.hasNext()) {//recorremos fila por fila
                HSSFRow row = (HSSFRow) iterator.next();
                if (row.getRowNum() != 0) {//comparamos que no sea la cabecera
                    listTpbs.add(Personal.loadCAS(row));
                } else {
                    try {
                        if ((!"".equals(row.getCell(11).toString()))) {
                            flag = "1";
                            if ((!"".equals(row.getCell(12).toString()))) {
                                outHash.put("errors", 1);
                                outHash.put("items", "");
                                out.print(gson.toJson(outHash));
                                return;
                            }
                        }
                    } catch (NullPointerException ex) {
                        if ("0".equals(flag)) {
                            outHash.put("errors", 1);
                            outHash.put("items", "");
                            out.print(gson.toJson(outHash));
                            return;
                        }
                    }
                }
            }
            if (listTpbs.size() > 0) {//aqui importamos el presupuesto temporal

                List<Personal> list = personal.importarPersonal(listTpbs);
                outHash.put("errors", 0);
                outHash.put("items", list);
                String arg = gson.toJson(outHash);
                out.print(arg);
            }
        } catch (IOException ex) {
            Logger.getLogger(GestionTransparenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void importarPersonalCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String rutaTemporal = getServletContext().getRealPath("/") + "tmp/" + request.getSession().getId() + ".xls";
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(rutaTemporal));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Iterator iterator = sheet.rowIterator();
            List<PersonalCategoria> listTpbs = new ArrayList<>();
            PersonalCategoriaDao personal = new PersonalCategoriaDao();
            HashMap outHash = new HashMap();
            Gson gson = new Gson();
            String flag = "0";
            while (iterator.hasNext()) {//recorremos fila por fila
                HSSFRow row = (HSSFRow) iterator.next();
                if (row.getRowNum() != 0) {//comparamos que no sea la cabecera
                    listTpbs.add(PersonalCategoria.loadCategoria(row));
                } else {
                    try {
                        if ((!"".equals(row.getCell(6).toString()))) {
                            flag = "1";
                            if ((!"".equals(row.getCell(7).toString()))) {
                                outHash.put("errors", 1);
                                outHash.put("items", "");
                                out.print(gson.toJson(outHash));
                                return;
                            }
                        }
                    } catch (NullPointerException ex) {
                        if ("0".equals(flag)) {
                            outHash.put("errors", 1);
                            outHash.put("items", "");
                            out.print(gson.toJson(outHash));
                            return;
                        }
                    }
                }
            }
            if (listTpbs.size() > 0) {//aqui importamos el presupuesto temporal
                HashMap hm = new HashMap();
                List<PersonalCategoria> list = personal.importarPersonalCategoria(listTpbs);

                outHash.put("items", list);
                String arg = gson.toJson(outHash);
                out.print(arg);
            }
        } catch (IOException ex) {
            Logger.getLogger(GestionTransparenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void volcarTemporalPersonalCategoria(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        PersonalCategoriaDao personal = new PersonalCategoriaDao();
        HashMap h = new HashMap();

        h.put("anho", request.getParameter("anho") == null ? "" : request.getParameter("anho"));
        h.put("trimestre", request.getParameter("trimestre") == null ? 0 : Integer.parseInt(request.getParameter("trimestre")));
        h.put("codigo", request.getParameter("codigo") == null ? "" : request.getParameter("codigo"));
        h.put("categoria", request.getParameter("categoria") == null ? "" : request.getParameter("categoria"));
        h.put("remuneracionMinimo", request.getParameter("remuneracionMinimo") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("remuneracionMinimo"))));
        h.put("remuneracionMaximo", request.getParameter("remuneracionMaximo") == null ? 0 : BigDecimal.valueOf(Double.parseDouble(request.getParameter("remuneracionMaximo"))));
        h.put("numeroTrabajadores", request.getParameter("numeroTrabajadores") == null ? 0 : Integer.parseInt(request.getParameter("numeroTrabajadores")));
        personal.addItemPersonalCategoria(h);
    }

    private void eliminarPersonalCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            PersonalCategoriaDao dao = new PersonalCategoriaDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            if (dao.eliminarPersonalCategoria(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "El Personal se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar el Personal");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void eliminarResolucion(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        ResolucionGerencialDao resolucionGerencialDao = new ResolucionGerencialDao();
        HashMap h = new HashMap();
        int id = request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id"));
        resolucionGerencialDao.eliminarResolucion(id);
    }

    ////OTROOSSS
    private void actualizarGlosario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson g = new Gson();
        HashMap hm = new HashMap();
        Glosario bean = new Glosario();
        bean.setTitulo(request.getParameter("titulo") == null ? "" : request.getParameter("titulo"));
        bean.setId(request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id")));
        bean.setDescripcion(request.getParameter("descripcion") == null ? "" : request.getParameter("descripcion"));
        Boolean flag = true;
        if ("0".equals(request.getParameter("op"))) {
            flag = new GlosarioDao().insert(bean);
        } else {
            flag = new GlosarioDao().update(bean);
        }
        if (flag) {
            hm.put("msg", "La Operaci&#243;n Fu&#233; Exitoso");
        } else {
            hm.put("msg", "Ya hay un registro con este Nombre");
        }

        hm.put("success", flag);
        response.getWriter().print(g.toJson(hm));
    }

    private void getGlosario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        Gson g = new Gson();
        try {
            Glosario bean = new GlosarioDao().obtenerBean(Integer.parseInt(request.getParameter("id")));
            response.getWriter().print(g.toJson(bean));
        } catch (NullPointerException ex) {
            response.getWriter().print("Intento Fallido");
        }
    }

    private void getSaldoBalance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        Gson g = new Gson();
        try {
            Finanza bean = new FinanzaDao().getFinanzaAdmin(Integer.parseInt(request.getParameter("id")));
            response.getWriter().print(g.toJson(bean));
        } catch (NullPointerException ex) {
            response.getWriter().print("Intento Fallido");
        }
    }
}
