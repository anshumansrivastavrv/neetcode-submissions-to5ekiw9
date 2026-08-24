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

    private int preIndex = 0;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store each value's index in inorder
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        // No nodes in this subtree
        if(left > right) {
            return null;
        }

        // Preorder: first element = root
        TreeNode root = new TreeNode(preorder[preIndex++]);

        // Find root's position in inorder in O(1)
        int index = inorderMap.get(root.val);

        // Everything before root = left subtree
        root.left = build(preorder, left, index - 1);

        // Everything after root = right subtree
        root.right = build(preorder, index + 1, right);

        return root;
    }
}