/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.RutaParaderos;

/**
 *
 * @author Diaz
 */
public interface IRutaParaderosDAO {
    public List<RutaParaderos> getRutaParaderos();
    
    public RutaParaderos getRutaParaderosId(int id);
    
    public void addRutaParaderos(RutaParaderos rutaParaderos);
    
    public void deleteRutaParaderos(int id);
    
    public void updateRutaParaderos(RutaParaderos rutaParaderos);
}
