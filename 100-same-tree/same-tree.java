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
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case :if both nodes are null return tru\\ same ko check maro 
        // ek null ho dusri no to false maro]
        if(p == null && q == null)return true;
        if(p== null|| q == null)return false;
        return(p.val ==q.val)&&
        isSameTree(p.left,q.left)&&
        isSameTree(p.right,q.right);
        
    }
}