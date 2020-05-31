/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import DataAccess.kullaniciDAO;
import entity.kullanici;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Casper
 */
@Named
@SessionScoped
public class loginController implements Serializable {

    private kullanici loginKullanici;
    private kullanici kullanici;
    private kullaniciDAO kullaniciDAO;
    private List<kullanici> kullaniciList;
    private String hataMesaji = null;

    public String setlog() {
        this.kullanici.setKullanici_adi("admin");
        this.kullanici.setKullanici_sifre("1234");
        login();
        return "/ebadmin/index?faces-redirect=true";
    }

    public String login() {
        int control = 0;
        for (kullanici kul : getKullaniciList()) {
            if (this.kullanici.getKullanici_adi().equals(kul.getKullanici_adi()) && this.kullanici.getKullanici_sifre().equals(kul.getKullanici_sifre())) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_kullanici", kul);
                control = 1;
                loginKullanici = kul;
                this.hataMesaji = null;
                return "/ebadmin/index?faces-redirect=true";
            }
        }
        if (control == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı Kullanıcı Adı ve Şifre Girişi Yaptınız...!"));
            this.hataMesaji = "Hatalı Kullanıcı Adı ve Şifre Girişi Yaptınız...!";
            return "/login?faces-redirect=true";
        }
        return "/login?faces-redirect=true";
    }

    public List<kullanici> getKullaniciList() {
        this.kullaniciList = getKullaniciDAO().findAll();
        return kullaniciList;
    }

    public void setKullaniciList(List<kullanici> kullaniciList) {
        this.kullaniciList = kullaniciList;
    }

    public kullaniciDAO getKullaniciDAO() {
        if (this.kullaniciDAO == null) {
            this.kullaniciDAO = new kullaniciDAO();
        }
        return kullaniciDAO;
    }

    public void setKullaniciDAO(kullaniciDAO kullaniciDAO) {
        this.kullaniciDAO = kullaniciDAO;
    }

    public kullanici getKullanici() {
        if (this.kullanici == null) {
            this.kullanici = new kullanici();
        }
        return kullanici;
    }

    public void setKullanici(kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public kullanici getLoginKullanici() {
        return loginKullanici;
    }

    public void setLoginKullanici(kullanici loginKullanici) {
        this.loginKullanici = loginKullanici;
    }

    public String getHataMesaji() {
        return hataMesaji;
    }

    public void setHataMesaji(String hataMesaji) {
        this.hataMesaji = hataMesaji;
    }

}
