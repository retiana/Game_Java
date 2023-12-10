package co.id.fwd.challange;

import co.id.fwd.challange.services.TicTacToeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {

    private static String[] board;
    private static String turn = "A";
    private static int boardSize;

    private static TicTacToeService ticTacToeService;

    public TicTacToe(TicTacToeService ticTacToeService) {
        this.ticTacToeService = ticTacToeService;
    }

    public static void main(String[] args) {
        String winner = null;
        ticTacToeService = new TicTacToeService();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Choose the board size you want to play ( 3 for 3x3, 5 for 5x5, 9 for 9x9): ");
            boardSize = Integer.parseInt(reader.readLine());
            if (boardSize < 3) {
                System.out.println("Board size cannot be less than 3. Setting board size to 3.");
                boardSize = 3;
            }

            board= ticTacToeService.initializeBoard(boardSize);

            System.out.println("Welcome to Tic Tac Toe!");
            System.out.println("------------------------");
            ticTacToeService.printBoard(board,boardSize);

            System.out.print("Player A will play first. Enter a slot number to place A in: ");

            while (winner == null) {
                try {
                    String input = reader.readLine();

                    int numInput = Integer.parseInt(input);

                    if (!(numInput > 0 && numInput <= boardSize * boardSize)) {
                        System.out.print("Invalid input; re-enter slot number: ");
                        continue;
                    }
                    if (!board[numInput - 1].equals(String.valueOf(numInput))) {
                        System.out.print("Slot already taken; re-enter slot number: ");
                        continue;
                    }
                    board[numInput - 1] = turn;
                    if (turn.equals("A")) {
                        System.out.println("Its Player B turn");
                        turn = "B";
                    } else {
                        System.out.println("Its Player A turn");
                        turn = "A";
                    }
                    ticTacToeService.printBoard(board,boardSize);

                    winner = ticTacToeService.checkWinner(board,boardSize);
                    if(winner!=null){
                        System.out.println("Congratulation the winner is "+winner);
                    }else{
                        System.out.print("Enter a slot number : ");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input; re-enter slot number: ");
                }
            }
            // Rest of your game logic remains unchanged
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }


}

