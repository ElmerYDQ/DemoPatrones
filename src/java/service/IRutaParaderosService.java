/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.RutaParaderos;

/**
 *
 * @author Diaz
 */
public interface IRutaParaderosService {
    public List<RutaParaderos> listar();
    
    public List<RutaParaderos> getRutaParaderosRuta(int id);
    
    public RutaParaderos getId(int idRuta, int idParadero);
    
    public void add(RutaParaderos rutaParaderos);
    
    public void delete(int idRuta, int idParadero);
    
    public void update(RutaParaderos rutaParaderos, int antiguo);
}
