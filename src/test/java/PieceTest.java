
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.example.Piece;
import org.example.PieceSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class PieceTest {
    PieceSet allSets = PieceSet.getInstance();

    // Test if all the pieces have been initialized
    @Test
    void testPieceInitialization(){
        int cont = 0;

        for(Piece p : allSets.getPossibleSet())
        {
            if(!p.equals(null))
                cont++;
        }
        assertEquals(allSets.getPossibleSet().length, cont);
    }

    // Test if a shape it's initialized by comparing it to the real matrix
    @Test
    void testFirstShapeMatrixInitialization(){
        assertTrue(allSets.getPossibleSet()[0]
                .getPieceGeometry()
                .getShape()
                .equals(new Array2DRowRealMatrix(new double[][]{{0, 0}, {1 ,0}})));
    }

    // Test how to get a entry and if it's working
    @Test
    void testWorkingGetEntry(){
        assertTrue(allSets.getPossibleSet()[0]
                .getPieceGeometry()
                .getShape().getEntry(1, 0) == 1);
    }

    // This test checks if a rotation of 360 is correct
    @ParameterizedTest
    @ValueSource(ints={0, 1, 2, 3, 4, 5, 6, 7})
    void testPieceRotation(int index){

        RealMatrix m = allSets.getPossibleSet()[index]
                .getPieceGeometry().getShape();
        RealMatrix res = allSets.getPossibleSet()[index]
                .getPieceGeometry().getShape();

        for(int i = 0; i < 360; i+= 90)
        {
            res = res.multiply(new Array2DRowRealMatrix(new double[][]{{0, -1}, {1, 0}}));
        }

        assertTrue(res.equals(m));
    }
}