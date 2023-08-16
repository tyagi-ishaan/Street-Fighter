package com.tyagi.streetfighter.utils;

public interface GameConstants {

    String TITLE = ConfigReader.getValue("game.title");
    int SCREENWIDTH = Integer.parseInt(ConfigReader.getValue("game.width"));
    int SCREENHEIGHT = Integer.parseInt(ConfigReader.getValue("game.height"));
    int GROUND = Integer.parseInt(ConfigReader.getValue("game.height")) - 400;
    String RYU_IMAGE = ConfigReader.getValue("oppPlayer.img");
    String KEN_IMAGE = ConfigReader.getValue("player.img");
    int MAX_HEALTH = 500;
    int SPEED = 10;
    int IDLE = 1;
    int WALK = 2;
    int KICK = 3;
    int HIT = 4;
    int PUNCH = 5;
    int POWER = 7;
    int GRAVITY = 6;



}
