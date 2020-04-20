/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.telefonRenkDAO;
import entity.telefonRenk;
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
public class telefonRenkController implements Serializable{
    private  List<telefonRenk> renkList;
    private telefonRenkDAO renkDAO;
    private telefonRenk renk;

    public String create()
    {
       
        this.getRenkDAO().insert(this.renk);
        
        return "/module/telefon/ozellik/ozellik.xhtml";
    }
    public List<telefonRenk> getRenkList() {
        this.renkList=this.getRenkDAO().findAll();
               
        return renkList;
    }

    public void setRenkList(List<telefonRenk> renkList) {
        this.renkList = renkList;
    }

    public telefonRenkDAO getRenkDAO() {
        if (this.renkDAO==null) {
            this.renkDAO=new telefonRenkDAO();
        }
        return renkDAO;
    }

    public void setRenkDAO(telefonRenkDAO renkDAO) {
        this.renkDAO = renkDAO;
    }

    public telefonRenk getRenk() {
        if (this.renk==null) {
            this.renk=new telefonRenk();
        }
        return renk;
    }

    public void setRenk(telefonRenk renk) {
        this.renk = renk;
    }
    
}
