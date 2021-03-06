import java.util.HashMap;

public class Main {
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (index.containsKey(nums[i]) && i - index.get(nums[i]) <= k) {
                return true;
            }
            index.put(nums[i], i);
        }
        return false;
    }
}
