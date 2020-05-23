/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import DataAccess.televizyonIslettimSistemiDAO;
import entity.televizyonIslettimSistemi;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author techn
 */
@FacesConverter(value = "teleIsletimSistemiConverter")
public class TelevizyonIsletimSistemiConverter implements Converter {

    private televizyonIslettimSistemiDAO teleIslettimSistemiDAO;

    public televizyonIslettimSistemiDAO getTeleIslettimSistemiDAO() {
        if (this.teleIslettimSistemiDAO == null) {
            this.teleIslettimSistemiDAO = new televizyonIslettimSistemiDAO();
        }
        return teleIslettimSistemiDAO;
    }

    public void setTeleIslettimSistemiDAO(televizyonIslettimSistemiDAO teleIslettimSistemiDAO) {
        this.teleIslettimSistemiDAO = teleIslettimSistemiDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getTeleIslettimSistemiDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        televizyonIslettimSistemi teleIsletimSistemi = (televizyonIslettimSistemi) value;
        return String.valueOf(teleIsletimSistemi.getIsletim_sistemi_id());
    }

}
