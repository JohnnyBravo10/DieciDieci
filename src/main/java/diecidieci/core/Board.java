package diecidieci.core;

import diecidieci.pages.Game;
import diecidieci.graphics.BoardGraphics;

public class Board {

    private final Tile[][] gameBoard;
    public final BoardGraphics boardGraphics;
    public static final int BOARD_DIM = 10;

    //costruttore di board vuota
    public Board() {
        this.gameBoard = new Tile[BOARD_DIM][BOARD_DIM];

        for (int i = 0; i < BOARD_DIM; i++) {
            for (int j = 0; j < BOARD_DIM; j++) {
                this.gameBoard[i][j] = new Tile();
            }
        }

        this.boardGraphics = new BoardGraphics(this.gameBoard);
    }

    // metodo che controlla righe, colonne e rende bianche quelle completate
    public void checkBoard() {
        Boolean[] tokeepColumns = checkColumns();
        Boolean[] tokeepRows = checkRows();
        cleanBoard(tokeepRows, tokeepColumns);
    }

    // metodo per controllare le colonne da tenere
    public Boolean[] checkColumns() {
        Boolean[] tokeepColumns = new Boolean[BOARD_DIM];

        for (int i = 0; i < BOARD_DIM; i++) {
            for (int j = 0; j < BOARD_DIM; j++) {
                if (this.gameBoard[j][i].isEmpty()) {
                    tokeepColumns[i] = true;
                    break;
                }
            }
            if (tokeepColumns[i] == null){
                tokeepColumns[i] = false;
            }
        }
        return tokeepColumns;
    }

    // metodo per controllare le righe da tenere
    public Boolean[] checkRows() {
        Boolean[] tokeepRows = new Boolean[BOARD_DIM];

        for (int i = 0; i < BOARD_DIM; i++) {
            for (int j = 0; j < BOARD_DIM; j++) {
                if (this.gameBoard[i][j].isEmpty()) {
                    tokeepRows[i] = true;
                    break;
                }
            }
            if (tokeepRows[i] == null){
                tokeepRows[i] = false;
            }
        }
        return tokeepRows;
    }

    // metodo che rende bianche righe e colonne completate e aggiunge i punti
    public void cleanBoard(Boolean[] tokeepRows, Boolean[] tokeepColumns) {

        for (int i = 0; i < BOARD_DIM; i++) {
            if (!tokeepRows[i]) {
                for (int j = 0; j < BOARD_DIM; j++) {
                    this.gameBoard[i][j].makeAvailable();
                }
                Game.getInstance().addPoints(10);
            }
            if (!tokeepColumns[i]) {
                for (int j = 0; j < BOARD_DIM; j++) {
                    this.gameBoard[j][i].makeAvailable();
                }
                Game.getInstance().addPoints(10);
            }
        }
    }


    //metodo per determinare se un dato pezzo può essere posizionato con il leftcorner sul tile della gameboard cliccato
    //forse gli indici della casella della board cliccata potrebbero essere anche descritti da un array di int
    public boolean canBePlaced(Piece p, Double[] clickedPosition) throws ArrayIndexOutOfBoundsException {
        if (p==null){
            return false;
        }

        try {
            for (int i = 0; i < p.getSize(); i++) {
                if (!this.gameBoard[(int) (clickedPosition[0] + p.getGeometry().getLeftSquareCorner().getEntry(1) - p.getGeometry().getShape().getRow(i)[1])][(int) (clickedPosition[1] - p.getGeometry().calculateLeftCorner()[0] + p.getGeometry().getShape().getRow(i)[0])].isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (
                ArrayIndexOutOfBoundsException indexOutOfBoundsException) { //in this case the piece can't be placed beacause it's totally or partially out of the board
            return false;
        }
    }


    //metodo da invocare per piazzare il pezzo (dopo aver verificato che c'è spazio con canBePlaced)
    public void place (Piece p, Double[] clickedPosition){
        for (int i = 0; i < p.getGeometry().getShape().getRowDimension(); i++){
            this.gameBoard[(int) (clickedPosition[0] + p.getGeometry().getLeftSquareCorner().getEntry(1) - p.getGeometry().getShape().getRow(i)[1])][(int) (clickedPosition[1] - p.getGeometry().calculateLeftCorner()[0] + p.getGeometry().getShape().getRow(i)[0])].setColor(p.getColor());
        }
    }

    //board getter
    public Tile[][] getGameBoard() {
        return gameBoard;
    }

    //metodo per verificare che ci sia ancora la possibilità di piazzare pezzi
    public boolean shouldStop(PieceTriplet triplet) {
        Piece firstPiece = new Piece(triplet.pieces[0]);
        Piece secondPiece = new Piece(triplet.pieces[1]);
        Piece thirdPiece = new Piece(triplet.pieces[2]);
        for (int k = 0; k < 4; k++) {
            for (int i=0; i<BOARD_DIM; i++){
                for (int j=0; j<BOARD_DIM; j++){
                    Double[] coord = {(double) i, (double) j};
                    if ((canBePlaced(firstPiece,coord) && firstPiece.isAvailable()) || (canBePlaced(secondPiece,coord) && secondPiece.isAvailable()) || (canBePlaced(thirdPiece,coord) && thirdPiece.isAvailable())){
                        return false;
                    }
                }
            }
            triplet.rotateAll();
        }
        return true;
    }
}