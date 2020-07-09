package com.company;

import java.awt.image.*;
import java.util.*;
import java.util.List;
import java.awt.*;

public class GlitchEffect {
     private BufferedImage image;
     private List<Pixel> pixels = new ArrayList<Pixel>();
     public void setImage(BufferedImage image){
         this.image = image;
     }
     public BufferedImage getImage(){
         return image;
    }
    
    public GlitchEffect(BufferedImage image){
        this.image = image;
        applyEffect(6);
    }
    public void applyEffect(int glitchSize){
    for(int x = 0; x < image.getWidth();x++){
        for(int y = 0; y < image.getHeight();y++){
            try{
            Color pixelColor = new Color(image.getRGB(x,y));
            //check if R,G,B values of the pixel color are bigger than 100
            if(pixelColor.getBlue() > 100 && pixelColor.getRed() > 100 && pixelColor.getGreen() > 100){
                pixels.add(new Pixel(x,y));

                Color c;
                for (int i = 1; i <= glitchSize ;i ++){
                 c = new Color(image.getRGB(x + i, y + i));
                if((c.getRed() < 100 || c.getBlue() < 100 || c.getGreen() < 100) && c != Color.blue && c != Color.red && c != Color.green){
                    image.setRGB(x + i, y + i, Color.BLUE.getRGB());
            }
        }

        for (int i = glitchSize + 3; i <= glitchSize * 2 + 3 ;i ++){
            c = new Color(image.getRGB(x + i, y + i));
           if((c.getRed() < 100 || c.getBlue() < 100 || c.getGreen() < 100) && c != Color.blue && c != Color.red && c != Color.green){
               image.setRGB(x + i, y + i, Color.GREEN.getRGB());
       }
    }   

        for (int i = glitchSize * 2 + 6; i <= glitchSize * 3 + 3 ;i ++){
            c = new Color(image.getRGB(x + i, y + i));
           if((c.getRed() < 100 || c.getBlue() < 100 || c.getGreen() < 100) && c != Color.blue && c != Color.red && c != Color.green){
               image.setRGB(x + i, y + i, Color.RED.getRGB());
       }
    }

             }
           }catch(Exception e){
            continue;
        }
        }
        }
    }
}
    