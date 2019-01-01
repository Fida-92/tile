package de.fida.graphics;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int WIDTH=32,HEIGHT=32;
    public static BufferedImage player, dirt, grass, stone, tree;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(MyImageLoader.loadImage("./resources/textures/sheet.png"));
        dirt = sheet.createSubImage(WIDTH, 0, WIDTH, HEIGHT);
        grass = sheet.createSubImage(WIDTH*2, 0, WIDTH, HEIGHT);
        stone = sheet.createSubImage(WIDTH*3, 0, WIDTH, HEIGHT);
        tree = sheet.createSubImage(0, WIDTH, WIDTH, HEIGHT);
        player = sheet.createSubImage(4*WIDTH, 0, WIDTH, HEIGHT);
    }

}
