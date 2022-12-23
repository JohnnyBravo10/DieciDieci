import org.example.Board;
import org.example.Piece;
import org.example.PieceSet;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.example.Board.BOARD_DIM;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
    // test per verificare l'efficienza del metodo checkBoard
    @Test
    void Test_checkBoard(){
        Board tabella1 = new Board();
        Board tabella2 = new Board();
        boolean b = true;

        for (int i=0; i < BOARD_DIM;i++){
            tabella1.gameBoard[0][i].setColor(Color.RED);
            tabella1.gameBoard[5][i].setColor(Color.RED);
        }

        tabella1.checkBoard();

        for (int i=0; i< BOARD_DIM;i++){
            for (int j=0; j< BOARD_DIM;j++){
                if (!tabella1.gameBoard[i][j].equals(tabella2.gameBoard[i][j])){
                    b = false;
                }
            }
        }
        assertTrue(b);
    }

    //Test per verificare il metodo can be placed
    @Test
    void canBePlacedTest(){
        Piece p= PieceSet.getPossibleSet()[1];
        Board tabella= new Board();
        assertTrue(tabella.canBePlaced(p, new Double[]{2.0,2.0})); //can be placed case
        tabella.gameBoard[2][3].setColor(Color.yellow);
        assertFalse(tabella.canBePlaced(p, new Double[]{2.0,2.0})); //occupied tile case
        assertFalse(tabella.canBePlaced(p, new Double[]{3.0,9.0})); //out of gameboard case
    }


}
