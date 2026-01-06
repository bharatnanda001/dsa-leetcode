class Solution {
    Integer[][][][][]dp;
    static final int len =11;
    static final int nmask =1024;
    public int numDupDigitsAtMostN(int n) {
        String s = String.valueOf(n);
        dp = new Integer[11][2][2][nmask][2];
        return solve(s,0,1,0,0,1);
        
        
    }
    public int solve(String s, int idx, int tight, int repeated, int mask, int lz ){
        if(idx== s.length()){
            return repeated;
        }
        if(dp[idx][tight][repeated][mask][lz]!=null){
            return dp[idx][tight][repeated][mask][lz];
        }
        int lb =0;
        int ub =(tight==1)?s.charAt(idx)-'0':9;
        int res = 0;
        for(int digit =lb; digit<= ub; digit++){
            int newTight = (tight ==1 && digit ==ub)?1:0;
            if(lz==1 && digit ==0){
                res += solve(s, idx+1, newTight, repeated , mask, lz);
            }else{
                int isDigitused = 1 &(mask >>digit);
                int newRepeated =(repeated==1 || isDigitused==1)?1:0;
                int newMask= ((1<<digit)|mask);
                res += solve(s,idx+1,newTight, newRepeated, newMask,0);
            }
        }
        dp[idx][tight][repeated][mask][lz] =res;
        return res;
    }
}