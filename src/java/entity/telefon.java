/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author techn
 */
public class telefon {

    private Long telefon_id;
    private String telefon_ad;
    private String telefon_marka;
    private String telefon_model;
    private int telefon_ram;
    private Double telefon_ram_frekansi;
    private int telefon_dahili_depolama;
    private int telefon_boy;
    private Double telefon_en;
    private int telefon_agirlik;
    private List<telefonRenk> renk;
    private telefonBatarya batarya;
    private telefonIslemci islemci;
    private telefonIsletimSistemi isletimSistemi;
    private telefonArkaKamera arkaKamera;
    private telefonOnKamera onKamera;
    private telefonEkran ekran;
    private Dosya resim;
    private List<yorum> yorumList;

    public List<yorum> getYorumList() {
        return yorumList;
    }

    public void setYorumList(List<yorum> yorumList) {
        this.yorumList = yorumList;
    }

    public telefon() {
    }

    public telefonArkaKamera getArkaKamera() {
        return arkaKamera;
    }

    public void setArkaKamera(telefonArkaKamera arkaKamera) {
        this.arkaKamera = arkaKamera;
    }

    public telefonOnKamera getOnKamera() {
        return onKamera;
    }

    public void setOnKamera(telefonOnKamera onKamera) {
        this.onKamera = onKamera;
    }

    public telefonEkran getEkran() {
        return ekran;
    }

    public void setEkran(telefonEkran ekran) {
        this.ekran = ekran;
    }

    public telefonIsletimSistemi getIsletimSistemi() {
        return isletimSistemi;
    }

    public void setIsletimSistemi(telefonIsletimSistemi isletimSistemi) {
        this.isletimSistemi = isletimSistemi;
    }

    public telefonIslemci getIslemci() {
        return islemci;
    }

    public void setIslemci(telefonIslemci islemci) {
        this.islemci = islemci;
    }

    public Long getTelefon_id() {
        return telefon_id;
    }

    public void setTelefon_id(Long telefon_id) {
        this.telefon_id = telefon_id;
    }

    public String getTelefon_ad() {
        return telefon_ad;
    }

    public void setTelefon_ad(String telefon_ad) {
        this.telefon_ad = telefon_ad;
    }

    public String getTelefon_marka() {
        return telefon_marka;
    }

    public void setTelefon_marka(String telefon_marka) {
        this.telefon_marka = telefon_marka;
    }

    public String getTelefon_model() {
        return telefon_model;
    }

    public void setTelefon_model(String telefon_model) {
        this.telefon_model = telefon_model;
    }

    public int getTelefon_ram() {
        return telefon_ram;
    }

    public void setTelefon_ram(int telefon_ram) {
        this.telefon_ram = telefon_ram;
    }

    public Double getTelefon_ram_frekansi() {
        return telefon_ram_frekansi;
    }

    public void setTelefon_ram_frekansi(Double telefon_ram_frekansi) {
        this.telefon_ram_frekansi = telefon_ram_frekansi;
    }

    public int getTelefon_dahili_depolama() {
        return telefon_dahili_depolama;
    }

    public void setTelefon_dahili_depolama(int telefon_dahili_depolama) {
        this.telefon_dahili_depolama = telefon_dahili_depolama;
    }

    public int getTelefon_boy() {
        return telefon_boy;
    }

    public void setTelefon_boy(int telefon_boy) {
        this.telefon_boy = telefon_boy;
    }

    public Double getTelefon_en() {
        return telefon_en;
    }

    public void setTelefon_en(Double telefon_en) {
        this.telefon_en = telefon_en;
    }

    public int getTelefon_agirlik() {
        return telefon_agirlik;
    }

    public void setTelefon_agirlik(int telefon_agirlik) {
        this.telefon_agirlik = telefon_agirlik;
    }

    public telefonBatarya getBatarya() {
        return batarya;
    }

    public void setBatarya(telefonBatarya batarya) {
        this.batarya = batarya;
    }

    public List<telefonRenk> getRenk() {
        return renk;
    }

    public void setRenk(List<telefonRenk> renk) {
        this.renk = renk;
    }

    public Dosya getResim() {
        return resim;
    }

    public void setResim(Dosya resim) {
        this.resim = resim;
    }

}
