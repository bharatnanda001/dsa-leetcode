// rec top down + memo(top down dp)
class Solution {
    int[][]dp;
    public int longestCommonSubsequence(String a, String b) {
        dp = new int[a.length()][b.length()];
        for(int[] row: dp)Arrays.fill(row,-1);
        return solve(0,0,a,b);      
    }
    private int solve(int i , int j, String a, String b){
        if(i ==a.length()|| j == b.length())return 0;
        if(dp[i][j] != -1)return dp[i][j];
        if(a.charAt(i)==b.charAt(j))
            return dp[i][j] =1+solve(i+1, j+1, a, b);
            return dp[i][j] = Math.max(solve(i+1,j,a,b),solve(i,j+1,a,b));
    }
}