/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import DataAccess.laptopPilDAO;
import entity.laptopPil;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author techn
 */
@FacesConverter(value = "lapPilConverter")
public class LaptopPilConverter implements Converter {

    private laptopPilDAO lapPilDAO;

    public laptopPilDAO getLapPilDAO() {
        if (this.lapPilDAO == null) {
            this.lapPilDAO = new laptopPilDAO();
        }
        return lapPilDAO;
    }

    public void setLapPilDAO(laptopPilDAO lapPilDAO) {
        this.lapPilDAO = lapPilDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getLapPilDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        laptopPil lapPil = (laptopPil) value;
        return String.valueOf(lapPil.getPil_id());
    }

}
