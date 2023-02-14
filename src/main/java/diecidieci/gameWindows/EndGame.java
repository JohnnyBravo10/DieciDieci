package diecidieci.gameWindows;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EndGame {

    private final JFrame window;

    public EndGame(){
        this.window = new JFrame("1010");
        this.window.setPreferredSize(new Dimension(300, 300));
        this.window.setResizable(false);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1));
        mainPanel.setBorder(new EmptyBorder(10, 50, 10, 50));

        JLabel labelGameover = new JLabel("GAME OVER");
        labelGameover.setHorizontalAlignment(JLabel.CENTER);

        JLabel labelPoints = new JLabel("You scored: "+ Game.getInstance().getPunteggio());
        labelPoints.setHorizontalAlignment(JLabel.CENTER);

        JButton newGameButton = new JButton("New Game");
        newGameButton.setBackground(Color.GREEN);
        newGameButton.setOpaque(true);
        newGameButton.setBorderPainted(false);
        newGameButton.addActionListener(e -> {
            Game.getInstance().startNewGame();
            this.window.dispose();
        });
        JButton homeButton = new JButton("Menù Start");
        homeButton.setBackground(Color.YELLOW);
        homeButton.setOpaque(true);
        homeButton.setBorderPainted(false);
        homeButton.addActionListener(e -> {
            StartMenu startMenu = new StartMenu();
            this.window.dispose();
        });

        mainPanel.add(labelGameover);
        mainPanel.add(labelPoints);
        mainPanel.add(newGameButton);
        mainPanel.add(homeButton);
        this.window.add(mainPanel);
        this.window.pack();
        this.window.setVisible(true);
    }
}
