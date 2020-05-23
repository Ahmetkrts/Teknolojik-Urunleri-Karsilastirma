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
public class laptopEkran {
    private Long ekran_id;
    private Double ekran_boyutu;
    private String ekran_cozunurlugu;
    private int ekran_yenileme;

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

    public String getEkran_cozunurlugu() {
        return ekran_cozunurlugu;
    }

    public void setEkran_cozunurlugu(String ekran_cozunurlugu) {
        this.ekran_cozunurlugu = ekran_cozunurlugu;
    }

    public int getEkran_yenileme() {
        return ekran_yenileme;
    }

    public void setEkran_yenileme(int ekran_yenileme) {
        this.ekran_yenileme = ekran_yenileme;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.ekran_id);
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
        final laptopEkran other = (laptopEkran) obj;
        if (!Objects.equals(this.ekran_id, other.ekran_id)) {
            return false;
        }
        return true;
    }

    
}
