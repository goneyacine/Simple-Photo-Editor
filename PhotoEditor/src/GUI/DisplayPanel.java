package GUI;


import javax.swing.*;
import java.awt.image.BufferedImage;


public class DisplayPanel extends JLabel {
    private ImageIcon imageIcon;
    public DisplayPanel(BufferedImage image) {
        imageIcon = new ImageIcon(image);
        setVisible(true);
        setBounds(0,0,image.getWidth(),image.getHeight());
        setIcon(imageIcon);
    }
}
