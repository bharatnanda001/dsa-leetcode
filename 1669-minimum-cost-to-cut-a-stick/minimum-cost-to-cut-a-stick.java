class Solution {
    Integer[][] dp;
    public int minCost(int n, int[] cuts) {
        int[] newCut = new int[cuts.length+2];
        newCut[0]= 0;
        newCut[newCut.length-1]= n;
        Arrays.sort(cuts);
        dp = new Integer[newCut.length][newCut.length];
        for(int i =0;i<cuts.length;i++){
            newCut[i+1]= cuts[i];
        }        
        return solve(1,cuts.length , newCut);
    }
    public int solve(int i , int j , int[] arr){
        if(i >j) return 0;
        if(dp[i][j] != null)return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int idx =i; idx <= j; idx++){
            int cost = arr[j+1]-arr[i-1]+solve(i, idx-1,arr)+solve(idx+1, j ,arr);
            mini = Math.min(mini, cost);
        }
        return dp[i][j]= mini;
    }
}