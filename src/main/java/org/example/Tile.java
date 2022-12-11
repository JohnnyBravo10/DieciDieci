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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Tile tile = (Tile) o;

        return this.occupied == tile.occupied;
    }
}
