import java.util.ArrayList;
import java.util.List;

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

class Solution {
    boolean findPreOrder(TreeNode t, int target, List<TreeNode> route) {
        if (t == null) return false;
        route.add(t);
        if (t.val == target) return true;
        if (findPreOrder(t.left, target, route)) return true;
        if (findPreOrder(t.right, target, route)) return true;
        route.remove(route.size() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pRoute = new ArrayList<>();
        List<TreeNode> qRoute = new ArrayList<>();
        findPreOrder(root, p.val, pRoute);
        findPreOrder(root, q.val, qRoute);
        int limit = Math.min(pRoute.size(), qRoute.size());
        for (int i = 0; i < limit; i++) {
            if (pRoute.get(i).val != qRoute.get(i).val) return pRoute.get(i - 1);
        }
        return pRoute.get(limit - 1);
    }
}