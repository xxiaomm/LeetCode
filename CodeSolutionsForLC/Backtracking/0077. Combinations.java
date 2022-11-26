/*
condition: combinations are unordered

1. time:

2. space:
*/
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k > n) return res;  // all possibilities aren't satisfied
        // store each result
        List<Integer> path = new LinkedList<>();
        // record each used element
        Set<Integer> used = new HashSet<>();
        backtracking(1, n, k, path, used);
        return res;
    }
    public void backtracking(int pos, int n, int k, List<Integer> path, Set<Integer> used) {
        if (path.size() == k) { // qulified
            res.add(new LinkedList<>(path)); 
            return;
        }
        // "pos" ensure no duplicates, like [1,2] [2,1], 不走回头路
        for (int i = pos; i <= n; i++) {
            if (used.contains(i)) continue; // if used
            path.add(i);    
            used.add(i);
            backtracking(i+1, n, k, path, used);    
            path.remove(path.size() - 1);
            used.remove(i);
        }
    }
}