/*
condition: duplicates,

1. time:

2. space: 
*/
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); 
        // store the elements of each permutation
        List<Integer> path = new LinkedList<>();
        // record the elements used in the path
        Set<Integer> used = new HashSet<>(); 
        backtracking(nums, path, used);
        return res;
    }
    public void backtracking(int[] nums, List<Integer> path, Set<Integer> used) {
        if (path.size() == nums.length) {   // all elements in the path
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used.contains(i)) continue;
            path.add(nums[i]);  
            used.add(i);    // 技巧：store index
            backtracking(nums, path, used);
            path.remove(path.size() - 1);
            used.remove(i);
            // skip duplicates -> distinct result (前提条件, sorted array)
            while (i + 1 < nums.length && nums[i+1] == nums[i])
                i++;
        }
    }
}