/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 *
 * 
 * @author techn
 */
public class telefonBatarya {
    private Long batarya_id;
    private int batarya_kapasitesi;
    private String batarya_teknolojisi;
    private String hizli_sarj_ozelligi;

    public telefonBatarya() {
    }

    public Long getBatarya_id() {
        return batarya_id;
    }

    public void setBatarya_id(Long batarya_id) {
        this.batarya_id = batarya_id;
    }

    public int getBatarya_kapasitesi() {
        return batarya_kapasitesi;
    }

    public void setBatarya_kapasitesi(int batarya_kapasitesi) {
        this.batarya_kapasitesi = batarya_kapasitesi;
    }

    public String getBatarya_teknolojisi() {
        return batarya_teknolojisi;
    }

    public void setBatarya_teknolojisi(String batarya_teknolojisi) {
        this.batarya_teknolojisi = batarya_teknolojisi;
    }

    public String getHizli_sarj_ozelligi() {
        return hizli_sarj_ozelligi;
    }

    public void setHizli_sarj_ozelligi(String hizli_sarj_ozelligi) {
        this.hizli_sarj_ozelligi = hizli_sarj_ozelligi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.batarya_id);
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
        final telefonBatarya other = (telefonBatarya) obj;
        if (!Objects.equals(this.batarya_id, other.batarya_id)) {
            return false;
        }
        return true;
    }
    
}
