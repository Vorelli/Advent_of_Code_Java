package dev.toscanonatale;

public class Head extends Knot {
    private Tail tail;

    public Head(Tail t) {
        this.tail = t;
    }

    public void moveTo(Position p) {
        super.moveTo(p);
    }

    public Tail getTail() {
        return this.tail;
    }
}
