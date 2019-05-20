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
    int findIndex(int[] a, int t) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == t) return i;
        }
        return -1;
    }

    int findMaxIndex(int[] base, int[] targets, int begin, int end) {
        int maxIndex = end, max = -1, temp;
        for (int i = begin; i <= end; i++) {
            temp = findIndex(base, targets[i]);
            if (temp > max) {
                max = temp;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    void build(
            int[] inOrder,
            int inBegin,
            int inEnd,
            int[] postOrder,
            TreeNode parent
    ) {
        int parentIndex = findIndex(inOrder, parent.val);
        // left
        if (parentIndex > inBegin) {
            int inLeftEnd = parentIndex - 1;
            int maxIndex = findMaxIndex(postOrder, inOrder, inBegin, inLeftEnd);
            parent.left = new TreeNode(inOrder[maxIndex]);
            build(inOrder, inBegin, inLeftEnd, postOrder, parent.left);
        }
        // right
        TreeNode right;
        if (parentIndex < inEnd) {
            int inRightBegin = parentIndex + 1;
            int maxIndex = findMaxIndex(postOrder, inOrder, inRightBegin, inEnd);
            parent.right = new TreeNode(inOrder[maxIndex]);
            build(inOrder, inRightBegin, inEnd, postOrder, parent.right);
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        build(inorder, 0, inorder.length - 1, postorder, root);
        return root;
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
            t.right = build(inOrder, mid + 1, inEnd, postOrder, postBegin + mid - inBegin, postEnd);
        return t;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
}


