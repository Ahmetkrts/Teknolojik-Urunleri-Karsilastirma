/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.laptopDepolamaBellek;
import entity.laptopPil;
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
public class laptopPilDAO {

    private Connector connector;
    private Connection connection;

    public void remove(laptopPil pil) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from laptop_pil where pil_id=?");
            pst.setLong(1, pil.getPil_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void edit(laptopPil laptopPil) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update laptop_pil set pil_gucu=?,pil_hucre_sayisi=?,pil_ozellikleri=? where pil_id=?");
            pst.setInt(1, laptopPil.getPil_gucu());
            pst.setInt(2, laptopPil.getPil_hucre_sayisi());
            pst.setString(3, laptopPil.getPil_ozellikleri());
            pst.setLong(4, laptopPil.getPil_id());
            pst.executeUpdate();
            getConnection().close();

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

    public laptopPil find(Long id) {
        laptopPil pil = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop_pil where pil_id=" + id);
            rs.next();
            pil = new laptopPil();
            pil.setPil_id(rs.getLong("pil_id"));
            pil.setPil_gucu(rs.getInt("pil_gucu"));
            pil.setPil_hucre_sayisi(rs.getInt("pil_hucre_sayisi"));
            pil.setPil_ozellikleri(rs.getString("pil_ozellikleri"));
            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pil;
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

    public Connection getConnection() throws SQLException {
        this.connection = this.getConnector().Connect();
        return connection;
    }

}
