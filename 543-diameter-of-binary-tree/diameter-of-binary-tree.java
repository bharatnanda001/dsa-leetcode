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
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        int Lheight = height(root.left);
        int Rheight = height(root.right);
        int Ldia = diameterOfBinaryTree(root.left);
        int Rdia = diameterOfBinaryTree(root.right);
        return Math.max(Lheight + Rheight , Math.max(Ldia, Rdia));
    }
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }    
    
    
}