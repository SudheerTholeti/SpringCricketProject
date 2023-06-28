package com.skytech.cricket.rest.Implementation;

import com.skytech.cricket.model.Player;
import com.skytech.cricket.rest.RestPlayerService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestPlayerServiceImpl implements RestPlayerService {

    private RestTemplate restTemplate;

    @Override
    public List<Player> getPlayerList() {
        List<Player> list=restTemplate.getForObject(url,List.class);
        return list;
    }

    @Override
    public Player getPlayerById(int id) {
        Player player=restTemplate.getForObject(url+id,Player.class);
        return player;
    }

    @Override
    public void deletePlayer(int id) {
        restTemplate.delete(url+"delete/"+id);
    }

    @Override
    public int createPlayer(Player player) {
        int count=restTemplate.postForObject(url+"create",player,Integer.class);
        return count;
    }

    @Override
    public void updatePlayer(Player player) {
        restTemplate.put(url+"update",player);
    }

    @Override
    public Player details(String email) {
        Player player=restTemplate.getForObject(url+"/details/"+email,Player.class);
        return player;
    }

    @Override
    public String encryptPassword(String password) {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String pass=encoder.encode(password);
        return pass;
    }


    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
