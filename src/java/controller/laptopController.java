/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.laptopDAO;
import entity.laptop;
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
public class laptopController implements Serializable {

    private List<laptop> laptopList;
    private laptopDAO laptopdao;
    private laptop laptop;
    private Long selectEkran;
    private Long selectDepolamaBellek;
    private Long selectIslemci;
    private Long selectEkranKarti;
    private Long selectPil;
    private Long selectBaglanti;

    public String temizle()
    {
        this.laptop=new laptop();
        return "module/laptop/laptop.xhtml";
    }
    public void delete(laptop laptop) {
        this.getLaptopdao().delete(laptop);

    }

    public void update() {
        this.getLaptopdao().update(this.laptop, this.selectEkran, this.selectDepolamaBellek, this.selectIslemci, this.selectEkranKarti, this.selectPil, this.selectBaglanti);

    }

    public void updateForm(laptop lp) {
        this.laptop = lp;

    }

    public void create() {
        this.getLaptopdao().insert(this.laptop, this.selectEkran, this.selectDepolamaBellek, this.selectIslemci, this.selectEkranKarti, this.selectPil, this.selectBaglanti);

    }

    public Long getSelectEkran() {
        return selectEkran;
    }

    public void setSelectEkran(Long selectEkran) {
        this.selectEkran = selectEkran;
    }

    public Long getSelectDepolamaBellek() {
        return selectDepolamaBellek;
    }

    public void setSelectDepolamaBellek(Long selectDepolamaBellek) {
        this.selectDepolamaBellek = selectDepolamaBellek;
    }

    public Long getSelectIslemci() {
        return selectIslemci;
    }

    public void setSelectIslemci(Long selectIslemci) {
        this.selectIslemci = selectIslemci;
    }

    public Long getSelectEkranKarti() {
        return selectEkranKarti;
    }

    public void setSelectEkranKarti(Long selectEkranKarti) {
        this.selectEkranKarti = selectEkranKarti;
    }

    public Long getSelectPil() {
        return selectPil;
    }

    public void setSelectPil(Long selectPil) {
        this.selectPil = selectPil;
    }

    public Long getSelectBaglanti() {
        return selectBaglanti;
    }

    public void setSelectBaglanti(Long selectBaglanti) {
        this.selectBaglanti = selectBaglanti;
    }

    public laptop getLaptop() {
        if (this.laptop == null) {
            this.laptop = new laptop();
        }
        return laptop;
    }

    public List<laptop> getLaptopList() {
        this.laptopList = getLaptopdao().findAll();
        return laptopList;
    }

    public laptopDAO getLaptopdao() {
        if (this.laptopdao == null) {
            this.laptopdao = new laptopDAO();
        }
        return laptopdao;
    }

}
