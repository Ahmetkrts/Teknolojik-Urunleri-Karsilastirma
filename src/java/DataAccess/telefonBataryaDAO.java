/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.telefonBatarya;
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
public class telefonBataryaDAO {

    private Connector connector;
    private Connection connection;

    public List<telefonBatarya> findAll(int page, int pageSize, int siralama) {
        String s = (siralama == 1) ? "asc" : "desc";
        int start = (page - 1) * pageSize;

        List< telefonBatarya> batarya_liste = new ArrayList<>();
        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_batarya order by batarya_id " + s + " limit " + start + "," + pageSize);
            while (rs.next()) {
                telefonBatarya tmp = new telefonBatarya();
                tmp.setBatarya_id(rs.getLong("batarya_id"));
                tmp.setBatarya_kapasitesi(rs.getInt("batarya_kapasitesi"));
                tmp.setBatarya_teknolojisi(rs.getString("batarya_teknolojisi"));
                tmp.setHizli_sarj_ozelligi(rs.getString("hizli_sarj_ozelligi"));
                batarya_liste.add(tmp);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return batarya_liste;
    }

    public List<telefonBatarya> findAll() {

        List< telefonBatarya> batarya_liste = new ArrayList<>();
        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_batarya ");
            while (rs.next()) {
                telefonBatarya tmp = new telefonBatarya();
                tmp.setBatarya_id(rs.getLong("batarya_id"));
                tmp.setBatarya_kapasitesi(rs.getInt("batarya_kapasitesi"));
                tmp.setBatarya_teknolojisi(rs.getString("batarya_teknolojisi"));
                tmp.setHizli_sarj_ozelligi(rs.getString("hizli_sarj_ozelligi"));
                batarya_liste.add(tmp);
            }
             st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return batarya_liste;
    }

    public int countSize() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select count(batarya_id) as telefon_batarya_count from telefon_batarya ");
            rs.next();
            count = rs.getInt("telefon_batarya_count");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "LaptopDAO");
        }

        return count;

    }

    public telefonBatarya find(Long id) {
        telefonBatarya batarya = null;
        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_batarya where batarya_id=" + id);
            rs.next();
            batarya = new telefonBatarya();
            batarya.setBatarya_id(rs.getLong("batarya_id"));
            batarya.setBatarya_kapasitesi(rs.getInt("batarya_kapasitesi"));
            batarya.setBatarya_teknolojisi(rs.getString("batarya_teknolojisi"));
            batarya.setHizli_sarj_ozelligi(rs.getString("hizli_sarj_ozelligi"));
             st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return batarya;
    }

    public void insert(telefonBatarya batarya) {
        try {
            Statement st = getConnection().createStatement();
            st.executeUpdate("insert into telefon_batarya (batarya_kapasitesi,batarya_teknolojisi,hizli_sarj_ozelligi) values ("
                    + "" + batarya.getBatarya_kapasitesi() + ",'" + batarya.getBatarya_teknolojisi() + "','" + batarya.getHizli_sarj_ozelligi() + "')");
 st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void edit(telefonBatarya batarya) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update telefon_batarya set batarya_kapasitesi=?,batarya_teknolojisi=?,hizli_sarj_ozelligi=? where batarya_id=?");
            pst.setInt(1, batarya.getBatarya_kapasitesi());
            pst.setString(2, batarya.getBatarya_teknolojisi());
            pst.setString(3, batarya.getHizli_sarj_ozelligi());
            pst.setLong(4, batarya.getBatarya_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(telefonBatarya batarya) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from telefon_batarya where batarya_id=?");
            pst.setLong(1, batarya.getBatarya_id());
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
