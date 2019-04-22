class Solution {
    public void reverseWord(char[] words, int start, int end) {
        char temp;
        int half = (end + start) / 2;
        for (int i = start; i <= half; i++) {
            temp = words[i];
            words[i] = words[start + end - i];
            words[start + end - i] = temp;
        }
    }
    public String reverseWords(String s) {
        char[] words = s.toCharArray();
        int back = 0, front = 0;
        for (; front < s.length(); front++) {
            if (words[front] == ' ' && front - back > 0) {
                reverseWord(words, back, front - 1);
                back = front + 1;
            } else if (front == s.length() - 1 && front - back > 0) {
                reverseWord(words, back, front);
            }
        }
        return String.valueOf(words);
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords("hello world!"));
    }
}
