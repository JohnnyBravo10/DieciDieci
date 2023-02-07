package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game {
    public JFrame gameFrame;


    private Board Board; //board di gioco
    public int points;
    public JButton rotationButton; //bottone per ruotare i pezzi
    private Piece[] availablePieces; //tre pezzi disponibili da piazzare



    private JPanel piecesPanel;

    public Game() {
        this.gameFrame = new JFrame("1010");
        this.Board = new Board();
        this.availablePieces=new Piece[]{PieceSet.getRandomPiece(),PieceSet.getRandomPiece(),PieceSet.getRandomPiece()};
        this.gameFrame.setSize(1200, 800);
        this.gameFrame.setResizable(true);
        this.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.points=0;

        //creazione di 4 JPanel da inserire nel JFrame per: board, pezzi, bottone rotazione, punteggio

        JPanel gameBoardPanel = new JPanel() {
            //per rappresentare figure è sufficiente fare override del metodo paint di JPanel
            //qui vengono disegnata board e tre pezzi, c'è da capire come fare a refreshare il jframe quando Board viene modificata o available pieces viene cambiato
            @Override
            public void paint(Graphics gr) {
                //rappresentazione board
                for (int i = 0; i < Board.gameBoard.length; i++) {
                    for (int j = 0; j < Board.gameBoard[i].length; j++) {
                        gr.setColor(Board.gameBoard[i][j].getColor());
                        gr.fillRect(300 + 35 * i, 20 + 35 * j, 34, 34);
                    }
                }
            }
        };

        //creazione bottone rotazione
        this.rotationButton= new JButton("Rotate");
        this.rotationButton.addActionListener(e -> {
            for (Piece piece : this.availablePieces){
                piece.getPieceGeometry().rotate();
                this.updatePiecesPanel();
                }
        });
        JPanel rotationPanel= new JPanel();
        rotationPanel.add(this.rotationButton);
        rotationPanel.setBounds(800,550,200,200);
        this.gameFrame.add(rotationPanel);

        JPanel pointsPanel=new JPanel();
        pointsPanel.add(new JLabel("Points: "+ this.points));
        pointsPanel.setBounds(800,300,200,200);
        this.gameFrame.add(pointsPanel);

        gameBoardPanel.setBounds(0,0,1000,500);
        this.gameFrame.add(gameBoardPanel);

        this.updatePiecesPanel();
    }

    public void updatePiecesPanel(){

        if (this.piecesPanel!=null){
            this.piecesPanel=null;
        }

        Piece[] ap=this.availablePieces;
    this.piecesPanel= new JPanel() {
        public void paint(Graphics gr) {
            //rappresentazione dei tre pezzi disponibili
            for (int l = 0; l < ap.length; l++) {//per ognuno dei tre pezzi
                gr.setColor(ap[l].getPieceColor());//seleziono il colore del pezzo
                for (int k = 0; k < ap[l].getPieceGeometry().getShape().getRowDimension(); k++) {//per ogni quadratino del pezzo
                    gr.fillRect((int) (150/*offset da sinistra*/ + 250 * l/*distanza tra i punti (0,0) dei pezzi*/ + 35 * ap[l].getPieceGeometry().getShape().getRow(k)[0]/*ascissa del quadratino*/), (int) (520 /*offset dall'alto del (0,0) dei pezzi*/ - 35 * ap[l].getPieceGeometry().getShape().getRow(k)[1]/*ascissa del quadratino*/), 34, 34);
                }
            }
        }
    };
    this.piecesPanel.setBounds(0,500,1000,300);
    this.gameFrame.add(this.piecesPanel);
    SwingUtilities.updateComponentTreeUI(this.gameFrame);
    }
    }