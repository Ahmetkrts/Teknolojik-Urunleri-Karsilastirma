/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import DataAccess.telefonIsletimSistemiDAO;
import entity.telefonIsletimSistemi;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author techn
 */
@FacesConverter(value = "telIsletimSistemiConverter")
public class TelefonIsletimSistemiConverter implements Converter{
    private telefonIsletimSistemiDAO telIsletimSistemiDAO;

    public telefonIsletimSistemiDAO getTelIsletimSistemiDAO() {
        if(this.telIsletimSistemiDAO == null){
            this.telIsletimSistemiDAO = new telefonIsletimSistemiDAO();
        }
        return telIsletimSistemiDAO;
    }

    public void setTelIsletimSistemiDAO(telefonIsletimSistemiDAO telIsletimSistemiDAO) {
        this.telIsletimSistemiDAO = telIsletimSistemiDAO;
    }

    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getTelIsletimSistemiDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        telefonIsletimSistemi telIsletimSistemi = (telefonIsletimSistemi) value;
        return String.valueOf(telIsletimSistemi.getIsletim_sistemi_id());
    }
    
}
