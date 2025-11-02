class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // 0 empty, -1 wall, 2 guard, 1 guarded
        int[][] grid = new int[m][n];
        for (int[] w : walls) grid[w[0]][w[1]] = -1;
        for (int[] g : guards) grid[g[0]][g[1]] = 2;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] g : guards) {
            int r = g[0], c = g[1];
            for (int[] d : dirs) {
                int rr = r + d[0], cc = c + d[1];
                while (rr >= 0 && rr < m && cc >= 0 && cc < n) {
                    if (grid[rr][cc] == -1 || grid[rr][cc] == 2) break;
                    if (grid[rr][cc] == 0) grid[rr][cc] = 1;
                    rr += d[0];
                    cc += d[1];
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] == 0) ans++;
        return ans;
    }
}
