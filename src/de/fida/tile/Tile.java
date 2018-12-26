package de.fida.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

    //Statische Sachen
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile rockTile = new RockTile(2);

    //Class
    protected BufferedImage texture;
    protected int id;
    public static final int TILEWIDTH = 32, TILEHEIGHT = 32;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;
        tiles[id] = this;
    }

    public boolean isSolid() {
        return false;
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

}
