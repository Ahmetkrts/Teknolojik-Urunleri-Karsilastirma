/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.laptopPilDAO;
import entity.laptopPil;
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
public class laptopPilController implements Serializable {

    private List<laptopPil> laptopPilList;
    private laptopPilDAO laptopPildao;
    private laptopPil laptopPil;

    public void temizle() {
        this.laptopPil = new laptopPil();

    }

    public void delete(laptopPil pil) {
        this.laptopPildao.delete(pil);

    }

    public void update() {
        this.laptopPildao.update(this.laptopPil);

    }

    public void updateForm(laptopPil pil) {
        this.laptopPil = pil;

    }

    public void create() {
        this.laptopPildao.insert(this.laptopPil);
        temizle();
    }

    public List<laptopPil> getlaptopPilList() {
        this.laptopPilList = this.getlaptopPildao().findAll();
        return laptopPilList;
    }

    public void setlaptopPilList(List<laptopPil> laptopPilList) {
        this.laptopPilList = laptopPilList;
    }

    public laptopPilDAO getlaptopPildao() {
        if (this.laptopPildao == null) {
            this.laptopPildao = new laptopPilDAO();
        }
        return laptopPildao;
    }

    public void setlaptopPildao(laptopPilDAO laptopPildao) {
        this.laptopPildao = laptopPildao;
    }

    public laptopPil getlaptopPil() {
        if (this.laptopPil == null) {
            this.laptopPil = new laptopPil();
        }
        return laptopPil;
    }

    public void setlaptopPil(laptopPil laptopPil) {
        this.laptopPil = laptopPil;
    }
}
