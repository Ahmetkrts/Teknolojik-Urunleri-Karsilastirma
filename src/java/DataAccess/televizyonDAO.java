/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

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
    private DosyaDAO dosyaDAO;
    private yorumDAO yorum;

    public yorumDAO getYorum() {
        if (this.yorum == null) {
            this.yorum = new yorumDAO();
        }
        return yorum;
    }

    public List<televizyon> findAll(int page, int pageSize, int siralama) {
        String s = (siralama == 1) ? "asc" : "desc";
        List<televizyon> televizyon_list = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from televizyon order by televizyon_id " + s + " limit " + start + "," + pageSize);
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
                tmp.setResim(this.getDosyaDAO().televizyonFind(rs.getLong("dosya")));
                tmp.setYorumList(this.getYorum().getYorum(tmp.getTelevizyon_id(), "televizyon"));
                televizyon_list.add(tmp);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return televizyon_list;
    }

    public televizyon find(long id) {
        televizyon tmp = new televizyon();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from televizyon where televizyon_id=" + id);
            rs.next();
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
            tmp.setResim(this.getDosyaDAO().televizyonFind(rs.getLong("dosya")));
            tmp.setYorumList(this.getYorum().getYorum(tmp.getTelevizyon_id(), "televizyon"));
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
            ResultSet rs = st.executeQuery("select count(televizyon_id) as televizyon_count from televizyon ");
            rs.next();
            count = rs.getInt("televizyon_count");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return count;

    }

    public void insert(televizyon televizyon) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into televizyon (televizyon_ad,televizyon_marka,televizyon_model,televizyon_ekran_id,televizyon_enerji,televizyon_ses_cikis_gucu,televizyon_hoparlor_sistemi,televizyon_dahili_wifi,televizyon_usb_20,televizyon_usb_30,televizyon_genisligi,televizyon_yuksekligi,televizyon_isletim_sistemi,televizyon_yenileme_hizi,televizyon_hd_uydu_alici,dosya) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, televizyon.getTelevizyon_ad());
            pst.setString(2, televizyon.getTelevizyon_marka());
            pst.setString(3, televizyon.getTelevizyon_model());
            pst.setLong(4, televizyon.getEkran().getEkran_id());
            pst.setString(5, televizyon.getTelevizyon_enerji());
            pst.setInt(6, televizyon.getTelevizyon_ses_cikis_gucu());
            pst.setInt(7, televizyon.getTelevizyon_hoparlor_sistemi());
            pst.setString(8, televizyon.getTelevizyon_dahili_wifi());
            pst.setInt(9, televizyon.getTelevizyon_usb_20());
            pst.setInt(10, televizyon.getTelevizyon_usb_30());
            pst.setInt(11, televizyon.getTelevizyon_genisligi());
            pst.setInt(12, televizyon.getTelevizyon_yuksekligi());
            pst.setLong(13, televizyon.getIsletimsistemi().getIsletim_sistemi_id());
            pst.setInt(14, televizyon.getTelevizyon_yenileme_hizi());
            pst.setString(15, televizyon.getTelevizyon_hd_uydu_alici());
            pst.setLong(16, televizyon.getResim().getDosya_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void edit(televizyon televizyon) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update televizyon set televizyon_ad=?,televizyon_marka=?,televizyon_model=?,televizyon_ekran_id=?,televizyon_enerji=?,televizyon_ses_cikis_gucu=?,televizyon_hoparlor_sistemi=?,televizyon_dahili_wifi=?,televizyon_usb_20=?,televizyon_usb_30=?,televizyon_genisligi=?,televizyon_yuksekligi=?,televizyon_isletim_sistemi=?,televizyon_yenileme_hizi=?,televizyon_hd_uydu_alici=?,dosya=? where televizyon_id=?");
            pst.setString(1, televizyon.getTelevizyon_ad());
            pst.setString(2, televizyon.getTelevizyon_marka());
            pst.setString(3, televizyon.getTelevizyon_model());
            pst.setLong(4, televizyon.getEkran().getEkran_id());
            pst.setString(5, televizyon.getTelevizyon_enerji());
            pst.setInt(6, televizyon.getTelevizyon_ses_cikis_gucu());
            pst.setInt(7, televizyon.getTelevizyon_hoparlor_sistemi());
            pst.setString(8, televizyon.getTelevizyon_dahili_wifi());
            pst.setInt(9, televizyon.getTelevizyon_usb_20());
            pst.setInt(10, televizyon.getTelevizyon_usb_30());
            pst.setInt(11, televizyon.getTelevizyon_genisligi());
            pst.setInt(12, televizyon.getTelevizyon_yuksekligi());
            pst.setLong(13, televizyon.getIsletimsistemi().getIsletim_sistemi_id());
            pst.setInt(14, televizyon.getTelevizyon_yenileme_hizi());
            pst.setString(15, televizyon.getTelevizyon_hd_uydu_alici());
            pst.setLong(16, televizyon.getResim().getDosya_id());
            pst.setLong(17, televizyon.getTelevizyon_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(televizyon televizyon) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from televizyon where televizyon_id=?");
            pst.setLong(1, televizyon.getTelevizyon_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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

    public Connection getConnection() throws SQLException {
        this.connection = this.getConnector().Connect();
        return connection;
    }

    public DosyaDAO getDosyaDAO() {
        if (this.dosyaDAO == null) {
            this.dosyaDAO = new DosyaDAO();
        }
        return dosyaDAO;
    }

}
