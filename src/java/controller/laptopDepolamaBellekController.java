/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.laptopDepolamaBellekDAO;
import entity.laptopDepolamaBellek;
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
public class laptopDepolamaBellekController implements Serializable {

    private List<laptopDepolamaBellek> laptopDepolamaBellekList;
    private laptopDepolamaBellekDAO laptopDepolamaBellekDAO;
    private laptopDepolamaBellek laptopDepolamaBellek;
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
        this.pageCount = (int) Math.ceil(this.getLaptopDepolamaBellekDAO().countSize() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void update() {
        this.getLaptopDepolamaBellekDAO().edit(this.laptopDepolamaBellek);
    }

    public void delete(laptopDepolamaBellek laptopDepolamaBellek) {
        this.getLaptopDepolamaBellekDAO().remove(laptopDepolamaBellek);
        this.laptopDepolamaBellek = null;
    }

    public void temizle() {
        this.laptopDepolamaBellek = null;

    }

    public void updateForm(laptopDepolamaBellek bag) {
        this.laptopDepolamaBellek = bag;
    }

    public void create() {
        this.getLaptopDepolamaBellekDAO().insert(this.laptopDepolamaBellek);
        temizle();
    }

    public List<laptopDepolamaBellek> getLaptopDepolamaBellekList() {
        this.laptopDepolamaBellekList = this.getLaptopDepolamaBellekDAO().findAll();
        return laptopDepolamaBellekList;
    }

    public List<laptopDepolamaBellek> depolamaBellekList() {
        this.laptopDepolamaBellekList = this.getLaptopDepolamaBellekDAO().findAll(page, pageSize, 2);
        return laptopDepolamaBellekList;
    }

    public void setLaptopDepolamaBellekList(List<laptopDepolamaBellek> laptopDepolamaBellekList) {
        this.laptopDepolamaBellekList = laptopDepolamaBellekList;
    }

    public laptopDepolamaBellekDAO getLaptopDepolamaBellekDAO() {
        if (this.laptopDepolamaBellekDAO == null) {
            this.laptopDepolamaBellekDAO = new laptopDepolamaBellekDAO();
        }
        return laptopDepolamaBellekDAO;
    }

    public void setLaptopDepolamaBellekDAO(laptopDepolamaBellekDAO laptopDepolamaBellekDAO) {
        this.laptopDepolamaBellekDAO = laptopDepolamaBellekDAO;
    }

    public laptopDepolamaBellek getLaptopDepolamaBellek() {
        if (this.laptopDepolamaBellek == null) {
            this.laptopDepolamaBellek = new laptopDepolamaBellek();
        }
        return laptopDepolamaBellek;
    }

    public void setLaptopDepolamaBellek(laptopDepolamaBellek laptopDepolamaBellek) {
        this.laptopDepolamaBellek = laptopDepolamaBellek;
    }

}
