package com.chatweb.comm.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SecurityFilter implements Filter {
    
    private static Set<String> GreenUrlSet = new HashSet<String>();


    @Override
    public void init(FilterConfig arg0) throws ServletException {
        GreenUrlSet.add("/login");
        GreenUrlSet.add("/register");
        GreenUrlSet.add("/index");
        GreenUrlSet.add("/forgotPassword");
        GreenUrlSet.add("/newPassword");
        GreenUrlSet.add("/tool");
    }

    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) srequest;
        String uri = request.getRequestURI();
        filterChain.doFilter(srequest, sresponse);
    }


    /**
     * @param url
     * @return
     * @author neo
     * @date 2016-5-4
     */
    private boolean containsSuffix(String url) {
        if (url.endsWith(".js")
                || url.endsWith(".css")
                || url.endsWith(".jpg")
                || url.endsWith(".gif")
                || url.endsWith(".png")
                || url.endsWith(".html")
                || url.endsWith(".eot")
                || url.endsWith(".svg")
                || url.endsWith(".ttf")
                || url.endsWith(".woff")
                || url.endsWith(".ico")
                || url.endsWith(".woff2")) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void destroy() {

    }

    public String codeToString(String str) {
        String strString = str;
        try {
            byte tempB[] = strString.getBytes("ISO-8859-1");
            strString = new String(tempB);
            return strString;
        } catch (Exception e) {
            return strString;
        }
    }


}