package diecidieci.core;

import diecidieci.graphics.PieceTripletGraphics;

public class PieceTriplet {
    public final Piece[] pieces;
    public PieceTripletGraphics pieceSelectionPanel;

    //generatore di una tripletta dati i tre pezzi
    public PieceTriplet(Piece[] pieces){
        this.pieces = pieces;
        this.pieceSelectionPanel = new PieceTripletGraphics(this.pieces);
    }

    //metodo per ruotare tutti i pezzi di una tripletta
    public void rotateAll(){
        for(Piece p : pieces){
            p.getGeometry().rotate();
        }
    }

    public void draw(){
        this.pieceSelectionPanel.repaint();
    }
}
