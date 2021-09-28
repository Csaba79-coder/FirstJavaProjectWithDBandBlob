package application.tantus;

import application.database.HandleImageInMySQL;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Gagandeep Bali
 * Date: 7/1/14
 * Time: 9:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class ImageExample {

    InputStream imageInputStream = new HandleImageInMySQL().readPic();

    private void displayGUI() {
        JFrame frame = new JFrame("Profile_picture");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        MyPanel contentPane = new MyPanel();

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private class MyPanel extends JPanel {

        private BufferedImage image;

        public MyPanel() {
            try {
                image = ImageIO.read(imageInputStream);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return image == null ? new Dimension(400, 300): new Dimension(image.getWidth(), image.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }

    public void runPicWithGui() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new ImageExample().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}

