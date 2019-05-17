
public class Main {
    public static void main(String[] args) {
        int[] l1 = new int[] {1,2};
        int[] l2 = new int[] {-1,3};
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(l1, l2));
    }
}

class Comparation {
    int left, right, mid;
    int smaller, equal, larger;

    public Comparation() {
        reset();
    }

    public void reset() {
        this.smaller = 0;
        this.equal = 0;
        this.larger = 0;
    }
}

class Solution {
    double doubleMedian(int[] num) {
        int len = num.length, half;
        if ((len & 1) == 1) {
            return (double) num[len >> 1];
        } else {
            half = (len >> 1) - 1;
            return ((double) (num[half] + num[half + 1])) / 2.0;
        }
    }

    void compare(int[] num, Comparation c) {
        for (int value : num) {
            if (value > c.mid) c.larger++;
            else if (value < c.mid) c.smaller++;
            else c.equal++;
        }
    }

    double medianInEvenLengthArray(int[] nums1, int[] nums2) {
        int half = (nums1.length + nums2.length >> 1);
        Comparation cr = new Comparation();
        Comparation cl = new Comparation();
        cr.left = cl.left = Math.min(nums1[0], nums2[0]);
        cr.right = cl.right = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);
        while (cr.left < cr.right) {
            cr.reset();
            cr.mid = cr.left + (cr.right - cr.left >> 1);
            compare(nums1, cr);
            compare(nums2, cr);
            if (cr.smaller < half && cr.larger < half && cr.equal >= 2) return (double) cr.mid;
            else if(cr.smaller > cr.larger && cr.smaller <= half && cr.equal > 0) break;
            else if(cr.larger >= cr.smaller) {
                cr.left = cr.mid + 1;
            } else {
                cr.right = cr.mid;
            }
        }
        if (cr.left == cr.right) cr.mid = cr.right;
        while (cl.left < cl.right) {
            cl.reset();
            cl.mid = cl.left + (cl.right - cl.left >> 1);
            compare(nums1, cl);
            compare(nums2, cl);
            if(cl.smaller < cl.larger && cl.larger <= half && cl.equal > 0) break;
            else if (cl.smaller >= cl.larger) {
                cl.right = cl.mid;
            } else {
                cl.left = cl.mid + 1;
            }
        }
        if (cl.left == cl.right) cl.mid = cl.left;
        return ((double) (cl.mid + cr.mid)) / 2.0;
    }

    double medianInOddLengthArray(int[] nums1, int[] nums2) {
        int half = nums1.length + nums2.length >> 1;
        Comparation c = new Comparation();
        c.left = Math.min(nums1[0], nums2[0]);
        c.right = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);
        while (c.left < c.right) {
            c.reset();
            c.mid = c.left + (c.right - c.left >> 1);
            compare(nums1, c);
            compare(nums2, c);
            if (c.smaller <= half && c.larger <= half && c.equal > 0) return (double) c.mid;
            else if (c.smaller > c.larger) {
                c.right = c.mid;
            } else {
                c.left = c.mid + 1;
            }
        }
        return (double) c.right;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 == 0) return doubleMedian(nums2);
        if (len2 == 0) return doubleMedian(nums1);
        if ((len1 + len2 & 1) == 0) {
            return medianInEvenLengthArray(nums1, nums2);
        } else {
            return medianInOddLengthArray(nums1, nums2);
        }
    }
}