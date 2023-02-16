package diecidieci.pages;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowEvent;

public class StartMenu {

    private final JFrame window;

    public StartMenu(){
        this.window = new JFrame("1010");
        this.window.setPreferredSize(new Dimension(780, 780));
        this.window.setResizable(false);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1));
        mainPanel.setBorder(new EmptyBorder(100, 200, 100, 200));

        JLabel labelTitolo = new JLabel("1010!");
        labelTitolo.setPreferredSize(new Dimension(400, 400));
        labelTitolo.setHorizontalAlignment(JLabel.CENTER);
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            Game.getInstance();
            this.window.dispose();
        });
        startButton.setBackground(Color.GREEN);
        startButton.setOpaque(true);
        startButton.setBorderPainted(false);
        JButton rulesButton = new JButton("Rules");
        rulesButton.addActionListener(e -> {
            final String message =
                    "Every turn three pieces are offered to the player, who has to place them in the 10x10 tiles game board\n" +
                   "without putting them above a tile of a previously placed piece. The player earns 1 point for every tile\n" +
                   "composing the pieces he posits on the board. If after a piece is placed on the board all the tiles of a\n" +
                   "row or a column are occupied this line is fully emptied and the player earns 10 points. The game\n" +
                   "terminates when none of the proposed pieces can be placed on the board.\n"+
                    "(Please note: when you click on a tile of the board that will be the one where the top left tile of\n"+
                    "the selected piece will be placed)\n";
            JOptionPane.showMessageDialog(null,message,"Rules",JOptionPane.PLAIN_MESSAGE);
        });
        rulesButton.setBackground(Color.YELLOW);
        rulesButton.setOpaque(true);
        rulesButton.setBorderPainted(false);
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> {
            WindowEvent close = new WindowEvent(this.window, WindowEvent.WINDOW_CLOSING);
            this.window.dispatchEvent(close);
        });
        exitButton.setBackground(Color.MAGENTA);
        exitButton.setOpaque(true);
        exitButton.setBorderPainted(false);

        mainPanel.add(labelTitolo);
        mainPanel.add(startButton);
        mainPanel.add(rulesButton);
        mainPanel.add(exitButton);

        this.window.add(mainPanel);
        this.window.pack();
        this.window.setVisible(true);

    }
}