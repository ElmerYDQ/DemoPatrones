/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.HistorialConductor;

/**
 *
 * @author Diaz
 */
public interface IHistorialConductorDAO {
    public List<HistorialConductor> getHistorialConductores();
    
    public HistorialConductor getHistorialConductorId(int idBus, int idConductor);
    
    public void addHistorialConductor(HistorialConductor historialConductor);
}
