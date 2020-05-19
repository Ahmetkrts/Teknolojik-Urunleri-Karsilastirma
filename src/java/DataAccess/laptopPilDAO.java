/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.laptopPil;
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
public class laptopPilDAO {

    private Connector connector;
    private Connection connection;

    public void delete(laptopPil pil) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("DELETE FROM laptop_pil  WHERE pil_id=" + pil.getPil_id());
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(laptopPil laptopPil) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("UPDATE laptop_pil SET pil_gucu=" + laptopPil.getPil_gucu() + ", pil_hucre_sayisi=" + laptopPil.getPil_hucre_sayisi() + ", pil_ozellikleri='" + laptopPil.getPil_ozellikleri() + "' WHERE pil_id=" + laptopPil.getPil_id());
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(laptopPil laptopPil) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("INSERT INTO laptop_pil (pil_gucu, pil_hucre_sayisi, pil_ozellikleri) VALUES "
                    + "( " + laptopPil.getPil_gucu() + ", " + laptopPil.getPil_hucre_sayisi() + ", '" + laptopPil.getPil_ozellikleri() + "')");
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<laptopPil> findAll() {
        List<laptopPil> pil_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop_pil");
            while (rs.next()) {
                laptopPil tmp = new laptopPil();
                tmp.setPil_id(rs.getLong("pil_id"));
                tmp.setPil_gucu(rs.getInt("pil_gucu"));
                tmp.setPil_hucre_sayisi(rs.getInt("pil_hucre_sayisi"));
                tmp.setPil_ozellikleri(rs.getString("pil_ozellikleri"));
                pil_liste.add(tmp);

            }
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pil_liste;
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
