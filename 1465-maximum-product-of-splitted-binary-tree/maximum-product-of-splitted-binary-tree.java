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
    long totalSum = 0;
    long maxProduct = 0;
    static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        
        totalSum = dfsSum(root);

        // compute max product
        dfsProduct(root);

        return (int)(maxProduct % MOD);
    }

    // First DFS: total sum
    private long dfsSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + dfsSum(node.left) + dfsSum(node.right);
    }

    private long dfsProduct(TreeNode node) {
        if (node == null) return 0;

        long left = dfsProduct(node.left);
        long right = dfsProduct(node.right);

        long subtreeSum = node.val + left + right;

        long product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subtreeSum;
    }
}
