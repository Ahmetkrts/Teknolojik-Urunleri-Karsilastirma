/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import DataAccess.televizyonEkranDAO;
import entity.televizyonEkran;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author techn
 */
@FacesConverter(value = "teleEkranConverter")
public class TelevizyonEkranConverter implements Converter {

    private televizyonEkranDAO teleEkranDAO;

    public televizyonEkranDAO getTeleEkranDAO() {
        if (this.teleEkranDAO == null) {
            this.teleEkranDAO = new televizyonEkranDAO();
        }
        return teleEkranDAO;
    }

    public void setTeleEkranDAO(televizyonEkranDAO teleEkranDAO) {
        this.teleEkranDAO = teleEkranDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getTeleEkranDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        televizyonEkran teleEkran = (televizyonEkran) value;
        return String.valueOf(teleEkran.getEkran_id());
    }

}
