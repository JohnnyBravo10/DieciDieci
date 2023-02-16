package diecidieci.graphics;

import diecidieci.pages.EndGame;
import diecidieci.pages.Game;
import diecidieci.core.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TileGraphics extends JComponent {

    private final Tile tile;

    //costruttore TileGraphics con MouseListener
    public TileGraphics(Tile tile, Double[] coordinate) {//le coordinate servono per dire dove si trova il tile nella board per piazzare il pezzo quando si clicca
        this.tile = tile;

        this.setSize(new Dimension(32, 32));

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                if (Game.getInstance().getBoard().canBePlaced(Game.getInstance().getSelectedPiece(), coordinate)) {//se il pezzo ci sta

                    Game.getInstance().getBoard().place(Game.getInstance().getSelectedPiece(), coordinate); //piazzo il pezzo
                    Game.getInstance().addPoints(Game.getInstance().getSelectedPiece().getSize()); //incremento il punteggio (si potrebbe includere nel metodo place)
                    Game.getInstance().getBoard().checkBoard(); //libero colonne o righe piene (e incremento punteggi)

                    Game.getInstance().getSelectedPiece().setUnavailable(); //cancello pezzo dal panello in basso
                    Game.getInstance().setSelectedPiece(null);//deseleziono

                    Game.getInstance().getBoard().boardGraphics.repaint(); //aggiorno la board
                    Game.getInstance().getPunteggio().pointsLabel.setText("Punteggio: " + Game.getInstance().getPunteggio().points); //aggiorno il punteggio

                    if (!Game.getInstance().checkAvailability()) {//se non ci sono più pezzi
                        Game.getInstance().refreshPieces();
                        Game.getInstance().getAvailablePieces().pieceSelectionPanel = new PieceTripletGraphics(Game.getInstance().getAvailablePieces().pieces);
                        ((JPanel)Game.getInstance().getWindow().getMainPanel().getComponent(1)).remove(0);
                        ((JPanel)Game.getInstance().getWindow().getMainPanel().getComponent(1)).add(Game.getInstance().getAvailablePieces().pieceSelectionPanel, 0);
                    }
                    Game.getInstance().getAvailablePieces().draw();//aggiorno pezzi
                    if (Game.getInstance().getBoard().shouldStop(Game.getInstance().getAvailablePieces())) {//se non si riesce più a giocare
                        Game.getInstance().getWindow().getFrame().dispose();
                        EndGame endgame = new EndGame();
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}

        });
    }

    //rappresentazione TileGraphics
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(this.tile.getColor());//seleziono il colore del tile
        g.fillRect(0, 0, Tile.getSize(), Tile.getSize());
    }
}
