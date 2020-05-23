/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.laptopDepolamaBellek;
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
public class laptopDepolamaBellekDAO {

    private Connector connector;
    private Connection connection;

    public void remove(laptopDepolamaBellek depolama) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from laptop_depolama_bellek where depolama_bellek_id=?");
            pst.setLong(1, depolama.getDepolama_bellek_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void edit(laptopDepolamaBellek laptopDepolamaBellek) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update laptop_depolama_bellek set bellek_boyutu=?,bellek_frekansi=?,sabit_disk_boyutu=?,sabit_disk_yazma_hizi=?,ssd_boyutu=?,ssd_tipi=? where depolama_bellek_id=?");
            pst.setInt(1, laptopDepolamaBellek.getBellek_boyutu());
            pst.setInt(2, laptopDepolamaBellek.getBellek_frekansi());
            pst.setInt(3, laptopDepolamaBellek.getSabit_disk_boyutu());
            pst.setInt(4, laptopDepolamaBellek.getSabit_disk_yazma_hizi());
            pst.setInt(5, laptopDepolamaBellek.getSsd_boyutu());
            pst.setString(5, laptopDepolamaBellek.getSsd_tipi());
            pst.setLong(6, laptopDepolamaBellek.getDepolama_bellek_id());
            pst.executeUpdate();
            getConnection().close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(laptopDepolamaBellek laptopDepolamaBellek) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("INSERT INTO laptop_depolama_bellek (bellek_boyutu, bellek_frekansi, sabit_disk_boyutu, sabit_disk_yazma_hizi, ssd_boyutu, ssd_tipi) VALUES"
                    + "(" + laptopDepolamaBellek.getBellek_boyutu() + " ," + laptopDepolamaBellek.getBellek_frekansi() + " ," + laptopDepolamaBellek.getSabit_disk_boyutu() + " ,"
                    + "" + laptopDepolamaBellek.getSabit_disk_yazma_hizi() + " ," + laptopDepolamaBellek.getSsd_boyutu() + " ,'" + laptopDepolamaBellek.getSsd_tipi() + "' )");

            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "DepolamaDAO1");
        }
    }

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
            System.out.println(e.getMessage() + "DepolamaDAO2");
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
            System.out.println(e.getMessage() + "DepolamaDAO3");
        }

        return depolamBellek;

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
