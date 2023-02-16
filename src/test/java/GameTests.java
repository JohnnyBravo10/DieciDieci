
import diecidieci.core.Piece;
import diecidieci.core.PieceSet;
import diecidieci.pages.Game;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTests {


    //Test metodo addPoints
    @Test
    void testAddingPoint()
    {
        if (!GraphicsEnvironment.isHeadless()){
            Game game = Game.getInstance();
            int initialScore = game.getScore().points;
            game.addPoints(10);
            assertEquals(10, game.getScore().points - initialScore);
        }

        assertTrue(true);

    }


    //Test metodo addPoints
    @Test
    void testPointsAddedByPiece()
    {
        if (!GraphicsEnvironment.isHeadless()) {
            Game game = Game.getInstance();
            int initialScore = game.getScore().points;
            Piece p = PieceSet.getPossibleSet()[2];
            game.addPoints(p.getSize());
            assertEquals(3, game.getScore().points - initialScore); // Punti primo test + punti secondo
        }

        assertTrue(true);
    }
}


