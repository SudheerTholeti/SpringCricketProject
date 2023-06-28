package com.skytech.cricket.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class SuccessHandler implements AuthenticationSuccessHandler {
    RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if(authentication.isAuthenticated()){
            Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
            for(GrantedAuthority grantedAuthority:authorities){
                if(grantedAuthority.getAuthority().equals("ROLE_ADMIN")){
                    redirectStrategy.sendRedirect(request,response,"/getList");
                }
                else if(grantedAuthority.getAuthority().equals("ROLE_USER")){
                    redirectStrategy.sendRedirect(request,response,"/user");
                }
                else{
                    redirectStrategy.sendRedirect(request,response,"/login");
                }
            }
        }
    }
}
