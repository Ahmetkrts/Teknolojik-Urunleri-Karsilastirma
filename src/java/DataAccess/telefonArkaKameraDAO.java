/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.telefonArkaKamera;
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
public class telefonArkaKameraDAO {

    private Connector connector;
    private Connection connection; 
    
    public telefonArkaKamera find(Long id) {
        telefonArkaKamera arkaKamera = null;
        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_arka_kamera where kamera_id=" + id);
            rs.next();
            arkaKamera = new telefonArkaKamera();
            arkaKamera.setKamera_id(rs.getLong("kamera_id"));
            arkaKamera.setTelefon_model(rs.getString("telefon_model"));
            arkaKamera.setKamera_cozunurlugu(rs.getInt("kamera_cozunurlugu"));
            arkaKamera.setOptik_goruntu_sabitleyici(rs.getString("optik_goruntu_sabitleyici"));
            arkaKamera.setFlas(rs.getString("flas"));
            arkaKamera.setDiafram_acikligi(rs.getDouble("diafram_acikligi"));
            arkaKamera.setVideo_kayit_cozunurlugu(rs.getString("video_kayit_cozunurlugu"));
            arkaKamera.setVideo_fps_degeri(rs.getInt("video_fps_degeri"));
            arkaKamera.setIki_kamera_cozunurlugu(rs.getInt("iki_kamera_cozunurlugu"));
            arkaKamera.setIki_diafram_acikligi(rs.getDouble("iki_diafram_acikligi"));
            arkaKamera.setUc_kamera_cozunurlugu(rs.getInt("uc_kamera_cozunurlugu"));
            arkaKamera.setUc_diafram_acikligi(rs.getDouble("uc_diafram_acikligi"));
            arkaKamera.setDort_kamera_cozunurlugu(rs.getInt("dort_kamera_cozunurlugu"));
            arkaKamera.setDort_diafram_acikligi(rs.getDouble("dort_diafram_acikligi"));
            arkaKamera.setBes_kamera_cozunurlugu(rs.getInt("bes_kamera_cozunurlugu"));
            arkaKamera.setBes_diafram_acikligi(rs.getDouble("bes_diafram_acikligi"));
            rs.close();
            st.close();
            this.getConnection().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arkaKamera;
    }

    public List<telefonArkaKamera> findAll() {
        List<telefonArkaKamera> arka_kamera = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_arka_kamera");
            while (rs.next()) {
                telefonArkaKamera tmp = new telefonArkaKamera();

                tmp.setKamera_id(rs.getLong("kamera_id"));
                tmp.setTelefon_model(rs.getString("telefon_model"));
                tmp.setKamera_cozunurlugu(rs.getInt("kamera_cozunurlugu"));
                tmp.setOptik_goruntu_sabitleyici(rs.getString("optik_goruntu_sabitleyici"));
                tmp.setFlas(rs.getString("flas"));
                tmp.setDiafram_acikligi(rs.getDouble("diafram_acikligi"));
                tmp.setVideo_kayit_cozunurlugu(rs.getString("video_kayit_cozunurlugu"));
                tmp.setVideo_fps_degeri(rs.getInt("video_fps_degeri"));
                tmp.setIki_kamera_cozunurlugu(rs.getInt("iki_kamera_cozunurlugu"));
                tmp.setIki_diafram_acikligi(rs.getDouble("iki_diafram_acikligi"));
                tmp.setUc_kamera_cozunurlugu(rs.getInt("uc_kamera_cozunurlugu"));
                tmp.setUc_diafram_acikligi(rs.getDouble("uc_diafram_acikligi"));
                tmp.setDort_kamera_cozunurlugu(rs.getInt("dort_kamera_cozunurlugu"));
                tmp.setDort_diafram_acikligi(rs.getDouble("dort_diafram_acikligi"));
                tmp.setBes_kamera_cozunurlugu(rs.getInt("bes_kamera_cozunurlugu"));
                tmp.setBes_diafram_acikligi(rs.getDouble("bes_diafram_acikligi"));
                arka_kamera.add(tmp);

            }
            this.getConnection().close();
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arka_kamera;
    }

    public void insert(telefonArkaKamera arkaKamera) {
        try {

            Statement st = this.getConnection().createStatement();
            st.executeUpdate("INSERT INTO telefon_arka_kamera ( telefon_model, kamera_cozunurlugu, optik_goruntu_sabitleyici, flas, diafram_acikligi, video_kayit_cozunurlugu, video_fps_degeri, iki_kamera_cozunurlugu, iki_diafram_acikligi, uc_kamera_cozunurlugu, uc_diafram_acikligi, dort_kamera_cozunurlugu, dort_diafram_acikligi, bes_kamera_cozunurlugu, bes_diafram_acikligi) VALUES"
                    + "('" + arkaKamera.getTelefon_model() + "'," + arkaKamera.getKamera_cozunurlugu() + ",'" + arkaKamera.getOptik_goruntu_sabitleyici() + "',"
                    + "'" + arkaKamera.getFlas() + "'," + arkaKamera.getDiafram_acikligi() + ",'" + arkaKamera.getVideo_kayit_cozunurlugu() + "'," + arkaKamera.getVideo_fps_degeri() + ""
                    + "," + arkaKamera.getIki_kamera_cozunurlugu() + "," + arkaKamera.getIki_diafram_acikligi() + "," + arkaKamera.getUc_kamera_cozunurlugu() + "," + arkaKamera.getUc_diafram_acikligi() + ""
                    + "," + arkaKamera.getDort_kamera_cozunurlugu() + "," + arkaKamera.getDort_diafram_acikligi() + "," + arkaKamera.getBes_kamera_cozunurlugu() + "," + arkaKamera.getBes_diafram_acikligi() + ")");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(telefonArkaKamera arkaKamera) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from telefon_arka_kamera where kamera_id=?");
            pst.setLong(1, arkaKamera.getKamera_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void edit(telefonArkaKamera arkaKamera) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update telefon_arka_kamera set telefon_model=?,kamera_cozunurlugu=?,optik_goruntu_sabitleyici=?,flas=?,diafram_acikligi=?,video_kayit_cozunurlugu=?,video_fps_degeri=?,iki_kamera_cozunurlugu=?,iki_diafram_acikligi=?,uc_kamera_cozunurlugu=?,uc_diafram_acikligi=?,dort_kamera_cozunurlugu=?,dort_diafram_acikligi=?,bes_kamera_cozunurlugu=?,bes_diafram_acikligi=? where kamera_id=?");
            pst.setString(1, arkaKamera.getTelefon_model());
            pst.setInt(2, arkaKamera.getKamera_cozunurlugu());
            pst.setString(3, arkaKamera.getOptik_goruntu_sabitleyici());
            pst.setString(4, arkaKamera.getFlas());
            pst.setDouble(5, arkaKamera.getDiafram_acikligi());
            pst.setString(6, arkaKamera.getVideo_kayit_cozunurlugu());
            pst.setInt(7, arkaKamera.getVideo_fps_degeri());
            pst.setInt(8, arkaKamera.getIki_kamera_cozunurlugu());
            pst.setDouble(9, arkaKamera.getIki_diafram_acikligi());
            pst.setInt(10, arkaKamera.getUc_kamera_cozunurlugu());
            pst.setDouble(11, arkaKamera.getUc_diafram_acikligi());
            pst.setInt(12, arkaKamera.getDort_kamera_cozunurlugu());
            pst.setDouble(13, arkaKamera.getDiafram_acikligi());
            pst.setInt(14, arkaKamera.getBes_kamera_cozunurlugu());
            pst.setDouble(15, arkaKamera.getBes_diafram_acikligi());
            pst.setLong(16, arkaKamera.getKamera_id());
            pst.executeUpdate();
            getConnection().close();
            pst.close();
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

    public Connection getConnection() throws SQLException {
        this.connection = this.getConnector().Connect();
        return connection;
    }

}