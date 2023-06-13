package dev.toscanonatale;

public class FSFile extends FSNode {
    private int size;

    public FSFile(String path, FSDir parent, int size) {
        super(path, parent);
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}
