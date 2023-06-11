package dev.toscanonatale;

import java.util.ArrayList;

public class StackOfCrates {
    public ArrayList<String> stack;

    public StackOfCrates() {
        this.stack = new ArrayList<>();
    }

    public void add(String s) {
        this.stack.add(s);
    }

    public String pop() {
        if (this.stack.size() > 0)
            return this.stack.remove(0);
        return "";
    }
}
