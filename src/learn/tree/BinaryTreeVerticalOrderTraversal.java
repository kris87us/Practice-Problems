package learn.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import helper.Helper;
import models.TreeNodeJava;

public class BinaryTreeVerticalOrderTraversal {

    public static void main(String[] args) {
        List<List<Integer>> res = verticalOrder(Helper.createBinaryTree());
        System.out.println(res);
    }

    static Map<Integer, Map<Integer, List<Integer>>> map;

    public static List<List<Integer>> verticalOrder(TreeNodeJava root) {
        if (root == null)
            return new ArrayList<>();

        map = new TreeMap<>();

        dfs(root, 0, 0);
        
        List<List<Integer>> result = new ArrayList<>();        
        for (Integer x : map.keySet()) {
            List<Integer> temp = new ArrayList<>();
            for (Integer y : map.get(x).keySet()) {
                temp.addAll(map.get(x).get(y));            
            }
            result.add(temp);
        }
        return result;
    }

    private static void dfs(TreeNodeJava node, int x, int y) {
        // Common Case
        if (!map.containsKey(x)) {
            Map<Integer, List<Integer>> temp = new TreeMap<>();
            map.put(x, temp);
        }
        if (!map.get(x).containsKey(y)) {
            List<Integer> temp = new ArrayList<>();
            temp.add(node.val);
            map.get(x).put(y, temp);
        } else {
            map.get(x).get(y).add(node.val);
        }

        // Base Case
        // Not needed

        // Recursive case
        if (node.left != null) {
            dfs(node.left, x - 1, y + 1);
        }
        if (node.right != null) {
            dfs(node.right, x + 1, y + 1);
        }
    }
}
