/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.telefonIslemci;
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
public class telefonIslemciDAO {

    private Connector connector;
    private Connection connection;

    public telefonIslemci find(Long id) {
        telefonIslemci islemci = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_islemcileri where islemci_id=" + id);
            rs.next();
            islemci = new telefonIslemci();
            islemci.setIslemci_id(rs.getLong("islemci_id"));
            islemci.setYonga_seti(rs.getString("yonga_seti"));
            islemci.setAna_islemci(rs.getString("ana_islemci"));
            islemci.setCpu_frekansi(rs.getDouble("cpu_frekansi"));
            islemci.setCpu_cekirdegi(rs.getInt("cpu_cekirdegi"));
            islemci.setIslemci_mimarisi(rs.getInt("islemci_mimarisi"));
            islemci.setBirinci_yardimci_islemci(rs.getString("birinci_yardimci_islemci"));
            islemci.setGrafik_islemcisi_gpu(rs.getString("grafik_islemcisi_gpu"));
            islemci.setGpu_frekansi(rs.getInt("gpu_frekansi"));
            islemci.setCpu_uretim_teknolojisi(rs.getInt("cpu_uretim_teknolojisi"));
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return islemci;
    }

    public List<telefonIslemci> findAll(int page, int pageSize, int siralama) {
        String s = (siralama == 1) ? "asc" : "desc";
        int start = (page - 1) * pageSize;

        List<telefonIslemci> islemci_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_islemcileri order by islemci_id " + s + " limit " + start + "," + pageSize);
            while (rs.next()) {
                telefonIslemci tmp = new telefonIslemci();
                tmp.setIslemci_id(rs.getLong("islemci_id"));
                tmp.setYonga_seti(rs.getString("yonga_seti"));
                tmp.setAna_islemci(rs.getString("ana_islemci"));
                tmp.setCpu_frekansi(rs.getDouble("cpu_frekansi"));
                tmp.setCpu_cekirdegi(rs.getInt("cpu_cekirdegi"));
                tmp.setIslemci_mimarisi(rs.getInt("islemci_mimarisi"));
                tmp.setBirinci_yardimci_islemci(rs.getString("birinci_yardimci_islemci"));
                tmp.setGrafik_islemcisi_gpu(rs.getString("grafik_islemcisi_gpu"));
                tmp.setGpu_frekansi(rs.getInt("gpu_frekansi"));
                tmp.setCpu_uretim_teknolojisi(rs.getInt("cpu_uretim_teknolojisi"));
                islemci_liste.add(tmp);

            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return islemci_liste;
    }

    public List<telefonIslemci> findAll() {

        List<telefonIslemci> islemci_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon_islemcileri");
            while (rs.next()) {
                telefonIslemci tmp = new telefonIslemci();
                tmp.setIslemci_id(rs.getLong("islemci_id"));
                tmp.setYonga_seti(rs.getString("yonga_seti"));
                tmp.setAna_islemci(rs.getString("ana_islemci"));
                tmp.setCpu_frekansi(rs.getDouble("cpu_frekansi"));
                tmp.setCpu_cekirdegi(rs.getInt("cpu_cekirdegi"));
                tmp.setIslemci_mimarisi(rs.getInt("islemci_mimarisi"));
                tmp.setBirinci_yardimci_islemci(rs.getString("birinci_yardimci_islemci"));
                tmp.setGrafik_islemcisi_gpu(rs.getString("grafik_islemcisi_gpu"));
                tmp.setGpu_frekansi(rs.getInt("gpu_frekansi"));
                tmp.setCpu_uretim_teknolojisi(rs.getInt("cpu_uretim_teknolojisi"));
                islemci_liste.add(tmp);

            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return islemci_liste;
    }

    public int countSize() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select count(islemci_id) as telefon_islemcileri_count from telefon_islemcileri ");
            rs.next();
            count = rs.getInt("telefon_islemcileri_count");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return count;

    }

    public void edit(telefonIslemci islemci) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update telefon_islemcileri set yonga_seti=?,ana_islemci=?,cpu_frekansi=?,cpu_cekirdegi=?,islemci_mimarisi=?,birinci_yardimci_islemci=?,grafik_islemcisi_gpu=?,gpu_frekansi=?,cpu_uretim_teknolojisi=? where islemci_id=?");
            pst.setString(1, islemci.getYonga_seti());
            pst.setString(2, islemci.getAna_islemci());
            pst.setDouble(3, islemci.getCpu_frekansi());
            pst.setInt(4, islemci.getCpu_cekirdegi());
            pst.setInt(5, islemci.getIslemci_mimarisi());
            pst.setString(6, islemci.getBirinci_yardimci_islemci());
            pst.setString(7, islemci.getGrafik_islemcisi_gpu());
            pst.setInt(8, islemci.getGpu_frekansi());
            pst.setInt(9, islemci.getCpu_uretim_teknolojisi());
            pst.setLong(10, islemci.getIslemci_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(telefonIslemci islemci) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from telefon_islemcileri where islemci_id=?");
            pst.setLong(1, islemci.getIslemci_id());
            pst.executeUpdate();
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

    public void insert(telefonIslemci islemci) {
        try {
            Statement st = getConnection().createStatement();
            st.executeUpdate("insert into telefon_islemcileri (yonga_seti,ana_islemci,cpu_frekansi,cpu_cekirdegi,islemci_mimarisi,birinci_yardimci_islemci,grafik_islemcisi_gpu"
                    + ",gpu_frekansi,cpu_uretim_teknolojisi) values ('" + islemci.getYonga_seti() + "','" + islemci.getAna_islemci() + "'," + islemci.getCpu_frekansi() + ""
                    + "," + islemci.getCpu_cekirdegi() + "," + islemci.getIslemci_mimarisi() + ",'" + islemci.getBirinci_yardimci_islemci() + "','" + islemci.getGrafik_islemcisi_gpu() + "',"
                    + "" + islemci.getGpu_frekansi() + "," + islemci.getCpu_uretim_teknolojisi() + ")");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
