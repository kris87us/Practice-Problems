package learn.tree;

import models.ListNode;
import models.TreeNodeJava;

// Time: O(n)
// Space: O(log n) - Only call stack space is counted
public class ConvertSortedLinkedListToBST {
    static ListNode[] curr;
    static TreeNodeJava sorted_list_to_bst(ListNode head) {
        if (head == null) return null;
        
        // Calculate number of nodes in LL
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length += 1;
            p = p.next;
        }
        // Create new result list
        curr = new ListNode[1];
        // Assign head node to result
        curr[0] = head;
        
        return helper(0, length - 1);
    }
    
    static TreeNodeJava helper(int start, int end) {
        // Base case
        if (start > end) { // ZERO relements
            return null;
        }
        if (start == end) { // ONE element
            int rootVal = curr[0].val;
            curr[0] = curr[0].next;
            return new TreeNodeJava(rootVal);
        }
        // Recursive case
        int mid = (start + end) / 2;
        
        // Recurse on left subtree to find root
        TreeNodeJava l = helper(start, mid - 1);
        // Assign root since curr[0] will be at the right place
        TreeNodeJava root = new TreeNodeJava(curr[0].val);
        root.left = l;
        // Increment the pointer so that next is updated for the right subordinate
        curr[0] = curr[0].next;
        root.right = helper(mid + 1, end);
        
        return root;
    }
}
