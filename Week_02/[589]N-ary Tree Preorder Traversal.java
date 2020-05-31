
import java.util.ArrayList;
import java.util.List;

class NaryPreOrderTraversal{
    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        ret.add(root.val);
        for(Node node: root.children){
            ret.addAll(preorder(node));
        }
        return ret;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}