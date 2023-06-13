package dev.toscanonatale;

import java.util.ArrayList;

public class FSDir extends FSNode {
    private ArrayList<FSNode> children;

    public FSDir(String path, FSDir parent) {
        super(path, parent);
        this.children = new ArrayList<>();
    }

    public int getSize() {
        int size = 0;
        for (FSNode n : this.children) {
            size += n.getSize();
        }
        return size;
    }

    public void addChild(FSNode child) {
        this.children.add(child);
    }

    public FSDir findChild(String directoryName) {
        for (FSNode child : this.children) {
            String[] path = child.getPath().split("/");
            if (child instanceof FSDir && path[path.length - 1].equals(directoryName)) {
                return (FSDir) child;
            }
        }
        return null;
    }

    public int getDirUnder100k() {
        int sum = 0;
        int size = this.getSize();
        if (size < 100000) {
            sum += size;
        }
        for (FSNode child : this.children) {
            if (child instanceof FSDir) {
                sum += ((FSDir) child).getDirUnder100k();
            }
        }
        return sum;
    }

    public int findClosestToSize(int size) {
        int ret = Integer.MAX_VALUE;
        if (this.getSize() >= size)
            ret = this.getSize();
        for (FSNode child : this.children) {
            if (child instanceof FSDir) {
                int childSize = ((FSDir) child).findClosestToSize(size);
                if (childSize >= size) {
                    ret = Math.min(ret, childSize);
                }
            }
        }
        return ret;
    }

    public int getSmallestForUpdate() {
        int start = (70000000 - this.getSize());
        int needed = 30000000 - start;
        return this.findClosestToSize(needed);
    }
}
