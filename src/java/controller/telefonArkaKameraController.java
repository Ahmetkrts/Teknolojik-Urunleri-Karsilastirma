/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.telefonArkaKameraDAO;
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
public class telefonArkaKameraController implements Serializable{
    private List<telefonArkaKamera> arkaKameraList;
    private telefonArkaKameraDAO arkaKameradao;
    private telefonArkaKamera arkaKamera;

    public String create()
    {
        this.getArkaKameradao().insert(this.arkaKamera);
        return "/module/telefon/ozellik/ozellik.xhtml";
    }
    public List<telefonArkaKamera> getArkaKameraList() {
        this.arkaKameraList=this.getArkaKameradao().findAll();
        return arkaKameraList;
    }

    public void setArkaKameraList(List<telefonArkaKamera> arkaKameraList) {
        this.arkaKameraList = arkaKameraList;
    }

    public telefonArkaKameraDAO getArkaKameradao() {
        if (this.arkaKameradao==null) {
            this.arkaKameradao=new telefonArkaKameraDAO();
        }
        return arkaKameradao;
    }

    public void setArkaKameradao(telefonArkaKameraDAO arkaKameradao) {
        this.arkaKameradao = arkaKameradao;
    }

    public telefonArkaKamera getArkaKamera() {
        if (this.arkaKamera==null) {
            this.arkaKamera=new telefonArkaKamera();
        }
        return arkaKamera;
    }

    public void setArkaKamera(telefonArkaKamera arkaKamera) {
        this.arkaKamera = arkaKamera;
    }
    
    
}
