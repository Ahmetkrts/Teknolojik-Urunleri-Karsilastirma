/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.telefonEkranDAO;
import entity.telefonEkran;
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
public class telefonEkranController implements Serializable {

    private List<telefonEkran> ekranList;
    private telefonEkranDAO ekrandao;
    private telefonEkran ekran;

    public String temizle(){
        this.ekran = null;
        return "ekranForm";
    }
    
    public void updateForm(telefonEkran ekran){
        this.ekran = ekran;
    }
    
    public String create() {
        this.getEkrandao().insert(this.ekran);
        return "/module/telefon/ozellik/ozellik.xhtml";
    }

    public List<telefonEkran> getEkranList() {
        this.ekranList = this.getEkrandao().findAll();
        return ekranList;
    }

    public void setEkranList(List<telefonEkran> ekranList) {
        this.ekranList = ekranList;
    }

    public telefonEkranDAO getEkrandao() {
        if (this.ekrandao == null) {
            this.ekrandao = new telefonEkranDAO();
        }
        return ekrandao;
    }

    public void setEkrandao(telefonEkranDAO ekrandao) {
        this.ekrandao = ekrandao;
    }

    public telefonEkran getEkran() {
        if (this.ekran == null) {
            this.ekran = new telefonEkran();
        }
        return ekran;
    }

    public void setEkran(telefonEkran ekran) {
        this.ekran = ekran;
    }

}
