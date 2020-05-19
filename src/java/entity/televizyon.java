/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author techn
 */
public class televizyon {
    private Long televizyon_id;
    private String televizyon_ad;
    private String televizyon_marka;
    private String televizyon_model;
    private String televizyon_enerji;
    private int televizyon_ses_cikis_gucu;
    private int televizyon_hoparlor_sistemi;
    private String televizyon_dahili_wifi;
    private int televizyon_usb_20;
    private int televizyon_usb_30;
    private int televizyon_genisligi;
    private int televizyon_yuksekligi;
    private int televizyon_yenileme_hizi;
    private String televizyon_hd_uydu_alici;
    private televizyonEkran ekran;
    private televizyonIslettimSistemi isletimsistemi;
    

    public Long getTelevizyon_id() {
        return televizyon_id;
    }

    public void setTelevizyon_id(Long televizyon_id) {
        this.televizyon_id = televizyon_id;
    }

    public String getTelevizyon_ad() {
        return televizyon_ad;
    }

    public void setTelevizyon_ad(String televizyon_ad) {
        this.televizyon_ad = televizyon_ad;
    }

    public String getTelevizyon_marka() {
        return televizyon_marka;
    }

    public void setTelevizyon_marka(String televizyon_marka) {
        this.televizyon_marka = televizyon_marka;
    }

    public String getTelevizyon_model() {
        return televizyon_model;
    }

    public void setTelevizyon_model(String televizyon_model) {
        this.televizyon_model = televizyon_model;
    }


    public String getTelevizyon_enerji() {
        return televizyon_enerji;
    }

    public void setTelevizyon_enerji(String televizyon_enerji) {
        this.televizyon_enerji = televizyon_enerji;
    }

    public int getTelevizyon_ses_cikis_gucu() {
        return televizyon_ses_cikis_gucu;
    }

    public void setTelevizyon_ses_cikis_gucu(int televizyon_ses_cikis_gucu) {
        this.televizyon_ses_cikis_gucu = televizyon_ses_cikis_gucu;
    }

    public int getTelevizyon_hoparlor_sistemi() {
        return televizyon_hoparlor_sistemi;
    }

    public void setTelevizyon_hoparlor_sistemi(int televizyon_hoparlor_sistemi) {
        this.televizyon_hoparlor_sistemi = televizyon_hoparlor_sistemi;
    }

    public String getTelevizyon_dahili_wifi() {
        return televizyon_dahili_wifi;
    }

    public void setTelevizyon_dahili_wifi(String televizyon_dahili_wifi) {
        this.televizyon_dahili_wifi = televizyon_dahili_wifi;
    }

    public int getTelevizyon_usb_20() {
        return televizyon_usb_20;
    }

    public void setTelevizyon_usb_20(int televizyon_usb_20) {
        this.televizyon_usb_20 = televizyon_usb_20;
    }

    public int getTelevizyon_usb_30() {
        return televizyon_usb_30;
    }

    public void setTelevizyon_usb_30(int televizyon_usb_30) {
        this.televizyon_usb_30 = televizyon_usb_30;
    }

    public int getTelevizyon_genisligi() {
        return televizyon_genisligi;
    }

    public void setTelevizyon_genisligi(int televizyon_genisligi) {
        this.televizyon_genisligi = televizyon_genisligi;
    }

    public int getTelevizyon_yuksekligi() {
        return televizyon_yuksekligi;
    }

    public void setTelevizyon_yuksekligi(int televizyon_yuksekligi) {
        this.televizyon_yuksekligi = televizyon_yuksekligi;
    }


    public int getTelevizyon_yenileme_hizi() {
        return televizyon_yenileme_hizi;
    }

    public void setTelevizyon_yenileme_hizi(int televizyon_yenileme_hizi) {
        this.televizyon_yenileme_hizi = televizyon_yenileme_hizi;
    }

    public String getTelevizyon_hd_uydu_alici() {
        return televizyon_hd_uydu_alici;
    }

    public void setTelevizyon_hd_uydu_alici(String televizyon_hd_uydu_alici) {
        this.televizyon_hd_uydu_alici = televizyon_hd_uydu_alici;
    }

    public televizyonEkran getEkran() {
        return ekran;
    }

    public void setEkran(televizyonEkran ekran) {
        this.ekran = ekran;
    }

    public televizyonIslettimSistemi getIsletimsistemi() {
        return isletimsistemi;
    }

    public void setIsletimsistemi(televizyonIslettimSistemi isletimsistemi) {
        this.isletimsistemi = isletimsistemi;
    }
    
    
}
