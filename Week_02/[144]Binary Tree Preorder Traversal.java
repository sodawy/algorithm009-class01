import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreePreOrderTraversal {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                ret.add(root.val);
                stack.push(root.right);
                root = root.left;
            } else {
                root = stack.pop();
            }
        }

        return ret;
    }
}