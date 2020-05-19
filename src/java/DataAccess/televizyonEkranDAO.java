/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.televizyonEkran;
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
public class televizyonEkranDAO {

    private Connector connector;
    private Connection connection;

    public televizyonEkran find(Long id) {
        televizyonEkran ekran = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from televizyon_ekran where ekran_id=" + id);
            rs.next();
            ekran = new televizyonEkran();
            ekran.setEkran_id(rs.getLong("ekran_id"));
            ekran.setEkran_turu(rs.getString("ekran_turu"));
            ekran.setEkran_tipi(rs.getString("ekran_tipi"));
            ekran.setEkran_boyutu(rs.getInt("ekran_boyutu"));
            ekran.setEkran_cozunurlugu(rs.getString("ekran_cozunurlugu"));
            ekran.setHDR(rs.getString("HDR"));
            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ekran;
    }

    public List<televizyonEkran> findAll() {
        List<televizyonEkran> ekran_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from televizyon_ekran");
            while (rs.next()) {
                televizyonEkran tmp = new televizyonEkran();
                tmp.setEkran_id(rs.getLong("ekran_id"));
                tmp.setEkran_turu(rs.getString("ekran_turu"));
                tmp.setEkran_tipi(rs.getString("ekran_tipi"));
                tmp.setEkran_boyutu(rs.getInt("ekran_boyutu"));
                tmp.setEkran_cozunurlugu(rs.getString("ekran_cozunurlugu"));
                tmp.setHDR(rs.getString("HDR"));
                ekran_liste.add(tmp);
            }
            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ekran_liste;
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
