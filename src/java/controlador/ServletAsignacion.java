/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import criteria.HistorialBusCriteria;
import criteria.ICriteria;
import dao.IHistorialBusDAO;
import dao.IHistorialConductorDAO;
import dao.impl.FactoriaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.HistorialBus;
import modelo.HistorialConductor;
import service.IHistorialBusService;

/**
 *
 * @author Diaz
 */
@WebServlet(name = "ServletAsignacion", urlPatterns = {"/ServletAsignacion"})
public class ServletAsignacion extends HttpServlet {
    
    private FactoriaDAO factoria = new FactoriaDAO();
    private IHistorialBusService historialBus = (IHistorialBusService) factoria.getHistorialDAO("bus");
    //private IHistorialConductorDAO historialConductor = (IHistorialConductorDAO) factoria.getHistorialDAO("conductor");
    
    private HistorialBus listaBus = new HistorialBus();
    private HistorialConductor listaConductor = new HistorialConductor();
    
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
        
        if(accion.equals("listarBuses")) {
            this.listarBuses(request, response);
        } else if(accion.equals("registrarHistorialBus")) {
            this.registrarHistorialBus(request, response);
        }
    }
    
    protected void listarBuses(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idRuta = Integer.parseInt(request.getParameter("idRuta"));
        ICriteria criteria = new HistorialBusCriteria();
        List<HistorialBus> listaHistorial = historialBus.getHistoriales();
        listaHistorial = criteria.filtrar(listaHistorial, idRuta);
        request.setAttribute("listaHistorial", listaHistorial);
        request.getSession().setAttribute("idRuta", idRuta);
        request.getRequestDispatcher("jsp/rutaBuses.jsp").forward(request, response);
    }
    
    protected void registrarHistorialBus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idRuta = Integer.parseInt(request.getParameter("idRuta"));
        int idBus = Integer.parseInt(request.getParameter("idBus"));
        Date fecha = new Date();
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        listaBus.setIdRuta(idRuta);
        listaBus.setIdBus(idBus);
        listaBus.setFecha(new java.sql.Date(fecha.getTime()));
        
        historialBus.addHistorial(listaBus);
        
        response.sendRedirect(request.getContextPath() + "/ServletAsignacion?accion=listarBuses&idRuta="+idRuta);
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
