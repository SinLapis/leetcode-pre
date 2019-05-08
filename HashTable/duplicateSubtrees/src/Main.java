
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;
        Solution s = new Solution();
        s.findDuplicateSubtrees(t0);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int hashTree(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        TreeNode next;
        while (!queue.isEmpty()) {
            next = queue.poll();
            if (next == null) {
                sb.append('x');
                sb.append('.');
                continue;
            }
            queue.add(next.left);
            queue.add(next.right);
            sb.append(next.val);
            sb.append('.');
        }
        return sb.toString().hashCode();
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        HashMap<Integer, TreeNode> struct = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode next;
        while (!queue.isEmpty()) {
            next = queue.poll();
            int hash = hashTree(next);
            count.put(hash, count.getOrDefault(hash, 0) + 1);
            struct.put(hash, next);
            if (next.left != null) {
                queue.add(next.left);
            }
            if (next.right != null) {
                queue.add(next.right);
            }
        }
        List<TreeNode> result = new ArrayList<>();
        for (int hash: count.keySet()) {
            if (count.get(hash) >= 2) {
                result.add(struct.get(hash));
            }
        }
        return result;
    }
}