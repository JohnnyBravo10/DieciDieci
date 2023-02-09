package diecidieci.graphics;
import diecidieci.graphics.Window;
import diecidieci.core.Game;

import javax.swing.*;
import java.awt.*;

public class StartMenu {

    private final Window window;

    public JButton startButton;

    public StartMenu(){
        this.window = new Window("1010", new Dimension(1280, 720));
        this.startButton = new JButton("Start");
        startButton.setSize(10,10);
        this.startButton.addActionListener(e -> {
            Game game = new Game();
        });
        JLabel label_titolo = new JLabel("1010!");
        label_titolo.setSize(50,50);
        label_titolo.setHorizontalAlignment(JLabel.CENTER);
        this.window.getMainPanel().add(label_titolo);
        this.window.getMainPanel().add(this.startButton);
        this.window.getWindowFrame().add(this.window.getMainPanel());
        this.window.getWindowFrame().pack();
        this.window.getWindowFrame().setVisible(true);

    }

}