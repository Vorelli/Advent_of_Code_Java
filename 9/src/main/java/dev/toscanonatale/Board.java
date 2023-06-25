package dev.toscanonatale;

public class Board {
    private boolean[][] board;
    private int count;

    public Board() {
        this.board = new boolean[1000][1000];
        this.count = 0;
    }

    public void visit(Position p) {
        int x = this.board.length - p.x - 1;
        int y = this.board[0].length - p.y - 1;
        if (this.board[x][y] == false)
            this.count++;
        this.board[x][y] = true;
    }

    public int getCount() {
        return this.count;
    }
}
