package diecidieci.core;

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
            p.getGeometry().rotate();
        }
    }

    public void draw(){
        this.pieceSelectionPanel.repaint();
    }
}
