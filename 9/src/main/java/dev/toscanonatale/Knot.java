package dev.toscanonatale;

public class Knot {
    private Position pos;

    public Knot() {
        this.pos = new Position(500, 500);
    }

    public Position getPos() {
        return this.pos;
    }

    public void moveTo(Position p) {
        this.pos = p;
    }

    public void moveTo(int x, int y) {
        this.pos = new Position(x, y);
    }
}
