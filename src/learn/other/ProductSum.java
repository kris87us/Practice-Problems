package learn.other;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {
    private static int prodSum = 0;
    public static int productSum(List<Object> array) {
        // Write your code here.
        return productSumHelper(array, 1);
    }

    public static int productSumHelper(List<Object> array, int multiplier) {
        for (Object element : array) {
            if (element instanceof ArrayList) {
                prodSum = productSumHelper((List<Object>) element, multiplier++);
            } else if (element instanceof Integer) {
                prodSum += (multiplier * (int) element);
            }
        }

        return prodSum;
    }
}
