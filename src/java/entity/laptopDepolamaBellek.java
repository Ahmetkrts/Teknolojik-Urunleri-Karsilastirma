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
public class laptopDepolamaBellek {

    private Long depolama_bellek_id;
    private int bellek_boyutu;
    private int bellek_frekansi;
    private int sabit_disk_boyutu;
    private int sabit_disk_yazma_hizi;
    private int ssd_boyutu;
    private String ssd_tipi;

    public Long getDepolama_bellek_id() {
        return depolama_bellek_id;
    }

    public void setDepolama_bellek_id(Long depolama_bellek_id) {
        this.depolama_bellek_id = depolama_bellek_id;
    }

    public int getBellek_boyutu() {
        return bellek_boyutu;
    }

    public void setBellek_boyutu(int bellek_boyutu) {
        this.bellek_boyutu = bellek_boyutu;
    }

    public int getBellek_frekansi() {
        return bellek_frekansi;
    }

    public void setBellek_frekansi(int bellek_frekansi) {
        this.bellek_frekansi = bellek_frekansi;
    }

    public int getSabit_disk_boyutu() {
        return sabit_disk_boyutu;
    }

    public void setSabit_disk_boyutu(int sabit_disk_boyutu) {
        this.sabit_disk_boyutu = sabit_disk_boyutu;
    }

    public int getSabit_disk_yazma_hizi() {
        return sabit_disk_yazma_hizi;
    }

    public void setSabit_disk_yazma_hizi(int sabit_disk_yazma_hizi) {
        this.sabit_disk_yazma_hizi = sabit_disk_yazma_hizi;
    }

    public int getSsd_boyutu() {
        return ssd_boyutu;
    }

    public void setSsd_boyutu(int ssd_boyutu) {
        this.ssd_boyutu = ssd_boyutu;
    }

    public String getSsd_tipi() {
        return ssd_tipi;
    }

    public void setSsd_tipi(String ssd_tipi) {
        this.ssd_tipi = ssd_tipi;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.depolama_bellek_id);
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
        final laptopDepolamaBellek other = (laptopDepolamaBellek) obj;
        if (!Objects.equals(this.depolama_bellek_id, other.depolama_bellek_id)) {
            return false;
        }
        return true;
    }

    
}
