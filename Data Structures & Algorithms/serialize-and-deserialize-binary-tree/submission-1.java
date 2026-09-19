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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> elements = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //TODO: base case
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (currNode == null) {
                elements.add("null");
            } else {
                queue.offer(currNode.left);
                queue.offer(currNode.right);
                elements.add(Integer.toString(currNode.val));
            }
        }
        //System.out.println("Tree - " + String.join(",", elements));
        return String.join(",", elements);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //TODO: base case
        Queue<String> elements = new LinkedList<>();
        Arrays.stream(data.split(","))
        .forEach(a -> elements.offer(a));
        Queue<TreeNode> queue = new LinkedList<>();
        String rootVal = elements.poll();
        if (rootVal.equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        queue.offer(root);
        
        while (!elements.isEmpty()) {
            TreeNode currNode = queue.poll();
            String left = elements.poll();
            String right = elements.poll();

            if (!left.equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(left));
                currNode.left = leftNode;
                queue.offer(leftNode);
            }
            if (!right.equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(right));
                currNode.right = rightNode;
                queue.offer(rightNode);
            }
        }

        return root;
    }
}
