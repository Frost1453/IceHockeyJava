package me.frosty.icehockey.states;

import me.frosty.icehockey.game.Game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;

public class MenuScene extends MouseAdapter {

    public MenuScene() {

    }

    public void update() {
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (Game.STATE == States.Menu) {

            // ## PLAY ##
            if (mouseOver(mx, my, 200, 250, 200, 80)) {
                Game.STATE = States.Game;
                System.out.println("play button!");
            }

            // ## SETTINGS ##
            if (mouseOver(mx, my, 150, 360, 300, 80)) {
                Game.STATE = States.Settings;
            }

            // ## HELP ##
            if (mouseOver(mx, my, 150, 470, 300, 80)) {
                Game.STATE = States.Help;
            }

            // ## QUIT ##
            if (mouseOver(mx, my, 150, 580, 300, 80)) {
                System.out.println("quit pressed");
                System.exit(0);
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
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.setColor(new Color(95, 205, 228));
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("Ana Menü", 180, 100);

        g.setColor(new Color(223, 113, 38));
        g.fillRect(150, 250, 300, 80);

        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("Oyna", 245, 300);

        g.setColor(new Color(223, 113, 38));
        g.fillRect(150, 360, 300, 80);

        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("Ayarlar", 215, 410);


        g.setColor(new Color(223, 113, 38));
        g.fillRect(150, 470, 300, 80);

        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("Yardım", 215, 520);


        g.setColor(new Color(223, 113, 38));
        g.fillRect(150, 580, 300, 80);

        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("Çıkış", 245, 630);
    }
}
