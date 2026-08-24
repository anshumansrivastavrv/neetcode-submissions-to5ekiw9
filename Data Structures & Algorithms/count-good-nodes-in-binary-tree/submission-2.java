class Solution {

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxValue) {

        if(node == null) {
            return 0;
        }

        int count = 0;

        // Current node is good
        if(node.val >= maxValue) {
            count = 1;
        }

        // Update maximum for children
        maxValue = Math.max(maxValue, node.val);

        // Explore left and right
        count += dfs(node.left, maxValue);
        count += dfs(node.right, maxValue);

        return count;
    }
}