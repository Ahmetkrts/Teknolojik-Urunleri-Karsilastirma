/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import DataAccess.telefonArkaKameraDAO;
import entity.telefonArkaKamera;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author techn
 */
@FacesConverter(value = "telArkaKameraConverter")
public class TelefonArkaKameraConverter implements Converter{
    private telefonArkaKameraDAO telArkaKameraDAO;

    public telefonArkaKameraDAO getTelArkaKameraDAO() {
        if(this.telArkaKameraDAO == null){
            this.telArkaKameraDAO = new telefonArkaKameraDAO();
        }
        return telArkaKameraDAO;
    }

    public void setTelArkaKameraDAO(telefonArkaKameraDAO telArkaKameraDAO) {
        this.telArkaKameraDAO = telArkaKameraDAO;
    }

    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getTelArkaKameraDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        telefonArkaKamera telArkaKamera = (telefonArkaKamera) value;
        return String.valueOf(telArkaKamera.getKamera_id());
    }
    
}
