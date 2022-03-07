package me.frosty.icehockey.states;

import me.frosty.icehockey.game.Game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;

public class HelpScene extends MouseAdapter {

    public void update() {

    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if (Game.STATE == States.Settings) {


            // ## GERI ##
            if(mouseOver(mx,my,150,580,300,80)){

                Game.STATE = States.Menu;
            }
        }
    }

    public static boolean mouseOver(int mx, int my, int x, int y, int w, int h) {
        if (mx > x && mx < x +w) {
            if (my > y && my < y + h){
                return true;
            } else return false;
        }else return false;
    }

    public void draw(Graphics g){
        Font font = null;
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("CharriotDeluxe.ttf");
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(48f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Font font2 = null;
        InputStream stream1 = ClassLoader.getSystemClassLoader().getResourceAsStream("CharriotDeluxe.ttf");
        try {
            font2 = Font.createFont(Font.TRUETYPE_FONT, stream1).deriveFont(22f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.clearRect(0,0,Game.WIDTH,Game.HEIGHT);
        g.setColor(new Color(95, 205, 228));
        g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);


        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("Yardım",200,100);

        g.setFont(font2);
        g.setColor(Color.BLACK);
        g.drawString("WAD ve Yön tuşları ile oynanır.", 100,300);
        g.drawString("Özel Yeteneğinizi W veya ", 100,330);
        g.drawString("Yukarı tuşu ile kullanabilirsiniz.", 100,360);

        g.drawString("Topun Kalenize Girmesini Engelleyin", 100,390);

        g.setColor(new Color(223,113,38));
        g.fillRect(150,580,300,80);

        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("Geri",245,630);
    }



}
