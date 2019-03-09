package gob.peam.servlet;

import gob.peam.beans.LineaAccion;
import gob.peam.dao.LineaAccionDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mvilchez
 */
@WebServlet(name = "LineaAccionServlet", urlPatterns = {"/LineaAccion"})
public class LineaAccionServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -4634880771247916346L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String respuesta = request.getParameter("action") == null ? "" : request.getParameter("action");
        switch (respuesta) {
            case "ListarLineaAccionActivos":
                listarLineaAccionActivos(request, response);
                break;
            case "ListarDireccionesActivos":
                listarDireccionesActivos(request, response);
                break;
            case "AreaEstudios":
                areaEstudioWeb(request, response);
                break;

            case "DireccionInfraestructura":
                direccionInfrestructuraWeb(request, response);
                break;
            case "DireccionManejoAmbiental":
                direccionManejoAmbientalWeb(request, response);
                break;
            case "DireccionDesarrolloAgropecuario":
                direccionDesarrolloAgropecuarioWeb(request, response);
                break;

        }
    }

    private void areaEstudioWeb(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/linea/estudio.jsp").forward(request, response);
    }

    private void direccionInfrestructuraWeb(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/linea/infraestructura.jsp").forward(request, response);
    }

    private void direccionManejoAmbientalWeb(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/linea/ambiental.jsp").forward(request, response);
    }

    private void direccionDesarrolloAgropecuarioWeb(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("./WEB-INF/linea/agropecuario.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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

    private void listarLineaAccionActivos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            LineaAccionDao lineaAccionDao = new LineaAccionDao();
            try {
                List<LineaAccion> lineasAccion = lineaAccionDao.listLineaAccionActivos();

                String result = "<select id ='lineaAccion' class='casilla' style='width: width: 649px;;'>";
                for (LineaAccion lineaAccion : lineasAccion) {
                    result += "<option value=" + lineaAccion.getId() + ">" + lineaAccion.getDescripcion() + "</option>";

                }
                result += "</span>";
                out.print(result);
            } catch (Exception e) {
                out.print(e);
            } finally {
                out.close();
            }
        }
    }

    private void listarDireccionesActivos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("./Intranet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            LineaAccionDao lineaAccionDao = new LineaAccionDao();
            try {
                List<LineaAccion> lineasAccion = lineaAccionDao.listDireccionesActivos();

                String result = "<select id ='lineaAccion' class='casilla' style='width: width: 649px;;'>";
                for (LineaAccion lineaAccion : lineasAccion) {
                    result += "<option value=" + lineaAccion.getId() + ">" + lineaAccion.getDescripcion() + "</option>";

                }
                result += "</span>";
                out.print(result);
            } catch (Exception e) {
                out.print(e);
            } finally {
                out.close();
            }
        }
    }

}
