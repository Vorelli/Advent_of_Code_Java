package dev.toscanonatale;

public class Head extends Knot {
    private Knot tail;

    public Head(Knot t) {
        this.tail = t;
    }

    public void moveTo(Position p) {
        super.moveTo(p);
    }

    public Knot getTail() {
        return this.tail;
    }
}
