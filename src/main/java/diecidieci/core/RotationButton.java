package diecidieci.core;

import diecidieci.Pages.Game;

import javax.swing.*;
import java.awt.*;

public class RotationButton extends JButton {

    public RotationButton() {
        super("Rotate");
        this.setSize(new Dimension(100, 50));

        this.addActionListener(e -> {
            Game.getInstance().getAvailablePieces().rotateAll();
            Game.getInstance().getAvailablePieces().draw();
        });
    }
}
