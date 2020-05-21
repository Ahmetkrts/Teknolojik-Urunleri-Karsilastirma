/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DataAccess.laptopDepolamaBellekDAO;
import DataAccess.laptopEkranDAO;
import DataAccess.laptopEkranKartiDAO;
import entity.laptop;
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

    public void delete(laptop laptop) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("DELETE From laptop WHERE laptop_id=" + laptop.getLaptop_id());
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "----------------------LaptopDAO");
        }
    }

    public void update(laptop laptop, Long selectEkran, Long selectDepolamaBellek, Long selectIslemci, Long selectEkranKarti, Long selectPil, Long selectBaglanti) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("UPDATE laptop SET urun_adi='" + laptop.getUrun_adi() + "', urun_tipi='" + laptop.getUrun_tipi() + "', urun_amaci='" + laptop.getUrun_amaci() + "', urun_ailesi='" + laptop.getUrun_ailesi() + "', urun_serisi='" + laptop.getUrun_serisi() + "', isletim_sistemi='" + laptop.getIsletim_sistemi() + "',"
                    + " ekran_id=" + selectEkran + ", genislik=" + laptop.getGenislik() + ", derinlik=" + laptop.getDerinlik() + ", kalinlik=" + laptop.getKalinlik() + ", agirlik=" + laptop.getAgirlik() + ", depolama_bellek_id=" + selectDepolamaBellek + ", islemci_id=" + selectIslemci + ", "
                    + "ekran_karti_id=" + selectEkranKarti + ", pil_id=" + selectPil + ", baglanti_id=" + selectBaglanti + " where laptop_id=" + laptop.getLaptop_id() + "");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "----------------------LaptopDAO");
        }
    }

    public void insert(laptop laptop, Long selectEkran, Long selectDepolamaBellek, Long selectIslemci, Long selectEkranKarti, Long selectPil, Long selectBaglanti) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("INSERT INTO laptop ( urun_adi, urun_tipi, urun_amaci, urun_ailesi, urun_serisi, isletim_sistemi, ekran_id, genislik, derinlik, kalinlik,"
                    + " agirlik, depolama_bellek_id, islemci_id, ekran_karti_id, pil_id, baglanti_id) VALUES ( '" + laptop.getUrun_adi() + "', '" + laptop.getUrun_tipi() + "', '" + laptop.getUrun_amaci() + "', '" + laptop.getUrun_ailesi() + "'"
                    + ", '" + laptop.getUrun_serisi() + "', '" + laptop.getIsletim_sistemi() + "', " + selectEkran + ", " + laptop.getGenislik() + ", " + laptop.getDerinlik() + ", " + laptop.getKalinlik() + ", " + laptop.getAgirlik() + ", " + selectDepolamaBellek + ", " + selectIslemci + ", " + selectEkranKarti + ", " + selectPil + ", " + selectBaglanti + ")");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "LaptopDAO");
        }
    }

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

    public Connection getConnection() throws SQLException {
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
