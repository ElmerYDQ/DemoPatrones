/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.IAdministradorDAO;
import dao.impl.AdministradorDaoImpl;
import java.util.List;
import modelo.Administrador;
import service.IAdministradorService;

/**
 *
 * @author Diaz
 */
public class AdministradorService implements IAdministradorService {
    
    private IAdministradorDAO dao = new AdministradorDaoImpl();
    
    @Override
    public List<Administrador> listar() {
        return dao.listar();
    }

    @Override
    public Administrador getId(int id) {
        return dao.getId(id);
    }
    
    @Override
    public Administrador validarUsuario(String usuario, String contrasena) {
        return dao.validarUsuario(usuario, contrasena);
    }

    @Override
    public void add(Administrador t) {
        dao.add(t);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(Administrador t) {
        dao.update(t);
    }
    
}
