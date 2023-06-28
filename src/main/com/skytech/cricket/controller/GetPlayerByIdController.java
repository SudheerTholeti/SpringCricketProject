package com.skytech.cricket.controller;

import com.skytech.cricket.model.Player;
import com.skytech.cricket.rest.Implementation.RestPlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class GetPlayerByIdController {
    @Autowired
    private RestPlayerServiceImpl restPlayerService;

    @GetMapping(value = "/getPlayer/{id}")
    public ModelAndView getById(@PathVariable int id,ModelAndView modelAndView){
        Player player=restPlayerService.getPlayerById(id);
        modelAndView.addObject(player);
        modelAndView.setViewName("displayPlayer");
        return modelAndView;
    }
    @GetMapping("/user")
    public String user(Model model, Principal principal, HttpServletResponse response){
        String email=principal.getName();
        response.addCookie(new Cookie("email",principal.getName()));
        model.addAttribute("email",email);
        return "user";
    }

    @GetMapping("/getPlayers/{email}")
    public ModelAndView getPlayerByName(@PathVariable String email, ModelAndView modelAndView, HttpServletRequest request ){
        HttpSession session=request.getSession();
        session.setAttribute("email",email);
        Player player=restPlayerService.details(email);
        modelAndView.addObject("player",player);
        modelAndView.setViewName("playerData");
        return modelAndView;
    }



}
