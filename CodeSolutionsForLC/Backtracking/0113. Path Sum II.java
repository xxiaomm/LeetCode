/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 /*
1. time:

2. space:
 */
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new LinkedList<>();
        dfs(root, targetSum, path);
        return res;
    }
    public void dfs(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        targetSum -= root.val;
        System.out.println(root.val+" "+targetSum);
        if (root.left == null && root.right == null && targetSum == 0) 
            res.add(new LinkedList<>(path));
        
        dfs(root.left, targetSum, path);
        dfs(root.right, targetSum, path);
        path.remove(path.size() - 1);
    }
}