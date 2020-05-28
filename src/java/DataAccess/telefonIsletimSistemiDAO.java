/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.telefonIsletimSistemi;
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
public class telefonIsletimSistemiDAO {

    private Connector connector;
    private Connection connection;

    public telefonIsletimSistemi find(Long id) {
        telefonIsletimSistemi isletimsistemi = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_isletimsistemi where isletim_sistemi_id=" + id);
            rs.next();
            isletimsistemi = new telefonIsletimSistemi();
            isletimsistemi.setIsletim_sistemi_id(rs.getLong("isletim_sistemi_id"));
            isletimsistemi.setIsletim_sistemi_versiyon(rs.getString("isletim_sistemi_versiyon"));
            isletimsistemi.setIsletim_sistemi(rs.getString("isletim_sistemi"));
            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isletimsistemi;
    }

    public List<telefonIsletimSistemi> findAll(int page, int pageSize, int siralama) {
        String s = (siralama == 1) ? "asc" : "desc";
        int start = (page - 1) * pageSize;

        List<telefonIsletimSistemi> isletimsistemi_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_isletimsistemi order by isletim_sistemi_id " + s + " limit " + start + "," + pageSize);
            while (rs.next()) {
                telefonIsletimSistemi tmp = new telefonIsletimSistemi();
                tmp.setIsletim_sistemi_id(rs.getLong("isletim_sistemi_id"));
                tmp.setIsletim_sistemi_versiyon(rs.getString("isletim_sistemi_versiyon"));
                tmp.setIsletim_sistemi(rs.getString("isletim_sistemi"));

                isletimsistemi_liste.add(tmp);
            }
            getConnection().close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isletimsistemi_liste;
    }

    public List<telefonIsletimSistemi> findAll() {

        List<telefonIsletimSistemi> isletimsistemi_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_isletimsistemi");
            while (rs.next()) {
                telefonIsletimSistemi tmp = new telefonIsletimSistemi();
                tmp.setIsletim_sistemi_id(rs.getLong("isletim_sistemi_id"));
                tmp.setIsletim_sistemi_versiyon(rs.getString("isletim_sistemi_versiyon"));
                tmp.setIsletim_sistemi(rs.getString("isletim_sistemi"));

                isletimsistemi_liste.add(tmp);
            }
            getConnection().close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isletimsistemi_liste;
    }

    public int countSize() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select count(isletim_sistemi_id) as telefon_isletimsistemi_count from telefon_isletimsistemi ");
            rs.next();
            count = rs.getInt("telefon_isletimsistemi_count");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "LaptopDAO");
        }

        return count;

    }

    public void edit(telefonIsletimSistemi isletimSistemi) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update telefon_isletimsistemi set isletim_sistemi_versiyon=?,isletim_sistemi=? where isletim_sistemi_id=?");
            pst.setString(1, isletimSistemi.getIsletim_sistemi_versiyon());
            pst.setString(2, isletimSistemi.getIsletim_sistemi());
            pst.setLong(3, isletimSistemi.getIsletim_sistemi_id());
            pst.executeUpdate();
            getConnection().close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(telefonIsletimSistemi isletimSistemi) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from telefon_isletimsistemi where isletim_sistemi_id=?");
            pst.setLong(1, isletimSistemi.getIsletim_sistemi_id());
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

    public void insert(telefonIsletimSistemi isletimSistemi) {
        try {
            Statement st = getConnection().createStatement();
            st.executeUpdate("insert into telefon_isletimsistemi (isletim_sistemi_versiyon,isletim_sistemi) values ('" + isletimSistemi.getIsletim_sistemi_versiyon() + "',"
                    + "'" + isletimSistemi.getIsletim_sistemi() + "')");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
