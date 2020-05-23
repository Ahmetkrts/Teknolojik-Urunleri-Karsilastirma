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
public class laptopIslemci {
    private Long islemci_id;
    private String islemci_marka;
    private  String islemci_serisi;
    private String islemci_modeli;
    private Double islemci_temel_frekansi;
    private int cekirdek_sayisi;
    private int sanal_cekirdek_sayisi;
    private int on_bellek;
    private int uretim_teknolojisi;
    private int tdp_degeri;

    public Long getIslemci_id() {
        return islemci_id;
    }

    public void setIslemci_id(Long islemci_id) {
        this.islemci_id = islemci_id;
    }

    public String getIslemci_marka() {
        return islemci_marka;
    }

    public void setIslemci_marka(String islemci_marka) {
        this.islemci_marka = islemci_marka;
    }

    public String getIslemci_serisi() {
        return islemci_serisi;
    }

    public void setIslemci_serisi(String islemci_serisi) {
        this.islemci_serisi = islemci_serisi;
    }

    public String getIslemci_modeli() {
        return islemci_modeli;
    }

    public void setIslemci_modeli(String islemci_modeli) {
        this.islemci_modeli = islemci_modeli;
    }

    public Double getIslemci_temel_frekansi() {
        return islemci_temel_frekansi;
    }

    public void setIslemci_temel_frekansi(Double islemci_temel_frekansi) {
        this.islemci_temel_frekansi = islemci_temel_frekansi;
    }

    public int getCekirdek_sayisi() {
        return cekirdek_sayisi;
    }

    public void setCekirdek_sayisi(int cekirdek_sayisi) {
        this.cekirdek_sayisi = cekirdek_sayisi;
    }

    public int getSanal_cekirdek_sayisi() {
        return sanal_cekirdek_sayisi;
    }

    public void setSanal_cekirdek_sayisi(int sanal_cekirdek_sayisi) {
        this.sanal_cekirdek_sayisi = sanal_cekirdek_sayisi;
    }

    public int getOn_bellek() {
        return on_bellek;
    }

    public void setOn_bellek(int on_bellek) {
        this.on_bellek = on_bellek;
    }

    public int getUretim_teknolojisi() {
        return uretim_teknolojisi;
    }

    public void setUretim_teknolojisi(int uretim_teknolojisi) {
        this.uretim_teknolojisi = uretim_teknolojisi;
    }

    public int getTdp_degeri() {
        return tdp_degeri;
    }

    public void setTdp_degeri(int tdp_degeri) {
        this.tdp_degeri = tdp_degeri;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.islemci_id);
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
        final laptopIslemci other = (laptopIslemci) obj;
        if (!Objects.equals(this.islemci_id, other.islemci_id)) {
            return false;
        }
        return true;
    }
            
            
}
