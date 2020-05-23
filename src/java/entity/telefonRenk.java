/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Casper
 */
public class telefonRenk {
    private Long renk_id;
    private String renk_adi;

    public Long getRenk_id() {
        return renk_id;
    }

    public void setRenk_id(Long renk_id) {
        this.renk_id = renk_id;
    }

    public String getRenk_adi() {
        return renk_adi;
    }

    public void setRenk_adi(String renk_adi) {
        this.renk_adi = renk_adi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.renk_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final telefonRenk other = (telefonRenk) obj;
        if (!Objects.equals(this.renk_id, other.renk_id)) {
            return false;
        }
        return true;
    }
    
}
