/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.telefonIsletimSistemiDao;
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
    private telefonIsletimSistemiDao isletimSistemiDAO;
    private telefonIsletimSistemi isletimSistemi;
    
    public String update(){
        this.isletimSistemiDAO.edit(this.isletimSistemi);
        return "/module/telefon/ozellik/ozellik.xhtml";
    }
    
    public String temizle(){
        this.isletimSistemi = null;
        return "isletimSistemiForm";
    }
    
    public void updateForm(telefonIsletimSistemi isletimSistemi){
        this.isletimSistemi = isletimSistemi;
    }
    
    public String create()
    {
        this.getIsletimSistemiDAO().insert(this.isletimSistemi);
        return "/module/telefon/ozellik/ozellik.xhtml";
    }
    public List<telefonIsletimSistemi> getIslemtimSistemiList() {
        this.islemtimSistemiList=this.getIsletimSistemiDAO().findAll();
        return islemtimSistemiList;
    }

    public void setIslemtimSistemiList(List<telefonIsletimSistemi> islemtimSistemiList) {
        this.islemtimSistemiList = islemtimSistemiList;
    }

    public telefonIsletimSistemiDao getIsletimSistemiDAO() {
        if (this.isletimSistemiDAO==null) {
            this.isletimSistemiDAO=new telefonIsletimSistemiDao();
        }
        return isletimSistemiDAO;
    }

    public void setIsletimSistemiDAO(telefonIsletimSistemiDao isletimSistemiDAO) {
        this.isletimSistemiDAO = isletimSistemiDAO;
    }

    public telefonIsletimSistemi getIsletimSistemi() {
        if (this.isletimSistemi==null) {
            this.isletimSistemi=new telefonIsletimSistemi();
        }
        return isletimSistemi;
    }

    public void setIsletimSistemi(telefonIsletimSistemi isletimSistemi) {
        this.isletimSistemi = isletimSistemi;
    }
    
    
}
