/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import gob.peam.administracion.dao.EtiquetaDao;
import gob.peam.administracion.dao.SesionDao;
import gob.peam.administracion.dao.ThemaDao;
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
@WebServlet(name = "WebContent", urlPatterns = {"/WebContent"})
public class WebContentServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 7218930533554580879L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
                case "ConvocatoriaBien":
                    convocatoriaBien(request, response);
                    break;
                case "ConvocatoriaPers":
                    convocatoriaPers(request, response);
                    break;
                case "DocumentosGestion":
                    documentosGestion(request, response);
                    break;
                case "AdquiContra":
                    adquiContra(request, response);
                    break;
                case "LibroReclamos":
                    libroReclamos(request, response);
                    break;
                case "Comentario":
                    comentario(request, response);
                    break;
                case "Solicitud":
                    solicitud(request, response);
                    break;
                case "Anuncios":
                    anuncio(request, response);
                    break;
                case "Multimedia":
                    multimedia(request, response);
                    break;
                case "NotaPrensa":
                    notaPrensa(request, response);
                    break;
                case "PresFin":
                    presupuestoFinanza(request, response);
                    break;
                case "Temas":
                    temas(request, response);
                    break;
                case "Viaticos":
                    viaticos(request, response);
                    break;
                case "MemoriasAnuales":
                    memorias(request, response);
                    break;
                case "OtrasPublicaciones":
                    otrasPublicaciones(request, response);
                    break;
                case "AgendaGerencial":
                    agendaGerencial(request, response);
                    break;
                case "AgendaInfra":
                    agendaInfra(request, response);
                    break;
                case "AgendaAgro":
                    agendaAgro(request, response);
                    break;
                case "AgendaAmbiental":
                    agendaAmbiental(request, response);
                    break;
                case "PlanGerencial":
                    planGerencial(request, response);
                    break;
                case "Personal":
                    personal(request, response);
                    break;
                case "Correo":
                    correo(request, response);
                    break;
                case "Glosario":
                    glosario(request, response);
                    break;
                case "Directorio":
                    directorio(request, response);
                    break;
                case "FinalObra":
                    finalObra(request, response);
                    break;
                case "AdicionalObra":
                    adicionalObra(request, response);
                    break;
                case "Supervicion":
                    supervicion(request, response);
                    break;
                case "Comites":
                    comite(request, response);
                    break;
                case "Laudos":
                    laudos(request, response);
                    break;
                case "Conciliacion":
                    conciliacion(request, response);
                    break;
                case "Recomendacion":
                    recomendacion(request, response);
                    break;
                case "Evaluacion":
                    evaluacion(request, response);
                    break;
                case "Exoneracion":
                    exonerado(request, response);
                    break;
                case "Penalidad":
                    penalidad(request, response);
                    break;
                case "Indicador":
                    indicador(request, response);
                    break;
                case "Proyecto":
                    proyecto(request, response);
                    break;
                case "Modificatoria":
                    modificatoria(request, response);
                    break;
                case "SaldoBalance":
                    saldoBalance(request, response);
                    break;
                case "PatrimonioNeto":
                    patrimonioNeto(request, response);
                    break;
                case "FlujoEfectivo":
                    flujoEfectivo(request, response);
                    break;
                case "EstadoGestion":
                    estadoGestion(request, response);
                    break;
                case "Declaracion":
                    declaracion(request, response);
                    break;
                case "Portal":
                    portal(request, response);
                    break;
                case "DNG":
                    DNG(request, response);
                    break;
                //Nuevo contenido
                case "Destacados":
                    destacados(request, response);
                    break;
                case "Eventos":
                    eventos(request, response);
                    break;
                case "Estudios":
                    estudios(request, response);
                    break;
                case "Obras":
                    obras(request, response);
                    break;

            }
        }
    }

    // <editor-fold defaultstate="collapsed"
    // desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
    } //</editor-fold>

    private void getEstiloForUsuarioEstilo(HttpServletRequest request) throws IOException {
        HashMap hm = new HashMap();
        try {
            hm.put("usuaId", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
            hm.put("moduId", Integer.parseInt(request.getSession().getAttribute("idModulo").toString()));
            request.setAttribute("estilo", new ThemaDao().buscarEstiloPorUsuarioyModulo(hm).getThePath());
        } catch (Exception ex) {
            request.setAttribute("estilo", "ui-lightness");
        }
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a class='active'>Contenido Web</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/index.jsp").forward(request, response);
    }

    private void temas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Temas</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/temas.jsp").forward(request, response);
    }

    private void convocatoriaBien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Convocatoria Bienes, Servicios y Obras</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/convocatoria.jsp").forward(request, response);
    }

    private void convocatoriaPers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Convocatoria Personal</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/convocatoriapers.jsp").forward(request, response);
    }

    private void documentosGestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Documentos de Gestion</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/documentosGestion.jsp").forward(request, response);
    }

    private void adquiContra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Adquisiciones y Contrataciones</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/adquisicion.jsp").forward(request, response);
    }

    private void libroReclamos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Adquisiciones y Contrataciones</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/libroReclamos.jsp").forward(request, response);
    }

    private void memorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Memorias Anuales</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/memorias.jsp").forward(request, response);
    }

    private void otrasPublicaciones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Otras Publicaciones</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/otraspublicaciones.jsp").forward(request, response);
    }

    private void comentario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Comentarios y Sugerencias</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/comentarios.jsp").forward(request, response);
    }

    private void solicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Solicitud 27806</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/solicitud.jsp").forward(request, response);
    }

    private void notaPrensa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Nota de Prensa</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/notaPrensa.jsp").forward(request, response);
    }

    private void multimedia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Multimedia</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/multimedia.jsp").forward(request, response);
    }

    private void anuncio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Anuncios</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/anuncio.jsp").forward(request, response);
    }

    private void presupuestoFinanza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Presupuesto Finanza</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/presupuesto.jsp").forward(request, response);
    }

    private void viaticos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Viaticos</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/viatico.jsp").forward(request, response);
    }

    private void agendaGerencial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Agenda Gerencial</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/agendaGerencial.jsp").forward(request, response);
    }

    private void agendaInfra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Agenda del Director de Infraestructura</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/agendaInfraestructura.jsp").forward(request, response);
    }

    private void agendaAgro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Agenda del Director de Desarrollo Agropecuario</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/agendaAgropecuario.jsp").forward(request, response);
    }

    private void agendaAmbiental(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Agenda del Director de Manejo Ambiental</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/agendaAmbiental.jsp").forward(request, response);
    }

    private void planGerencial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Plan Gerencial y Directivo</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/planGerencialDirectiva.jsp").forward(request, response);
    }

    private void personal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Personal</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/personal.jsp").forward(request, response);
    }

    private void correo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Configuración de Correo</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/correo.jsp").forward(request, response);
    }

    private void glosario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Glosario de Terminos</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/glosario.jsp").forward(request, response);
    }

    private void directorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Directorio Telefonico</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/directorioTelefonico.jsp").forward(request, response);
    }

    private void finalObra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Monto de Liquidación final de Obra</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/finalObra.jsp").forward(request, response);
    }

    private void adicionalObra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Monto de adicionales de obras</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/adicionalObra.jsp").forward(request, response);
    }

    private void supervicion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Informes de supervición de contratos</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/supervicion.jsp").forward(request, response);
    }

    private void comite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Comite Encargados de proceso de bases</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/comite.jsp").forward(request, response);
    }

    private void laudos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Laudos</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/laudos.jsp").forward(request, response);
    }

    private void conciliacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Conciliacion</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/conciliacion.jsp").forward(request, response);
    }

    private void recomendacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Recomendacion de auditorías</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/recomendacion.jsp").forward(request, response);
    }

    private void evaluacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Evaluacion de actualizacion del portal</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/evaluacion.jsp").forward(request, response);
    }

    private void exonerado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Procesos de Exoneraci&oacute;n</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/exonerado.jsp").forward(request, response);
    }

    private void penalidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Penalidades</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/penalidad.jsp").forward(request, response);
    }

    private void indicador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Indicadores de Desempeño</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/indicador.jsp").forward(request, response);
    }

    private void proyecto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Proyectos de Inversi&oacute;n</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/proyecto.jsp").forward(request, response);
    }

    private void modificatoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Modificatorias del PAC</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/modificatoriaPac.jsp").forward(request, response);
    }

    private void saldoBalance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Saldos de Balance</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/saldoBalance.jsp").forward(request, response);
    }

    private void patrimonioNeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Estados de Cambio en el Patrimonio Neto</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/patrimonioNeto.jsp").forward(request, response);
    }

    private void flujoEfectivo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Estados de Flujo de Efectivo</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/flujoEfectivo.jsp").forward(request, response);
    }

    private void estadoGestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Estados de Gestión</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/estadoGestion.jsp").forward(request, response);
    }

    private void declaracion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Declaraciones Juradas</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/declaracion.jsp").forward(request, response);
    }

    private void portal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Informes Técnicos Previos de Evaluación de Software</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/portal.jsp").forward(request, response);
    }

    private void DNG(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Documentos Normativos y de Gestión</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/dng.jsp").forward(request, response);
    }

    //Nuevo contenido
    private void destacados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Destacados</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/destacado.jsp").forward(request, response);
    }

    private void eventos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Eventos</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/evento.jsp").forward(request, response);
    }

    private void estudios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Estudios</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/estudio.jsp").forward(request, response);
    }

    private void obras(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a href='./WebContent'>Contenido Web</a>|<a class='active'>Obras</a>");
        HashMap hm = new HashMap();
        hm.put("idUsuario", Integer.parseInt(request.getSession().getAttribute("idUsuario").toString()));
        hm.put("url", request.getServletPath());
        getEstiloForUsuarioEstilo(request);
        request.setAttribute("gadgets", new EtiquetaDao().listarMenusPorUsuarioyModulo(hm));
        request.getRequestDispatcher("./WEB-INF/intranet/web/obra.jsp").forward(request, response);
    }
}
