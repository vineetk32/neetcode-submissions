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
        List<Integer> leftTree = serialize(p);
        List<Integer> rightTree = serialize(q);

        if (leftTree.equals(rightTree)) return true;
        else return false;
    }

    List<Integer> serialize(final TreeNode p) {
        List<Integer> serialized = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (p == null) {
            serialized.add(-101);
            return serialized;
        }
        queue.offer(p);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                serialized.add(-101);
            } else {
                serialized.add(curr.val);
                queue.offer(curr.left);
                queue.offer(curr.right);
            }            
        }
        return serialized;
    }
}
