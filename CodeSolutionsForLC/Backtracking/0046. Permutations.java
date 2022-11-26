

/*
Permutations
conidtion: unique, 

1. time: 
2. space: 
*/

class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
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
            if (used.contains(nums[i])) continue;
            path.add(nums[i]);
            used.add(nums[i]);
            backtracking(nums, path, used);
            path.remove(path.size() - 1);
            used.remove(nums[i]);
        }
    }
}


/*
Optimization: 


1. time: 

2. space: 
*/

