class Solution {
    private final int[][] DIRS = { {1,0}, {-1,0}, {0,1}, {0,-1} };
    private int m, n;
    private int[][] heights;
    private boolean[][] pacificReach, atlanticReach;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        if (m == 0) return new ArrayList<>();
        n = heights[0].length;

        pacificReach = new boolean[m][n];
        atlanticReach = new boolean[m][n];

        // From Pacific side: top row & left column
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacificReach);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacificReach);
        }

        // From Atlantic side: bottom row & right column
        for (int i = 0; i < m; i++) {
            dfs(i, n-1, atlanticReach);
        }
        for (int j = 0; j < n; j++) {
            dfs(m-1, j, atlanticReach);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificReach[i][j] && atlanticReach[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] reach) {
        if (reach[r][c]) return;
        reach[r][c] = true;
        for (int[] d: DIRS) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
            if (reach[nr][nc]) continue;
            if (heights[nr][nc] < heights[r][c]) continue;  // only go uphill
            dfs(nr, nc, reach);
        }
    }
}
