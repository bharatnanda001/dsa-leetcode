class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        Integer[][] memo = new Integer[n][n];
        return memoHelper(s,0,n-1,memo);
    }
    private int memoHelper(String s, int i, int j, Integer[][] memo){
        if(i>j) return 0;
        if(i ==j)return 1;
        if(memo[i][j] != null){
            return memo[i][j];
        }
        int result;
        if(s.charAt(i)== s.charAt(j)){
            result =2+ memoHelper(s,i+1,j-1,memo);
        }else{
            result = Math.max(memoHelper(s,i+1,j, memo),memoHelper(s,i,j-1,memo));
        }
        memo[i][j] =result;
        return result;
    }
}