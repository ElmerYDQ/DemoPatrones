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
import modelo.Avenida;
import service.IAvenidaService;
import service.impl.AvenidaService;

/**
 *
 * @author Diaz
 */
@WebServlet(name = "ServletAvenida", urlPatterns = {"/ServletAvenida"})
public class ServletAvenida extends HttpServlet {

    private IAvenidaService service = new AvenidaService();
    private Avenida avenida = new Avenida();
    
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
        
        List<Avenida> avenidas = service.listar();
        request.getSession().setAttribute("avenidas", avenidas);
        request.getRequestDispatcher("jsp/avenidas.jsp").forward(request, response);
        
    }
    
    protected void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        
        avenida.setNombre(nombre);
        
        service.add(avenida);
        response.sendRedirect(request.getContextPath()+"/ServletAvenida?accion=listar");
        //request.getRequestDispatcher("jsp/avenidaes.jsp").forward(request, response);
    }
    
    protected void obtener(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.getSession().setAttribute("avenida", service.getId(id));
        request.getRequestDispatcher("jsp/editarAvenida.jsp").forward(request, response);
        
    }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        
        avenida.setNombre(nombre);
        
        service.update(avenida);
        response.sendRedirect(request.getContextPath()+"/ServletAvenida?accion=listar");
        
    }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        response.sendRedirect(request.getContextPath()+"/ServletAvenida?accion=listar");
        
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
