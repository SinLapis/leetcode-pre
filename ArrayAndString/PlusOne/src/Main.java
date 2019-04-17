class Solution {
    public int[] plusOne(int[] digits) {
        boolean c = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (c) {
                digits[i]++;
                if (digits[i] >= 10) {
                    digits[i] = 0;
                } else {
                    c = false;
                }
            }
        }
        if (c) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        } else {
            return digits;
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
