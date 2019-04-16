import java.util.ArrayList;
import java.util.List;

class Solution {
    void visit(List<Integer> visited, List<List<Integer>> rooms, int room) {
        visited.add(room);
        for (int key: rooms.get(room)) {
            if (!visited.contains(key)) {
                visit(visited, rooms, key);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> visited = new ArrayList<>();
        visit(visited, rooms, 0);
        return visited.size() == rooms.size();
    }
}
public class Main {
}
