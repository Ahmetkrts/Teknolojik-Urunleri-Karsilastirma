/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.telefonBataryaDAO;
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
public class telefonBataryaController implements Serializable {

    private List<telefonBatarya> bataryaList;
    private telefonBataryaDAO bataryaDao;
    private telefonBatarya batarya;
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
        this.pageCount = (int) Math.ceil(this.getBataryaDao().countSize() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void update() {
        this.bataryaDao.edit(this.batarya);

    }

    public void delete() {
        this.bataryaDao.remove(this.batarya);
        this.batarya = null;
    }

    public void temizle() {
        this.batarya = null;

    }

    public void updateForm(telefonBatarya batarya) {
        this.batarya = batarya;
    }

    public void create() {
        this.getBataryaDao().insert(this.batarya);
        temizle();
    }

    public List<telefonBatarya> getBataryaList() {
        this.bataryaList = this.getBataryaDao().findAll();
        return bataryaList;
    }
     public List<telefonBatarya> telBataryaList() {
        this.bataryaList = this.getBataryaDao().findAll(page, pageSize, 2);
        return bataryaList;
    }

    public void setBataryaList(List<telefonBatarya> bataryaList) {
        this.bataryaList = bataryaList;
    }

    public telefonBataryaDAO getBataryaDao() {
        if (this.bataryaDao == null) {
            this.bataryaDao = new telefonBataryaDAO();
        }
        return bataryaDao;
    }

    public void setBataryaDao(telefonBataryaDAO bataryaDao) {
        this.bataryaDao = bataryaDao;
    }

    public telefonBatarya getBatarya() {
        if (this.batarya == null) {
            this.batarya = new telefonBatarya();
        }
        return batarya;
    }

    public void setBatarya(telefonBatarya batarya) {
        this.batarya = batarya;
    }

}
