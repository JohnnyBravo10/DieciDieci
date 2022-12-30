package org.example;

import java.awt.*;


public class Piece {

    private final PieceGeometry pieceGeometry;
    private final ShapeType type;
    private final Color pieceColor;

    public Piece(PieceGeometry pieceGeometry, ShapeType type, Color pieceColor){
        this.pieceGeometry = pieceGeometry;
        this.type = type;
        this.pieceColor = pieceColor;
    }
    //il costruttore di pezzi di forma casuale è Pieceset.getRandomPiece

    public enum ShapeType{
        SQUARE2x,
        SQUARE3x,
        STRAIGHT1x,
        STRAIGHT2x,
        STRAIGHT3x,
        STRAIGHT4x,
        STRAIGHT5x,
        ELLE2x,
        ELLE3x,
        REVERSED_ELLE2X,
        REVERSED_ELLE3X

    }

    // GETTERS
    public ShapeType getType() {
        return this.type;
    }
    public PieceGeometry getPieceGeometry(){
        return this.pieceGeometry;
    }

    public Color getPieceColor() {
        return this.pieceColor;
    }
}






