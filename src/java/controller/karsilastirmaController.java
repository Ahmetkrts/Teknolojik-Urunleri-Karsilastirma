/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.laptopDAO;
import DataAccess.telefonDAO;
import DataAccess.televizyonDAO;
import entity.laptop;
import entity.telefon;
import entity.televizyon;
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
public class karsilastirmaController implements Serializable {

    private Long selected1;
    private Long selected2;
    //-*-*-*-*-*-*-Laptop*-*-*-*-*-*-*-*
    private laptop laptop1;
    private laptop laptop2;
    private laptopDAO laptopDao;
    private List<laptop> laptopList;
    //-*-*-*-*-*-*-Laptop*-*-*-*-*-*-*-*
    //-*-*-*-*-*-*-Telefon*-*-*-*-*-*-*-*
    private telefon telefon1;
    private telefon telefon2;
    private telefonDAO telefonDao;
    private List<telefon> telefonList;
    //-*-*-*-*-*-*-Telefon*-*-*-*-*-*-*-*
    //-*-*-*-*-*-*-televizyon*-*-*-*-*-*-*-*
    private televizyon televizyon1;
    private televizyon televizyon2;
    private televizyonDAO televizyonDao;
    private List<televizyon> televizyonList;

    //-*-*-*-*-*-*-Televizyon*-*-*-*-*-*-*-*
    public String televizyonSec(Long id) {
        this.televizyon1 = getTelevizyonDao().find(id);
        this.televizyon2 = null;
        return "/televizyon-karsilastirma.xhtml";
    }

    public String karsilastirBaglan(String s) {
        this.laptop1 = null;
        this.laptop2 = null;
        this.telefon1 = null;
        this.telefon2 = null;
        this.televizyon1 = null;
        this.televizyon2 = null;
        return "/faces/" + s + "-karsilastirma?faces-redirect=true";
    }

    public void televizyon1sec() {
        this.televizyon1 = getTelevizyonDao().find(selected1);

    }

    public void televizyon2sec() {
        this.televizyon2 = getTelevizyonDao().find(selected2);

    }

    public String telefonSec(Long id) {
        this.telefon1 = getTelefonDao().find(id);
        this.telefon2 = null;
        return "/telefon-karsilastirma.xhtml";
    }

    public void telefon1sec() {
        this.telefon1 = getTelefonDao().find(selected1);

    }

    public void telefon2sec() {
        this.telefon2 = getTelefonDao().find(selected2);

    }

    public String laptopSec(Long id) {
        this.laptop1 = getLaptopDao().find(id);
        this.laptop2 = null;
        return "/laptop-karsilastirma.xhtml";
    }

    public void laptop1sec() {
        this.laptop1 = getLaptopDao().find(selected1);
        System.out.println("laptop 2: " + laptop1.getUrun_adi());
    }

    public void laptop2sec() {
        this.laptop2 = getLaptopDao().find(selected2);
        System.out.println("laptop 2: " + laptop2.getUrun_adi());

    }

    public laptop getLaptop1() {
        if (this.laptop1 == null) {
            this.laptop1 = new laptop();
        }
        return laptop1;
    }

    public void setLaptop1(laptop laptop1) {
        this.laptop1 = laptop1;
    }

    public laptop getLaptop2() {
        if (this.laptop2 == null) {
            this.laptop2 = new laptop();
        }
        return laptop2;
    }

    public void setLaptop2(laptop laptop2) {
        this.laptop2 = laptop2;
    }

    public laptopDAO getLaptopDao() {
        if (this.laptopDao == null) {
            this.laptopDao = new laptopDAO();
        }
        return laptopDao;
    }

    public void setLaptopDao(laptopDAO laptopDao) {
        this.laptopDao = laptopDao;
    }

    public List<laptop> getLaptopList() {
        if (this.laptopList == null) {
            this.laptopList = getLaptopDao().findAll(1, getLaptopDao().countSize(), 1);
        }
        return laptopList;
    }

    public void setLaptopList(List<laptop> laptopList) {
        this.laptopList = laptopList;
    }

    public Long getSelected1() {
        return selected1;
    }

    public void setSelected1(Long selected1) {
        this.selected1 = selected1;
    }

    public Long getSelected2() {
        return selected2;
    }

    public void setSelected2(Long selected2) {
        this.selected2 = selected2;
    }

    public telefon getTelefon1() {
        if (this.telefon1 == null) {
            this.telefon1 = new telefon();
        }
        return telefon1;
    }

    public void setTelefon1(telefon telefon1) {
        this.telefon1 = telefon1;
    }

    public telefon getTelefon2() {
        if (this.telefon2 == null) {
            this.telefon2 = new telefon();
        }
        return telefon2;
    }

    public void setTelefon2(telefon telefon2) {
        this.telefon2 = telefon2;
    }

    public telefonDAO getTelefonDao() {
        if (this.telefonDao == null) {
            this.telefonDao = new telefonDAO();
        }
        return telefonDao;
    }

    public void setTelefonDao(telefonDAO telefonDao) {
        this.telefonDao = telefonDao;
    }

    public List<telefon> getTelefonList() {
        this.telefonList = getTelefonDao().findAll(1, getTelefonDao().countSize(), 1);
        return telefonList;
    }

    public void setTelefonList(List<telefon> telefonList) {
        this.telefonList = telefonList;
    }

    public televizyon getTelevizyon1() {
        if (this.televizyon1 == null) {
            this.televizyon1 = new televizyon();

        }
        return televizyon1;
    }

    public void setTelevizyon1(televizyon televizyon1) {
        this.televizyon1 = televizyon1;
    }

    public televizyon getTelevizyon2() {
        if (this.televizyon2 == null) {
            this.televizyon2 = new televizyon();

        }
        return televizyon2;
    }

    public void setTelevizyon2(televizyon televizyon2) {
        this.televizyon2 = televizyon2;
    }

    public televizyonDAO getTelevizyonDao() {
        if (this.televizyonDao == null) {
            this.televizyonDao = new televizyonDAO();
        }
        return televizyonDao;
    }

    public void setTelevizyonDao(televizyonDAO televizyonDao) {
        this.televizyonDao = televizyonDao;
    }

    public List<televizyon> getTelevizyonList() {
        this.televizyonList = getTelevizyonDao().findAll(1, getTelefonDao().countSize(), 1);
        return televizyonList;
    }

    public void setTelevizyonList(List<televizyon> televizyonList) {
        this.televizyonList = televizyonList;
    }

}
