

package de.fida.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

 
public class Display {
    private JFrame frame;
    private Canvas canvas;
    private String title;
    private int width,height;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }
    
  private void createDisplay(){
      frame = new JFrame(title);
      frame.setSize(width, height);
      frame.setResizable(true);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      canvas = new Canvas();
      canvas.setPreferredSize(new Dimension(width, height));
      canvas.setMaximumSize(new Dimension(width, height));
      canvas.setMinimumSize(new Dimension(width, height));
      canvas.setFocusable(false);
      frame.add(canvas);
      frame.pack();
  }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
    
    
    
    
  
  
}
  