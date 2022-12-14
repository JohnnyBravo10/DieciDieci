package org.example;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.awt.*;

public class Piece {

    // TODO: forse posso trasformare sta roba in un hashmap però ci devo pensare meglio private HashMap<ShapeType, Tile[][]> shapeX;

    private static final Tile[][] SQUARE2x_PIECE = new Tile[][]{
       {new Tile(new Color(175, 255, 175)),new Tile(new Color(175, 255, 175))},
       {new Tile(new Color(175, 255, 175)),new Tile(new Color(175, 255, 175))}
};

private static final Tile[][] SQUARE3x_PIECE = new Tile[][]{
        {new Tile(Color.cyan), new Tile(Color.cyan), new Tile(Color.cyan)},
        {new Tile(Color.cyan), new Tile(Color.cyan), new Tile(Color.cyan)},
        {new Tile(Color.cyan), new Tile(Color.cyan), new Tile(Color.cyan)}
        };

private static final Tile[][] STRAIGHT1x_PIECE = new Tile[][]{
        {new Tile(new Color(175, 175, 225))}
        };

private static final Tile[][] STRAIGHT2x_PIECE = new Tile[][]{
        {new Tile(Color.yellow),new Tile(Color.yellow)}
        };

private static final Tile[][] STRAIGHT3x_PIECE = new Tile[][]{
        {new Tile(Color.orange),new Tile(Color.orange),new Tile(Color.orange)}
        };

private static final Tile[][] STRAIGHT4x_PIECE = new Tile[][]{
        {new Tile(Color.magenta),new Tile(Color.magenta),new Tile(Color.magenta),new Tile(Color.magenta)}
        };

private static final Tile[][] STRAIGHT5x_PIECE = new Tile[][]{
        {new Tile(Color.red),new Tile(Color.red),new Tile(Color.red),new Tile(Color.red),new Tile(Color.red)}
        };

private static final Tile[][] ELLE2x_PIECE = new Tile[][]{
        {new Tile(Color.green), new Tile()},
        {new Tile(Color.green), new Tile(Color.green)}
        };

private static final Tile[][] ELLE3x_PIECE = new Tile[][]{
        {new Tile(Color.darkGray),new Tile(),new Tile()},
        {new Tile(Color.darkGray),new Tile(),new Tile()},
        {new Tile(Color.darkGray),new Tile(Color.darkGray),new Tile(Color.darkGray)}
        };

private static final Tile[][] REVERSEDELLE2X_PIECE = new Tile[][]{
        {new Tile(), new Tile(Color.green)},
        {new Tile(Color.green), new Tile(Color.green)}
        };

private static final Tile[][] REVERSEDELLE3X_PIECE = new Tile[][]{
        {new Tile(), new Tile(), new Tile(Color.darkGray)},
        {new Tile(), new Tile(), new Tile(Color.darkGray)},
        {new Tile(Color.darkGray), new Tile(Color.darkGray), new Tile(Color.darkGray)}
        };
    private enum ShapeType{
        SQUARE2x,
        SQUARE3x,
        STRAIGHT1x,
        STRAIGHT2x,
        STRAIGHT3x,
        STRAIGHT4x,
        STRAIGHT5x,
        ELLE2x,
        ELLE3x,
        REVERSEDELLE2X,
        REVERSEDELLE3X
    }

    private static final Map<ShapeType,Tile[][]> possiblePieces=new HashMap<ShapeType,Tile[][]>(){{ //NON CAMBIARE SENNò CIRCLE SI ARRABBIA
        put(ShapeType.SQUARE2x, SQUARE2x_PIECE);
        put(ShapeType.SQUARE3x, SQUARE3x_PIECE);
        put(ShapeType.STRAIGHT1x, STRAIGHT1x_PIECE);
        put(ShapeType.STRAIGHT2x, STRAIGHT2x_PIECE);
        put(ShapeType.STRAIGHT3x, STRAIGHT3x_PIECE);
        put(ShapeType.STRAIGHT4x, STRAIGHT4x_PIECE);
        put(ShapeType.STRAIGHT5x, STRAIGHT5x_PIECE);
        put(ShapeType.ELLE2x, ELLE2x_PIECE);
        put(ShapeType.ELLE3x, ELLE3x_PIECE);
        put(ShapeType.REVERSEDELLE2X, REVERSEDELLE2X_PIECE);
        put(ShapeType.REVERSEDELLE3X, REVERSEDELLE3X_PIECE);

    }};

    //shape of the piece
    private final Tile[][] shape;
    private final ShapeType type;


    // Normal piece constructor

    public Piece(ShapeType type) {
        this.shape = possiblePieces.get(type);
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






