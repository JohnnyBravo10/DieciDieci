import diecidieci.core.Piece;
import diecidieci.core.PieceSet;
import diecidieci.pages.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTests {

    @Test
    void testAddingPoint()
    {
        Game game = Game.getInstance();
        game.addPoints(10);
        assertEquals(10, game.getScore().points);
    }


    @Test
    void testPointsAddedByPiece()
    {
        Game game = Game.getInstance();
        Piece p = PieceSet.getPossibleSet()[2];
        game.addPoints(p.getSize());
        assertEquals(13, game.getScore().points); // Punti primo test + punti secondo
    }
}


