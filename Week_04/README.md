学习笔记


[Leetcode 126] Word Ladder
1. bfs breath find search, level traverse
2. dfs, backtrack

[Leetcode 126] Word Ladder II
pruning notes：
1. `bfs` first， get two critical things:
    1.1 min steps of solve
    1.2 each step-th of string in the min path
2. `dfs` use the result from `bfs`
    1. if the path already greater than min_step_from_bfs(1.1), break;
    2. we reversely find startStr from endStr, and using the each-th of string from base(1.2)
3. build neighbor map time-complexity improve:
    - if two for loop, O(n^2), we use `a-z` & `set.contains`, -> O(25*N) -> O(N)  