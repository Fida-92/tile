package de.fida.entities.creatures;

import de.fida.entities.Entity;
import de.fida.tile.Handler;
import java.awt.Graphics;

public class Creature extends Entity {

    protected int health;
    protected double speed;
    protected static final int DEFAULT_HEALTH = 10;
    protected static final int DEFAULT_CREATUR_WIDTH = 64;
    protected static final int DEFAULT_CREATUR_HEIGHT = 64;
    protected static final double DEFAULT_SPEED = 3.5;
    protected float xMove, yMove;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
    }

    public void move() {
        x += xMove;
        y += yMove;
    }

    //GETTERs & SETTERs
    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

}
