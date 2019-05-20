import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class TreeNodePlus {
    TreeNode t;
    int level;

    public TreeNodePlus(TreeNode t, int level) {
        this.t = t;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNodePlus> queue = new LinkedList<>();
        queue.add(new TreeNodePlus(root, 0));
        TreeNodePlus next;
        while (!queue.isEmpty()) {
            next = queue.poll();
            if (next.level == result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(next.level).add(next.t.val);
            if (next.t.left != null) {
                queue.add(new TreeNodePlus(next.t.left, next.level + 1));
            }
            if (next.t.right != null) {
                queue.add(new TreeNodePlus(next.t.right, next.level + 1));
            }
        }
        return result;
    }
}
