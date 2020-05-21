/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.laptopIslemciDAO;
import entity.laptopIslemci;
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
public class laptopIslemciController implements Serializable {

    private List<laptopIslemci> laptopIslemciList;
    private laptopIslemciDAO laptopIslemcidao;
    private laptopIslemci laptopIslemci;

    public void temizle() {
        this.laptopIslemci = new laptopIslemci();

    }

    public void delete(laptopIslemci islemci) {
        this.laptopIslemcidao.delete(islemci);

    }

    public void update() {
        this.laptopIslemcidao.update(this.laptopIslemci);

    }

    public void updateForm(laptopIslemci islemci) {
        this.laptopIslemci = islemci;

    }

    public void create() {
        this.laptopIslemcidao.insert(this.laptopIslemci);
        temizle();
    }

    public List<laptopIslemci> getlaptopIslemciList() {
        this.laptopIslemciList = this.getlaptopIslemcidao().findAll();
        return laptopIslemciList;
    }

    public void setlaptopIslemciList(List<laptopIslemci> laptopIslemciList) {
        this.laptopIslemciList = laptopIslemciList;
    }

    public laptopIslemciDAO getlaptopIslemcidao() {
        if (this.laptopIslemcidao == null) {
            this.laptopIslemcidao = new laptopIslemciDAO();
        }
        return laptopIslemcidao;
    }

    public void setlaptopIslemcidao(laptopIslemciDAO laptopIslemcidao) {
        this.laptopIslemcidao = laptopIslemcidao;
    }

    public laptopIslemci getlaptopIslemci() {
        if (this.laptopIslemci == null) {
            this.laptopIslemci = new laptopIslemci();
        }
        return laptopIslemci;
    }

    public void setlaptopIslemci(laptopIslemci laptopIslemci) {
        this.laptopIslemci = laptopIslemci;
    }
}
