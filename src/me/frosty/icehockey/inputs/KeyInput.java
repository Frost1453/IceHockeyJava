package me.frosty.icehockey.inputs;

import me.frosty.icehockey.framework.Handler;
import me.frosty.icehockey.objects.GameObject;
import me.frosty.icehockey.objects.ID;
import me.frosty.icehockey.objects.PlayerONE;
import me.frosty.icehockey.objects.PlayerTWO;
import me.frosty.icehockey.states.GameScene;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    Handler handler;
    GameScene gameScene;

    private boolean[] keys = {false, false, false, false, false, false, false};

    public KeyInput(Handler handler, GameScene gameScene) {
        this.handler = handler;
        this.gameScene = gameScene;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();


        int size = handler.objects.size();
        for (int i = 0; i < size; i++) {
            GameObject obj = handler.objects.get(i);

            // PLAYER ONE KEY INPUT

            if (obj.getID() == ID.PlayerONE) {

                if (PlayerONE.ultReady) {
                    if (key == KeyEvent.VK_UP) {
                        keys[0] = true;
                        PlayerONE.ultReady = false;
                        PlayerONE.usingUlt = true;
                    }
                }
                if (key == KeyEvent.VK_LEFT) {
                    keys[1] = true;
                    obj.setVelX(-4);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    keys[2] = true;
                    obj.setVelX(4);
                }


            }

            if (obj.getID() == ID.PlayerTWO) {
                if (PlayerONE.ultReady) {
                    if (key == KeyEvent.VK_W) {
                        keys[3] = true;
                        PlayerTWO.ultReady = false;
                        PlayerTWO.usingUlt = true;
                    }
                }

                if (key == KeyEvent.VK_A) {
                    obj.setVelX(-4);
                    keys[4] = true;
                }
                if (key == KeyEvent.VK_D) {
                    obj.setVelX(4);
                    keys[5] = true;
                }

            }
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();


        int size = handler.objects.size();
        for (int i = 0; i < size; i++) {
            GameObject obj = handler.objects.get(i);

            // PLAYER ONE KEY INPUT

            if (obj.getID() == ID.PlayerONE) {
                if (key == KeyEvent.VK_UP) {
                    keys[0] = false;
                    PlayerONE.usingUlt = false;
                }
                if (key == KeyEvent.VK_LEFT) {
                    keys[1] = false;
                }
                if (key == KeyEvent.VK_RIGHT) {
                    keys[2] = false;
                }

                if (!keys[1] && !keys[2]) {
                    obj.setVelX(0);
                }

            }

            // PLAYER TWO KEY INPUT

            if (obj.getID() == ID.PlayerTWO) {
                if (key == KeyEvent.VK_W) {
                    keys[3] = false;
                    PlayerTWO.usingUlt = false;
                }
                if (key == KeyEvent.VK_A) {
                    keys[4] = false;
                }
                if (key == KeyEvent.VK_D) {
                    keys[5] = false;
                }

                if (!keys[4] && !keys[5]) {
                    obj.setVelX(0);
                }

            }
        }
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

}
