package application.tantus;

import javax.swing.*;

public class DisplayProfilePic {

    public void displayPhoto() {
        ShowProfilePic gui = new ShowProfilePic();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.pack();
        gui.setTitle("Profile_pic");
    }
}
