package helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.TreeNodeJava;

public class Helper {

    public static TreeNodeJava createBinaryTree() {
        /**
                1
             2     3
           4   5 6   7
        */
        TreeNodeJava root = new TreeNodeJava(1, 
            new TreeNodeJava(2, 
        new TreeNodeJava(4, new TreeNodeJava(8), null), new TreeNodeJava(4)), 
            new TreeNodeJava(4, 
        new TreeNodeJava(4), new TreeNodeJava(4)));

        return root;
    }

    /**
            4
         2     6
       1   3 5   7
    */
    public static TreeNodeJava createBST() {
        TreeNodeJava root = new TreeNodeJava(4, 
            new TreeNodeJava(2, 
        new TreeNodeJava(1), new TreeNodeJava(3)), 
            new TreeNodeJava(6, 
        new TreeNodeJava(5), new TreeNodeJava(7)));

        return root;
    }

    public static int[] convertIntegerListToArray(final List<Integer> list)
    {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int pickRandom(int start, int end) {
        Random rand = new Random();
        return rand.nextInt((end - start) + 1) + start;
    }

    public static void swapArray(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void swap2DArray(int[][] nums, int i, int j) {
        int[] temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void swapArrayList(ArrayList<Integer> nums, int a1, int a2) {
        int temp = nums.get(a1);
        nums.set(a1, nums.get(a2));
        nums.set(a2, temp);
    }

    public static int twoWayPartition(int[] nums, int smallerIndex, int biggerIndex, int pivotElement, int start, int end) {
        for (int i = biggerIndex; i <= end;) {
            if (nums[i] <= pivotElement) {
                smallerIndex++;
                swapArray(nums, i, smallerIndex);
            }
            i++;
        }
        swapArray(nums, smallerIndex, start);
        return smallerIndex;
    }

    public static int threeWayPartition(int[] nums, int smallerIndex, int equalIndex, int biggerIndex, int pivotElement, int start, int end) {
        for (int i = biggerIndex; i <= end;) {
            if (nums[i] < pivotElement) {
                smallerIndex++;
                swapArray(nums, i, smallerIndex);
            } else if (nums[i] == pivotElement) {
                equalIndex++;
                swapArray(nums, i, equalIndex);
            }
            i++;
        }
        //swap(nums, biggerIndex, equalIndex);
        swapArray(nums, smallerIndex, start);
        System.out.print("Start: "+start);
        System.out.print("Smaller: "+ smallerIndex);
        System.out.print("Bigger: "+ biggerIndex);
        System.out.println("Equal: "+equalIndex);
        return smallerIndex;
    }
}
