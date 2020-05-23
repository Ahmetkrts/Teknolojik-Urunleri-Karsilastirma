/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.laptopEkranKartiDAO;
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
    private laptopEkranKartiDAO laptopEkranKartiDAO;
    private laptopEkranKarti laptopEkranKarti;

    public void update() {
        this.laptopEkranKartiDAO.edit(this.laptopEkranKarti);
    }

    public void delete(laptopEkranKarti laptopEkranKarti) {
        this.laptopEkranKartiDAO.remove(laptopEkranKarti);
        this.laptopEkranKarti = null;
    }

    public void temizle() {
        this.laptopEkranKarti = null;
    }

    public void updateForm(laptopEkranKarti bag) {
        this.laptopEkranKarti = bag;
    }

    public void create() {
        this.laptopEkranKartiDAO.insert(this.laptopEkranKarti);
        temizle();
    }

    public List<laptopEkranKarti> getLaptopEkranKartiList() {
        this.laptopEkranKartiList = this.getLaptopEkranKartiDAO().findAll();
        return laptopEkranKartiList;
    }

    public void setLaptopEkranKartiList(List<laptopEkranKarti> laptopEkranKartiList) {
        this.laptopEkranKartiList = laptopEkranKartiList;
    }

    public laptopEkranKartiDAO getLaptopEkranKartiDAO() {
        if (this.laptopEkranKartiDAO == null) {
            this.laptopEkranKartiDAO = new laptopEkranKartiDAO();
        }
        return laptopEkranKartiDAO;
    }

    public void setLaptopEkranKartiDAO(laptopEkranKartiDAO laptopEkranKartiDAO) {
        this.laptopEkranKartiDAO = laptopEkranKartiDAO;
    }

    public laptopEkranKarti getLaptopEkranKarti() {
        if (this.laptopEkranKarti == null) {
            this.laptopEkranKarti = new laptopEkranKarti();
        }
        return laptopEkranKarti;
    }

    public void setLaptopEkranKarti(laptopEkranKarti laptopEkranKarti) {
        this.laptopEkranKarti = laptopEkranKarti;
    }

}
