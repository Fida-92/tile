package de.fida.tile;

import de.fida.display.Display;
import de.fida.graphics.Assets;
import de.fida.graphics.GameCamera;
import de.fida.input.KeyManager;
import de.fida.states.GameState;
import de.fida.states.State;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements Runnable {

    private Display display;
    public int width, height;
    private Thread thread;
    private String title;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;
    private State gameState;
    private KeyManager keyManager;
    private GameCamera gameCamera;
    
    private Handler handler; 
    
    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }

    private void init() {

        display = new Display(title, width, height);
        Assets.init();
        gameCamera = new GameCamera(this, 0, 0);
        handler = new Handler(this);
        gameState = new GameState(handler);
        State.setCurrentState(gameState);
        display.getFrame().addKeyListener(keyManager);

    }

    private void tick() {
        keyManager.tick();
        if (State.getCurrentState() != null) {
            State.getCurrentState().tick();
        }
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //clear the window.
        g.clearRect(0, 0, width, height);
        //draw hier
        gameState.render(g);

        //end drawing
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        // speed: 
        int fps = 60; //frame per second. 
        long now, last = System.nanoTime();
        double delta = 0;
        double timePerTick = 1E9 / fps;
        while (running) {
            now = System.nanoTime();
            delta += (now - last);
            last = now;
            if (delta >= timePerTick) {
                tick();
                render();
                delta = delta - timePerTick;
            }
        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public GameCamera getGameCamera(){
        return gameCamera;
    }
    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();//calls run internally
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    
}
