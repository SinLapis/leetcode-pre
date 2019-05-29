import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

class BSTIterator {
    List<Integer> l;
    int i;

    void traverse(TreeNode node, List<Integer> l) {
        if (node.left != null) traverse(node.left, l);
        l.add(node.val);
        if (node.right != null) traverse(node.right, l);
    }

    public BSTIterator(TreeNode root) {
        l = new ArrayList<>();
        i = 0;
        if (root == null) return;
        traverse(root, l);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return l.get(i++);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return i < l.size();
    }
}
