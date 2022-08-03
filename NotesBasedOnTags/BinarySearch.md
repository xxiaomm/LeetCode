# Binary Search
[参考学习Luciferd](https://github.com/azl397985856/leetcode/blob/master/91/binary-search.md)

二分查找又称折半搜索算法。 狭义地来讲，二分查找是一种在有序数组查找某一特定元素的搜索算法。这同时也是大多数人所知道的一种说法。实际上， 广义的二分查找是将问题的规模缩小到原有的一半。类似的，三分法就是将问题规模缩小为原来的 1/3。   

## Hints to use

1. 排序数组 (30% - 40%) (如果无序考虑排序，注意排序算法的时间复杂度)
2. 找比 O(N)更小时间复杂度算法 (99%)
3. 找到数组中的某个位置，使得左或右某半部分不满足条件(100%)
4. 找到一个最大/最小值使某个条件被满足(90%)
5. 两段有序数组,. 第k小？
33 153 1095 852

## Complexity

- 平均时间复杂度： $O(logN)$
- 最坏时间复杂度： $O(logN)$
- 最优时间复杂度： $O(1)$
- 空间复杂度
  - 迭代：$O(1)$
  - 递归：$O(logN)$（无尾调用消除）


## 题型

- [寻找目标值](#寻找目标值)
- [找满足条件的最左]
- [最右的index]
- [二维数组]
  


## 模板

### 寻找目标值

Example: LC [704](https://leetcode.com/problems/binary-search/),   

- 搜索 [left, right]
- 终止条件: left <= right
- 循环内, 比较 nums[mid] 和 target :
  - 如果arr[mid] == target, 返回mid;
  - 如果arr[mid] > target, 说明答案区间在 [left, mid - 1]: right = mid - 1;
  - 如果arr[mid] < target, 说明答案区间在 [mid + 1, right]: left = mid + 1;
- 找不到, 则返回-1;
  
题型：寻找(不大于)target; 找到符合要求的最左边的index;   


```java
// 最基本的模板
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1; // 搜索 [left, right]
        while (l <= r) {
            int mid = l + (r - l) / 2;  // 防止 r+l overflow
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)    
                r = mid - 1;    // 答案区间在 [left, mid - 1]
            else 
                l = mid + 1;    // 答案区间在 [mid + 1, right]
        }
        return -1;              // 没找到
    }
}
```

### 寻找最左边的满足条件的值
Example: LC [278](https://leetcode.com/problems/first-bad-version/), [35](https://leetcode.com/problems/search-insert-position/), [278](), 【[69](),   
  
- 搜索 [left, right]
- 终止条件: left <= right
- 循环内, 比较 nums[mid] 和 target :
  - 如果arr[mid] == target, *找到可能解(备胎)，收缩右边界，看看左边是否还有target*,;
  - 如果arr[mid] > target, 说明答案区间在 [left, mid - 1]: right = mid - 1;
  - 如果arr[mid] < target, 说明答案区间在 [mid + 1, right]: left = mid + 1;
- 找不到, 则返回-1;

  
题型：;   
题目: LC 852,

```java
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length; //
        while (l < r) {            //
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) 
                r = mid;        //   
            else 
                l = mid + 1;
        }
        return l;   
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length; //
        while (l <= r) {            //
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) 
                r = mid - 1;        //   
            else 
                l = mid + 1;
        }
        return l;   
    }
}
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1; // r = nums.length
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target)
                r = mid - 1;            // r = mid
            else 
                l = mid + 1;
        }
        return l;   
    }
}
```


1. 
   - 初始条件：left = 0, right = length-1
   - 终止：left + 1 == right
   - 向左查找：right = mid
   - 向右查找：left = mid
题型：;   
题目: LC,


