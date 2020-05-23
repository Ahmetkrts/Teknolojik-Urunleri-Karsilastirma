/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import DataAccess.laptopIslemciDAO;
import entity.laptopIslemci;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author techn
 */
@FacesConverter(value = "lapIslemciConverter")
public class LaptopIslemciConverter implements Converter {

    private laptopIslemciDAO lapIslemciDAO;

    public laptopIslemciDAO getLapIslemciDAO() {
        if (this.lapIslemciDAO == null) {
            this.lapIslemciDAO = new laptopIslemciDAO();
        }
        return lapIslemciDAO;
    }

    public void setLapIslemciDAO(laptopIslemciDAO lapIslemciDAO) {
        this.lapIslemciDAO = lapIslemciDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getLapIslemciDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        laptopIslemci lapIslemci = (laptopIslemci) value;
        return String.valueOf(lapIslemci.getIslemci_id());
    }

}
