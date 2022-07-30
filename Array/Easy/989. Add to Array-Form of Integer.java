/*
### Link

https://leetcode.com/problems/add-to-array-form-of-integer/

### Idea

1. Add two numbers from right to left, column by column, and record the carry;
2. If carry > 0, add it to the next column;
3. Add the result to the first position of the result list;
4. Implement the loop until all digit in two numbers has been calculated, or carry = 0;

#### Code

```java
 */
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int i = num.length - 1, carry = 0;
        while (i >= 0 || k > 0 || carry > 0) {
            int val1 = i < 0 ? 0 : num[i--];
            int val2 = k % 10;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            res.add(0, sum % 10);
            k = k / 10;
        }
        return res;
    }
}
```

/* 
#### Complexity

Time complexity: O(n), n is the greater length of the two numbers.  
Space complexity: O(1), not include the space of output array.
*/