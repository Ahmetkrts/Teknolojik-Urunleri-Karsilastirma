/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.telefonRenk;
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
public class telefonRenkDAO {

    private Connector connector;
    private Connection connection;

    public List<telefonRenk> getRenk(Long telefon_id) {
        List<telefonRenk> renklist = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_renk where telefon_id=" + telefon_id);

            while (rs.next()) {
                renklist.add(this.find(rs.getLong("renk_id")));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return renklist;
    }

    public telefonRenk find(Long id) {
        telefonRenk renk = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_renkleri where renk_id=" + id);
            rs.next();
            renk = new telefonRenk();
            renk.setRenk_id(rs.getLong("renk_id"));
            renk.setRenk_adi(rs.getString("renk_adi"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return renk;
    }

    public List<telefonRenk> findAll(int page, int pageSize, int siralama) {
        String s = (siralama == 1) ? "asc" : "desc";
        int start = (page - 1) * pageSize;

        List<telefonRenk> renklist = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_renkleri order by renk_id " + s + " limit " + start + "," + pageSize);;

            while (rs.next()) {
                telefonRenk tmp = new telefonRenk();
                tmp.setRenk_id(rs.getLong("renk_id"));
                tmp.setRenk_adi(rs.getString("renk_adi"));
                renklist.add(tmp);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return renklist;
    }

    public List<telefonRenk> findAll() {

        List<telefonRenk> renklist = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_renkleri ");

            while (rs.next()) {
                telefonRenk tmp = new telefonRenk();
                tmp.setRenk_id(rs.getLong("renk_id"));
                tmp.setRenk_adi(rs.getString("renk_adi"));
                renklist.add(tmp);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return renklist;
    }

    public int countSize() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select count(renk_id) as telefon_renkleri_count from telefon_renkleri ");
            rs.next();
            count = rs.getInt("telefon_renkleri_count");
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

    public void insert(telefonRenk renk) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into telefon_renkleri (renk_adi) values ('" + renk.getRenk_adi() + "')");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void edit(telefonRenk renk) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update telefon_renkleri set renk_adi=? where renk_id=?");
            pst.setString(1, renk.getRenk_adi());
            pst.setLong(2, renk.getRenk_id());
            pst.executeUpdate();
            getConnection().close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(telefonRenk renk) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from telefon_renkleri where renk_id=?");
            pst.setLong(1, renk.getRenk_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
