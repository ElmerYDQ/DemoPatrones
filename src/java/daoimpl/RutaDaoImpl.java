/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import conexion.ConexionSingleton;
import dao.IRutaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Ruta;

/**
 *
 * @author Diaz
 */
public class RutaDaoImpl implements IRutaDAO {

    private ConexionSingleton singleton = ConexionSingleton.getInstance();
    private Connection con = singleton.getConnection();

    private final String select = "select * from ruta";
    private final String selectId = "select * from ruta where id_ruta = ?";
    private final String insert = "insert into ruta (paradero_inicio, paradero_fin, nombre) values (?, ?, ?, ?, ?, ?, ?)";
    private final String delete = "delete from ruta where id_ruta = ?";
    private final String update = "update ruta set paradero_inicio = ?, paradarero = ?, nombre = ? where id_ruta = ?";

    @Override
    public List<Ruta> getRutas() {
        Ruta ruta;
        List<Ruta> rutaes = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(select);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ruta = new Ruta();
                ruta.setIdRuta(rs.getInt(1));
                ruta.setParaderoInicio(rs.getInt(2));
                ruta.setParaderoFinal(rs.getInt(3));
                ruta.setNombre(rs.getString(4));
                rutaes.add(ruta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rutaes;
    }

    @Override
    public Ruta getRutaId(int id) {
        Ruta ruta = new Ruta();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(selectId);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            ruta.setIdRuta(rs.getInt(1));
            ruta.setParaderoInicio(rs.getInt(2));
            ruta.setParaderoFinal(rs.getInt(3));
            ruta.setNombre(rs.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ruta;
    }

    @Override
    public void addRuta(Ruta ruta) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(insert);
            pstm.setInt(1, ruta.getParaderoInicio());
            pstm.setInt(2, ruta.getParaderoFinal());
            pstm.setString(3, ruta.getNombre());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRuta(int id) {
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
    public void updateRuta(Ruta ruta) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(update);
            pstm.setInt(1, ruta.getParaderoInicio());
            pstm.setInt(2, ruta.getParaderoFinal());
            pstm.setString(3, ruta.getNombre());
            pstm.setInt(4, ruta.getIdRuta());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
