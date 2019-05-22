public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.buildTree(new int[]{2,1,4,3,5}, new int[]{1,2,3,4,5}));
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
    int findIndex(int[] a, int t) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == t) return i;
        }
        return -1;
    }
    TreeNode build(
            int[] inOrder,
            int inBegin,
            int inEnd,
            int[] preOrder,
            int preBegin
    ) {
        TreeNode t = new TreeNode(preOrder[preBegin]);
        int mid = findIndex(inOrder, t.val);
        if (mid > inBegin)
            t.left = build(inOrder, inBegin, mid - 1, preOrder, preBegin + 1);
        if (mid < inEnd)
            t.right = build(inOrder, mid + 1, inEnd, preOrder, preBegin + mid + 1 - inBegin);
        return t;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) return null;
        return build(inorder, 0, inorder.length - 1, preorder, 0);
    }
}
