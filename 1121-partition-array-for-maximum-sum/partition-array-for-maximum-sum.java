class Solution {
    int n;
    Integer[] dp;;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        n = arr.length;
        dp = new Integer[n];
        return solve(0,k,arr); 
    }
    public int solve(int idx, int k, int[] arr){
        if(idx ==n){
            return 0;
        }
        if(dp[idx] != null) return dp[idx];
        int len =0;
        int maxI=Integer.MIN_VALUE;
        int maxArray= Integer.MIN_VALUE;
        for(int i = idx; i <Math.min(n,idx+k);i++){
            len++;
            maxI= Math.max(arr[i],maxI);
            int cost = maxI * len+solve(i+1,k, arr);
            maxArray= Math.max(maxArray,cost);
        }
        return dp[idx]= maxArray; 
    }
}
