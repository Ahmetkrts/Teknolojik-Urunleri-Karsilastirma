/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.televizyonDAO;
import DataAccess.yorumDAO;
import entity.televizyon;
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
public class televizyonController implements Serializable {

    private List<televizyon> televizyon_list;
    private televizyonDAO televizyondao;
    private televizyon televizyon;
    private televizyon tv;
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;
    private yorumDAO yorumdao;
    private yorum yorum;

    public void yoruminsert() {
        getYorumdao().insert(yorum, this.televizyon.getTelevizyon_id(), "televizyon");
        TelevizyonOzellikleri(this.televizyon.getTelevizyon_id());
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

    public String TelevizyonOzellikleri(Long id) {
        this.televizyon = getTelevizyondao().find(id);
        return "televizyon-ozellikleri.xhtml";
    }

    public void temizle() {
        this.televizyon = null;
    }

    public void delete() {
        this.televizyondao.remove(this.televizyon);
        this.televizyon = null;
    }

    public void updateForm(televizyon tel) {
        this.televizyon = tel;
    }

    public void update() {
        this.getTelevizyondao().edit(this.televizyon);

    }

    public void create() {
        this.getTelevizyondao().insert(this.televizyon);
        temizle();
    }

    public televizyon getTv() {
        if (!this.getTelevizyon_list().isEmpty()) {
            this.tv = this.getTelevizyon_list().get(0);
        }
        return tv;
    }

    public void setTv(televizyon tv) {
        this.tv = tv;
    }

    public List<televizyon> getTelevizyon_list() {
        this.televizyon_list = this.getTelevizyondao().findAll(page, pageSize, 1);
        return televizyon_list;
    }

    public void setTelevizyon_list(List<televizyon> televizyon_list) {
        this.televizyon_list = televizyon_list;
    }

    public televizyonDAO getTelevizyondao() {
        if (this.televizyondao == null) {
            this.televizyondao = new televizyonDAO();
        }
        return televizyondao;
    }

    public void setTelevizyondao(televizyonDAO televizyondao) {
        this.televizyondao = televizyondao;
    }

    public televizyon getTelevizyon() {
        if (this.televizyon == null) {
            this.televizyon = new televizyon();
        }
        return televizyon;
    }

    public void setTelevizyon(televizyon televizyon) {
        this.televizyon = televizyon;
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
        this.pageCount = (int) Math.ceil(this.getTelevizyondao().countSize() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
