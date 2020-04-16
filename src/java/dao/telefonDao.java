/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.telefon;
import java.sql.Connection;
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
public class telefonDao {

    private Connector connector;
    private Connection connection;
    private telefonBataryaDao batarya;
    private telefonEkranDao ekran;
    private telefonIslemciDao islemci;
    private telefonIsletimSistemiDao isletimsistemi;
    private telefonKameraDao kamera;

    public List<telefon> findAll() {
        List<telefon> telefon_list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon");
            while (rs.next()) {
                telefon tmp = new telefon();
                tmp.setTelefon_id(rs.getLong("telefon_id"));
                tmp.setTelefon_ad(rs.getString("telefon_ad"));
                tmp.setTelefon_marka(rs.getString("telefon_marka"));
                tmp.setTelefon_model(rs.getString("telefon_model"));
                tmp.setTelefon_ram(rs.getInt("telefon_ram"));
                tmp.setTelefon_ram_frekansi(rs.getDouble("telefon_ram_frekansi"));
                tmp.setTelefon_dahili_depolama(rs.getInt("telefon_dahili_depolama"));
                tmp.setTelefon_boy(rs.getInt("telefon_boy"));
                tmp.setTelefon_en(rs.getDouble("telefon_en"));
                tmp.setTelefon_agirlik(rs.getInt("telefon_agirlik"));
                tmp.setTelefon_renk(rs.getString("telefon_renk"));
                tmp.setBatarya(getBatarya().find(rs.getLong("telefon_batarya_id")));
                tmp.setEkran(this.getEkran().find(rs.getLong("telefon_ekran_id")));
                tmp.setIslemci(this.getIslemci().find(rs.getLong("telefon_islemci_id")));
                tmp.setIsletimSistemi(this.getIsletimsistemi().find(rs.getLong("isletim_sistemi_id")));
                tmp.setKamera(this.getKamera().getkamera(tmp.getTelefon_id()));
                telefon_list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return telefon_list;
    }

    public telefonIsletimSistemiDao getIsletimsistemi() {
        if(this.isletimsistemi == null){
            this.isletimsistemi = new telefonIsletimSistemiDao(); 
        }
        return isletimsistemi;
    }

    public telefonIslemciDao getIslemci() {
        if(this.islemci == null){
            this.islemci = new telefonIslemciDao();
        }
        return islemci;
    }

    public telefonEkranDao getEkran() {
        if (this.ekran == null) {
            this.ekran = new telefonEkranDao();
        }
        return ekran;
    }

    public telefonBataryaDao getBatarya() {
        if (this.batarya == null) {
            this.batarya = new telefonBataryaDao();
        }
        return batarya;
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

    public telefonKameraDao getKamera() {
        if(this.kamera == null){
            this.kamera = new telefonKameraDao();
        }
        return kamera;
    }
    

}
