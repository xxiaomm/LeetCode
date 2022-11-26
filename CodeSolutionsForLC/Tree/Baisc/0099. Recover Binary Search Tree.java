
/*
Idea: DFS, Recursion, inorder
注意点：可能两个node相邻

1. time: O(n), n is the number of tree nodes.

2. space: O(H). the height of tree, also the recursion stack.
*/
class Solution {
    TreeNode first = null, sec = null, pre = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = sec.val;
        sec.val = first.val;
        first.val = temp;
    }
    public void inorder(TreeNode root) {
        // if root = null
        if (root == null) 
            return;
        inorder(root.left);
        if (pre != null && pre.val > root.val) {
            if (first == null) {    // find the first one, 相邻的暂定为second node.
                first = pre;
                sec = root;
            } else {                // find the second one.
                sec = root;
                return;
            }
        }
        pre = root;
        inorder(root.right);
    }
}



/*
Optimization: 


1. time: 

2. space: 
*/

