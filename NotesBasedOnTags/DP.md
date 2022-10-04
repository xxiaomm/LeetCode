

子数组、子序列这类问题，你就可以尝试定义 dp[i] 是以 nums[i] 为结尾的最大子数组和/最长递增子序列，因为这样定义更容易将 dp[i+1] 和 dp[i] 建立起联系，利用数学归纳法写出状态转移方程。

- [简介](#简介)
  - [三要素](#三要素)
  - [Complexity](#complexity)
- [背包问题](#背包问题)
  - [0-1 背包](#0-1-背包)
  - [完全背包](#完全背包)
  - [](#)
- [路径问题](#路径问题)
  - [空间优化](#空间优化)


[OI-wiki](https://oi-wiki.org/dp/knapsack/)  
[知乎](https://zhuanlan.zhihu.com/p/126546914)


## 简介

动态规划问题的一般形式就是求最值, 求解动态规划的核心问题是穷举。

### 三要素
- 「最优子结构」: 是否能够通过子问题的最值得到原问题的最值。
- 「重叠子问题」: 暴力穷举的话效率会很低，所以需要你使用「备忘录」或者「DP table」来优化穷举过程，避免不必要的计算。
- 「状态转移方程」: 正确的状态转移方程 -> 正确地穷举。
  - 思考状态转移方程的思路:   
   明确 base case -> 明确「状态」-> 明确「选择」 -> 定义 dp 数组/函数的含义。

### Complexity
Time Complexity: 就是用子问题个数乘以解决一个子问题需要的时间。


## 背包问题

[labuladong](https://labuladong.github.io/algo/3/27/81/)    
[宫水三叶](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzU4NDE3MTEyMA==&action=getalbum&album_id=1751702161341628417&scene=173&from_msgid=2247485638&from_itemidx=1&count=3&nolastread=1#wechat_redirect) 


泛指一类「给定价值与成本」，同时「限定决策规则」，在这样的条件下，如何实现价值最大化的问题。

背包问题本质上属于组合优化的「 NP完全问题」。  「 NP完全问题」(Knapsack problem)属于「无法直接求解」的问题。
只能通过「穷举」+「验证」的方式进行求解。

哨兵技巧：增加一行不存在任何物品的讨论 base case


### 0-1 背包

「01背包」是指给定物品价值与体积（对应了「给定价值与成本」），在规定容量下（对应了「限定决策规则」）如何使得所选物品的总价值最大。-> 每个物品只有一个，对应「要么选」「要么不选」。

题目
- [416. Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
- [279. Perfect Squares](https://leetcode.com/problems/perfect-squares/)

- 


https://github.com/SharingSource/LogicStack-LeetCode/wiki/%E8%83%8C%E5%8C%85-DP     
474 494 638 879 1049 1155 449 1995

### 完全背包

01背包的特例 -> 每个物品有无限个。

- [322. Coin Change](https://leetcode.com/problems/coin-change/)
- [518. Coin Change II](https://leetcode.com/problems/coin-change-ii/)

### 




## 路径问题

[宫水三叶](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzU4NDE3MTEyMA==&action=getalbum&album_id=1773144264147812354&scene=173&from_msgid=2247485580&from_itemidx=1&count=3&nolastread=1#wechat_redirect)



题目:
- [62. Unique Paths](https://leetcode.com/problems/unique-paths/)
- [63. Unique Paths II](https://leetcode.com/problems/unique-paths-ii/)
- [64. Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)
- [120. Triangle](https://leetcode.com/problems/triangle/)
- [931. Minimum Falling Path Sum](https://leetcode.com/problems/minimum-falling-path-sum/)
- [1289. Minimum Falling Path Sum II](https://leetcode.com/problems/minimum-falling-path-sum-ii/)
- [1575. Count All Possible Routes](https://leetcode.com/problems/count-all-possible-routes/)
- [576. Out of Boundary Paths](https://leetcode.com/problems/out-of-boundary-paths/)
- [1301. Number of Paths with Max Score](https://leetcode.com/problems/number-of-paths-with-max-score/)

### 空间优化

- 滚动数组 (推荐)
  - O(n^2) -> O(n): 每次只需要用到上一次的数据(不选 f[i-1]j]，选择 f[i-1][j-x])，可以降为 f[2][n] ->  填入顺序变换方式 f [ i & 1 ][ j ] 
  - O(n^2) - O(1): 利用修改原数组，从后往前遍历
- 根据状态依赖调整迭代/循环的方向