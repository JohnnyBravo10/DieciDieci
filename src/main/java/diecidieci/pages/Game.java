package diecidieci.pages;

import diecidieci.core.*;
import diecidieci.graphics.PieceTripletGraphics;

import javax.swing.*;


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
        this.window.getFrame().setVisible(true);
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

    // TODO: Probabilmente c'è un modo per farlo meglio Game non credo deve prendersi le responsabilità di qualcosa che deve fare la classe Piece

    public Board getBoard(){
        return this.board;
    }

    public Score getPunteggio(){
        return this.score;
    }

    public PieceTriplet getAvailablePieces(){ return this.availablePieces;}


    //verifica della disponibilità o meno di pezzi
    public boolean checkAvailability() {
        for (Piece x : this.availablePieces.pieces
        ) {
            if (x.available) {
                return true;
            }
        }
        return false;
    }

    //generazione di 3 nuovi pezzi da piazzare
    public void refreshPieces(){
        this.availablePieces = new PieceTriplet(new Piece[]{PieceSet.getRandomPiece(),PieceSet.getRandomPiece(),PieceSet.getRandomPiece()});
    }

    //window getter
    public GameWindow getWindow() {
        return window;
    }

    //aggiorno board
    public void updateBoard(){
        this.getBoard().boardGraphics.repaint();
    }

    //aggiorno il punteggio
    public void updateScore(){
        this.getPunteggio().pointsLabel.setText("Punteggio: " + Game.getInstance().getPunteggio().points);
    }

    //aggiorno availablePieces (necessario quando genero nuovi pezzi, quando ruoto quelli esistenti basta draw)
    public void updateAvailablePieces(){
        this.getAvailablePieces().pieceSelectionPanel = new PieceTripletGraphics(this.getAvailablePieces().pieces);
        this.getLowerPanel().remove(0);
        this.getLowerPanel().add(this.getAvailablePieces().pieceSelectionPanel, 0);
    }

    //accesso al lowerPanel
    public JPanel getLowerPanel(){
        return (JPanel)this.getWindow().getMainPanel().getComponent(1);
    }

    //chiusura frame
    public void disposeWindow(){
        this.getWindow().getFrame().dispose();
    }
}