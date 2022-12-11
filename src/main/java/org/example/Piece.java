package org.example;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Piece {

    // TODO: forse posso trasformare sta roba in un hashmap però ci devo pensare meglio private HashMap<ShapeType, Tile[][]> shapeX;

    //shape of the piece
    private final Tile[][] shape;
    public enum ShapeType{
        SQUARE2x,
        SQUARE3x,
        STRAIGHT1x,
        STRAIGHT2x,
        STRAIGHT3x,
        STRAIGHT4x,
        STRAIGHT5x,
        ELLE2x,
        ELLE3x
    }

    private final ShapeType type;

    // Normal piece constructor

    public Piece(Tile[][] tileSet, ShapeType type) {
        this.shape = tileSet;
        this.type = type;
    }
    // Copy constructor
    public Piece(Piece piece){
        this.shape = new Tile[piece.shape.length][piece.shape[0].length];

        for(int i = 0; i < piece.shape.length; i++){
            this.shape[i] = Arrays.copyOf(piece.shape[i], piece.shape[i].length);
        }

        this.type = piece.type;
    }

    // type getter
    public ShapeType getType() {
        return this.type;
    }

    // copy object method
    public Piece copy() {
        return new Piece(this);
    }

    // equals can be called to check if 2 pieces are equal
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Piece piece = (Piece) o;

        if(piece.shape[0].length != this.shape[0].length ||
                piece.shape.length != this.shape.length)
            return false;

        boolean result = true;

        for(int i = 0; i < this.shape[0].length; i++)
        {
            for(int j = 0; j < this.shape.length; j++)
            {
                result &= this.shape[j][i].equals(piece.shape[j][i]);
            }
        }
        // field comparison
        return result;
    }

}






