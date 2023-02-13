package diecidieci.core;

import diecidieci.graphics.PieceGraphics;
import diecidieci.graphics.PieceTripletGraphics;

public class PieceTriplet {
    public Piece[] pieces;
    public PieceTripletGraphics pieceSelectionPanel;

    public PieceTriplet(Piece[] pieces){
        this.pieces=pieces;
        this.pieceSelectionPanel = new PieceTripletGraphics(this.pieces);
    }

    public void rotateAll(){
        for(Piece p : pieces){
            p.getPieceGeometry().rotate();
        }
    }

    public void draw(){
        this.pieceSelectionPanel.repaint();
    }
}
