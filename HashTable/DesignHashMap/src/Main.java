import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(2);
        l.add(3);
        l.add(4);
        l.remove((Integer) 4);
        System.out.println(l);
    }

}

class MyHashMap {
    List<Integer> keys, values;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        if (keys.contains(key)) {
            int index = keys.indexOf(key);
            values.set(index, value);
        } else {
            keys.add(key);
            values.add(value);
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        if (keys.contains(key)) {
            int index = keys.indexOf(key);
            return values.get(index);
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        if (keys.contains(key)) {
            int index = keys.indexOf(key);
            keys.remove(index);
            values.remove(index);
        }
    }
}