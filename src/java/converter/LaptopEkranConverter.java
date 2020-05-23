/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import DataAccess.laptopEkranDAO;
import entity.laptopEkran;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author techn
 */
@FacesConverter(value = "lapEkranConverter")
public class LaptopEkranConverter implements Converter {

    private laptopEkranDAO lapEkranDAO;

    public laptopEkranDAO getLapEkranDAO() {
        if (this.lapEkranDAO == null) {
            this.lapEkranDAO = new laptopEkranDAO();
        }
        return lapEkranDAO;
    }

    public void setLapEkranDAO(laptopEkranDAO lapEkranDAO) {
        this.lapEkranDAO = lapEkranDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getLapEkranDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        laptopEkran lapEkran = (laptopEkran) value;
        return String.valueOf(lapEkran.getEkran_id());
    }

}
