/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import com.google.gson.Gson;
import gob.peam.administracion.beans.Entidad;
import gob.peam.administracion.dao.EntidadDao;
import gob.peam.administracion.dao.SesionDao;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author jpgprog84
 */
@SuppressWarnings("serial")
@WebServlet(name = "Entidad", urlPatterns = {"/Entidad"})
public class EntidadServlet extends HttpServlet {

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

//    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        request.setAttribute("navigation", "<a href='./Intranet'>Inicio</a>|<a class='active'>Entidad</a>");
//        ModuloDao dao = new ModuloDao();
//        request.setAttribute("modulos", dao.listarModulosForMenus());
//        request.setAttribute("opcion", "ul1-ent");
//        request.setAttribute("javascript", "entidad");
//        request.getRequestDispatcher("./WEB-INF/Administracion/entidad.jsp").forward(request, response);
//
//    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void mostrarEntidad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        EntidadDao entidadDao = new EntidadDao();
        Gson gson = new Gson();
        HashMap hm = new HashMap();
        hm.put("entidad", entidadDao.seleccionarEntidad());
        String s = gson.toJson(hm);
        response.getWriter().print(s);
    }

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
            SesionDao sesionDao = new SesionDao();
        if (!sesionDao.verificarSesion(request, response)) {
            response.sendRedirect("./Login");
        } else {
            String action = request.getParameter("action") == null ? "" : request.getParameter("action");
            switch (action) {
                /*case "":
                    index(request, response);
                    break;*/
                case "getEntidad":
                    mostrarEntidad(request, response);
                    break;
                case "updateDataEntidad":
                    actualizarDataEntidad(request, response);
                    break;
                case "upFileImg":
                    try {
                        subirTemporalImg(request, response);
                    } catch (Exception ex) {
                        Logger.getLogger(EntidadServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "updateLogo":
                    updateLogoEntidad(request, response);
                    break;
                case "getImagenEntidad":
                    obtenerImagen(request, response);

            }
        }
    }

    @SuppressWarnings({"rawtypes", "unused"})
    private void subirTemporalImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Login");
        } else {            
            String rutaTemporal = getServletContext().getRealPath("/") + "tmp/";
            FileItemFactory file_factory = new DiskFileItemFactory();
            /*
             * ServletFileUpload esta clase convierte los input file a FileItem
             */
            ServletFileUpload servlet_up = new ServletFileUpload(file_factory);
            /*
             * sacando los FileItem del ServletFileUpload en una lista
             */
            List items = servlet_up.parseRequest(request);
            request.getSession().setAttribute("cambioImagen", false);
            for (int i = 0; i < items.size(); i++) {
                FileItem item = (FileItem) items.get(i);
                if (!item.isFormField()) {
                    File archivo_server = new File(rutaTemporal + request.getSession().getId());
                    request.getSession().setAttribute("cambioImagen", true);
                    item.write(archivo_server);
                    response.getWriter().print("<img id='tmp-image'  src='tmp/" + request.getSession().getId() + "' />");
                }
            }
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked", "unused", "resource"})
    private void updateLogoEntidad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Login");
        } else {
            if (Boolean.parseBoolean(request.getSession().getAttribute("cambioImagen").toString()) == true) {
                String rutaTemporal = getServletContext().getRealPath("/") + "tmp/";
                File archivo_server = new File(rutaTemporal + request.getSession().getId());
                Entidad entidad = new Entidad();
                entidad.setIdEntidad(Integer.parseInt(request.getParameter("idEntidad")));
                // lo abrimos. Lo importante es que sea un InputStream
                InputStream is = new FileInputStream(archivo_server);
                // creamos el buffer
                byte[] buffer = new byte[(int) archivo_server.length()];
                // leemos el archivo al buffer
                int readers = is.read(buffer);
                entidad.setLogo(buffer); // lo guardamos en la entidad
                EntidadDao dao = new EntidadDao();
                Gson g = new Gson();
                HashMap hm = new HashMap();
                if (dao.actualizarImagen(entidad)) {
                    hm.put("success", true);
                    hm.put("msg", "La Imagen se Guardo Correctamente");
                    // ahora eliminamos el archivo
                    archivo_server.delete();
                } else {
                    hm.put("success", false);
                    hm.put("msg", "Hubo un Problema al Guardar la Imagen");
                }
                String arg = g.toJson(hm);
                response.getWriter().print(arg);
            }
        }
    }

    private void obtenerImagen(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        EntidadDao dao = new EntidadDao();
        Entidad entidad = dao.seleccionarLogoEntidad();
        ServletOutputStream out = response.getOutputStream();
        if (entidad.getLogo() == null) {
            String rutaTemporal = getServletContext().getRealPath("/") + "resources/images/nofound.png";
            byte[] bytes;
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(rutaTemporal))) {
                bytes = new byte[in.available()];
                in.read(bytes);
                in.close();
            }
            out.write(bytes);
        } else {
            out.write(entidad.getLogo());
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void actualizarDataEntidad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        EntidadDao entidadDao = new EntidadDao();
        HashMap hm = new HashMap();
        Entidad entidad = new Entidad();
        entidad.setIdEntidad(Integer.parseInt(request.getParameter("idEntidad")));
        entidad.setAbreviatura(request.getParameter("abreviatura").trim().toUpperCase());
        entidad.setCarpetaSiaf(request.getParameter("carpetaSiaf"));
        entidad.setDireccion(request.getParameter("direccion").trim().toUpperCase());
        entidad.setFrase(request.getParameter("frase").trim().toUpperCase());
        entidad.setNombre(request.getParameter("nombre").trim().toUpperCase());
        entidad.setRepresentanteLegal(request.getParameter("representanteLegal").trim().toUpperCase());
        entidad.setRuc(request.getParameter("ruc"));
        entidad.setSecuenciaEjecutora(request.getParameter("secuenciaEjecutora"));
        entidad.setPie(request.getParameter("pie"));
        entidad.setVersion(request.getParameter("version"));
        if (entidadDao.actualizarData(entidad)) {
            hm.put("success", true);
            hm.put("msg", "Los Datos de la Entidad se Actualizaron Correctamente");
        } else {
            hm.put("success", false);
            hm.put("msg", "Hubo un Problema al Actualizar los Datos de la Entidad");
        }
        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }
}
