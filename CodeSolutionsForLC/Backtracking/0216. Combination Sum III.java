/*
1. time:
2. space:
*/
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> path = new LinkedList<>();
        backtracking(1, k, n, path);
        return res;
    }
    public void backtracking(int pos, int k, int n, List<Integer> path) {
        // qualified，sum == n, 个数 == k
        if (path.size() == k && n == 0) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = pos; i <= 9; i++) {
            // 如果当前的i已经大于所需的n，则后面的都不用尝试了，都比i大
            if (i > n) return; 
            n -= i;
            path.add(i);
            backtracking(i+1, k, n, path);
            path.remove(path.size() - 1);
            n += i;
        }
    }
}