import java.util.*;

public class Main {
}
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> l1 = Arrays.asList(list1);
        HashMap<Integer, List<String>> restaurant = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            if (l1.contains(list2[i])) {
                int sum = l1.indexOf(list2[i]) + i;
                if (restaurant.containsKey(sum)) {
                    restaurant.get(sum).add(list2[i]);
                } else {
                    restaurant.put(sum, new ArrayList<>(Collections.singleton(list2[i])));
                }
            }
        }
        int minIndex = list1.length + list2.length;
        for (int i: restaurant.keySet()) {
            if (i < minIndex) {
                minIndex = i;
            }
        }
        return restaurant.get(minIndex).toArray(new String[0]);
    }
}