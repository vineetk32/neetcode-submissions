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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncestors = getAncestors(root, p);
        List<TreeNode> qAncestors = getAncestors(root, q);

        int i = pAncestors.size() - 1;
        int j = qAncestors.size() - 1;

        while (i >= 0 && j >= 0 && pAncestors.get(i) == qAncestors.get(j)) {
            i--;
            j--;
        }

        return pAncestors.get(i + 1);
    }

    private List<TreeNode> getAncestors(final TreeNode root, final TreeNode p) {
        if (root == null) return null;
        List<TreeNode> res = null;;
        if (root == p) {
            res = new LinkedList<>();
            res.add(p);
        }
        else {
            res = getAncestors(root.left, p);
            if (res != null) {
                res.add(root);
            }
            else {
                res = getAncestors(root.right, p);
                if (res != null) {
                    res.add(root);
                }
            }
        }
        return res;
    }
}
