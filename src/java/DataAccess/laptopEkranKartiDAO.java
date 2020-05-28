/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.laptopDepolamaBellek;
import entity.laptopEkranKarti;
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
public class laptopEkranKartiDAO {

    private Connector connector;
    private Connection connection;

    public void remove(laptopEkranKarti ekranKarti) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from laptop_ekran_karti where ekran_karti_id=?");
            pst.setLong(1, ekranKarti.getEkran_karti_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void edit(laptopEkranKarti laptopEkranKarti) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update laptop_ekran_karti set ekran_karti_marka=?,ekran_karti_serisi=?,ekran_karti_modeli=?,ekran_karti_cekirdek_hizi=?,ekran_karti_bellek_boyutu=?,ekran_karti_bellek_turu=?,ekran_karti_bellek_arayuzu=? where ekran_karti_id=?");
            pst.setString(1, laptopEkranKarti.getEkran_karti_marka());
            pst.setString(2, laptopEkranKarti.getEkran_karti_serisi());
            pst.setString(3, laptopEkranKarti.getEkran_karti_modeli());
            pst.setDouble(4, laptopEkranKarti.getEkran_karti_cekirdek_hizi());
            pst.setInt(5, laptopEkranKarti.getEkran_karti_bellek_boyutu());
            pst.setString(6, laptopEkranKarti.getEkran_karti_bellek_turu());
            pst.setInt(7, laptopEkranKarti.getEkran_karti_bellek_arayuzu());
            pst.setLong(8, laptopEkranKarti.getEkran_karti_id());
            pst.executeUpdate();
            getConnection().close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(laptopEkranKarti laptopEkranKarti) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("INSERT INTO laptop_ekran_karti (ekran_karti_marka, ekran_karti_serisi, ekran_karti_modeli, ekran_karti_cekirdek_hizi, "
                    + "ekran_karti_bellek_boyutu, ekran_karti_bellek_turu, ekran_karti_bellek_arayuzu) VALUES"
                    + " ( '" + laptopEkranKarti.getEkran_karti_marka() + "', '" + laptopEkranKarti.getEkran_karti_serisi() + "', '" + laptopEkranKarti.getEkran_karti_modeli() + ""
                    + "', " + laptopEkranKarti.getEkran_karti_cekirdek_hizi() + ", " + laptopEkranKarti.getEkran_karti_bellek_boyutu() + ", '" + laptopEkranKarti.getEkran_karti_bellek_turu() + "'"
                    + ", " + laptopEkranKarti.getEkran_karti_bellek_arayuzu() + ");");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "EkranKarti DAO");
        }
    }

    public List<laptopEkranKarti> findAll(int page, int pageSize, int siralama) {
        String s = (siralama == 1) ? "asc" : "desc";
        int start = (page - 1) * pageSize;

        List<laptopEkranKarti> ekranKarti_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop_ekran_karti order by ekran_karti_id " + s + " limit " + start + "," + pageSize);
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

    public int countSize() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select count(ekran_karti_id) as ekran_karti_count from laptop_ekran_karti ");
            rs.next();
            count = rs.getInt("ekran_karti_count");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return count;

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

    public Connection getConnection() throws SQLException {
        if (this.connection == null) {
            this.connection = this.getConnector().Connect();
        }
        return connection;
    }

}
