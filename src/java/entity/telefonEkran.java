/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author techn
 */
public class telefonEkran {
    private Long ekran_id;
    private double ekran_boyutu;
    private String ekran_teknolojisi;
    private String ekran_cozunurlugu;
    private int piksel_yogunlugu; 
    private String ekran_dayanikliligi;

    public Long getEkran_id() {
        return ekran_id;
    }

    public void setEkran_id(Long ekran_id) {
        this.ekran_id = ekran_id;
    }

    public Double getEkran_boyutu() {
        return ekran_boyutu;
    }

    public void setEkran_boyutu(Double ekran_boyutu) {
        this.ekran_boyutu = ekran_boyutu;
    }

    public String getEkran_teknolojisi() {
        return ekran_teknolojisi;
    }

    public void setEkran_teknolojisi(String ekran_teknolojisi) {
        this.ekran_teknolojisi = ekran_teknolojisi;
    }

    public String getEkran_cozunurlugu() {
        return ekran_cozunurlugu;
    }

    public void setEkran_cozunurlugu(String ekran_cozunurlugu) {
        this.ekran_cozunurlugu = ekran_cozunurlugu;
    }

    public int getPiksel_yogunlugu() {
        return piksel_yogunlugu;
    }

    public void setPiksel_yogunlugu(int piksel_yogunlugu) {
        this.piksel_yogunlugu = piksel_yogunlugu;
    }

    public String getEkran_dayanikliligi() {
        return ekran_dayanikliligi;
    }

    public void setEkran_dayanikliligi(String ekran_dayanikliligi) {
        this.ekran_dayanikliligi = ekran_dayanikliligi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.ekran_id);
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
        final telefonEkran other = (telefonEkran) obj;
        if (!Objects.equals(this.ekran_id, other.ekran_id)) {
            return false;
        }
        return true;
    }

    
    
}
