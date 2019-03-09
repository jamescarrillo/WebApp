/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import com.google.gson.Gson;
import gob.peam.administracion.beans.Prefijo;
import gob.peam.administracion.dao.PrefijoDao;
import gob.peam.administracion.dao.SesionDao;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jpgprog84
 */
@WebServlet(name = "PrefijoServlet", urlPatterns = {"/Prefijo"})
public class PrefijoServlet extends HttpServlet {

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
            SesionDao sesionDao = new SesionDao();
        if (!sesionDao.verificarSesion(request, response)) {
            response.sendRedirect("./Login");
        } else {
            String action = request.getParameter("action") == null ? "" : request.getParameter("action");
            switch (action) {
                case "ListarPrefijos":
                    listarPrefijos(request, response);
                    break;
                case "InsertarPrefijo":
                    insertarPrefijo(request, response);
                    break;
                case "ActualizarPrefijo":
                    actualizarPrefijo(request, response);
                    break;
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

    private void listarPrefijos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrefijoDao dao = new PrefijoDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        List<Prefijo> list = dao.listarPrefijos(request.getSession().getAttribute("anio").toString());
        hm.put("prefijos", list);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void insertarPrefijo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        HashMap hm = new HashMap();
        Gson g = new Gson();
        PrefijoDao dao = new PrefijoDao();
        String ordenCompra = request.getParameter("ordenCompra");
        String ordenServicio = request.getParameter("ordenServicio");
        String prefijo = request.getParameter("prefijo").toUpperCase();
        hm.put("anio", request.getSession().getAttribute("anio"));
        hm.put("prefijo", prefijo);
        if (dao.buscarPrefijo(hm) == null) {
            Prefijo p = new Prefijo();
            p.setAnio(request.getSession().getAttribute("anio").toString());
            p.setOrdenCompra(ordenCompra);
            p.setOrdenServicio(ordenServicio);
            p.setPrefijo(prefijo);
            if (dao.insertPrefijo(p)) {
                hm = new HashMap();
                hm.put("success", true);
                hm.put("msg", "Se Ingreso Correctamente el Prefijo");
            } else {
                hm = new HashMap();
                hm.put("success", false);
                hm.put("msg", "Hubo un Problema al Insertar el Prefijo");
            }
        } else {
            hm = new HashMap();
            hm.put("success", false);
            hm.put("msg", "El Prefijo Ya Existe");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }

    private void actualizarPrefijo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        HashMap hm = new HashMap();
        Gson g = new Gson();
        PrefijoDao dao = new PrefijoDao();
        String ordenCompra = request.getParameter("ordenCompra");
        String ordenServicio = request.getParameter("ordenServicio");
        String prefijo = request.getParameter("prefijo").toUpperCase();
        hm.put("anio", request.getSession().getAttribute("anio"));
        hm.put("prefijo", prefijo);

        Prefijo p = new Prefijo();
        p.setAnio(request.getSession().getAttribute("anio").toString());
        p.setOrdenCompra(ordenCompra);
        p.setOrdenServicio(ordenServicio);
        p.setPrefijo(prefijo);
        if (dao.actualizarPrefijo(p)) {
            hm = new HashMap();
            hm.put("success", true);
            hm.put("msg", "Se Actualizo Correctamente el Prefijo");
        } else {
            hm = new HashMap();
            hm.put("success", false);
            hm.put("msg", "Hubo un Problema al Actualizar el Prefijo");
        }

        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }
}
