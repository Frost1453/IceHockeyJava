package me.frosty.icehockey.states;

import me.frosty.icehockey.assets.ImageLoader;
import me.frosty.icehockey.assets.SpriteSheet;
import me.frosty.icehockey.framework.Handler;
import me.frosty.icehockey.game.Game;
import me.frosty.icehockey.objects.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameScene {

    Handler handler;
    Game game;

    private SpriteSheet ss;
    private BufferedImage spriteSheet;
    private ImageLoader loader;

    public GameScene(Handler handler, Game game) {
        this.handler = handler;
        this.game = game;
        create();
    }

    public void create() {

        loader = new ImageLoader();
        spriteSheet = loader.loadImage("/hockeysprite.png");
        ss = new SpriteSheet(spriteSheet);

        handler.addObject(new PlayerONE(250, 600, ID.PlayerONE, ss));
        handler.addObject(new PlayerTWO(250, 100, ID.PlayerTWO, ss));
        handler.addObject(new Ball((int) (Game.WIDTH / 2.5 + 30), Game.HEIGHT / 2 - 55, ID.Ball, ss, handler));
        handler.addObject(new Goal(0, 765, ID.GoalONE, ss, handler));
        handler.addObject(new Goal(0, 5, ID.GoalTWO, ss, handler));
    }

    public void update() {
        handler.update();
    }

    public void draw(Graphics g) {
        handler.draw(g);
    }

}
