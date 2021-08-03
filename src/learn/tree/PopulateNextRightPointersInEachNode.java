package learn.tree;

import java.util.LinkedList;
import java.util.Queue;

import models.Node;

public class PopulateNextRightPointersInEachNode {
    
    public Node connect(Node root) {
        if (root == null) return null;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int len = q.size();
            Node prev = null;
            for (int i = 0; i < len; i++) {
                Node node = q.poll();
                
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
            }
        }
        return root;
    }

    public Node connect_with_constant_space(Node root) {
        if (root == null) return null;
        
        Node leftmost = root;

        while (leftmost.next != null) {
            Node head = leftmost;
            while (head != null) {
                // Connection 1
                head.left.next = head.right;

                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}
