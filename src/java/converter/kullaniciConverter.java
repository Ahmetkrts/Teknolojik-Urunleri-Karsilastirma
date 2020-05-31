/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import DataAccess.kullaniciDAO;
import entity.kullanici;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author techn
 */
@FacesConverter(value = "kullaniciConverter")
public class kullaniciConverter implements Converter {

    private kullaniciDAO kulDAO;

    public kullaniciDAO getkulDAO() {
        if (this.kulDAO == null) {
            this.kulDAO = new kullaniciDAO();
        }
        return kulDAO;
    }

    public void setkulDAO(kullaniciDAO kulDAO) {
        this.kulDAO = kulDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getkulDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        kullanici kul = (kullanici) value;
        return String.valueOf(kul.getKullanici_id());
    }

}
