package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.*;

public class ChangePixelsColor {
    private List<Pixel> pixels = new ArrayList<>();
    private BufferedImage image;
    private Color newPixelColor;
    
    public ChangePixelsColor(List<Pixel> pixels,BufferedImage image,Color newPixelColor){
        this.newPixelColor = newPixelColor;
        this.image = image;
        this.pixels = pixels;
        changePixelsColor();
    }
    public void setPixels(List<Pixel> pixels){
        this.pixels = pixels;
    }
    public List<Pixel> getPixels(){
        return pixels;
    }
    public void setImage(BufferedImage image){
        this.image = image;
    }
    public BufferedImage getImage(){
        return image;
    }
    public void setNewPixelColor(Color newPixelColor){
        this.newPixelColor = newPixelColor;
    }
    public Color getNewPixelColor(){
        return  newPixelColor;
    }
    public void changePixelsColor(){
     for(Pixel pixel : pixels){
         image.setRGB(pixel.x,pixel.y,newPixelColor.getRGB());
         setImage(image);
     }
    }
}
