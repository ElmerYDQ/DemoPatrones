/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Administrador;

/**
 *
 * @author Diaz
 */
public interface IAdministradorDAO {
    public List<Administrador> getAdministradores();
    
    public Administrador getAdministradorId(int id);
    
    public void addAdministrador(Administrador administrador);
    
    public void deleteAdministrador(int id);
    
    public void updateAdministrador(Administrador administrador);
}
