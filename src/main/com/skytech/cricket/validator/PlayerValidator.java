package com.skytech.cricket.validator;

import com.skytech.cricket.model.Player;
import com.skytech.cricket.rest.Implementation.RestPlayerServiceImpl;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class PlayerValidator implements Validator {

    RestPlayerServiceImpl restPlayerService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Player.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Player player= (Player) target;
        int age=player.getAge();
        String email=player.getEmail();
        String name=player.getName();
        int noOfMatches=player.getNoOfMatches();
        ValidationUtils.rejectIfEmpty(errors,"role","player.role.empty");
        ValidationUtils.rejectIfEmpty(errors,"password","player.password.empty");
        if(age<18||age>50){
           errors.rejectValue("age","player.age.range.invalid");
        }
        if(!name.matches("^[a-z A-Z]{3,20}$")){
            errors.rejectValue("name" ,"player.name.matches");
        }
        if(noOfMatches<=0){
            errors.rejectValue("noOfMatches","player.noOfMatches.range.invalid");
        }

        if (email!=null && !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z]+\\.[a-zA-Z]{2,3}$")) {
            errors.rejectValue("email", "player.email.matches");
        }

        if(email!=null && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z]+\\.[a-zA-Z]{2,3}$")) {
            Player player1 = restPlayerService.details(email);
            if(player1!=null){
                errors.rejectValue("email","player.email.present");
            }
        }
    }

    public RestPlayerServiceImpl getRestPlayerService() {
        return restPlayerService;
    }

    public void setRestPlayerService(RestPlayerServiceImpl restPlayerService) {
        this.restPlayerService = restPlayerService;
    }
}
