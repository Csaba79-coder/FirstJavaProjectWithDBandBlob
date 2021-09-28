package application.tantus;

import javax.swing.*;

public class MyJFrame {

    public void showJFrame() {
        JFrame myJFrame = new JFrame();
        String frameHeader = "Profile_picture";

        myJFrame.setTitle(frameHeader);
        myJFrame.setSize(1200, 600);
        myJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myJFrame.setVisible(true);

        // new ShowProfilePic().addProfilePic();
    }
}
