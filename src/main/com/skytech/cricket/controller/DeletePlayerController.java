package com.skytech.cricket.controller;

import com.skytech.cricket.rest.Implementation.RestPlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class DeletePlayerController {
    @Autowired
    private RestPlayerServiceImpl restPlayerService;

    @GetMapping("/delete/{id}")
    public ModelAndView deletePlayers(@PathVariable int id,ModelAndView modelAndView){
        restPlayerService.deletePlayer(id);
        modelAndView.setViewName("redirect:/getList");
        return modelAndView;
    }
    @GetMapping("getPlayers/delete/{id}")
    public ModelAndView deletePlayer(@PathVariable int id,ModelAndView modelAndView){
        restPlayerService.deletePlayer(id);
        modelAndView.setViewName("deleteMessage");
        return modelAndView;
    }
}
