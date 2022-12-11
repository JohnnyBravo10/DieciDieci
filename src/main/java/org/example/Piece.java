package org.example;

import java.security.SecureRandom;
import java.util.Objects;

public class Piece {

//shape of the piece
    public Tile[][] shape;
//possible shapes (matrices of occupied/empty tiles)///////////////////////////////////////////////////////////////////

    // straight pieces
    private static final Tile[][] A={{new Tile(true)}};
    private static final Tile[][] B={{new Tile(true),new Tile(true)}};
    private static final Tile[][] C={{new Tile(true),new Tile(true),new Tile(true)}};
    private static final Tile[][] D={{new Tile(true),new Tile(true),new Tile(true),new Tile(true)}};
    private static final Tile[][] E={{new Tile(true),new Tile(true),new Tile(true),new Tile(true),new Tile(true)}};

    // square pieces
    private static final Tile[][] F={
            {new Tile(true),new Tile(true)},
            {new Tile(true),new Tile(true)}
    };
    private static final Tile[][] G={
            {new Tile(true),new Tile(true),new Tile(true)},
            {new Tile(true), new Tile(true), new Tile(true)},
            {new Tile(true),new Tile(true), new Tile(true)}
    };

    //'L' pieces
    private static final Tile[][] H={
            {new Tile(true), new Tile()},
            {new Tile(true), new Tile(true)}
    };
    private static final Tile[][] I={
            {new Tile(true),new Tile(),new Tile()},
            {new Tile(true),new Tile(),new Tile()},
            {new Tile(true),new Tile(true),new Tile(true)}
    };

    //reversed 'L' pieces
    private static final Tile[][] J={
            {new Tile(), new Tile(true)},
            {new Tile(true), new Tile(true)}
    };
    private static final Tile[][] K={
            {new Tile(),new Tile(),new Tile(true)},
            {new Tile(),new Tile(),new Tile(true)},
            {new Tile(true),new Tile(true),new Tile(true)}
    };

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //costruttore di pezzi di forma random
    public Piece(){
        SecureRandom s = new SecureRandom();
        //array of possible shapes
        Tile[][][] possibleShapes = {A, B, C, D, E, F, G, H, I, J, K};
        this.shape = possibleShapes[s.nextInt(possibleShapes.length)];
    }

    public Piece(int pieceIndex) throws IllegalArgumentException {
        Tile[][][] possibleShapes = {A, B, C, D, E, F, G, H, I, J, K};

        if (pieceIndex < 0 || pieceIndex > possibleShapes.length - 1)
            throw new IllegalArgumentException("Piece Index out of bounds");

        this.shape = possibleShapes[pieceIndex];
    }

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






