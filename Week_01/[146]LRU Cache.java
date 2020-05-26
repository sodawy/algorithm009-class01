package Week_01;//Design and implement a data structure for Least Recently Used (LRU) cache. It
//should support the following operations: get and put. 
//
// get(key) - Get the value (will always be positive) of the key if the key exis
//ts in the cache, otherwise return -1. 
//put(key, value) - Set or insert the value if the key is not already present. W
//hen the cache reached its capacity, it should invalidate the least recently used
// item before inserting a new item. 
//
// The cache is initialized with a positive capacity. 
//
// Follow up: 
//Could you do both operations in O(1) time complexity? 
//
// Example: 
//
// 
//LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4
// 
//
// 
// Related Topics Design

import java.util.HashMap;
import java.util.LinkedList;

class Node {
    Node pre;
    Node next;
    int key;
    int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    private LinkedList list;
    HashMap<Integer, Node> hashMap;
    Node head;
    Node tail;
    int currentCount = 0;
    int capacity;

    private void moveToHead(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        node.next = head.next;
        node.pre = head;

        head.next.pre = node;
        head.next = node;
    }

    private void addAfterHead(Node node) {
        head.next.pre = node;
        node.next = head.next;

        node.pre = head;
        head.next = node;
    }

    private Node removeTail() {
        Node removedNode = tail.pre;

        removedNode.pre.next = tail;
        tail.pre = removedNode.pre;

        removedNode.pre = null;
        removedNode.next = null;

        return removedNode;
    }

    public LRUCache(int capacity) {
        this.list = new LinkedList();
        this.hashMap = new HashMap<>();
        this.capacity = capacity;

        head = new Node(-1, -1);
        head.pre = null;

        tail = new Node(-1, -1);
        tail.next = null;

        head.next = tail;
        tail.pre = head;

    }

    public int get(int key) {
        //check map
        Node o = hashMap.get(key);
        if (o != null) {
            //move o to head
            moveToHead(o);

            return o.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node o = hashMap.get(key);
        if (o != null) {
            //update
            o.value = value;

            //move o to head
            moveToHead(o);
        } else {
            Node newNode = new Node(key, value);

            //add o to list head
            addAfterHead(newNode);

            //add o to hashmap
            hashMap.put(key, newNode);

            currentCount++;

            //check is over capacity
            if (currentCount > capacity) {
                Node removedNode = removeTail();
                hashMap.remove(removedNode.key);
            }

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
