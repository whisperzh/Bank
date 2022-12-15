package com.ood.Views;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This is a class which extends the JPanel to read the images in the project to create a part of the Bank Page.
 */

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

