package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game {
    public JFrame gameFrame;
    private Board board; //board di gioco

    public int points;
    public JButton rotationButton; //bottone per ruotare i pezzi
    private Piece[] availablePieces; //tre pezzi disponibili da piazzare
    private PieceGraphics[] pieceGraphicsComponents;

    public Game() {
        this.gameFrame = new JFrame("1010");

        this.board = new Board();

        // TODO: Aggiungere copy constuctor

        this.availablePieces=new Piece[]{PieceSet.getRandomPiece(),PieceSet.getRandomPiece(),PieceSet.getRandomPiece()};

        this.gameFrame.setPreferredSize(new Dimension(1280, 750));/////////////////////////////

        this.gameFrame.setResizable(false);

        this.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.points = 0;

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(5, 20, 20, 20));////////////////////////////////////
        mainPanel.setLayout(new GridLayout(2,2));

        JPanel pieceSelectionPanel = new JPanel();
        pieceSelectionPanel.setLayout(new GridLayout(1, 3));

        JComponent boardComponent = new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                setBackground(getBackground());
                for (int i = 0; i < board.gameBoard.length; i++) {
                    for (int j = 0; j < board.gameBoard[i].length; j++) {
                        g.setColor(board.gameBoard[i][j].getColor());
                        g.fillRect(33 * i, 33 * j, 32, 32);////////////////////////////
                    }
                }
            }
        };

        this.pieceGraphicsComponents = new PieceGraphics[3];

        for(int i = 0; i < this.pieceGraphicsComponents.length; i++)
        {
            this.pieceGraphicsComponents[i] = new PieceGraphics(this.availablePieces[i], this.pieceGraphicsComponents, i);/////////////////////////////////////////////
            pieceSelectionPanel.add(this.pieceGraphicsComponents[i]);
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

        mainPanel.add(boardComponent);
        mainPanel.add(new JLabel("Punteggio: " + this.points));
        mainPanel.add(pieceSelectionPanel);
        mainPanel.add(this.rotationButton);

        this.gameFrame.add(mainPanel);

        this.gameFrame.pack();

    }
    public void addPoints(int increment){
        this.points += increment;
    }
    }