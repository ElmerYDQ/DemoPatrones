/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Paradero;

/**
 *
 * @author Diaz
 */
public interface IParaderoDAO {
    public List<Paradero> getParaderoes();
    
    public Paradero getParaderoId(int id);
    
    public void addParadero(Paradero paradero);
    
    public void deleteParadero(int id);
    
    public void updateParadero(Paradero paradero);
}