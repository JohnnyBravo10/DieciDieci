
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.example.Piece;
import org.example.PieceGeometry;
import org.example.PieceSet;
import org.example.Tile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class PieceTest {

    //final PieceSet allSets = PieceSet.getInstance();



    // Test if all the pieces have been initialized
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

    // Test if a shape it's initialized by comparing it to the real matrix
    @Test
    void testFirstShapeMatrixInitialization(){
        assertEquals(PieceSet.getPossibleSet()[0]
                .getPieceGeometry()
                .getShape(), new Array2DRowRealMatrix(new double[][]{{0, 0}}));
    }

    // Test how to get an entry and if it's working
    @Test
    void testWorkingGetEntry(){
        assertEquals(PieceSet.getPossibleSet()[0]
                .getPieceGeometry()
                .getShape().getEntry(0, 0) ,0);
    }

    // This test checks if a rotation of 360 is correct
    @ParameterizedTest
    @ValueSource(ints={0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void testPieceRotation(int index){

        RealMatrix m = PieceSet.getPossibleSet()[index]
                .getPieceGeometry().getShape();

        for(int i = 0; i < 360; i+= 90)
        {
            PieceSet.getPossibleSet()[index].getPieceGeometry().rotate();
        }

        assertEquals(PieceSet.getPossibleSet()[index].getPieceGeometry().getShape(), m);
    }

    final List<RealVector> startingLeftCornerPositions = new ArrayList<>(
            Arrays.asList(
                    new ArrayRealVector(new double[]{0, 0}),
                    new ArrayRealVector(new double[]{0, 0}),
                    new ArrayRealVector(new double[]{0, 0}),
                    new ArrayRealVector(new double[]{0, 0}),
                    new ArrayRealVector(new double[]{0, 0}),

                    new ArrayRealVector(new double[]{0, 1}),
                    new ArrayRealVector(new double[]{-1, 1}),

                    new ArrayRealVector(new double[]{0, 1}),
                    new ArrayRealVector(new double[]{-1, 1}),

                    new ArrayRealVector(new double[]{0, 0}),
                    new ArrayRealVector(new double[]{-1, 1})
                    )
    );

    //test per calculate left square corner
    @ParameterizedTest
    @ValueSource(ints={0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void testLeftCornerCalculation(int index){
        assertEquals(new ArrayRealVector(PieceSet.getPossibleSet()[index]
                .getPieceGeometry()
                .calculateLeftCorner()), startingLeftCornerPositions.get(index));
    }


    //test per getLeftSquareCorner
    @ParameterizedTest
    @ValueSource(ints={0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void testGetLeftCorner(int index){
        assertEquals(PieceSet.getPossibleSet()[index]
                .getPieceGeometry()
                .getLeftSquareCorner(), startingLeftCornerPositions.get(index));
    }


    //per ogni pezzo, posizione del left square corner nei quattro casi di rotazione
    final List<RealMatrix> LeftCornerPositions = new ArrayList<>(
            Arrays.asList(
                    new Array2DRowRealMatrix(new double[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}}),
                    new Array2DRowRealMatrix(new double[][]{{0, 0}, {0, 0}, {-1, 0}, {0, 1}}),
                    new Array2DRowRealMatrix(new double[][]{{0, 0}, {0, 0}, {-2, 0}, {0, 2}}),
                    new Array2DRowRealMatrix(new double[][]{{0, 0}, {0, 0}, {-3, 0}, {0, 3}}),
                    new Array2DRowRealMatrix(new double[][]{{0, 0}, {0, 0}, {-4, 0}, {0, 4}}),

                    new Array2DRowRealMatrix(new double[][]{{0, 1}, {0, 0}, {-1, 0}, {-1, 1}}),
                    new Array2DRowRealMatrix(new double[][]{{-1, 1}, {-1, 1}, {-1, 1}, {-1, 1}}),

                    new Array2DRowRealMatrix(new double[][]{{0, 1}, {0, 0}, {-1, 0}, {0, 1}}),
                    new Array2DRowRealMatrix(new double[][]{{-1, 1}, {-1, 1}, {-1, 1}, {1, 1}}),

                    new Array2DRowRealMatrix(new double[][]{{0, 0}, {-1, 0}, {0, 1}, {0, 1}}),
                    new Array2DRowRealMatrix(new double[][]{{-1, 1}, {-1, 1}, {1, 1}, {-1, 1}})
            )
    );

    //test per i Left corner ad ogni rotazione
    @ParameterizedTest
    @ValueSource(ints={0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void testGetLeftCornerWithRotations(int index) {
        PieceGeometry p= PieceSet.getPossibleSet()[index].getPieceGeometry();

        for (int i = 0; i < 360; i += 90) {
            assertEquals(p.getLeftSquareCorner(), LeftCornerPositions.get(index).getRowVector(i/90));
            p.rotate();
        }
    }

}