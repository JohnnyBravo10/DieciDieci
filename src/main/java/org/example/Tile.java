package org.example;

import java.awt.*;

public class Tile {

    public boolean occupied;
    private Color color;

    //initialization empty tile
    public Tile(){
        this.occupied=false;
    }

    //initialization empty/occupied tile
    public Tile (boolean o){
        this.occupied=o;
    }
}
