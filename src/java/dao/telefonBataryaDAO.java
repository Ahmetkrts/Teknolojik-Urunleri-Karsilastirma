/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.telefonBatarya;
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
 * @author techn
 */
public class telefonBataryaDAO {

    private Connector connector;
    private Connection connection;

    public telefonBatarya find(Long id) {
        telefonBatarya batarya = null;
        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_batarya where batarya_id=" + id);
            rs.next();
            batarya = new telefonBatarya();
            batarya.setBatarya_id(rs.getLong("batarya_id"));
            batarya.setBatarya_kapasitesi(rs.getInt("batarya_kapasitesi"));
            batarya.setBatarya_teknolojisi(rs.getString("batarya_teknolojisi"));
            batarya.setHizli_sarj_ozelligi(rs.getString("hizli_sarj_ozelligi"));
            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return batarya;
    }

    public List<telefonBatarya> findAll() {
        List< telefonBatarya> batarya_liste = new ArrayList<>();
        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_batarya");
            while (rs.next()) {
                telefonBatarya tmp = new telefonBatarya();
                tmp.setBatarya_id(rs.getLong("batarya_id"));
                tmp.setBatarya_kapasitesi(rs.getInt("batarya_kapasitesi"));
                tmp.setBatarya_teknolojisi(rs.getString("batarya_teknolojisi"));
                tmp.setHizli_sarj_ozelligi(rs.getString("hizli_sarj_ozelligi"));
                batarya_liste.add(tmp);
            }
            getConnection().close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return batarya_liste;
    }
    
    public void insert(telefonBatarya batarya) {
        try {
            Statement st=getConnection().createStatement();
            st.executeUpdate("insert into telefon_batarya (batarya_kapasitesi,batarya_teknolojisi,hizli_sarj_ozelligi) values ("
                    + ""+batarya.getBatarya_kapasitesi()+",'"+batarya.getBatarya_teknolojisi()+"','"+batarya.getHizli_sarj_ozelligi()+"')");
            
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

    

    

}
