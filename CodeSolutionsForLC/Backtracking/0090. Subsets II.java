/*
condition: duplicate elements, unique subsets

1. time:
2. space: 
*/

class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> path = new LinkedList();
        backtracking(0, nums, path);
        return res;
    }
    public void backtracking(int pos, int[] nums, List<Integer> path) {
        res.add(new LinkedList<>(path));
        for (int i = pos; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(i+1, nums, path);
            path.remove(path.size() - 1);
            // skip duplicates, ensure the result contains distinct subsets, 
            while (i+1 < nums.length && nums[i+1] == nums[i])
                i++;
        }
    }
}