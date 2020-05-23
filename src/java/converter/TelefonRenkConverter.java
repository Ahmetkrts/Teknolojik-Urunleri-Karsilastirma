/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;
import DataAccess.telefonRenkDAO;
import entity.telefonRenk;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author techn
 */
@FacesConverter(value = "telRenkConverter")
public class TelefonRenkConverter implements Converter{
    private telefonRenkDAO telRenkDAO;

    public telefonRenkDAO getTelRenkDAO() {
        if(this.telRenkDAO == null){
            this.telRenkDAO = new telefonRenkDAO();
        }
        return telRenkDAO;
    }

    public void setTelRenkDAO(telefonRenkDAO telRenkDAO) {
        this.telRenkDAO = telRenkDAO;
    }

    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getTelRenkDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        telefonRenk telRenk = (telefonRenk) value;
        return String.valueOf(telRenk.getRenk_id());
    }
    
}
