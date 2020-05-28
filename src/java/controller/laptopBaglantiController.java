/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.laptopBaglantiDAO;
import entity.laptopBaglanti;
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
public class laptopBaglantiController implements Serializable {

    private List<laptopBaglanti> baglantiList;
    private laptopBaglantiDAO baglantiDAO;
    private laptopBaglanti baglanti;
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
        this.pageCount = (int) Math.ceil(this.getBaglantiDAO().countSize() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void update() {
        this.baglantiDAO.edit(this.baglanti);
    }

    public void delete(laptopBaglanti baglanti) {
        this.baglantiDAO.remove(baglanti);
        this.baglanti = null;
    }

    public void temizle() {
        this.baglanti = null;

    }

    public void updateForm(laptopBaglanti bag) {
        this.baglanti = bag;
    }

    public void create() {
        this.getBaglantiDAO().insert(this.baglanti);
        temizle();
    }

    public List<laptopBaglanti> getBaglantiList() {
        this.baglantiList = this.getBaglantiDAO().findAll();
        return baglantiList;
    }

    public List<laptopBaglanti> bagList() {
        this.baglantiList = this.getBaglantiDAO().findAll(page, pageSize, 2);
        return baglantiList;
    }

    public void setBaglantiList(List<laptopBaglanti> baglantiList) {
        this.baglantiList = baglantiList;
    }

    public laptopBaglantiDAO getBaglantiDAO() {
        if (this.baglantiDAO == null) {
            this.baglantiDAO = new laptopBaglantiDAO();
        }
        return baglantiDAO;
    }

    public void setBaglantiDAO(laptopBaglantiDAO baglantiDAO) {
        this.baglantiDAO = baglantiDAO;
    }

    public laptopBaglanti getBaglanti() {
        if (this.baglanti == null) {
            this.baglanti = new laptopBaglanti();
        }
        return baglanti;
    }

    public void setBaglanti(laptopBaglanti baglanti) {
        this.baglanti = baglanti;
    }

}
