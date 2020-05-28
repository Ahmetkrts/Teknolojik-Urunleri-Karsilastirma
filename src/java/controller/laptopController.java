/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.laptopDAO;
import entity.laptop;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;

/**
 *
 * @author techn
 */
@Named
@SessionScoped
public class laptopController implements Serializable {

    private List<laptop> laptop_list;
    private laptopDAO laptopdao;
    private laptop laptop;
    private laptop lp;
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

    public String laptopOzellikleri(laptop laptop) {
        this.laptop = laptop;
        return "laptop-ozellikleri.xhtml";
    }

    public laptop getLp() {
        if (!getLaptop_list().isEmpty()) {
            this.lp = getLaptop_list().get(0);
        }
        return lp;
    }

    public void setLp(laptop lp) {
        this.lp = lp;
    }

    public void temizle() {
        this.laptop = null;
    }

    public void delete(laptop laptop) {
        this.laptopdao.remove(laptop);
        temizle();
    }

    public void updateForm(laptop laptop) {
        this.laptop = laptop;
    }

    public void update() {
        this.getLaptopdao().edit(this.laptop);
        temizle();
    }

    public void create() {
        this.getLaptopdao().insert(this.laptop);
        temizle();
    }

    public List<laptop> getLaptop_list() {
        this.laptop_list = this.getLaptopdao().findAll(page, pageSize, 2);
        return laptop_list;
    }

    public void setLaptop_list(List<laptop> laptop_list) {
        this.laptop_list = laptop_list;
    }

    public laptopDAO getLaptopdao() {
        if (this.laptopdao == null) {
            this.laptopdao = new laptopDAO();
        }
        return laptopdao;
    }

    public void setLaptopdao(laptopDAO laptopdao) {
        this.laptopdao = laptopdao;
    }

    public laptop getLaptop() {
        if (this.laptop == null) {
            this.laptop = new laptop();
        }
        return laptop;
    }

    public void setLaptop(laptop laptop) {
        this.laptop = laptop;
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
        this.pageCount = (int) Math.ceil(this.getLaptopdao().countSize() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
