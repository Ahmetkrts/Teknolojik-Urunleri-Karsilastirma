/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import DataAccess.telefonOnKameraDAO;
import entity.telefonOnKamera;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author techn
 */
@FacesConverter(value = "telOnKameraConverter")
public class TelefonOnKameraConverter implements Converter {

    private telefonOnKameraDAO telOnKameraDAO;

    public telefonOnKameraDAO getTelOnKameraDAO() {
        if (this.telOnKameraDAO == null) {
            this.telOnKameraDAO = new telefonOnKameraDAO();
        }
        return telOnKameraDAO;
    }

    public void setTelOnKameraDAO(telefonOnKameraDAO telOnKameraDAO) {
        this.telOnKameraDAO = telOnKameraDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getTelOnKameraDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        telefonOnKamera telOnKamera = (telefonOnKamera) value;
        return String.valueOf(telOnKamera.getKamera_id());
    }

}
