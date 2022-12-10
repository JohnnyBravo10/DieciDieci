import org.example.Piece;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PieceTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 15})
    void testOutOfBoundExeption(int pieceIndex){
        assertThrows(IllegalArgumentException.class,
                () -> new Piece(pieceIndex)
        );
    }
}
