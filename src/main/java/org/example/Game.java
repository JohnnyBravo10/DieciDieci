package org.example;

import javax.swing.*;
import java.awt.*;

public class Game {
    public JFrame gameFrame;
    public Board Board;

    public Game() {
        this.gameFrame = new JFrame("1010");
        this.Board = new Board();

        this.gameFrame.setSize(700, 700);
        this.gameFrame.setResizable(true);
        this.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel() {
            //per rappresentare figure è sufficiente fare override del metodo paint di JPanel
            @Override
            public void paint(Graphics gr) {
                for (int i = 0; i < Board.gameBoard.length; i++) {
                    for (int j = 0; j < Board.gameBoard[i].length; j++) {
                        gr.setColor(Board.gameBoard[i][j].getColor());
                        gr.fillRect(20 + 40 * i, 20 + 40 * j, 39, 39);
                    }
                }
            }
        };
        this.gameFrame.add(p);
        }
    }
