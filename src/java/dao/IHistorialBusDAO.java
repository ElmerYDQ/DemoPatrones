/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.HistorialBus;

/**
 *
 * @author Diaz
 */
public interface IHistorialBusDAO {
    public List<HistorialBus> getHistorialBuses();
    
    public HistorialBus getHistorialBusId(int idRuta, int idBus);
    
    public void addHistorialBus(HistorialBus historialBus);
}
