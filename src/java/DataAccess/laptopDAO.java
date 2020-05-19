/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.laptop;
import entity.laptopDepolamaBellek;
import entity.laptopEkran;
import entity.laptopEkranKarti;
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
public class laptopDAO {

    private Connector connector;
    private Connection connection;
    private laptopEkranDAO ekran;
    private laptopDepolamaBellekDAO depolamaBellek;
    private laptopIslemciDAO islemci;
    private laptopEkranKartiDAO ekranKarti;

    public List<laptop> findAll() {
        List<laptop> laptoplist = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop");
            while (rs.next()) {
                laptop tmp = new laptop();
                tmp.setLaptop_id(rs.getLong("laptop_id"));
                tmp.setUrun_adi(rs.getString("urun_adi"));
                tmp.setUrun_tipi(rs.getString("urun_tipi"));
                tmp.setUrun_amaci(rs.getString("urun_amaci"));
                tmp.setUrun_ailesi(rs.getString("urun_ailesi"));
                tmp.setUrun_serisi(rs.getString("urun_serisi"));
                tmp.setIsletim_sistemi(rs.getString("isletim_sistemi"));
                tmp.setEkran(this.getEkran().find(rs.getLong("ekran_id")));
                tmp.setGenislik(rs.getDouble("genislik"));
                tmp.setDerinlik(rs.getDouble("derinlik"));
                tmp.setKalinlik(rs.getDouble("kalinlik"));
                tmp.setAgirlik(rs.getDouble("agirlik"));
                tmp.setDepolama_bellek(this.getDepolamaBellek().find(rs.getLong("depolama_bellek_id")));
                tmp.setIslemci(this.getIslemci().find(rs.getLong("islemci_id")));
                tmp.setEkran_karti(this.getEkranKarti().find(rs.getLong("ekran_karti_id")));
                laptoplist.add(tmp);

            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "LaptopDAO");
        }

        return laptoplist;

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

    public laptopEkranDAO getEkran() {
        if (this.ekran == null) {
            this.ekran = new laptopEkranDAO();
        }
        return ekran;
    }

    public laptopDepolamaBellekDAO getDepolamaBellek() {
        if (this.depolamaBellek == null) {
            this.depolamaBellek = new laptopDepolamaBellekDAO();
        }
        return depolamaBellek;
    }

    public laptopIslemciDAO getIslemci() {
        if (this.islemci == null) {
            this.islemci = new laptopIslemciDAO();
        }
        return islemci;
    }

    public laptopEkranKartiDAO getEkranKarti() {
        if (this.ekranKarti == null) {
            this.ekranKarti = new laptopEkranKartiDAO();
        }
        return ekranKarti;
    }

}
