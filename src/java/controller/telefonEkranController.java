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
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void next() {
        if (this.page == getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getEkrandao().countSize() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

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

    public List<telefonEkran> telEkranList() {
        this.ekranList = this.getEkrandao().findAll(page, pageSize, 2);
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
