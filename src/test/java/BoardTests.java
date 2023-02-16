
import diecidieci.core.Board;
import diecidieci.core.Piece;
import diecidieci.core.PieceSet;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static diecidieci.core.Board.BOARD_DIM;


class BoardTests {

    //Test costruttore board
    @Test
    void correctBoardInitialization()
    {
        Board b = new Board();

        Arrays.stream(b.getGameBoard())
                .forEach(x -> Arrays.stream(x).forEach(y -> assertTrue(y.isEmpty())));
    }

    //Test metodo checkBoard
    @Test
    void checkBoardTest(){
        if (!GraphicsEnvironment.isHeadless()) {
            Board tabella1 = new Board();
            Board tabella2 = new Board();
            for (int i = 0; i < BOARD_DIM; i++) {
                tabella1.getGameBoard()[0][i].setColor(Color.RED);
                tabella1.getGameBoard()[5][i].setColor(Color.RED);
            }
            tabella1.checkBoard();
            for (int i = 0; i < BOARD_DIM; i++) {
                for (int j = 0; j < BOARD_DIM; j++) {
                    assertEquals(tabella1.getGameBoard()[i][j].getColor(), tabella2.getGameBoard()[i][j].getColor());
                }
            }
        }
        assertTrue(true);
    }

    //Test metodo canBePlaced
    @Test
    void canBePlacedTest(){
        Piece p= PieceSet.getPossibleSet()[1];
        Board tabella= new Board();
        assertTrue(tabella.canBePlaced(p, new Double[]{2.0,2.0})); //can be placed case
        tabella.getGameBoard()[2][3].setColor(Color.yellow);
        assertFalse(tabella.canBePlaced(p, new Double[]{2.0,2.0})); //occupied tile case
        assertFalse(tabella.canBePlaced(p, new Double[]{3.0,9.0})); //out of gameboard case
    }

    //Test metodi place e canBePlaced
    @Test
    void placeTest(){
        Piece p=PieceSet.getPossibleSet()[1];
        Board tabella=new Board();
        assertTrue(tabella.canBePlaced(p, new Double[]{2.0,2.0})); //can be placed case
        tabella.place(p, new Double[]{2.0, 1.0});
        assertFalse(tabella.canBePlaced(p, new Double[]{2.0,0.0})); //verifico che lo stesso pezzo non possa più essere posizionato
        assertFalse(tabella.canBePlaced(p, new Double[]{2.0,1.0}));  // negli spazi già occupati
        assertFalse(tabella.canBePlaced(p, new Double[]{2.0,2.0}));
        assertTrue(tabella.canBePlaced(p, new Double[]{2.0,3.0}));
    }


}
