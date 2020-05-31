/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author Casper
 */
public class laptop {

    private Long laptop_id;
    private String urun_adi;
    private String urun_tipi;
    private String urun_amaci;
    private String urun_ailesi;
    private String urun_serisi;
    private String isletim_sistemi;
    private laptopEkran ekran;
    private Double genislik;
    private Double derinlik;
    private Double kalinlik;
    private Double agirlik;
    private laptopDepolamaBellek depolama_bellek;
    private laptopIslemci islemci;
    private laptopEkranKarti ekran_karti;
    private laptopPil pil;
    private laptopBaglanti baglanti;
    private Dosya resim;
    private List<yorum> yorumList;

    public List<yorum> getYorumList() {
        return yorumList;
    }

    public void setYorumList(List<yorum> yorumList) {
        this.yorumList = yorumList;
    }

    public Long getLaptop_id() {
        return laptop_id;
    }

    public void setLaptop_id(Long laptop_id) {
        this.laptop_id = laptop_id;
    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public String getUrun_tipi() {
        return urun_tipi;
    }

    public void setUrun_tipi(String urun_tipi) {
        this.urun_tipi = urun_tipi;
    }

    public String getUrun_amaci() {
        return urun_amaci;
    }

    public void setUrun_amaci(String urun_amaci) {
        this.urun_amaci = urun_amaci;
    }

    public String getUrun_ailesi() {
        return urun_ailesi;
    }

    public void setUrun_ailesi(String urun_ailesi) {
        this.urun_ailesi = urun_ailesi;
    }

    public String getUrun_serisi() {
        return urun_serisi;
    }

    public void setUrun_serisi(String urun_serisi) {
        this.urun_serisi = urun_serisi;
    }

    public String getIsletim_sistemi() {
        return isletim_sistemi;
    }

    public void setIsletim_sistemi(String isletim_sistemi) {
        this.isletim_sistemi = isletim_sistemi;
    }

    public laptopEkran getEkran() {
        return ekran;
    }

    public void setEkran(laptopEkran ekran) {
        this.ekran = ekran;
    }

    public Double getGenislik() {
        return genislik;
    }

    public void setGenislik(Double genislik) {
        this.genislik = genislik;
    }

    public Double getDerinlik() {
        return derinlik;
    }

    public void setDerinlik(Double derinlik) {
        this.derinlik = derinlik;
    }

    public Double getKalinlik() {
        return kalinlik;
    }

    public void setKalinlik(Double kalinlik) {
        this.kalinlik = kalinlik;
    }

    public Double getAgirlik() {
        return agirlik;
    }

    public void setAgirlik(Double agirlik) {
        this.agirlik = agirlik;
    }

    public laptopDepolamaBellek getDepolama_bellek() {
        return depolama_bellek;
    }

    public void setDepolama_bellek(laptopDepolamaBellek depolama_bellek) {
        this.depolama_bellek = depolama_bellek;
    }

    public laptopIslemci getIslemci() {
        return islemci;
    }

    public void setIslemci(laptopIslemci islemci) {
        this.islemci = islemci;
    }

    public laptopEkranKarti getEkran_karti() {
        return ekran_karti;
    }

    public void setEkran_karti(laptopEkranKarti ekran_karti) {
        this.ekran_karti = ekran_karti;
    }

    public laptopPil getPil() {
        return pil;
    }

    public void setPil(laptopPil pil) {
        this.pil = pil;
    }

    public laptopBaglanti getBaglanti() {
        return baglanti;
    }

    public void setBaglanti(laptopBaglanti baglanti) {
        this.baglanti = baglanti;
    }

    public Dosya getResim() {
        return resim;
    }

    public void setResim(Dosya resim) {
        this.resim = resim;
    }

}
