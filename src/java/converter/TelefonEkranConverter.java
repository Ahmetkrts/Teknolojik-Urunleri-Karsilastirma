/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import DataAccess.telefonEkranDAO;
import entity.telefonEkran;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author techn
 */
@FacesConverter(value = "telEkranConverter")
public class TelefonEkranConverter implements Converter{
    private telefonEkranDAO telEkranDAO;

    public telefonEkranDAO getTelEkranDAO() {
        if(telEkranDAO == null){
            this.telEkranDAO = new telefonEkranDAO();
        }
        return telEkranDAO;
    }

    public void setTelEkranDAO(telefonEkranDAO telEkranDAO) {
        this.telEkranDAO = telEkranDAO;
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getTelEkranDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        telefonEkran telEkran = (telefonEkran) value;
        return String.valueOf(telEkran.getEkran_id());
    }
    
}
