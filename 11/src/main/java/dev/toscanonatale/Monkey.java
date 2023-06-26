package dev.toscanonatale;

import java.util.ArrayList;

public class Monkey {
    public ArrayList<Long> items;
    public String operation;
    public int test;
    public int trueThrow;
    public int falseThrow;
    private int inspections = 0;

    public Monkey() {
        this.items = new ArrayList<>();
    }

    public boolean hasNextItem() {
        return this.items.size() > 0;
    }

    public ArrayList<Long> getItems() {
        return this.items;
    }

    public long getNextItem() {
        inspections++;
        return items.remove(0);
    }

    public int getInspections() {
        return this.inspections;
    }

    public void addItem(long item) {
        this.items.add(item);
    }
}
