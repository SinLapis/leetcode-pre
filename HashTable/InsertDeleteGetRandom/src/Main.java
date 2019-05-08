import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        RandomizedSet s = new RandomizedSet();
        s.insert(0);
        s.remove(0);
        s.insert(-1);
        s.remove(0);
        s.getRandom();
        s.getRandom();
        s.getRandom();
        s.getRandom();
        s.getRandom();
        s.getRandom();
        s.getRandom();
        s.getRandom();
        s.getRandom();
        s.getRandom();
    }
}

class RandomizedSet {
    HashMap<Integer, Integer> element2Index;
    HashMap<Integer, Integer> index2Element;
    int index;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        element2Index = new HashMap<>();
        index2Element = new HashMap<>();
        index = 0;
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (element2Index.containsKey(val)) {
            return false;
        } else {
            element2Index.put(val, index);
            index2Element.put(index, val);
            index++;
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (element2Index.containsKey(val)) {
            index--;
            int i = element2Index.get(val);
            int move = index2Element.get(index);
            element2Index.put(move, i);
            index2Element.put(i, move);
            element2Index.remove(val);
            index2Element.remove(index);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random random = new Random();
        int i = random.nextInt(index);
        return index2Element.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */