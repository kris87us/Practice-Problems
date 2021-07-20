package models;

import java.util.List;

public class N_aryTreeNode {
    public int val;
    public List<N_aryTreeNode> children;

    public N_aryTreeNode(int val) {
        this.val = val;
        this.children = null;
    }

    public N_aryTreeNode(int val, List<N_aryTreeNode> children) {
        this.val = val;
        this.children = children;
    }
}
