package diecidieci.core;

import diecidieci.graphics.PieceTripletGraphics;

public class PieceTriplet {
    public final Piece[] pieces;
    public PieceTripletGraphics selectionPanel;

    //generatore di una tripletta dati i tre pezzi
    public PieceTriplet(Piece[] pieces){
        this.pieces = pieces;
        this.selectionPanel = new PieceTripletGraphics(this.pieces);
    }

    //metodo per ruotare tutti i pezzi di una tripletta
    public void rotateAll(){
        for(Piece p : pieces){
            p.getGeometry().rotate();
        }
    }

    //metodo per fare repaint del selectionPanel
    public void draw(){
        this.selectionPanel.repaint();
    }
}
