/*
condition: unique, unique subsets

1. time:
2. space: 
*/
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        // store each subset temporarily
        List<Integer> path = new LinkedList<>();
        backtracking(0, nums, path);
        return res;
    }
    public void backtracking(int pos, int[] nums, List<Integer> path) {
        res.add(new LinkedList<>(path));    // each subset, including empty set.
        for (int i = pos; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(i+1, nums, path);
            path.remove(path.size() - 1);
        }
    }
}