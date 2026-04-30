class Solution {
    fun maxPathScore(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size
        val k = Math.min(k, m + n - 2)
        val dp = Array(n + 1) { IntArray(k + 1) { -1_000 } }
        dp[1][0] = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                val score = grid[i][j]
                val cost = if (score == 0) 0 else 1
                val l = dp[j]
                val c = dp[j + 1]
                for (h in k downTo 0)
                    c[h] = if (h - cost >= 0) Math.max(c[h - cost], l[h - cost]) + score else -1_000
            }
        }
        var res = -1
        for (h in 0..k)
            res = Math.max(res, dp[n][h])
        return res
    }
}