/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Casper
 */
public class laptopEkranKarti {

    private Long ekran_karti_id;
    private String ekran_karti_marka;
    private String ekran_karti_serisi;
    private String ekran_karti_modeli;
    private double ekran_karti_cekirdek_hizi;
    private int ekran_karti_bellek_boyutu;
    private String ekran_karti_bellek_turu;
    private int ekran_karti_bellek_arayuzu;

    public Long getEkran_karti_id() {
        return ekran_karti_id;
    }

    public void setEkran_karti_id(Long ekran_karti_id) {
        this.ekran_karti_id = ekran_karti_id;
    }

    public String getEkran_karti_marka() {
        return ekran_karti_marka;
    }

    public void setEkran_karti_marka(String ekran_karti_marka) {
        this.ekran_karti_marka = ekran_karti_marka;
    }

    public String getEkran_karti_serisi() {
        return ekran_karti_serisi;
    }

    public void setEkran_karti_serisi(String ekran_karti_serisi) {
        this.ekran_karti_serisi = ekran_karti_serisi;
    }

    public String getEkran_karti_modeli() {
        return ekran_karti_modeli;
    }

    public void setEkran_karti_modeli(String ekran_karti_modeli) {
        this.ekran_karti_modeli = ekran_karti_modeli;
    }

    public Double getEkran_karti_cekirdek_hizi() {
        return ekran_karti_cekirdek_hizi;
    }

    public void setEkran_karti_cekirdek_hizi(Double ekran_karti_cekirdek_hizi) {
        this.ekran_karti_cekirdek_hizi = ekran_karti_cekirdek_hizi;
    }

    public int getEkran_karti_bellek_boyutu() {
        return ekran_karti_bellek_boyutu;
    }

    public void setEkran_karti_bellek_boyutu(int ekran_karti_bellek_boyutu) {
        this.ekran_karti_bellek_boyutu = ekran_karti_bellek_boyutu;
    }

    public String getEkran_karti_bellek_turu() {
        return ekran_karti_bellek_turu;
    }

    public void setEkran_karti_bellek_turu(String ekran_karti_bellek_turu) {
        this.ekran_karti_bellek_turu = ekran_karti_bellek_turu;
    }

    public int getEkran_karti_bellek_arayuzu() {
        return ekran_karti_bellek_arayuzu;
    }

    public void setEkran_karti_bellek_arayuzu(int ekran_karti_bellek_arayuzu) {
        this.ekran_karti_bellek_arayuzu = ekran_karti_bellek_arayuzu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.ekran_karti_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final laptopEkranKarti other = (laptopEkranKarti) obj;
        if (!Objects.equals(this.ekran_karti_id, other.ekran_karti_id)) {
            return false;
        }
        return true;
    }

}
