/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.telefonArkaKameraDao;
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
    private telefonArkaKameraDao arkaKameradao;
    private telefonArkaKamera arkaKamera;

    public String update(){
        this.getArkaKameradao().edit(this.arkaKamera);
        return "/module/telefon/ozellik/ozellik.xhtml";
    }
    public String temizle(){
        this.arkaKamera = null;
        return "arkaKameraForm";
    }
    public void updateForm(telefonArkaKamera kamera){
        this.arkaKamera = kamera;
    }
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

    public telefonArkaKameraDao getArkaKameradao() {
        if (this.arkaKameradao==null) {
            this.arkaKameradao=new telefonArkaKameraDao();
        }
        return arkaKameradao;
    }

    public void setArkaKameradao(telefonArkaKameraDao arkaKameradao) {
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
