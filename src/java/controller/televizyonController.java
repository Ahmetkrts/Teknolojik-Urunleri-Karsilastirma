/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.televizyonDAO;
import entity.televizyon;
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

    public String TelevizyonOzellikleri(televizyon televizyon) {
        this.televizyon = televizyon;
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
        this.tv = this.getTelevizyon_list().get(0);
        return tv;
    }

    public void setTv(televizyon tv) {
        this.tv = tv;
    }

    public List<televizyon> getTelevizyon_list() {
        this.televizyon_list = this.getTelevizyondao().findAll();
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

}
