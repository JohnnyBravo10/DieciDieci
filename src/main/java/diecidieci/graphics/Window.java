package diecidieci.graphics;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Window {

    private final JFrame windowFrame;
    private final JPanel mainPanel;

    public Window(final String title, final Dimension size){
        this.windowFrame = new JFrame(title);
        this.windowFrame.setPreferredSize(size);
        this.windowFrame.setResizable(false);
        this.windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.mainPanel = new JPanel();
        this.mainPanel.setBorder(new EmptyBorder(5, 20, 20, 20));
        this.mainPanel.setLayout(new GridLayout(2,2));

    }

    public final JFrame getWindowFrame(){
        return this.windowFrame;
    }

    public final JPanel getMainPanel(){
        return this.mainPanel;
    }

}
