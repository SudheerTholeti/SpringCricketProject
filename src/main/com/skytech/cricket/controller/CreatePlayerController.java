package com.skytech.cricket.controller;

import com.skytech.cricket.model.Player;
import com.skytech.cricket.rest.Implementation.RestPlayerServiceImpl;
import com.skytech.cricket.validator.PlayerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class CreatePlayerController {

    @Autowired
    PlayerValidator playerValidator;
    @Autowired
    private RestPlayerServiceImpl restPlayerService;

    @RequestMapping(value = {"/start"})
    public String getRegister(Model model){
        model.addAttribute("player", new Player());
       return "home" ;
    }

    @PostMapping("/entry")
    public ModelAndView registerPlayer(@Valid @ModelAttribute Player player, BindingResult bindingResult, ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {

        playerValidator.validate(player, bindingResult);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("home");
            return modelAndView;
        }

        response.addCookie(new Cookie("Name",player.getName()));
        response.addCookie(new Cookie("Role",player.getRole()));
        response.addCookie(new Cookie("Email",player.getEmail()));
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("name", player.getName());
        String password = restPlayerService.encryptPassword(player.getPassword());
        player.setPassword(password);
        player.setAuthority("ROLE_USER");
        int count = restPlayerService.createPlayer(player);
        if (count > 0){
            modelAndView.addObject("msg", " registered Successfully....!");
        }else {
            modelAndView.addObject("msg", " Data is not inserted....!");
        }
        modelAndView.setViewName("successfull");
        return modelAndView;

    }

    @GetMapping(value = {"/getPlayers/start","/getPlayers/delete/start"})
    public ModelAndView insert(ModelAndView modelAndView){
        modelAndView.setViewName("redirect:/start");
        return modelAndView;
    }

}
