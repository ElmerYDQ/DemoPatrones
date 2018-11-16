/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Conductor;

/**
 *
 * @author Diaz
 */
public interface IConductorDAO {
    public List<Conductor> getConductores();
    
    public Conductor getConductorId(int id);
    
    public void addConductor(Conductor conductor);
    
    public void deleteConductor(int id);
    
    public void updateConductor(Conductor conductor);
}
