package org.example;

public class PieceSet {
    // Dato che il set di pezzi è singolo volevo creare una classe singleton per contenere tutti i pezzi

    private final Piece[] possibleSet;
    private static PieceSet set;

    private PieceSet(){
        this.possibleSet = new Piece[]{
                // straight pieces
                new Piece(new Tile[][]{{new Tile(true)}}, Piece.ShapeType.STRAIGHT1x),
                new Piece(new Tile[][]{{new Tile(true),new Tile(true)}}, Piece.ShapeType.STRAIGHT2x),
                new Piece(new Tile[][]{{new Tile(true),new Tile(true),new Tile(true)}}, Piece.ShapeType.STRAIGHT3x),
                new Piece(new Tile[][]{{new Tile(true),new Tile(true),new Tile(true),new Tile(true)}}, Piece.ShapeType.STRAIGHT4x),
                new Piece(new Tile[][]{{new Tile(true),new Tile(true),new Tile(true),new Tile(true),new Tile(true)}}, Piece.ShapeType.STRAIGHT5x),

                // squares
                new Piece(new Tile[][]{
                        {new Tile(true),new Tile(true)},
                        {new Tile(true),new Tile(true)}
                }, Piece.ShapeType.SQUARE2x),
                new Piece(new Tile[][]{
                        {new Tile(true), new Tile(true), new Tile(true)},
                        {new Tile(true), new Tile(true), new Tile(true)},
                        {new Tile(true), new Tile(true), new Tile(true)}
                }, Piece.ShapeType.SQUARE3x),

                // elles
                new Piece(new Tile[][]{
                        {new Tile(true), new Tile()},
                        {new Tile(true), new Tile(true)}
                }, Piece.ShapeType.ELLE2x),
                new Piece(new Tile[][]{
                        {new Tile(true),new Tile(),new Tile()},
                        {new Tile(true),new Tile(),new Tile()},
                        {new Tile(true),new Tile(true),new Tile(true)}
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
