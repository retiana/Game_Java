package co.id.fwd.challange.model;

public class Board {
    String[] board;

    String currentTurn;
     String[] cells;
    private int size;


    public Board(String[] board, int size, String currentTurn) {
        this.size = size;
        this.cells = board;
        this.currentTurn = currentTurn;
        this.board=board;
    }

    public String[] getBoard() {
        return board;
    }

    public void setBoard(String[] board) {
        this.board = board;
    }

    public String getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(String currentTurn) {
        this.currentTurn = currentTurn;
    }

    public String[] getCells() {
        return cells;
    }

    public void setCells(String[] cells) {
        this.cells = cells;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
