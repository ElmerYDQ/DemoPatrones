/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.impl.FactoriaDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Avenida;
import modelo.Bus;
import modelo.EstadoBus;
import modelo.HistorialBus;
import modelo.Paradero;
import modelo.RutaParaderos;
import service.*;
import service.impl.*;

/**
 *
 * @author Diaz
 */
public class Facade {
    private FactoriaDAO factoria = new FactoriaDAO();
    private IAvenidaService avenida;
    private IParaderoService paradero;
    private IEstadoBusService estado;
    private IRutaParaderosService rutaParadero;
    private IBusService bus;
    private IHistorialBusService historialBus;
    
    public Facade() {
        avenida = new AvenidaService();
        paradero = new ParaderoService();
        estado = new EstadoBusService();
        rutaParadero = new RutaParaderosService();
        bus = new BusService();
        historialBus = (IHistorialBusService) factoria.getHistorialDAO("bus");
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
    
    public List<Paradero> listarParaderoFiltrado(int id) {
        List<Paradero> paraderos = paradero.listar();
        List<RutaParaderos> rutaParaderos = rutaParadero.getRutaParaderosRuta(id);
        List<Paradero> lista = new ArrayList<>();
        List<Integer> valores = new ArrayList<>();
        for(RutaParaderos r : rutaParaderos) {
            valores.add(r.getIdParadero());
        }
        for(Paradero p : paraderos) {
            if(!valores.contains(p.getIdParadero())) {
                lista.add(p);
            }
        }
        return lista;
    }
    
    public List<EstadoBus> listarEstado() {
        return estado.listar();
    }
    
    public List<Avenida> listarAvenida() {
        return avenida.listar();
    }
    
    public List<Bus> listarBus() {
        return bus.listar();
    }
    
    public List<Bus> listarBusFiltrado() {
        List<Bus> buses = bus.listar();
        List<HistorialBus> historial = historialBus.getHistoriales();
        List<Bus> lista = new ArrayList<>();
        List<Integer> valores = new ArrayList<>();
        for(HistorialBus h : historial) {
            valores.add(h.getIdBus());
        }
        for(Bus b : buses) {
            if(!valores.contains(b.getIdBus())) {
                lista.add(b);
            }
        }
        return lista;
    }
    
    public Bus getBus(int id) {
        return bus.getId(id);
    }
    
    public List<RutaParaderos> getRutaParaderosRuta(int id) {
        return rutaParadero.getRutaParaderosRuta(id);
    }
    
    public Paradero getParadero(int id) {
        return paradero.getId(id);
    }
}
