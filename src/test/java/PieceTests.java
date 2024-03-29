
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import diecidieci.core.Piece;
import diecidieci.core.PieceGeometry;
import diecidieci.core.PieceSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class PieceTests {

    //Test metodo getPossibleSet
    @Test
    void testPieceInitialization(){
        int cont = 0;

        for(Piece p : PieceSet.getPossibleSet())
        {
            if(!p.equals(null))
                cont++;
        }
        assertEquals(PieceSet.getPossibleSet().length, cont);
    }

    //Test metodo getPossibleSet
    @Test
    void testFirstShapeMatrixInitialization(){
        assertEquals(PieceSet.getPossibleSet()[0]
                .getGeometry()
                .getShape(), new Array2DRowRealMatrix(new double[][]{{0, 0}}));
    }

    //Test metodo getPossibleSet
    @Test
    void testWorkingGetEntry(){
        assertEquals(0, PieceSet.getPossibleSet()[0]
                .getGeometry()
                .getShape().getEntry(0, 0));
    }

    //Test metodo rotate
    @ParameterizedTest
    @ValueSource(ints={0, 1, 2, 3, 4, 5, 6, 7, 8})
    void testPieceRotation(int index){

        RealMatrix m = PieceSet.getPossibleSet()[index]
                .getGeometry().getShape();

        for(int i = 0; i < 360; i+= 90)
        {
            PieceSet.getPossibleSet()[index].getGeometry().rotate();
        }

        assertEquals(PieceSet.getPossibleSet()[index].getGeometry().getShape(), m);
    }

    final List<RealVector> startingLeftCornerPositions = new ArrayList<>(
            Arrays.asList(
                    new ArrayRealVector(new double[]{0, 0}),
                    new ArrayRealVector(new double[]{-0.5, 0}),
                    new ArrayRealVector(new double[]{-1, 0}),
                    new ArrayRealVector(new double[]{-1.5, 0}),
                    new ArrayRealVector(new double[]{-2, 0}),

                    new ArrayRealVector(new double[]{-0.5, 0.5}),
                    new ArrayRealVector(new double[]{-1, 1}),

                    new ArrayRealVector(new double[]{-0.5, 0.5}),
                    new ArrayRealVector(new double[]{0, 2})
                    )
    );

    //Test per metodo calculateLeftCorner
    @ParameterizedTest
    @ValueSource(ints={0, 1, 2, 3, 4, 5, 6, 7, 8})
    void testLeftCornerCalculation(int index){
        assertEquals(new ArrayRealVector(PieceSet.getPossibleSet()[index]
                .getGeometry()
                .calculateLeftCorner()), startingLeftCornerPositions.get(index));
    }


    //test per metodo getLeftSquareCorner
    @ParameterizedTest
    @ValueSource(ints={0, 1, 2, 3, 4, 5, 6, 7, 8})
    void testGetLeftCorner(int index){
        assertEquals(PieceSet.getPossibleSet()[index]
                .getGeometry()
                .getLeftSquareCorner(), startingLeftCornerPositions.get(index));
    }


    //per ogni pezzo, posizione del left square corner nei quattro casi di rotazione
    final List<RealMatrix> LeftCornerPositions = new ArrayList<>(
            Arrays.asList(
                    new Array2DRowRealMatrix(new double[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}}),
                    new Array2DRowRealMatrix(new double[][]{{-0.5, 0}, {0, 0.5}, {-0.5, 0}, {0, 0.5}}),
                    new Array2DRowRealMatrix(new double[][]{{-1, 0}, {0, 1}, {-1, 0}, {0, 1}}),
                    new Array2DRowRealMatrix(new double[][]{{-1.5, 0}, {0, 1.5}, {-1.5, 0}, {0, 1.5}}),
                    new Array2DRowRealMatrix(new double[][]{{-2, 0}, {0, 2}, {-2, 0}, {0, 2}}),

                    new Array2DRowRealMatrix(new double[][]{{-0.5, 0.5}, {-0.5, 0.5}, {-0.5, 0.5}, {-0.5, 0.5}}),
                    new Array2DRowRealMatrix(new double[][]{{-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}}),

                    new Array2DRowRealMatrix(new double[][]{{-0.5, 0.5}, {-0.5, 0.5}, {-0.5, 0.5}, {0.5, 0.5}}),
                    new Array2DRowRealMatrix(new double[][]{{0, 2}, {0, 0}, {-2, 0}, {0, 2}})
            )
    );

    //test per metodi getLeftSquareCorner e rotate
    @ParameterizedTest
    @ValueSource(ints={0, 1, 2, 3, 4, 5, 6, 7, 8})
    void testGetLeftCornerWithRotations(int index) {
        PieceGeometry p= PieceSet.getPossibleSet()[index].getGeometry();

        for (int i = 0; i < 360; i += 90) {
            assertEquals(p.getLeftSquareCorner(), LeftCornerPositions.get(index).getRowVector(i/90));
            p.rotate();
        }
    }

    @Test
    void SetUnavailableTest(){
        Piece p = new Piece(PieceSet.getRandomPiece());
        p.setUnavailable();
        assertFalse(p.isAvailable());
    }

}