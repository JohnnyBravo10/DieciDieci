package org.example;

public class Board {

    public Tile[][] gameBoard;
    public Board(){
        this.gameBoard = new Tile [10][10];
        for (int i=0; i< 10; i++){
            for (int j=0; j< 10; j++){
                gameBoard[i][j] = new Tile();
            }
        }
    }
}
