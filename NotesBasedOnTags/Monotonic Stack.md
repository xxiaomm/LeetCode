
# Monotonic Stack

- [Monotonic Stack](#monotonic-stack)
    - [Hint to use](#hint-to-use)
    - [Complexity](#complexity)
    - [几种情况的模板](#几种情况的模板)
      - [模板: 找第一个大于它的数 -> 单调递减栈](#模板-找第一个大于它的数---单调递减栈)
      - [模板: 找第一个小于它的数 -> 单调递增栈](#模板-找第一个小于它的数---单调递增栈)
      - [模板: 求出含A[i]并以A[i]为最小/大 -> 左右边界都需要考虑](#模板-求出含ai并以ai为最小大---左右边界都需要考虑)
      - [和Greedy搭配使用](#和greedy搭配使用)
    - [Reference](#reference)


### Hint to use
- 求解「第一个大于 xxx」(单调递减栈) 
- 求解「第一个小于 xxx」(单调递增栈)
- 有一堆 digits，找最大/最小的排列方式
- 和Greedy搭配使用

**技巧**
1. 存储index而不是元素本身
2. 存储index时, 添加 ***哨兵*** 在头部或尾部

### Complexity

Time: 由于 arr 的元素最多只会入栈，出栈一次，因此时间复杂度仍然是 O(n),其中 N 为数组长度。
Space: O(n)

### 几种情况的模板

#### 模板: 找第一个大于它的数 -> 单调递减栈
题目: 
- [496. Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/) 
- [503. Next Greater Element II](https://leetcode.com/problems/next-greater-element-ii/) 
- [739. Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)
- [901. Online Stock Span](https://leetcode.com/problems/online-stock-span/)


```java
// 503. Next Greater Element II
class Solution {
    public int[] nextGreaterElements(int[] nums) {
      // 存储递减元素的stack
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for(int i = 0; i < nums.length*2; i++) {
            int j = i % nums.length; 
            // 单调递减栈: 遇到不符合规则的 / 遇到(栈顶元素) 比它小的, 弹栈, 
            // 此元素 -> 即为弹出元素的 第一个比它大的
            while (!stack.isEmpty() && nums[stack.peek()] < nums[j])
                res[stack.pop()] = nums[j];  //求的是第一个比它大的元素的值
            stack.push(j);
        }
        return res;        
    }
}
```

#### 模板: 找第一个小于它的数 -> 单调递增栈
题目:   
- [1475. Final Prices With a Special Discount in a Shop](https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/)

```java
// 1475. Final Prices With a Special Discount in a Shop
// 找第一个 < prices[i]的, 单调增栈
// O(n), O(1)
class Solution {
    public int[] finalPrices(int[] prices) {
        // 存储递增元素的stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            // 单调递增栈: 遇到不符合规则的 / 遇到(栈顶元素) 比它大的, 弹栈, 
            // 此元素 -> 即为弹出元素的 第一个比它小的
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i])
                prices[stack.pop()] -= prices[i];   // 求的是第一个比原价小的折扣后的售价

            stack.push(i);
        }
        return prices;
    }
}
```

#### 模板: 求出含A[i]并以A[i]为最小/大 -> 左右边界都需要考虑

题目:  
- [907. Sum of Subarray Minimums](https://leetcode.com/problems/sum-of-subarray-minimums/)【以A[i]为最小】
- [2104. Sum of Subarray Ranges](https://leetcode.com/problems/sum-of-subarray-ranges/)
- [84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)【以A[i]为最大】
- [85. Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/)

```java
// 2104. Sum of Subarray Ranges
// 统计某个值充当 min 和 max 在子数组出现的次数, 二者的差 * 值 -> 贡献值
class Solution {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        long[] minCnt = new long[nums.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // 哨兵
        for (int i = 0; i < nums.length; i++) {
            // 递增栈, 计算nums[i]作为min出现的次数
            while (stack.size() > 1 && nums[i] < nums[stack.peek()]) {
                int curIndex = stack.pop();
                // 左边界可选个数 * 右边界可选个数
                minCnt[curIndex] = (long) (curIndex - stack.peek()) * (i - curIndex);
            }
            stack.push(i);
        }
        while (stack.size() > 1) {
            int curIndex = stack.pop();
            minCnt[curIndex] = (long) (curIndex - stack.peek()) * (nums.length - curIndex);
        }
        
        long[] maxCnt = new long[nums.length];
        stack.clear();
        stack.push(-1); // 别忘了再次添加哨兵
        for (int i = 0; i < nums.length; i++) {
            // 递减栈, 计算nums[i]作为max出现的次数
            while (stack.size() > 1 && nums[i] > nums[stack.peek()]) {
                int curIndex = stack.pop();
                // 左边界可选个数 * 右边界可选个数
                maxCnt[curIndex] = (long) (curIndex - stack.peek()) * (i - curIndex);
            }
            stack.push(i);
        }
        while (stack.size() > 1) {
            int curIndex = stack.pop();
            maxCnt[curIndex] = (long) (curIndex - stack.peek()) * (nums.length - curIndex);
        }
        // num[i]的值 * ( 作为max出现的次数 - 作为min出现的次数 )
        for (int i = 0; i < nums.length; i++) 
            res += (long) nums[i] * (maxCnt[i] - minCnt[i]);
        
        return res;
    }
}



// 84. Largest Rectangle in Histogram: 以A[i]为最大
public class Solution {
    public int largestRectangleArea(int[] h) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // 哨兵
        int maxRec = 0;
        for (int i = 0; i < h.length; i++) {
            // 右侧遇到比它小的, 开始弹栈, 栈内都是比栈顶元素 小 或 等于
            while (stack.size() > 1 && h[i] < h[stack.peek()]) {
                int curH = h[stack.pop()];
                // 遇到 == 栈顶元素, 弹栈, 宽度增加
                while(stack.size() > 1 && h[stack.peek()] == curH)
                    stack.pop();
                // width = 最右比它小的 - 最左比它小的 - 1
                maxRec = Math.max(maxRec, curH * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        // 右边界是末尾的墙
        while (stack.size() > 1) {
            int curH = h[stack.pop()];
            while(stack.size() > 1 && h[stack.peek()] == curH)
                stack.pop();
            maxRec = Math.max(maxRec, curH * (h.length - stack.peek() - 1));
        }
        return maxRec;
    }
}
```

#### 和Greedy搭配使用

题目：
- [316. Remove Duplicate Letters](https://leetcode.com/problems/remove-duplicate-letters/)(same as 
- [1081](https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/))【[力扣加加题解](https://leetcode.cn/problems/remove-duplicate-letters/solution/yi-zhao-chi-bian-li-kou-si-dao-ti-ma-ma-zai-ye-b-4/)】







https://leetcode.cn/problems/remove-duplicate-letters/solution/yi-zhao-chi-bian-li-kou-si-dao-ti-ma-ma-zai-ye-b-4/

- [402. Remove K Digits](https://leetcode.com/problems/remove-k-digits/)
- [316. Remove Duplicate Letters](https://leetcode.com/problems/remove-duplicate-letters/)
- [321. Create Maximum Number](https://leetcode.com/problems/create-maximum-number/)
- [1081. Smallest Subsequence of Distinct Characters](https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/)



### Reference

https://mp.weixin.qq.com/s/Mb8PAxMj2KLTQ1QrCh8XAA 