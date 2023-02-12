package diecidieci.graphics;

import diecidieci.core.Tile;

import javax.swing.*;
import java.awt.*;

import static diecidieci.core.Board.BOARD_DIM;

public class BoardGraphics extends JPanel {

    private TileGraphics[][] gameBoard;

    public BoardGraphics(){

        this.gameBoard = new TileGraphics[BOARD_DIM][BOARD_DIM];
        for (int i = 0; i < BOARD_DIM; i++) {
            for (int j = 0; j < BOARD_DIM; j++) {
                gameBoard[i][j] = new TileGraphics(new Tile());
            }
        }
        this.setLayout(new GridLayout(BOARD_DIM, BOARD_DIM,0,0));
        this.setPreferredSize(new Dimension(320,320));
    }

    public BoardGraphics(TileGraphics[][] gameBoard)
    {
        this.gameBoard = gameBoard;
        this.setLayout(new GridLayout(BOARD_DIM, BOARD_DIM));
        this.setPreferredSize(new Dimension(320,320));
    }

    public TileGraphics[][] getGameBoard(){
        return this.gameBoard;
    }

    @Override
    protected void paintComponent(Graphics g){
        setBackground(getBackground());
        for (int i = 0; i < BOARD_DIM; i++) {
            for (int j = 0; j < BOARD_DIM; j++) {
                this.add(gameBoard[i][j]);
            }
        }
    }
}
