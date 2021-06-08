package learn.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// Input: [[1, 3, 5], [2, 4, 6], [7, 10]]
// Output: [1, 2, 3, 4, 5, 6, 7, 10]
public class Merge_K_Sorted_Lists {
    public static List<Integer> mergeKSortedLists(List<List<Integer>> lists, int k) {
        // WRITE YOUR BRILLIANT CODE HERE
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Element> heap = new PriorityQueue<Element>(k, Comparator.comparing((e -> e.val)));

        // Add first element of each list to the HEAP
        for (List<Integer> list : lists) {
            heap.add(new Element(list.get(0), list, 0));
        }
        while (!heap.isEmpty()) {
            Element element = heap.remove();
            int smallest = element.val;
            List<Integer> currentArr = element.fromArray;
            int headIndex = element.headIndex;

            result.add(smallest);

            if (headIndex + 1 < currentArr.size()) {
                heap.add(new Element(currentArr.get(headIndex + 1), currentArr, headIndex + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(mergeKSortedLists(List.of(List.of(1, 3, 5), List.of(2, 4, 6), List.of(7, 10)), 3));
    }
}

class Element {
    int val;
    List<Integer> fromArray;
    int headIndex;

    public Element(int val, List<Integer> fromArray, int headIndex) {
        this.val = val;
        this.fromArray = fromArray;
        this.headIndex = headIndex;
    }
}