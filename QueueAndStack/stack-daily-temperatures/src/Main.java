import java.util.Arrays;
import java.util.Stack;

class Temperature {
    private int temperature;
    private int day;
    private int remain;
    Temperature(int temperature, int day) {
        this.temperature = temperature;
        this.day = day;
        this.remain = 0;
    }
    public void passOneDay() {
        remain++;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getDay() {
        return day;
    }

    public int getRemain() {
        return remain;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] remainDays = new int[T.length];
        if (T.length == 0)
            return remainDays;
        Stack<Temperature> temperatures = new Stack<>();
        temperatures.push(new Temperature(T[0], 0));
        for (int i = 1; i < T.length; i++) {
            boolean addFlag = false;
            for (int j = temperatures.size() - 1; j >= 0; j--) {
                if (addFlag) {
                    temperatures.get(j).passOneDay();
                } else if (temperatures.get(j).getTemperature() < T[i]) {
                    Temperature out = temperatures.pop();
                    out.passOneDay();
                    remainDays[out.getDay()] = out.getRemain();
                    if (j == 0) {
                        temperatures.push(new Temperature(T[i], i));
                    }
                } else {
                    temperatures.push(new Temperature(T[i], i));
                    addFlag = true;
                    j++;
                }
            }
        }
        return remainDays;
    }
}
public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();   //获取开始时间
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}
