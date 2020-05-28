/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.laptopEkranKartiDAO;
import entity.laptopEkranKarti;
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
public class laptopEkranKartiController implements Serializable {

    private List<laptopEkranKarti> laptopEkranKartiList;
    private laptopEkranKartiDAO laptopEkranKartiDAO;
    private laptopEkranKarti laptopEkranKarti;
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
        this.pageCount = (int) Math.ceil(this.getLaptopEkranKartiDAO().countSize() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void update() {
        this.laptopEkranKartiDAO.edit(this.laptopEkranKarti);
    }

    public void delete(laptopEkranKarti laptopEkranKarti) {
        this.laptopEkranKartiDAO.remove(laptopEkranKarti);
        this.laptopEkranKarti = null;
    }

    public void temizle() {
        this.laptopEkranKarti = null;
    }

    public void updateForm(laptopEkranKarti bag) {
        this.laptopEkranKarti = bag;
    }

    public void create() {
        this.laptopEkranKartiDAO.insert(this.laptopEkranKarti);
        temizle();
    }

    public List<laptopEkranKarti> getLaptopEkranKartiList() {
        this.laptopEkranKartiList = this.getLaptopEkranKartiDAO().findAll();
        return laptopEkranKartiList;
    }

    public List<laptopEkranKarti> ekranKartiList() {
        this.laptopEkranKartiList = this.getLaptopEkranKartiDAO().findAll(page, pageSize, 2);
        return laptopEkranKartiList;
    }

    public void setLaptopEkranKartiList(List<laptopEkranKarti> laptopEkranKartiList) {
        this.laptopEkranKartiList = laptopEkranKartiList;
    }

    public laptopEkranKartiDAO getLaptopEkranKartiDAO() {
        if (this.laptopEkranKartiDAO == null) {
            this.laptopEkranKartiDAO = new laptopEkranKartiDAO();
        }
        return laptopEkranKartiDAO;
    }

    public void setLaptopEkranKartiDAO(laptopEkranKartiDAO laptopEkranKartiDAO) {
        this.laptopEkranKartiDAO = laptopEkranKartiDAO;
    }

    public laptopEkranKarti getLaptopEkranKarti() {
        if (this.laptopEkranKarti == null) {
            this.laptopEkranKarti = new laptopEkranKarti();
        }
        return laptopEkranKarti;
    }

    public void setLaptopEkranKarti(laptopEkranKarti laptopEkranKarti) {
        this.laptopEkranKarti = laptopEkranKarti;
    }

}
