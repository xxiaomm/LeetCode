/*
Idea: DFS, Recursion

n is the number of tree nodes.
1. time: O(n).

2. space: O(n), output list.
*/

class Solution {
    List<Integer> res = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}



/*
Optimization: 


1. time: 

2. space: 
*/

