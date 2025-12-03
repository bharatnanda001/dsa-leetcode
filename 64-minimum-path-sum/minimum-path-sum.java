class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] memo = new Integer[m][n];
        return dfs(m-1, n-1, grid, memo);
    }

    private int dfs(int i, int j, int[][] grid, Integer[][] memo) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE / 2;

        if (i == 0 && j == 0) return grid[0][0];
        if (memo[i][j] != null) return memo[i][j];

        int up = dfs(i-1, j, grid, memo);
        int left = dfs(i, j-1, grid, memo);
        memo[i][j] = grid[i][j] + Math.min(up, left);
        return memo[i][j];
    }
}

