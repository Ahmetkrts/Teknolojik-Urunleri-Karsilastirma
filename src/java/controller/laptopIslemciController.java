/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.laptopEkranKartiDAO;
import DataAccess.laptopIslemciDAO;
import entity.laptopEkranKarti;
import entity.laptopIslemci;
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
public class laptopIslemciController implements Serializable {

    private List<laptopIslemci> laptopIslemciList;
    private laptopIslemciDAO laptopIslemciDAO;
    private laptopIslemci laptopIslemci;
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
        this.pageCount = (int) Math.ceil(this.getLaptopIslemciDAO().countSize() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void update() {
        this.laptopIslemciDAO.edit(this.laptopIslemci);
    }

    public void delete(laptopIslemci laptopIslemci) {
        this.laptopIslemciDAO.remove(laptopIslemci);
        this.laptopIslemci = null;
    }

    public void temizle() {
        this.laptopIslemci = null;
    }

    public void updateForm(laptopIslemci bag) {
        this.laptopIslemci = bag;
    }

    public void create() {
        this.laptopIslemciDAO.insert(this.laptopIslemci);
        temizle();
    }

    public List<laptopIslemci> getLaptopIslemciList() {
        this.laptopIslemciList = this.getLaptopIslemciDAO().findAll();
        return laptopIslemciList;
    }

    public List<laptopIslemci> islemciList() {
        this.laptopIslemciList = this.getLaptopIslemciDAO().findAll(page, pageSize, 2);
        return laptopIslemciList;
    }

    public void setLaptopIslemciList(List<laptopIslemci> laptopIslemciList) {
        this.laptopIslemciList = laptopIslemciList;
    }

    public laptopIslemciDAO getLaptopIslemciDAO() {
        if (this.laptopIslemciDAO == null) {
            this.laptopIslemciDAO = new laptopIslemciDAO();
        }
        return laptopIslemciDAO;
    }

    public void setLaptopIslemciDAO(laptopIslemciDAO laptopIslemciDAO) {
        this.laptopIslemciDAO = laptopIslemciDAO;
    }

    public laptopIslemci getLaptopIslemci() {
        if (this.laptopIslemci == null) {
            this.laptopIslemci = new laptopIslemci();
        }
        return laptopIslemci;
    }

    public void setLaptopIslemci(laptopIslemci laptopIslemci) {
        this.laptopIslemci = laptopIslemci;
    }

}
