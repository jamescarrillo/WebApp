/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.servlet.reportes;

import gob.peam.config.ConexionReporte;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.xml.sax.SAXException;

/**
 *
 * @author alabajos
 */
@WebServlet(name = "VehiculoPrint", urlPatterns = {"/VehiculoPrint"})
public class VehiculoPrint extends HttpServlet {

   public Integer mes;
   
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        String formato = request.getParameter("format");
        String anho = request.getParameter("anho");
        mes = request.getParameter("mes") == null ? 0 : Integer.parseInt(request.getParameter("mes"));
        
        try {
            ServletOutputStream ouputStream = null;

            switch (formato) {
                case "pdf":
                    byte[] bs = JasperExportManager.exportReportToPdf(crearReporte(anho));
                    response.setContentType("application/pdf");
                    response.setContentLength(bs.length);
                    ouputStream = response.getOutputStream();
                    ouputStream.write(bs, 0, bs.length);
                    ouputStream.flush();
                    ouputStream.close();
                    break;
                case "word":
                    JasperPrint print1 = crearReporte(anho);
                    ServletContext srvcon1 = getServletContext();
                    String rutafisica1 = srvcon1.getRealPath("//reportes//");
                    JRRtfExporter exportador1 = new JRRtfExporter();
                    exportador1.setParameter(JRExporterParameter.JASPER_PRINT, print1);
                    exportador1.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, rutafisica1 + "/vehiculo.doc");
                    exportador1.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS, true);
                    exportador1.exportReport();
                    FileInputStream entrada1 = new FileInputStream(rutafisica1 + "/vehiculo.doc");
                    byte[] lectura1 = new byte[entrada1.available()];
                    entrada1.read(lectura1);
                    response.setContentType("application/word");
                    response.setHeader("Content-Disposition", "attachment; filename=vehiculo.doc");
                    response.setContentLength(lectura1.length);
                    response.getOutputStream().write(lectura1);
                    response.getOutputStream().flush();
                    response.getOutputStream().close();
                    entrada1.close();
                    break;

                case "excel":
                    JasperPrint print2 = crearReporte(anho);
                    ServletContext srvcon = getServletContext();
                    String rutafisica = srvcon.getRealPath("//reportes//");
                    JRXlsExporter exportador = new JRXlsExporter();
                    exportador.setParameter(JRExporterParameter.JASPER_PRINT, print2);
                    exportador.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, rutafisica + "/vehiculo.xls");
                    exportador.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS, true);
                    exportador.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, false);
                    exportador.setParameter(JRXlsAbstractExporterParameter.IS_IGNORE_CELL_BORDER, false);
                    exportador.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, true);
                    exportador.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, true);
                    exportador.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, true);
                    exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, true);
                    exportador.exportReport();
                    FileInputStream entrada = new FileInputStream(rutafisica + "/vehiculo.xls");
                    byte[] lectura = new byte[entrada.available()];
                    entrada.read(lectura);
                    response.setContentType("application/vnd.ms-excel");
                    response.setHeader("Content-Disposition", "attachment;filename = vehiculo.xls");
                    response.setContentLength(lectura.length);
                    response.getOutputStream().write(lectura);
                    response.getOutputStream().flush();
                    response.getOutputStream().close();
                    entrada.close();
                    break;

                case "odt":
                    JasperPrint print3 = crearReporte(anho);
                    ServletContext srvcon2 = getServletContext();
                    String rutafisica2 = srvcon2.getRealPath("//reportes//");
                    JROdtExporter exportador2 = new JROdtExporter();
                    exportador2.setParameter(JRExporterParameter.JASPER_PRINT, print3);
                    exportador2.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, rutafisica2 + "/vehiculo.odt");
                    exportador2.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS, true);
                    exportador2.exportReport();
                    FileInputStream entrada2 = new FileInputStream(rutafisica2 + "/vehiculo.odt");
                    byte[] lectura2 = new byte[entrada2.available()];
                    entrada2.read(lectura2);
                    response.setContentType("application/odt");
                    response.setHeader("Content-Disposition", "attachment; filename=vehiculo.odt");
                    response.setContentLength(lectura2.length);
                    response.getOutputStream().write(lectura2);
                    response.getOutputStream().flush();
                    response.getOutputStream().close();
                    entrada2.close();
                    break;
            }
        } catch (JRException | SQLException | ClassNotFoundException | ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(VehiculoPrint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JasperPrint crearReporte(String anho) throws JRException, SQLException, ServletException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException {
        ServletContext srvcon = getServletContext();
        String rutafisica = srvcon.getRealPath("//reportes//");

        JasperReport masterReport = (JasperReport) JRLoader.loadObject(rutafisica + "/vehiculo.jasper");

        String rutaLogo = srvcon.getRealPath("//reportes//encabezadoPEAM.jpg");
        Map parametro = new HashMap();
        Locale locale = new Locale("en", "US");
        parametro.put(JRParameter.REPORT_LOCALE, locale);
        parametro.put("p_anho_p", anho);
        
        parametro.put("p_mes_p", mes);
        
        parametro.put("p_logo", rutaLogo);
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, ConexionReporte.AbrirConexion());
        ConexionReporte.CerrarConexion();
        return jasperPrint;
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
