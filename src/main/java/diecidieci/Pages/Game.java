package diecidieci.Pages;

import diecidieci.core.*;

import javax.swing.*;


public class Game {
    private static Game instance;
    private final Board board; //board di gioco
    private final Score score;
    private final RotationButton rotationButton; //bottone per ruotare i pezzi
    private PieceTriplet availablePieces; //tre pezzi disponibili da piazzare, anche questo campo probabilmente dovrà essere reso statico
    private Piece selectedPiece;
    private final GameWindow window;

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

    public static Game getInstance(){
        if (instance == null){
            instance = new Game();
        }
        return instance;
    }

    protected void startNewGame(){
        instance = new Game();
    }

    public void addPoints(int increment){
        this.score.points += increment;
    }

    public void setSelectedPiece (Piece piece){
        this.selectedPiece = piece;
    }

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


    //ritorna true se ci sono ancora pezzi da inserire nella board
    public boolean checkAvailability() {
        for (Piece x : this.availablePieces.pieces
        ) {
            if (x.available) {
                return true;
            }
        }
        return false;
    }

    // metodo da aggiustare
    public void refreshPieces(){
        this.availablePieces = new PieceTriplet(new Piece[]{PieceSet.getRandomPiece(),PieceSet.getRandomPiece(),PieceSet.getRandomPiece()});
        //this.availablePieces.draw();
    }

    public GameWindow getWindow() {
        return window;
    }
}