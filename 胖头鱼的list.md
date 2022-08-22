https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=678970&page=1&authorid=682747

- [第十章 数据结构](#第十章-数据结构)
  - [基本问题：](#基本问题)
  - [数据结构 题目列表：](#数据结构-题目列表)
    - [Stack](#stack)
- [第十一章 动态规划](#第十一章-动态规划)
  - [基本问题：](#基本问题-1)
  - [动态规划 题目列表：](#动态规划-题目列表)
    - [Backpack:](#backpack)
    - [Single Sequence:](#single-sequence)
    - [Double Sequences:](#double-sequences)
    - [Sections:](#sections)
    - [Matrix:](#matrix)
    - [Others：](#others)
    - [Greedy:](#greedy)


### 语法入门题目列表：

因为Leetcode没太多基础的题，所以这个章节基本用的是Lintcode上的Naive。
这些题主要是帮助熟悉语法，所以没有用特别高的优先级。
- [Lint-37. Reverse 3-digit Integer](https://www.lintcode.com/problem/37/)

## 第十章 数据结构
### 基本问题：
(1) 本章按照数据结构分类一些问题，和之前按算法分类的题目相比可能会有重复，因为一道题可能有多个标签。
(2) 对于每种数据结构，需要先学习掌握其基本原理，优缺点，复杂度，和对应语言中的API用法。对于其基本的实现方式也要了解。
(3) Array，Matrix，String，Hash都是一些常用的数据结构，一般在各种题里都会用到，这里主要列举一些没有涉及到其他算法的题目。
(4) Linked List往往自成一类，会涉及到一些pointer操作，需要细心。
(5) Queue一般用在BFS里面比较多，这里不单独列举了。
(6) Heap， Stack往往和其他知识点混用，但自己单独出题也可以。
(7) Trie，Union Find， Sweep Line的套路比较明显，需要记住模板。
(8) Binary Index Tree 和Segment Tree涉及到的题目有限，需要记住模板。Segment Tree解法一般来说可以覆盖BIT能解决的问题，但是BIT写起来短一些。
(9) 复合数据结构里面LRU和LFU相对比较重要。其他的在掌握基本数据结构即复杂度之后，可以随机应变。
### 数据结构 题目列表：
（必背：紫色；核心：蓝色；重点：绿色；普通：黄色；默认是LeetCode，如果是LintCode会以Lint开头）

#### Stack
- [155. Min Stack](https://leetcode.com/problems/min-stack/)


## 第十一章 动态规划

### 基本问题：
(1) 动态规划更准确的说是一种数学思想，而不是一种算法。学习曲线相对于前面的算法会比较陡峭，如果是有天赋的大佬，可能可以很快领悟。但是对于大部分平均水平的同学，可能需要前后间隔几个礼拜甚至几个月，反复思考两三遍才能顿悟并运用。所以作为初学者，一时半会想不明白没关系，隔几天回来再多看几次就能渐渐理解了。
(2) 不过针对目前的面试，除了少数那几家公司之外，动态规划的出现频率其实没有那么高，而且主要也都是中等难度的题目。所以如果准备时间有限，建议优先把时间放在前面的算法上，动态规划可以先看几道中等难度经典题，其他的题目后面有时间再看。
(3) 关于一道题是用动态规划还是用贪心法，一般来说时间复杂度类似的时候优先用动态规划，因为通用性、可解释性都比较强。而自己凭空想出来的贪心法，不但不容易解释，而且很容易是错的，面试风险相对比较高。不过有一些题目确实是贪心法最优，作者在后面也列出了几题，如果碰到原题或者类似题，可以参考。
(4) 对于新手而言，在学习动态规划的时候，看懂题目在问什么之后就可以在网上找答案了，别自己瞎折腾。网上各种大佬的博客有详细的图文解释，慢慢揣摩理解。
(5) 动态规划的一般思路是数学归纳法，就是用递推的方式把大问题（最终问题）分解为小问题（前置问题），然后一路倒推到边界；在边界附近计算出初始状态后，再原路反向往回计算，最后得到所求解。所以对于绝大部分题目，都需要遵循：分解子问题，写出转移方程，描述边界条件，计算出最终解这几个步骤。
(6) 有些动态规划问题，可以通过滚动数组的方式优化空间复杂度，一般可以降一个维度。但是要注意运算的方向，需要避免前序的结果在被用到之前就被覆盖掉的情况。
(7)大部分动态规划都是求解“可行性”，“最值”问题，如果有些题目要求输出结果，也可以考虑用“打印路径”的方式。
(8) 很多问题，通过细微的改一些条件，就会变成另外一道题，解法思路会产生明显差异，所以审题要小心。比如背包类问题，是否可以重复选同一个物品，是否有重复物品，求解最大重量还是最大价值， 背后的原理可能会产生变化。有时候是组合问题，有时候是排列问题，还叠加了是否可以重复的情况，需要透彻的理解。另外在解法上，比如说，正着走一遍循环和倒着走一遍循环可能代表的是两种不同的思考方式，这些往往需要反复细致的理解才能完善自己的思维体系。
(9) 有些问题需要求“所有可行解”，这时候往往会使用搜索（DFS，BFS）的方法。但为了进行时空优化，记忆化搜索也会常常被用到。其实DFS记忆化搜索和常规动态规划写法常常是一个思维的两种实现方式，在不同的题目中各有优劣。
(10) 在面试动态规划的时候，重点在于能够比较清晰地画图描述并解释清楚所写的动态方程，让面试官理解你的思路，注意初始化以及for循环的起始条件。至于代码本身，往往是for循环为主，一般也不长。
### 动态规划 题目列表：
（必背：紫色；核心：蓝色；重点：绿色；普通：黄色；默认是LeetCode，如果是LintCode会以Lint开头）
#### Backpack:
- [Lint-92. Backpack](https://www.lintcode.com/problem/backpack/description)
- [Lint-125. Backpack II](https://www.lintcode.com/problem/backpack-ii/description)
- [Lint-440. Backpack III](https://www.lintcode.com/problem/backpack-iii/description)
- [Lint-562. Backpack IV](https://www.lintcode.com/problem/backpack-iv/description)
- [Lint-563. Backpack V](https://www.lintcode.com/problem/backpack-v/description)
- [Lint-564. Backpack VI (Combination Sum IV)](https://www.lintcode.com/problem/combination-sum-iv/description)
- [Lint-971. Surplus Value Backpack]VIP
- [474. Ones and Zeroes](https://leetcode.com/problems/ones-and-zeroes/)
#### Single Sequence:
- [139. Word Break](https://leetcode.com/problems/word-break)
- [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
- [122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)
- [123. Best Time to Buy and Sell Stock III]
https://leetcode.com/problems/be ... and-sell-stock-iii/
188. Best Time to Buy and Sell Stock IV
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
256. Paint House
https://leetcode.com/problems/paint-house/
265. Paint House II
https://leetcode.com/problems/paint-house-ii/
Lint-843. Digital Flip
https://www.lintcode.com/problem/digital-flip/description
#### Double Sequences:
10. Regular Expression Matching
https://leetcode.com/problems/regular-expression-matching/
44. Wildcard Matching
https://leetcode.com/problems/wildcard-matching/
72. Edit Distance
https://leetcode.com/problems/edit-distance/
97. Interleaving String
https://leetcode.com/problems/interleaving-string/
115. Distinct Subsequences
https://leetcode.com/problems/distinct-subsequences/
1143. Longest Common Subsequence
https://leetcode.com/problems/longest-common-subsequence/
#### Sections:
312. Burst Balloons
https://leetcode.com/problems/burst-balloons/
516. Longest Palindromic Subsequence
https://leetcode.com/problems/longest-palindromic-subsequence/
87. Scramble String
https://leetcode.com/problems/scramble-string/
#### Matrix:
62. Unique Paths
https://leetcode.com/problems/unique-paths/
63. Unique Paths II
https://leetcode.com/problems/unique-paths-ii/
64. Minimum Path Sum
https://leetcode.com/problems/minimum-path-sum/
85. Maximal Rectangle
https://leetcode.com/problems/maximal-rectangle/
221. Maximal Square
https://leetcode.com/problems/maximal-square/
361. Bomb Enemy
https://leetcode.com/problems/bomb-enemy/
#### Others：
91. Decode Ways
https://leetcode.com/problems/decode-ways/
Lint-394. Coins in a Line
https://www.lintcode.com/problem/coins-in-a-line/description
132. Palindrome Partitioning II
https://leetcode.com/problems/palindrome-partitioning-ii/
279. Perfect Squares
https://leetcode.com/problems/perfect-squares/
639. Decode Ways II
https://leetcode.com/problems/decode-ways-ii/
Lint-395. Coins in a Line II
https://www.lintcode.com/problem/coins-in-a-line-ii/description
Lint-396. Coins in a Line III
https://www.lintcode.com/problem/coins-in-a-line-iii/description
#### Greedy:
55. Jump Game
https://leetcode.com/problems/jump-game/
45. Jump Game II
https://leetcode.com/problems/jump-game-ii/
763. Partition Labels
https://leetcode.com/problems/partition-labels/