public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstBadVersion(1));
    }
}
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
class VersionControl {

}
class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n, m;
        while (left < right) {
            m = left + ((right - left) >> 1);
            if (isBadVersion(m)) {
                right = m;
            } else {
                left = m + 1;
            }
        }
        return right;
    }
    boolean isBadVersion(int version) {
        return version >= 1;
    }
}