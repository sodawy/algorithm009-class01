import java.util.HashMap;
import java.util.PriorityQueue;

class LRUCache {
    class DLinkNode{
        int key;
        int value;
        DLinkNode pre;
        DLinkNode next;
    }

    HashMap<Integer, DLinkNode> cache;
    int cap;
    int size;
    DLinkNode head;
    DLinkNode tail;

    LRUCache(int capacity){
        this.cache = new HashMap<>();
        this.size = 0;
        this.cap = capacity;

        this.head = new DLinkNode();
        this.tail = new DLinkNode();

        this.head.next = this.tail;
        this.head.pre = null;
        this.tail.next = null;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            DLinkNode node = cache.get(key);
            moveToHead(node);
            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            //update value
            DLinkNode node = cache.get(key);
            node.value = value;
            //move to head
            moveToHead(node);
        }else{
            DLinkNode node = new DLinkNode();
            node.value = value;
            node.key = key;

            cache.put(key, node);
            this.addNode(node);
            this.size++;

            if(size > cap){
                DLinkNode lastNode = tail.pre;
                removeNode(lastNode);
                cache.remove(lastNode);
                this.size--;
            }
        }
    }

    private void moveToHead(DLinkNode node){
        removeNode(node);
        addNode(node);
    }

    private void addNode(DLinkNode node){
        node.next = head.next;
        node.pre = head;

        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */