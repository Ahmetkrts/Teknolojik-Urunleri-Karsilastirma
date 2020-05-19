/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.telefonIslemciDAO;
import entity.telefonIslemci;
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
public class telefonIslemciController implements Serializable{
    
    private  List<telefonIslemci> islemciList;
    private telefonIslemciDAO islemciDao;
    private telefonIslemci islemci;

    public String update(){
        this.islemciDao.edit(this.islemci);
        return "/module/telefon/ozellik/ozellik.xhtml";
    }
    
    public void delete(){
        this.islemciDao.remove(this.islemci);
        this.islemci = null;
    }
    public String temizle(){
        this.islemci = null;
        return "islemciForm";
    }
    
    public void updateForm(telefonIslemci ekran){
        this.islemci = ekran;
    }
    
    public String create()
    {
        this.getIslemciDao().insert(this.islemci);
        
        return "/module/telefon/ozellik/ozellik.xhtml";
    }
    public List<telefonIslemci> getIslemciList() {
        this.islemciList=this.getIslemciDao().findAll();
        return islemciList;
    }

    public void setIslemciList(List<telefonIslemci> islemciList) {
        this.islemciList = islemciList;
    }

    public telefonIslemciDAO getIslemciDao() {
        if (this.islemciDao==null) {
            this.islemciDao=new telefonIslemciDAO();
        }
        return islemciDao;
    }

    public void setIslemciDao(telefonIslemciDAO islemciDao) {
        this.islemciDao = islemciDao;
    }

    public telefonIslemci getIslemci() {
        if (this.islemci==null) {
            this.islemci=new telefonIslemci();
        }
        return islemci;
    }

    public void setIslemci(telefonIslemci islemci) {
        this.islemci = islemci;
    }
    
}
