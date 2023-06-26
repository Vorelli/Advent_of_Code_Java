package dev.toscanonatale;

import java.math.BigInteger;
import java.util.ArrayList;

public class Monkey {
    public ArrayList<BigInteger> items;
    public String operation;
    public int test;
    public int trueThrow;
    public int falseThrow;
    private long inspections = 0;

    public Monkey() {
        this.items = new ArrayList<>();
    }

    public boolean hasNextItem() {
        return this.items.size() > 0;
    }

    public ArrayList<BigInteger> getItems() {
        return this.items;
    }

    public BigInteger getNextItem() {
        inspections++;
        return items.remove(0);
    }

    public long getInspections() {
        return this.inspections;
    }

    public void addItem(BigInteger item) {
        this.items.add(item);
    }
}
