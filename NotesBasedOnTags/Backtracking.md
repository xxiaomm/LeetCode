

[力扣加加](https://leetcode-solution-leetcode-pp.gitbook.io/leetcode-solution/thinkings/backtrack)  
[labuladong](https://labuladong.github.io/algo/4/31/105/)   
[宫水三叶](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzU4NDE3MTEyMA==&action=getalbum&album_id=1748759631868280833#wechat_redirect)   


- [简介](#简介)
- [Hint to Use](#hint-to-use)
- [模板](#模板)
  - [排列组合的一些条件形式](#排列组合的一些条件形式)
    - [排列组合基础知识](#排列组合基础知识)
  - [技巧](#技巧)
- [推荐题目](#推荐题目)
    - [Permutation](#permutation)
    - [Combination](#combination)
    - [others](#others)

## 简介

回溯是DFS中的一种技巧, 对每一步进行选择 / 撤销选择, 通过穷举所有可能寻找所有正确答案。   
回溯的本质是一种**暴力枚举算法**。  

***剪枝*** 是回溯算法的一个重要考点。

***排列组合*** 相关题目的关键点是如何避免结果集的重复元素。

## Hint to Use

1. 求的是所有的方案，而不是方案数; (要枚举所有方案的题目)
2. 给定 字符串 / matrix, 求是否存在符合要求的...
3. 通常数据范围不会太大，只有几十, 通常会限制在 30 以内;



## 模板
- 确定结束回溯的条件 base case;
- 遍历所有选择;
- 已选择的需要排除(用boolean数组标记), 防止结果集出现重复结果;
- 选择 -> 递归 -> 撤销选择;

```java
List<> res = new ArrayList<>();
public void backtrack(路径path, 选择列表):
    if (满足结束条件) {
        res.add(path)；
        return;
    }
   
    for (选择 in 选择列表) {
        (已选择的: continue)
        做选择;     // visited[i] = true
        backtrack(路径, 选择列表);
        撤销选择;   //  visited[i] = false
    }
```

### 排列组合的一些条件形式

- 元素无重不可复选，即 nums 中的元素都是唯一的，每个元素最多只能被使用一次; 【 index(组合), set / boolean数组(排列) 】
- 元素可重不可复选，即 nums 中的元素可以存在重复，每个元素最多只能被使用一次; 【先sort -> index避免重复选择, while循环/if语句 避免出现重复path(剪枝) 】
- 元素无重可复选，即 nums 中的元素都是唯一的，每个元素可以被使用若干次; 【传index】
- 元素可重不可复选，即 nums 中的元素可以存在重复，每个元素最多只能被使用一次; 【 boolean数组避免复选, while / if 避免path重复 】

#### [排列组合基础知识](Basic%20Notes/Combination%20&%20Permutation.md)

### 技巧

1. 可能需要排序;
2. 已排序（组合）: 传递参数index, 使用 while 循环, 选择重复元素 / 跳过重复元素;
3. 未排序（排列）: 使用 set / boolean 数组, 标记已选择元素;
4. 排列: for 循环从 0 开始;
5. 组合: 传入 index, for 循环从 index开始, 不走回头路;
6. 剪枝: 原则就是 ***避免根本不可能是答案的递归*** 。





## 推荐题目
[Backtracking for Beginners](https://leetcode.com/discuss/study-guide/2244368/Backtracking-for-Beginners-Problems)  
[labuladong题目推荐](https://labuladong.github.io/algo/4/31/107/)    
[宫水三叶题目推荐](https://github.com/SharingSource/LogicStack-LeetCode/wiki/%E5%9B%9E%E6%BA%AF%E7%AE%97%E6%B3%95) 

#### Permutation

- [46. Permutations](https://leetcode.com/problems/permutations/)
- [47. Permutations II](https://leetcode.com/problems/permutations-ii/)



#### Combination

- [39. Combination Sum](https://leetcode.com/problems/combination-sum/)
- [40. Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)
- [77. Combinations](https://leetcode.com/problems/combinations/)
- [216. Combination Sum III](https://leetcode.com/problems/combination-sum-iii/)
- [78. Subsets](https://leetcode.com/problems/subsets/)
- [90. Subsets II](https://leetcode.com/problems/subsets-ii/)

#### others

- [17. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
- [22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)
- [79. Word Search](https://leetcode.com/problems/word-search/)
- [212. Word Search II](https://leetcode.com/problems/word-search-ii/) (+ Trie)
- [37. Sudoku Solver](https://leetcode.com/problems/sudoku-solver/)
- [51. N-Queens](https://leetcode.com/problems/n-queens/)
- [52. N-Queens II](https://leetcode.com/problems/n-queens-ii/)
- [301. Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses/)
- 







- [638. Shopping Offers](https://leetcode.com/problems/shopping-offers/)



 301 306 797 1219
  113 131 1255
笛卡尔积 140 401 816



 1240 489 473 