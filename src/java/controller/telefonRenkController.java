/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.telefonRenkDAO;
import entity.telefonRenk;
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
public class telefonRenkController implements Serializable {

    private List<telefonRenk> renkList;
    private telefonRenkDAO renkDAO;
    private telefonRenk renk;
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
        this.pageCount = (int) Math.ceil(this.getRenkDAO().countSize() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void update() {
        this.renkDAO.edit(this.renk);

    }

    public void delete() {
        this.renkDAO.remove(this.renk);
        this.renk = null;
    }

    public void temizle() {
        this.renk = null;

    }

    public void updateForm(telefonRenk renk) {
        this.renk = renk;
    }

    public void create() {

        this.getRenkDAO().insert(this.renk);
        temizle();

    }

    public List<telefonRenk> getRenkList() {
        this.renkList = this.getRenkDAO().findAll();

        return renkList;
    }

    public List<telefonRenk> telRenkList() {
        this.renkList = this.getRenkDAO().findAll(page, pageSize, 2);

        return renkList;
    }

    public void setRenkList(List<telefonRenk> renkList) {
        this.renkList = renkList;
    }

    public telefonRenkDAO getRenkDAO() {
        if (this.renkDAO == null) {
            this.renkDAO = new telefonRenkDAO();
        }
        return renkDAO;
    }

    public void setRenkDAO(telefonRenkDAO renkDAO) {
        this.renkDAO = renkDAO;
    }

    public telefonRenk getRenk() {
        if (this.renk == null) {
            this.renk = new telefonRenk();
        }
        return renk;
    }

    public void setRenk(telefonRenk renk) {
        this.renk = renk;
    }

}
