import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }
        String[] tempArray = s.split("");
        Stack<String> strings = new Stack<>();
        for (String t : tempArray) {
            if (strings.empty()) {
                strings.push(t);
                continue;
            }
            if (t.equals(")") && strings.peek().equals("(")) {
                strings.pop();
            } else if (t.equals("]") && strings.peek().equals("[")) {
                strings.pop();
            } else if (t.equals("}") && strings.peek().equals("{")) {
                strings.pop();
            } else {
                strings.push(t);
            }
        }
        return strings.empty();
    }
}

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();   //获取开始时间
        Solution s = new Solution();
        System.out.println(s.isValid("()"));
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}
