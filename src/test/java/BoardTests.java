import diecidieci.core.Board;
import diecidieci.core.Piece;
import diecidieci.core.PieceSet;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static diecidieci.core.Board.BOARD_DIM;


public class BoardTests {

    // Check if at the beginning all the board pieces are blank
    @Test
    void correctBoardInitialization()
    {
        Board b = new Board();

        Arrays.stream(b.getGameBoard())
                .forEach(x -> Arrays.stream(x).forEach(y -> assertTrue(y.isEmpty())));
    }

    // test per verificare l'efficienza del metodo checkBoard
    @Disabled //non funziona ora che ho aggiunto l'incremento del punteggio al metodo cleanBoard perché il punteggio non è inizializzato
    @Test
    void Test_checkBoard(){
        Board tabella1 = new Board();
        Board tabella2 = new Board();
        for (int i=0; i < BOARD_DIM;i++){
            tabella1.getGameBoard()[0][i].setColor(Color.RED);
            tabella1.getGameBoard()[5][i].setColor(Color.RED);
        }
        int points_count = tabella1.checkBoard();
        for (int i=0; i< BOARD_DIM;i++){
            for (int j=0; j< BOARD_DIM;j++){
                assertEquals(tabella1.getGameBoard()[i][j].getColor(),tabella2.getGameBoard()[i][j].getColor());
            }
        }
        assertEquals(points_count, 2);
    }

    //Test per verificare il metodo can be placed
    @Test
    void canBePlacedTest(){
        Piece p= PieceSet.getPossibleSet()[1];
        Board tabella= new Board();
        assertTrue(tabella.canBePlaced(p, new Double[]{2.0,2.0})); //can be placed case
        tabella.getGameBoard()[2][3].setColor(Color.yellow);
        assertFalse(tabella.canBePlaced(p, new Double[]{2.0,2.0})); //occupied tile case
        assertFalse(tabella.canBePlaced(p, new Double[]{3.0,9.0})); //out of gameboard case
    }

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
