package me.frosty.icehockey.assets;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage image;

    public SpriteSheet(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage pickImage(int col, int row, int w, int h){
        return image.getSubimage((col*32)-32,(row*32)-32,w,h);
    }

}
