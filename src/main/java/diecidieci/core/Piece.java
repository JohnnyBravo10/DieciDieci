package diecidieci.core;

import java.awt.*;


public class Piece {

    private final PieceGeometry geometry;
    private final ShapeType type;
    private final Color color;
    private final int size;

    public boolean available;

    public Piece(PieceGeometry pieceGeometry, ShapeType type, Color pieceColor){
        this.geometry = pieceGeometry;
        this.type = type;
        this.color = pieceColor;
        this.size = pieceGeometry.getShape().getRowDimension();
        this.available = true;
    }

    public Piece(Piece piece){
        this.geometry = new PieceGeometry(piece.getGeometry());
        this.type = piece.type;
        this.color = piece.getColor();
        this.size = piece.getGeometry().getShape().getRowDimension();
        this.available = piece.available;
    }
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

    // GETTERS
    public PieceGeometry getGeometry(){
        return this.geometry;
    }

    public Color getColor() {
        return this.color;
    }

    public int getSize(){return this.size;}

    public void setUnavailable(){ this.available = false;}
}






