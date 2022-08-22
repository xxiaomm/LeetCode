
- [数据结构](#数据结构)
- [常用算法及思想](#常用算法及思想)
- [不常考但推荐会的算法or数据结构](#不常考但推荐会的算法or数据结构)
- [OOD](#ood)
- [Tag 频率](#tag-频率)
- [Reference](#reference)


## 数据结构

- LinkedList: 必会 遍历 / 反转 / 找中点 / 判断cycle，slow/fast pointer, 推荐题：[LC 2130](https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/)
- Queue: poll(), offer(), peek()等操作，并知道其时间复杂度，常与BFS联合考察，BFS的space complexity往往由queue的size决定, 想一想为什么有时候BFS在从queue中poll一个元素前，会先记录下当前queue的size，而有时候却不用？) 
- Stack/Deque: 基础的操作一定要会，***Monotonic Stack*** 一定要会，也常和Tree一起联合考察，即 Iterative way pre-order and in-order traversal）推荐题：[LC 239](https://leetcode.com/problems/sliding-window-maximum/)（ 请务必弄清楚理解为什么时间复杂度是O(n)而不是O(n^2), [LC 496](https://leetcode.com/problems/next-greater-element-i/), [LC 20](https://leetcode.com/problems/valid-parentheses/), [LC 155](https://leetcode.com/problems/min-stack/), [LC 772](https://leetcode.com/problems/basic-calculator-iii/)
- Heap/PriorityQueue （请务必知道，如何根据特定规则定义PriorityQueue的排列顺序，了解offer, poll, peak的时间复杂度，请自己尝试实现一个heap，也常与Dijkstra一起联用）推荐题: [LC 23](https://leetcode.com/problems/merge-k-sorted-lists/), [LC 973](https://leetcode.com/problems/k-closest-points-to-origin/), [LC 295](https://leetcode.com/problems/find-median-from-data-stream/)
- Set/Map/TreeSet/TreeMap （请务必了解四种数据结构常用操作的时间复杂度，请尝试自己实现一个HashMap，了解一下 ***hash collision***(经常问到), 请务必了解如何重写一个自定义classs的hashCode()与equals()以及二者的关系）推荐题: [LC 2158(TreeMap)](https://leetcode.com/problems/amount-of-new-area-painted-each-day/), [LC 560(HashMap)](https://leetcode.com/problems/subarray-sum-equals-k/)
- Graph: BFS / DFS / Dijkstra / cycle 检测(拓扑), 请务必熟练掌握这三种算法，非常非常非常重要！要会分析每一种的时间空间复杂度;【 [labuladong讲解](https://labuladong.github.io/algo/2/22/51/) 】推荐题: [LC 317](https://leetcode.com/problems/shortest-distance-from-all-buildings/)
- Tree: 一般常与Recursion联用，注意 average case / worst case的不同，注意Binary Search Tree的特性; 推荐题: [LC 545](https://leetcode.com/problems/boundary-of-binary-tree/) and so many questions



## 常用算法及思想

- Binary Search: 常见模板一定要烂熟于心，常与一个O(n)的check function联用，从而得到一个O(nlogn)的套路解法）推荐题: [LC 875](https://leetcode.com/problems/koko-eating-bananas/) （必做，你做了这套题，等于多会了10道题！）
- Sliding Window: 必会，不难）推荐题: [LC 3](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
- Two pointers: 必会，不难，常与sorting联用; 推荐题: [LC 15](https://leetcode.com/problems/3sum/)
- Prefix Sum: 必会; 推荐题: [LC 528](https://leetcode.com/problems/random-pick-with-weight/)（很有趣一题）
- Sorting (Merge Sort, Quick Sort, Bucket Sort)  -> 这里稍微改动一下就是quick select是很多Kth题的最优解，average time O(n)，那问题来了，worst time是多少呢？ 推荐题目：347 （很巧妙的bucket sort）
- Topologic sort: 必会，经典题[course schedule](https://leetcode.com/problems/course-schedule/), 以及最近谷歌常考的食谱的那道题;
- Union Find （我觉得最好会，不是很难，我推荐跟古城算法的视频学一下[古城算法](https://www.youtube.com/c/%E5%8F%A4%E5%9F%8E%E7%AE%97%E6%B3%95/playlists?app=desktop), 城主yyds，注意听听城主对其时间/空间复杂度的分析）推荐题: [LC 2092](https://leetcode.com/problems/find-all-people-with-secret/)（也是很有意思的一道题）

- BFS/DFS/Dijkstra 我再强调一遍哥仨的重要性！
- Greedy: 这个真的有时候比较难想，难的点在于如何证明其正确性！
- DP: ***经典DP一定要会！*** 我到现在也不是很会DP，在这里抛砖引玉一下，但是目前我的看法是，第一步一定要想清楚你dp的物理意义，第二步一定要定义好你的induction rule！一般一道题，你可以先从brute force DFS（recursion）的方法开始，优化到DFS + MEMO（这还挺常见的）, 如果能再优化到iterative dp更好, 如果准备时间不多，也不必花太多时间在dp; 推荐题: [LC 300](https://leetcode.com/problems/longest-increasing-subsequence/), [LC 198](https://leetcode.com/problems/house-robber/) ..








## 不常考但推荐会的算法or数据结构

- Trie (面亚麻必会，常见的比如buildTree，insert，search，delete（也可以会），时间复杂度分析）推荐题：1268
- Line Sweep （常与TreeSet and TreeMap联用）
- Segment Tree（面谷歌需要会一下，我推荐城主视频，我也是跟城主大佬学的，顺便准备一下cord tree）
- Rolling Hash （其实说白了，也不难，学学呗）推荐题：1044（有趣有趣，这题突然让我想到一点，当你看到minimum的题的时候，不妨往BFS和Binary Search身上想想！）


## OOD
https://www.1point3acres.com/bbs/thread-717638-1-1.html




## Tag 频率
- **不同Tag考察频率如下(2021)：**
    
    总体：DFS (17%) -> two pointers (11%) -> linked list (6%) -> BFS (5%) -> Hash, stack, heap, binary search, dp
    
    👉🏻Google: DFS (23%) -> Greedy (10%) -> dynamic programming (10%) -> Hash (8%) 果然是最喜欢考难题和dp的大厂
    
    👉🏻Amazon: DFS (23%) -> heap (14%) -> BFS (11%) -> hash (9%)
    
    👉🏻Meta: DFS (16%) -> two pointers (10%) -> BFS, Binary search, heap (6%)
    
    👉🏻Airbnb: two pointers (16%) -> DFS (10%) -> heap (10%) -> BFS (6%)

<img src="../LeetCode/images/Importance%20of%20tags.png">


## Reference 
https://www.1point3acres.com/bbs/thread-921263-1-1.html?mobile=2