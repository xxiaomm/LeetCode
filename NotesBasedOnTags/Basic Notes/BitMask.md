
[leetcode discussion: A summary: how to use bit manipulation to solve problems easily and efficiently](https://leetcode.com/problems/sum-of-two-integers/discuss/84278/a-summary-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently)   

[Bit Manipulation Tricks | Helpful and concise](https://leetcode.com/discuss/study-guide/1412978/Bit-Manipulation-Tricks-or-Helpful-and-concise)

[COMPLETED GUIDE ON BITWISE OPERATORS:)](https://leetcode.com/discuss/study-guide/1487055/completed-guide-on-bitwise-operators)

http://graphics.stanford.edu/~seander/bithacks.html#ReverseParallel

https://www.jianshu.com/p/6a56cac31c25

https://codeantenna.com/a/9HDBdCLMwQ

https://www.cnblogs.com/blknemo/p/14470610.html


https://www.cnblogs.com/RioTian/p/13598747.html

int bit = Integer.bitCount

### Bitwise XOR 按位异或 (" ^ ",  XOR)

- 常见特性:  
  - x ^ 0s = x  
  - x ^ 1s = ~x  
  - x ^ x = 0
  - 满足交换律: a ^ b ^ c = a ^ c ^ b

- 常用技巧
  - 判断两个数是否异号
    ```java
    int x = -1, y = 2;
    boolean f = ((x ^ y) < 0); // true

    int x = 3, y = 2;
    boolean f = ((x ^ y) < 0); // false
    ```

    
  - 不用临时变量交换两个数:  
    ```java
    int a = 1, b = 2;
    a ^= b;
    b ^= a;
    a ^= b;
    // 现在 a = 2, b = 1
    ```
  - 加一
    ```java
    int n = 1;
    n = -~n;
    // 现在 n = 2
    ```
  - 减一
    ```java
    int n = 2;
    n = ~-n;
    // 现在 n = 1
    ```

### Bitwise AND 按位与 (" & ")

- 常见特性:  
  - x & 0s = 0  
  - x & 1s = x  
  - x & x = x

- 常用技巧
  - n & (n-1): 去除数字 n 的最后一位（二进制是1的），例如， n = 1111 0100, n-1 = 1111 0011, n & (n-1) = 1111 0000
  - n & (- n): 获得 n 的最低位, 例如， n = 1111 0100, - n = 0000 1100, n & (- n) = 0000 0100



### Bitwise OR 按位或 (" | ", OR)

- 常见特性:  
  - x | 0s = x  
  - x | 1s = 1s  
  - x | x = x


### 取反 (" ~ ", )


### Left Shift 算数左移 (" << ")


### Right Shift 算数右移 (" >> ")
