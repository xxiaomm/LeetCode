/*
Idea: DFS, down-top Recursion

1. time: O(n), n is the number of tree nodes.

2. space: O(H). the height of tree, also the recursion stack.
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        // the depth of left subtree
        int left = dfs(root.left);
        if (left == -1) return -1; 
        // the depth of right subtree
        int right = dfs(root.right);
        // not balance -> -1, balanced -> return max depth
        if (right == -1) return -1;
        return Math.abs(left-right) > 1 ? -1 : Math.max(left, right)+1;
    }
}



/*
Optimization: 


1. time: 

2. space: 
*/

