package dev.toscanonatale;

public class FSFile extends FSNode {
    private int size;

    public FSFile(String path, int size) {
        super(path);
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}
