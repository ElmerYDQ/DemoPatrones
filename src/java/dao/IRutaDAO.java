/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Ruta;

/**
 *
 * @author Diaz
 */
public interface IRutaDAO {
    public List<Ruta> getRutaes();
    
    public Ruta getRutaId(int id);
    
    public void addRuta(Ruta ruta);
    
    public void deleteRuta(int id);
    
    public void updateRuta(Ruta ruta);
}
