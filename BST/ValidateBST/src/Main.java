public class Main {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(20);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        Solution s = new Solution();
        System.out.println(s.isValidBST(n1));
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
    boolean verify(TreeNode t, long start, long end) {
        if (t == null) {
            return true;
        } else if (t.val >= end || t.val <= start) {
            return false;
        } else if (t.left == null && t.right == null) {
            return true;
        } else {
            boolean leftFlag = true, rightFlag = true;
            if (t.left != null) {
                leftFlag = t.val > t.left.val;
            }
            if (t.right != null) {
                rightFlag = t.val < t.right.val;
            }
            if (leftFlag && rightFlag) {
                return verify(t.left, start, t.val) && verify(t.right, t.val, end);
            } else {
                return false;
            }
        }
    }

    public boolean isValidBST(TreeNode root) {
        return verify(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
