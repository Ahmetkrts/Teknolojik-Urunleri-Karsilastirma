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
public class telefonIslemci {
    private Long islemci_id;
    private String yonga_seti;
    private String ana_islemci;
    private Double  cpu_frekansi;
    private int cpu_cekirdegi;
    private int islmeci_mimarisi;
    private String  birinci_yardimci_islemci;
    private String  grafik_islmecisi_gpu;
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

    public int getIslmeci_mimarisi() {
        return islmeci_mimarisi;
    }

    public void setIslmeci_mimarisi(int islmeci_mimarisi) {
        this.islmeci_mimarisi = islmeci_mimarisi;
    }

    public String getBirinci_yardimci_islemci() {
        return birinci_yardimci_islemci;
    }

    public void setBirinci_yardimci_islemci(String birinci_yardimci_islemci) {
        this.birinci_yardimci_islemci = birinci_yardimci_islemci;
    }

    public String getGrafik_islmecisi_gpu() {
        return grafik_islmecisi_gpu;
    }

    public void setGrafik_islmecisi_gpu(String grafik_islmecisi_gpu) {
        this.grafik_islmecisi_gpu = grafik_islmecisi_gpu;
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
    
    
}
