# 学习笔记

## Hash
### hash function
 - hashFunction(key) -> index of array table
 
### hash collision
 - improve hash function
 - save elements in same index by LinkedList, access time complexity from O(1) -> O(n)

### Implements in JAVA
#### HashSet
 - Implement `Set` interface, backed by a hashMap instance, key is what you set, value is a dummy object
 - not guarantee order
 - allow set null
 - `add(o)` `contains(o)` `clear()` `isEmpty()` `size()` `remove(o)`
#### HashMap (jdk12)
 - hash function:
    ```java
    static final int hash(Object key) {
        int h;
        //distrubing function to care high and low order position bits
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16); 
    }
    ```
 - capacity, length of table, must be pow of two(so that we can improve % to by from `table[hash % n]` by `table[(n-1) & hash]` )
 - loadFactor, if current size is bigger than capacity*loadFactor will `resize`
 - support null key and null value, but not thread-safe
 - get/put/remove
    1. get index of table by hash(key), if ret is not null, return else 2
    2. update value or tree or LinkedList
    3. if size of LinkedList > 8, LinkedList change to Tree. O(1) -> O(n) -> O(logN)
 - [reference reading](https://juejin.im/post/5c8f461c5188252da90125ba)

## Tree
 - two-dimension data structure
 - **dimension raise** to solve or improve more situations, like a LinkedNode have one more next pointers
 - The difference to Graph is that there is no cycle in Tree
 - So: `Graph` is a special `Tree` which has cycle, `Tree` is a special `LinkedLists` which has one more next pointer. 
### Binary Tree
 - traverse( O(n) ): `pre-order`: root->left->right; `in-order`: left->root->right; `post-order`: left->right->root 
### Binary Search Tree (Sorted Binary Tree, Ordered Binary Tree)
 - left < root < right, So, the result of in-order traverse, is monotonous increased.
 - CAUTION: we should traverse **all childNode** is leftChildTree, but not only leftChildNode.
 - Basically functions: add, insert, delete, time complexity O(logN). The worst situation is degeneratd to LinkedList O(n)
 - Remove Node
    - leef node: remove directly
    - root or root of left(right)-tree: replace by the closet bigger Node, and recursion heal the broken tree
    
## Heap
 - Generally, when we say `Heap` is algorithm context, we say max-heap or min-heap, which mean we can get max(min) value by O(1);
 - There are lots of implements of max(min) heap, the best performance is `strict-fibonacci`(not only getMax-O(1), but also insertMax-O(1), deleteMax-O(1))
 - A trade-off here between performance and implement complexity, we talk and use `binary-heap` more usually
 - `Binary-Heap`
    - full-fill-tree:except leef nodes, all nodes have two children
    - parent is larger than its children
    - we can implement it by `array` backed.
    - getMax(), return the root value
    - insert(), append new node to tail, then `heapityUp`
    - delete(), move the last node to the node which is deleted, than `heapifyDown` (the last one)
    - if it backed by array, `leftChild` of `item[i]` is `2*i+1`, `rightChild` is `2*i+2`, `parent` is `Math.floor((i-1)/2)`       


 


    
     
  
  
 