/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.telefonDAO;
import DataAccess.yorumDAO;
import entity.telefon;
import entity.yorum;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author techn
 */
@Named
@SessionScoped
public class telefonController implements Serializable {

    private List<telefon> telefon_list;
    private telefonDAO telefondao;
    private telefon telefon;
    private telefon tl;
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;
    private yorumDAO yorumdao;
    private yorum yorum;

    public void yoruminsert() {
        getYorumdao().insert(yorum, this.telefon.getTelefon_id(), "telefon");
        telefonOzellikleri(this.telefon.getTelefon_id());
        this.yorum = new yorum();
    }

    public yorum getYorum() {
        if (this.yorum == null) {
            this.yorum = new yorum();
        }
        return yorum;
    }

    public void setYorum(yorum yorum) {
        this.yorum = yorum;
    }

    public yorumDAO getYorumdao() {
        if (this.yorumdao == null) {
            this.yorumdao = new yorumDAO();
        }
        return yorumdao;
    }

    public void setYorumdao(yorumDAO yorumdao) {
        this.yorumdao = yorumdao;
    }

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

    public String telefonOzellikleri(Long id) {
        this.telefon = getTelefondao().find(id);
        return "telefon-ozellikleri.xhtml";
    }

    public void temizle() {
        this.telefon = null;
    }

    public void delete() {
        this.telefondao.remove(this.telefon);
        this.telefon = null;
        temizle();
    }

    public void updateForm(telefon tel) {
        this.telefon = tel;
    }

    public void update() {
        this.getTelefondao().edit(this.telefon);
        temizle();
    }

    public void create() {
        this.getTelefondao().insert(this.telefon);
        temizle();
    }

    public telefon getTl() {
        if (!this.getTelefon_list().isEmpty()) {
            this.tl = this.getTelefon_list().get(0);
        }
        return tl;
    }

    public void setTl(telefon tl) {
        this.tl = tl;
    }

    public List<telefon> getTelefon_list() {
        this.telefon_list = this.getTelefondao().findAll(page, pageSize, 2);
        return telefon_list;
    }

    public void setTelefon_list(List<telefon> telefon_list) {
        this.telefon_list = telefon_list;
    }

    public telefonDAO getTelefondao() {
        if (this.telefondao == null) {
            this.telefondao = new telefonDAO();
        }
        return telefondao;
    }

    public void setTelefondao(telefonDAO telefondao) {
        this.telefondao = telefondao;
    }

    public telefon getTelefon() {
        if (this.telefon == null) {
            this.telefon = new telefon();
        }
        return telefon;
    }

    public void setTelefon(telefon telefon) {
        this.telefon = telefon;
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
        this.pageCount = (int) Math.ceil(this.getTelefondao().countSize() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
