package org.example;

import java.awt.*;

public class Tile {
    private Color color;

    //initialization empty tile
    public Tile(){
        this.color = Color.white;
    }

    //initialization empty/occupied tile
    public Tile (String colore){
        this.setColor(colore);
    }

    public void setColor(String colore){
        switch(colore) {
            case "red":
                this.color = Color.red;
                break;
            case "orange":
                this.color = Color.orange;
                break;
            case "yellow":
                this.color = Color.yellow;
                break;
            case "green":
                this.color = Color.green;
                break;
            case "blue":
                this.color = Color.blue;
                break;
            case "cyan":
                this.color = Color.cyan;
                break;
            case "magenta":
                this.color = Color.magenta;
                break;
            case "pink":
                this.color = Color.pink;
                break;
            case "lightGray":
                this.color = Color.lightGray;
                break;
            case "gray":
                this.color = Color.gray;
                break;
            case "darkGray":
                this.color = Color.darkGray;
                break;
            case "black":
                this.color = Color.black;
                break;
            case "lightGreen":
                this.color = new Color(175, 255, 175);
                break;
            case "purple":
                this.color = new Color(175, 175, 225);
                break;
            case "white":
                this.color = Color.white;
                break;
        }
    }

    // Adding is Empty check
    public boolean isEmpty(){
        return this.color.equals(Color.white);
    }

    //Get tile's color
    public Color getColor(){
        return this.color;
    }
}
