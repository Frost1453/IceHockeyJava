package me.frosty.icehockey.states;

import me.frosty.icehockey.game.Game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;

public class SettingsScene extends MouseAdapter {

    public void update() {

    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (Game.STATE == States.Help) {


            // ## GERI ##
            if (mouseOver(mx, my, 150, 580, 300, 80)) {

                Game.STATE = States.Menu;
            }
        }
    }

    public static boolean mouseOver(int mx, int my, int x, int y, int w, int h) {
        if (mx > x && mx < x + w) {
            if (my > y && my < y + h) {
                return true;
            } else return false;
        } else return false;
    }

    public void draw(Graphics g) {
        Font font = null;
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("CharriotDeluxe.ttf");
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(48f);
        } catch (Exception e) {
            e.printStackTrace();
        }

        g.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.setColor(new Color(95, 205, 228));
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("Ayarlar", 200, 100);

        g.setColor(new Color(223, 113, 38));
        g.fillRect(150, 580, 300, 80);


        g.setColor(new Color(223, 113, 38));
        g.fillRect(150, 580, 300, 80);

        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("Geri", 245, 630);
    }


}
