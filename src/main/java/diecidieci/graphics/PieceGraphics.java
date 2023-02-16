package diecidieci.graphics;

import diecidieci.pages.Game;
import diecidieci.core.Piece;
import diecidieci.core.Tile;
import org.apache.commons.math3.linear.RealMatrix;

import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PieceGraphics extends JComponent {

    private final Piece piece;

    //costruttore PieceGraphics con MouseListener
    public PieceGraphics(Piece piece, PieceGraphics[] array, int index){
        this.piece = piece;
        this.setPreferredSize(new Dimension(200, 200));

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Do nothing because we use mousePressed
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Game instance = Game.getInstance();
                if(getBorder()==null) {
                    setBorder(BorderFactory.createLineBorder(Color.RED));
                    instance.setSelectedPiece(piece);
                }
                else {
                    setBorder(null);
                    instance.setSelectedPiece(null);
                }

                for (int a = 0; a < array.length; a++){
                    if (a != index){
                        array[a].setBorder(null);
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Do nothing because we use mousePressed
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                // Do nothing because we use mousePressed
            }
            @Override
            public void mouseExited(MouseEvent e) {
                // Do nothing because we use mousePressed
            }
        });

    }

    //rappresentazione PieceGraphics
    @Override
    protected void paintComponent(Graphics g){
        if (!piece.available){
            this.setVisible(false);
        }

        else {
            this.setVisible(true);
            setBackground(getBackground());
            g.setColor(piece.getColor());//seleziono il colore del pezzo
            for (int k = 0; k < piece.getSize(); k++) {//per ogni quadratino del pezzo
                RealMatrix pg = piece.getGeometry().getShape();
                g.fillRect((int) (this.getPreferredSize().width / 2 + (Tile.getSize() + 1) * (pg.getRow(k)[0] - 0.5)/*ascissa del quadratino*/),
                        (int) (this.getPreferredSize().height / 2 - (Tile.getSize() + 1) * (pg.getRow(k)[1] + 0.5)), Tile.getSize(), Tile.getSize());
            }
        }
    }

    //piece getter
    public Piece getPiece(){
        return this.piece;
    }
}

