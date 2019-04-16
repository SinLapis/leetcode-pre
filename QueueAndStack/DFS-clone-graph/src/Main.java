import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
class Solution {
    public Node cloneGraph(Node node) {
        Node cloneNode = new Node(node.val, node.neighbors);
    }
}
public class Main {

    public static void main(String[] args) {

    }
}
