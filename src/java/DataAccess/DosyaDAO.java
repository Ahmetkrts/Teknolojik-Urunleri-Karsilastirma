/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.Dosya;
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
public class DosyaDAO {

    private Connector connector;
    private Connection connection;

    public void laptopDelete(Dosya dosya) {

        try {

            PreparedStatement pst = this.getConnection().prepareStatement("delete from laptop_resim where dosya_id=?");
            pst.setLong(1, dosya.getDosya_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Dosya laptopFind(Long id) {
        Dosya resim = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop_resim where dosya_id=" + id);
            rs.next();
            resim = new Dosya();
            resim.setDosya_id(rs.getLong("dosya_id"));
            resim.setFilePath(rs.getString("filePath"));
            resim.setFileName(rs.getString("fileName"));
            resim.setFileType(rs.getString("fileType"));
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resim;
    }

    public List<Dosya> laptopFindAll() {
        List<Dosya> dlist = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from laptop_resim");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Dosya d = new Dosya();
                d.setDosya_id(rs.getLong("dosya_id"));
                d.setFilePath(rs.getString("filePath"));
                d.setFileName(rs.getString("fileName"));
                d.setFileType(rs.getString("fileType"));

                dlist.add(d);
            }
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dlist;
    }

    public void laptopInsert(Dosya d) {
        String query = "insert into laptop_resim (filePath,fileName,fileType)values(?,?,?)";
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, d.getFilePath());
            pst.setString(2, d.getFileName());
            pst.setString(3, d.getFileType());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void televizyonDelete(Dosya dosya) {

        try {

            PreparedStatement pst = this.getConnection().prepareStatement("delete from televizyon_resim where dosya_id=?");
            pst.setLong(1, dosya.getDosya_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Dosya televizyonFind(Long id) {
        Dosya resim = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from televizyon_resim where dosya_id=" + id);
            rs.next();
            resim = new Dosya();
            resim.setDosya_id(rs.getLong("dosya_id"));
            resim.setFilePath(rs.getString("filePath"));
            resim.setFileName(rs.getString("fileName"));
            resim.setFileType(rs.getString("fileType"));
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resim;
    }

    public List<Dosya> televizyonFindAll() {
        List<Dosya> dlist = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from televizyon_resim");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Dosya d = new Dosya();
                d.setDosya_id(rs.getLong("dosya_id"));
                d.setFilePath(rs.getString("filePath"));
                d.setFileName(rs.getString("fileName"));
                d.setFileType(rs.getString("fileType"));

                dlist.add(d);
            }
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dlist;
    }

    public void televizyonInsert(Dosya d) {
        String query = "insert into televizyon_resim (filePath,fileName,fileType)values(?,?,?)";
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, d.getFilePath());
            pst.setString(2, d.getFileName());
            pst.setString(3, d.getFileType());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void telefonDelete(Dosya dosya) {

        try {

            PreparedStatement pst = this.getConnection().prepareStatement("delete from telefon_resim where dosya_id=?");
            pst.setLong(1, dosya.getDosya_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Dosya telefonFind(Long id) {
        Dosya resim = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_resim where dosya_id=" + id);
            rs.next();
            resim = new Dosya();
            resim.setDosya_id(rs.getLong("dosya_id"));
            resim.setFilePath(rs.getString("filePath"));
            resim.setFileName(rs.getString("fileName"));
            resim.setFileType(rs.getString("fileType"));
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resim;
    }

    public List<Dosya> telefonFindAll() {
        List<Dosya> dlist = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from telefon_resim");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Dosya d = new Dosya();
                d.setDosya_id(rs.getLong("dosya_id"));
                d.setFilePath(rs.getString("filePath"));
                d.setFileName(rs.getString("fileName"));
                d.setFileType(rs.getString("fileType"));

                dlist.add(d);
            }
            pst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dlist;
    }

    public void telefonInsert(Dosya d) {
        String query = "insert into telefon_resim (filePath,fileName,fileType)values(?,?,?)";
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, d.getFilePath());
            pst.setString(2, d.getFileName());
            pst.setString(3, d.getFileType());
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
