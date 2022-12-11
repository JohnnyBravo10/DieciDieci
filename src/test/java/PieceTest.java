import org.example.Piece;
import org.example.PieceSet;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PieceTest {
    PieceSet allSets = PieceSet.getPieceSetInstance();

    // Checking if the referece are diffent but the content is the same to test the copy constructor
    private Stream<Arguments> provideCopyToTest() {
        return Stream.of(
                Arguments.of(allSets.getPieceByType(Piece.ShapeType.SQUARE2x) ==
                        allSets.getPieceByType(Piece.ShapeType.SQUARE2x).copy(), false),
                Arguments.of(allSets.getPieceByType(Piece.ShapeType.SQUARE2x)
                        .equals(allSets.getPieceByType(Piece.ShapeType.SQUARE2x).copy()), true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCopyToTest")
    void checkCopyConstructor(boolean eval, boolean expected){
        assertEquals(eval, expected);
    }

    // Check if pieces are equal with differnt shapes
    private Stream<Arguments> providePiecesToTest() {
        var piece = allSets.getPieceByType(Piece.ShapeType.SQUARE2x);
        return Stream.of(
                Arguments.of(piece.equals(piece.copy()), true),
                Arguments.of(allSets.getPieceByType(Piece.ShapeType.SQUARE3x).equals(piece), false),
                Arguments.of(piece.equals(piece), true),
                Arguments.of(piece.equals(null), false)
        );
    }

    @ParameterizedTest
    @MethodSource("providePiecesToTest")
    void checkEqualPieces(boolean eval, boolean expected){
        assertEquals(expected, eval);
    }
}
