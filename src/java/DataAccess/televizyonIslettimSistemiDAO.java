/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.televizyonIslettimSistemi;
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
public class televizyonIslettimSistemiDAO {

    private Connector connector;
    private Connection connection;

    public televizyonIslettimSistemi find(Long id) {
        televizyonIslettimSistemi isletimsistemi = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from televizyon_isletim_sistemi where isletim_sistemi_id=" + id);
            rs.next();
            isletimsistemi = new televizyonIslettimSistemi();
            isletimsistemi.setIsletim_sistemi_id(rs.getLong("isletim_sistemi_id"));
            isletimsistemi.setIsletim_sistemi(rs.getString("isletim_sistemi"));
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isletimsistemi;
    }

    public List<televizyonIslettimSistemi> findAll(int page, int pageSize, int siralama) {
        String s = (siralama == 1) ? "asc" : "desc";
        int start = (page - 1) * pageSize;

        List<televizyonIslettimSistemi> isletimsistemi_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from televizyon_isletim_sistemi order by isletim_sistemi_id " + s + " limit " + start + "," + pageSize);
            while (rs.next()) {
                televizyonIslettimSistemi tmp = new televizyonIslettimSistemi();
                tmp.setIsletim_sistemi_id(rs.getLong("isletim_sistemi_id"));
                tmp.setIsletim_sistemi(rs.getString("isletim_sistemi"));
                isletimsistemi_liste.add(tmp);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isletimsistemi_liste;
    }

    public List<televizyonIslettimSistemi> findAll() {

        List<televizyonIslettimSistemi> isletimsistemi_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from televizyon_isletim_sistemi ");
            while (rs.next()) {
                televizyonIslettimSistemi tmp = new televizyonIslettimSistemi();
                tmp.setIsletim_sistemi_id(rs.getLong("isletim_sistemi_id"));
                tmp.setIsletim_sistemi(rs.getString("isletim_sistemi"));
                isletimsistemi_liste.add(tmp);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isletimsistemi_liste;
    }

    public int countSize() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select count(isletim_sistemi_id) as televizyon_isletim_sistemi_count from televizyon_isletim_sistemi ");
            rs.next();
            count = rs.getInt("televizyon_isletim_sistemi_count");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return count;

    }

    public void edit(televizyonIslettimSistemi isletimSistemi) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update televizyon_isletim_sistemi set isletim_sistemi=? where isletim_sistemi_id=?");
            pst.setString(1, isletimSistemi.getIsletim_sistemi());
            pst.setLong(2, isletimSistemi.getIsletim_sistemi_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(televizyonIslettimSistemi isletimSistemi) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from televizyon_isletim_sistemi where isletim_sistemi_id=?");
            pst.setLong(1, isletimSistemi.getIsletim_sistemi_id());
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

    public void insert(televizyonIslettimSistemi isletimSistemi) {
        try {
            Statement st = getConnection().createStatement();
            st.executeUpdate("insert into televizyon_isletim_sistemi (isletim_sistemi) values ('" + isletimSistemi.getIsletim_sistemi() + "')");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
