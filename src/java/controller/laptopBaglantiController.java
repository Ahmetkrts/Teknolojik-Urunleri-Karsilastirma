/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.laptopBaglantiDAO;
import entity.laptopBaglanti;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Casper
 */
@Named
@SessionScoped
public class laptopBaglantiController implements Serializable {

    private List<laptopBaglanti> laptopBaglantiList;
    private laptopBaglantiDAO laptopBaglantidao;
    private laptopBaglanti laptopBaglanti;

    public String temizle() {
        this.laptopBaglanti=new  laptopBaglanti();
        return "/module/laptop/ozellik/ozellik.xhtml";

    }
    public void delete(laptopBaglanti baglanti) {
        this.laptopBaglantidao.delete(baglanti);

    }

    public void update() {
        this.laptopBaglantidao.update(this.laptopBaglanti);
    }

    public void updateForm(laptopBaglanti baglanti) {
        this.laptopBaglanti = baglanti;

    }

    public String create() {
        this.laptopBaglantidao.insert(this.laptopBaglanti);
        return "/module/laptop/ozellik/ozellik.xhtml";
    }

    public List<laptopBaglanti> getlaptopBaglantiList() {
        this.laptopBaglantiList = this.getlaptopBaglantidao().findAll();
        return laptopBaglantiList;
    }

    public void setlaptopBaglantiList(List<laptopBaglanti> laptopBaglantiList) {
        this.laptopBaglantiList = laptopBaglantiList;
    }

    public laptopBaglantiDAO getlaptopBaglantidao() {
        if (this.laptopBaglantidao == null) {
            this.laptopBaglantidao = new laptopBaglantiDAO();
        }
        return laptopBaglantidao;
    }

    public void setlaptopBaglantidao(laptopBaglantiDAO laptopBaglantidao) {
        this.laptopBaglantidao = laptopBaglantidao;
    }

    public laptopBaglanti getlaptopBaglanti() {
        if (this.laptopBaglanti == null) {
            this.laptopBaglanti = new laptopBaglanti();
        }
        return laptopBaglanti;
    }

    public void setlaptopBaglanti(laptopBaglanti laptopBaglanti) {
        this.laptopBaglanti = laptopBaglanti;
    }

}
