import java.util.HashMap;
import java.util.Map;

class LFUCache {
    class DLinkedNode {
        int key, value, freq;
        DLinkedNode prev, next;

        DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLinkedList {
        DLinkedNode head;
        DLinkedNode tail;
        int size;

        DLinkedList() {
            this.size = 0;
            this.head = new DLinkedNode(0, 0);
            this.tail = new DLinkedNode(0, 0);
            this.head.next = this.tail;
            this.head.prev = null;
            this.tail.prev = this.head;
            this.tail.next = null;
        }

        void remove(DLinkedNode node) {
            DLinkedNode next = node.next;
            DLinkedNode prev = node.prev;
            prev.next = next;
            next.prev = prev;
            node.next = null;
            node.prev = null;
            this.size--;
        }

        void addToHead(DLinkedNode node) {
            DLinkedNode next = this.head.next;

            node.next = next;
            next.prev = node;
            this.head.next = node;
            node.prev = this.head;

            this.size++;
        }

        DLinkedNode removeLast() {
            DLinkedNode last = this.tail.prev;
            this.remove(last);
            return last;
        }
    }

    int capacity;
    int size;
    int minFreq;
    Map<Integer, DLinkedNode> nodeMap;
    Map<Integer, DLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        this.nodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (this.nodeMap.containsKey(key)) {
            DLinkedNode node = this.nodeMap.get(key);
            updateNodeFreq(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

//        System.out.println("put" + key);
        if (this.nodeMap.containsKey(key)) {
            DLinkedNode node = this.nodeMap.get(key);
            node.value = value;
            updateNodeFreq(node);
        } else {
            if (this.size == this.capacity) {
                //evicts
                DLinkedList minList = this.freqMap.get(this.minFreq);
                DLinkedNode removedNode = minList.removeLast();

//                System.out.println("remove " + removedNode.key + " ");

                this.nodeMap.remove(removedNode.key);
                this.size--;
            }

            DLinkedNode newNode = new DLinkedNode(key, value);
            DLinkedList list = freqMap.getOrDefault(1, new DLinkedList());
            list.addToHead(newNode);

            this.freqMap.put(1, list);
            this.nodeMap.put(key, newNode);

            this.size++;
            this.minFreq = 1;

        }
    }

    private void updateNodeFreq(DLinkedNode node) {
//        System.out.println("update " + node.key);
        //remove node from old list
        DLinkedList oldList = freqMap.get(node.freq);
        oldList.remove(node);

        if(this.minFreq == node.freq && oldList.size == 0){
            this.minFreq++;
        }

        node.freq++;

        //add node to new list
        DLinkedList newList = freqMap.getOrDefault(node.freq, new DLinkedList());
        newList.addToHead(node);
        freqMap.put(node.freq, newList);

    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}