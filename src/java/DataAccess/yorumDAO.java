/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.yorum;
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
public class yorumDAO {

    private Connector connector;
    private Connection connection;

    public List<yorum> getYorum(Long id, String secim) {
        String sorgu = null;
        List<yorum> yorumlist = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            switch (secim) {
                case "laptop":
                    sorgu = "select * from laptop_yorum where laptop_id=" + id;
                    break;
                case "telefon":
                    sorgu = "select * from telefon_yorum where telefon_id=" + id;
                    break;
                case "televizyon":
                    sorgu = "select * from televizyon_yorum where televizyon_id=" + id;
                    break;

            }
            ResultSet rs = st.executeQuery(sorgu);

            while (rs.next()) {
                yorumlist.add(this.find(rs.getLong("yorum_id")));

            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return yorumlist;
    }

    public yorum find(Long id) {
        yorum yorum = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from yorumlar where yorum_id=" + id);
            rs.next();
            yorum = new yorum();
            yorum.setYorum_id(rs.getLong("yorum_id"));
            yorum.setYorum_adSoyad(rs.getString("yorum_adSoyad"));
            yorum.setYorum_icerik(rs.getString("yorum_icerik"));
            yorum.setYorum_tarihi(rs.getString("yorum_tarih"));
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "yorum");
        }

        return yorum;
    }

    public List<yorum> findAll(String secim) {
        String sorgu = null;
        switch (secim) {
            case "laptop":
                sorgu = "select * from laptop_yorum";
                break;
            case "telefon":
                sorgu = "select * from telefon_yorum";
                break;
            case "televizyon":
                sorgu = "select * from televizyon_yorum";
                break;

        }
        List<yorum> yorumlist = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sorgu);
            while (rs.next()) {
                yorumlist.add(find(rs.getLong("yorum_id")));

            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return yorumlist;
    }

    public int countSize() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select count(yorum_id) as laptop_yorum_count from laptop_yorum ");
            rs.next();
            count = rs.getInt("laptop_yorum_count");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return count;

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

    public void insert(yorum yorum, Long id, String secim) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into yorumlar (yorum_icerik,yorum_adSoyad) values ('" + yorum.getYorum_icerik() + "','" + yorum.getYorum_adSoyad() + "')", Statement.RETURN_GENERATED_KEYS);
            Long yorum_id = null;
            ResultSet gk = st.getGeneratedKeys();
            if (gk.next()) {
                yorum_id = gk.getLong(1);
            }
            Statement st2 = this.getConnection().createStatement();
            switch (secim) {
                case "laptop":
                    st2.executeUpdate("insert into laptop_yorum (laptop_id,yorum_id) values (" + id + "," + yorum_id + ")");
                    break;
                case "telefon":
                    st2.executeUpdate("insert into telefon_yorum (telefon_id,yorum_id) values (" + id + "," + yorum_id + ")");
                    break;
                case "televizyon":
                    st2.executeUpdate("insert into televizyon_yorum (televizyon_id,yorum_id) values (" + id + "," + yorum_id + ")");
                    break;
                default:
                    break;
            }
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "yorum insert");
        }
    }

    public void remove(yorum yorum, String secim) {
        String sorgu = null;
        switch (secim) {
            case "laptop":
                sorgu = "delete from laptop_yorum where yorum_id=?";
                break;
            case "telefon":
                sorgu = "delete from telefon_yorum where yorum_id=?";
                break;
            case "televizyon":
                sorgu = "delete from televizyon_yorum where yorum_id=?";
                break;

        }
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(sorgu);
            pst.setLong(1, yorum.getYorum_id());
            pst.executeUpdate();
            PreparedStatement pst2 = this.getConnection().prepareStatement("delete from yorum where yorum_id=?");
            pst2.setLong(1, yorum.getYorum_id());
            pst2.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
