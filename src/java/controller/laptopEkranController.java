/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.laptopEkranDAO;
import entity.laptopEkran;
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
public class laptopEkranController implements Serializable {

    private List<laptopEkran> laptopEkranList;
    private laptopEkranDAO laptopEkranDAO;
    private laptopEkran laptopEkran;
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
        this.pageCount = (int) Math.ceil(this.getLaptopEkranDAO().countSize() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void update() {
        this.laptopEkranDAO.edit(this.laptopEkran);
    }

    public void delete(laptopEkran laptopEkran) {
        this.laptopEkranDAO.remove(laptopEkran);
        this.laptopEkran = null;
    }

    public void temizle() {
        this.laptopEkran = null;
    }

    public void updateForm(laptopEkran bag) {
        this.laptopEkran = bag;
    }

    public void create() {
        this.laptopEkranDAO.insert(this.laptopEkran);
        temizle();
    }

    public List<laptopEkran> getLaptopEkranList() {
        this.laptopEkranList = this.getLaptopEkranDAO().findAll();
        return laptopEkranList;
    }

    public List<laptopEkran> ekranList() {
        this.laptopEkranList = this.getLaptopEkranDAO().findAll(page, pageSize, 2);
        return laptopEkranList;
    }

    public void setLaptopEkranList(List<laptopEkran> laptopEkranList) {
        this.laptopEkranList = laptopEkranList;
    }

    public laptopEkranDAO getLaptopEkranDAO() {
        if (this.laptopEkranDAO == null) {
            this.laptopEkranDAO = new laptopEkranDAO();
        }
        return laptopEkranDAO;
    }

    public void setLaptopEkranDAO(laptopEkranDAO laptopEkranDAO) {
        this.laptopEkranDAO = laptopEkranDAO;
    }

    public laptopEkran getLaptopEkran() {
        if (this.laptopEkran == null) {
            this.laptopEkran = new laptopEkran();
        }
        return laptopEkran;
    }

    public void setLaptopEkran(laptopEkran laptopEkran) {
        this.laptopEkran = laptopEkran;
    }

}
