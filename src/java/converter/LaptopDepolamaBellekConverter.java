/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import DataAccess.laptopDepolamaBellekDAO;
import entity.laptopDepolamaBellek;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author techn
 */
@FacesConverter(value = "lapDepolamaBellekConverter")
public class LaptopDepolamaBellekConverter implements Converter {

    private laptopDepolamaBellekDAO lapDepolamaBellekDAO;

    public laptopDepolamaBellekDAO getLapDepolamaBellekDAO() {
        if (this.lapDepolamaBellekDAO == null) {
            this.lapDepolamaBellekDAO = new laptopDepolamaBellekDAO();
        }
        return lapDepolamaBellekDAO;
    }

    public void setLapDepolamaBellekDAO(laptopDepolamaBellekDAO lapDepolamaBellekDAO) {
        this.lapDepolamaBellekDAO = lapDepolamaBellekDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getLapDepolamaBellekDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        laptopDepolamaBellek lapDepolamaBellek = (laptopDepolamaBellek) value;
        return String.valueOf(lapDepolamaBellek.getDepolama_bellek_id());
    }

}
