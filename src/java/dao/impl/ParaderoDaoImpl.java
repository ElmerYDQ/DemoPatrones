/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import conexion.ConexionSingleton;
import dao.IParaderoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Paradero;

/**
 *
 * @author Diaz
 */
public class ParaderoDaoImpl implements IParaderoDAO {

    private ConexionSingleton singleton = ConexionSingleton.getInstance();
    private Connection con = singleton.getConnection();

    private final String select = "select * from paradero";
    private final String selectId = "select * from paradero where id_paradero = ?";
    private final String insert = "insert into paradero (id_avenida, nombre, direccion) values (?, ?, ?)";
    private final String delete = "delete from paradero where id_paradero = ?";
    private final String update = "update paradero set id_avenida = ?, nombre = ?, direccion = ? where id_paradero = ?";

    @Override
    public List<Paradero> listar() {
        Paradero paradero;
        List<Paradero> paraderos = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(select);
            rs = pstm.executeQuery();
            while (rs.next()) {
                paradero = new Paradero();
                paradero.setIdParadero(rs.getInt(1));
                paradero.setIdAvenida(rs.getInt(2));
                paradero.setNombre(rs.getString(3));
                paradero.setDireccion(rs.getString(4));
                paraderos.add(paradero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paraderos;
    }

    @Override
    public Paradero getId(int id) {
        Paradero paradero = new Paradero();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(selectId);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            paradero.setIdParadero(rs.getInt(1));
            paradero.setIdAvenida(rs.getInt(2));
            paradero.setNombre(rs.getString(3));
            paradero.setDireccion(rs.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paradero;
    }

    @Override
    public void add(Paradero paradero) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(insert);
            pstm.setInt(1, paradero.getIdAvenida());
            pstm.setString(2, paradero.getNombre());
            pstm.setString(3, paradero.getDireccion());
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
    public void update(Paradero paradero) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(update);
            pstm.setInt(1, paradero.getIdAvenida());
            pstm.setString(2, paradero.getNombre());
            pstm.setString(3, paradero.getDireccion());
            pstm.setInt(8, paradero.getIdParadero());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
