/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import conexion.ConexionSingleton;
import dao.IAdministradorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Administrador;
import modelo.PersonaClone;

/**
 *
 * @author Diaz
 */
public class AdministradorDaoImpl implements IAdministradorDAO {

    private ConexionSingleton singleton = ConexionSingleton.getInstance();
    private Connection con = singleton.getConnection();
    private PersonaClone clone;

    private final String select = "select * from administrador";
    private final String selectId = "select * from administrador where id_administrador = ?";
    private final String login = "select * from administrador where usuario = ? and contrasena = ?";
    private final String insert = "insert into administrador (nombre, apellido, dni, telefono, email, usuario, contrasena) values (?, ?, ?, ?, ?, ?, ?)";
    private final String delete = "delete from administrador where id_administrador = ?";
    private final String update = "update administrador set nombre = ?, apellido = ?, dni = ?, telefono = ?, email = ?, usuario = ?, contrasena = ? where id_administrador = ?";

    @Override
    public List<Administrador> listar() {
        clone = new PersonaClone();
        Administrador administrador;
        List<Administrador> administradores = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(select);
            rs = pstm.executeQuery();
            while (rs.next()) {
                administrador = (Administrador) clone.createBasicItem("administrador");
                administrador.setIdAdministrador(rs.getInt(1));
                administrador.setNombre(rs.getString(2));
                administrador.setApellido(rs.getString(3));
                administrador.setDni(rs.getString(4));
                administrador.setTelefono(rs.getString(5));
                administrador.setEmail(rs.getString(6));
                administrador.setUsuario(rs.getString(7));
                administrador.setContrasena(rs.getString(8));
                administradores.add(administrador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return administradores;
    }

    @Override
    public Administrador getId(int id) {
        clone = new PersonaClone();
        Administrador administrador = (Administrador) clone.createBasicItem("administrador");
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(selectId);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            administrador.setIdAdministrador(rs.getInt(1));
            administrador.setNombre(rs.getString(2));
            administrador.setApellido(rs.getString(3));
            administrador.setDni(rs.getString(4));
            administrador.setTelefono(rs.getString(5));
            administrador.setEmail(rs.getString(6));
            administrador.setUsuario(rs.getString(7));
            administrador.setContrasena(rs.getString(8));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return administrador;
    }

    @Override
    public Administrador validarUsuario(String usuario, String contrasena) {
        clone = new PersonaClone();
        Administrador administrador = (Administrador) clone.createBasicItem("administrador");
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(login);
            pstm.setString(1, usuario);
            pstm.setString(2, contrasena);
            rs = pstm.executeQuery();
            while (rs.next()) {
                administrador.setIdAdministrador(rs.getInt(1));
                administrador.setNombre(rs.getString(2));
                administrador.setApellido(rs.getString(3));
                administrador.setDni(rs.getString(4));
                administrador.setTelefono(rs.getString(5));
                administrador.setEmail(rs.getString(6));
                administrador.setUsuario(rs.getString(7));
                administrador.setContrasena(rs.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return administrador;
    }

    @Override
    public void add(Administrador administrador) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(insert);
            pstm.setString(1, administrador.getNombre());
            pstm.setString(2, administrador.getApellido());
            pstm.setString(3, administrador.getDni());
            pstm.setString(4, administrador.getTelefono());
            pstm.setString(5, administrador.getEmail());
            pstm.setString(6, administrador.getUsuario());
            pstm.setString(7, administrador.getContrasena());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(delete);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Administrador administrador) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(update);
            pstm.setString(1, administrador.getNombre());
            pstm.setString(2, administrador.getApellido());
            pstm.setString(3, administrador.getDni());
            pstm.setString(4, administrador.getTelefono());
            pstm.setString(5, administrador.getEmail());
            pstm.setString(6, administrador.getUsuario());
            pstm.setString(7, administrador.getContrasena());
            pstm.setInt(8, administrador.getIdAdministrador());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
