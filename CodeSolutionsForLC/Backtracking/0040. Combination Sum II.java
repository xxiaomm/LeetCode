

/*
condition: elements -> not distinct, elment can use for only once, 

1. time:  
2. space: 
*/

class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        // store the numbers of current combination
        List<Integer> path = new LinkedList<>();
        backtracking(0, 0, candidates, target, path);
        return res;
    }
    public void backtracking(int sum, int pos, int[] candidates, int target, List<Integer> path) {
        if (sum > target) return;
        if (sum == target) {    // qulified result
            res.add(new LinkedList<>(path));
            return;
        }
        // pos ensure each element use once
        for (int i = pos; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtracking(sum+candidates[i], i+1, candidates, target, path);
            path.remove(path.size()-1);
            // avoid duplicate result, skip the duplicate elements
            while (i+1 < candidates.length && candidates[i+1] == candidates[i]) 
                i++;
        }
    }
}