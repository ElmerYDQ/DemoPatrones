/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import conexion.ConexionSingleton;
import dao.IBusDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Bus;

/**
 *
 * @author Diaz
 */
public class BusDaoImpl implements IBusDAO {

    private ConexionSingleton singleton = ConexionSingleton.getInstance();
    private Connection con = singleton.getConnection();

    private final String select = "select * from bus";
    private final String selectId = "select * from bus where id_bus = ?";
    private final String insert = "insert into bus (id_estado, placa, soat, capacidad, anho) values (?, ?, ?, ?, ?)";
    private final String delete = "delete from bus where id_bus = ?";
    private final String update = "update bus set id_estado = ?, placa = ?, soat = ?, capacidad = ?, anho = ? where id_bus = ?";

    @Override
    public List<Bus> listar() {
        Bus bus;
        List<Bus> buses = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(select);
            rs = pstm.executeQuery();
            while (rs.next()) {
                bus = new Bus();
                bus.setIdBus(rs.getInt(1));
                bus.setIdEstado(rs.getInt(2));
                bus.setPlaca(rs.getString(3));
                bus.setSoat(rs.getString(4));
                bus.setCapacidad(rs.getInt(5));
                bus.setAnho(rs.getInt(6));
                buses.add(bus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buses;
    }

    @Override
    public Bus getId(int id) {
        Bus bus = new Bus();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(selectId);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            bus.setIdBus(rs.getInt(1));
            bus.setIdEstado(rs.getInt(2));
            bus.setPlaca(rs.getString(3));
            bus.setSoat(rs.getString(4));
            bus.setCapacidad(rs.getInt(5));
            bus.setAnho(rs.getInt(6));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bus;
    }

    @Override
    public void add(Bus bus) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(insert);
            pstm.setInt(1, bus.getIdEstado());
            pstm.setString(2, bus.getPlaca());
            pstm.setString(3, bus.getSoat());
            pstm.setInt(4, bus.getCapacidad());
            pstm.setInt(5, bus.getAnho());
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
    public void update(Bus bus) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(update);
            pstm.setInt(1, bus.getIdEstado());
            pstm.setString(2, bus.getPlaca());
            pstm.setString(3, bus.getSoat());
            pstm.setInt(4, bus.getCapacidad());
            pstm.setInt(5, bus.getAnho());
            pstm.setInt(8, bus.getIdBus());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
