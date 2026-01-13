class Solution {
    int[][] dp;
    public int palindromePartition(String s, int k) {
        int n=s.length();
        if(n==k) return 0;
        dp = new int[n][k+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return helper(s,k,0,n);
    }
    private int helper(String s,int k,int idx,int n){
        if(idx==n&&k==0) return 0;
        if(n-idx < k ||idx>=n || k<0) return Integer.MAX_VALUE-200;
        if(dp[idx][k]!=-1) return dp[idx][k];
        int min = Integer.MAX_VALUE-200;
        for(int i=idx;i<n;i++) min = Math.min(min,minimumCount(s.substring(idx,i+1))+helper(s,k-1,i+1,n));
        return dp[idx][k]=min;
    }

    private int minimumCount(String s){
        int l=0,e=s.length()-1,count=0;
        while(l<e) if(s.charAt(l++) != s.charAt(e--)) count++;
        return count;
    }
}