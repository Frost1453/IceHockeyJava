package me.frosty.icehockey.objects;

import me.frosty.icehockey.assets.SpriteSheet;
import me.frosty.icehockey.framework.HUD;
import me.frosty.icehockey.framework.Handler;
import me.frosty.icehockey.game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ball extends GameObject {

    private BufferedImage ballImg;
    private Handler handler;
    private GameObject p1;
    private GameObject p2;

    private int addscorePlayer1 = 0;
    private int addscorePlayer2 = 0;

    public static int timer = 300;

    public Ball(int x, int y, ID id, SpriteSheet spriteSheet, Handler handler) {
        super(x, y, id, spriteSheet);
        this.handler = handler;

        create();
    }

    @Override
    public void create() {
        ballImg = spriteSheet.pickImage(8, 15, 32, 32);
        velX = 5;
        velY = 5;

    }

    @Override
    public void update() {
        timer--;

        if (timer <= 0) {
            timer = 0;
            x += velX;
            y += velY;

            if (y <= 0 || y >= Game.HEIGHT - 64) velY *= -1;
            if (x <= 0 || x >= Game.WIDTH - 48) velX *= -1;

            collision();
        }
    }

    public void collision() {
        int size = handler.objects.size();
        for (int i = 0; i < size; i++) {
            GameObject obj = handler.objects.get(i);

            if (obj.getID() == ID.PlayerONE) {
                if (getBounds().intersects(obj.getBounds())) {
                    velY *= -1;

                    if (PlayerONE.usingUlt) {

                        if (PlayerONE.getPlayerClasses() == PlayerClasses.BasicPlayer) {
                            velY *= 3;
                        }

                        if (PlayerONE.getPlayerClasses() == PlayerClasses.CatPlayer) {
                            if (getBounds().intersects(obj.getBounds())) {
                                x = p1.getX();
                            }
                        }
                    }
                }
            }

            if (obj.getID() == ID.PlayerTWO) {
                if (getBounds().intersects(obj.getBounds())) {
                    velY *= -1;

                    if (PlayerTWO.usingUlt) {
                        if (PlayerTWO.getPlayerClasses() == PlayerClasses.BasicPlayer) {
                            velY *= 3;
                        }
                    }

                }
            }

            if (obj.getID() == ID.GoalONE) {
                if (getBounds().intersects(obj.getBounds())) {
                    addscorePlayer2 += 1;
                    HUD.p2Score = addscorePlayer2;
                }
            }
            if (obj.getID() == ID.GoalTWO) {
                if (getBounds().intersects(obj.getBounds())) {
                    addscorePlayer1 += 1;
                    HUD.p1Score = addscorePlayer1;
                }
            }

        }
    }

    @Override
    public void draw(Graphics g) {

        g.drawImage(ballImg, x, y, 32, 32, null);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x + 4, y + 4, 24, 24);
    }
}
