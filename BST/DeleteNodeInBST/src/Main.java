public class Main {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        Solution s = new Solution();
        System.out.println(s.deleteNode(n1, 2));
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
    TreeNode findLeftestNode(TreeNode parent) {
        TreeNode t = parent.left;
        if (t == null) return null;
        while (t.left != null) {
            parent = t;
            t = t.left;
        }
        return parent;
    }

    void deleteNochild(TreeNode parent, boolean isLeft) {
        if (isLeft) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    }

    void deleteOneChild(TreeNode parent, boolean parentLeft, boolean childLeft) {
        if (parentLeft) {
            if (childLeft) parent.left = parent.left.left;
            else parent.left = parent.left.right;
        } else {
            if (childLeft) parent.right = parent.right.left;
            else parent.right = parent.right.right;
        }
    }

    void deleteTwoChild(TreeNode parent, boolean isLeft) {
        TreeNode current;
        if (isLeft) current = parent.left;
        else current = parent.right;
        TreeNode leftestParent = findLeftestNode(current.right);
        if (leftestParent == null) {
            current.right.left = current.left;
            if (isLeft) parent.left = current.right;
            else parent.right = current.right;
            return;
        }
        if (isLeft) parent.left = leftestParent.left;
        else parent.right = leftestParent.left;
        leftestParent.left.left = current.left;
        leftestParent.left.right = current.right;
        leftestParent.left = null;
    }

    TreeNode find(TreeNode root, int val) {
        TreeNode next = root;
        TreeNode parent = null;
        while (next != null) {
            if (next.val == val) return parent;
            parent = next;
            if (val < next.val) {
                next = next.left;
            } else next = next.right;
        }
        return null;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode leftestParent = findLeftestNode(root);
            leftestParent.left.left = root.left;
            leftestParent.left.right = root.right;
            TreeNode newRoot = leftestParent.left;
            leftestParent.left = null;
            return newRoot;
        }
        TreeNode deleteParent = find(root, key);
        if (deleteParent == null) return root;
        boolean isLeft = key < deleteParent.val;
        int childNum = 0;
        TreeNode deleteNode;
        if (isLeft) {
            deleteNode = deleteParent.left;
        } else {
            deleteNode = deleteParent.right;
        }
        boolean childLeft = false;
        if (deleteNode.left != null) {
            childNum++;
            childLeft = true;
        }
        if (deleteNode.right != null) {
            childNum++;
            childLeft = false;
        }
        switch (childNum) {
            case 0:
                deleteNochild(deleteParent, isLeft);
                break;
            case 1:
                deleteOneChild(deleteParent, isLeft, childLeft);
                break;
            case 2:
                deleteTwoChild(deleteParent, isLeft);
        }
        return root;
    }
}

