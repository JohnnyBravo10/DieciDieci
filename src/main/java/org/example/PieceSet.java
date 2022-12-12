package org.example;

public class PieceSet {
    // Dato che il set di pezzi è singolo volevo creare una classe singleton per contenere tutti i pezzi

    private final Piece[] possibleSet;
    private static PieceSet set;

    private PieceSet(){
        this.possibleSet = new Piece[]{
                // straight pieces
                new Piece(new Tile[][]{{new Tile("purple")}}, Piece.ShapeType.STRAIGHT1x),
                new Piece(new Tile[][]{{new Tile("yellow"),new Tile("yellow")}}, Piece.ShapeType.STRAIGHT2x),
                new Piece(new Tile[][]{{new Tile("orange"),new Tile("orange"),new Tile("orange")}}, Piece.ShapeType.STRAIGHT3x),
                new Piece(new Tile[][]{{new Tile("magenta"),new Tile("magenta"),new Tile("magenta"),new Tile("magenta")}}, Piece.ShapeType.STRAIGHT4x),
                new Piece(new Tile[][]{{new Tile("red"),new Tile("red"),new Tile("red"),new Tile("red"),new Tile("red")}}, Piece.ShapeType.STRAIGHT5x),

                // squares
                new Piece(new Tile[][]{
                        {new Tile("lightGreen"),new Tile("lightGreen")},
                        {new Tile("lightGreen"),new Tile("lightGreen")}
                }, Piece.ShapeType.SQUARE2x),
                new Piece(new Tile[][]{
                        {new Tile("cyan"), new Tile("cyan"), new Tile("cyan")},
                        {new Tile("cyan"), new Tile("cyan"), new Tile("cyan")},
                        {new Tile("cyan"), new Tile("cyan"), new Tile("cyan")}
                }, Piece.ShapeType.SQUARE3x),

                // elles
                new Piece(new Tile[][]{
                        {new Tile("green"), new Tile()},
                        {new Tile("green"), new Tile("green")}
                }, Piece.ShapeType.ELLE2x),
                new Piece(new Tile[][]{
                        {new Tile("grey"),new Tile(),new Tile()},
                        {new Tile("grey"),new Tile(),new Tile()},
                        {new Tile("grey"),new Tile("grey"),new Tile("grey")}
                }, Piece.ShapeType.ELLE3x)
        };
    }

    public static PieceSet getPieceSetInstance(){
        if (set == null)
            set = new PieceSet();

        return set;
    }

    public Piece getPieceByType(Piece.ShapeType type) throws IllegalArgumentException{

        for(Piece piece : this.possibleSet){
            if(piece.getType() == type){
                return piece;
            }
        }

        throw new IllegalArgumentException("Shape Out of Bounds");
    }
}
