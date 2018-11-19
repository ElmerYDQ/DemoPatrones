/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import conexion.ConexionSingleton;
import dao.IAvenidaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Avenida;

/**
 *
 * @author Diaz
 */
public class AvenidaDaoImpl implements IAvenidaDAO {
    private ConexionSingleton singleton = ConexionSingleton.getInstance();
    private Connection con = singleton.getConnection();
    
    private final String select = "select * from avenida";
    private final String selectId = "select * from avenida where id_avenida = ?";
    private final String insert = "insert into avenida (nombre) values (?)";
    private final String delete = "delete from avenida where id_avenida = ?";
    private final String update = "update avenida set nombre = ? where id_avenida = ?";
    
    @Override
    public List<Avenida> listar() {
        Avenida avenida;
        List<Avenida> avenidas = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(select);
            rs = pstm.executeQuery();
            while(rs.next()) {
                avenida  = new Avenida();
                avenida.setIdAvenida(rs.getInt(1));
                avenida.setNombre(rs.getString(2));
                avenidas.add(avenida);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avenidas;
    }

    @Override
    public Avenida getId(int id) {
        Avenida avenida = new Avenida();
        PreparedStatement pstm = null;
        ResultSet rs =  null;
        try {
            pstm = con.prepareStatement(selectId);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            avenida.setIdAvenida(rs.getInt(1));
            avenida.setNombre(rs.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avenida;
    }

    @Override
    public void add(Avenida avenida) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(insert);
            pstm.setString(1, avenida.getNombre());
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
    public void update(Avenida avenida) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(update);
            pstm.setString(1, avenida.getNombre());
            pstm.setInt(2, avenida.getIdAvenida());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
