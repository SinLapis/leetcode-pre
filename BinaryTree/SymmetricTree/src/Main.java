import java.util.*;

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

class Solution1 {
    boolean compare(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        } else {
            if (right == null) return false;
            else {
                if (left.val != right.val) return false;
                return compare(left.left, right.right) && compare(left.right, right.left);
            }
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }
}
