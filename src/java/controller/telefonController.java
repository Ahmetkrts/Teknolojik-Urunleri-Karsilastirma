/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.telefonDAO;
import entity.telefon;
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

    public String telefonOzellikleri(telefon telefon) {
        this.telefon = telefon;
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
        this.telefon_list = this.getTelefondao().findAll();
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

}
