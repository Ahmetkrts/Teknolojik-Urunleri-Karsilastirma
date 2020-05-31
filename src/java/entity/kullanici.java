/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Casper
 */
public class kullanici {

    private Long kullanici_id;
    private String kullanici_adSoyad;
    private String kullanici_adi;
    private String kullanici_sifre;

    @Override
    public String toString() {
        return "kullanici{" + "kullanici_id=" + kullanici_id + ", kullanici_adSoyad=" + kullanici_adSoyad + ", kullanici_adi=" + kullanici_adi + ", kullanici_sifre=" + kullanici_sifre + '}';
    }

    public Long getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(Long kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getKullanici_adSoyad() {
        return kullanici_adSoyad;
    }

    public void setKullanici_adSoyad(String kullanici_adSoyad) {
        this.kullanici_adSoyad = kullanici_adSoyad;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getKullanici_sifre() {
        return kullanici_sifre;
    }

    public void setKullanici_sifre(String kullanici_sifre) {
        this.kullanici_sifre = kullanici_sifre;
    }

}
