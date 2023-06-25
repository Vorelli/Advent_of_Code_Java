package dev.toscanonatale;

public class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(Position other) {
        this.x = this.x + other.x;
        this.y = this.y + other.y;
    }
}
