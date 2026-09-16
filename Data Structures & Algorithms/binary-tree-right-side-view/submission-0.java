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
    public List<Integer> rightSideView(TreeNode root) {
       Queue<TreeNode> currLevel, nextLevel;
       List<Integer> outputList = new LinkedList<>();

        //base case

        currLevel = new LinkedList<>();
        nextLevel = new LinkedList<>();

        nextLevel.offer(root); //1
        while (!nextLevel.isEmpty()) {
            
            currLevel.addAll(nextLevel);//[2, 3]
            nextLevel.clear();//[4, 5, 5, 6]

            int lastElement = 0;

            while (!currLevel.isEmpty()) {
                TreeNode curr = currLevel.poll();//3
                if (curr != null) {
                    lastElement = curr.val;//[3]
                    nextLevel.offer(curr.left);
                    nextLevel.offer(curr.right);
                }
            }
            if (lastElement > 0) outputList.add(lastElement);
        }

        return outputList;
    }
}
