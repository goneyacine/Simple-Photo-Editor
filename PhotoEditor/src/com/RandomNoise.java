package com;

import java.awt.image.*;
import java.awt.*;

public class RandomNoise {
    private BufferedImage image;
    
    public RandomNoise(BufferedImage image){
        this.image = image;
        applyEffect();
    }
    public void setImage(BufferedImage image){
        this.image = image;
    }
    public BufferedImage getImage(){
        return image;
    }
    public void applyEffect(){
        for(int x = 0; x < image.getWidth();x++){
            for(int y = 0; y < image.getHeight();y++){
            Color pixelColor = new Color(image.getRGB(x, y));
            int randomR =(int)(Math.random() * (255 - pixelColor.getRed())); 
            int randomG =(int)(Math.random() * (255 - pixelColor.getGreen()));
            int randomB =(int)(Math.random() * (255 - pixelColor.getBlue())); 
            pixelColor = new Color(pixelColor.getRed()+ randomR ,pixelColor.getGreen() + randomG,pixelColor.getBlue() + randomB);
            image.setRGB(x, y,pixelColor.getRGB());
            }
        }
    }
}