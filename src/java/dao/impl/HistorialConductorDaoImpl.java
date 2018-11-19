/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import conexion.ConexionSingleton;
import dao.IHistorialConductorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.HistorialConductor;

/**
 *
 * @author Diaz
 */
public class HistorialConductorDaoImpl implements IHistorialConductorDAO {

    private ConexionSingleton singleton = ConexionSingleton.getInstance();
    private Connection con = singleton.getConnection();

    private final String select = "select * from historialconductor";
    private final String selectId = "select * from historialconductor where id_bus = ?, id_conductor = ?";
    private final String insert = "insert into historialconductor (id_bus, id_conductor, fecha) values (?, ?, ?)";

    @Override
    public List<HistorialConductor> getHistoriales() {
        HistorialConductor historialConductor;
        List<HistorialConductor> historialConductores = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(select);
            rs = pstm.executeQuery();
            while (rs.next()) {
                historialConductor = new HistorialConductor();
                historialConductor.setIdBus(rs.getInt(1));
                historialConductor.setIdConductor(rs.getInt(2));
                historialConductor.setFecha(rs.getDate(3));
                historialConductores.add(historialConductor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historialConductores;
    }

    @Override
    public HistorialConductor getHistorialId(int idBus, int idConductor) {
        HistorialConductor historialConductor = new HistorialConductor();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(selectId);
            pstm.setInt(1, idBus);
            pstm.setInt(2, idConductor);
            rs = pstm.executeQuery();
            rs.next();
            historialConductor.setIdBus(rs.getInt(1));
            historialConductor.setIdConductor(rs.getInt(2));
            historialConductor.setFecha(rs.getDate(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historialConductor;
    }

    @Override
    public void addHistorial(HistorialConductor historial) {
        HistorialConductor historialConductor = (HistorialConductor) historial;
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(insert);
            pstm.setInt(1, historialConductor.getIdBus());
            pstm.setInt(2, historialConductor.getIdConductor());
            pstm.setDate(3, historialConductor.getFecha());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
