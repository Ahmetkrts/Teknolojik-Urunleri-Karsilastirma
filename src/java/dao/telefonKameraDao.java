/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.telefonKamera;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Connector;

/**
 *
 * @author techn
 */
public class telefonKameraDao {
    private Connector connector;
    private Connection connection;
    
    public List<telefonKamera> getkamera(Long telefon_id) {
        List<telefonKamera> kameralist = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_kamera where telefon_id="+telefon_id);
            
            while(rs.next()){
                kameralist.add(this.find(rs.getLong("kamera_id")));
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return kameralist;
    }
    
    public telefonKamera find(Long id){
        telefonKamera kamera = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_kameralari where kamera_id="+id);
            rs.next();
            kamera = new telefonKamera();
            kamera.setKamera_id(rs.getLong("kamera_id"));
            kamera.setKamera_on_arka(rs.getString("kamera_on_arka"));
            kamera.setKamera_cozunurlugu(rs.getInt("kamera_cozunurlugu"));
            kamera.setOptik_goruntu_sabitleyici(rs.getString("optik_goruntu_sabitleyici"));
            kamera.setFlas(rs.getString("flas"));
            kamera.setDiafram_acikligi(rs.getDouble("diafram_acikligi"));
            kamera.setVideo_kayit_cozunurlugu(rs.getString("video_kayit_cozunurlugu"));
            kamera.setVideo_fps_degeri(rs.getInt("video_fps_degeri"));
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return kamera;
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
}
