/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author techn
 */
public class telefonIsletimSistemi {
    private Long isletim_sistemi_id;
    private String isletim_sistemi_versiyon;
    private String isletim_sistemi;

    public Long getIsletim_sistemi_id() {
        return isletim_sistemi_id;
    }

    public void setIsletim_sistemi_id(Long isletim_sistemi_id) {
        this.isletim_sistemi_id = isletim_sistemi_id;
    }

    public String getIsletim_sistemi_versiyon() {
        return isletim_sistemi_versiyon;
    }

    public void setIsletim_sistemi_versiyon(String isletim_sistemi_versiyon) {
        this.isletim_sistemi_versiyon = isletim_sistemi_versiyon;
    }

    public String getIsletim_sistemi() {
        return isletim_sistemi;
    }

    public void setIsletim_sistemi(String isletim_sistemi) {
        this.isletim_sistemi = isletim_sistemi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.isletim_sistemi_id);
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
        final telefonIsletimSistemi other = (telefonIsletimSistemi) obj;
        if (!Objects.equals(this.isletim_sistemi_id, other.isletim_sistemi_id)) {
            return false;
        }
        return true;
    }
    
}
