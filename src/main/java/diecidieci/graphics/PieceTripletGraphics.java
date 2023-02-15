package diecidieci.graphics;

import diecidieci.core.Piece;

import javax.swing.*;
import java.awt.*;

public class PieceTripletGraphics extends JPanel {

    public PieceGraphics[] components;
    public PieceTripletGraphics(Piece[] pieces){
        this.setLayout(new GridLayout(1, 3));

        this.components = new PieceGraphics[3];

        for(int i = 0; i < components.length; i++)
        {
            components[i] = new PieceGraphics(pieces[i], this.components, i);
            this.add(this.components[i]);
        }
    }
}
