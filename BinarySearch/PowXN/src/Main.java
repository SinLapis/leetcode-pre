public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPow(1.000000d, -2147483648));
    }
}

class Solution {
    double pow(double x, long n) {
        if (n == 1) return x;
        else {
            double temp = pow(x, n >> 1);
            if (Math.abs(temp - 0.0) < 4.9E-324) {
                return 0.0d;
            }
            if (n % 2 == 0) {
                return temp * temp;
            } else {
                return temp * temp * x;
            }
        }
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1.0d;
        boolean minus = false;
        boolean overflow = false;
        int mn;
        if (n < 0) {
            minus = true;
            if (n == -2147483648) {
                mn = 2147483647;
                overflow = true;
            } else {
                mn = -n;
            }
        } else {
            mn = n;
        }
        double y = pow(x, mn);
        if (overflow) {
            y *= x;
        }
        if (minus) {
            y = 1 / y;
        }
        return y;
    }
}