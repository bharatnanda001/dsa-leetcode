class Solution {
    public long getDescentPeriods(int[] prices) {
        //price[i]- price[i+1]==1
        long ans =0; 
        long dp =0;
        for(int i =0; i<prices.length;i++){
            if(i>0 && prices[i-1]-prices[i]==1){
                dp++;
            }else{
                dp =1;

            }
            ans +=dp;
        }
        return ans;
    }
}