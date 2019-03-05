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

class SolutionTimeout {
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
                if (!deadendsP.contains(mid) && !usedPassword.contains(mid)) {
                    oneStepPassword.add(mid);
                }
            }
            if (oneStepPassword.isEmpty()) {
                return -1;
            }
        }
    }
}

class Solution {
    private List<String> getOneStep(String next) {
        String[] tempString = next.split("");
        int[] tempInt = new int[4];
        int[] backup = new int[4];
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            tempInt[i] = Integer.parseInt(tempString[i]);
        }
        System.arraycopy(tempInt, 0, backup, 0, 4);
        for (int i = 0; i < 4; i++) {
            System.arraycopy(backup, 0, tempInt, 0, 4);
            tempInt[i] = (tempInt[i] + 1) % 10;
            result.add("" + tempInt[0] + tempInt[1] + tempInt[2] + tempInt[3]);
            // set -1
            tempInt[i] = (tempInt[i] + 10 - 2) % 10;
            result.add("" + tempInt[0] + tempInt[1] + tempInt[2] + tempInt[3]);
        }
        return result;
    }
    private boolean findString(String[] list, String target) {
        for (String s: list) {
            if (target.equals(s)) {
                return true;
            }
        }
        return false;
    }
    public int openLock(String[] deadends, String target) {
        String[] oneStepPassword = new String[10001];
        int oneHead = 0;
        int oneTail = 0;
        String[] usedPassword = new String[10000];
        int usedPointer = 0;
        String next = "0000";
        if (findString(deadends, next)) {
            return -1;
        }
        oneStepPassword[oneTail] = next;
        oneTail++;
        int step = 0;
        int total = 1;
        int nextTotal = 0;
        while (true) {
            next = oneStepPassword[oneHead];
            oneHead++;
            total--;
            // 1. check if next is target
            if (next.equals(target)) {
                return step;
            }
            // 2. generate one step password
            List<String> midPassword = getOneStep(next);
            usedPassword[usedPointer] = next;
            usedPointer++;
            for (String mid : midPassword) {
                if (!findString(deadends, mid) && !findString(usedPassword, mid)) {
                    oneStepPassword[oneTail] = mid;
                    oneTail++;
                    nextTotal++;
                }
            }
            if (oneHead == oneTail) {
                return -1;
            }
            if (total == 0) {
                total = nextTotal;
                nextTotal = 0;
                step++;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.openLock(new String[]{
                "0201", "0101", "0102", "1212", "2002"
        }, "0202"));
    }
}
