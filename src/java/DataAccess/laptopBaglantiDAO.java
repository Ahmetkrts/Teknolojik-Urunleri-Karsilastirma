/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.laptopBaglanti;
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
public class laptopBaglantiDAO {

    private Connector connector;
    private Connection connection;

    public laptopBaglanti find(Long id) {
        laptopBaglanti baglanti = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop_baglanti where baglanti_id=" + id);
            rs.next();
            baglanti = new laptopBaglanti();
            baglanti.setBaglanti_id(rs.getLong("baglanti_id"));
            baglanti.setUsb3x_adeti(rs.getInt("usb3x_adeti"));
            baglanti.setUsbtypec_adeti(rs.getInt("usbtypec_adeti"));
            baglanti.setHdmi_ozellikleri(rs.getString("hdmi_ozellikleri"));
            baglanti.setBluetooth_ozellikleri(rs.getString("bluetooth_ozellikleri"));
            baglanti.setEthernet_ozellikleri(rs.getString("ethernet_ozellikleri"));
            baglanti.setWifi_ozellikleri(rs.getString("wifi_ozellikleri"));
            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return baglanti;
    }

    public List<laptopBaglanti> findAll() {
        List<laptopBaglanti> baglanti_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop_baglanti ");
            while (rs.next()) {
                laptopBaglanti tmp = new laptopBaglanti();
                tmp.setBaglanti_id(rs.getLong("baglanti_id"));
                tmp.setUsb3x_adeti(rs.getInt("usb3x_adeti"));
                tmp.setUsbtypec_adeti(rs.getInt("usbtypec_adeti"));
                tmp.setHdmi_ozellikleri(rs.getString("hdmi_ozellikleri"));
                tmp.setBluetooth_ozellikleri(rs.getString("bluetooth_ozellikleri"));
                tmp.setEthernet_ozellikleri(rs.getString("ethernet_ozellikleri"));
                tmp.setWifi_ozellikleri(rs.getString("wifi_ozellikleri"));
                baglanti_liste.add(tmp);

            }
            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "baglantiDAO ");
        }
        return baglanti_liste;
    }

    public List<laptopBaglanti> findAll(int page, int pageSize, int siralama) {
        String s = (siralama == 1) ? "asc" : "desc";
        int start = (page - 1) * pageSize;
        List<laptopBaglanti> baglanti_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop_baglanti order by baglanti_id " + s + " limit " + start + "," + pageSize);
            while (rs.next()) {
                laptopBaglanti tmp = new laptopBaglanti();
                tmp.setBaglanti_id(rs.getLong("baglanti_id"));
                tmp.setUsb3x_adeti(rs.getInt("usb3x_adeti"));
                tmp.setUsbtypec_adeti(rs.getInt("usbtypec_adeti"));
                tmp.setHdmi_ozellikleri(rs.getString("hdmi_ozellikleri"));
                tmp.setBluetooth_ozellikleri(rs.getString("bluetooth_ozellikleri"));
                tmp.setEthernet_ozellikleri(rs.getString("ethernet_ozellikleri"));
                tmp.setWifi_ozellikleri(rs.getString("wifi_ozellikleri"));
                baglanti_liste.add(tmp);

            }
            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "baglantiDAO ");
        }
        return baglanti_liste;
    }

    public int countSize() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select count(baglanti_id) as laptop_count from laptop_baglanti ");
            rs.next();
            count = rs.getInt("laptop_count");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return count;

    }

    public void remove(laptopBaglanti laptopBaglanti) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from laptop_baglanti where baglanti_id=?");
            pst.setLong(1, laptopBaglanti.getBaglanti_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void edit(laptopBaglanti laptopBaglanti) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update laptop_baglanti set usb3x_adeti=?,usbtypec_adeti=?,hdmi_ozellikleri=?,bluetooth_ozellikleri=?,ethernet_ozellikleri=?,wifi_ozellikleri=? where baglanti_id=?");
            pst.setInt(1, laptopBaglanti.getUsb3x_adeti());
            pst.setInt(2, laptopBaglanti.getUsbtypec_adeti());
            pst.setString(3, laptopBaglanti.getHdmi_ozellikleri());
            pst.setString(4, laptopBaglanti.getBluetooth_ozellikleri());
            pst.setString(5, laptopBaglanti.getEthernet_ozellikleri());
            pst.setString(6, laptopBaglanti.getWifi_ozellikleri());
            pst.setLong(7, laptopBaglanti.getBaglanti_id());
            pst.executeUpdate();
            getConnection().close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(laptopBaglanti laptopBaglanti) {
        try {

            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into laptop_baglanti (usb3x_adeti, usbtypec_adeti, hdmi_ozellikleri, bluetooth_ozellikleri, ethernet_ozellikleri, wifi_ozellikleri) values"
                    + "	(" + laptopBaglanti.getUsb3x_adeti() + ", " + laptopBaglanti.getUsbtypec_adeti() + ",' " + laptopBaglanti.getHdmi_ozellikleri() + "', '" + laptopBaglanti.getBluetooth_ozellikleri() + "',"
                    + " '" + laptopBaglanti.getEthernet_ozellikleri() + "', '" + laptopBaglanti.getWifi_ozellikleri() + "')");

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "baglantiDAO 2");
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
