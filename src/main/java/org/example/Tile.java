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

    // Make tiles white again
    public void makeAvailable(){
        this.color = Color.white;
    }

    // set the color
    public void setColor(Color color){
        this.color = color;
    }

    // check if two tiles are equals (have the same color)
    public boolean equals (Tile tile){
        return this.getColor() == tile.getColor();
    }
}
