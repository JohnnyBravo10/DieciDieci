import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {

    @Test
    void addPointsTest()
    {
        Game g = new Game();

        g.addPoints(10);

        assertEquals(g.points, 10);
    }

    @Test
    void addPointsTest2()
    {
        Game g = new Game();

        Piece p = PieceSet.getPossibleSet()[2];

        g.addPoints(p.getSize());

        assertEquals(g.points, 3);
    }

}
