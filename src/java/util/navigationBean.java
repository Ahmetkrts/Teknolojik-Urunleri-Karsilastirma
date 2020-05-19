/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Casper
 */
@Named
@RequestScoped
public class navigationBean implements Serializable{
    
    public String page(String p)
    {
       return "/module/"+p+"/"+p+"?faces-redirct=true";
    
    }
    public String subPage(String page,String sub)
    {
       return "/module/"+page+"/"+sub+"/"+sub+".xhtml?faces-redirct=true";
    
    }
}
