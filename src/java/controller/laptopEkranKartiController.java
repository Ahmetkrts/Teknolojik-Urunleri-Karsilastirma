/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.laptopEkranKartiDAO;
import entity.laptopEkranKarti;
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
public class laptopEkranKartiController implements Serializable {

    private List<laptopEkranKarti> laptopEkranKartiList;
    private laptopEkranKartiDAO laptopEkranKartidao;
    private laptopEkranKarti laptopEkranKarti;

    public String create() {
        this.laptopEkranKartidao.insert(this.laptopEkranKarti);
        return "/module/laptop/ozellik/ozellik.xhtml";
    }

    public List<laptopEkranKarti> getlaptopEkranKartiList() {
        this.laptopEkranKartiList = this.getlaptopEkranKartidao().findAll();
        return laptopEkranKartiList;
    }

    public void setlaptopEkranKartiList(List<laptopEkranKarti> laptopEkranKartiList) {
        this.laptopEkranKartiList = laptopEkranKartiList;
    }

    public laptopEkranKartiDAO getlaptopEkranKartidao() {
        if (this.laptopEkranKartidao == null) {
            this.laptopEkranKartidao = new laptopEkranKartiDAO();
        }
        return laptopEkranKartidao;
    }

    public void setlaptopEkranKartidao(laptopEkranKartiDAO laptopEkranKartidao) {
        this.laptopEkranKartidao = laptopEkranKartidao;
    }

    public laptopEkranKarti getlaptopEkranKarti() {
        if (this.laptopEkranKarti == null) {
            this.laptopEkranKarti = new laptopEkranKarti();
        }
        return laptopEkranKarti;
    }

    public void setlaptopEkranKarti(laptopEkranKarti laptopEkranKarti) {
        this.laptopEkranKarti = laptopEkranKarti;
    }
}
