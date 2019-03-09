/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.administracion.servlets;

import com.google.gson.Gson;
import gob.peam.administracion.beans.Mes;
import gob.peam.administracion.beans.Periodo;
import gob.peam.administracion.dao.PeriodoDao;
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
@WebServlet(name = "PeriodoServlet", urlPatterns = {"/Periodo"})
public class PeriodoServlet extends HttpServlet {

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
                case "ListarAnhos":
                    listarAnhos(request, response);
                    break;
                case "BuscarPeriodo":
                    buscarPeriodo(request, response);
                    break;
                case "ListarMeses":
                    listarMeses(request, response);
                    break;
                case "ActualizarPeriodo":
                    actualizarPeriodo(request, response);
                    break;
                case "NuevoPeriodo":
                    nuevoPeriodo(request, response);
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

    private void listarAnhos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PeriodoDao dao = new PeriodoDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        List<Periodo> list = dao.listarPeriodos();
        hm.put("periodos", list);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }
    
    private void buscarPeriodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PeriodoDao dao = new PeriodoDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        String anio = request.getParameter("anho");
        Periodo periodo = dao.buscarPeriodo(anio);
        hm.put("periodo", periodo);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }
    
    private void listarMeses(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PeriodoDao dao = new PeriodoDao();
        Gson g = new Gson();
        HashMap hm = new HashMap();
        String anio = request.getParameter("anho");
        List<Mes> list = dao.listarMeses(anio);
        hm.put("meses", list);
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }
    
    private void actualizarPeriodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        HashMap hm = new HashMap();
        Gson g = new Gson();
        PeriodoDao dao = new PeriodoDao();
        Periodo periodo = new Periodo();
        periodo.setAnio(request.getParameter("anho"));
        periodo.setDescripcion(request.getParameter("descripcion").trim().toUpperCase());
        if (dao.actualizarPeriodo(periodo)) {
            hm.put("success", true);
            hm.put("msg", "El Periodo se Actualizó Correctamente");
        } else {
            hm.put("success", false);
            hm.put("msg", "Hubo Problemas a la hora de Actualizar el Periodo");
        }
        String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }
    
    private void nuevoPeriodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        HashMap hm = new HashMap();
        Gson g = new Gson();
        PeriodoDao dao = new PeriodoDao();
        Periodo periodo = dao.buscarPeriodoActivo();
        Mes mes = dao.buscarMesActivo(periodo.getAnio());
        if (Integer.parseInt(mes.getId()) + 1 > 12) {
            if (dao.incrementarAnio(periodo.getAnio())) {
                hm = new HashMap();
                hm.put("success", true);
                hm.put("msg", "El Periodo se Incremento Correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo Problemas a la hora de Incrementar el Periodo");
            }
        } else {
            hm.put("anio", periodo.getAnio());            
            hm.put("idMes", String.valueOf(Integer.parseInt(mes.getId())+1).length()==2?String.valueOf(Integer.parseInt(mes.getId())+1):"0"+String.valueOf(Integer.parseInt(mes.getId())+1));
            if (dao.incrementarMes(hm)) {
                hm = new HashMap();
                hm.put("success", true);
                hm.put("msg", "El Periodo se Incremento Correctamente");
            } else {
                hm.put("success", false);
                hm.put("msg", "Hubo Problemas a la hora de Incrementar el Periodo");
            }
        }
         String arg = g.toJson(hm);
        response.getWriter().print(arg);
    }
}
