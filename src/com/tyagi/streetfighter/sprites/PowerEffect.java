package com.tyagi.streetfighter.sprites;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PowerEffect extends CommonPlayer {
    public PowerEffect(int x, int y, BufferedImage img) {
        this.playerImg = img;
        this.x = x;
        this.y = y;
        w = 50;
        h = 50;
        speed = 70;
    }

    @Override
    public BufferedImage defaultImage() {
        return playerImg.getSubimage(19, 1030, 110, 77);
    }

    public void printPower(Graphics pen) {
        pen.drawImage(defaultImage(),x,y,w,h,null);
        move();
    }
}
