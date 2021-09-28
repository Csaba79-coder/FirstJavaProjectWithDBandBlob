package application.tantus;

import javax.swing.*;
import java.awt.*;

import javax.swing.ImageIcon;

public class ShowProfilePic extends JFrame {

    ImageIcon imageIcon;
    JLabel jLabel;

    public ShowProfilePic() {
        setLayout(new FlowLayout());

        try {
            imageIcon = new ImageIcon((getClass().getResource("CsabaVadasz.png")));
            jLabel = new JLabel(imageIcon);
            add(jLabel);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


//    public void addProfilePic() {
//        // ImageIcon image = new ImageIcon("C:\\Users\\Meneer\\Pictures\\image.png");
//        ImageIcon image = new ImageIcon("src/main/resources/CsabaVadasz.png");
//        JLabel label = new JLabel(image);
//        JScrollPane scrollPane = new JScrollPane(label);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        add(scrollPane, BorderLayout.CENTER);
//        pack();
//    }
}
