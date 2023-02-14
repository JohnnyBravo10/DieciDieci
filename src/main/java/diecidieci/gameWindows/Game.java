package diecidieci.gameWindows;

import diecidieci.core.*;

import javax.swing.*;
import java.awt.*;


public class Game {
    private static final int WINDOW_SIZE = 780;
    private static Game instance;

    private final Board board; //board di gioco
    private final Punteggio punteggio;
    private final JButton rotationButton; //bottone per ruotare i pezzi
    private PieceTriplet availablePieces; //tre pezzi disponibili da piazzare, anche questo campo probabilmente dovrà essere reso statico
    private Piece selectedPiece;

    private final Window window;

    private Game() {

        this.window = new Window("1010", new Dimension(WINDOW_SIZE, WINDOW_SIZE));

        this.board = new Board();

        this.availablePieces = new PieceTriplet(new Piece[]{PieceSet.getRandomPiece(),PieceSet.getRandomPiece(),PieceSet.getRandomPiece()});

        this.punteggio = new Punteggio(0);

        //creazione bottone rotazione, anche per questo si potrebbe forse creare una classe apposita che estenda JButton
        this.rotationButton = new JButton("Rotate");
        this.rotationButton.setSize(new Dimension(100, 50));

        this.rotationButton.addActionListener(e -> {
            for(int i = 0; i < this.availablePieces.pieces.length; i++)
            {
                this.availablePieces.rotateAll();
            }
            this.availablePieces.draw();
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
        this.punteggio.points += increment;
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

    public Punteggio getPunteggio(){
        return this.punteggio;
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
        this.availablePieces.draw();
    }
}