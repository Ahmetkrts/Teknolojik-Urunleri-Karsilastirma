/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.laptopDAO;
import entity.laptop;
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
public class laptopController implements Serializable {

    private List<laptop> laptop_list;
    private laptopDAO laptopdao;
    private laptop laptop;

    public void temizle() {
        this.laptop = null;
    }

    public void delete(laptop laptop) {
        this.laptopdao.remove(laptop);
        temizle();
    }

    public void updateForm(laptop laptop) {
        this.laptop = laptop;
    }

    public void update() {
        this.getLaptopdao().edit(this.laptop);
        temizle();
    }

    public void create() {
        this.getLaptopdao().insert(this.laptop);
        temizle();
    }

    public List<laptop> getLaptop_list() {
        this.laptop_list = this.getLaptopdao().findAll();
        return laptop_list;
    }

    public void setLaptop_list(List<laptop> laptop_list) {
        this.laptop_list = laptop_list;
    }

    public laptopDAO getLaptopdao() {
        if(this.laptopdao == null){
            this.laptopdao = new laptopDAO();
        }
        return laptopdao;
    }

    public void setLaptopdao(laptopDAO laptopdao) {
        this.laptopdao = laptopdao;
    }

    public laptop getLaptop() {
        if(this.laptop == null){
            this.laptop = new laptop();
        }
        return laptop;
    }

    public void setLaptop(laptop laptop) {
        this.laptop = laptop;
    }

    

}
