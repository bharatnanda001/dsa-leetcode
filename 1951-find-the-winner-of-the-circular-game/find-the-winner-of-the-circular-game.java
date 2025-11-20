class Solution {
    public int findTheWinner(int n, int k) {
        int res =helper(n, k);
        return res+1;
    }
    int helper(int n , int k){
        if(n ==1) return 0;
        int ans =(helper(n-1,k)+k)%n;
        return ans;

        
    }
}