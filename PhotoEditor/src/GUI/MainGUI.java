package GUI;

import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.RandomNoise;
import com.company.BlackWhiteEffect;
import com.company.GlitchEffect;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class MainGUI {

    private BufferedImage image;
    private JScrollPane scrollPane;
    private  DisplayPanel displayPanel;
    private JPanel toolsBar;
    private JFrame frame;

    public MainGUI(int xframeSize,int yframeSize,String loadedImagePath)  {

        frame = new JFrame();
        frame.setBounds(0,0,xframeSize,yframeSize);
        frame.setTitle("PHOTO EDITOR");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            this.image = ImageIO.read(new File(loadedImagePath));
        }catch (IOException e){
            System.out.println(e);
        }
        frame.setLayout(null);
        frame.setResizable(false);
         toolsBar = new JPanel();
        toolsBar.setBackground(Color.BLACK);
        toolsBar.setBounds(0,0,300,frame.getHeight() - 40);
        frame.add(toolsBar,BorderLayout.WEST);
         displayPanel= new DisplayPanel(this.image);
        scrollPane = new JScrollPane(displayPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(301,0,frame.getWidth() - 320,frame.getHeight() - 40);
        frame.add(scrollPane);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
               JMenuItem saveMenuItem = new JMenuItem("save");
               fileMenu.add(saveMenuItem);
               saveMenuItem.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    try{
                        File outputFile = new File(loadedImagePath);
                        ImageIO.write(image,"png",outputFile);
                    }catch(Exception e){
                      System.out.println("ERROR " + e);
                    }
                }
            });
               JMenuItem openMenuItem = new JMenuItem("open");
               fileMenu.add(openMenuItem);
               openMenuItem.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                 frame.setVisible(false);
                 new StartWindow();
                }
            });
        JMenu effectsMenu = new JMenu("Effects");
              JMenuItem glitchEffectJMenuItem = new JMenuItem("glitch effect");
              effectsMenu.add(glitchEffectJMenuItem);
              glitchEffectJMenuItem.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    GlitchEffect glitchEffect = new GlitchEffect(image);
                    scrollPane.repaint();
                    frame.repaint();
                }
            });
              JMenuItem blackWhiteEffectJMenuItem = new JMenuItem("white & black effect");
              effectsMenu.add(blackWhiteEffectJMenuItem);
              blackWhiteEffectJMenuItem.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    BlackWhiteEffect blackWhiteEffect = new BlackWhiteEffect(image);
                    scrollPane.repaint();
                    frame.repaint();
                }
            });
              JMenuItem noiseEffectJMenuItem = new JMenuItem("noise effect");
              effectsMenu.add(noiseEffectJMenuItem);
              noiseEffectJMenuItem.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    RandomNoise randomNoise = new RandomNoise(image);
                    scrollPane.repaint();
                    frame.repaint();
                }
            });
        menuBar.add(fileMenu);
        menuBar.add(effectsMenu);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        update();
        //C:\Users\dtech\Pictures\chiken.jpg
    }
  public void setImage(BufferedImage image){
    this.image = image;
  }
  public BufferedImage getImage(){
      return image;
  }
  private void update(){
   
  }
}
