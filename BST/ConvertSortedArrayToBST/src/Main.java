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
    void construct(int[] nums, int start, int end, TreeNode parent, boolean isLeft) {
        if (end < start) return;
        int mid = start + (end - start >> 1);
        TreeNode t = new TreeNode(nums[mid]);
        if (isLeft) {
            parent.left = t;
        } else {
            parent.right = t;
        }
        construct(nums,start, mid - 1, t, true);
        construct(nums, mid + 1, end, t, false);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int start = 0, end = nums.length - 1;
        int mid = end >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        construct(nums, start, mid - 1, root, true);
        construct(nums, mid + 1, end, root, false);
        return root;
    }
}