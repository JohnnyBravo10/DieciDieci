package diecidieci.graphics;

import diecidieci.core.Piece;

import javax.swing.*;
import java.awt.*;

public class PieceTripletGraphics extends JPanel {

    public PieceGraphics[] pieceGraphicsComponents;
    public PieceTripletGraphics(Piece[] pieces){
        this.setLayout(new GridLayout(1, 3));

        this.pieceGraphicsComponents = new PieceGraphics[3];

        for(int i = 0; i < pieceGraphicsComponents.length; i++)
        {
            pieceGraphicsComponents[i] = new PieceGraphics(pieces[i], this.pieceGraphicsComponents, i);/////////////////////////////////////////////
            this.add(this.pieceGraphicsComponents[i]);
        }
    }
}
