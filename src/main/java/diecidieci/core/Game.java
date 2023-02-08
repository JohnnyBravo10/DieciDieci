package diecidieci.core;

import diecidieci.graphics.PieceGraphics;
import diecidieci.graphics.Window;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class Game {
    private Board board; //board di gioco

    public int points;
    public JButton rotationButton; //bottone per ruotare i pezzi
    private Piece[] availablePieces; //tre pezzi disponibili da piazzare
    private PieceGraphics[] pieceGraphicsComponents;

    private final Window window;

    public Game() {

        this.window = new Window("1010", new Dimension(1280, 720));

        this.board = new Board();

        this.availablePieces = new Piece[]{PieceSet.getRandomPiece(),PieceSet.getRandomPiece(),PieceSet.getRandomPiece()};

        this.points = 0;

        this.pieceGraphicsComponents = new PieceGraphics[3];

        for(int i = 0; i < this.pieceGraphicsComponents.length; i++)
        {
            this.pieceGraphicsComponents[i] = new PieceGraphics(this.availablePieces[i], this.pieceGraphicsComponents, i);/////////////////////////////////////////////
            this.window.getPieceSelectionPanel().add(this.pieceGraphicsComponents[i]);
        }

        //creazione bottone rotazione
        this.rotationButton = new JButton("Rotate");
        this.rotationButton.setPreferredSize(new Dimension(100, 50));

        this.rotationButton.addActionListener(e -> {
            for(int i = 0; i < this.availablePieces.length; i++)
            {
                this.availablePieces[i].getPieceGeometry().rotate();
                this.pieceGraphicsComponents[i].repaint();
            }
        });

        this.window.getMainPanel().add(this.board.getBoardGraphics());
        this.window.getMainPanel().add(new JLabel("Punteggio: " + this.points));
        this.window.getMainPanel().add(this.window.getPieceSelectionPanel());
        this.window.getMainPanel().add(this.rotationButton);

        this.window.getWindowFrame().add(this.window.getMainPanel());

        this.window.getWindowFrame().pack();

        this.window.getWindowFrame().setVisible(true);
    }

    public void addPoints(int increment){
        this.points += increment;
    }
    }