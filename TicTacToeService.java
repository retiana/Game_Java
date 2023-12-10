package co.id.fwd.challange.services;


import org.springframework.stereotype.Service;

@Service
public class TicTacToeService {

    public static String[] initializeBoard(int boardSize) {
        String[] board = new String[boardSize * boardSize];
        for (int a = 0; a < boardSize * boardSize; a++) {
            board[a] = String.valueOf(a + 1);
        }
        return board;
    }


    public StringBuilder printBoard(String[] board, int boardSize) {
        StringBuilder createBoard = new StringBuilder();
        for (int i = 0; i < boardSize; i++) {
            createBoard.append("|");
            for (int j = 0; j < boardSize; j++) {
                createBoard.append(" ").append(board[i * boardSize + j]).append(" |");
            }
            createBoard.append("\n");
        }
        System.out.println(createBoard);
        return createBoard;
    }

    public static String repeatString(String str, int times) {
        return str.repeat(times);
    }

    public static String checkWinner(String[] board, int boardSize) {

        for (int i = 0; i < boardSize; i++) {
            String row = "";
            String col = "";
            for (int j = 0; j < boardSize; j++) {
                row += board[i * boardSize + j];
                col += board[j * boardSize + i];
            }
            if (row.equals(repeatString("A", boardSize)) || col.equals(repeatString("A", boardSize))) {
                return "Player A";
            } else if (row.equals(repeatString("B", boardSize)) || col.equals(repeatString("B", boardSize))) {
                return "Player B";
            }
        }


        String diagonal1 = "";
        String diagonal2 = "";
        for (int i = 0; i < boardSize; i++) {
            diagonal1 += board[i * (boardSize + 1)];
            diagonal2 += board[(i + 1) * (boardSize - 1)];
        }
        if (diagonal1.equals(repeatString("A", boardSize)) || diagonal2.equals(repeatString("A", boardSize))) {
            return "Player A";
        } else if (diagonal1.equals(repeatString("B", boardSize)) || diagonal2.equals(repeatString("B", boardSize))) {
            return "Player B";
        }

        for (String cell : board) {
            if (!cell.equals("A") && !cell.equals("B")) {
                return null;
            }
        }
        return "draw";
    }



    public String makeMove(String[] board, int boardSize, int slot, String playerSymbol) {
        int row = (slot - 1) / boardSize;
        int col = (slot - 1) % boardSize;

        if (!(slot > 0 && slot <= boardSize * boardSize)) {
            throw new IllegalArgumentException("Invalid input; re-enter slot number");
        }
        if (!board[slot - 1].equals(String.valueOf(slot))) {
            throw new IllegalArgumentException("Slot already taken; re-enter slot number");
        }

        board[slot - 1] = playerSymbol;

        String winner = checkWinner(board, boardSize);
        if (winner != null) {
            return "Congratulations! The winner is " + winner;
        }


        return "Move made successfully";
    }

}
