/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;
import DataAccess.telefonIslemciDAO;
import entity.telefonIslemci;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author techn
 */
@FacesConverter(value = "telIslemciConverter")
public class TelefonIslemciConverter implements Converter{
    private telefonIslemciDAO telisIslemciDAO;

    public telefonIslemciDAO getTelisIslemciDAO() {
        if(this.telisIslemciDAO == null){
            this.telisIslemciDAO = new telefonIslemciDAO();
        }
        return telisIslemciDAO;
    }

    public void setTelisIslemciDAO(telefonIslemciDAO telisIslemciDAO) {
        this.telisIslemciDAO = telisIslemciDAO;
    }

    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getTelisIslemciDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        telefonIslemci telIslemci = (telefonIslemci) value;
        return String.valueOf(telIslemci.getIslemci_id());
    }
    
}
