/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IHistorialDAO;
import service.IHistorialService;
import service.impl.HistorialBusService;
import service.impl.HistorialConductorService;

/**
 *
 * @author Diaz
 */
public class FactoriaDAO {
    
    public IHistorialService getHistorialDAO(String historial){
        if(historial == null) {
            return null;
        }
        if(historial.equals("bus")) {
            return new HistorialBusService();
        } else if (historial.equals("conductor")) {
            return new HistorialConductorService();
        }
        return null;
    }
}
