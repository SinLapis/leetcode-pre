public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.guessNumber(2126753390));
    }
}

class GuessGame {

}

class Solution extends GuessGame {
    public int guessNumber(int n) {
        long left = 1, right = n;
        long guessNumber;
        long result;
        while (true) {
            guessNumber = (left + right) >> 1;
            result = guess((int)guessNumber);
            if (result == 0) {
                return (int)guessNumber;
            } else if (result > 0) {
                left = guessNumber + 1;
            } else {
                right = guessNumber - 1;
            }
        }
    }

    int guess(int n) {
        if (n == 1702766719) {
            return 0;
        }
        if (n > 1702766719) {
            return -1;
        }
        return 1;
    }
}
