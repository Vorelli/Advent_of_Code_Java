package dev.toscanonatale;

import java.util.ArrayList;

public class StackOfCrates {
    public ArrayList<String> stack;

    public StackOfCrates() {
        this.stack = new ArrayList<>();
    }

    public void addFromTop(String s) {
        this.stack.add(0, s);
    }

    public void add(String s) {
        this.stack.add(s);
    }

    public void print() {
        for (String s : this.stack) {
            System.out.print(s);
        }
        System.out.println("");
    }

    public String pop() {
        if (this.stack.size() > 0)
            return this.stack.remove(this.stack.size() - 1);
        return "";
    }
}
