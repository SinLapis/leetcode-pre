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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode next = root;
        while (next != null) {
            if (next.val == val) return next;
            if (val < next.val)  next = next.left;
            else next = next.right;
        }
        return null;
    }
}