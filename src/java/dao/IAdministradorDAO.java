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
public interface IAdministradorDAO extends IDAO<Administrador >{
    
    public Administrador validarUsuario(String usuario, String contrasena);
    
}
