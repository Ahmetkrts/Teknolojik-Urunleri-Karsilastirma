/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.telefonOnKameraDAO;
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

    public String create() {
        this.getOnKameradao().insert(this.onKamera);
        return "/module/telefon/ozellik/ozellik.xhtml";
    }

    public List<telefonOnKamera> getOnKameraList() {
        this.onKameraList = this.getOnKameradao().findAll();
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
