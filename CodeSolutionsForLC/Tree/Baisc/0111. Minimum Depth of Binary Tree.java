

/*
/*
Idea: DFS, Recursion

1. time: O(n), n is the number of tree nodes.

2. space: O(H). the height of tree, also the recursion stack.
*/
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 0);
    }
    public int dfs(TreeNode root, int depth) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) 
            return depth+1;
        int left = dfs(root.left, depth+1);
        int right = dfs(root.right, depth+1);
        return Math.min(left, right);
    }
}



/*
Optimization: 


1. time: 

2. space: 
*/

