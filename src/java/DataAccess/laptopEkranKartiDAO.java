/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.laptopEkranKarti;
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
public class laptopEkranKartiDAO {

    private Connector connector;
    private Connection connection;

    public List<laptopEkranKarti> findAll() {
        List<laptopEkranKarti> ekranKarti_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop_ekran_karti");
            while (rs.next()) {
                laptopEkranKarti tmp = new laptopEkranKarti();
                tmp.setEkran_karti_id(rs.getLong("ekran_karti_id"));
                tmp.setEkran_karti_marka(rs.getString("ekran_karti_marka"));
                tmp.setEkran_karti_serisi(rs.getString("ekran_karti_serisi"));
                tmp.setEkran_karti_modeli(rs.getString("ekran_karti_modeli"));
                tmp.setEkran_karti_cekirdek_hizi(rs.getDouble("ekran_karti_cekirdek_hizi"));
                tmp.setEkran_karti_bellek_boyutu(rs.getInt("ekran_karti_bellek_boyutu"));
                tmp.setEkran_karti_bellek_turu(rs.getString("ekran_karti_bellek_turu"));
                tmp.setEkran_karti_bellek_arayuzu(rs.getInt("ekran_karti_bellek_arayuzu"));
                ekranKarti_liste.add(tmp);
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "EkranKarti DAO");
        }
        return ekranKarti_liste;
    }

    public laptopEkranKarti find(Long id) {
        laptopEkranKarti ekranKarti = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop_ekran_karti where ekran_karti_id=" + id);
            rs.next();
            ekranKarti = new laptopEkranKarti();
            ekranKarti.setEkran_karti_id(rs.getLong("ekran_karti_id"));
            ekranKarti.setEkran_karti_marka(rs.getString("ekran_karti_marka"));
            ekranKarti.setEkran_karti_serisi(rs.getString("ekran_karti_serisi"));
            ekranKarti.setEkran_karti_modeli(rs.getString("ekran_karti_modeli"));
            ekranKarti.setEkran_karti_cekirdek_hizi(rs.getDouble("ekran_karti_cekirdek_hizi"));
            ekranKarti.setEkran_karti_bellek_boyutu(rs.getInt("ekran_karti_bellek_boyutu"));
            ekranKarti.setEkran_karti_bellek_turu(rs.getString("ekran_karti_bellek_turu"));
            ekranKarti.setEkran_karti_bellek_arayuzu(rs.getInt("ekran_karti_bellek_arayuzu"));
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "EkranKarti DAO");
        }

        return ekranKarti;

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
