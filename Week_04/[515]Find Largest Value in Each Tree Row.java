import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class FindLargestValueInEachTreeRow {
    public static class TreeNode {
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


    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            ret.add(Integer.MIN_VALUE);
            int len = queue.size();
            int max = ret.get(level);
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                //compare and update max_value
                if (node.val > max) {
                    max = node.val;
                    ret.set(level, node.val);
                }
                //add child to queue
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            level++;
        }

        return ret;
    }

    public static void main(String[] args) {
        FindLargestValueInEachTreeRow findLargestValueInEachTreeRow = new FindLargestValueInEachTreeRow();
        TreeNode root = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        root.left = node3;
        root.right = node2;

        TreeNode node5 = new TreeNode(5);
        node3.left = node5;


        TreeNode node33 = new TreeNode(3);

        node3.right = node33;


        TreeNode node9 = new TreeNode(9);
        node2.right = node9;


        List<Integer> integers = findLargestValueInEachTreeRow.largestValues(root);
        for (Integer i : integers) {
            System.out.println(i);
        }
    }
}