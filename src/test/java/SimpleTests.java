import org.example.Tile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SimpleTests {
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

   }