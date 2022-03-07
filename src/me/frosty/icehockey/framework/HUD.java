package me.frosty.icehockey.framework;

import me.frosty.icehockey.game.Game;
import me.frosty.icehockey.objects.Ball;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class HUD {

    public static int p1Score = 0, p2Score = 0;

    public void update() {

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


        if (Ball.timer <= 0) {
            g.setFont(font);
            g.setColor(Color.BLACK);
            g.drawString(p1Score + " : " + p2Score, (int) (Game.WIDTH / 2.5), Game.HEIGHT / 2);
        }
    }

}
