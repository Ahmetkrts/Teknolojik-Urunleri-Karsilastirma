/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.telefonBataryaDao;
import entity.telefonBatarya;
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
public class telefonBataryaController implements Serializable{
    
    private List<telefonBatarya> bataryaList;
    private telefonBataryaDao bataryaDao;
    private telefonBatarya batarya;
    
    public String update(){
        this.bataryaDao.edit(this.batarya);
        return "/module/telefon/ozellik/ozellik.xhtml";
    }
    
    public String temizle(){
        this.batarya = null;
        return "bataryaForm";
    }
    
    public void updateForm(telefonBatarya batarya){
        this.batarya = batarya;
    }
    
    
    public String create()
    {
        this.getBataryaDao().insert(this.batarya);
        return "/module/telefon/ozellik/ozellik.xhtml";
    }
    public List<telefonBatarya> getBataryaList() {
        this.bataryaList=this.getBataryaDao().findAll();
        return bataryaList;
    }

    public void setBataryaList(List<telefonBatarya> bataryaList) {
        this.bataryaList = bataryaList;
    }

    public telefonBataryaDao getBataryaDao() {
        if (this.bataryaDao==null) {
            this.bataryaDao=new telefonBataryaDao();
        }
        return bataryaDao;
    }

    public void setBataryaDao(telefonBataryaDao bataryaDao) {
        this.bataryaDao = bataryaDao;
    }

    public telefonBatarya getBatarya() {
        if (this.batarya==null) {
            this.batarya=new telefonBatarya();
        }
        return batarya;
    }

    public void setBatarya(telefonBatarya batarya) {
        this.batarya = batarya;
    }
    
    
}
