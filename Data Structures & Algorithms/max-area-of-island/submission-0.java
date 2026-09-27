class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i = 0;  i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    //System.out.println("Starting at " + i + ", " + j);
                    int area = traverse(grid, i, j, visited);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private int traverse(final int[][] grid, int x, int y, boolean[][] visited) {
        int[][] directions = new int[][]{{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || visited[x][y] == true) {
            return 0;
        }

        //System.out.println("Visiting " + x + ", " + y);
        visited[x][y] = true;
        int totalArea = 1;
        for (int[] d: directions) {
            totalArea += traverse(grid, x + d[0], y + d[1], visited);
        }

        return totalArea;
    }
}

