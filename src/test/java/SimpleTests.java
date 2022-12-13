import org.example.Tile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTests {

   /*
   Se eseguite solo dei segunti test appare un messaggio di warning, non se si può disattivare
   e come, ma non è un errore. Su github dicono così':
   https://stackoverflow.com/questions/68465659/what-causes-a-junit-warning-org-junit-platform-launcher-core-enginediscoveryorch
   Comunque se li eseguite tutti passano
   */

    private static Stream<Arguments> provideTilesToTest() {
        return Stream.of(
                Arguments.of(new Tile("white").isEmpty(), true),
                Arguments.of(new Tile("black").isEmpty(), false)
        );
    }

    // Check if a tile is occupied or not all in one test
    @ParameterizedTest
    @MethodSource("provideTilesToTest")
    void testTiles(boolean expected, boolean result){
        assertEquals(expected, result);
    }

}