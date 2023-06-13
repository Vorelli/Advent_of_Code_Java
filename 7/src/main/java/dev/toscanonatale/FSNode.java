package dev.toscanonatale;

public abstract class FSNode {
    private String path;

    public FSNode(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public abstract int getSize();
}
