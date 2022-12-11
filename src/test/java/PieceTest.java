import org.example.Piece;
import org.example.Tile;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PieceTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 15})
    void testOutOfBoundExeption(int pieceIndex){
        assertThrows(IllegalArgumentException.class,
                () -> new Piece(pieceIndex)
        );
    }

    private static Stream<Arguments> providePiecesToTest() {
        Piece piece = new Piece(0);
        return Stream.of(
                Arguments.of(new Piece(0).equals(piece), true),
                Arguments.of(new Piece(1).equals(piece), false),
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
