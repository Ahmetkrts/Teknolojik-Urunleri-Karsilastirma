/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.laptopEkran;
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
public class laptopEkranDAO {

    private Connector connector;
    private Connection connection;

    public void remove(laptopEkran ekran) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from laptop_ekran where ekran_id=?");
            pst.setLong(1, ekran.getEkran_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void edit(laptopEkran laptopEkran) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update laptop_ekran set ekran_boyutu=?,ekran_cozunurlugu=?,ekran_yenileme=? where ekran_id=?");
            pst.setDouble(1, laptopEkran.getEkran_boyutu());
            pst.setString(2, laptopEkran.getEkran_cozunurlugu());
            pst.setInt(3, laptopEkran.getEkran_yenileme());
            pst.setLong(4, laptopEkran.getEkran_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(laptopEkran laptopEkran) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("INSERT INTO laptop_ekran (ekran_boyutu, ekran_cozunurlugu, ekran_yenileme) VALUES"
                    + " ( " + laptopEkran.getEkran_boyutu() + ", '" + laptopEkran.getEkran_cozunurlugu() + "', " + laptopEkran.getEkran_yenileme() + ")");

            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "EkranDAo1");
        }
    }

    public List<laptopEkran> findAll() {

        List<laptopEkran> ekran_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop_ekran ");
            while (rs.next()) {
                laptopEkran tmp = new laptopEkran();
                tmp.setEkran_id(rs.getLong("ekran_id"));
                tmp.setEkran_boyutu(rs.getDouble("ekran_boyutu"));
                tmp.setEkran_cozunurlugu(rs.getString("ekran_cozunurlugu"));
                tmp.setEkran_yenileme(rs.getInt("ekran_yenileme"));
                ekran_liste.add(tmp);
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "EkranDAo2");
        }
        return ekran_liste;
    }

    public List<laptopEkran> findAll(int page, int pageSize, int siralama) {
        String s = (siralama == 1) ? "asc" : "desc";
        int start = (page - 1) * pageSize;
        List<laptopEkran> ekran_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop_ekran  order by ekran_id " + s + " limit " + start + "," + pageSize);
            while (rs.next()) {
                laptopEkran tmp = new laptopEkran();
                tmp.setEkran_id(rs.getLong("ekran_id"));
                tmp.setEkran_boyutu(rs.getDouble("ekran_boyutu"));
                tmp.setEkran_cozunurlugu(rs.getString("ekran_cozunurlugu"));
                tmp.setEkran_yenileme(rs.getInt("ekran_yenileme"));
                ekran_liste.add(tmp);
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "EkranDAo3");
        }
        return ekran_liste;
    }

    public int countSize() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select count(ekran_id) as ekran_count from laptop_ekran ");
            rs.next();
            count = rs.getInt("ekran_count");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return count;

    }

    public laptopEkran find(Long id) {
        laptopEkran ekran = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop_ekran where ekran_id=" + id);
            rs.next();
            ekran = new laptopEkran();
            ekran.setEkran_id(rs.getLong("ekran_id"));
            ekran.setEkran_boyutu(rs.getDouble("ekran_boyutu"));
            ekran.setEkran_cozunurlugu(rs.getString("ekran_cozunurlugu"));
            ekran.setEkran_yenileme(rs.getInt("ekran_yenileme"));
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "EkranDAo");
        }

        return ekran;

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
