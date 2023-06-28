package com.skytech.cricket.rest;

import com.skytech.cricket.model.Player;

import java.util.List;

public interface RestPlayerService {
    public static final String url="http://localhost:8080/SpringBcciProject_war_exploded/player/";

    /**
     *
     * @return This method is to get the players list using RestTemplate through api
     */
    public List<Player> getPlayerList();

    /**
     *
     * @param id
     * @return This method is to get the player data from  RestTemplate by using api
     */
    public Player getPlayerById(int id);

    /**
     *
     * @param id
     * @return This method is to delete the player in database by using RestTemplate through api
     */
    public void deletePlayer(int id);

    /**
     *
     * @param player
     * @return This method is to insert the player in database by using RestTemplate through api
     */
    public int createPlayer(Player player);

    /**
     *
     * @param player
     * @return This method is to update the player in database by using RestTemplate through api
     */
    public void updatePlayer(Player player);

    /**
     *
     * @param email
     * @return This method is to get the player details throgh email in database by using RestTemplate through api
     */
    public Player details(String email);

    /**
     *
     * @param password
     * @return This method is to encrypting the passwords while inserting into database
     */
    public String encryptPassword(String password);
}
