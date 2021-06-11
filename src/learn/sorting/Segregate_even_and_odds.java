package learn.sorting;

import java.util.ArrayList;
import java.util.Arrays;

import static helper.Helper.swapArrayList;

public class Segregate_even_and_odds {
    public static void main(String[] args) {
        System.out.print(segregate_evens_and_odds(new ArrayList<>(Arrays.asList(4, 9, 5, 24, 2, 6, 8, 1, 2, 9, 5, 7, 10))));
    }

    static ArrayList<Integer> segregate_evens_and_odds(ArrayList<Integer> numbers) {
        // Write your code here.
        int odd = numbers.size() - 1;
        int even = 0;

        while (even < odd) {
            int elementAtEvenIndex = numbers.get(even);
            int elementAtOddIndex = numbers.get(odd);

            if ((elementAtEvenIndex % 2 != 0) && (elementAtOddIndex % 2 == 0)) { // ElementAtEvenIndex is Odd
                swapArrayList(numbers, even, odd);
                even++;
                odd--;
            } else if (elementAtOddIndex % 2 == 0) {
                even++;
            } else {
                odd--;
            }
        }
        return numbers;
    }


}
