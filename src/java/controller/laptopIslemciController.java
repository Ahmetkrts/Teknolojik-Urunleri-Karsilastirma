/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.laptopEkranKartiDAO;
import DataAccess.laptopIslemciDAO;
import entity.laptopEkranKarti;
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
    private laptopIslemciDAO laptopIslemciDAO;
    private laptopIslemci laptopIslemci;

    public void update() {
        this.laptopIslemciDAO.edit(this.laptopIslemci);
    }

    public void delete(laptopIslemci laptopIslemci) {
        this.laptopIslemciDAO.remove(laptopIslemci);
        this.laptopIslemci = null;
    }

    public void temizle() {
        this.laptopIslemci = null;
    }

    public void updateForm(laptopIslemci bag) {
        this.laptopIslemci = bag;
    }

    public void create() {
        this.laptopIslemciDAO.insert(this.laptopIslemci);
        temizle();
    }

    public List<laptopIslemci> getLaptopIslemciList() {
        this.laptopIslemciList = this.getLaptopIslemciDAO().findAll();
        return laptopIslemciList;
    }

    public void setLaptopIslemciList(List<laptopIslemci> laptopIslemciList) {
        this.laptopIslemciList = laptopIslemciList;
    }

    public laptopIslemciDAO getLaptopIslemciDAO() {
        if(this.laptopIslemciDAO == null){
            this.laptopIslemciDAO = new laptopIslemciDAO();
        }
        return laptopIslemciDAO;
    }

    public void setLaptopIslemciDAO(laptopIslemciDAO laptopIslemciDAO) {
        this.laptopIslemciDAO = laptopIslemciDAO;
    }

    public laptopIslemci getLaptopIslemci() {
        if(this.laptopIslemci == null){
            this.laptopIslemci = new laptopIslemci();
        }
        return laptopIslemci;
    }

    public void setLaptopIslemci(laptopIslemci laptopIslemci) {
        this.laptopIslemci = laptopIslemci;
    }

}
