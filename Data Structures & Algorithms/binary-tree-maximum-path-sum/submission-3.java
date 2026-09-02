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
    int mxi=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return mxi;
    }

    private int dfs(TreeNode node){
        if(node==null)return 0;

        int lh=Math.max(dfs(node.left),0);
        int rh=Math.max(dfs(node.right),0);

        mxi=Math.max(mxi,lh+rh+node.val);

        return node.val+Math.max(lh,rh);
    }
}
