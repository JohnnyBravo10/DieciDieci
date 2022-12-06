package org.example;

public class Piece {

//shape of the piece
    public Tile[][] shape;
//possible shapes (matrices of occupied/empty tiles)

    // straight pieces
    private static final Tile[][] A={{new Tile(true)}};
    private static final Tile[][] B={{new Tile(true),new Tile(true)}};
    private static final Tile[][] C={{new Tile(true),new Tile(true),new Tile(true)}};
    private static final Tile[][] D={{new Tile(true),new Tile(true),new Tile(true),new Tile(true)}};
    private static final Tile[][] E={{new Tile(true),new Tile(true),new Tile(true),new Tile(true),new Tile(true)}};

    // square pieces
    private static final Tile[][] F={{new Tile(true),new Tile(true)},{new Tile(true),new Tile(true)}};
    private static final Tile[][] G={{new Tile(true),new Tile(true),new Tile(true)},{new Tile(true), new Tile(true), new Tile(true)}, {new Tile(true),new Tile(true), new Tile(true)}};

    //'L' pieces
    private static final Tile[][] H={{new Tile(true), new Tile()}, {new Tile(true), new Tile(true)}};
    private static final Tile[][] I={{new Tile(true),new Tile(),new Tile()}, {new Tile(true),new Tile(),new Tile()}, {new Tile(true),new Tile(true),new Tile(true)} };

    //reversed 'L' pieces
    private static final Tile[][] J={{new Tile(), new Tile(true)}, {new Tile(true), new Tile(true)}};
    private static final Tile[][] K={{new Tile(),new Tile(),new Tile(true)}, {new Tile(),new Tile(),new Tile(true)}, {new Tile(true),new Tile(true),new Tile(true)} };

    //array of possible shapes
    private final Tile[][][] possibleShapes={A,B,C,D,E,F,G,H,I,J,K};

    public void clockwiseRotation(){
    }

}






