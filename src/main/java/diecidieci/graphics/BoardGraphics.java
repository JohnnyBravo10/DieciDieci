package diecidieci.graphics;

import diecidieci.core.Tile;
import javax.swing.*;
import java.awt.*;
import static diecidieci.core.Board.BOARD_DIM;

public class BoardGraphics extends JPanel {


    //costruttore BoardGraphics con matrice di TileGraphics
    public BoardGraphics(Tile[][] gameBoard) {
        this.setPreferredSize(new Dimension(330, 330));
        this.setLayout(new GridLayout(BOARD_DIM, BOARD_DIM));

        TileGraphics[][] tiles = new TileGraphics[BOARD_DIM][BOARD_DIM];

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                tiles[i][j] = new TileGraphics(gameBoard[i][j], new Double[]{(double)i,(double)j});
                this.add(tiles[i][j]);
            }
        }
    }
}
