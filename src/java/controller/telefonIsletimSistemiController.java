/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.telefonIsletimSistemiDAO;
import entity.telefonIsletimSistemi;
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
public class telefonIsletimSistemiController implements Serializable {

    private List<telefonIsletimSistemi> islemtimSistemiList;
    private telefonIsletimSistemiDAO isletimSistemiDAO;
    private telefonIsletimSistemi isletimSistemi;

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

    public void updateForm(telefonIsletimSistemi isletimSistemi) {
        this.isletimSistemi = isletimSistemi;
    }

    public void create() {
        this.getIsletimSistemiDAO().insert(this.isletimSistemi);
        temizle();
    }

    public List<telefonIsletimSistemi> getIslemtimSistemiList() {
        this.islemtimSistemiList = this.getIsletimSistemiDAO().findAll();
        return islemtimSistemiList;
    }

    public void setIslemtimSistemiList(List<telefonIsletimSistemi> islemtimSistemiList) {
        this.islemtimSistemiList = islemtimSistemiList;
    }

    public telefonIsletimSistemiDAO getIsletimSistemiDAO() {
        if (this.isletimSistemiDAO == null) {
            this.isletimSistemiDAO = new telefonIsletimSistemiDAO();
        }
        return isletimSistemiDAO;
    }

    public void setIsletimSistemiDAO(telefonIsletimSistemiDAO isletimSistemiDAO) {
        this.isletimSistemiDAO = isletimSistemiDAO;
    }

    public telefonIsletimSistemi getIsletimSistemi() {
        if (this.isletimSistemi == null) {
            this.isletimSistemi = new telefonIsletimSistemi();
        }
        return isletimSistemi;
    }

    public void setIsletimSistemi(telefonIsletimSistemi isletimSistemi) {
        this.isletimSistemi = isletimSistemi;
    }

}
