package diecidieci.core;


import diecidieci.graphics.BoardGraphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board {

    // TODO: May be it can be a singleton class since we need only one board but idk

    public static Tile[][] gameBoard;
    public final BoardGraphics boardGraphics;
    public static final int BOARD_DIM = 10;

    //costruttore di board vuota
    public Board() {
        this.gameBoard = new Tile[BOARD_DIM][BOARD_DIM];

        for (int i = 0; i < BOARD_DIM; i++) {
            for (int j = 0; j < BOARD_DIM; j++) {
                gameBoard[i][j] = new Tile();
            }
        }

        this.boardGraphics = new BoardGraphics(this.gameBoard);
        this.boardGraphics.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                //TODO: determinare su che casella ci si trova col mouse, verificare che il selectedPeace possa essere inserito in quel punto (metodo canBePlaced)
                //eventualmente piazzarlo nella board (metodo place)
                Game.board.boardGraphics.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
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
            }
            if (!tokeepColumns[i]) {
                for (int j = 0; j < BOARD_DIM; j++) {
                    this.gameBoard[j][i].makeAvailable();
                }
            }
        }
    }
    //metodo per determinare se un dato pezzo può essere posizionato con il leftcorner posizionato sul tile della gameboard cliccato (accetta indici del tile sulla matrice gameboard)
    //forse gli indici della casella della board cliccata potrebbero essere anche descritti da un array di int


    public boolean canBePlaced(Piece p, Double[] clickedPosition) throws ArrayIndexOutOfBoundsException {
        try {
            for (int i = 0; i < p.getPieceGeometry().getShape().getRowDimension(); i++) {
                if (!this.gameBoard[(int) (clickedPosition[0] + p.getPieceGeometry().getLeftSquareCorner().getEntry(1) - p.getPieceGeometry().getShape().getRow(i)[1])][(int) (clickedPosition[1] - p.getPieceGeometry().calculateLeftCorner()[0] + p.getPieceGeometry().getShape().getRow(i)[0])].isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (
                ArrayIndexOutOfBoundsException IndexOutOfBoundsException) { //in this case the piece can't be placed beacause it's totally or partially out of the board
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

}


