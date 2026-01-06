class Solution {
    Integer [][][]dp;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int mask =0;
        for(int i =0; i<digits.length;i++){
            int digit = Integer.parseInt(digits[i]);
            mask = mask|1<<digit;//entry hogi ni to ni hogi .

        } 
        String s = String.valueOf(n);
        dp = new Integer[s.length()][2][2]; 
        return solve(s,0,1,1,mask)-1;
    }
    public int solve(String s, int idx, int tight,int lz ,int mask){
        if(idx==s.length()){
            return 1;

        }
        if(dp[idx][tight][lz]!=null){
            return dp[idx][tight][lz];
        }
        int lb =0;
        int ub =(tight ==1)?s.charAt(idx)-'0':9;
        int res =0;
        for(int digit =lb ;digit<=ub; digit++){
            int newTight =(tight==1&& digit == ub)?1:0;
            if(lz==1 &&digit ==0){
                res +=solve(s,idx+1,newTight,lz,mask);
            }else{
            int isDigitused= ((mask>> digit)&1);
            if(isDigitused==0){
                continue;
            }else{
                res += solve(s, idx+1, newTight,0,mask);
            }
            }
        }
        return dp[idx][tight][lz]= res;
    }
}