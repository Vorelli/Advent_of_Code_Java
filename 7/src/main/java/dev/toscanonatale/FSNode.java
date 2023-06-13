package dev.toscanonatale;

public abstract class FSNode {
    private String path;
    private FSDir parent;

    public FSNode(String path, FSDir parent) {
        this.path = path;
        this.parent = parent;
    }

    public FSNode(String path) {
        this(path, null);
    }

    public String getPath() {
        return this.path;
    }

    public FSDir getParent() {
        return this.parent;
    }

    public abstract int getSize();
}
