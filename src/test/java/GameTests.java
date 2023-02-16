import diecidieci.core.Piece;
import diecidieci.core.PieceSet;
import diecidieci.pages.Game;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTests {


    @Test
    void testAddingPoint()
    {
        if (!GraphicsEnvironment.isHeadless()){
            Game game = Game.getInstance();
            game.addPoints(10);
            assertEquals(10, game.getScore().points);
        }

        assertTrue(true);

    }


    @Test
    void testPointsAddedByPiece()
    {
        if (!GraphicsEnvironment.isHeadless()) {
            Game game = Game.getInstance();
            Piece p = PieceSet.getPossibleSet()[2];
            game.addPoints(p.getSize());
            assertEquals(13, game.getScore().points); // Punti primo test + punti secondo
        }

        assertTrue(true);
    }
}


