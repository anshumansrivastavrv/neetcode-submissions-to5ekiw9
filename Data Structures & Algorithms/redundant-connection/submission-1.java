class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        // Initially, every node is its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int parentU = find(parent, u);
            int parentV = find(parent, v);

            // Already connected -> this edge creates a cycle
            if (parentU == parentV) {
                return edge;
            }

            // Union
            parent[parentU] = parentV;
        }

        return new int[]{};
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }
}