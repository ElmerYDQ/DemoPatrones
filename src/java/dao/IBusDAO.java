/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Bus;

/**
 *
 * @author Diaz
 */
public interface IBusDAO {
    public List<Bus> getBuses();
    
    public Bus getBusId(int id);
    
    public void addBus(Bus bus);
    
    public void deleteBus(int id);
    
    public void updateBus(Bus bus);
}
