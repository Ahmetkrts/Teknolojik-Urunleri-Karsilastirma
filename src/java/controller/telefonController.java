/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.telefonDAO;
import entity.telefon;
import java.io.Serializable;
import java.sql.SQLException;
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
    private Long selectEkran;
    private Long selectBatarya;
    private Long selectIslemci;
    private Long selectArkaKamera;
    private Long selectOnKamera;
    private Long selectIsletimSistemi;
    private List<Long> selectRenkList;

   

    public void create()  {
        this.getTelefondao().insert(this.telefon, this.selectEkran,this.selectBatarya,this.selectIslemci,this.selectArkaKamera,this.selectOnKamera,this.selectIsletimSistemi,this.selectRenkList);
        
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

    public Long getSelectEkran() {
        return selectEkran;
    }

    public void setSelectEkran(Long selectEkran) {
        this.selectEkran = selectEkran;
    }

    public Long getSelectBatarya() {
        return selectBatarya;
    }

    public void setSelectBatarya(Long selectBatarya) {
        this.selectBatarya = selectBatarya;
    }

    public Long getSelectIslemci() {
        return selectIslemci;
    }

    public void setSelectIslemci(Long selectIslemci) {
        this.selectIslemci = selectIslemci;
    }

    public Long getSelectArkaKamera() {
        return selectArkaKamera;
    }

    public void setSelectArkaKamera(Long selectArkaKamera) {
        this.selectArkaKamera = selectArkaKamera;
    }

    public Long getSelectOnKamera() {
        return selectOnKamera;
    }

    public void setSelectOnKamera(Long selectOnKamera) {
        this.selectOnKamera = selectOnKamera;
    }

    public Long getSelectIsletimSistemi() {
        return selectIsletimSistemi;
    }

    public void setSelectIsletimSistemi(Long selectIsletimSistemi) {
        this.selectIsletimSistemi = selectIsletimSistemi;
    }
     public List<Long> getSelectRenkList() {
        return selectRenkList;
    }

    public void setSelectRenkList(List<Long> selectRenkList) {
        this.selectRenkList = selectRenkList;
    }

}
