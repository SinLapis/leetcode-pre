import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(1);
        l.add(2);
        l.remove((Integer)1);
        System.out.println(l);
    }
}
class MyHashSet {
    List<List<Integer>> buckets = new ArrayList<>(1000);

    /** Initialize your data structure here. */
    public MyHashSet() {
        for (int i = 0; i < 1000; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    public void add(int key) {
        int bucketIndex = key % 1000;
        buckets.get(bucketIndex).add(key);
    }

    public void remove(int key) {
        int bucketIndex = key % 1000;
        while (buckets.get(bucketIndex).contains(key)) {
            buckets.get(bucketIndex).remove((Integer)key);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = key % 1000;

        return buckets.get(bucketIndex).contains((Integer)key);
    }
}


