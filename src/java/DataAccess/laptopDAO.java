/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.laptop;
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
public class laptopDAO {

    private Connector connector;
    private Connection connection;
    private laptopEkranDAO ekran;
    private laptopDepolamaBellekDAO depolamaBellek;
    private laptopIslemciDAO islemci;
    private laptopEkranKartiDAO ekranKarti;
    private laptopBaglantiDAO baglanti;
    private laptopPilDAO pil;

    public void remove(laptop laptop) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from laptop where laptop_id=?");
            pst.setLong(1, laptop.getLaptop_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void edit(laptop laptop) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update laptop set urun_adi=?,urun_tipi=?,urun_amaci=?,urun_ailesi=?,urun_serisi=?,isletim_sistemi=?,ekran_id=?,genislik=?,derinlik=?,kalinlik=?,agirlik=?,depolama_bellek_id=?,islemci_id=?,ekran_karti_id=?,pil_id=?,baglanti_id=? where laptop_id=?");
            pst.setString(1, laptop.getUrun_adi());
            pst.setString(2, laptop.getUrun_tipi());
            pst.setString(3, laptop.getUrun_amaci());
            pst.setString(4, laptop.getUrun_ailesi());
            pst.setString(5, laptop.getUrun_serisi());
            pst.setString(6, laptop.getIsletim_sistemi());
            pst.setLong(7, laptop.getEkran().getEkran_id());
            pst.setDouble(8, laptop.getGenislik());
            pst.setDouble(9, laptop.getDerinlik());
            pst.setDouble(10, laptop.getKalinlik());
            pst.setDouble(11, laptop.getAgirlik());
            pst.setLong(12, laptop.getDepolama_bellek().getDepolama_bellek_id());
            pst.setLong(13, laptop.getIslemci().getIslemci_id());
            pst.setLong(14, laptop.getEkran_karti().getEkran_karti_id());
            pst.setLong(15, laptop.getPil().getPil_id());
            pst.setLong(16, laptop.getBaglanti().getBaglanti_id());
            pst.setLong(17, laptop.getLaptop_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(laptop laptop) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("INSERT INTO laptop ( urun_adi, urun_tipi, urun_amaci, urun_ailesi, urun_serisi, isletim_sistemi, ekran_id, genislik, derinlik, kalinlik,"
                    + " agirlik, depolama_bellek_id, islemci_id, ekran_karti_id, pil_id, baglanti_id) VALUES ( '" + laptop.getUrun_adi() + "', '" + laptop.getUrun_tipi() + "', '" + laptop.getUrun_amaci() + "', '" + laptop.getUrun_ailesi() + "'"
                    + ", '" + laptop.getUrun_serisi() + "', '" + laptop.getIsletim_sistemi() + "', " + laptop.getEkran().getEkran_id() + ", " + laptop.getGenislik() + ", " + laptop.getDerinlik() + ", " + laptop.getKalinlik() + ", " + laptop.getAgirlik() + ", " + laptop.getDepolama_bellek().getDepolama_bellek_id() + ", " + laptop.getIslemci().getIslemci_id() + ", " + laptop.getEkran_karti().getEkran_karti_id() + ", " + laptop.getPil().getPil_id() + ", " + laptop.getBaglanti().getBaglanti_id() + ")");
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
                tmp.setBaglanti(this.getBaglanti().find(rs.getLong("baglanti_id")));
                tmp.setEkran(this.getEkran().find(rs.getLong("ekran_id")));
                tmp.setPil(this.getPil().find(rs.getLong("pil_id")));
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

    public laptopBaglantiDAO getBaglanti() {
        if (this.baglanti == null) {
            this.baglanti = new laptopBaglantiDAO();
        }
        return baglanti;
    }

    public laptopPilDAO getPil() {
        if (this.pil == null) {
            this.pil = new laptopPilDAO();
        }
        return pil;
    }

}
