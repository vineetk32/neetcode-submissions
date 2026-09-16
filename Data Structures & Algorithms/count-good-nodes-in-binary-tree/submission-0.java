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
    public int goodNodes(TreeNode root) {
        return goodNodesWorker(root, root.val);
    }

    private int goodNodesWorker(final TreeNode root, final int max) {
        int nodeCount = 0;
        if (root == null) return 0;
        if (root.val >= max) nodeCount++;
        nodeCount += goodNodesWorker(root.left, Math.max(max, root.val));
        nodeCount += goodNodesWorker(root.right, Math.max(max, root.val));

        return nodeCount;
    }
}
