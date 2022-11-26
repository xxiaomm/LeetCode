

/*
condition: elements -> distinct, elment can use for more than one time, 

1. time:  
2. space: 
*/
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        // store all numbers of qulified combination
        List<Integer> path = new LinkedList<>(); 
        backtracking(0, 0, candidates, target, path);
        return res;
    }
    // "pos" ensures that each iteration starts from the current or next values 
    // -> no duplicate combination
    public void backtracking(int sum, int pos, int[] candidates, int target, List<Integer> path) {
        if (sum > target) return;   // cut branch 
        if (sum == target) {    // qulified result
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            path.add(candidates[i]);    // add to the path
            backtracking(sum+candidates[i], i, candidates, target, path);
            path.remove(path.size()-1); // remove from the path, try next combination
        }
    }
}
