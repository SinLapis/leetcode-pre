public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.buildTree(new int[]{2,1,4,3,5}, new int[]{2,4,5,3,1}));
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
            int[] postOrder,
            int postBegin,
            int postEnd
    ) {
        TreeNode t = new TreeNode(postOrder[postEnd]);
        int mid = findIndex(inOrder, t.val);
        if (mid > inBegin)
            t.left = build(inOrder, inBegin, mid - 1, postOrder, postBegin, postBegin + mid - 1 - inBegin);
        if (mid < inEnd)
            t.right = build(inOrder, mid + 1, inEnd, postOrder, postBegin + mid - inBegin, postEnd - 1);
        return t;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
}


