import org.example.Board;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTests {

    // Check if at the beginning all the board pieces are blank
    @Test
    void correctBoardInitialization()
    {
        Board b = new Board();

        Arrays.stream(b.gameBoard)
                .forEach(x -> Arrays.stream(x).forEach(y -> assertTrue(y.isEmpty())));
    }
}
