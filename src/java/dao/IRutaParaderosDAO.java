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
    public List<RutaParaderos> listar();
    
    public List<RutaParaderos> getRutaParaderosRuta(int id);
    
    public RutaParaderos getId(int idRuta, int idParadero);
    
    public void add(RutaParaderos rutaParaderos);
    
    public void delete(int idRuta, int idParadero);
    
    public void update(RutaParaderos rutaParaderos, int antiguo);
    
    public void deleteRuta(int idRuta);
}
