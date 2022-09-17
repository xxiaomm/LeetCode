

- [Hint to Use](#hint-to-use)
- [模板](#模板)
- [一些基础知识](#一些基础知识)
  - [Combination](#combination)
  - [Permutation](#permutation)
- [典型题目](#典型题目)
- [Reference](#reference)

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
        做选择;
        backtrack(路径, 选择列表);
        撤销选择;
    }
```

一些条件形式：
- 元素无重不可复选，即 nums 中的元素都是唯一的，每个元素最多只能被使用一次; 【 index(组合), set / boolean数组(排列) 】
- 元素可重不可复选，即 nums 中的元素可以存在重复，每个元素最多只能被使用一次; 【先sort -> index避免重复选择, while循环/if语句 避免出现重复path(剪枝) 】
- 元素无重可复选，即 nums 中的元素都是唯一的，每个元素可以被使用若干次; 【传index】
- 元素可重不可复选，即 nums 中的元素可以存在重复，每个元素最多只能被使用一次; 【 boolean数组避免复选, while / if 避免path重复 】

***技巧*** 
1. 可能需要排序;
2. 已排序: 传递参数index, 使用 while 循环, 选择重复元素 / 跳过重复元素;
3. 未排序: 使用 set / boolean 数组, 标记已选择元素;

## 一些基础知识

### Combination
从 n 个中选择 k 个进行组合。 eg. 组合 / 子集问题  
时间复杂度: C_n ^ k  * (n! / ((n-k)! k!) )



### Permutation
将 n 个元素任意排序组合。    
时间复杂度: n！



## 典型题目
- [Backtracking for Beginners](https://leetcode.com/discuss/study-guide/2244368/Backtracking-for-Beginners-Problems)


## Reference
https://labuladong.github.io/algo/   
[labuladong](https://labuladong.github.io/algo/4/31/105/)   
[labuladong题目推荐](https://labuladong.github.io/algo/4/31/107/)   
[宫水三叶](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzU4NDE3MTEyMA==&action=getalbum&album_id=1748759631868280833#wechat_redirect)    
[宫水三叶题目推荐](https://github.com/SharingSource/LogicStack-LeetCode/wiki/%E5%9B%9E%E6%BA%AF%E7%AE%97%E6%B3%95) 