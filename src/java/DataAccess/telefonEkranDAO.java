/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.telefonEkran;
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
public class telefonEkranDAO {

    private Connector connector;
    private Connection connection;

    public telefonEkran find(Long id) {
        telefonEkran ekran = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_ekran where ekran_id=" + id);
            rs.next();
            ekran = new telefonEkran();
            ekran.setEkran_id(rs.getLong("ekran_id"));
            ekran.setEkran_boyutu(rs.getDouble("ekran_boyutu"));
            ekran.setEkran_teknolojisi(rs.getString("ekran_teknolojisi"));
            ekran.setEkran_cozunurlugu(rs.getString("ekran_cozunurlugu"));
            ekran.setPiksel_yogunlugu(rs.getInt("piksel_yogunlugu"));
            ekran.setEkran_dayanikliligi(rs.getString("ekran_dayanikligi"));
            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ekran;
    }

    public List<telefonEkran> findAll(int page, int pageSize, int siralama) {
        String s = (siralama == 1) ? "asc" : "desc";
        int start = (page - 1) * pageSize;

        List<telefonEkran> ekran_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_ekran order by ekran_id " + s + " limit " + start + "," + pageSize);
            while (rs.next()) {
                telefonEkran tmp = new telefonEkran();
                tmp.setEkran_id(rs.getLong("ekran_id"));
                tmp.setEkran_boyutu(rs.getDouble("ekran_boyutu"));
                tmp.setEkran_teknolojisi(rs.getString("ekran_teknolojisi"));
                tmp.setEkran_cozunurlugu(rs.getString("ekran_cozunurlugu"));
                tmp.setPiksel_yogunlugu(rs.getInt("piksel_yogunlugu"));
                tmp.setEkran_dayanikliligi(rs.getString("ekran_dayanikligi"));
                ekran_liste.add(tmp);
            }
            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ekran_liste;
    }

    public List<telefonEkran> findAll() {

        List<telefonEkran> ekran_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_ekran ");;
            while (rs.next()) {
                telefonEkran tmp = new telefonEkran();
                tmp.setEkran_id(rs.getLong("ekran_id"));
                tmp.setEkran_boyutu(rs.getDouble("ekran_boyutu"));
                tmp.setEkran_teknolojisi(rs.getString("ekran_teknolojisi"));
                tmp.setEkran_cozunurlugu(rs.getString("ekran_cozunurlugu"));
                tmp.setPiksel_yogunlugu(rs.getInt("piksel_yogunlugu"));
                tmp.setEkran_dayanikliligi(rs.getString("ekran_dayanikligi"));
                ekran_liste.add(tmp);
            }
            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ekran_liste;
    }

    public int countSize() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select count(ekran_id) as telefon_ekran_count from telefon_ekran ");
            rs.next();
            count = rs.getInt("telefon_ekran_count");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return count;

    }

    public void edit(telefonEkran ekran) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update telefon_ekran set ekran_boyutu=?,ekran_teknolojisi=?,ekran_cozunurlugu=?,piksel_yogunlugu=?,ekran_dayanikligi=? where ekran_id=?");
            pst.setDouble(1, ekran.getEkran_boyutu());
            pst.setString(2, ekran.getEkran_teknolojisi());
            pst.setString(3, ekran.getEkran_cozunurlugu());
            pst.setInt(4, ekran.getPiksel_yogunlugu());
            pst.setString(5, ekran.getEkran_dayanikliligi());
            pst.setLong(6, ekran.getEkran_id());
            pst.executeUpdate();
            getConnection().close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(telefonEkran ekran) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from telefon_ekran where ekran_id=?");
            pst.setLong(1, ekran.getEkran_id());
            pst.executeUpdate();
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

    public void insert(telefonEkran ekran) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into telefon_ekran (ekran_boyutu,ekran_teknolojisi,ekran_cozunurlugu,piksel_yogunlugu,ekran_dayanikligi)values("
                    + "" + ekran.getEkran_boyutu() + ",'" + ekran.getEkran_teknolojisi() + "','" + ekran.getEkran_cozunurlugu() + "'," + ekran.getPiksel_yogunlugu() + ""
                    + ",'" + ekran.getEkran_dayanikliligi() + "')");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
