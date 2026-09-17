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
    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
maxPathSumWorker(root);
        return maxPath; 
    }

    private void maxPathSumWorker(TreeNode root) {
        if (root == null) return;

        int leftPath = getMaxPath(root.left);
        int rightPath = getMaxPath(root.right);
        maxPath = Math.max(maxPath, leftPath + root.val + rightPath);

        maxPathSum(root.left);
        maxPathSum(root.right);
    }

    private int getMaxPath(final TreeNode root) {
        if (root == null) return 0;
        int leftPath = getMaxPath(root.left);
        int rightPath = getMaxPath(root.right);

        int localMax = Math.max(leftPath, rightPath);

        return Math.max(0, root.val + localMax);
    }
}
