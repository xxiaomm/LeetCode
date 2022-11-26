

/*
Idea: DFS, Recursion

1. time: O(n), n is the number of tree nodes.

2. space: O(H). the height of tree, also the recursion stack.
*/
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) 
            && isSameTree(p.right, q.right);
    }
}



/*
Optimization: 


1. time: 

2. space: 
*/

