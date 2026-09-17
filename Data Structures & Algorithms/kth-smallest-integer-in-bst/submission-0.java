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
    public int kthSmallest(TreeNode root, int k) {
        //Iterative in-order.
        //Keep pushing left nodes onto the stack
        //Pop, visit
        TreeNode curr = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || curr != null) {

            while (curr != null) {
                stack.offerLast(curr);
                curr = curr.left;
            }

            curr = stack.pollLast();
            k--;
            if (k == 0) return curr.val;

            curr = curr.right;

            //System.out.println("Curr - " + curr.val);
        }

        return -1;
    }
}
