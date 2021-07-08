package models;

public class TreeNodeJava {
    public int val;
    public TreeNodeJava left;
    public TreeNodeJava right;

    public TreeNodeJava(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNodeJava(int val, TreeNodeJava left, TreeNodeJava right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
