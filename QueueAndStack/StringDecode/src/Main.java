import java.util.Stack;

class Solution {
    public String repeat(String base, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(base);
        }
        return result.toString();
    }

    public String decodeString(String s) {
        Stack<Character> characters = new Stack<>();
        char[] input = s.toCharArray();
        for (char i : input) {
            if (i != ']') {
                characters.push(i);
            } else {
                StringBuilder baseSB = new StringBuilder();
                StringBuilder countSB = new StringBuilder();
                // fill base
                while (!characters.isEmpty()) {
                    char c = characters.pop();
                    if (c != '[') {
                        baseSB.insert(0, c);
                    } else {
                        break;
                    }
                }
                // fill count
                while (!characters.isEmpty()) {
                    char c = characters.pop();
                    if (c >= '0' && c <= '9') {
                        countSB.insert(0, c);
                    } else {
                        characters.push(c);
                        break;
                    }
                }
                // fill result
                StringBuilder tempSB = new StringBuilder();
                String base = baseSB.toString();
                int count = Integer.parseInt(countSB.toString());
//                resultSB.append(base.repeat(count));
                tempSB.append(repeat(base, count));
                for (char t: tempSB.toString().toCharArray()) {
                    characters.push(t);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character c: characters) {
            result.append(c);
        }
        return result.toString();
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Solution s = new Solution();
        System.out.println(s.decodeString("3[ab2[def]]"));
    }
}
