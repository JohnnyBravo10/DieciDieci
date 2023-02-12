package diecidieci.core;

import diecidieci.graphics.PieceGraphics;
import diecidieci.graphics.Window;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class Game {
    public static Board board; //board di gioco
    public static Punteggio punteggio;
    public JButton rotationButton; //bottone per ruotare i pezzi
    public static PieceTriplet availablePieces; //tre pezzi disponibili da piazzare, anche questo campo probabilmente dovrà essere reso statico
    private static Piece selectedPiece;

    private static Tile selectedTile;
    private final Window window;

    public Game() {

        this.window = new Window("1010", new Dimension(780, 780));

        board = new Board();

        this.availablePieces = new PieceTriplet(new Piece[]{PieceSet.getRandomPiece(),PieceSet.getRandomPiece(),PieceSet.getRandomPiece()});

        this.punteggio= new Punteggio(0);

        //creazione bottone rotazione, anche per questo si potrebbe forse creare una classe apposita che estenda JButton
        this.rotationButton = new JButton("Rotate");
        this.rotationButton.setSize(new Dimension(100, 50));

        this.rotationButton.addActionListener(e -> {
            for(int i = 0; i < this.availablePieces.pieces.length; i++)
            {
                this.availablePieces.pieces[i].getPieceGeometry().rotate();
                //this.availablePieces.pieceSelectionPanel.pieceGraphicsComponents[i].repaint();
                //faccio direttamente il repaint del pannello fuori dal for
            }
            this.availablePieces.pieceSelectionPanel.repaint();
        });

        JPanel upperPanel = new JPanel();
        upperPanel.add(this.punteggio.pointsLabel);
        upperPanel.add(board.getBoardGraphics());

        JPanel lowerPanel = new JPanel();
        lowerPanel.add(this.availablePieces.pieceSelectionPanel);
        lowerPanel.add(this.rotationButton);

        this.window.getMainPanel().add(upperPanel);
        this.window.getMainPanel().add(lowerPanel);

        this.window.getWindowFrame().add(this.window.getMainPanel());
        this.window.getWindowFrame().pack();
        this.window.getWindowFrame().setVisible(true);
    }

    public static void addPoints(int increment){
        punteggio.points += increment;
    }

    public static void setSelectedPiece (Piece p){
        selectedPiece=p;
    }

    public static Piece getSelectedPiece(){
        return selectedPiece;
    }

    public static void setSelectedTile(Tile t){
        selectedTile = t;
    }
    public static Tile getSelectedTile(){
        return selectedTile;
    }
    }