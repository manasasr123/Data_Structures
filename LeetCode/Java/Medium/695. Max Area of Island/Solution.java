class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int row, int col) {

        // Out of bounds or water
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == 0) {
            return 0;
        }

        // Mark as visited
        grid[row][col] = 0;

        int area = 1;

        area += dfs(grid, row - 1, col); // up
        area += dfs(grid, row + 1, col); // down
        area += dfs(grid, row, col - 1); // left
        area += dfs(grid, row, col + 1); // right

        return area;
    }
}