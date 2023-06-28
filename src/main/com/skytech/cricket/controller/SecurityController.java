package com.skytech.cricket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SecurityController {

    @RequestMapping(value = {"/login","/getPlayers/login","/getPlayers/delete/login"})
    public String logIn(){
        return "login";
    }

    @RequestMapping("/error")
    public String error(Model model){
       model.addAttribute("msg","Invalid login credentials. Please try again!");
        return "login";
    }

    @RequestMapping(value = {"/logOut"})
    public String logOut(Model model, HttpServletRequest request, HttpServletResponse response){
       Cookie[] cookie= request.getCookies();
       if(cookie!=null) {
           for (Cookie cookie1 : cookie) {
               cookie1.setMaxAge(0);
               response.addCookie(cookie1);
           }
       }
        model.addAttribute("msg","Logout Successfull!");
        return "logout";
    }

    @RequestMapping("/getPlayers/logOut")
    public String securityLogout(){
        return "redirect:/logOut";
    }
}
