package de.fida.graphics;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int WIDTH=32,HEIGHT=32;
    public static BufferedImage player, dirt, grass, stone, tree;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(MyImageLoader.loadImage("./resources/textures/sheet.png"));
        player = sheet.createSubImage(0, 0, WIDTH, HEIGHT);
        dirt = sheet.createSubImage(WIDTH, 0, WIDTH, HEIGHT);
        grass = sheet.createSubImage(WIDTH*2, 0, WIDTH, HEIGHT);
        stone = sheet.createSubImage(WIDTH*3, 0, WIDTH, HEIGHT);
        tree = sheet.createSubImage(0, WIDTH, WIDTH, HEIGHT);
    }

}
