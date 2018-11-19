/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import facade.Facade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.RutaParaderos;
import service.IRutaParaderosService;
import service.IRutaParaderosService;
import service.impl.RutaParaderosService;
import service.impl.RutaParaderosService;

/**
 *
 * @author Diaz
 */
@WebServlet(name = "ServletRutaParadero", urlPatterns = {"/ServletRutaParadero"})
public class ServletRutaParadero extends HttpServlet {

    private IRutaParaderosService service = new RutaParaderosService();
    private RutaParaderos rutaParaderos = new RutaParaderos();
    private Facade facade = new Facade();

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
        String accion = request.getParameter("accion");

        if (accion.equals("listar")) {
            this.listar(request, response);
        } else if (accion.equals("registrar")) {
            this.registrar(request, response);
        } else if (accion.equals("obtener")) {
            this.obtener(request, response);
        } else if (accion.equals("editar")) {
            this.editar(request, response);
        } else if (accion.equals("eliminar")) {
            this.eliminar(request, response);
        } 
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        List<RutaParaderos> rutaParaderos = service.getRutaParaderosRuta(id);
        request.getSession().setAttribute("rutaParaderos", rutaParaderos);
        request.getSession().setAttribute("facade", facade);
        request.getRequestDispatcher("jsp/rutaParaderos.jsp").forward(request, response);

    }

    protected void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*int idParaderoInicio = Integer.parseInt(request.getParameter("idParaderoInicio"));
        int idParaderoFinal = Integer.parseInt(request.getParameter("idParaderoFinal"));
        String nombre = request.getParameter("nombre");

        rutaParaderos.setParaderoInicio(idParaderoInicio);
        rutaParaderos.setParaderoFinal(idParaderoFinal);
        rutaParaderos.setNombre(nombre);

        service.add(rutaParaderos);
        response.sendRedirect(request.getContextPath() + "/ServletRutaParaderos?accion=listar");*/
        //request.getRequestDispatcher("jsp/rutaParaderoses.jsp").forward(request, response);
    }

    protected void obtener(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*int id = Integer.parseInt(request.getParameter("id"));
        request.getSession().setAttribute("rutaParaderos", service.getId(id));
        request.getRequestDispatcher("jsp/editarRutaParaderos.jsp").forward(request, response);*/

    }

    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*int id = Integer.parseInt(request.getParameter("id"));
        int idParaderoInicio = Integer.parseInt(request.getParameter("idParaderoInicio"));
        int idParaderoFinal = Integer.parseInt(request.getParameter("idParaderoFinal"));
        String nombre = request.getParameter("nombre");
        
        rutaParaderos.setIdRutaParaderos(id);
        rutaParaderos.setParaderoInicio(idParaderoInicio);
        rutaParaderos.setParaderoFinal(idParaderoFinal);
        rutaParaderos.setNombre(nombre);

        service.update(rutaParaderos);
        response.sendRedirect(request.getContextPath() + "/ServletRutaParaderos?accion=listar");*/

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*int id = Integer.parseInt(request.getParameter("id"));
        paraderos.deleteRutaParaderos(id);
        service.delete(id);
        
        response.sendRedirect(request.getContextPath() + "/ServletRutaParaderos?accion=listar");*/

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

}
