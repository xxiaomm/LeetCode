/* 
## Link

https://leetcode.com/problems/design-a-stack-with-increment-operation/

## Idea

1. Use an array to store the increment, inc[i] means that from ```0 - i```, the element should add ```inc[i]```;
2. While poping an element form the stack, the size of the stack decrease, and inc[i] should be update to 0; so we need to update the increment array;  
3. Update the former: ```inc[i-1] += inc[i]```, because element from 0 to i-1 still should add inc[i], then update ```inc[i] = 0```;

## Code
 */

class CustomStack {
    private int capacity;
    private int[] inc;
    Stack<Integer> s;
    
    // O(n), O(n)
    public CustomStack(int maxSize) {
        this.capacity = maxSize;
        inc = new int[capacity];
        s  = new Stack<>();
    }
    // O(1)
    public void push(int x) {
        if (s.size() < capacity)
            s.push(x);
    }
    // O(1)
    public int pop() {
        if (s.isEmpty()) return -1;
        
        int i = s.size()-1;
        if (i > 0)
            inc[i-1] += inc[i];
        int val = s.pop()+inc[i];
        inc[i] = 0;
        return val;
    }
    // O(1)
    public void increment(int k, int val) {
        int bound = Math.min(s.size(),k) - 1;
        if (bound >= 0)
            inc[bound] += val;
    }
}



/* ## Complexity

Time complexity: Initialization: O(n); Others: O(1).  
Space complexity: Initialization: O(n); Others: O(1).
 */