
/*
Idea: DFS, Recursion, inorder
each element should be greater than the previous one

1. time: O(n), n is the number of tree nodes.

2. space: O(H). the height of tree, also the recursion stack.
*/
class Solution {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (pre != null && pre.val >= root.val)
            return false;
        pre = root;
        return isValidBST(root.right);
    }
}

/*
Optimization: 


1. time: 

2. space: 
*/

