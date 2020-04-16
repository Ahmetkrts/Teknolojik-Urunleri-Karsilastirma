/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.telefonEkran;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.Connector;

/**
 *
 * @author techn
 */
public class telefonEkranDao {

    private Connector connector;
    private Connection connection;

    public telefonEkran find(Long id) {
        telefonEkran ekran = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_ekran where ekran_id=" + id);
            rs.next();
            ekran = new telefonEkran();
            ekran.setEkran_id(rs.getLong("ekran_id"));
            ekran.setEkran_boyutu(rs.getDouble("ekran_boyutu"));
            ekran.setEkran_teknolojisi(rs.getString("ekran_teknolojisi"));
            ekran.setEkran_cozunurkugu(rs.getString("ekran_cozunurlugu"));
            ekran.setPiksel_yogunlugu(rs.getInt("piksel_yogunlugu"));
            ekran.setEkran_dayanikliligi(rs.getString("ekran_dayanikligi"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ekran;
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
