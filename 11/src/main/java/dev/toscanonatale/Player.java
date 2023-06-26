package dev.toscanonatale;

public class Player {
    private long worry = 0;

    public void addWorry(int amt) {
        this.worry += amt;
    }

    public void setWorry(long amt) {
        this.worry = amt;
    }

    public void mulWorry(int amt) {
        this.worry *= amt;
    }

    public void chill() {
        this.worry = this.worry / 3;
    }

    public long getWorry() {
        return this.worry;
    }
}
