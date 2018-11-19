/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import modelo.EstadoBus;
import modelo.Paradero;
import service.*;
import service.impl.*;

/**
 *
 * @author Diaz
 */
public class Facade {
    private IAvenidaService avenida;
    private IParaderoService paradero;
    private IEstadoBusService estado;
    
    public Facade() {
        avenida = new AvenidaService();
        paradero = new ParaderoService();
        estado = new EstadoBusService();
    }
    
    public String getNombreAvenida(int id) {
        return avenida.getId(id).getNombre();
    }
    
    public String getEstado(int id) {
        return estado.getId(id).getNombre();
    }
    
    public String getNombreParadero(int id) {
        return paradero.getId(id).getNombre();
    }
    
    public List<Paradero> listarParadero() {
        return paradero.listar();
    }
    
    public List<EstadoBus> listarEstado() {
        return estado.listar();
    }
}
