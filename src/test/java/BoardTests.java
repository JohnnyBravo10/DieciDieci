import org.example.Board;
import org.junit.jupiter.api.Test;

import java.awt.*;
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

    @Test
    void Test_checkColumnsAndRowsMethod(){
        Board tabella1 = new Board();
        Board tabella2 = new Board();
        boolean b = true;

        for (int i=0; i< tabella1.BOARD_DIM;i++){
            tabella1.gameBoard[0][i].setColor(Color.RED);
            tabella1.gameBoard[5][i].setColor(Color.RED);
        }

        tabella1.checkColumnsAndRows();

        for (int i=0; i< tabella1.BOARD_DIM;i++){
            for (int j=0; j< tabella1.BOARD_DIM;j++){
                if (tabella1.gameBoard[i][j].getColor() != tabella2.gameBoard[i][j].getColor()){
                    b = false;
                }
            }
        }
        assertTrue(b == true);
    }

}
