/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import DataAccess.laptopBaglantiDAO;
import entity.laptopBaglanti;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author techn
 */
@FacesConverter(value = "lapBaglantiConverter")
public class LaptopBaglantiConverter implements Converter {

    private laptopBaglantiDAO lapBaglantiDAO;

    public laptopBaglantiDAO getLapBaglantiDAO() {
        if (this.lapBaglantiDAO == null) {
            this.lapBaglantiDAO = new laptopBaglantiDAO();
        }
        return lapBaglantiDAO;
    }

    public void setLapBaglantiDAO(laptopBaglantiDAO lapBaglantiDAO) {
        this.lapBaglantiDAO = lapBaglantiDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getLapBaglantiDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        laptopBaglanti lapBaglanti = (laptopBaglanti) value;
        return String.valueOf(lapBaglanti.getBaglanti_id());
    }

}
