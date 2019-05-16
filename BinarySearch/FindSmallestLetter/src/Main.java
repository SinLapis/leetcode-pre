public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[] l = new char[]{'e','e','e','e','e','e','n','n','n','n'};
        System.out.println(s.nextGreatestLetter(l, 'e'));
    }
}
class Solution {
//    char ascendSearch(char[] ls, char t) {
//
//    }
//    char cliffSearch(char[] ls, char t) {
//
//    }
    public char nextGreatestLetter(char[] letters, char target) {
        int right = letters.length - 1;
        if (target >= letters[right]) return letters[0];
        int left = 0, mid;
        while (left < right) {
            mid = left + (right - left >> 1);
            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return letters[right];
    }
}
