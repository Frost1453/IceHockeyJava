package me.frosty.icehockey.objects;

import me.frosty.icehockey.assets.SpriteSheet;
import me.frosty.icehockey.game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class PlayerONE extends GameObject{

    public static int timer = 300;
    public static boolean usingUlt = false;
    public static boolean ultReady = false;

    BufferedImage p1Img;

    //##############################################################################

    public static PlayerClasses player_ability_class = PlayerClasses.BasicPlayer;

    //##############################################################################

    public PlayerONE(int x, int y, ID id, SpriteSheet spriteSheet) {
        super(x, y, id, spriteSheet);
        create();
    }

    @Override
    public void create() {
        p1Img = spriteSheet.pickImage(1,1,32,32);
    }

    @Override
    public void update() {
        x+=velX;
        y+=velY;

        x = Game.clamp(x, -3,Game.WIDTH - 109);


        if (!ultReady) {
            timer--;
            if (timer <= 0) {
                timer = 650;
                ultReady = true;
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(p1Img,x,y,96,96,null);

        //g.setColor(Color.RED);
        //g.drawRect(x+3,y+28,90,1);

        Font font = null;
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("CharriotDeluxe.ttf");
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(22f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!ultReady) {
            g.setFont(font);
            g.setColor(Color.BLACK);
            g.drawString("Ult: " + timer, 50, 750);
        }

        if (ultReady) {
            g.setFont(font);
            g.setColor(Color.RED);
            g.drawString("Ult: " + "READY!", 50, 750);
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x+3,y+28,90,1);
    }

    public static PlayerClasses getPlayerClasses() {
        return player_ability_class;
    }
}
