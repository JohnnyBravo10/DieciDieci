package diecidieci.pages;

import diecidieci.core.*;
import diecidieci.graphics.PieceTripletGraphics;

import javax.swing.*;
import java.awt.*;


public class Game {
    private static Game instance;
    private final Board board; //board di gioco
    private final Score score;
    private final RotationButton rotationButton; //bottone per ruotare i pezzi
    private PieceTriplet availablePieces; //tre pezzi disponibili da piazzare
    private Piece selectedPiece;
    private final GameWindow window;

    //costruttore Game con window riempita da 4 entità (punteggio, plancia, pezzi, tasto rotazione)
    private Game() {

        this.window = new GameWindow("1010");

        this.board = new Board();
        this.availablePieces = new PieceTriplet(new Piece[]{PieceSet.getRandomPiece(),PieceSet.getRandomPiece(),PieceSet.getRandomPiece()});
        this.score = new Score(0);
        this.rotationButton = new RotationButton();

        JPanel upperPanel = new JPanel();
        upperPanel.add(this.score.pointsLabel);
        upperPanel.add(this.board.boardGraphics);

        JPanel lowerPanel = new JPanel();
        lowerPanel.add(this.availablePieces.pieceSelectionPanel);
        lowerPanel.add(this.rotationButton);

        this.window.getMainPanel().add(upperPanel);
        this.window.getMainPanel().add(lowerPanel);

        this.window.getFrame().add(this.window.getMainPanel());
        this.window.getFrame().pack();
        if (!GraphicsEnvironment.isHeadless()) {
            this.window.getFrame().setVisible(true);
        }
    }

    //instance getter
    public static Game getInstance(){
        if (instance == null){
            instance = new Game();
        }
        return instance;
    }

    //inizio nuova partita
    protected void startNewGame(){
        instance = new Game();
    }

    //incremento punteggio
    public void addPoints(int increment){
        this.score.points += increment;
    }

    //set SelectedPiece
    public void setSelectedPiece (Piece piece){
        this.selectedPiece = piece;
    }

    //getters
    public Piece getSelectedPiece(){
        return this.selectedPiece;
    }

    public Score getScore(){
        return this.score;
    }

    public PieceTriplet getAvailablePieces(){ return this.availablePieces;}


    //verifica della disponibilità o meno di pezzi
    public boolean checkPieceAvailability() {
        for (Piece x : this.availablePieces.pieces
        ) {
            if (x.available) {
                return true;
            }
        }
        return false;
    }

    //generazione di 3 nuovi pezzi da piazzare
    private PieceTriplet refreshPieces(){
        return new PieceTriplet(new Piece[]{PieceSet.getRandomPiece(),PieceSet.getRandomPiece(),PieceSet.getRandomPiece()});
    }

    //aggiorno board
    private void drawBoard(){
        this.board.boardGraphics.repaint();
    }

    //aggiorno il punteggio
    private void updateScore(){
        this.score.pointsLabel.setText("Punteggio: " + this.score.points);
    }

    //aggiorno availablePieces (necessario quando genero nuovi pezzi, quando ruoto quelli esistenti basta draw)
    public void updateAvailablePieces(){
        this.availablePieces = this.refreshPieces();
        this.availablePieces.pieceSelectionPanel = new PieceTripletGraphics(this.availablePieces.pieces);
        this.getLowerPanel().remove(0);
        this.getLowerPanel().add(this.availablePieces.pieceSelectionPanel, 0);
    }

    //accesso al lowerPanel
    private JPanel getLowerPanel(){
        return (JPanel)this.window.getMainPanel().getComponent(1);
    }

    //chiusura frame
    private void disposeWindow(){
        this.window.getFrame().dispose();
    }

    public void update(Double[] coordinate){
        if (this.board.canBePlaced(this.getSelectedPiece(), coordinate)) {//se il pezzo ci sta
            this.updateOnPiecePlaced(coordinate);
            if (!this.checkPieceAvailability()) {//se non ci sono più pezzi
                this.updateAvailablePieces();
            }
            this.availablePieces.draw();//aggiorno pezzi
            if (this.board.shouldStop(this.availablePieces)) {//se non si riesce più a giocare
                this.disposeWindow();
                new EndMenu();
            }
        }
    }

    private void updateOnPiecePlaced(Double[] coordinate){
        this.board.place(this.selectedPiece, coordinate); //piazzo il pezzo
        this.addPoints(this.selectedPiece.getSize()); //incremento il punteggio (si potrebbe includere nel metodo place)
        this.board.checkBoard(); //libero colonne o righe piene (e incremento punteggi)

        this.selectedPiece.setUnavailable(); //cancello pezzo dal panello in basso
        this.setSelectedPiece(null);//deseleziono

        this.drawBoard(); //aggiorno la board
        this.updateScore();
    }
}