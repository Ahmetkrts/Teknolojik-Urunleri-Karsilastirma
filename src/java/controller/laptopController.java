/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.laptopDAO;
import entity.laptop;
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
public class laptopController implements Serializable{
    private List<laptop> laptopList;
    private laptopDAO laptopdao;
    private laptop laptop;

    public laptop getLaptop() {
        if (this.laptop==null) {
            this.laptop=new laptop();
        }
        return laptop;
    }

    public List<laptop> getLaptopList() {
        this.laptopList=getLaptopdao().findAll();
        return laptopList;
    }

    public laptopDAO getLaptopdao() {
        if (this.laptopdao==null) {
            this.laptopdao=new laptopDAO();
        }
        return laptopdao;
    }
    
}
