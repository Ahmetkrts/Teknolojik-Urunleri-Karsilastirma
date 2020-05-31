/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.kullanici;
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
public class kullaniciDAO {

    private Connector connector;
    private Connection connection;

    public void remove(kullanici kullanici) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from kullanici where kullanici_id=?");
            pst.setLong(1, kullanici.getKullanici_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void edit(kullanici kullanici) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update kullanici set kullanici_adSoyad=?,kullanici_adi=?,kullanici_sifre=? where kullanici_id=?");
            pst.setString(1, kullanici.getKullanici_adSoyad());
            pst.setString(2, kullanici.getKullanici_adi());
            pst.setString(3, kullanici.getKullanici_sifre());
            pst.setLong(4, kullanici.getKullanici_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(kullanici kullanici) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into kullanici (kullanici_adSoyad,kullanici_adi,kullanici_sifre) values (?,?,?)");
            pst.setString(1, kullanici.getKullanici_adSoyad());
            pst.setString(2, kullanici.getKullanici_adi());
            pst.setString(3, kullanici.getKullanici_sifre());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "kullaniciDAo1");
        }
    }

    public List<kullanici> findAll() {

        List<kullanici> kullanici_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici ");
            while (rs.next()) {
                kullanici tmp = new kullanici();
                tmp.setKullanici_id(rs.getLong("kullanici_id"));
                tmp.setKullanici_adSoyad(rs.getString("kullanici_adSoyad"));
                tmp.setKullanici_adi(rs.getString("kullanici_adi"));
                tmp.setKullanici_sifre(rs.getString("kullanici_sifre"));
                kullanici_liste.add(tmp);
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "kullaniciDAo2");
        }
        return kullanici_liste;
    }

    public List<kullanici> findAll(int page, int pageSize, int siralama) {
        String s = (siralama == 1) ? "asc" : "desc";
        int start = (page - 1) * pageSize;
        List<kullanici> kullanici_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici  order by kullanici_id " + s + " limit " + start + "," + pageSize);
            while (rs.next()) {
                kullanici tmp = new kullanici();
                tmp.setKullanici_id(rs.getLong("kullanici_id"));
                tmp.setKullanici_adSoyad(rs.getString("kullanici_adSoyad"));
                tmp.setKullanici_adi(rs.getString("kullanici_adi"));
                tmp.setKullanici_sifre(rs.getString("kullanici_sifre"));

                kullanici_liste.add(tmp);
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "kullaniciDAo3");
        }
        return kullanici_liste;
    }

    public int countSize() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select count(kullanici_id) as kullanici_count from kullanici ");
            rs.next();
            count = rs.getInt("kullanici_count");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return count;

    }

    public kullanici find(Long id) {
        kullanici kullanici = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici where kullanici_id=" + id);
            rs.next();
            kullanici = new kullanici();
            kullanici.setKullanici_id(rs.getLong("kullanici_id"));
            kullanici.setKullanici_adSoyad(rs.getString("kullanici_adSoyad"));
            kullanici.setKullanici_adi(rs.getString("kullanici_adi"));
            kullanici.setKullanici_sifre(rs.getString("kullanici_sifre"));

            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "kullaniciDAo");
        }

        return kullanici;

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
