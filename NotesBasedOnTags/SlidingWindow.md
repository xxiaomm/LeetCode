
# Sliding window

### Complexity
Time: O(n).   
Space: O(1) / O(constant integer).

### 常见使用

1. 滑动窗口(90%)
2. 时间复杂度 O(N)（80%）
3. 原地交换，不能使用额外空间(80%)
4. 有 subarray / substring 关键词(50%)
5. 回文 palindrome （50%）
6. 前缀和
7. 当我们需要枚举数组中的两个元素时，如果我们发现随着第一个元素的递增，第二个元素是递减的，那么就可以使用双指针的方法，将枚举的时间复杂度从 O(N^2)减少至 O(N)。


### 常见题型

-[固定窗口大小](#题型-固定窗口大小)  
-[求满足条件最大窗口/最小窗口](#题型-求满足条件最大窗口/最小窗口)


#### 题型 固定窗口大小

1. l 初始化 0
2. r 初始化 r - l + 1 => 窗口大小
3. 同时移动 l r
4. 判断窗口内元素是否满足条件
   扩张窗口找到可行解，收缩窗口直到不可行，然后再扩张

- 如果满足，考虑更新解
- 如果不满足，继续



#### 题型 求满足条件最大窗口/最小窗口

1. l, r 初始化为 0
2. r++
3. 判断窗口内连续元素是否满足条件
   
- 如果满足，考虑更新解，并且移动 l
- 如果不满足，重复  
  就是 r 指针不停向右移动，l 指针仅仅在窗口满足条件之后才会移动，起到窗口收缩的效果。

#### 伪代码
```java
初始化慢指针 = 0
初始化 ans

for 快指针 in 可迭代集合
   更新窗口内信息
   while 窗口内不符合题意
      扩展或者收缩窗口
      慢指针移动
   更新答案
返回 ans
```

#### 模板代码
[209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) (最小窗口)

```java
// O(n), O(1)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = nums.length + 1, sum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                // 最小窗口: update在循环里面
                res = Math.min(res, r-l+1);
                sum -= nums[l++];
            }                
        }
        return res == nums.length+1 ? 0 : res;
    }
}
```


### 至多有K个不同的数字/字母(最大窗口)

1. 求其最长的长度(子数组/子串); 
2. 求子数组个数;
   
(k=1 没有重复的最长子串: O(n), O(min(128,s.length) )
例题: LeetCode 3, 159, 340, 904, 992,

#### 模板代码
[340. Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/) (最大窗口)

```java
// O(n), O(k)
class Solution {
    public int atMostK(String s, int k) {
        Map<Character, Integer> cnt = new HashMap<>();
        int res = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            cnt.put(c, cnt.getOrDefault(c,0)+1);
            while (cnt.size() > k) {
                char ch = s.charAt(l);
                cnt.put(ch, cnt.get(ch) - 1);
                if (cnt.get(ch) == 0)
                    cnt.remove(ch);
                l++;
            }
            // 最大窗口: update在循环外面
            res = Math.max(res, r - l + 1); // 求最长子数组/子串; 
            // res += r-l+1;    // 求子数组个数
            // 每增加一个元素,此时子数组长度为m 且仍满足要求, 
            // 则符合题意的子数组个数 + m: 该元素本身+该元素和前面每个元素组成子数组
        }
        return res;
    }
}
```

```java
public int longestSub(string s, int k) {
    int maxLen = -1;
    Map<Character, Integer> map = new HashMap<>();
    int left = 0; // start index for the window
    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        if (map.getOrDefault(c, 0) == 0)
            k--;
        map.put(c, map.getOrDefault(c, 0) + 1); 
        while (k < 0) {
            char ch = s.charAt(left);
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) == 0)
                k++;
            left++;
        }
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
```


### 允许修改K次 -> 使得unique(只有一种字母/数字)的子串最长 (最大窗口)

(没有重复的最长子串: O(n), O(min(128,s.length) )  
例题: LeetCode 424, 487, 1004, 2024 

#### 模板代码

[424. Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/) (最大窗口)

```java
// O(n), O(26) / O(128) 看string里都包含啥
class Solution {
    public int characterReplacement(String s, int k) {
        int mainCnt = 0, res = 0;
        int[] cnt = new int[26];
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            // 串里主要的字母个数
            // res最长=mainCnt+k; 所以即使之后换了mian的字母, 若mainCnt比之前小,res肯定也比之前小,就没必要计算
            mainCnt = Math.max(mainCnt, ++cnt[c-'A']);
            while (r - l + 1 - mainCnt > k) 
                cnt[s.charAt(l++)-'A']--;
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
```


###  (最大窗口)

(没有重复的最长子串: O(n), O(min(128,s.length) )  
例题: LeetCode 424, 487, 1004, 2024 

#### 模板代码

[424. Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/) (最大窗口)

```java

```
