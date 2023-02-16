package diecidieci.core;

import java.awt.*;

public class Tile {
    private Color color;
    private static final int SIZE = 32;

    //costruttore Tile vuoto
    public Tile(){
        this.color = Color.white;
    }

    //costruttore Tile vuoto/occupato
    public Tile (Color color){
        this.color = color;
    }

    //verifica accessibilità Tile
    public boolean isEmpty(){
        return this.color.equals(Color.white);
    }

    //Tile's color getter
    public Color getColor(){
        return this.color;
    }

    //liberare Tile
    public void makeAvailable(){
        this.color = Color.white;
    }

    //occupare il Tile
    public void setColor(Color color){
        this.color = color;
    }

    //SIZE getter
    public static int getSize() {
        return SIZE;
    }
}
