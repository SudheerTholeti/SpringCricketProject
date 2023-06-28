package com.skytech.cricket.controller;

import com.skytech.cricket.model.Player;
import com.skytech.cricket.rest.Implementation.RestPlayerServiceImpl;
import com.skytech.cricket.validator.PlayerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UpdatePlayerController {
    @Resource
    private RestPlayerServiceImpl restPlayerService;

    @Autowired
    private PlayerValidator playerValidator;

    @GetMapping(value = {"/edit/{id}","/getPlayers/edit/{id}"})
    public ModelAndView update(@PathVariable int id,ModelAndView modelAndView){
        Player player=restPlayerService.getPlayerById(id);
        modelAndView.addObject("player",player);
        modelAndView.setViewName("update");
        return modelAndView;
    }

    @PostMapping("/edit/update")
    public ModelAndView updatePlayer(@Valid @ModelAttribute Player player, BindingResult bindingResult, ModelAndView modelAndView){
        System.out.println("dfghdfgh");
        playerValidator.validate(player,bindingResult);
        if(bindingResult.hasErrors()){
            System.out.println("fhfhffg");
            modelAndView.setViewName("update");
            return modelAndView;
        }
        restPlayerService.updatePlayer(player);
        modelAndView.setViewName("redirect:/getList");
        return modelAndView;
    }

    @PostMapping("/getPlayers/edit/update")
    public ModelAndView updatePlayerData(@Valid @ModelAttribute Player player, BindingResult bindingResult, ModelAndView modelAndView, HttpServletRequest request ){
        HttpSession httpSession=request.getSession();
        playerValidator.validate(player,bindingResult);
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("update");
            return modelAndView;
        }
        String email= (String) httpSession.getAttribute("email");
        restPlayerService.updatePlayer(player);
        modelAndView.setViewName("redirect:/getPlayers/"+email);
        return modelAndView;
    }
}
