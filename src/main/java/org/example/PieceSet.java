package org.example;

import java.awt.*;

public class PieceSet {
    // Dato che il set di pezzi è singolo volevo creare una classe singleton per contenere tutti i pezzi

    private final Piece[] possibleSet;
    private static PieceSet set;

    private PieceSet(){
        this.possibleSet = new Piece[]{
                // straight pieces
                new Piece(new Tile[][]{{new Tile(new Color(175, 175, 225))}}, Piece.ShapeType.STRAIGHT1x),
                new Piece(new Tile[][]{{new Tile(Color.yellow), new Tile(Color.yellow)}}, Piece.ShapeType.STRAIGHT2x),
                new Piece(new Tile[][]{{new Tile(Color.orange), new Tile(Color.orange), new Tile(Color.orange)}}, Piece.ShapeType.STRAIGHT3x),
                new Piece(new Tile[][]{{new Tile(Color.magenta), new Tile(Color.magenta), new Tile(Color.magenta), new Tile(Color.magenta)}}, Piece.ShapeType.STRAIGHT4x),
                new Piece(new Tile[][]{{new Tile(Color.red), new Tile(Color.red), new Tile(Color.red), new Tile(Color.red), new Tile(Color.red)}}, Piece.ShapeType.STRAIGHT5x),

                // squares
                // meglio new color() o creare una variabile lightGreen = new Color() ?????
                new Piece(new Tile[][]{
                        {new Tile(new Color(175, 255, 175)), new Tile(new Color(175, 255, 175))},
                        {new Tile(new Color(175, 255, 175)), new Tile(new Color(175, 255, 175))}
                }, Piece.ShapeType.SQUARE2x),
                new Piece(new Tile[][]{
                        {new Tile(Color.cyan), new Tile(Color.cyan), new Tile(Color.cyan)},
                        {new Tile(Color.cyan), new Tile(Color.cyan), new Tile(Color.cyan)},
                        {new Tile(Color.cyan), new Tile(Color.cyan), new Tile(Color.cyan)}
                }, Piece.ShapeType.SQUARE3x),

                // elles
                new Piece(new Tile[][]{
                        {new Tile(Color.green), new Tile()},
                        {new Tile(Color.green), new Tile(Color.green)}
                }, Piece.ShapeType.ELLE2x),
                new Piece(new Tile[][]{
                        {new Tile(Color.darkGray), new Tile(), new Tile()},
                        {new Tile(Color.darkGray), new Tile(), new Tile()},
                        {new Tile(Color.darkGray), new Tile(Color.darkGray), new Tile(Color.darkGray)}
                }, Piece.ShapeType.ELLE3x),

                //reversed elles
                new Piece(new Tile[][]{
                        {new Tile(), new Tile(Color.green)},
                        {new Tile(Color.green), new Tile(Color.green)}
                }, Piece.ShapeType.REVERSEDELLE2X),


                new Piece(new Tile[][]{
                        {new Tile(), new Tile(), new Tile(Color.darkGray)},
                        {new Tile(), new Tile(), new Tile(Color.darkGray)},
                        {new Tile(Color.darkGray), new Tile(Color.darkGray), new Tile(Color.darkGray)}
                }, Piece.ShapeType.REVERSEDELLE3X)
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
