/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.peam.servlet;

import com.google.gson.Gson;
import gob.peam.beans.Busqueda;
import gob.peam.dao.BusquedaDao;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "BusquedaServlet", urlPatterns = {"/Busqueda"})
public class BusquedaServlet extends HttpServlet {

    private static final long serialVersionUID = 11;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String query = "";
        String filter = "";
        HashMap hashMap = new HashMap();
        HashMap hashMapOut = new HashMap();
        List<Busqueda> lista = null;
        BusquedaDao busquedaDao = new BusquedaDao();
        lista = busquedaDao.listarBusqueda(hashMap);
        int limit = request.getParameter("limit") == null ? 20 : Integer.parseInt(request.getParameter("limit"));
        int start = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        if (!"".equals(request.getParameter("filter"))) {
            filter = request.getParameter("filter");
        }

        query = "SELECT titulo_formato t, descripcion d, "
                + " CASE WHEN titulo_formato='Misión' THEN './LaInstitucion?action=Vision'"
                + " WHEN titulo_formato='Visión' THEN './LaInstitucion?action=Vision'"
                + " WHEN titulo_formato='Ubicación' THEN './LaInstitucion?action=Ubicacion'"
                + " WHEN titulo_formato='Estructura Orgánica (Organigrama)' THEN './LaInstitucion?action=Estructura'"
                + " WHEN titulo_formato='Directorio Telefónico' THEN './LaInstitucion?action=Directorio'"
                + " ELSE './LaInstitucion?action=Objetivo'"
                + " END  r from web.f00025 where ((concat(titulo_formato, ' ', descripcion) ILIKE '%" + filter + "%'))"
                + " UNION SELECT titulo t, substring(contenido from 1 for 301) d, concat('./Publicaciones?action=PaginaNotaPrensaPrint&id=',id)  r  from web.f00021 where ((concat(titulo) ILIKE '%" + filter + "%'))"
                + " UNION SELECT docu_titulo t, substring(docu_resumen from 1 for 301) d, concat('./GestionTransparente?action=verResolucion&id=',docu_id,'&anho=',trim(substring(docu_fecha_docx from 7)))  r  from web.documento where ((concat(docu_titulo) ILIKE '%" + filter + "%'))";

        hashMap.put("limit", limit);
        hashMap.put("start", start);
        hashMap.put("query", query + "LIMIT " + limit + " OFFSET " + start);
        lista = busquedaDao.listarBusqueda(hashMap);
        hashMapOut.put("items", lista);
        hashMap.put("query", query);
        hashMapOut.put("total", busquedaDao.listarTotalBusqueda(hashMap));
        Gson gson = new Gson();
        String arg = gson.toJson(hashMapOut);
        out.print(arg);
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
