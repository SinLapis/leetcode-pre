import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
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
*/
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Route {
    public int nodeIDA;
    public int nodeIDB;

    Route(int a, int b) {
        nodeIDA = a;
        nodeIDB = b;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Route castObj = (Route) obj;
            boolean aFlag = castObj.nodeIDA == nodeIDA && castObj.nodeIDB == nodeIDB;
            boolean bFlag = castObj.nodeIDB == nodeIDA && castObj.nodeIDA == nodeIDB;
            return aFlag || bFlag;
        } catch (ClassCastException cce) {
            return super.equals(obj);
        }
    }
}

class Solution {
    public boolean checkContainId(List<Node> nodes, int exNodeID) {
        for (Node n : nodes) {
            if (n.val == exNodeID) {
                return true;
            }
        }
        return false;
    }

    public Node findNode(List<Node> nodes, int nodeID) {
        for (Node n : nodes) {
            if (n.val == nodeID) {
                return n;
            }
        }
        return null;
    }

    public Node cloneGraph(Node node) {
        Node next = node;
        List<Route> routes = new ArrayList<>();
        Stack<Node> visitedNode = new Stack<>();
        List<Node> originNodes = new ArrayList<>();
        List<Node> cloneNodes = new ArrayList<>();
        visitedNode.push(node);
        cloneNodes.add(new Node(node.val, new ArrayList<>()));
        // 1 get routes
        while (true) {
            if (!checkContainId(originNodes, next.val)) {
                originNodes.add(next);
            }
            // 1.1 save new route
            Node nextNeighbor = null;
            for (Node neighbor : next.neighbors) {
                Route tempRoute = new Route(next.val, neighbor.val);
                if (!routes.contains(tempRoute)) {
                    routes.add(tempRoute);
                    nextNeighbor = neighbor;
                    break;
                }
            }

            // 1.2 no new route, pop
            if (nextNeighbor == null) {
                visitedNode.pop();
                if (visitedNode.empty()) {
                    break;
                }
                next = visitedNode.peek();
                continue;
            }
            // 1.3 add next node to stack
            if (!checkContainId(visitedNode, nextNeighbor.val)) {
                visitedNode.push(nextNeighbor);
                next = nextNeighbor;
            } else {
                visitedNode.pop();
                if (visitedNode.empty()) {
                    break;
                }
                next = visitedNode.peek();
            }
        }
        // 2 reconstruct graph
        // 2.1 check all node val
        for (Node origin : originNodes) {
            if (!checkContainId(cloneNodes, origin.val)) {
                cloneNodes.add(new Node(origin.val, new ArrayList<>()));
            }
        }
        for (int i = 0; i < originNodes.size(); i++) {
            for (Node originNeighbor : originNodes.get(i).neighbors) {
                cloneNodes.get(i).neighbors.add(findNode(cloneNodes, originNeighbor.val));
            }
        }
//        for (Route r: routes) {
//            if (!checkContainId(cloneNodes, r.nodeIDA)) {
//                cloneNodes.add(new Node(r.nodeIDA, new ArrayList<>()));
//            }
//            if (!checkContainId(cloneNodes, r.nodeIDB)) {
//                cloneNodes.add(new Node(r.nodeIDB, new ArrayList<>()));
//            }
//        }
//        for (Route r: routes) {
//
//            Node nodeA = findNode(cloneNodes, r.nodeIDA);
//            Node nodeB = findNode(cloneNodes, r.nodeIDB);
//            nodeA.neighbors.add(nodeB);
//            nodeB.neighbors.add(nodeA);
//        }
        return findNode(cloneNodes, node.val);
    }
}

public class Main {

    public static void main(String[] args) {
//        Node node1 = new Node(1, new ArrayList<>());
//        Node node2 = new Node(2, new ArrayList<>());
//        Node node3 = new Node(3, new ArrayList<>());
//        Node node4 = new Node(4, new ArrayList<>());
//        node1.neighbors.add(node2);
//        node1.neighbors.add(node4);
//        node2.neighbors.add(node1);
//        node2.neighbors.add(node3);
//        node3.neighbors.add(node2);
//        node3.neighbors.add(node4);
//        node4.neighbors.add(node1);
//        node4.neighbors.add(node3);
        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node3.neighbors.add(node1);
        Solution s = new Solution();
        Node n = s.cloneGraph(node1);
        System.out.println("Hello World!");
    }
}
