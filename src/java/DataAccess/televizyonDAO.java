/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.televizyon;
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
public class televizyonDAO {

    private Connector connector;
    private Connection connection;
    private televizyonEkranDAO ekranDAO;
    private televizyonIslettimSistemiDAO islettimSistemiDAO;

    public List<televizyon> findAll() {
        List<televizyon> televizyon_list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from televizyon");
            while (rs.next()) {
                televizyon tmp = new televizyon();
                tmp.setTelevizyon_id(rs.getLong("televizyon_id"));
                tmp.setTelevizyon_ad(rs.getString("televizyon_ad"));
                tmp.setTelevizyon_marka(rs.getString("televizyon_marka"));
                tmp.setTelevizyon_model(rs.getString("televizyon_model"));
                tmp.setEkran(this.getEkranDAO().find(rs.getLong("televizyon_ekran_id")));
                tmp.setIsletimsistemi(this.getIslettimSistemiDAO().find(rs.getLong("televizyon_isletim_sistemi")));
                tmp.setTelevizyon_enerji(rs.getString("televizyon_enerji"));
                tmp.setTelevizyon_ses_cikis_gucu(rs.getInt("televizyon_ses_cikis_gucu"));
                tmp.setTelevizyon_hoparlor_sistemi(rs.getInt("televizyon_hoparlor_sistemi"));
                tmp.setTelevizyon_dahili_wifi(rs.getString("televizyon_dahili_wifi"));
                tmp.setTelevizyon_usb_20(rs.getInt("televizyon_usb_20"));
                tmp.setTelevizyon_usb_30(rs.getInt("televizyon_usb_30"));
                tmp.setTelevizyon_genisligi(rs.getInt("televizyon_genisligi"));
                tmp.setTelevizyon_yuksekligi(rs.getInt("televizyon_yuksekligi"));
                tmp.setTelevizyon_yenileme_hizi(rs.getInt("televizyon_yenileme_hizi"));
                tmp.setTelevizyon_hd_uydu_alici(rs.getString("televizyon_hd_uydu_alici"));
                televizyon_list.add(tmp);
            }
            getConnection().close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return televizyon_list;
    }


    public televizyonEkranDAO getEkranDAO() {
        if (this.ekranDAO == null) {
            this.ekranDAO = new televizyonEkranDAO();
        }
        return ekranDAO;
    }

    public televizyonIslettimSistemiDAO getIslettimSistemiDAO() {
        if (this.islettimSistemiDAO == null) {
            this.islettimSistemiDAO = new televizyonIslettimSistemiDAO();
        }
        return islettimSistemiDAO;
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
