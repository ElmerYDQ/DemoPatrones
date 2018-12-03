/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.IHistorialBusDAO;
import dao.impl.HistorialBusDaoImpl;
import java.util.List;
import modelo.HistorialBus;
import service.IHistorialBusService;

/**
 *
 * @author Diaz
 */
public class HistorialBusService implements IHistorialBusService {
    
    private IHistorialBusDAO dao = new HistorialBusDaoImpl();

    @Override
    public List<HistorialBus> getHistoriales() {
        return dao.getHistoriales();
    }

    @Override
    public HistorialBus getHistorialId(int id1, int id2) {
        return dao.getHistorialId(id1, id2);
    }

    @Override
    public void addHistorial(HistorialBus historial) {
        dao.addHistorial(historial);
    }

    @Override
    public void deleteHistorial(int id1, int id2) {
        dao.deleteHistorial(id1, id2);
    }
  
}
