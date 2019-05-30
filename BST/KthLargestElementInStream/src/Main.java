import java.util.*;

public class Main {
    public static void main(String[] args) {
        KthLargest k = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        Queue<Integer> q = new PriorityQueue<>();
    }
}

class KthLargest {
    int[] l;
    boolean ready;

    public KthLargest(int k, int[] nums) {
        if (k > nums.length) {
            l = Arrays.copyOf(nums, k);
            ready = false;
            return;
        }
        l = new int[k];
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            l[i] = nums[nums.length - k + i];
        }
        ready = true;
    }

    int addFirst(int val) {
        l[l.length - 1] = val;
        Arrays.sort(l);
        ready = true;
        return l[0];
    }

    public int add(int val) {
        if (!ready) return addFirst(val);
        int i, j;
        if (val < l[0]) return l[0];
        for (i = 0; i < l.length; i++) {
            if (val < l[i]) {
                break;
            }
        }
        for (j = 1; j < i; j++) {
            l[j - 1] = l[j];
        }
        l[j - 1] = val;
        return l[0];
    }
}