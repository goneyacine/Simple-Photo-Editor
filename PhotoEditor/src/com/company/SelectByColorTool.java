package com.company;

import interfaces.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
public class SelectByColorTool implements  selectTool {
    private Color selectedColor;
    private BufferedImage image;
    private List<Pixel> selectedPixels = new ArrayList<>();
    public SelectByColorTool(int R, int G, int B, BufferedImage image){
        selectedColor =  new Color(R,G,B);
        this.image = image;
        select();
    }
    @Override
    public void select() {
        
        for(int x = 0; x<image.getWidth();x++){
            for(int y = 0; y < image.getHeight();y++){
              if(image.getRGB(x,y) == selectedColor.getRGB()){
                  selectedPixels.add(new Pixel(x,y));
              }
            }
        }
        if(selectedPixels == null){
            System.out.println("Worked but null");
        }
    }
    public void setImage( BufferedImage image){
        this.image = image;
    }
    public BufferedImage getImage(){
        return image;
    }
    public void setSelectedColor( int R, int G, int B, BufferedImage image){
        selectedColor =  new Color(R,G,B);
    }
    public Color getSelectedColor(){
        return selectedColor;
    }
    public void setSelectedPixel( List<Pixel> selectedpixels){
     this.selectedPixels = selectedpixels;
    }
    public List<Pixel> getSelectedPixels(){
        return selectedPixels;
    }
}
