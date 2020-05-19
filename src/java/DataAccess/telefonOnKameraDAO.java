/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.telefonOnKamera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Connector;

/**
 *
 * @author Casper
 */
public class telefonOnKameraDAO {

    private Connector connector;
    private Connection connection;

    public telefonOnKamera find(Long id) {
        telefonOnKamera onKamera = null;
        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_on_kamera where kamera_id=" + id);
            rs.next();
            onKamera = new telefonOnKamera();
            onKamera.setKamera_id(rs.getLong("kamera_id"));
            onKamera.setTelefon_model(rs.getString("telefon_model"));
            onKamera.setKamera_cozunurlugu(rs.getInt("kamera_cozunurlugu"));
            onKamera.setVideo_cozunurlugu(rs.getString("video_cozunurlugu"));
            onKamera.setVideo_fps_degeri(rs.getInt("video_fps_degeri"));
            onKamera.setDiafram_acikligi(rs.getDouble("diafram_acikligi"));
            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return onKamera;
    }

    public List<telefonOnKamera> findAll() {
        List<telefonOnKamera> kamera_list = new ArrayList<>();

        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_on_kamera");
            while (rs.next()) {
                telefonOnKamera tmp = new telefonOnKamera();
                tmp.setKamera_id(rs.getLong("kamera_id"));
                tmp.setTelefon_model(rs.getString("telefon_model"));
                tmp.setKamera_cozunurlugu(rs.getInt("kamera_cozunurlugu"));
                tmp.setVideo_cozunurlugu(rs.getString("video_cozunurlugu"));
                tmp.setVideo_fps_degeri(rs.getInt("video_fps_degeri"));
                tmp.setDiafram_acikligi(rs.getDouble("diafram_acikligi"));

                kamera_list.add(tmp);
            }
            getConnection().close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return kamera_list;
    }
    
    public void edit(telefonOnKamera onKamera) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update telefon_on_kamera set telefon_model=?,kamera_cozunurlugu=?,video_cozunurlugu=?,video_fps_degeri=?,diafram_acikligi=? where kamera_id=?");
            pst.setString(1, onKamera.getTelefon_model());
            pst.setInt(2, onKamera.getKamera_cozunurlugu());
            pst.setString(3,onKamera.getVideo_cozunurlugu());
            pst.setInt(4,onKamera.getVideo_fps_degeri());
            pst.setDouble(5,onKamera.getDiafram_acikligi());
            pst.setLong(6,onKamera.getKamera_id());
            pst.executeUpdate();
            getConnection().close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(telefonOnKamera onKamera) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from telefon_on_kamera where kamera_id=?");
            pst.setLong(1, onKamera.getKamera_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connector getConnector() {
        if (this.connector == null) {
            this.connector = new Connector();
        }
        return connector;
    }

    public Connection getConnection() {
        this.connection = this.getConnector().Connect();
        return connection;
    }

    public void insert(telefonOnKamera onKamera) {
        try {
            Statement st = getConnection().createStatement();
            st.executeUpdate("insert into telefon_on_kamera (telefon_model,kamera_cozunurlugu,video_cozunurlugu,video_fps_degeri,diafram_acikligi) values ("
                    + "'" + onKamera.getTelefon_model() + "'," + onKamera.getKamera_cozunurlugu() + ",'" + onKamera.getVideo_cozunurlugu() + "',"
                    + "" + onKamera.getVideo_fps_degeri() + "," + onKamera.getDiafram_acikligi() + ")");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
}
