/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import DataAccess.DosyaDAO;
import entity.Dosya;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author techn
 */
@FacesConverter(value = "telResim")
public class TelefonDosyaConverter implements Converter {

    private DosyaDAO telDosyaDAO;

    public DosyaDAO getTelDosyaDAO() {
        if (this.telDosyaDAO == null) {
            this.telDosyaDAO = new DosyaDAO();
        }
        return telDosyaDAO;
    }

    public void setTelDosyaDAO(DosyaDAO telDosyaDAO) {
        this.telDosyaDAO = telDosyaDAO;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getTelDosyaDAO().telefonFind(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Dosya Resim = (Dosya) value;
        return String.valueOf(Resim.getDosya_id());
    }

}
