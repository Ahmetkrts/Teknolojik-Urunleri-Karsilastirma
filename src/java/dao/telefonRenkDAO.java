/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
            getConnection().close();
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
            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return renk;
    }

    public List<telefonRenk> findAll() {
        List<telefonRenk> renklist = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_renkleri");

            while (rs.next()) {
                telefonRenk tmp = new telefonRenk();
                tmp.setRenk_id(rs.getLong("renk_id"));
                tmp.setRenk_adi(rs.getString("renk_adi"));
                renklist.add(tmp);

            }
            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return renklist;
    }

    public Connector getConnector() {
        if (this.connector == null) {
            this.connector = new Connector();
        }
        return connector;
    }

    public Connection getConnection() {
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

    

}
