/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.telefonDao;
import entity.telefon;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author techn
 */
@Named
@SessionScoped
public class telefonController implements Serializable{
    
    private List<telefon> telefon_list;
    private telefonDao telefondao;
    private telefon telefon;

    public List<telefon> getTelefon_list() {
        this.telefon_list = this.getTelefondao().findAll();
        return telefon_list;
    }

    public void setTelefon_list(List<telefon> telefon_list) {
        this.telefon_list = telefon_list;
    }

    public telefonDao getTelefondao() {
        if(this.telefondao == null){
            this.telefondao = new telefonDao();
        }
        return telefondao;
    }

    public void setTelefondao(telefonDao telefondao) {
        this.telefondao = telefondao;
    }

    public telefon getTelefon() {
        if(this.telefon == null){
            this.telefon = new telefon();
        }
        return telefon;
    }

    public void setTelefon(telefon telefon) {
        this.telefon = telefon;
    }
    
}
