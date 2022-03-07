package me.frosty.icehockey.game;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import me.frosty.icehockey.assets.ImageLoader;
import me.frosty.icehockey.assets.SpriteSheet;
import me.frosty.icehockey.framework.HUD;
import me.frosty.icehockey.framework.Handler;
import me.frosty.icehockey.inputs.KeyInput;
import me.frosty.icehockey.states.*;
import me.frosty.icehockey.window.Window;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 600 , HEIGHT = WIDTH/3*4;

    private boolean isRunning = false;
    private Thread thread;

    private Handler handler;

    private MenuScene menu;
    private GameScene game;
    private SettingsScene settings;
    private HelpScene help;
    private HUD hud;

    private SpriteSheet ss;
    private BufferedImage spriteSheet;
    private ImageLoader loader;


    public static States STATE = States.Menu;

    public Game() {
        create();
        System.out.println("Created!");
        start();
    }

    public void create() {
        handler = new Handler();
        menu = new MenuScene();
        settings = new SettingsScene();
        help = new HelpScene();
        hud = new HUD();
        game = new GameScene(handler,this);

        loader = new ImageLoader();
        spriteSheet = loader.loadImage("/hockeysprite.png");
        ss = new SpriteSheet(spriteSheet);

        this.addMouseListener(menu);
        this.addMouseListener(help);
        this.addMouseListener(settings);
        this.addKeyListener(new KeyInput(handler,game));

        new Window(WIDTH,HEIGHT,"Ice Hockey Game", this);
    }

    public void start() {
        if (!isRunning) {
            isRunning = true;
            thread = new Thread(this);
            thread.start();
            System.out.println("Game has started!");
        }
    }

    public void stop() {
        if (isRunning) {
            isRunning = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfUpdates = 60.0;
        double ns = 1000000000 / amountOfUpdates;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                delta--;
            }
            draw();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;

            }
        }
        stop();
    }

    public void update() {
        if(STATE == States.Menu){
            menu.update();
        }else if (STATE == States.Game) {
            game.update();
            hud.update();
        }else if (STATE == States.Help) {
            help.update();
        }
        if (STATE == States.Settings){
            settings.update();
        }
    }

    public void draw() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        if (STATE == States.Menu) {
            menu.draw(g);
        }else if (STATE == States.Game) {
            hud.draw(g);
            game.draw(g);
        }else if (STATE == States.Help) {
            help.draw(g);
        }else if (STATE == States.Settings){
            settings.draw(g);
        }

        g.dispose();
        bs.show();
    }

    public static int clamp(int value, int min, int max) {
        if (value <= min) return min;
        else if (value >= max) return max;
        else return value;
    }

}
