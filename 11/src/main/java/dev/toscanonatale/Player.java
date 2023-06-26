package dev.toscanonatale;

import java.math.BigInteger;

public class Player {
    private BigInteger worry = BigInteger.valueOf(0);

    public void addWorry(BigInteger amt) {
        this.worry = this.worry.add(amt);
    }

    public void setWorry(BigInteger amt) {
        this.worry = amt;
    }

    public void mulWorry(BigInteger amt) {
        this.worry = this.worry.multiply((amt));
    }

    public void mulWorry(int amt) {
        this.worry = this.worry.multiply(BigInteger.valueOf(amt));
    }

    public void chill() {
        this.worry = this.worry.divide(BigInteger.valueOf(3));
    }

    public BigInteger getWorry() {
        return this.worry;
    }
}
