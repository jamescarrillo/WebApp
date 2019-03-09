/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.servlet;

import com.google.gson.Gson;
import gob.peam.beans.Comentario;
import gob.peam.beans.Correo;
import gob.peam.beans.Reclamo;
import gob.peam.beans.Solicitud;
import gob.peam.config.ConexionReporte;
import gob.peam.dao.ComentarioDao;
import gob.peam.dao.CorreoDao;
import gob.peam.dao.ReclamoDao;
import gob.peam.dao.SolicitudDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.lang.StringEscapeUtils;
import org.xml.sax.SAXException;

/**
 *
 * @author alabajos
 */
@WebServlet(name = "ParticipacionCiudadana", urlPatterns = {"/ParticipacionCiudadana"})
public class ParticipacionCiudadanaServlet extends HttpServlet {

    private static final long serialVersionUID = -2740384830649012156L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String respuesta = request.getParameter("action") == null ? "" : request.getParameter("action");
            switch (respuesta) {
                case "":
                    index(request, response);
                    break;
                case "AccesoInformacion":
                    accesoInformacion(request, response);
                    break;
                case "LibroReclamaciones":
                    libroReclamaciones(request, response);
                    break;
                case "Consultas":
                    consultas(request, response);
                    break;
                case "PortalTransparencia":
                    transparencia(request, response);
                    break;
                case "MisServicios":
                    servicios(request, response);
                    break;
                case "Reclamos":
                    getReclamo(request, response);
                    break;
                case "insertReclamos":
                    insertarReclamo(request, response);
                    break;
                case "insertSolicitud":
                    insertarSolicitud(request, response);
                    break;
                case "insertComentario":
                    insertarComentario(request, response);
                    break;
                case "listarReclamosForAdmin":
                    listarReclamosForAdmin(request, response);
                    break;
                case "listarSolicitudForAdmin":
                    listarSolicitudForAdmin(request, response);
                    break;
                case "getReclamoForAdmin":
                    getReclamoForAdmin(request, response);
                    break;
                case "getSolicitud":
                    getSolicitud(request, response);
                    break;
                case "getSolicitudForAdmin":
                    getSolicitudForAdmin(request, response);
                    break;
                case "actualizarReclamo":
                    actualizarReclamo(request, response);
                    break;
                case "actualizarSolicitud":
                    actualizarSolicitud(request, response);
                    break;
                case "listarComentarioForAdmin":
                    listarComentarioForAdmin(request, response);
                    break;
                case "getComentarioForAdmin":
                    getComentarioForAdmin(request, response);
                    break;
                case "actualizarComentario":
                    actualizarComentario(request, response);
                    break;
                case "EliminarReclamo":
                    eliminarReclamo(request, response);
                    break;
                case "EliminarSolicitud":
                    eliminarSolicitud(request, response);
                    break;
                case "EliminarComentario":
                    eliminarComentario(request, response);
                    break;
                case "GetAlertaSolicitud":
                    getAlertaSolicitud(request, response);
                    break;
                case "GetCorreo":
                    getCorreo(request, response);
                    break;
                case "ActualizarCorreo":
                    actualizarCorreo(request, response);
                    break;
                case "VerifyCaptcha":
                    verifyCaptcha(request, response);
                    break;
            }
        } catch (MessagingException ex) {
            Logger.getLogger(ParticipacionCiudadanaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/participacionCiudadana/index.jsp").forward(request, response);
    }

    private void accesoInformacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/participacionCiudadana/solicitud.jsp").forward(request, response);
    }

    private void libroReclamaciones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/participacionCiudadana/libroReclamaciones.jsp").forward(request, response);
    }

    private void consultas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/participacionCiudadana/consultasSugerencias.jsp").forward(request, response);
    }

    private void transparencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/participacionCiudadana/portalTransparencia.jsp").forward(request, response);
    }

    private void servicios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/participacionCiudadana/misServicios.jsp").forward(request, response);
    }

    private void getReclamo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Reclamo> lista = null;
        HashMap hashMap = new HashMap();
        HashMap hashMapOut = new HashMap();
        ReclamoDao reclamoDao = new ReclamoDao();

        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));

        hashMap.put("limit", "1");
        hashMap.put("start", start);
        lista = reclamoDao.listarReclamo(hashMap);
        hashMapOut.put("items", lista);
        hashMapOut.put("total", reclamoDao.listarTotalReclamo(hashMap));
        Gson gson = new Gson();
        String arg = gson.toJson(hashMapOut);
        out.print(arg);
    }

    private void getSolicitud(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Solicitud> lista = null;
        HashMap hashMap = new HashMap();
        HashMap hashMapOut = new HashMap();
        SolicitudDao solicitudDao = new SolicitudDao();

        int limit = request.getParameter("limit") == null ? 1 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));

        hashMap.put("limit", limit);
        hashMap.put("start", start);
        lista = solicitudDao.listarSolicitud(hashMap);
        hashMapOut.put("items", lista);
        hashMapOut.put("total", solicitudDao.listarTotalSolicitud(hashMap));
        Gson gson = new Gson();
        String arg = gson.toJson(hashMapOut);
        out.print(arg);
    }

    private void insertarReclamo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        Gson g = new Gson();
        ReclamoDao dao = new ReclamoDao();
        Reclamo reclamo = new Reclamo();
        reclamo.setDocumentoIdentidad(request.getParameter("documento"));
        reclamo.setUsuario(StringEscapeUtils.escapeHtml(request.getParameter("nombre")));
        reclamo.setDireccion(StringEscapeUtils.escapeHtml(request.getParameter("domicilio")));
        reclamo.setDescripcionAtencion(StringEscapeUtils.escapeHtml(request.getParameter("reclamo")));
        reclamo.setTelefono(request.getParameter("telefono"));
        reclamo.setEmail(request.getParameter("correo"));
        reclamo.setNumeroDocumento(request.getParameter("nrodocumento"));
        java.sql.Date d = new java.sql.Date(new java.util.Date().getTime());
        reclamo.setAnio(String.valueOf(d.getYear() + 1900));
        reclamo.setFecha(String.valueOf(d));
        reclamo.setFechaAcciones(String.valueOf(d));
        String msn = null;
        String msn1 = null;
        String cabecera = "Estimado(a), " + reclamo.getUsuario() + " su reclamo se recibi&#243; con &#233;xito, cualquier comunicaci&#243;n estaremos remitiendo por este mismo medio. No olvide revisar frecuentemente su correo.<br/>";
        String result = null;
        String numero = null;
        if (request.getSession().getAttribute("captcha").equals(request.getParameter("usua_captcha"))) {
            numero = dao.insertarReclamo(reclamo);
            if (!"".equals(numero)) {
                msn = "<h1 style='font-size:12pt; text-align:center'>Su Reclamo ha sido enviado con copia a su correo </h1> "
                        + "<h2 style='font-size:10pt; text-align:center; color:red;'> (Revise en la carpeta de correo no deseado o Spam, de ser necesario)</h2>";
                String fecha = reclamo.getFecha();

                msn1 = "<table border='1' collspacing='0' cellspacing ='0' id='tableta' style=\"width:100%; border:1px solid black; margin:20px auto 0px auto\">"
                        + "<tr style='border-bottom: 1px solid black;'><th colspan='4' style='font-weight: bold; text-align:center; padding:5px;'>Registro de Reclamaci&#243;n</th></tr>"
                        + "<tr style='border-bottom: 1px solid black;'><td>Fecha Registro:</td><td>" + fecha.split("-")[2] + "/" + fecha.split("-")[1] + "/" + fecha.split("-")[0] + "</td><td>N&#176; de Registro:</td><td>" + reclamo.getNumero() + "-" + reclamo.getAnio() + "</td></tr>"
                        + "<tr style='border-bottom: 1px solid black;'><td colspan='1'>Nombre Completo:</td><td colspan='3'>" + reclamo.getUsuario() + "</td></tr>"
                        + "<tr style='border-bottom: 1px solid black;'><td colspan='1'>Domicilio:</td><td colspan='3'>" + reclamo.getDireccion() + "</td></tr>"
                        + "<tr style='border-bottom: 1px solid black;'><td>DNI/RUC/CE:</td><td>" + reclamo.getDocumentoIdentidad() + "</td><td>Tel&#233;fono:</td><td>" + reclamo.getTelefono() + "</td></tr>"
                        + "<tr style='border-bottom: 1px solid black;'><td colspan='1'>Correo Electr&#243;nico:</td><td colspan='3'>" + reclamo.getEmail() + "</td></tr>"
                        + "<tr style='border-bottom: 1px solid black;'><td colspan='4'>Formulaci&#243;n del Reclamo:</td></tr>"
                        + "<tr style='border-bottom: 1px solid black;'><td colspan='4'>" + reclamo.getDescripcionAtencion() + "</td></tr>"
                        + "</table>"
                        + "<h2 style='font-size:10pt; color: blue; width:100%; text-align:center'>  <a href='http://www.peam.gob.pe/ReclamoPrint?id=" + reclamo.getNumero() + "&anho=" + reclamo.getAnio() + "&format=pdf' target='_blank'>Imprimir Aqu&#237;</a></h2>";
            } else {
                msn = "Lo sentimos hubo un error inesperado en el sistema. Intentelo más tarde";
            }

            /*
             * envio de correo
             */
            Correo c = new CorreoDao().buscarCorreo(1);
            String to = c.getParaCorreo();
            String cc = reclamo.getEmail().toString() + ", " + c.getCcCorreo();
            String from = c.getParteCorreo();

            String host = "correo.peam.gob.pe";
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", host);
            Session mailSession = Session.getDefaultInstance(properties);

            try {
                MimeMessage message = new MimeMessage(mailSession);
                message.setFrom(new InternetAddress(from));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
                message.setSubject("Formulario de Reclamo Nro: " + reclamo.getNumero() + "-" + reclamo.getAnio());
                Multipart mp = new MimeMultipart();

                MimeBodyPart htmlPart = new MimeBodyPart();
                htmlPart.setContent(cabecera + msn1, "text/html");
                mp.addBodyPart(htmlPart);

                byte[] bs = JasperExportManager.exportReportToPdf(crearReporteReclamo(reclamo.getNumero(), reclamo.getAnio()));

                MimeBodyPart attachment = new MimeBodyPart();
                attachment.setFileName("reclamo-" + reclamo.getNumero() + "-" + reclamo.getAnio() + ".pdf");
                attachment.setContent(bs, "application/pdf");
                mp.addBodyPart(attachment);

                message.setContent(mp);
                Transport.send(message);
                result = "Se Envió el mensaje correctamente";
            } catch (JRException | SQLException | ServletException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
                result = "Error: Al enviar el correo al destinatario...." + ex;
                Logger.getLogger(ParticipacionCiudadanaServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException mex) {
                result = "Error: Al enviar el correo al destinatario...." + mex;
            }
        } else {
            msn = "ER-CAPTCHA";
        }
        response.getWriter().print(msn + msn1);
    }

    public JasperPrint crearReporteReclamo(String id, String Anho) throws JRException, SQLException, ServletException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException {
        ServletContext srvcon = getServletContext();
        String rutafisica = srvcon.getRealPath("//reportes//");
        JasperReport masterReport = (JasperReport) JRLoader.loadObject(rutafisica + "/reclamos.jasper");
        String rutaLogo = srvcon.getRealPath("//reportes//encabezadoPEAM.jpg");
        Map parametro = new HashMap();
        Locale locale = new Locale("es", "ES");
        parametro.put(JRParameter.REPORT_LOCALE, locale);
        parametro.put("p_id", id);
        parametro.put("p_anho", Anho);
        parametro.put("ruta_logo", rutaLogo);
        JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, ConexionReporte.AbrirConexion());
        ConexionReporte.CerrarConexion();
        return jasperPrint;
    }

    private void verifyCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException, MessagingException {
        response.setContentType("application/json;charset=UTF-8");
        Gson g = new Gson();
        HashMap hashMapOut = new HashMap();
        if (request.getSession().getAttribute("captcha").equals(request.getParameter("usua_captcha"))) {
            hashMapOut.put("msn", 1);
        } else {
            hashMapOut.put("msn", 0);
        }
        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(hashMapOut));
    }

    private void insertarSolicitud(HttpServletRequest request, HttpServletResponse response) throws IOException, MessagingException {
        response.setContentType("text/html;charset=UTF-8");
        Gson g = new Gson();
        SolicitudDao dao = new SolicitudDao();
        Solicitud solicitud = new Solicitud();
        java.sql.Date d = new java.sql.Date(new java.util.Date().getTime());
        solicitud.setAnho(String.valueOf(d.getYear() + 1900));
        solicitud.setFechaRegistro(String.valueOf(d));
        solicitud.setDni(request.getParameter("documento"));
        solicitud.setUsuario(StringEscapeUtils.escapeHtml(request.getParameter("nombre").toUpperCase()));
        solicitud.setCorreo(request.getParameter("correo"));
        solicitud.setDependencia(StringEscapeUtils.escapeHtml(request.getParameter("dependencia").toUpperCase()));
        solicitud.setDescripcion(StringEscapeUtils.escapeHtml(request.getParameter("solicitud").toUpperCase()));
        solicitud.setTelefono(request.getParameter("telefono"));
        solicitud.setDomicilio(StringEscapeUtils.escapeHtml(request.getParameter("domicilio").toUpperCase()));
        solicitud.setForma(Integer.parseInt(request.getParameter("forma")));

        String msn = null;
        String msn1 = null;
        String result;
        String cabecera = "Estimado(a), " + solicitud.getUsuario() + " su solicitud se recibi&#243; con &#233;xito, cualquier comunicaci&#243;n estaremos remitiendo por este mismo medio. No olvide revisar frecuentemente su correo.<br/>";
        if (request.getSession().getAttribute("captcha").equals(request.getParameter("usua_captcha"))) {
            Integer id = dao.insertarSolicitud(solicitud);
            if (id != null) {
                String forma = null;
                switch (solicitud.getForma()) {
                    case 1:
                        forma = "COPIA SIMPLE";
                        break;
                    case 2:
                        forma = "COPIA FEDATEADA";
                        break;
                    case 3:
                        forma = "CD ROM";
                        break;
                    case 4:
                        forma = "CORREO ELECTRONICO";
                        break;
                    case 5:
                        forma = "OTRO";
                        break;
                }
                msn = "<h1 style='font-size:12pt; text-align:center'>Su solicitud ha sido enviada con copia a su correo </h1> "
                        + "<h2 style='font-size:10pt; text-align:center; color:red;'> (Revise en la carpeta de correo no deseado o Spam, de ser necesario)</h2>";
                String fecha = solicitud.getFechaRegistro();
                msn1 = "<table border='1' collspacing='0' cellspacing ='0' id='tableta' style=\"width:100%; border:1px solid black; margin:20px auto 0px auto\">"
                        + "<tr style='border-bottom: 1px solid black;'><th colspan='4' style='font-weight: bold; text-align:center; padding:5px;'>Solicitud Electr&#243;nica de Acceso a la Informaci&#243;n</th></tr>"
                        + "<tr style='border-bottom: 1px solid black;'><td>Fecha Registro:</td><td>" + fecha.split("-")[2] + "/" + fecha.split("-")[1] + "/" + fecha.split("-")[0] + "</td><td>N&#176; de Registro:</td><td>" + id + "</td></tr>"
                        + "<tr style='border-bottom: 1px solid black;'><td colspan='1'>Responsable de Entrega:</td><td colspan='3'>ING. ORLANDO RAMIREZ CUESTA</td></tr>"
                        + "<tr style='border-bottom: 1px solid black;'><td colspan='1'>Nombre / Raz&#243;n Social:</td><td colspan='3'>" + solicitud.getUsuario() + "</td></tr>"
                        + "<tr style='border-bottom: 1px solid black;'><td>Doc. de Indentidad:</td><td>" + solicitud.getDni() + "</td><td>Tel&#233;fono:</td><td>" + solicitud.getTelefono() + "</td></tr>"
                        + "<tr style='border-bottom: 1px solid black;'><td colspan='1'>Correo Electr&#243;nico:</td><td colspan='3'>" + solicitud.getCorreo() + "</td></tr>"
                        + "<tr style='border-bottom: 1px solid black;'><td colspan='1'>Domicilio:</td><td colspan='3'>" + solicitud.getDomicilio() + "</td></tr>"
                        + "<tr style='border-bottom: 1px solid black;'><td colspan='1'>Dependencia:</td><td colspan='3'>" + solicitud.getDependencia() + "</td></tr>"
                        + "<tr style='border-bottom: 1px solid black;'><td colspan='4'>Informaci&#243;n Solicitada:</td></tr>"
                        + "<tr style='border-bottom: 1px solid black;'><td colspan='4'>" + solicitud.getDescripcion() + "</td></tr>"
                        + "<tr style='border-bottom: 1px solid black;'><td colspan='1'>Forma de Entrega:</td><td colspan='3'>" + forma + "</td></tr>"
                        + "</table>"
                        + "<h2 style='font-size:10pt; color: blue; width:100%; text-align:center'>  <a href='http://www.peam.gob.pe/SolicitudPrint?id=" + id + "&format=pdf' target='_blank'>Imprimir Aqu&#237;</a></h2>";
            } else {
                msn = "Lo sentimos hubo un error inesperado en el sistema. Inténtelo más tarde";
            }
            /*
             * * envio de correo
             */
            Correo c = new CorreoDao().buscarCorreo(1);
            String to = c.getParaCorreo();
            String cc = solicitud.getCorreo().toString() + ", " + c.getCcCorreo();
            String from = c.getParteCorreo();

            String host = "correo.peam.gob.pe";
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", host);
            Session mailSession = Session.getDefaultInstance(properties);

            try {
                MimeMessage message = new MimeMessage(mailSession);
                message.setFrom(new InternetAddress(from));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
                message.setSubject("Solicitud Nro: " + id + " (Ley 27806) ");
                Multipart mp = new MimeMultipart();

                MimeBodyPart htmlPart = new MimeBodyPart();
                htmlPart.setContent(cabecera + msn1, "text/html");
                mp.addBodyPart(htmlPart);

                byte[] bs = JasperExportManager.exportReportToPdf(crearReporte(id));

                MimeBodyPart attachment = new MimeBodyPart();
                attachment.setFileName("solicitud-" + id + ".pdf");
                attachment.setContent(bs, "application/pdf");
                mp.addBodyPart(attachment);

                message.setContent(mp);
                Transport.send(message);
                result = "Se Envió el mensaje correctamente";
            } catch (JRException | SQLException | ServletException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
                Logger.getLogger(ParticipacionCiudadanaServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException mex) {
                result = "Error: Al enviar el correo al destinatario....";
            }


        } else {
            msn = "Codigo Seguridad CAPTCHA equivocada";
        }
        response.getWriter().print(msn + msn1);
    }

    public JasperPrint crearReporte(Integer id) throws JRException, SQLException, ServletException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException {
        ServletContext srvcon = getServletContext();
        String rutafisica = srvcon.getRealPath("//reportes//");
        JasperReport masterReport = (JasperReport) JRLoader.loadObject(rutafisica + "/solicitud.jasper");
        String rutaLogo = srvcon.getRealPath("//reportes//encabezadoPEAM.jpg");
        Map parametro = new HashMap();
        Locale locale = new Locale("es", "ES");
        parametro.put(JRParameter.REPORT_LOCALE, locale);
        parametro.put("p_id", id);
        parametro.put("ruta_logo", rutaLogo);
        JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, ConexionReporte.AbrirConexion());
        ConexionReporte.CerrarConexion();
        return jasperPrint;
    }

    private void insertarComentario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        Gson g = new Gson();
        ComentarioDao dao = new ComentarioDao();
        Comentario comentario = new Comentario();
        comentario.setUsuario(StringEscapeUtils.escapeHtml(request.getParameter("nombre").toUpperCase()));
        comentario.setDescripcion(StringEscapeUtils.escapeHtml(request.getParameter("coment").toUpperCase()));
        comentario.setTema(StringEscapeUtils.escapeHtml(request.getParameter("tema").toUpperCase()));
        comentario.setCorreo(request.getParameter("correo"));
        java.sql.Date d = new java.sql.Date(new java.util.Date().getTime());
        comentario.setAnho(String.valueOf(d.getYear() + 1900));
        comentario.setFecha(String.valueOf(d));
        String msn = null;

        String msn1 = null;
        String result;
        String cabecera = "Estimado(a), " + comentario.getUsuario() + " su comentario / sugerencia se recibi&#243; con &#233;xito, cualquier comunicaci&#243;n estaremos remitiendo por este mismo medio. No olvide revisar frecuentemente su correo.<br/>";
        if (request.getSession().getAttribute("captcha").equals(request.getParameter("usua_captcha"))) {

            if (dao.insertarComentario(comentario)) {
                msn = "<h1 style='font-size:12pt; text-align:center'>Su Comentario o Sugerencia ha sido enviada con copia a su correo </h1> "
                        + "<h2 style='font-size:10pt; text-align:center; color:red;'> (Revise en la carpeta de correo no deseado o Spam, de ser necesario)</h2>";
                String fecha = comentario.getFecha();
                msn1 = "<table border='1' collspacing='0' cellspacing ='0' id='tableta' style=\"width:100%; border:1px solid black; margin:20px auto 0px auto\">"
                        + "<tr><th colspan='4' style='font-weight: bold; text-align:center; padding:5px;'>Formulario de Comentario y Sugerencias</th></tr>"
                        + "<tr><td>Fecha Registro:</td><td>" + fecha.split("-")[2] + "/" + fecha.split("-")[1] + "/" + fecha.split("-")[0] + "</td></tr>"
                        + "<tr><td colspan='1'>Responsable de Entrega:</td><td colspan='3'>ING. ORLANDO RAMIREZ CUESTA</td></tr>"
                        + "<tr><td colspan='1'>Nombre / Raz&#243;n Social:</td><td colspan='3'>" + comentario.getUsuario() + "</td></tr>"
                        + "<tr><td colspan='1'>Correo Electr&#243;nico:</td><td colspan='3'>" + comentario.getCorreo() + "</td></tr>"
                        + "<tr><td colspan='1'>Tema:</td><td colspan='3'>" + comentario.getTema() + "</td></tr>"
                        + "<tr><td colspan='4'>Comentario o Sugerencia:</td></tr>"
                        + "<tr><td colspan='4'>" + comentario.getDescripcion() + "</td></tr>"
                        + "</table>"
                        + "";
            } else {
                msn = "Lo sentimos hubo un error inesperado en el sistema. Intentelo mas tarde";
            }
            // envio de correo


            Correo c = new CorreoDao().buscarCorreo(1);
            String to = c.getParaCorreo();
            String cc = comentario.getCorreo().toString() + ", " + c.getCcCorreo();
            String from = c.getParteCorreo();

            String host = "correo.peam.gob.pe";
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", host);
            Session mailSession = Session.getDefaultInstance(properties);

            try {
                MimeMessage message = new MimeMessage(mailSession);
                message.setFrom(new InternetAddress(from));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
                message.setSubject("Comentario y Sugerencia");
                Multipart mp = new MimeMultipart();

                MimeBodyPart htmlPart = new MimeBodyPart();
                htmlPart.setContent(cabecera + msn1, "text/html");
                mp.addBodyPart(htmlPart);

                message.setContent(mp);
                Transport.send(message);
                result = "Se Envió el mensaje correctamente";
            } catch (MessagingException mex) {
                result = "Error: Al enviar el correo al destinatario....";
            }
        } else {
            msn = "ER-CAPTCHA";
        }
        response.getWriter().print(msn + msn1);
    }

    private void listarReclamosForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            ReclamoDao reclamoDao = new ReclamoDao();
            String filtro = request.getParameter("filtro") == null ? "" : request.getParameter("filtro").toString();
            int limit = request.getParameter("limit") == null ? 6 : Integer.parseInt(request.getParameter("limit"));
            int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
            try {
                HashMap hm = new HashMap();
                hm.put("filtro", "%" + filtro.toUpperCase() + "%");
                hm.put("limit", limit);
                hm.put("start", start);
                List<Reclamo> reclamo = reclamoDao.listReclamoForAdmin(hm);
                Integer total = reclamoDao.listTotalReclamoForAdmin("%" + filtro.toUpperCase() + "%");
                out.print("<div id ='total' style='width: 100%;'>Total de Registros: " + total + " </div>");

                for (Reclamo bean : reclamo) {
                    String result = "";
                    result += "<div data=" + total + " class='notice ui-widget ui-widget-content ui-corner-all'>";
                    result += "<div class='notice-head'>";
                    result += "<h2 alt='" + bean.getUsuario() + "' class='notice-htitulo'>" + bean.getUsuario().substring(0, bean.getUsuario().length() > 90 ? 90 : bean.getUsuario().length()) + "</h2>";
                    result += "<h2 class='notice-hfecha'>" + bean.getFecha() + "</h2>";
                    result += "</div>";
                    result += "<div class='notice-description'>";
                    result += "<p>" + bean.getDescripcionAtencion().substring(0, bean.getDescripcionAtencion().length() > 150 ? 150 : bean.getDescripcionAtencion().length()) + " ...</p>";
                    result += "</div>";
                    result += "<div class='notice-tools'  data='" + bean.getNumero() + "," + bean.getAnio() + "'>";

                    if ("".equals(bean.getDetalleAcciones())) {
                        result += "<span class='notice-tsubido'><p>Aun no respuesta</b></p></span>";
                    } else {
                        result += "<span class='notice-tsubido'><p>Ya esta respuesta</b></p></span>";
                    }

                    result += "<span class='notice-tbutton' style='display:none;'>";
                    result += "<a role='a' href='./ReclamoPrint?id=" + bean.getNumero() + "&anho=" + bean.getAnio() + "&format=pdf' target='_blank' dir='imprimir' class='imprimir'>Imprimir</a>";
                    result += "<a role='a' dir='nuevo' class='editar'>Responder</a>";
                    result += "<a role='a' dir='eliminar' class='eliminar'>Eliminar</a>";
                    if (bean.getEstado()) {
                        result += "<a class='anular'>Ocultar</a>";
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

    private void listarSolicitudForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            SolicitudDao solicitudDao = new SolicitudDao();
            String filtro = request.getParameter("filtro") == null ? "" : request.getParameter("filtro").toString();
            int limit = request.getParameter("limit") == null ? 6 : Integer.parseInt(request.getParameter("limit"));
            int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));

            HashMap hm = new HashMap();
            hm.put("filtro", "%" + filtro.toUpperCase() + "%");
            hm.put("limit", limit);
            hm.put("start", start);
            List<Solicitud> solicitud = solicitudDao.listSolicitudForAdmin(hm);
            Integer total = solicitudDao.listTotalSolicitudForAdmin("%" + filtro.toUpperCase() + "%");
            String descripcion = "";
            out.print("<div id ='total' style='width: 100%;'>Total de Registros: " + total + " </div>");
            for (Solicitud bean : solicitud) {
                String result = "";
                descripcion = bean.getDescripcion().replaceAll("\\<.*?\\>", "");
                result += "<div data=" + total + " class='notice ui-widget ui-widget-content ui-corner-all'>";
                result += "<div class='notice-head'>";
                result += "<h2 alt='" + bean.getUsuario() + "' class='notice-htitulo'> Solicitud N° " + bean.getSoliId() + ": " + bean.getUsuario().substring(0, bean.getUsuario().length() > 90 ? 90 : bean.getUsuario().length()) + "</h2>";
                result += "<h2 class='notice-hfecha'>" + bean.getFechaRegistro() + "</h2>";
                result += "</div>";
                result += "<div class='notice-description'>";
                result += "<p>" + descripcion.substring(0, descripcion.length() > 150 ? 150 : descripcion.length()) + " ...</p>";
                result += "</div>";

                result += "<div class='notice-tools'  data='" + bean.getSoliId() + "'>";

                if ("".equals(bean.getFechaAtendido())) {
                    result += "<span class='notice-tsubido'><p>Aun no Atendida</b></p></span>";
                } else {
                    result += "<span class='notice-tsubido'><p>Atendida el: " + bean.getFechaAtendido() + " </b></p></span>";
                }

                result += "<span class='notice-tbutton' style='display:none;'>";
                result += "<a role='a' href='./SolicitudPrint?id=" + bean.getSoliId() + "&format=pdf' target='_blank' dir='imprimir' class='imprimir'>Imprimir</a>";
                result += "<a role='a' dir='ver' class='editar'>Ver Detalle</a>";
                result += "<a role='a' dir='eliminar' class='eliminar'>Eliminar</a>";
                result += "</span>";
                result += "</div>";
                result += "</div>";
                out.print(result);
            }
        }
    }

    private void getReclamoForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            String id = request.getParameter("id");
            HashMap hm = new HashMap();
            hm.put("numero", request.getParameter("id").split(",")[0]);
            hm.put("anho", request.getParameter("id").split(",")[1]);
            ReclamoDao dao = new ReclamoDao();
            Reclamo reclamo = dao.getReclamoForAdmin(hm);
            HashMap hmOut = new HashMap();
            Gson g = new Gson();
            hmOut.put("reclamo", reclamo);
            String arg = g.toJson(hmOut);
            response.getWriter().print(arg);
        }
    }

    private void getSolicitudForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            Integer id = Integer.parseInt(request.getParameter("id"));
            SolicitudDao dao = new SolicitudDao();
            Solicitud solicitud = dao.getSolicitudForAdmin(id);
            HashMap hm = new HashMap();
            Gson g = new Gson();
            hm.put("solicitud", solicitud);
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void actualizarSolicitud(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            Gson g = new Gson();
            HashMap hm = new HashMap();
            java.sql.Date d = new java.sql.Date(new java.util.Date().getTime());
            SolicitudDao dao = new SolicitudDao();
            Solicitud solicitud = new Solicitud();
            solicitud.setSoliId(Integer.parseInt(request.getParameter("id")));
            solicitud.setFechaAtendido(String.valueOf(d));
            solicitud.setEstado(Boolean.parseBoolean(request.getParameter("estado")));

            if (dao.actualizarSolicitud(solicitud)) {
                hm.put("success", true);
                hm.put("msg", "La Solicitud se ha sido Atendida");
            } else {
                hm.put("success", false);
                hm.put("msg", "La Solicitud no se actualiz&oacute; correctamente, comuniquese con el administrador del sistema");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void actualizarReclamo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            Gson g = new Gson();
            HashMap hm = new HashMap();
            ReclamoDao dao = new ReclamoDao();
            Reclamo reclamo = new Reclamo();
            reclamo.setNumero(request.getParameter("id").split(",")[0]);
            reclamo.setAnio(request.getParameter("id").split(",")[1]);
            reclamo.setDescripcionAtencion(request.getParameter("reclamo"));
            reclamo.setDetalleAcciones(request.getParameter("acciones").toUpperCase());
            String fecha = String.valueOf(new Date(new java.util.Date().getTime()));
            reclamo.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
            reclamo.setEmail(request.getParameter("email"));
            reclamo.setFechaAcciones(fecha);
            reclamo.setFecha(request.getParameter("fecha"));

            hm.put("numero", reclamo.getNumero());
            hm.put("anho", reclamo.getAnio());

            String msn = null;

            if (dao.actualizarReclamo(reclamo)) {
                //Reclamo r = new ReclamoDao().getReclamoForAdmin(hm);
                msn = "<h2> Su reclamo Nro. " + reclamo.getNumero() + "-" + reclamo.getAnio() + ", efectuado el " + reclamo.getFecha() + "; con el siguiente contenido:</h2>"
                        + "<div style='display: block; width: 80%; font-style:italic; text-align: justify; color:#ccc; margin-top: 20px; margin-bottom:20px; border-bottom: 2px solid #cce;'>" + reclamo.getDescripcionAtencion() + "</div>"
                        + "<h2>Ha sido respuesto de la siguiente manera:</h2>"
                        + "<div style='display: block; width: 80%;'>" + reclamo.getDetalleAcciones() + "</div>";

                if (Boolean.parseBoolean(request.getParameter("send"))) {
                    Correo c = new CorreoDao().buscarCorreo(1);
                    String to = reclamo.getEmail();
                    String from = c.getParteCorreo();

                    String host = "correo.peam.gob.pe";
                    Properties properties = System.getProperties();
                    properties.setProperty("mail.smtp.host", host);
                    Session mailSession = Session.getDefaultInstance(properties);

                    try {
                        MimeMessage message = new MimeMessage(mailSession);
                        message.setFrom(new InternetAddress(from));
                        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                        message.setSubject("Reclamo Nro: " + reclamo.getNumero() + "-" + reclamo.getAnio());
                        Multipart mp = new MimeMultipart();

                        MimeBodyPart htmlPart = new MimeBodyPart();
                        htmlPart.setContent(msn, "text/html");
                        mp.addBodyPart(htmlPart);

                        message.setContent(mp);
                        Transport.send(message);
                        hm.put("msg", "Se Envió el mensaje correctamente");

                    } catch (MessagingException mex) {
                        hm.put("msg", "Error: Al enviar el correo al destinatario....");
                    }

                }
                hm.put("success", true);
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void listarComentarioForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            ComentarioDao comentarioDao = new ComentarioDao();
            String filtro = request.getParameter("filtro") == null ? "" : request.getParameter("filtro").toString();
            int limit = request.getParameter("limit") == null ? 6 : Integer.parseInt(request.getParameter("limit"));
            int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
            try {
                HashMap hm = new HashMap();
                hm.put("filtro", "%" + filtro.toUpperCase() + "%");
                hm.put("limit", limit);
                hm.put("start", start);
                List<Comentario> comentario = comentarioDao.listComentarioForAdmin(hm);
                Integer total = comentarioDao.listTotalComentarioForAdmin("%" + filtro.toUpperCase() + "%");
                out.print("<div id ='total' style='width: 100%;'>Total de Registros: " + total + " </div>");
                for (Comentario bean : comentario) {
                    String result = "";
                    String descripcion = bean.getDescripcion().replaceAll("\\<.*?\\>", "");

                    result += "<div data=" + total + " class='notice ui-widget ui-widget-content ui-corner-all'>";
                    result += "<div class='notice-head'>";
                    result += "<h2 alt='" + bean.getTema() + "' class='notice-htitulo'>" + bean.getTema().substring(0, bean.getTema().length() > 90 ? 90 : bean.getTema().length()) + "</h2>";
                    result += "<h2 class='notice-hfecha'>" + bean.getFecha() + "</h2>";
                    result += "</div>";
                    result += "<div class='notice-description'>";
                    result += "<p>" + descripcion.substring(0, descripcion.length() > 150 ? 150 : descripcion.length()) + " ...</p>";
                    result += "</div>";
                    result += "<div class='notice-tools'  data='" + bean.getNumero() + "'>";
                    result += "<span class='notice-tsubido'><p>" + bean.getUsuario().substring(0, bean.getUsuario().length() > 90 ? 90 : bean.getUsuario().length()) + "</b></p></span>";

                    result += "<span class='notice-tbutton' style='display:none;'>";
                    result += "<a role='a' dir='editar' class='editar'>Editar</a>";
                    result += "<a role='a' dir='eliminar' class='eliminar'>Eliminar</a>";

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

    private void getComentarioForAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            String id = request.getParameter("id");
            ComentarioDao dao = new ComentarioDao();
            Comentario comentario = dao.getComentarioForAdmin(id);
            HashMap hm = new HashMap();
            Gson g = new Gson();
            hm.put("comentario", comentario);
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void actualizarComentario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            Gson g = new Gson();
            HashMap hm = new HashMap();
            ComentarioDao dao = new ComentarioDao();
            Comentario comentario = new Comentario();
            comentario.setNumero(request.getParameter("id"));
            comentario.setDescripcion(request.getParameter("comentario"));
            comentario.setTema(request.getParameter("tema"));
            comentario.setEstado(Boolean.parseBoolean(request.getParameter("estado")));

            if (dao.actualizarComentario(comentario)) {
                hm.put("success", true);
                hm.put("msg", "El Comentario/Sugerencia se actualiz&oacute; correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "El Comentario/Sugerencia no se actualiz&oacute; correctamente, comuniquese con el administrador del sistema");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void eliminarReclamo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            ReclamoDao reclamoDao = new ReclamoDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();
            hm.put("numero", request.getParameter("id").split(",")[0]);
            hm.put("anho", request.getParameter("id").split(",")[1]);
            if (reclamoDao.eliminarReclamo(hm)) {
                hm.put("success", "true");
                hm.put("msg", "El Reclamo se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar el Reclamo");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void eliminarSolicitud(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            SolicitudDao soliDao = new SolicitudDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();

            if (soliDao.eliminarSolicitud(Integer.parseInt(request.getParameter("id")))) {
                hm.put("success", "true");
                hm.put("msg", "La Solicitud se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar La Solicitud");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void eliminarComentario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            ComentarioDao comentDao = new ComentarioDao();
            Gson g = new Gson();
            HashMap hm = new HashMap();

            if (comentDao.eliminarComentario(request.getParameter("id"))) {
                hm.put("success", "true");
                hm.put("msg", "El Comentario/Sugerencia se elimino correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar el Comentario/Sugerencia");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }

    private void getAlertaSolicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        SolicitudDao dao = new SolicitudDao();
        List<Solicitud> bean = dao.getAlertaForAdmin();
        HashMap hashMapOut = new HashMap();
        if (!bean.isEmpty()) {
            hashMapOut.put("msn", "Hay: " + bean.size() + " Solicitud Pendiente(s), REVISE SOLICITUD DE TRANPASPARENCIA o <a href='./WebContent?action=Solicitud'>CLICK AQUI</a>");
            hashMapOut.put("title", "ALERTA HAY SOLICITUD(ES) DE TRANPARENCIA PENDIENTE(S)");
            hashMapOut.put("image", "./resources/images/dialog-warning.png");
        }
        String arg = gson.toJson(hashMapOut);
        out.print(arg);
    }

    private void getCorreo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.print(new Gson().toJson(new CorreoDao().buscarCorreo(request.getParameter("tipo") == null ? 1 : Integer.parseInt(request.getParameter("tipo")))));
        } catch (Exception e) {
            out.print(e.getMessage());
        } finally {
            out.close();
        }
    }

    private void actualizarCorreo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("application/json;charset=UTF-8");
            Gson g = new Gson();
            HashMap hm = new HashMap();
            CorreoDao dao = new CorreoDao();
            Correo c = new Correo();
            c.setId(Integer.parseInt(request.getParameter("modulo")));
            c.setParaCorreo(request.getParameter("para"));
            c.setCcCorreo(request.getParameter("cc"));
            c.setParteCorreo(request.getParameter("de"));
            c.setMensajeCorreo(request.getParameter("contenido"));
            c.setEstado(request.getParameter("estado") == null ? false : true);
            if (dao.actualizarCorreo(c)) {
                hm.put("success", "true");
                hm.put("msg", "La Configuracion Se guardó correctamente");
            } else {
                hm.put("success", "false");
                hm.put("msg", "Hubo un problema al eliminar la Configuración");
            }
            String arg = g.toJson(hm);
            response.getWriter().print(arg);
        }
    }
}
