class Solution {
    String s1, s2, s3;
    Boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        dp = new Boolean[s1.length()+1][s2.length()+1];
        return dfs(0, 0);
    }

    boolean dfs(int i, int j) {
        if (i == s1.length() && j == s2.length()) return true;
        if (dp[i][j] != null) return dp[i][j];

        boolean ok = false;
        int k = i + j;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
            ok |= dfs(i + 1, j);

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k))
            ok |= dfs(i, j + 1);

        return dp[i][j] = ok;
    }
}
