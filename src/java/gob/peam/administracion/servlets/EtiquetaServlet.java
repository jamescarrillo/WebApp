/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import com.google.gson.Gson;
import gob.peam.administracion.beans.Etiqueta;
import gob.peam.administracion.dao.EtiquetaDao;
import gob.peam.administracion.dao.SesionDao;
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
@WebServlet(name = "Etiqueta", urlPatterns = {"/Etiqueta"})
public class EtiquetaServlet extends HttpServlet {

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
            SesionDao sesionDao = new SesionDao();
        if (!sesionDao.verificarSesion(request, response)) {
            response.sendRedirect("./Login");
        } else {
            String action = request.getParameter("action") == null ? "" : request.getParameter("action");
            switch (action) {
                case "ListarEtiquetaForCombo":
                    listarEtiquetaForCombo(request, response);
                    break;
                case "InsertarEtiqueta":
                    insertarEtiqueta(request, response);
                    break;
                case "ActualizarEtiqueta":
                    actualizarEtiqueta(request, response);
                    break;
                case "EliminarEtiqueta":
                    eliminarEtiqueta(request, response);
            }
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

    private void listarEtiquetaForCombo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        EtiquetaDao dao = new EtiquetaDao();
        String result = "";
        for (Etiqueta etiqueta : dao.listarEtiqueta()) {
            result += "<option value='" + etiqueta.getIdEtiqueta() + "'>" + etiqueta.getDescripcion() + "</option>";
        }
        response.getWriter().print(result);
    }

    private void insertarEtiqueta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        HashMap hm = new HashMap();
        Gson g = new Gson();
        EtiquetaDao dao = new EtiquetaDao();
        Etiqueta etiqueta = new Etiqueta();
        etiqueta.setDescripcion(request.getParameter("descripcion").toUpperCase().trim());
        if (dao.existeEtiqueta(etiqueta.getDescripcion())) {
            hm.put("success", false);
            hm.put("msg", "Ya Existe el Grupo");
        } else {
            if (dao.insertarEtiqueta(etiqueta) != null) {
                hm.put("success", true);
                hm.put("id", etiqueta.getIdEtiqueta());
                hm.put("msg", "Se Ingreso Correctamente el Grupo");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo un Problema al Insertar el Grupo");
            }
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void actualizarEtiqueta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        HashMap hm = new HashMap();
        Gson g = new Gson();
        EtiquetaDao dao = new EtiquetaDao();
        Etiqueta etiqueta = new Etiqueta();
        etiqueta.setIdEtiqueta(Integer.parseInt(request.getParameter("idEtiqueta")));
        etiqueta.setDescripcion(request.getParameter("descripcion").trim().toUpperCase());

        Etiqueta temp = dao.buscarEtiqueta(etiqueta.getDescripcion());
        if (temp == null) {
            //no existe actualizamos
            if (dao.actualizarEtiqueta(etiqueta)) {
                hm.put("success", true);
                hm.put("msg", "El Grupo se Actualizó Correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo Problemas a la hora de Actualizar el Grupo");
            }
        } else {
            if (temp.getIdEtiqueta() == etiqueta.getIdEtiqueta()) {
                if (dao.actualizarEtiqueta(etiqueta)) {
                    hm.put("success", true);
                    hm.put("msg", "El Grupo se Actualizó Correctamente");
                } else {
                    hm.put("success", false);
                    hm.put("msg", "Hubo Problemas a la hora de Actualizar el Grupo");
                }
            } else {
                hm.put("success", false);
                hm.put("msg", "El Nombre del Grupo Ya Se Encuentra En Otro Registro");
            }
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void eliminarEtiqueta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        HashMap hm = new HashMap();
        Gson g = new Gson();
        EtiquetaDao dao = new EtiquetaDao();
        if (dao.tieneDependencias(Integer.parseInt(request.getParameter("idEtiqueta")))) {
            hm.put("success", false);
            hm.put("msg", "No se Puede Eliminar por que Otros Dependen de El");
        } else {
            if (dao.eliminarEtiqueta(Integer.parseInt(request.getParameter("idEtiqueta")))) {
                hm.put("success", true);
                hm.put("msg", "Se Eliminó Correctamente el Grupo");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo Problemas a la hora de Eliminar el Grupo");
            }
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }
}
