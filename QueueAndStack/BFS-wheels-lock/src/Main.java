import java.util.ArrayList;
import java.util.List;

class Password {
    private int[] password = {0, 0, 0, 0};
    private int step;

    Password(int[] password, int step) {
        System.arraycopy(password, 0, this.password, 0, 4);
        this.step = step;
    }

    int getStep() {
        return step;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            for (int i = 0; i < 4; i++) {
                if (this.password[i] != ((Password) obj).password[i]) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException cce) {
            return super.equals(obj);
        }
    }

    public List<Password> getOneStepPassword() {
        List<Password> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int[] oneStep = new int[]{0, 0, 0, 0};
            System.arraycopy(this.password, 0, oneStep, 0, 4);
            // set +1
            oneStep[i] = (oneStep[i] + 1) % 10;
            result.add(new Password(oneStep, this.step + 1));
            // set -1
            oneStep[i] = (oneStep[i] + 10 - 2) % 10;
            result.add(new Password(oneStep, this.step + 1));
        }
        return result;
    }
}

class Solution {
    private Password string2Password(String stringPassword) {
        String[] tempArray = stringPassword.split("");
        return new Password(new int[]{
                Integer.parseInt(tempArray[0]),
                Integer.parseInt(tempArray[1]),
                Integer.parseInt(tempArray[2]),
                Integer.parseInt(tempArray[3]),
        }, -1);
    }

    public int openLock(String[] deadends, String target) {
        // convert string to Password
        List<Password> deadendsP = new ArrayList<>();
        for (String deadend : deadends) {
            deadendsP.add(string2Password(deadend));
        }
        Password targetP = string2Password(target);
        List<Password> oneStepPassword = new ArrayList<>();
        List<Password> usedPassword = new ArrayList<>();
        // 0. set start password
        Password next = new Password(new int[]{0, 0, 0, 0}, 0);
        // check if 0000 is in deadends
        if (deadendsP.contains(next)) {
            return -1;
        }
        oneStepPassword.add(next);
        while (true) {
            next = oneStepPassword.get(0);
            oneStepPassword.remove(0);
            // 1. check if next is target
            if (next.equals(targetP)) {
                return next.getStep();
            }
            // 2. generate one step password
            List<Password> midPassword = next.getOneStepPassword();
            usedPassword.add(next);
            for (Password mid : midPassword) {
                if (!deadendsP.contains(mid) && !usedPassword.contains(mid) && !oneStepPassword.contains(mid)) {
                    oneStepPassword.add(mid);
                }
            }
            if (oneStepPassword.isEmpty()) {
                return -1;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();   //获取开始时间
        Solution s = new Solution();
        System.out.println(s.openLock(new String[]{
                "8887", "8889", "8878", "8898", "7888", "9888"
        }, "8888"));
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}
