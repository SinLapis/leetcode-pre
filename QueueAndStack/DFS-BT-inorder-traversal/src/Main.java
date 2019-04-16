import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    // 递归
    private void findNextByRecursion(TreeNode root, List<Integer> intList) {
        if (root.left != null) {
            findNextByRecursion(root.left, intList);
        }
        intList.add(root.val);
        if (root.right != null) {
            findNextByRecursion(root.right, intList);
        }
    }

    // 迭代
    private void findNextByIteration(TreeNode root, List<Integer> intList) {
        Stack<TreeNode> treeNodes = new Stack<>();
        List<TreeNode> visitedNode = new ArrayList<>();
        treeNodes.push(root);
        TreeNode next;
        while (!treeNodes.isEmpty()) {
            next = treeNodes.peek();
            if (next.left != null && !visitedNode.contains(next.left)) {
                // 左孩子不为空且未遍历
                treeNodes.push(next.left);
                continue;
            } else if (!visitedNode.contains(next)) {
                intList.add(next.val);
                visitedNode.add(next);
            }
            if (next.right != null && !visitedNode.contains(next.right)) {
                // 右孩子不为空且未遍历
                treeNodes.push(next.right);
            } else {
                // 右孩子为空或已遍历
                treeNodes.pop();
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> intList = new ArrayList<>();
        if (root == null)
            return intList;
        findNextByIteration(root, intList);
        return intList;
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n0.right = n1;
        n1.left = n2;
        Solution s = new Solution();
        System.out.println(s.inorderTraversal(n0));
    }
}