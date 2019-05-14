import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String l = "1,1,2,2,3,3,6,7,8,9,9,11,11,12,12,12,13,15,18,18,21,22,22,23,25,25,32,33,34,37,37,38,38,39,39,40,41,43,43,45,45,46,46,48,48,49,50,50,53,53,54,54,56,57,57,58,58,60,60,61,62,63,63,66,69,70,71,71,71,74,75,75,76,76,80,81,81,82,84,86,86,87,87,87,88,90,91,93,93,93,94,94,94,95,96,97,98,98,98,99";
        String[] lss = l.split(",");
        int[] is = new int[lss.length];
        for (int i = 0; i < lss.length; i++) {
            is[i] = Integer.parseInt(lss[i]);
        }
        System.out.println(s.findClosestElements(is,
                3, 13));
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (k == 0) {
            return result;
        }
        // 确定中心值
        int center = -1, lastCenter = -1;
        int left = 0, right = arr.length - 1;
        int leftAbs, rightAbs, midAbs;
        if (x <= arr[0]) {
            center = 0;
        } else if (x >= arr[right]) {
            center = right;
        } else {
            while (left < right) {
                lastCenter = center;
                center = left + (right - left >> 1);
                if (arr[center] > x) {
                    right = center;
                } else if (arr[center] <= x) {
                    left = center;
                }
                if (lastCenter == center) {
                    break;
                }
            }
        }
        System.out.println(center);
        System.out.println(arr[center]);
        // 扩展区间长度为k
        left = center;
        right = center;
        for (int i = 1; i < k; i++) {
            if (left <= 0) {
                right++;
            } else if (right >= arr.length - 1) {
                left--;
            } else {
                leftAbs = Math.abs(arr[left - 1] - x);
                rightAbs = Math.abs(arr[right + 1] - x);
                if (leftAbs <= rightAbs) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        // 尝试滑动区间
        if (left == center) {
            while (true) {
                if (right >= arr.length - 1) break;
                if (arr[center] == arr[center + 1] && Math.abs(arr[left] - x) > Math.abs(arr[right + 1] - x)) {
                    left++;
                    right++;
                } else  {
                    break;
                }
            }
        } else if (right == center) {
            while (true) {
                if (left <= 0) break;
                if (arr[center] == arr[center - 1] && Math.abs(arr[left - 1] - x) < Math.abs(arr[right] - x)) {
                    left--;
                    right--;
                } else {
                    break;
                }
            }
        }

        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
