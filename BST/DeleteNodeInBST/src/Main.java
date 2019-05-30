public class Main {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        Solution s = new Solution();
        System.out.println(s.deleteNode(n1, 5));
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
    void replaceWithRightestNode(TreeNode deleteNode) {
        TreeNode alterNodeParent = deleteNode;
        TreeNode t = deleteNode.left;
        while (t.right != null) {
            alterNodeParent = t;
            t = t.right;
        }
        TreeNode alterNode = alterNodeParent.right;
        deleteNode.val = alterNode.val;
        alterNodeParent.right = alterNode.left;
    }

    void replaceWithLeftestNode(TreeNode deleteNode) {
        TreeNode alterNodeParent = deleteNode;
        TreeNode t = deleteNode.right;
        while (t.left != null) {
            alterNodeParent = t;
            t = t.left;
        }
        TreeNode alterNode = alterNodeParent.left;
        deleteNode.val = alterNode.val;
        alterNodeParent.left = alterNode.right;
    }

    TreeNode find(TreeNode root, int val) {
        TreeNode next = root;
        while (next != null) {
            if (next.val == val) return next;
            if (val < next.val) {
                next = next.left;
            } else next = next.right;
        }
        return null;
    }

    TreeNode findParent(TreeNode root, int val) {
        TreeNode next = root;
        while (next != null) {
            if (val < next.val) {
                if (next.left != null && val == next.left.val) return next;
                next = next.left;
            } else {
                if (next.right != null && val == next.right.val) return next;
                next = next.right;
            }
        }
        return null;
    }

    TreeNode deleteRoot(TreeNode root) {
        if (root.right == null) {
            if (root.left == null) return null;
            else return root.left;
        }
        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        } else replaceWithLeftestNode(root);
        return root;
    }

    TreeNode deleteChild(TreeNode root, TreeNode deleteNode) {
        TreeNode parent = findParent(root, deleteNode.val);
        // 没有子节点
        if (deleteNode.left == null && deleteNode.right == null) {
            if (parent.left == deleteNode) parent.left = null;
            else if (parent.right == deleteNode) parent.right = null;
        } else if (deleteNode.left == null) {
            if (parent.left == deleteNode) {
                parent.left = deleteNode.right;
            } else if (parent.right == deleteNode) {
                parent.right = deleteNode.right;
            }
        } else if (deleteNode.right == null) {
            if (parent.left == deleteNode) {
                parent.left = deleteNode.left;
            } else if (parent.right == deleteNode) {
                parent.right = deleteNode.left;
            }
        } else {
            if (deleteNode.right.left == null) {
                deleteNode.right.left = deleteNode.left;
                if (parent.left == deleteNode) parent.left = deleteNode.right;
                else parent.right = deleteNode.right;
            } else {
                if (parent.left == deleteNode) replaceWithRightestNode(deleteNode);
                else replaceWithLeftestNode(deleteNode);
            }
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode deleteNode = find(root, key);
        if (deleteNode == null) return root;
        if (deleteNode == root) return deleteRoot(root);
        else return deleteChild(root, deleteNode);
    }
}

