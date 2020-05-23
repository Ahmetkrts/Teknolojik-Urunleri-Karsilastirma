/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import DataAccess.laptopEkranKartiDAO;
import entity.laptopEkranKarti;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author techn
 */
@FacesConverter(value = "lapEkranKartiConverter")
public class LaptopEkranKartiConverter implements Converter {

    private laptopEkranKartiDAO lapEkranKartiDAO;

    public laptopEkranKartiDAO getLapEkranKartiDAO() {
        if (this.lapEkranKartiDAO == null) {
            this.lapEkranKartiDAO = new laptopEkranKartiDAO();
        }
        return lapEkranKartiDAO;
    }

    public void setLapEkranKartiDAO(laptopEkranKartiDAO lapEkranKartiDAO) {
        this.lapEkranKartiDAO = lapEkranKartiDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getLapEkranKartiDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        laptopEkranKarti lapEkranKarti = (laptopEkranKarti) value;
        return String.valueOf(lapEkranKarti.getEkran_karti_id());
    }

}
