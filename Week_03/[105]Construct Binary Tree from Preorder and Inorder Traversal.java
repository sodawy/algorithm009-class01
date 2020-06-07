import java.util.HashMap;
import java.util.Map;

class ConstructBinaryTreeFromPreorderAndInorder {

    public class TreeNode {
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


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) return null;

        Map<Integer, Integer> map = new HashMap<>();
        int pLen = preorder.length;
        int iLen = inorder.length;

        for (int i = 0; i < iLen; i++) {
            map.put(inorder[i], i);
        }


        return _builder(preorder, inorder, map, 0, pLen - 1, 0, iLen - 1);
    }

    private TreeNode _builder(int[] preorder, int[] inorder, Map<Integer, Integer> map, int pL, int pR, int iL, int iR) {
        if (pL > pR) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pL]);

        int index = map.get(root.val);
        int leftLen = index - 1 - iL;

        root.left = _builder(preorder, inorder, map, pL + 1, pL + 1 + leftLen, iL, index - 1);
        root.right = _builder(preorder, inorder, map, pL + 2 + leftLen, pR, index + 1, iR);

        return root;
    }
}