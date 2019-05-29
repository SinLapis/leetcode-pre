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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode next = root;
        while (true) {
            if (next.val == val) return root;
            if (val < next.val) {
                if (next.left == null) {
                    next.left = new TreeNode(val);
                    return root;
                } else {
                    next = next.left;
                    continue;
                }
            }
            if (next.right == null) {
                next.right = new TreeNode(val);
                return root;
            }
            next = next.right;
        }
    }
}