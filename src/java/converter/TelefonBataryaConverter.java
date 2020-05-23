/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import DataAccess.telefonBataryaDAO;
import entity.telefonBatarya;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author techn
 */
@FacesConverter(value = "telBataryaConverter")
public class TelefonBataryaConverter implements Converter{
    private telefonBataryaDAO telBataryaDAO;

    public telefonBataryaDAO getTelBataryaDAO() {
        if(this.telBataryaDAO == null){
            this.telBataryaDAO = new telefonBataryaDAO();
        }
        return telBataryaDAO;
    }

    public void setTelBataryaDAO(telefonBataryaDAO telBataryaDAO) {
        this.telBataryaDAO = telBataryaDAO;
    }

    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getTelBataryaDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        telefonBatarya telBatarya = (telefonBatarya) value;
        return String.valueOf(telBatarya.getBatarya_id());
    }
    
}
