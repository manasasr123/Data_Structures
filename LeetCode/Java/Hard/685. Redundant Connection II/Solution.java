
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int[] first = null;
        int[] second = null;
        int skip = -1;

        // Find a node with two parents
        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (parent[v] != v) {
                first = new int[]{parent[v], v};
                second = edges[i];
                skip = i;
            } else {
                parent[v] = u;
            }
        }

        // Reset DSU
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Detect cycle, skipping the second candidate
        for (int i = 0; i < n; i++) {
            if (i == skip) {
                continue;
            }

            int u = edges[i][0];
            int v = edges[i][1];

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            if (rootU == rootV) {
                if (first == null) {
                    return edges[i];
                }
                return first;
            }

            parent[rootV] = rootU;
        }

        return second;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
