package diecidieci.graphics;

import diecidieci.pages.Game;
import diecidieci.core.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TileGraphics extends JComponent {

    private final Tile tile;

    //costruttore TileGraphics con MouseListener
    public TileGraphics(Tile tile, Double[] coordinate) {//le coordinate servono per dire dove si trova il tile nella board per piazzare il pezzo quando si clicca
        this.tile = tile;

        this.setSize(new Dimension(32, 32));

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                Game.getInstance().update(coordinate);
            }

            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}

        });
    }

    //rappresentazione TileGraphics
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(this.tile.getColor());//seleziono il colore del tile
        g.fillRect(0, 0, Tile.getSize(), Tile.getSize());
    }
}
