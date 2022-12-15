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
}
