package diecidieci.graphics;

import diecidieci.core.Game;
import diecidieci.core.Piece;
import diecidieci.core.PieceSet;
import diecidieci.core.Tile;
import org.apache.commons.math3.linear.RealMatrix;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import static diecidieci.core.Board.BOARD_DIM;

public class TileGraphics extends JComponent {

    private Tile tile;

    public TileGraphics(Tile tile, Double[] coordinate){//le coordinate servono per dire dove si trova il tile nella board per piazzare il pezzo quando si clicca
        this.tile = tile;

        this.setSize(new Dimension(32,32) );

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (Game.getInstance().getBoard().canBePlaced(Game.getInstance().getSelectedPiece(), coordinate)) {//se il pezzo ci sta

                    Game.getInstance().getBoard().place(Game.getInstance().getSelectedPiece(), coordinate); //piazzo il pezzo
                    Game.getInstance().addPoints(Game.getInstance().getSelectedPiece().getSize()); //incremento il punteggio (si potrebbe includere nel metodo place)
                    Game.getInstance().getBoard().checkBoard(); //libero colonne o righe piene (e incremento punteggi)


                    Game.getInstance().getBoard().boardGraphics.repaint(); //aggiorno la board
                    Game.getInstance().getPunteggio().pointsLabel.setText("Punteggio: " + Game.getInstance().getPunteggio().points); //aggiorno il punteggio

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
        g.setColor(this.tile.getColor());//seleziono il colore del tile
        g.fillRect(0,0, Tile.getSize(), Tile.getSize());
    }

    public Tile getTile(){return this.tile;}
}
