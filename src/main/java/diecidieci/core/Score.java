package diecidieci.core;

import javax.swing.*;

public class Score extends JPanel{
    public int points;
    public JLabel pointsLabel;

    public Score (int points){
        this.points = points;
        this.pointsLabel = new JLabel("Punteggio: " + this.points);
    }
}