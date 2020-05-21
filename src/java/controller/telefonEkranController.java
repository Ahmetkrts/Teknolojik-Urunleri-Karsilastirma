/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.telefonEkranDAO;
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

    public void update() {
        this.ekrandao.edit(this.ekran);

    }

    public void delete() {
        this.ekrandao.remove(this.ekran);
        this.ekran = null;
    }

    public void temizle() {
        this.ekran = null;

    }

    public void updateForm(telefonEkran ekran) {
        this.ekran = ekran;
    }

    public void create() {
        this.getEkrandao().insert(this.ekran);
        temizle();
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
