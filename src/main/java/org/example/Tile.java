package org.example;

import java.awt.*;

public class Tile {
    private Color color;

    //initialization empty tile
    public Tile(){
        this.color = Color.white;
    }

    //initialization empty/occupied tile
    public Tile (Color color){
        this.color = color;
    }

    // Adding is Empty check
    public boolean isEmpty(){
        return this.color.equals(Color.white);
    }

    //Get tile's color
    public Color getColor(){
        return this.color;
    }

    public void makeAvailable(){
        this.color = Color.white;
    }

    public void setColor(Color color){
        this.color = color;
    }
}
