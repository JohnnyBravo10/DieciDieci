package org.example;

public class Board {

    // TODO: May be it can be a singleton class since we need only one board but idk

    public Tile[][] gameBoard;
    public static final int BOARD_DIM = 10;

    public Board(){
        this.gameBoard = new Tile [BOARD_DIM][BOARD_DIM];

        for (int i=0; i < BOARD_DIM; i++){
            for (int j=0; j < BOARD_DIM; j++){
                gameBoard[i][j] = new Tile();
            }
        }
    }
    // metodo che controlla riga e colonne complete e in caso rende bianchi i tile
    public void checkColumnsAndRows() {

        boolean[] tokeepColumns = new boolean[BOARD_DIM];
        boolean[] tokeepRows = new boolean[BOARD_DIM];

        for (int i = 0; i < BOARD_DIM; i++) {
            for (int j = 0; j < BOARD_DIM; j++) {
                if (this.gameBoard[i][j].isEmpty()) {
                    tokeepRows[i] = true;
                    break;
                }
            }
        }
        for (int i = 0; i < BOARD_DIM; i++) {
            for (int j = 0; j < BOARD_DIM; j++) {
                if (this.gameBoard[j][i].isEmpty()) {
                    tokeepColumns[i] = true;
                    break;
                }
            }
        }
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

