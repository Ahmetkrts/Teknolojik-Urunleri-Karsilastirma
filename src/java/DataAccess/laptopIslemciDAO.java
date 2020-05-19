/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.laptopIslemci;
import java.sql.Connection;
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
public class laptopIslemciDAO {

    private Connector connector;
    private Connection connection;

    public void insert(laptopIslemci laptopIslemci) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("INSERT INTO laptop_islemci ( islemci_marka, islemci_serisi, islemci_modeli, islemci_temel_frekansi, cekirdek_sayisi,"
                    + " sanal_cekirdek_sayisi, on_bellek, uretim_teknolojisi, tdp_degeri) VALUES"
                    + " ( '"+laptopIslemci.getIslemci_marka()+"', '"+laptopIslemci.getIslemci_serisi()+"', '"+laptopIslemci.getIslemci_modeli()+"', "+laptopIslemci.getIslemci_temel_frekansi()+""
                            + ", "+laptopIslemci.getCekirdek_sayisi()+", "+laptopIslemci.getSanal_cekirdek_sayisi()+", "+laptopIslemci.getOn_bellek()+", "+laptopIslemci.getUretim_teknolojisi()+","
                                    + laptopIslemci.getTdp_degeri()+");");
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "İslemciDAO");
        }
    }

    public List<laptopIslemci> findAll() {
        List<laptopIslemci> islemci_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from Laptop_islemci ");
            while (rs.next()) {
                laptopIslemci tmp = new laptopIslemci();
                tmp.setIslemci_id(rs.getLong("islemci_id"));
                tmp.setIslemci_marka(rs.getString("islemci_marka"));
                tmp.setIslemci_serisi(rs.getString("islemci_serisi"));
                tmp.setIslemci_modeli(rs.getString("islemci_modeli"));
                tmp.setIslemci_temel_frekansi(rs.getDouble("islemci_temel_frekansi"));
                tmp.setCekirdek_sayisi(rs.getInt("cekirdek_sayisi"));
                tmp.setSanal_cekirdek_sayisi(rs.getInt("sanal_cekirdek_sayisi"));
                tmp.setOn_bellek(rs.getInt("on_bellek"));
                tmp.setUretim_teknolojisi(rs.getInt("uretim_teknolojisi"));
                tmp.setTdp_degeri(rs.getInt("tdp_degeri"));
                islemci_liste.add(tmp);
            }

            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "İslemciDAO");
        }
        return islemci_liste;
    }

    public laptopIslemci find(Long id) {
        laptopIslemci islemci = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from Laptop_islemci where islemci_id=" + id);
            rs.next();
            islemci = new laptopIslemci();
            islemci.setIslemci_id(rs.getLong("islemci_id"));
            islemci.setIslemci_marka(rs.getString("islemci_marka"));
            islemci.setIslemci_serisi(rs.getString("islemci_serisi"));
            islemci.setIslemci_modeli(rs.getString("islemci_modeli"));
            islemci.setIslemci_temel_frekansi(rs.getDouble("islemci_temel_frekansi"));
            islemci.setCekirdek_sayisi(rs.getInt("cekirdek_sayisi"));
            islemci.setSanal_cekirdek_sayisi(rs.getInt("sanal_cekirdek_sayisi"));
            islemci.setOn_bellek(rs.getInt("on_bellek"));
            islemci.setUretim_teknolojisi(rs.getInt("uretim_teknolojisi"));
            islemci.setTdp_degeri(rs.getInt("tdp_degeri"));
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "İslemciDAO");
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
        if (this.connection == null) {
            this.connection = this.getConnector().Connect();
        }
        return connection;
    }

}
