package GUI;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.awt.*;

public class StartWindow{

  private JFrame frame;
  private String imagePathTextInput;

 public StartWindow(){
    frame = new JFrame();
    frame.setBounds(100,100,500,80);
    frame.setResizable(false);
    frame.setTitle("Open File (PHOTO EDITOR)");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel MainPanel = new JPanel();
    MainPanel.setBounds(0, 0, 500, 200);
    JLabel titleLabel = new JLabel("Open An Image");
    JTextField  imagePathInput = new JTextField("IMAGE PATH");
    JButton openFileButton = new JButton("OPEN");
    openFileButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
           imagePathTextInput = imagePathInput.getText();
           File temp = new File(imagePathTextInput);
           if(!temp.exists() ){
               JFrame errorFrame = new JFrame();
               
               errorFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
               errorFrame.setBounds(100,100,200,100);
               JLabel errorMessage = new JLabel("       FILE LOADING ERROR");
               errorMessage.setForeground(Color.RED);
               errorFrame.setResizable(false);
               errorFrame.add(errorMessage);
               errorFrame.setVisible(true);
           }
        else{
            frame.setVisible(false);
           MainGUI mainGUI = new MainGUI(1200,650,imagePathTextInput);
        }
    }
    });
    titleLabel.setBounds(100,10,50,30);
    imagePathInput.setBounds(250,100,200,80);
    openFileButton.setBounds(250,100,200,80);
    MainPanel.add(titleLabel);
    MainPanel.add(imagePathInput);
    MainPanel.add(openFileButton);
    frame.add(MainPanel);
    frame.setVisible(true);
 }
 public JFrame getFrame(){return frame;}
 public String getImagePathTextInput(){
     return imagePathTextInput;
 }
}