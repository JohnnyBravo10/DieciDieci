package org.example;

import javax.swing.*;
import java.awt.*;


public class Game {
    public JFrame gameFrame;
    private Board Board; //board di gioco

    public int points;

    public JLabel punteggio;

    public JButton rotationButton; //bottone per ruotare i pezzi
    private Piece[] availablePieces; //tre pezzi disponibili da piazzare

    public Game() {
        this.gameFrame = new JFrame("1010");
        this.Board = new Board();
        this.availablePieces=new Piece[]{PieceSet.getRandomPiece(),PieceSet.getRandomPiece(),PieceSet.getRandomPiece()};

        this.gameFrame.setSize(1200, 800);
        this.gameFrame.setResizable(true);
        this.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.punteggio=new JLabel("Points: "+this.points);

        //in JPanel p sono disegnate board e pezzi disponibili
        JPanel p = new JPanel() {
            //per rappresentare figure è sufficiente fare override del metodo paint di JPanel
            //qui vengono disegnata board e tre pezzi, c'è da capire come fare a refreshare il jframe quando Board viene modificata o available pieces viene cambiato
            @Override
            public void paint(Graphics gr) {
                //rappresentazione board
                for (int i = 0; i < Board.gameBoard.length; i++) {
                    for (int j = 0; j < Board.gameBoard[i].length; j++) {
                        gr.setColor(Board.gameBoard[i][j].getColor());
                        gr.fillRect(300 + 40 * i, 20 + 40 * j, 39, 39);
                    }
                }

                //rappresentazione dei tre pezzi disponibili
                for (int l=0; l<availablePieces.length; l++){//per ognuno dei tre pezzi
                    gr.setColor(availablePieces[l].getPieceColor());//seleziono il colore del pezzo
                    for (int k=0; k<availablePieces[l].getPieceGeometry().getShape().getRowDimension(); k++){//per ogni quadratino del pezzo
                        gr.fillRect((int)(120/*offset da sinistra*/+250*l/*distanza tra i punti (0,0) dei pezzi*/+ 40*availablePieces[l].getPieceGeometry().getShape().getRow(k)[0]/*ascissa del quadratino*/), (int)(550 /*offset dall'alto del (0,0) dei pezzi*/-40*availablePieces[l].getPieceGeometry().getShape().getRow(k)[1]/*ascissa del quadratino*/), 39,39);
                    }
                }
            }
        };

        //in JPAnel q c'è il tasto per ruotare
        this.rotationButton= new JButton("Rotate");
        JPanel q= new JPanel();
        q.add(this.rotationButton);
        q.setBounds(800,550,200,200);
        this.gameFrame.add(q);


        //in JPanel r c'è il punteggio
        JPanel r=new JPanel();
        r.add(this.punteggio);
        r.setBounds(800,300,200,200);
        this.gameFrame.add(r);

        p.setBounds(0,0,1000,800);
        this.gameFrame.add(p);

    }
    }