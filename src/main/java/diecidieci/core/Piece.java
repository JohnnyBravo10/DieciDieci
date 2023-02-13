package diecidieci.core;

import java.awt.*;


public class Piece {

    private final PieceGeometry pieceGeometry;
    private final ShapeType type;
    private final Color pieceColor;
    private final int size;

    public boolean visible;

    public Piece(PieceGeometry pieceGeometry, ShapeType type, Color pieceColor){
        this.pieceGeometry = pieceGeometry;
        this.type = type;
        this.pieceColor = pieceColor;
        this.size = pieceGeometry.getShape().getRowDimension();
        this.visible = true;
    }

    public Piece(Piece piece){
        this.pieceGeometry = new PieceGeometry(piece.getPieceGeometry());
        this.type = piece.type;
        this.pieceColor = piece.getPieceColor();
        this.size = piece.getPieceGeometry().getShape().getRowDimension();
        this.visible = piece.visible;
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
        ELLE3x,
        REVERSEDELLE2X,
        REVERSEDELLE3X

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

    public int getSize(){return this.size;}

    public void setInvisible(){ this.visible = false;}
}






