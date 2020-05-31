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
public class telefonIslemci {
    private Long islemci_id;
    private String yonga_seti;
    private String ana_islemci;
    private double  cpu_frekansi;
    private int cpu_cekirdegi;
    private int islemci_mimarisi;
    private String  birinci_yardimci_islemci;
    private String  grafik_islemcisi_gpu;
    private int gpu_frekansi;
    private int cpu_uretim_teknolojisi;

    public Long getIslemci_id() {
        return islemci_id;
    }

    public void setIslemci_id(Long islemci_id) {
        this.islemci_id = islemci_id;
    }

    public String getYonga_seti() {
        return yonga_seti;
    }

    public void setYonga_seti(String yonga_seti) {
        this.yonga_seti = yonga_seti;
    }

    public String getAna_islemci() {
        return ana_islemci;
    }

    public void setAna_islemci(String ana_islemci) {
        this.ana_islemci = ana_islemci;
    }

    public Double getCpu_frekansi() {
        return cpu_frekansi;
    }

    public void setCpu_frekansi(Double cpu_frekansi) {
        this.cpu_frekansi = cpu_frekansi;
    }

    public int getCpu_cekirdegi() {
        return cpu_cekirdegi;
    }

    public void setCpu_cekirdegi(int cpu_cekirdegi) {
        this.cpu_cekirdegi = cpu_cekirdegi;
    }

    public int getIslemci_mimarisi() {
        return islemci_mimarisi;
    }

    public void setIslemci_mimarisi(int islemci_mimarisi) {
        this.islemci_mimarisi = islemci_mimarisi;
    }

    public String getBirinci_yardimci_islemci() {
        return birinci_yardimci_islemci;
    }

    public void setBirinci_yardimci_islemci(String birinci_yardimci_islemci) {
        this.birinci_yardimci_islemci = birinci_yardimci_islemci;
    }

    public String getGrafik_islemcisi_gpu() {
        return grafik_islemcisi_gpu;
    }

    public void setGrafik_islemcisi_gpu(String grafik_islemcisi_gpu) {
        this.grafik_islemcisi_gpu = grafik_islemcisi_gpu;
    }

    public int getGpu_frekansi() {
        return gpu_frekansi;
    }

    public void setGpu_frekansi(int gpu_frekansi) {
        this.gpu_frekansi = gpu_frekansi;
    }

    public int getCpu_uretim_teknolojisi() {
        return cpu_uretim_teknolojisi;
    }

    public void setCpu_uretim_teknolojisi(int cpu_uretim_teknolojisi) {
        this.cpu_uretim_teknolojisi = cpu_uretim_teknolojisi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.islemci_id);
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
        final telefonIslemci other = (telefonIslemci) obj;
        if (!Objects.equals(this.islemci_id, other.islemci_id)) {
            return false;
        }
        return true;
    }
    
    
}
