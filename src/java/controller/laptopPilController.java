/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.laptopEkranKartiDAO;
import DataAccess.laptopPilDAO;
import entity.laptopEkranKarti;
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
    private laptopPilDAO laptopPilDAO;
    private laptopPil laptopPil;

    public void update() {
        this.laptopPilDAO.edit(this.laptopPil);
    }

    public void delete(laptopPil laptopPil) {
        this.laptopPilDAO.remove(laptopPil);
        this.laptopPil = null;
    }

    public void temizle() {
        this.laptopPil = null;
    }

    public void updateForm(laptopPil bag) {
        this.laptopPil = bag;
    }

    public void create() {
        this.laptopPilDAO.insert(this.laptopPil);
        temizle();
    }

    public List<laptopPil> getLaptopPilList() {
        this.laptopPilList = this.getLaptopPilDAO().findAll();
        return laptopPilList;
    }

    public void setLaptopPilList(List<laptopPil> laptopPilList) {
        this.laptopPilList = laptopPilList;
    }

    public laptopPilDAO getLaptopPilDAO() {
        if(this.laptopPilDAO == null){
            this.laptopPilDAO = new laptopPilDAO();
        }
        return laptopPilDAO;
    }

    public void setLaptopPilDAO(laptopPilDAO laptopPilDAO) {
        this.laptopPilDAO = laptopPilDAO;
    }

    public laptopPil getLaptopPil() {
        if(this.laptopPil == null){
            this.laptopPil = new laptopPil();
        }
        return laptopPil;
    }

    public void setLaptopPil(laptopPil laptopPil) {
        this.laptopPil = laptopPil;
    }


}
