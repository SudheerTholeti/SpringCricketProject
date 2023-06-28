package com.skytech.cricket.controller;

import com.skytech.cricket.model.Player;
import com.skytech.cricket.rest.Implementation.RestPlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;

@Controller
public class DisplayPlayerController {
    @Autowired
    private RestPlayerServiceImpl restPlayerService;

    @GetMapping(value = {"/getList"})
    public ModelAndView getAll(ModelAndView modelAndView, Principal principal, HttpServletResponse response){
        String email=principal.getName();
        response.addCookie(new Cookie("Email",email));
        List<Player> list=restPlayerService.getPlayerList();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("display");
        return modelAndView;
    }

    @GetMapping("/getPlayer/getList")
    public ModelAndView getPlayerList(ModelAndView modelAndView){
        modelAndView.setViewName("redirect:/getList");
        return modelAndView;
    }
}
