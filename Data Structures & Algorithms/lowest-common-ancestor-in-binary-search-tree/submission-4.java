class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null) {

            // Both p and q are smaller → go left
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            }

            // Both p and q are greater → go right
            else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            }

            // They are on different sides, or curr is p/q
            else {
                return curr;
            }
        }

        return null;
    }
}