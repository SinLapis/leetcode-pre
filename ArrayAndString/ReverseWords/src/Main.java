import java.util.Arrays;

class Solution {
    public String reverseWords(String s) {
        if (s.equals("")) {
            return "";
        }
        String[] words = s.split(" ");
        System.out.println(Arrays.toString(words));
        StringBuilder result = new StringBuilder();
        boolean empty = true;
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].equals("")) {
                empty = false;
                result.append(words[i]);
                result.append(" ");
            }
        }
        if (empty) {
            return "";
        }
        return result.delete(result.length() - 1, result.length()).toString();
    }
}

public class Main {
    public static void main(String[] args) {


        long startTime = System.currentTimeMillis();   //获取开始时间
        Solution s = new Solution();
        System.out.println(s.reverseWords("the sky is blue"));
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}
