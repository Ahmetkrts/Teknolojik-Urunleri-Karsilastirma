/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.televizyonEkranDAO;
import entity.televizyonEkran;
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
public class televizyonEkranController implements Serializable {

    private List<televizyonEkran> ekranList;
    private televizyonEkranDAO ekrandao;
    private televizyonEkran ekran;

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

    public void updateForm(televizyonEkran ekran) {
        this.ekran = ekran;
    }

    public void create() {
        this.getEkrandao().insert(this.ekran);
        temizle();
    }

    public List<televizyonEkran> getEkranList() {
        this.ekranList = this.getEkrandao().findAll();
        return ekranList;
    }

    public void setEkranList(List<televizyonEkran> ekranList) {
        this.ekranList = ekranList;
    }

    public televizyonEkranDAO getEkrandao() {
        if (this.ekrandao == null) {
            this.ekrandao = new televizyonEkranDAO();
        }
        return ekrandao;
    }

    public void setEkrandao(televizyonEkranDAO ekrandao) {
        this.ekrandao = ekrandao;
    }

    public televizyonEkran getEkran() {
        if (this.ekran == null) {
            this.ekran = new televizyonEkran();
        }
        return ekran;
    }

    public void setEkran(televizyonEkran ekran) {
        this.ekran = ekran;
    }

}
