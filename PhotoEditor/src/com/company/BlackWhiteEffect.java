package com.company;

import java.awt.image.*;
import java.awt.*;

public class BlackWhiteEffect {

    private BufferedImage image;

    public BlackWhiteEffect(BufferedImage image){
      this.image = image;
      applyEffect();;
    }

    public void applyEffect(){
        for(int x = 0; x < image.getWidth();x++){
            for(int y = 0 ;y < image.getHeight(); y ++){
            //the color of the pixel 
            Color pixelColor = new Color(image.getRGB(x, y));
             //[R,G,B]
             int[] rgb = {pixelColor.getRed(),pixelColor.getGreen(),pixelColor.getBlue()};
            //sorting the rgb array to get the bigest value
            boolean rgbArrayIsSorted = true;
            for(int i = 0; i<2 ;i++){
                if(rgb[i] > rgb[i+1]){
                  rgbArrayIsSorted = false;
                  break;
                }else{
                    rgbArrayIsSorted = true;
                }
            }
            while(!rgbArrayIsSorted){
                for(int i = 0; i < 2;i++){
                  if(rgb[i] > rgb[i + 1]){
                      int temp = rgb[i];
                      rgb[i] = rgb[i + 1];
                      rgb[i + 1] = temp;
                  }
                }
                  for(int i = 0; i<2 ;i++){
                      if(rgb[i] > rgb[i+1]){
                        rgbArrayIsSorted = false;
                        break;
                      }else{
                          rgbArrayIsSorted = true;
                      }
                  }
                }
                pixelColor = new Color(rgb[0],rgb[0],rgb[0]);
                image.setRGB(x,y,pixelColor.getRGB());
            } 
            }
        }
        public void setImage(BufferedImage image){
            this.image = image;
        }
        public BufferedImage getImage(){
              return image;
        }
        
    }