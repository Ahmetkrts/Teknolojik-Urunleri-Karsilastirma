/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.laptopBaglantiDAO;
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

    private List<laptopBaglanti> baglantiList;
    private laptopBaglantiDAO baglantiDAO;
    private laptopBaglanti baglanti;

    public void update() {
        this.baglantiDAO.edit(this.baglanti);
    }

    public void delete(laptopBaglanti baglanti) {
        this.baglantiDAO.remove(baglanti);
        this.baglanti = null;
    }

    public void temizle() {
        this.baglanti = null;

    }

    public void updateForm(laptopBaglanti bag) {
        this.baglanti = bag;
    }

    public void create() {
        this.getBaglantiDAO().insert(this.baglanti);
        temizle();
    }

    public List<laptopBaglanti> getBaglantiList() {
        this.baglantiList = this.getBaglantiDAO().findAll();
        return baglantiList;
    }

    public void setBaglantiList(List<laptopBaglanti> baglantiList) {
        this.baglantiList = baglantiList;
    }

    public laptopBaglantiDAO getBaglantiDAO() {
        if (this.baglantiDAO == null) {
            this.baglantiDAO = new laptopBaglantiDAO();
        }
        return baglantiDAO;
    }

    public void setBaglantiDAO(laptopBaglantiDAO baglantiDAO) {
        this.baglantiDAO = baglantiDAO;
    }

    public laptopBaglanti getBaglanti() {
        if (this.baglanti == null) {
            this.baglanti = new laptopBaglanti();
        }
        return baglanti;
    }

    public void setBaglanti(laptopBaglanti baglanti) {
        this.baglanti = baglanti;
    }

}
