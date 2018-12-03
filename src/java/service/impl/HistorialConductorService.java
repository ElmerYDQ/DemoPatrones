/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.IHistorialConductorDAO;
import dao.impl.HistorialConductorDaoImpl;
import java.util.List;
import modelo.HistorialConductor;
import service.IHistorialConductorService;

/**
 *
 * @author Diaz
 */
public class HistorialConductorService implements IHistorialConductorService {
    
    private IHistorialConductorDAO dao = new HistorialConductorDaoImpl();

    @Override
    public List<HistorialConductor> getHistoriales() {
        return dao.getHistoriales();
    }

    @Override
    public HistorialConductor getHistorialId(int id1, int id2) {
        return dao.getHistorialId(id1, id2);
    }

    @Override
    public void addHistorial(HistorialConductor historial) {
        dao.addHistorial(historial);
    }

    @Override
    public void deleteHistorial(int id1, int id2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
