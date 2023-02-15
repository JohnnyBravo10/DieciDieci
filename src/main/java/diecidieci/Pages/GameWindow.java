package diecidieci.Pages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameWindow {

    private static final int WINDOW_SIZE = 780;

    private final JFrame frame;
    private final JPanel mainPanel;

    public GameWindow(final String title){
        this.frame = new JFrame(title);
        this.frame.setPreferredSize(new Dimension(WINDOW_SIZE, WINDOW_SIZE));
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.mainPanel = new JPanel();
        this.mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.mainPanel.setLayout(new GridLayout(2,1));

    }

    public final JFrame getFrame(){
        return this.frame;
    }

    public final JPanel getMainPanel(){
        return this.mainPanel;
    }

}
