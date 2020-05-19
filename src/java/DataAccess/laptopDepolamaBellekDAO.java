/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.laptopDepolamaBellek;
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
public class laptopDepolamaBellekDAO {

    private Connector connector;
    private Connection connection;

    public List<laptopDepolamaBellek> findAll() {
        List<laptopDepolamaBellek> depolamaBellek_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop_depolama_bellek");
            while (rs.next()) {
                laptopDepolamaBellek tmp = new laptopDepolamaBellek();
                tmp.setDepolama_bellek_id(rs.getLong("depolama_bellek_id"));
                tmp.setBellek_boyutu(rs.getInt("bellek_boyutu"));
                tmp.setBellek_frekansi(rs.getInt("bellek_frekansi"));
                tmp.setSabit_disk_boyutu(rs.getInt("sabit_disk_boyutu"));
                tmp.setSabit_disk_yazma_hizi(rs.getInt("sabit_disk_yazma_hizi"));
                tmp.setSsd_boyutu(rs.getInt("ssd_boyutu"));
                tmp.setSsd_tipi(rs.getString("ssd_tipi"));
                depolamaBellek_liste.add(tmp);
            }

            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "DepolamaDAO");
        }

        return depolamaBellek_liste;
    }

    public laptopDepolamaBellek find(Long id) {
        laptopDepolamaBellek depolamBellek = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop_depolama_bellek where depolama_bellek_id=" + id);
            rs.next();
            depolamBellek = new laptopDepolamaBellek();
            depolamBellek.setDepolama_bellek_id(rs.getLong("depolama_bellek_id"));
            depolamBellek.setBellek_boyutu(rs.getInt("bellek_boyutu"));
            depolamBellek.setBellek_frekansi(rs.getInt("bellek_frekansi"));
            depolamBellek.setSabit_disk_boyutu(rs.getInt("sabit_disk_boyutu"));
            depolamBellek.setSabit_disk_yazma_hizi(rs.getInt("sabit_disk_yazma_hizi"));
            depolamBellek.setSsd_boyutu(rs.getInt("ssd_boyutu"));
            depolamBellek.setSsd_tipi(rs.getString("ssd_tipi"));
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "DepolamaDAO");
        }

        return depolamBellek;

    }

    public Connector getConnector() {
        if (this.connector == null) {
            this.connector = new Connector();

        }
        return connector;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = this.getConnector().Connect();
        }
        return connection;
    }



}
