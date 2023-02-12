package diecidieci.graphics;

import diecidieci.core.Game;
import diecidieci.core.Piece;
import diecidieci.core.Tile;
import org.apache.commons.math3.linear.RealMatrix;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import static diecidieci.core.Board.BOARD_DIM;

public class TileGraphics extends JComponent {

    private Tile tile;

    public TileGraphics(Tile tile1){
        this.tile = tile1;
        this.setSize(new Dimension(32,32) );

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

                if(getBorder()==null) {
                    setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                    Game.setSelectedTile(tile);
                }
                else {
                    setBorder(null);
                    Game.setSelectedTile(null);
                }
                for (int i=0; i< BOARD_DIM; i++){
                    for (int j= 0; j<BOARD_DIM; j++){
                        if (Game.getSelectedTile() != Game.board.getBoardGraphics().getGameBoard()[i][j].getTile()){
                            Game.board.getBoardGraphics().getGameBoard()[i][j].setBorder(null);
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
    }

    @Override
    protected void paintComponent(Graphics g){
        g.setColor(this.tile.getColor());//seleziono il colore del tile
        //g.fillRect((int)(this.getPreferredSize().width + (Tile.getSize()+1)*(0.05)/*ascissa del quadratino*/),
                //(int)(this.getPreferredSize().height + (Tile.getSize()+1.5)*(-0.1)),Tile.getSize(), Tile.getSize());
        g.fillRect(0,0, Tile.getSize(), Tile.getSize());
    }

    public Tile getTile(){return this.tile;}
}
