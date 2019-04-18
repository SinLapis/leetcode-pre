class Solution {
    public void reverseString(char[] s) {
        int front = 0;
        int back = s.length - 1;
        char temp;
        for (; front < back; front++, back--) {
            temp = s[front];
            s[front] = s[back];
            s[back] = temp;
        }
    }
}
public class Main {
    public static void main(String[] args) {

    }
}