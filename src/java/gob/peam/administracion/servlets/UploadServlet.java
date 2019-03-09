/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author jprada
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/Upload"})
public class UploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     *
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.write("call POST with multipart form data");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     *
     */
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            throw new IllegalArgumentException("Request is not multipart, please 'multipart/form-data' enctype for your form.");
        }
        String carpeta = request.getParameter("tmp") == null ? "archivos" : request.getParameter("tmp");
        ServletFileUpload uploadHandler = new ServletFileUpload(new DiskFileItemFactory());
        PrintWriter writer = response.getWriter();
        response.setContentType("text/plain");
        ServletContext srvcon = getServletContext();
        String ruta = srvcon.getRealPath("//"+carpeta+"//");
        try {
            List<FileItem> items = uploadHandler.parseRequest(request);
            for (FileItem item : items) {
                if (!item.isFormField()) {
                    //File file = File.createTempFile(ruta + "/" + item.getName(), "");
                    //item.write(file);
                    Random r = new Random();
                    int aleatorio = r.nextInt();
                    File archivo_server = new File(ruta + "/C_" + aleatorio+item.getName());
                    item.write(archivo_server);
                    writer.write("{\"name\":\"" + item.getName()+ "\",\"nametrue\":\"" + "C_" + aleatorio+item.getName() + "\",\"type\":\"" + item.getContentType() + "\",\"size\":\"" + item.getSize() + "\"}");
                    break; // assume we only get one file at a time
                }
            }
        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            writer.close();
        }
    }
}
