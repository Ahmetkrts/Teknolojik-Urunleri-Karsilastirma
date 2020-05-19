/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.televizyonIslettimSistemi;
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
public class televizyonIslettimSistemiDAO {
    private Connector connector;
    private Connection connection;

    public televizyonIslettimSistemi find(Long id) {
        televizyonIslettimSistemi isletimsistemi = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from televizyon_isletim_sistemi where isletim_sistemi_id=" + id);
            rs.next();
            isletimsistemi = new televizyonIslettimSistemi();
            isletimsistemi.setIsletim_sistemi_id(rs.getLong("isletim_sistemi_id"));
            isletimsistemi.setIsletim_sistemi(rs.getString("isletim_sistemi"));
            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isletimsistemi;
    }

    public List<televizyonIslettimSistemi> findAll() {
        List<televizyonIslettimSistemi> isletimsistemi_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from televizyon_isletim_sistemi");
            while (rs.next()) {
                televizyonIslettimSistemi tmp = new televizyonIslettimSistemi();
                tmp.setIsletim_sistemi_id(rs.getLong("isletim_sistemi_id"));
                tmp.setIsletim_sistemi(rs.getString("isletim_sistemi"));
                isletimsistemi_liste.add(tmp);
            }
            getConnection().close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isletimsistemi_liste;
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

    public void insert(televizyonIslettimSistemi isletimSistemi) {
        try {
            Statement st = getConnection().createStatement();
            st.executeUpdate("insert into televizyon_isletim_sistemi (isletim_sistemi) values ('" + isletimSistemi.getIsletim_sistemi() + "')");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
}
