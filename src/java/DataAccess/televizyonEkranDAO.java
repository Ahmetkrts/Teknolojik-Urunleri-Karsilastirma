/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

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
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ekran;
    }

    public List<televizyonEkran> findAll(int page, int pageSize, int siralama) {
        String s = (siralama == 1) ? "asc" : "desc";
        int start = (page - 1) * pageSize;

        List<televizyonEkran> ekran_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from televizyon_ekran order by ekran_id " + s + " limit " + start + "," + pageSize);
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
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ekran_liste;
    }

    public List<televizyonEkran> findAll() {

        List<televizyonEkran> ekran_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from televizyon_ekran ");
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
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ekran_liste;
    }

    public int countSize() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select count(ekran_id) as televizyon_ekran_count from televizyon_ekran ");
            rs.next();
            count = rs.getInt("televizyon_ekran_count");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return count;

    }

    public void edit(televizyonEkran ekran) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update televizyon_ekran set ekran_turu=?,ekran_tipi=?,ekran_boyutu=?,ekran_cozunurlugu=?,HDR=? where ekran_id=?");
            pst.setString(1, ekran.getEkran_turu());
            pst.setString(2, ekran.getEkran_tipi());
            pst.setInt(3, ekran.getEkran_boyutu());
            pst.setString(4, ekran.getEkran_cozunurlugu());
            pst.setString(5, ekran.getHDR());
            pst.setLong(6, ekran.getEkran_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(televizyonEkran ekran) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from televizyon_ekran where ekran_id=?");
            pst.setLong(1, ekran.getEkran_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(televizyonEkran ekran) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into televizyon_ekran (ekran_turu,ekran_tipi,ekran_boyutu,ekran_cozunurlugu,HDR) values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, ekran.getEkran_turu());
            pst.setString(2, ekran.getEkran_tipi());
            pst.setInt(3, ekran.getEkran_boyutu());
            pst.setString(4, ekran.getEkran_cozunurlugu());
            pst.setString(5, ekran.getHDR());

            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connector getConnector() {
        if (this.connector == null) {
            this.connector = new Connector();
        }
        return connector;
    }

    public Connection getConnection() throws SQLException {
        this.connection = this.getConnector().Connect();
        return connection;
    }

}
