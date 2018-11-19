/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import conexion.ConexionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.EstadoBus;
import dao.IEstadoBusDAO;

/**
 *
 * @author Diaz
 */
public class EstadoBusDaoImpl implements IEstadoBusDAO {
    private ConexionSingleton singleton = ConexionSingleton.getInstance();
    private Connection con = singleton.getConnection();
    
    private final String select = "select * from estado_bus";
    private final String selectId = "select * from estado_bus where id_estado = ?";
    private final String insert = "insert into estado_bus (nombre) values (?)";
    private final String delete = "delete from estado_bus where id_estado = ?";
    private final String update = "update estado_bus set nombre = ? where id_estado = ?";
    
    @Override
    public List<EstadoBus> listar() {
        EstadoBus estado;
        List<EstadoBus> estadoes = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(select);
            rs = pstm.executeQuery();
            while(rs.next()) {
                estado  = new EstadoBus();
                estado.setIdEstado(rs.getInt(1));
                estado.setNombre(rs.getString(2));
                estadoes.add(estado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estadoes;
    }

    @Override
    public EstadoBus getId(int id) {
        EstadoBus estado = new EstadoBus();
        PreparedStatement pstm = null;
        ResultSet rs =  null;
        try {
            pstm = con.prepareStatement(selectId);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            estado.setIdEstado(rs.getInt(1));
            estado.setNombre(rs.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estado;
    }

    @Override
    public void add(EstadoBus estado) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(insert);
            pstm.setString(1, estado.getNombre());
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
    public void update(EstadoBus estado) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(update);
            pstm.setString(1, estado.getNombre());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
