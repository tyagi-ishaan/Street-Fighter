package com.tyagi.streetfighter.sprites;

import com.tyagi.streetfighter.utils.GameConstants;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class OpponentPlayer extends CommonPlayer implements GameConstants {

    private BufferedImage idleImages[] = new BufferedImage[5];
    private BufferedImage walkImages[] = new BufferedImage[6];
    private BufferedImage hitImages[] = new BufferedImage[3];

    public OpponentPlayer() throws Exception {
        x = SCREENWIDTH - 460;
        y = GROUND;
        w = 200;
        h = 250;
        speed = 0;
        playerImg = ImageIO.read(Objects.requireNonNull(Player.class.getResource(RYU_IMAGE)));
        loadIdleImages();
        loadWalkImages();
        loadHitImages();
    }

 //   @Override
 //   public BufferedImage defaultImage() {
 //       // X = 2748 Y = 38 Width = 106 Height = 228
 //       return playerImg.getSubimage(2748, 38, 106, 228);
 //   }

    private void loadIdleImages() {
        idleImages[0] = playerImg.getSubimage(2174, 47, 90, 216);
        idleImages[1] = playerImg.getSubimage(2363, 36, 102, 230);
        idleImages[2] = playerImg.getSubimage(2560, 37, 104, 230);
        idleImages[3] = playerImg.getSubimage(2748, 36, 108, 232);
        idleImages[4] = playerImg.getSubimage(2958, 36, 107, 231);
    }

    private void loadWalkImages() {
        walkImages[0] = playerImg.getSubimage(2962, 329, 89, 215);
        walkImages[1] = playerImg.getSubimage(2758, 315, 112, 229);
        walkImages[2] = playerImg.getSubimage(2574, 315, 108, 229);
        walkImages[3] = playerImg.getSubimage(2395, 315, 94, 229);
        walkImages[4] = playerImg.getSubimage(2216, 315, 91, 229);
    }

    private void loadHitImages() {
        hitImages[0] = playerImg.getSubimage(1000, 1565, 120, 242);
        hitImages[1] = playerImg.getSubimage(1172, 1571, 143, 242);
        hitImages[2] = playerImg.getSubimage(1371, 1584, 129, 229);
    }

      public BufferedImage printHitImages() {
        if(imageIndex>2) {
            imageIndex = 0;
            currentMove = IDLE;
        }
        BufferedImage img = hitImages[imageIndex];
        imageIndex++;
        return img;
      }

      public BufferedImage printIdle() {
        if (imageIndex > 4) {
            imageIndex = 0;
        }
        BufferedImage img = idleImages[imageIndex];
        imageIndex++;
        return img;
      }

      public BufferedImage printIdleImages() {
        if(imageIndex > 4) {
            imageIndex = 0;
        }
        BufferedImage img = idleImages[imageIndex];
        imageIndex++;
        return img;
    }

    @Override
    public BufferedImage defaultImage() {
        // X = 46 Y = 238 Width = 109 Height = 250
        //return playerImg.getSubimage(46, 238, 109, 250);
        if (currentMove == HIT) {
            return printHitImages();
        }
        else {
            return printIdle();
        }
    }
}
