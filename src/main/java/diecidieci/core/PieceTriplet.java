package diecidieci.core;

import diecidieci.graphics.PieceGraphics;
import diecidieci.graphics.PieceTripletGraphics;

public class PieceTriplet {
    public Piece[] pieces;
    public PieceTripletGraphics pieceSelectionPanel;
    public PieceTriplet(Piece[] pieces){

        this.pieces=pieces;
        this.pieceSelectionPanel=new PieceTripletGraphics(this.pieces);

    }
}
