import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2);
    }
}

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 计数
        HashMap<Integer, Integer> num2Count = new HashMap<>();
        for (int n: nums) {
            num2Count.put(n, num2Count.getOrDefault(n, 0) + 1);
        }
        // 反向映射
        HashMap<Integer, List<Integer>> count2Num = new LinkedHashMap<>();
        for (int n: num2Count.keySet()) {
            int c = num2Count.get(n);
            List<Integer> l = count2Num.getOrDefault(c, new ArrayList<>());
            l.add(n);
            count2Num.put(c, l);
        }
        Integer[] a = count2Num.keySet().toArray(new Integer[0]);
        Arrays.sort(a);
        List<Integer> result = new ArrayList<>();
        for (int i = a.length - 1; k > 0 && i >= 0; i--) {
            result.addAll(count2Num.get(a[i]));
            k -= count2Num.get(a[i]).size();
        }
        return result;
    }
}
