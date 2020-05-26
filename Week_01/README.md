# 学习笔记


## 解题思路
1. 将复杂文件拆分简化，寻找重复子逻辑或结构，因为计算机支持的朴素逻辑即是 `if-else` `loop` `recursion`
2. 如果没有头绪，可以先从暴力求解开始，一定程度帮助理清问题。然后在考虑，哪些其中的哪些loop可以用更优的数据结构或技巧优化复杂度。

## 常用模板代码
1. 双层loop:
    ```java```
    for (int i = 0; i < arrays.length - 1; i++) {
        for (int j = i + 1; j < arrays.length; j ++) {
        
        }
    }
    ```
2. 两侧夹逼(squeeze)
    - 通常可降低一级复杂度
    - 优化：判断并跳过重复元素，可加速运行
    - 通常需要考虑是否有序
3. 链表的快慢指针(walker/runner)，判断是否有环
4. 单调(monotonous)栈。兼顾输入信息的位置和值大小。
5. 单调队列。

## 数据结构
### Array
- time complexity
    - access O(1)
    - insert O(n)
    - delete O(n) 
- note
    - insert or delete might cause lots of `System.arraycopy`
    - need contiguous memory space

### LinkedList
- time complexity
    - access O(n)
    - insert O(1)
    - delete O(1)

#### SkipedList
- time complexity
    - access O(logn)
    - insert O(logn)
    - delete O(1ogn)
- note
    - usually implement by OrderedLinkedList with IndexDict to speed up search
    - however, we need update IndexDict when insert/delete raw data 

### Stack
- time complexity
    - access O(n)
    - insert O(n)
    - delete O(n)
- note
    - 洋葱模型，从外到内，一层一层，包含最近相关性
    - `peek`, `pop`, `push`, `empty`

### Queue
- time complexity 
    - access O(n)
    - insert O(n)
    - delete O(n)
- note
    - 遵从先来后到
    - (Java) `Interface Queue<E>`
- 
|Throws|exception|Returns special value|
|---|---|---|
|Insert|`add(e)`|`offer(e)`|
|Remove|`remove()`|`poll()`|
|Examine|`element()`|`peek()`|

#### Deque
- note
    - You can insert or remove both on head and tail
    - (Java) `Interface Deque<E>`, Implements Classes: `ArrayDeque`, `LinkedBlockingQeueu`, `LinkedList` 
#### PriorityQueue 
- note
    - > An unbounded priority queue based on a priority heap. The elements of the priority queue are ordered according to their natural ordering, or by a Comparator provided at queue construction time, depending on which constructor is used.


### 本周棘手难题
84. Largest Rectangle in Histogram
    1. 暴力解法比较好理解，朴素好想的O(n^3)三次循环(遍历左柱，遍历右柱，遍历左右柱间的最小高)，以及对其优化的后的两次循环(借用上一次的最小高，省一次遍历)
    2. 不好理解的借助单调栈O(n)的解法:
        1. 问题的全局最大面积 = Math.max(子问题的最大面积), 子问题：以每个柱为矩形高的最大矩形的
        2. 子问题拆解：面积 = 柱i高度 * i最大面积时的左柱和右柱，此时问题转移成，如何确定i柱为高时且面积为最大时的左右柱？
        3. 取i柱高度为此子问题矩形面积的高，即i为解范围中的最低柱，所以左右两侧第一个低于i柱的就是解的边界。2.2的问题答案为：以i为中心，其左侧第一个小于他的即为左边界柱，其右侧第一个小于他的即为右边界柱。理解为什么时，需要借助实例动笔画下。
        4. 至此，选用单调栈也就很好理解了。其同时兼顾了次序和入栈顺序，以保证与入栈元素的位置最近
        5. 实现的时候，外层for循环控制遍历2.1的子问题，不断出栈的过程通过控制for中的i游标完成。
        ```java
        //ask from reply of `cx4ued`, link is https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/Short-and-Clean-O(n)-stack-based-JAVA-solution   
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= len;) {
            int h = (i == len ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            }else {
                int curHeight = heights[stack.pop()];
                int rightBoundary = i - 1;
                int leftBoundary = stack.isEmpty() ? 0 : stack.peek() + 1;
                int width = rightBoundary - leftBoundary + 1;
                maxArea = Math.max(maxArea, (curHeight * width));
            }
        }
        return maxArea;
    }
        ```
                                           
