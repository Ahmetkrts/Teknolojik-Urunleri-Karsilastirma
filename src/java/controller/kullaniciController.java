/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.kullaniciDAO;
import entity.kullanici;
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
public class kullaniciController implements Serializable {

    private List<kullanici> kullaniciList;
    private kullaniciDAO kullaniciDAO;
    private kullanici kullanici;
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
        this.pageCount = (int) Math.ceil(this.getKullaniciDAO().countSize() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void update() {
        this.kullaniciDAO.edit(this.kullanici);
    }

    public void delete(kullanici kullanici) {
        this.kullaniciDAO.remove(kullanici);
        this.kullanici = null;
    }

    public void temizle() {
        this.kullanici = null;
    }

    public void updateForm(kullanici bag) {
        this.kullanici = bag;
    }

    public void create() {
        this.kullaniciDAO.insert(this.kullanici);
        temizle();
    }

    public List<kullanici> getKullaniciList() {
        this.kullaniciList = this.getKullaniciDAO().findAll();
        return kullaniciList;
    }

    public List<kullanici> kullaniciist() {
        this.kullaniciList = this.getKullaniciDAO().findAll(page, pageSize, 2);
        return kullaniciList;
    }

    public void setKllaniciList(List<kullanici> kullaniciList) {
        this.kullaniciList = kullaniciList;
    }

    public kullaniciDAO getKullaniciDAO() {
        if (this.kullaniciDAO == null) {
            this.kullaniciDAO = new kullaniciDAO();
        }
        return kullaniciDAO;
    }

    public void setKullaniciDAO(kullaniciDAO kullaniciDAO) {
        this.kullaniciDAO = kullaniciDAO;
    }

    public kullanici getKullanici() {
        if (this.kullanici == null) {
            this.kullanici = new kullanici();
        }
        return kullanici;
    }

    public void setKullanici(kullanici kullanici) {
        this.kullanici = kullanici;
    }

}
