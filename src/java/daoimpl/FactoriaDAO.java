/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import dao.IHistorialDAO;

/**
 *
 * @author Diaz
 */
public class FactoriaDAO {
    
    public IHistorialDAO getHistorialDAO(String historial){
        if(historial == null) {
            return null;
        }
        if(historial.equals("bus")) {
            return new HistorialBusDaoImpl();
        } else if (historial.equals("conductor")) {
            return new HistorialConductorDaoImpl();
        }
        return null;
    }
}
