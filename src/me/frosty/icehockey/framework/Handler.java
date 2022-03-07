package me.frosty.icehockey.framework;

import me.frosty.icehockey.objects.GameObject;
import me.frosty.icehockey.objects.ID;

import java.awt.*;
import java.util.ArrayList;

public class Handler {

    public ArrayList<GameObject> objects = new ArrayList<>();

    public void update() {
        for (GameObject obj : objects) {
            obj.update();
        }
    }

    public void draw(Graphics g) {
        for (GameObject obj : objects) {
            obj.draw(g);
        }
    }

    public void addObject(GameObject obj) {
        this.objects.add(obj);
    }

    public void removeObject(GameObject obj) {
        this.objects.remove(obj);
    }

    public void removeBall(GameObject obj){
        if (obj.getID() == ID.Ball) {
            this.objects.remove(obj);
        }
    }

}
