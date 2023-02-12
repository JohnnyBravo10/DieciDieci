package diecidieci.core;

import javax.swing.*;

public class Punteggio extends JPanel{
    public int points;
    public JLabel pointsLabel;

    public Punteggio (int points){
        this.points = points;
        this.pointsLabel = new JLabel("Punteggio: " + this.points);
    }
}
