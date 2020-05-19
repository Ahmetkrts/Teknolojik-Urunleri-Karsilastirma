/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.laptopBaglanti;
import java.sql.Connection;
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


    public List<laptopBaglanti> findAll() {
        List<laptopBaglanti> baglanti_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop_baglanti");
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
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "baglantiDAO ");
        }
        return baglanti_liste;
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

}
