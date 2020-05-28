/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.telefonOnKameraDAO;
import entity.telefonOnKamera;
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
public class telefonOnKameraController implements Serializable {

    private List<telefonOnKamera> onKameraList;
    private telefonOnKameraDAO onKameradao;
    private telefonOnKamera onKamera;
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
        this.pageCount = (int) Math.ceil(this.getOnKameradao().countSize() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void update() {
        this.onKameradao.edit(this.onKamera);

    }

    public void delete() {
        this.onKameradao.remove(this.onKamera);
        this.onKamera = null;
    }

    public void temizle() {
        this.onKamera = null;

    }

    public void updateForm(telefonOnKamera onKamera) {
        this.onKamera = onKamera;
    }

    public void create() {
        this.getOnKameradao().insert(this.onKamera);
        temizle();
    }

    public List<telefonOnKamera> getOnKameraList() {
        this.onKameraList = this.getOnKameradao().findAll();
        return onKameraList;
    }

    public List<telefonOnKamera> telOnKameraList() {
        this.onKameraList = this.getOnKameradao().findAll(page, pageSize, 2);
        return onKameraList;
    }

    public void setOnKameraList(List<telefonOnKamera> onKameraList) {
        this.onKameraList = onKameraList;
    }

    public telefonOnKameraDAO getOnKameradao() {
        if (this.onKameradao == null) {
            this.onKameradao = new telefonOnKameraDAO();
        }
        return onKameradao;
    }

    public void setOnKameradao(telefonOnKameraDAO onKameradao) {
        this.onKameradao = onKameradao;
    }

    public telefonOnKamera getOnKamera() {
        if (this.onKamera == null) {
            this.onKamera = new telefonOnKamera();
        }
        return onKamera;
    }

    public void setOnKamera(telefonOnKamera onKamera) {
        this.onKamera = onKamera;
    }

}
