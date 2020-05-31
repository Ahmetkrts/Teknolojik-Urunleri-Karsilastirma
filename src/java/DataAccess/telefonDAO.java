/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import entity.telefon;
import entity.telefonRenk;
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
public class telefonDAO {

    private Connector connector;
    private Connection connection;
    private telefonBataryaDAO batarya;
    private telefonIslemciDAO islemci;
    private telefonIsletimSistemiDAO isletimsistemi;
    private telefonEkranDAO ekran;
    private telefonArkaKameraDAO arkaKameraDAO;
    private telefonOnKameraDAO onKameraDAO;
    private DosyaDAO dosyaDAO;
    private yorumDAO yorum;

    public yorumDAO getYorum() {
        if (this.yorum == null) {
            this.yorum = new yorumDAO();
        }
        return yorum;
    }

    private telefonRenkDAO renk;

    public List<telefon> findAll(int page, int pageSize, int siralama) {
        String s = (siralama == 1) ? "asc" : "desc";
        List<telefon> telefon_list = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon order by telefon_id " + s + " limit " + start + "," + pageSize);
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
                tmp.setBatarya(this.getBatarya().find(rs.getLong("telefon_batarya_id")));
                tmp.setEkran(this.getEkran().find(rs.getLong("telefon_ekran_id")));
                tmp.setArkaKamera(this.getArkaKameraDAO().find(rs.getLong("arka_kamera_id")));
                tmp.setOnKamera(this.getOnKameraDAO().find(rs.getLong("on_kamera_id")));
                tmp.setIslemci(this.getIslemci().find(rs.getLong("telefon_islemci_id")));
                tmp.setIsletimSistemi(this.getIsletimsistemi().find(rs.getLong("isletim_sistemi_id")));
                tmp.setRenk(this.getRenk().getRenk(tmp.getTelefon_id()));
                tmp.setResim(this.getDosyaDAO().telefonFind(rs.getLong("dosya")));
                tmp.setYorumList(this.getYorum().getYorum(tmp.getTelefon_id(), "telefon"));
                telefon_list.add(tmp);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return telefon_list;
    }

    public telefon find(long id) {
        telefon tmp = new telefon();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from telefon where telefon_id=" + id);
            rs.next();
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
            tmp.setBatarya(this.getBatarya().find(rs.getLong("telefon_batarya_id")));
            tmp.setEkran(this.getEkran().find(rs.getLong("telefon_ekran_id")));
            tmp.setArkaKamera(this.getArkaKameraDAO().find(rs.getLong("arka_kamera_id")));
            tmp.setOnKamera(this.getOnKameraDAO().find(rs.getLong("on_kamera_id")));
            tmp.setIslemci(this.getIslemci().find(rs.getLong("telefon_islemci_id")));
            tmp.setIsletimSistemi(this.getIsletimsistemi().find(rs.getLong("isletim_sistemi_id")));
            tmp.setRenk(this.getRenk().getRenk(tmp.getTelefon_id()));
            tmp.setResim(this.getDosyaDAO().telefonFind(rs.getLong("dosya")));
            tmp.setYorumList(this.getYorum().getYorum(tmp.getTelefon_id(), "telefon"));
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tmp;
    }

    public int countSize() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select count(telefon_id) as telefon_count from telefon");
            rs.next();
            count = rs.getInt("telefon_count");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return count;

    }

    public void insert(telefon telefon) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into telefon (telefon_ad,telefon_marka,telefon_model,telefon_ekran_id,telefon_batarya_id,telefon_islemci_id,arka_kamera_id,on_kamera_id,telefon_ram,telefon_ram_frekansi,telefon_dahili_depolama,telefon_boy,telefon_en,telefon_agirlik,isletim_sistemi_id,dosya) values ("
                    + "'" + telefon.getTelefon_ad() + "','" + telefon.getTelefon_marka() + "','" + telefon.getTelefon_model() + "'," + telefon.getEkran().getEkran_id() + "," + telefon.getBatarya().getBatarya_id() + "," + telefon.getIslemci().getIslemci_id() + ", "
                    + "" + telefon.getArkaKamera().getKamera_id() + "," + telefon.getOnKamera().getKamera_id() + "," + telefon.getTelefon_ram() + "," + telefon.getTelefon_ram_frekansi() + "," + telefon.getTelefon_dahili_depolama() + "," + telefon.getTelefon_boy() + ","
                    + "" + telefon.getTelefon_en() + "," + telefon.getTelefon_agirlik() + "," + telefon.getIsletimSistemi().getIsletim_sistemi_id() + "," + telefon.getResim().getDosya_id() + ")", Statement.RETURN_GENERATED_KEYS);

            Long telefon_id = null;
            ResultSet gk = st.getGeneratedKeys();
            if (gk.next()) {
                telefon_id = gk.getLong(1);
            }
            for (telefonRenk r : telefon.getRenk()) {
                Statement st2 = this.getConnection().createStatement();
                System.out.println("+++++++++++++++++++++++++++++");
                st2.executeUpdate("insert into telefon_renk (telefon_id,renk_id) values (" + telefon_id + "," + r.getRenk_id() + ")");
                System.out.println("/////////////////////////////////////");
            }

            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void edit(telefon telefon) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update telefon set telefon_ad=?,telefon_marka=?,telefon_model=?,telefon_ekran_id=?,telefon_batarya_id=?,telefon_islemci_id=?,arka_kamera_id=?,on_kamera_id=?,telefon_ram=?,telefon_ram_frekansi=?,telefon_dahili_depolama=?,telefon_boy=?,telefon_en=?,telefon_agirlik=?,isletim_sistemi_id=?,dosya=? where telefon_id=?");
            pst.setString(1, telefon.getTelefon_ad());
            pst.setString(2, telefon.getTelefon_marka());
            pst.setString(3, telefon.getTelefon_model());
            pst.setLong(4, telefon.getEkran().getEkran_id());
            pst.setLong(5, telefon.getBatarya().getBatarya_id());
            pst.setLong(6, telefon.getIslemci().getIslemci_id());
            pst.setLong(7, telefon.getArkaKamera().getKamera_id());
            pst.setLong(8, telefon.getOnKamera().getKamera_id());
            pst.setInt(9, telefon.getTelefon_ram());
            pst.setDouble(10, telefon.getTelefon_ram_frekansi());
            pst.setInt(11, telefon.getTelefon_dahili_depolama());
            pst.setInt(12, telefon.getTelefon_boy());
            pst.setDouble(13, telefon.getTelefon_en());
            pst.setInt(14, telefon.getTelefon_agirlik());
            pst.setLong(15, telefon.getIsletimSistemi().getIsletim_sistemi_id());
            pst.setLong(16, telefon.getResim().getDosya_id());
            pst.setLong(17, telefon.getTelefon_id());
            pst.executeUpdate();

            pst = this.getConnection().prepareStatement("delete from telefon_renk where telefon_id=?");
            pst.setLong(1, telefon.getTelefon_id());
            pst.executeUpdate();

            for (telefonRenk r : telefon.getRenk()) {
                Statement st2 = this.getConnection().createStatement();
                System.out.println("+++++++++++++++++++++++++++++");
                st2.executeUpdate("insert into telefon_renk (telefon_id,renk_id) values (" + telefon.getTelefon_id() + "," + r.getRenk_id() + ")");
                System.out.println("/////////////////////////////////////");
            }

            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(telefon telefon) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from telefon_renk where telefon_id=?");
            pst.setLong(1, telefon.getTelefon_id());
            pst.executeUpdate();

            pst = this.getConnection().prepareStatement("delete from telefon where telefon_id=?");
            pst.setLong(1, telefon.getTelefon_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public DosyaDAO getDosyaDAO() {
        if (this.dosyaDAO == null) {
            this.dosyaDAO = new DosyaDAO();
        }
        return dosyaDAO;
    }

    public telefonIsletimSistemiDAO getIsletimsistemi() {
        if (this.isletimsistemi == null) {
            this.isletimsistemi = new telefonIsletimSistemiDAO();
        }
        return isletimsistemi;
    }

    public telefonIslemciDAO getIslemci() {
        if (this.islemci == null) {
            this.islemci = new telefonIslemciDAO();
        }
        return islemci;
    }

    public telefonEkranDAO getEkran() {
        if (this.ekran == null) {
            this.ekran = new telefonEkranDAO();
        }
        return ekran;
    }

    public telefonOnKameraDAO getOnKameraDAO() {
        if (this.onKameraDAO == null) {
            this.onKameraDAO = new telefonOnKameraDAO();
        }
        return onKameraDAO;
    }

    public telefonBataryaDAO getBatarya() {
        if (this.batarya == null) {
            this.batarya = new telefonBataryaDAO();
        }
        return batarya;
    }

    public telefonArkaKameraDAO getArkaKameraDAO() {
        if (this.arkaKameraDAO == null) {
            this.arkaKameraDAO = new telefonArkaKameraDAO();
        }
        return arkaKameraDAO;
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

    public telefonRenkDAO getRenk() {
        if (this.renk == null) {
            this.renk = new telefonRenkDAO();
        }
        return renk;
    }
}
