class Solution {
    Integer []dp;
    public boolean isPalindrom(int i, int j , String s){
        while(i<j){
            if(s.charAt(i)!= s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public int minCut(String s) {
        dp = new Integer[s.length()];
        return solve(0,s)-1;
        
    }
    public int solve(int i , String s){
        if( i ==s.length()){
            return 0;
        }
        if(dp[i] != null) return dp[i];
        int mini = Integer.MAX_VALUE;
        for(int j=i; j<s.length();j++){
            if(isPalindrom(i,j,s)==true){
                int cost = 1+solve(j+1,s);
                mini = Math.min(mini,cost );
            }
        }
        return dp[i]= mini;
    }
}