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
public class televizyonEkran {
    private Long ekran_id;
    private String ekran_turu;
    private String ekran_tipi;
    private int ekran_boyutu;
    private String ekran_cozunurlugu;
    private String HDR;

    public Long getEkran_id() {
        return ekran_id;
    }

    public void setEkran_id(Long ekran_id) {
        this.ekran_id = ekran_id;
    }

    public String getEkran_turu() {
        return ekran_turu;
    }

    public void setEkran_turu(String ekran_turu) {
        this.ekran_turu = ekran_turu;
    }

    public String getEkran_tipi() {
        return ekran_tipi;
    }

    public void setEkran_tipi(String ekran_tipi) {
        this.ekran_tipi = ekran_tipi;
    }

    public int getEkran_boyutu() {
        return ekran_boyutu;
    }

    public void setEkran_boyutu(int ekran_boyutu) {
        this.ekran_boyutu = ekran_boyutu;
    }

    public String getEkran_cozunurlugu() {
        return ekran_cozunurlugu;
    }

    public void setEkran_cozunurlugu(String ekran_cozunurlugu) {
        this.ekran_cozunurlugu = ekran_cozunurlugu;
    }

    public String getHDR() {
        return HDR;
    }

    public void setHDR(String HDR) {
        this.HDR = HDR;
    }
    
    
}
