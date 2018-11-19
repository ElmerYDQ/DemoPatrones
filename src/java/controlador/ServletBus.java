/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import facade.Facade;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Bus;
import service.IBusService;
import service.impl.BusService;

/**
 *
 * @author Diaz
 */
@WebServlet(name = "ServletBus", urlPatterns = {"/ServletBus"})
public class ServletBus extends HttpServlet {

    private IBusService service = new BusService();
    private Bus bus = new Bus();
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
        
        if(accion.equals("listar")) {
            this.listar(request, response);
        } else if(accion.equals("registrar")) {
            this.registrar(request, response);
        } else if(accion.equals("obtener")) {
            this.obtener(request, response);
        } else if(accion.equals("editar")) {
            this.editar(request, response);
        } else if(accion.equals("eliminar")) {
            this.eliminar(request, response);
        }
    }
    
    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Bus> buses = service.listar();
        request.getSession().setAttribute("buses", buses);
        request.getSession().setAttribute("facade", facade);
        request.getRequestDispatcher("jsp/buses.jsp").forward(request, response);
        
    }
    
    protected void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idEstado = Integer.parseInt(request.getParameter("idEstado"));
        String placa = request.getParameter("placa");
        String soat = request.getParameter("soat");
        int capacidad = Integer.parseInt(request.getParameter("capacidad"));
        int anho = Integer.parseInt(request.getParameter("anho"));
        
        bus.setIdEstado(idEstado);
        bus.setPlaca(placa);
        bus.setSoat(soat);
        bus.setCapacidad(capacidad);
        bus.setAnho(anho);
        
        service.add(bus);
        response.sendRedirect(request.getContextPath()+"/ServletBus?accion=listar");
        //request.getRequestDispatcher("jsp/buses.jsp").forward(request, response);
    }
    
    protected void obtener(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.getSession().setAttribute("bus", service.getId(id));
        request.getRequestDispatcher("jsp/editarBus.jsp").forward(request, response);
        
    }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idEstado = Integer.parseInt(request.getParameter("idEstado"));
        String placa = request.getParameter("placa");
        String soat = request.getParameter("soat");
        int capacidad = Integer.parseInt(request.getParameter("capacidad"));
        int anho = Integer.parseInt(request.getParameter("anho"));
        
        bus.setIdEstado(idEstado);
        bus.setPlaca(placa);
        bus.setSoat(soat);
        bus.setCapacidad(capacidad);
        bus.setAnho(anho);
        
        service.update(bus);
        response.sendRedirect(request.getContextPath()+"/ServletBus?accion=listar");
        
    }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        response.sendRedirect(request.getContextPath()+"/ServletBus?accion=listar");
        
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
