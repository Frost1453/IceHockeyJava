package me.frosty.icehockey.window;

import me.frosty.icehockey.game.Game;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(int w, int h, String title, Game game) {
        this.setPreferredSize(new Dimension(w, h));
        this.setMinimumSize(new Dimension(w, h));
        this.setMinimumSize(new Dimension(w, h));
        this.add(game);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle(title);
        this.setResizable(false);

        this.setVisible(true);

    }
}
