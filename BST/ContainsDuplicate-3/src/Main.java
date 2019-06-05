import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }
}

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        Long low, high, inSet;
        for (int i = 0; i < nums.length; i++) {
            if (set.size() > k) {
                set.remove((long)nums[i - k - 1]);
            }
            low = (long)nums[i] - t;
            high = (long)nums[i] + t;
            inSet = set.floor(high);
            if (inSet != null && inSet >= low) return true;
            else {
                set.add((long)nums[i]);
            }
        }
        return false;
    }
}
