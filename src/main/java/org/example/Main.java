package org.example;


import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.gameFrame.setVisible(true);

       //per refreshare il jframe game.gameframe ogni volta che viene modificata la board o availablePieces usare:
        //SwingUtilities.updateComponentTreeUI(game.gameFrame);
        // è DA CAPIRE BENE COME FARE A MODIFICARE IL PUNTEGGIO E AGGIORNARE IL JFRAME

        /*
        Per aggiornare punteggio bisogna aggiprnare sia points che punteggio, esempio:
        game.points=10;
        game.punteggio.setText("Punteggio: "+game.points);


         */


        //per modificare la board basta cambiare colore ai tile di game.board.gamerBoard
        // bisogna creare spazi cliccabili in corrispondenza di pezzi e caselle della scacchiera
    }
}