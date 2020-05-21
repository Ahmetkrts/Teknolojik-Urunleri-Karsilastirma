/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.televizyonIslettimSistemiDAO;
import entity.televizyonIslettimSistemi;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author techn
 */
@Named
@SessionScoped
public class televizyonIslettimSistemiController implements Serializable {

    private List<televizyonIslettimSistemi> islemtimSistemiList;
    private televizyonIslettimSistemiDAO isletimSistemiDAO;
    private televizyonIslettimSistemi isletimSistemi;

    public void update() {
        this.isletimSistemiDAO.edit(this.isletimSistemi);

    }

    public void delete() {
        this.isletimSistemiDAO.remove(this.isletimSistemi);
        this.isletimSistemi = null;

    }

    public void temizle() {
        this.isletimSistemi = null;

    }

    public void updateForm(televizyonIslettimSistemi isletimSistemi) {
        this.isletimSistemi = isletimSistemi;
    }

    public void create() {
        this.getIsletimSistemiDAO().insert(this.isletimSistemi);
        temizle();
    }

    public List<televizyonIslettimSistemi> getIslemtimSistemiList() {
        this.islemtimSistemiList = this.getIsletimSistemiDAO().findAll();
        return islemtimSistemiList;
    }

    public void setIslemtimSistemiList(List<televizyonIslettimSistemi> islemtimSistemiList) {
        this.islemtimSistemiList = islemtimSistemiList;
    }

    public televizyonIslettimSistemiDAO getIsletimSistemiDAO() {
        if (this.isletimSistemiDAO == null) {
            this.isletimSistemiDAO = new televizyonIslettimSistemiDAO();
        }
        return isletimSistemiDAO;
    }

    public void setIsletimSistemiDAO(televizyonIslettimSistemiDAO isletimSistemiDAO) {
        this.isletimSistemiDAO = isletimSistemiDAO;
    }

    public televizyonIslettimSistemi getIsletimSistemi() {
        if (this.isletimSistemi == null) {
            this.isletimSistemi = new televizyonIslettimSistemi();
        }
        return isletimSistemi;
    }

    public void setIsletimSistemi(televizyonIslettimSistemi isletimSistemi) {
        this.isletimSistemi = isletimSistemi;
    }

}
