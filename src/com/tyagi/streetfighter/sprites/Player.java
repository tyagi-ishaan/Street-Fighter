package com.tyagi.streetfighter.sprites;

import com.tyagi.streetfighter.utils.GameConstants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Player extends CommonPlayer implements GameConstants {

    private BufferedImage idleImages[] = new BufferedImage[4];
    private BufferedImage walkImages[] = new BufferedImage[5];
    private BufferedImage kickImages[] = new BufferedImage[5];
    private BufferedImage punchImages[] = new BufferedImage[3];
    private BufferedImage powerImages[] = new BufferedImage[4];

    private int force;
    public Player() throws Exception {
        x = 225;
        y = GROUND;
        w = 200;
        h = 250;
        force = 0;
        speed = 0;
        playerImg = ImageIO.read(Objects.requireNonNull(Player.class.getResource(KEN_IMAGE)));
        loadIdleImages();
        loadWalkImages();
        loadKickImages();
        loadPunchImages();
        loadPowerImages();
    }

    private void loadIdleImages() {
        idleImages[0] = playerImg.getSubimage(46, 238, 109, 250);
        idleImages[1] = playerImg.getSubimage(266, 243, 111, 245);
        idleImages[2] = playerImg.getSubimage(478, 242, 111, 241);
        idleImages[3] = playerImg.getSubimage(685, 246, 115, 240);

    }

    private void loadPowerImages() {
        powerImages[0] = playerImg.getSubimage(  28, 5, 159, 229);
        powerImages[1] = playerImg.getSubimage(240, 13, 162, 220);
        powerImages[2] = playerImg.getSubimage(442, 24, 193, 209);
        powerImages[3] = playerImg.getSubimage(660, 24, 195, 208);

    }

    private void loadWalkImages() {
        walkImages[0] = playerImg.getSubimage(43, 735, 116, 241);
        walkImages[1] = playerImg.getSubimage(254, 732, 121, 241);
        walkImages[2] = playerImg.getSubimage(471, 734, 107, 241);
        walkImages[3] = playerImg.getSubimage(693, 733, 100, 243);
        walkImages[4] = playerImg.getSubimage(909, 748, 95, 228);

    }
    private void loadKickImages() {
        kickImages[0] = playerImg.getSubimage(53, 1458, 120, 244);
        kickImages[1] = playerImg.getSubimage(247, 1456, 123, 246);
        kickImages[2] = playerImg.getSubimage(427, 1455, 208, 247);
        kickImages[3] = playerImg.getSubimage(675, 1456, 125, 248);
        kickImages[4] = playerImg.getSubimage(909, 1461, 120, 244);
    }

    private void loadPunchImages() {
        punchImages[0] = playerImg.getSubimage(41, 490, 119, 237);
        punchImages[1] = playerImg.getSubimage(257, 488, 170, 240);
        punchImages[2] = playerImg.getSubimage(473, 490, 119, 240);

    }

        public BufferedImage printIdle () {
           isAttacking = false;
            if (imageIndex > 3) {
                imageIndex = 0;
            }
            BufferedImage img = idleImages[imageIndex];
            imageIndex++;
            return img;
        }

        public BufferedImage printWalk () {
           isAttacking = false;
            if (imageIndex > 4) {
                imageIndex = 0;
                currentMove = IDLE;
            }
            BufferedImage img = walkImages[imageIndex];
            imageIndex++;
            return img;
        }

        public BufferedImage printKick () {
            if (imageIndex > 4) {
                imageIndex = 0;
                currentMove = IDLE;
                isAttacking = false;
            }
            isAttacking = true;
            BufferedImage img = kickImages[imageIndex];
            imageIndex++;
            return img;
        }

    public BufferedImage printPunch() {
        if (imageIndex > 2) {
            imageIndex = 0;
            currentMove = IDLE;
            isAttacking = false;
        }
        isAttacking= true;
        BufferedImage img = punchImages[imageIndex];
        imageIndex++;
        return img;
    }

    public BufferedImage printPowerImage() {
        if (imageIndex > 3) {
            imageIndex = 0;
            currentMove = IDLE;
            isAttacking = false;
        }
        isAttacking= true;
        BufferedImage img = powerImages[imageIndex];
        imageIndex++;
        return img;
    }

    private ArrayList<PowerEffect> powers = new ArrayList<>();

    public ArrayList<PowerEffect>getPowers() {
        return powers;
    }

    public void showPower() {
        powers.add(new PowerEffect(x+w-55, y+h/2-70, playerImg));
    }

        public void jump() {
        force = -25;
        y = y+ force;
        }

        public void fall() {
        if(y + force > GROUND) {
            return;
        }
        force = force + GRAVITY;
        y = y + force;
        }

        @Override
        public BufferedImage defaultImage () {
            if (currentMove == WALK) {
                return printWalk();
            }
            else if (currentMove == KICK) {
                return printKick();
            }
            else if (currentMove == PUNCH) {
                return printPunch();
            }
            else if (currentMove == POWER) {
                return printPowerImage();
            }
            else {
                return printIdle();
            }
        }
}
