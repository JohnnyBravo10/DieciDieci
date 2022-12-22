package org.example;

public class Board {

    // TODO: May be it can be a singleton class since we need only one board but idk

    public Tile[][] gameBoard;
    public static final int BOARD_DIM = 10;

    //costruttore di board vuota
    public Board(){
        this.gameBoard = new Tile [BOARD_DIM][BOARD_DIM];

        for (int i=0; i < BOARD_DIM; i++){
            for (int j=0; j < BOARD_DIM; j++){
                gameBoard[i][j] = new Tile();
            }
        }
    }
    // metodo che controlla righe, colonne e rende bianche quelle completate
    public void checkBoard() {
        boolean[] tokeepColumns = checkColumns();
        boolean[] tokeepRows = checkRows();

        cleanBoard(tokeepRows, tokeepColumns);
    }

    // metodo per controllare le colonne
    public boolean[] checkColumns(){
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
    public boolean[] checkRows(){
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
    public void cleanBoard(boolean[] tokeepRows, boolean[] tokeepColumns){

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
}

