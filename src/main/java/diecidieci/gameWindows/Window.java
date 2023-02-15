package diecidieci.gameWindows;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Window {

    private static final int WINDOW_SIZE = 780;
    private final JFrame windowFrame;
    private final JPanel mainPanel;

    public Window(final String title){
        this.windowFrame = new JFrame(title);
        this.windowFrame.setPreferredSize(new Dimension(WINDOW_SIZE, WINDOW_SIZE));
        this.windowFrame.setResizable(false);
        this.windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.mainPanel = new JPanel();
        this.mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.mainPanel.setLayout(new GridLayout(2,1));

    }

    public final JFrame getWindowFrame(){
        return this.windowFrame;
    }

    public final JPanel getMainPanel(){
        return this.mainPanel;
    }

}
