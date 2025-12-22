class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int[] dp = new int[cols];
        Arrays.fill(dp,1);
        int maxKeep=1;
        for(int j =0; j<cols; j++){
            for(int i =0; i<j;i++){
                boolean valid = true;
                for(int r=0; r<rows;r++){
                    if(strs[r].charAt(i)>strs[r].charAt(j)){
                        valid=false;
                        break;
                    }
                }
                if(valid){
                    dp[j] =Math.max(dp[j],dp[i]+1);
                }
            }
            maxKeep= Math.max(maxKeep,dp[j]);
        } 
        return cols- maxKeep;
    }
}