

package de.fida.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

 
public class MyImageLoader {
public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.err.println("Datein");
            System.exit(1);
        }
        return null;
    }
}
