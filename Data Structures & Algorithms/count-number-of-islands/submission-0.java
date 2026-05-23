class Solution {
    public int numIslands(char[][] grid) { 
        int n = grid.length, m = grid[0].length;
        int visited[][] = new int[n][m];
        int island_count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1' && visited[i][j] == 0) {
                    markVisited(grid, visited, i, j);
                    island_count++;
                }
            }
        }

        return island_count;
    }

    private boolean isSafe(char[][] grid, int i, int j, int[][] visited) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1' && visited[i][j] == 0;
    }

    private void markVisited(char[][] grid, int visited[][], int i, int j) {
        visited[i][j] = 1;
        int[][] directions = {
            {0, -1},
            {-1, 0},
            {0, 1},
            {1, 0}
        };

        for(int k = 0; k < 4; k++) {
            int new_i = i + directions[k][0];
            int new_j = j + directions[k][1];
            if (isSafe(grid, new_i, new_j, visited)) {
                markVisited(grid, visited, new_i, new_j);
            }
        }
    }
}
