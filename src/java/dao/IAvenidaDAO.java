/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Avenida;

/**
 *
 * @author Diaz
 */
public interface IAvenidaDAO {
    public List<Avenida> getAvenidas();
    
    public Avenida getAvenidaId(int id);
    
    public void addAvenida(Avenida avenida);
    
    public void deleteAvenida(int id);
    
    public void updateAvenida(Avenida avenida);
}
