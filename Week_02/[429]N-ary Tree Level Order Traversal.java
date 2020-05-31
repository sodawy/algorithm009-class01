import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class NaryTreeLevelOrderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();

        if (root == null) {
            return ret;
        }

        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                list.add(node.val);
                for (Node child : node.children) {
                    queue.offer(child);
                }
            }
            ret.add(list);
        }


        return ret;

    }
}