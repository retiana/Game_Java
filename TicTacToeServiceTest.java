package co.id.fwd.challange.services;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TicTacToeServiceTest {

    private final TicTacToeService ticTacToeService = new TicTacToeService();

    @Test
    public void testInitializeBoardWithValidSizes() {
        // Test with a valid board size
        int boardSize = 3;
        String[] board = ticTacToeService.initializeBoard(boardSize);
        Assertions.assertNotNull(board);
        Assertions.assertEquals(boardSize * boardSize, board.length);

        // Test with another valid board size
        boardSize = 5;
        board = ticTacToeService.initializeBoard(boardSize);
        Assertions.assertNotNull(board);
        Assertions.assertEquals(boardSize * boardSize, board.length);
    }

    @Test
    public void testInitializeBoardWithInvalidSize() {
        // Test with an invalid board size
        int boardSize = 0;
        String[] board = ticTacToeService.initializeBoard(boardSize);
        Assertions.assertNull(board); // Assuming null is returned for invalid sizes
    }
}