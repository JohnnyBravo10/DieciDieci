import org.example.Tile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTests {

   /*
   Se eseguite solo dei segunti test appare un messaggio di warning, non se si può disattivare
   e come, ma non è un errore. Su github dicono così':
   https://stackoverflow.com/questions/68465659/what-causes-a-junit-warning-org-junit-platform-launcher-core-enginediscoveryorch
   Comunque se li eseguite tutti passano
   */

   @Test
   public void TileConstructor(){
      Tile t=new Tile();
      Assertions.assertFalse(t.occupied);
   }

   @Test
   public void OccupiedTileConstructor(){
      Tile t=new Tile(true);
      Assertions.assertTrue(t.occupied);
   }

   private static Stream<Arguments> provideTilesToTest() {
      Tile tile = new Tile();
      return Stream.of(
              Arguments.of(new Tile().equals(new Tile()), true),
              Arguments.of(new Tile(true).equals(new Tile(true)), true),
              Arguments.of(tile.equals(tile), true),
              Arguments.of(tile.equals(null), false)
      );
   }

   @ParameterizedTest
   @MethodSource("provideTilesToTest")
   void checkEqualTiles(boolean eval, boolean expected){
      assertEquals(expected, eval);
   }
}