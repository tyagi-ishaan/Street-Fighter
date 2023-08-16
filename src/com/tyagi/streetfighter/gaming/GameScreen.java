package com.tyagi.streetfighter.gaming;

import com.tyagi.streetfighter.utils.GameConstants;

import javax.swing.*;
import java.io.IOException;

public class GameScreen extends JFrame implements GameConstants {

        public GameScreen() throws Exception {

            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(SCREENWIDTH, SCREENHEIGHT);
            setLocationRelativeTo(null);
            setTitle(TITLE);
            GameBoard board = new GameBoard();
            add(board);

            setVisible(true);
        }

    public static void main(String[] args) {
        try {
            GameScreen obj = new GameScreen();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        }
}
