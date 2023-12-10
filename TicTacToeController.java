package co.id.fwd.challange.controller;


import co.id.fwd.challange.model.Board;
import co.id.fwd.challange.services.TicTacToeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/game")
public class TicTacToeController {

    @Autowired
    private TicTacToeService ticTacToeService;

    @PostMapping("/start")
    public ResponseEntity<Object> startGame(@RequestParam("size") int boardSize) {
        if (boardSize <= 0) {
            return ResponseEntity.badRequest().body(null);
        }

        String[] initializedBoard = ticTacToeService.initializeBoard(boardSize);
        if (initializedBoard == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        String currentPlayer = "A";
        Board newBoard = new Board(initializedBoard, boardSize, currentPlayer);

        Map<String, Object> response = new HashMap<>();
        response.put("cells", newBoard.getBoard());
        response.put("size", newBoard.getSize());


        return ResponseEntity.ok(response);
    }

    @GetMapping("/print")
    public ResponseEntity<String> printGameBoard(@RequestParam("board") String board, @RequestParam("size") int boardSize) {
        String[] boardArray = board.split(",");
        StringBuilder printableBoard = ticTacToeService.printBoard(boardArray, boardSize);
        return ResponseEntity.ok(printableBoard.toString());
    }
    @GetMapping("/check-winner")
    public String checkWinner(@RequestParam("size") int boardSize, @RequestParam("board") String[] board) {
        return ticTacToeService.checkWinner(board, boardSize);
    }



    @PostMapping("/move")
    public ResponseEntity<String> makeMove(@RequestParam("board") String[] board,@RequestParam("boardSize") int boardSize,@RequestParam("slot") int slot, @RequestParam("playerSymbol") String playerSymbol) {
        try {
            String response = ticTacToeService.makeMove(board,boardSize,slot,playerSymbol);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
