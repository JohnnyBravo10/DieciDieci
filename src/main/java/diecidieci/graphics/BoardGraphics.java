package diecidieci.graphics;

import diecidieci.core.Tile;

import javax.swing.*;
import java.awt.*;

public class BoardGraphics extends JComponent {

    private Tile[][] gameBoard;

    public BoardGraphics(Tile[][] gameBoard)
    {
        this.gameBoard = gameBoard;
    }

    @Override
    protected void paintComponent(Graphics g){
        setBackground(getBackground());
        for (int i = 0; i < this.gameBoard.length; i++) {
            for (int j = 0; j < this.gameBoard[i].length; j++) {
                g.setColor(this.gameBoard[i][j].getColor());
                g.fillRect((Tile.getSize() + 1) * i, (Tile.getSize() + 1) * j, Tile.getSize(), Tile.getSize());
            }
        }
    }

}
