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
public class yorum {

    private Long yorum_id;
    private String yorum_icerik;
    private String yorum_adSoyad;
    private String yorum_tarihi;

    @Override
    public String toString() {
        return "yorum{" + "yorum_icerik=" + yorum_icerik + ", yorum_adSoyad=" + yorum_adSoyad + ", yorum_tarihi=" + yorum_tarihi + '}';
    }

    public Long getYorum_id() {
        return yorum_id;
    }

    public void setYorum_id(Long yorum_id) {
        this.yorum_id = yorum_id;
    }

    public String getYorum_icerik() {
        return yorum_icerik;
    }

    public void setYorum_icerik(String yorum_icerik) {
        this.yorum_icerik = yorum_icerik;
    }

    public String getYorum_adSoyad() {
        return yorum_adSoyad;
    }

    public void setYorum_adSoyad(String yorum_adSoyad) {
        this.yorum_adSoyad = yorum_adSoyad;
    }

    public String getYorum_tarihi() {
        return yorum_tarihi;
    }

    public void setYorum_tarihi(String yorum_tarihi) {
        this.yorum_tarihi = yorum_tarihi;
    }

}
