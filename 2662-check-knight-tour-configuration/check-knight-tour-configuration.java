class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        
        if (grid[0][0] != 0) return false;

        int[][] moves = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };

        int row = 0, col = 0;

        for (int num = 1; num < n * n; num++) {
            boolean found = false;

            for (int[] m : moves) {
                int nr = row + m[0];
                int nc = col + m[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n &&
                    grid[nr][nc] == num) {
                    row = nr;
                    col = nc;
                    found = true;
                    break;
                }
            }

            if (!found) return false;
        }

        return true;
    }
}
