package diecidieci.core;


import diecidieci.gameWindows.Game;
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
    // ritorna il numero di righe e colonne cancellate che verrà poi moltiplicato per 10 per assegnare i punti
    public int checkBoard() {
        boolean[] tokeepColumns = checkColumns();
        boolean[] tokeepRows = checkRows();
        int count = 0;
        for (int i = 0; i < BOARD_DIM; i++){
            if (!tokeepColumns[i]){
                count += 1;
            }
            if (!tokeepRows[i]){
                count += 1;
            }
        }
        cleanBoard(tokeepRows, tokeepColumns);
        return count;
    }

    // metodo per controllare le colonne
    public boolean[] checkColumns() {
        boolean[] tokeepColumns = new boolean[BOARD_DIM];

        for (int i = 0; i < BOARD_DIM; i++) {
            for (int j = 0; j < BOARD_DIM; j++) {
                if (this.gameBoard[j][i].isEmpty()) {
                    tokeepColumns[i] = true;
                    break;
                }
            }
        }
        return tokeepColumns;
    }

    // metodo per controllare le righe
    public boolean[] checkRows() {
        boolean[] tokeepRows = new boolean[BOARD_DIM];

        for (int i = 0; i < BOARD_DIM; i++) {
            for (int j = 0; j < BOARD_DIM; j++) {
                if (this.gameBoard[i][j].isEmpty()) {
                    tokeepRows[i] = true;
                    break;
                }
            }
        }
        return tokeepRows;
    }

    // metodo che rende bianche righe e colonne completate
    public void cleanBoard(boolean[] tokeepRows, boolean[] tokeepColumns) {

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


    //metodo per determinare se un dato pezzo può essere posizionato con il leftcorner posizionato sul tile della gameboard cliccato (accetta indici del tile sulla matrice gameboard)
    //forse gli indici della casella della board cliccata potrebbero essere anche descritti da un array di int


    public boolean canBePlaced(Piece p, Double[] clickedPosition) throws ArrayIndexOutOfBoundsException {
        try {
            for (int i = 0; i < p.getSize(); i++) {
                if (!this.gameBoard[(int) (clickedPosition[0] + p.getPieceGeometry().getLeftSquareCorner().getEntry(1) - p.getPieceGeometry().getShape().getRow(i)[1])][(int) (clickedPosition[1] - p.getPieceGeometry().calculateLeftCorner()[0] + p.getPieceGeometry().getShape().getRow(i)[0])].isEmpty()) {
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
        for (int i = 0; i < p.getPieceGeometry().getShape().getRowDimension(); i++){
            this.gameBoard[(int) (clickedPosition[0] + p.getPieceGeometry().getLeftSquareCorner().getEntry(1) - p.getPieceGeometry().getShape().getRow(i)[1])][(int) (clickedPosition[1] - p.getPieceGeometry().calculateLeftCorner()[0] + p.getPieceGeometry().getShape().getRow(i)[0])].setColor(p.getPieceColor());
        }
    }

    public BoardGraphics getBoardGraphics(){
        return this.boardGraphics;
    }

    public Tile[][] getGameBoard() {
        return gameBoard;
    }

    public boolean shouldStop(PieceTriplet triplet) {
        Piece firstPiece = new Piece(triplet.pieces[0]);
        Piece secondPiece = new Piece(triplet.pieces[1]);
        Piece thirdPiece = new Piece(triplet.pieces[2]);
        for (int k = 0; k < 4; k++) {
            for (int i=0; i<BOARD_DIM; i++){
                for (int j=0; j<BOARD_DIM; j++){
                    Double[] coord = {(double) i, (double) j};
                    if ((canBePlaced(firstPiece,coord) && firstPiece.available) || (canBePlaced(secondPiece,coord) && secondPiece.available) || (canBePlaced(thirdPiece,coord) && thirdPiece.available)){
                        return false;
                    }
                }
            }
            firstPiece.getPieceGeometry().rotate();
            secondPiece.getPieceGeometry().rotate();
            thirdPiece.getPieceGeometry().rotate();
        }
        return true;
    }
}


