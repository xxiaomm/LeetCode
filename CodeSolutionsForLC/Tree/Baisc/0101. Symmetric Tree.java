

/*
Idea: DFS, Recursion  

1. time: O(n), n is the number of tree nodes.

2. space: O(H). the height of tree, also the recursion stack.
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }
    public boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSame(p.left, q.right) 
            && isSame(p.right, q.left);
    }
}


/*
Optimization: 


1. time: 

2. space: 
*/

