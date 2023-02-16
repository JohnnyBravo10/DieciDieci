package diecidieci.core;

import java.awt.*;

public class Piece {

    private final PieceGeometry geometry;
    private final ShapeType type;
    private final Color color;
    private final int size;
    private boolean available;

    //costruttore di piece (per creare il possibleSet in pieceSet)
    public Piece(PieceGeometry pieceGeometry, ShapeType type, Color pieceColor){
        this.geometry = pieceGeometry;
        this.type = type;
        this.color = pieceColor;
        this.size = pieceGeometry.getShape().getRowDimension();
        this.available = true;
    }

    //costruttore di piece (per copiarne uno dal possibleSet)
    public Piece(Piece piece){
        this.geometry = new PieceGeometry(piece.geometry);
        this.type = piece.type;
        this.color = piece.color;
        this.size = piece.geometry.getShape().getRowDimension();
        this.available = piece.available;
    }
    public enum ShapeType{
        SQUARE2X,
        SQUARE3X,
        STRAIGHT1X,
        STRAIGHT2X,
        STRAIGHT3X,
        STRAIGHT4X,
        STRAIGHT5X,
        ELLE2X,
        ELLE3X
    }

    public void setUnavailable(){ this.available = false;}

    public boolean isAvailable(){ return this.available;}

    // GETTERS
    public PieceGeometry getGeometry(){
        return this.geometry;
    }

    public Color getColor() {
        return this.color;
    }

    public int getSize(){return this.size;}

}






