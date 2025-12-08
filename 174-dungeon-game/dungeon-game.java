class Solution {
    public int calculateMinimumHP(int[][] power) {
        int m = power.length;
        int n = power[0].length;
        int[][]dp = new int[m][n];
        for(int i= m-1; i>=0;i--){
            for(int j = n-1;j>=0;j--){
                if(i ==m-1 && j == n-1){
                    if(power[i][j]>0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j]= Math.abs(power[i][j])+1;
                    }
                }
                else{
                    int down =(i+1>=m)?(int)1e9:dp[i+1][j];
                    int right =(j +1>=n)?(int)1e9:dp[i][j+1];
                    int need = Math.min(down,right)-power[i][j];
                    dp[i][j]=(need<=0)?1:need;
                }
            }
        }
        return dp[0][0];
    }
}