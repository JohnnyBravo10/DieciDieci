package diecidieci.graphics;

import diecidieci.core.Game;
import diecidieci.core.Piece;
import diecidieci.core.Tile;
import org.apache.commons.math3.linear.RealMatrix;

import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PieceGraphics extends JComponent {

    private Piece piece;

    public PieceGraphics(Piece piece, PieceGraphics[] array, int index){
        this.piece = piece;
        this.setPreferredSize(new Dimension(200, 200));

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

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

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    @Override
    protected void paintComponent(Graphics g){
        if (piece!=null) {
            setBackground(getBackground());
            g.setColor(piece.getPieceColor());//seleziono il colore del pezzo
            for (int k = 0; k < piece.getPieceGeometry().getShape().getRowDimension(); k++) {//per ogni quadratino del pezzo
                RealMatrix pg = piece.getPieceGeometry().getShape();
                g.fillRect((int) (this.getPreferredSize().width / 2 + (Tile.getSize() + 1) * (pg.getRow(k)[0] - 0.5)/*ascissa del quadratino*/),
                        (int) (this.getPreferredSize().height / 2 - (Tile.getSize() + 1) * (pg.getRow(k)[1] + 0.5)), Tile.getSize(), Tile.getSize());
            }
        }
    }

}

