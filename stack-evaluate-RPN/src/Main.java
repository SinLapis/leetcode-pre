import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int calculate(String rtS, String rsS, String operator) {
        // rt is earlier popped than rs
        int rt = Integer.parseInt(rtS);
        int rs = Integer.parseInt(rsS);
        switch (operator) {
            case "+":
                return rs + rt;
            case "-":
                return rs - rt;
            case "*":
                return rs * rt;
            case "/":
                return rs / rt;
            default:
                return 0;
        }
    }
    public int evalRPN(String[] tokens) {
        Stack<String> strings = new Stack<>();
        List<String> operators = new ArrayList<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        for (String s: tokens) {
            if (operators.contains(s)) {
                String rt = strings.pop();
                String rs = strings.pop();
                strings.push("" + calculate(rt, rs, s));
            } else {
                strings.push(s);
            }
        }
        return Integer.parseInt(strings.pop());
    }
}
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
