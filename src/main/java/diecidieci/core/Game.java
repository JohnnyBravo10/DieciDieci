package diecidieci.core;

import diecidieci.graphics.PieceGraphics;
import diecidieci.graphics.Window;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class Game {
    public static Board board; //board di gioco
    public int points;
    public JButton rotationButton; //bottone per ruotare i pezzi
    private PieceTriplet availablePieces; //tre pezzi disponibili da piazzare, anche questo campo probabilmente dovrà essere reso statico
    private static Piece selectedPiece;
    private final Window window;

    public Game() {

        this.window = new Window("1010", new Dimension(1280, 720));

        board = new Board();

        this.availablePieces = new PieceTriplet(new Piece[]{PieceSet.getRandomPiece(),PieceSet.getRandomPiece(),PieceSet.getRandomPiece()});

        this.points = 0;



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

        this.window.getMainPanel().add(board.getBoardGraphics());
        this.window.getMainPanel().add(new JLabel("Punteggio: " + this.points));//per ordine si potrebbe anche fare una classe per questo ma idk
        this.window.getMainPanel().add(this.availablePieces.pieceSelectionPanel);
        this.window.getMainPanel().add(this.rotationButton);

        this.window.getWindowFrame().add(this.window.getMainPanel());
        this.window.getWindowFrame().pack();
        this.window.getWindowFrame().setVisible(true);
    }

    public void addPoints(int increment){
        this.points += increment;
    }

    public static void setSelectedPiece (Piece p){
        selectedPiece=p;
    }

    public static Piece getSelectedPiece(){
        return selectedPiece;
    }
    }