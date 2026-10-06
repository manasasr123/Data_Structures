import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        // 0 = not colored
        // 1 = group 1
        // -1 = group 2
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {

            // Handle disconnected components
            if (color[i] != 0) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();

            queue.offer(i);
            color[i] = 1;

            while (!queue.isEmpty()) {

                int node = queue.poll();

                for (int neighbor : graph[node]) {

                    // Not colored yet
                    if (color[neighbor] == 0) {

                        color[neighbor] = -color[node];

                        queue.offer(neighbor);
                    }

                    // Same color as current node
                    else if (color[neighbor] == color[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}