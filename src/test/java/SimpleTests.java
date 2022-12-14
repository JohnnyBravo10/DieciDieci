import org.example.Tile;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTests {
    private static Stream<Arguments> provideTilesOccupiedToTest() {
        return Stream.of(
                Arguments.of(new Tile(Color.white).isEmpty(), true),
                Arguments.of(new Tile(Color.black).isEmpty(), false)
        );
    }

    // Check if a tile is occupied or not all in one test
    @ParameterizedTest
    @MethodSource("provideTilesOccupiedToTest")

    void testTiles(boolean expected, boolean result){
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideTilesColorToTest() {
        return Stream.of(
                Arguments.of(new Tile().getColor().toString(), Color.white.toString()),
                Arguments.of(new Tile(Color.red).getColor().toString(), Color.red.toString())
        );
    }

    @ParameterizedTest
    @MethodSource("provideTilesColorToTest")

    void testTiles(String expected, String result){
        assertEquals(expected, result);
    }

    @Test
    void MakeAvailableTest() {
        Tile redTile = new Tile(Color.red);
        redTile.makeAvailable();
        assertEquals(redTile.getColor(),Color.white);
    }
    @Test
    void SetColorTest() {
        Tile redTile = new Tile();
        redTile.setColor(Color.RED);
        assertEquals(redTile.getColor(),Color.RED);
    }

    @Test
    void EqualsTilesTest(){
        Tile tile1 = new Tile(Color.BLUE);
        Tile tile2 = new Tile(Color.BLUE);
        assertTrue(tile1.equals(tile2));
    }

}
