class Solution {
    public int numOfSubarrays(int[] arr) {
        int curr =0;
        int res =0;
        int count[] ={1, 0}, mod =(int)1e9+7;
        for(int a:arr){
            curr ^=a &1;
            res =(res+ count[1-curr])%mod;
            count[curr]++;
        }        
        return res;
    }
}