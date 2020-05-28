/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.laptopEkranKartiDAO;
import DataAccess.laptopPilDAO;
import entity.laptopEkranKarti;
import entity.laptopPil;
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
public class laptopPilController implements Serializable {

    private List<laptopPil> laptopPilList;
    private laptopPilDAO laptopPilDAO;
    private laptopPil laptopPil;
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
        this.pageCount = (int) Math.ceil(this.getLaptopPilDAO().countSize() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void update() {
        this.laptopPilDAO.edit(this.laptopPil);
    }

    public void delete(laptopPil laptopPil) {
        this.laptopPilDAO.remove(laptopPil);
        this.laptopPil = null;
    }

    public void temizle() {
        this.laptopPil = null;
    }

    public void updateForm(laptopPil bag) {
        this.laptopPil = bag;
    }

    public void create() {
        this.laptopPilDAO.insert(this.laptopPil);
        temizle();
    }

    public List<laptopPil> getLaptopPilList() {
        this.laptopPilList = this.getLaptopPilDAO().findAll();
        return laptopPilList;
    }

    public List<laptopPil> pilList() {
        this.laptopPilList = this.getLaptopPilDAO().findAll(page, pageSize, 2);
        return laptopPilList;
    }

    public void setLaptopPilList(List<laptopPil> laptopPilList) {
        this.laptopPilList = laptopPilList;
    }

    public laptopPilDAO getLaptopPilDAO() {
        if (this.laptopPilDAO == null) {
            this.laptopPilDAO = new laptopPilDAO();
        }
        return laptopPilDAO;
    }

    public void setLaptopPilDAO(laptopPilDAO laptopPilDAO) {
        this.laptopPilDAO = laptopPilDAO;
    }

    public laptopPil getLaptopPil() {
        if (this.laptopPil == null) {
            this.laptopPil = new laptopPil();
        }
        return laptopPil;
    }

    public void setLaptopPil(laptopPil laptopPil) {
        this.laptopPil = laptopPil;
    }

}
