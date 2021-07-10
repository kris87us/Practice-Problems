package learn.sorting;

import java.util.ArrayList;
import java.util.List;

public class FilterRestaurants {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<List<Integer>> filtered = new ArrayList<List<Integer>>();
        for (int i = 0; i < restaurants.length; i++) {
            int isRestaurantVegan = restaurants[i][2];
            if (veganFriendly == 0 || (veganFriendly == isRestaurantVegan)) {
                int id = restaurants[i][0];
                int rating = restaurants[i][1];
                int price = restaurants[i][3];
                int distance = restaurants[i][4];
                
                if (price <= maxPrice && distance <= maxDistance) {
                    List<Integer> rest = new ArrayList<>();
                    rest.add(id);
                    rest.add(rating);
                    rest.add(price);
                    rest.add(distance);
                    filtered.add(rest);
                }
            }
            
        }
        
        // Sort using comparator that checks rating first and if they are equal checks ID
        filtered.sort((a, b) -> {
           if (a.get(1).equals(b.get(1))) {
               return b.get(0) - a.get(0);
           } else {
               return b.get(1) - a.get(1);
           }
        });
        
        // Extract IDs from sorted list and return
        List<Integer> result = new ArrayList<Integer>();
        for (List<Integer> n : filtered) {
            result.add(n.get(0));
        }
        return result;
    }
}
