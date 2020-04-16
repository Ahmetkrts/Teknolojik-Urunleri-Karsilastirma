/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.telefonIslemci;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.Connector;

/**
 *
 * @author techn
 */
public class telefonIslemciDao {
    private Connector connector;
    private Connection connection;
    
    public telefonIslemci find(Long id){
        telefonIslemci islemci = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_islemcileri where islemci_id=" + id);
            rs.next();
            islemci = new telefonIslemci();
            islemci.setIslemci_id(rs.getLong("islemci_id"));
            islemci.setYonga_seti(rs.getString("yonga_seti"));
            islemci.setAna_islemci(rs.getString("ana_islemci"));
            islemci.setCpu_frekansi(rs.getDouble("cpu_frekansi"));
            islemci.setCpu_cekirdegi(rs.getInt("cpu_cekirdegi"));
            islemci.setIslmeci_mimarisi(rs.getInt("islmeci_mimarisi"));
            islemci.setBirinci_yardimci_islemci(rs.getString("birinci_yardimci_islmeci"));
            islemci.setGrafik_islmecisi_gpu(rs.getString("grafik_islemcisi_gpu"));
            islemci.setGpu_frekansi(rs.getInt("gpu_frekansi"));
            islemci.setCpu_uretim_teknolojisi(rs.getInt("cpu_uretim_teknolojisi"));
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return islemci;
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
