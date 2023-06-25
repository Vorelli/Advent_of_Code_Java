package dev.toscanonatale;

public class Tail extends Knot {
    public void follow(Position headPos) {
        Position pos = this.getPos();
        if (pos.x == headPos.x) {
            if (Math.abs(pos.y - headPos.y) > 1) {
                Position diff = new Position(0, (headPos.y - pos.y) / 2);
                this.getPos().add(diff);
            }
        } else if (pos.y == headPos.y) {
            if (Math.abs(pos.x - headPos.x) > 1) {
                Position diff = new Position((headPos.x - pos.x) / 2, 0);
                this.getPos().add(diff);
            }
        } else if (Math.abs(headPos.x - pos.x) > 1 || Math.abs(headPos.y - pos.y) > 1) {
            int xDiff = (headPos.x - pos.x) > 0 ? 1 : -1;
            int yDiff = (headPos.y - pos.y) > 0 ? 1 : -1;
            Position diff = new Position(xDiff, yDiff);
            this.getPos().add(diff);
        }
    }
}
