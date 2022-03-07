package me.frosty.icehockey.objects;

import me.frosty.icehockey.assets.SpriteSheet;
import me.frosty.icehockey.framework.Handler;

import java.awt.*;

public class Goal extends GameObject {

    public Goal(int x, int y, ID id, SpriteSheet spriteSheet, Handler handler) {
        super(x, y, id, spriteSheet);
        create();
    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        //g.setColor(Color.BLACK);
        //g.drawRect(x,y,800,1);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 800, 1);
    }
}
