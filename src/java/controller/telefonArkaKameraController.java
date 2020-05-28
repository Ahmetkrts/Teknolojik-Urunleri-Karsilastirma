/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.telefonArkaKameraDAO;
import entity.telefonArkaKamera;
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
public class telefonArkaKameraController implements Serializable {

    private List<telefonArkaKamera> arkaKameraList;
    private telefonArkaKameraDAO arkaKameradao;
    private telefonArkaKamera arkaKamera;
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
        this.pageCount = (int) Math.ceil(this.getArkaKameradao().countSize() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void update() {
        this.getArkaKameradao().edit(this.arkaKamera);

    }

    public void delete() {
        this.arkaKameradao.remove(this.arkaKamera);
        this.arkaKamera = null;
    }

    public void temizle() {
        this.arkaKamera = null;

    }

    public void updateForm(telefonArkaKamera kamera) {
        this.arkaKamera = kamera;
    }

    public void create() {
        this.getArkaKameradao().insert(this.arkaKamera);
        temizle();
    }

    public List<telefonArkaKamera> getArkaKameraList() {
        this.arkaKameraList = this.getArkaKameradao().findAll();
        return arkaKameraList;
    }

    public List<telefonArkaKamera> telKameraList() {
        this.arkaKameraList = this.getArkaKameradao().findAll(page, pageSize, 2);
        return arkaKameraList;
    }

    public void setArkaKameraList(List<telefonArkaKamera> arkaKameraList) {
        this.arkaKameraList = arkaKameraList;
    }

    public telefonArkaKameraDAO getArkaKameradao() {
        if (this.arkaKameradao == null) {
            this.arkaKameradao = new telefonArkaKameraDAO();
        }
        return arkaKameradao;
    }

    public void setArkaKameradao(telefonArkaKameraDAO arkaKameradao) {
        this.arkaKameradao = arkaKameradao;
    }

    public telefonArkaKamera getArkaKamera() {
        if (this.arkaKamera == null) {
            this.arkaKamera = new telefonArkaKamera();
        }
        return arkaKamera;
    }

    public void setArkaKamera(telefonArkaKamera arkaKamera) {
        this.arkaKamera = arkaKamera;
    }

}
