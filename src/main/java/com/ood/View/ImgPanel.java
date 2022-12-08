package com.ood.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class ImgPanel extends JPanel {

    private BufferedImage img;

    public ImgPanel(String filepath) {
        try {
            img = ImageIO.read(new File(filepath));
        } catch (IOException ex) {
            // handle exception...
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this); // see javadoc for more info on the parameters
    }

}

