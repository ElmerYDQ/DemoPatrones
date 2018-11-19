/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Conductor;
import modelo.PersonaClone;
import service.IConductorService;
import service.impl.ConductorService;

/**
 *
 * @author Diaz
 */
@WebServlet(name = "ServletConductor", urlPatterns = {"/ServletConductor"})
public class ServletConductor extends HttpServlet {
    
    private IConductorService service = new ConductorService();
    private PersonaClone clone = new PersonaClone();
    private Conductor conductor = (Conductor) clone.createBasicItem("conductor");
    
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
        
        List<Conductor> conductores = service.listar();
        request.getSession().setAttribute("conductores", conductores);
        request.getRequestDispatcher("jsp/conductores.jsp").forward(request, response);
        
    }
    
    protected void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String brevete = request.getParameter("brevete");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("email");
        
        conductor.setNombre(nombre);
        conductor.setApellido(apellido);
        conductor.setDni(dni);
        conductor.setBrevete(brevete);
        conductor.setTelefono(telefono);
        conductor.setDireccion(direccion);
        conductor.setEmail(email);
        
        service.add(conductor);
        response.sendRedirect(request.getContextPath()+"/ServletConductor?accion=listar");
        //request.getRequestDispatcher("jsp/conductores.jsp").forward(request, response);
    }
    
    protected void obtener(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.getSession().setAttribute("conductor", service.getId(id));
        request.getRequestDispatcher("jsp/editarConductor.jsp").forward(request, response);
        
    }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String brevete = request.getParameter("brevete");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("email");
        
        conductor.setIdConductor(id);
        conductor.setNombre(nombre);
        conductor.setApellido(apellido);
        conductor.setDni(dni);
        conductor.setBrevete(brevete);
        conductor.setTelefono(telefono);
        conductor.setDireccion(direccion);
        conductor.setEmail(email);
        
        service.update(conductor);
        response.sendRedirect(request.getContextPath()+"/ServletConductor?accion=listar");
        
    }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        response.sendRedirect(request.getContextPath()+"/ServletConductor?accion=listar");
        
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
