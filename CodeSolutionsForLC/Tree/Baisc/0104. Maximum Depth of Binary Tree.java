
/*
Idea: DFS, Recursion

1. time: O(n), n is the number of tree nodes.

2. space: O(H). the height of tree, also the recursion stack.
*/
class Solution {
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return maxDepth;
    }
    public void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, depth);
            return;
        }
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}


/*
Optimization: 


1. time: 

2. space: 
*/

