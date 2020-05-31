/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.kullanici;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Casper
 */
@WebFilter("/*")
public class loginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) sr;
        HttpServletResponse res = (HttpServletResponse) sr1;
        String url = req.getRequestURI();
        kullanici kul = (kullanici) req.getSession().getAttribute("valid_kullanici");
        
        if (kul == null) {
            if (url.contains("ebadmin") || url.contains("logout")) {
                res.sendRedirect(req.getContextPath() + "/faces/login.xhtml");
            } else {
                fc.doFilter(sr, sr1);
            }
        } else {
            if (url.contains("login") || url.contains("register")) {
                res.sendRedirect(req.getContextPath() + "/faces/ebadmin/index.xhtml");
            } else if (url.contains("logout")) {
                req.getSession().invalidate();
                res.sendRedirect(req.getContextPath() + "/faces/index.xhtml");
            } else {
                fc.doFilter(sr, sr1);
            }
        }
    }

}
