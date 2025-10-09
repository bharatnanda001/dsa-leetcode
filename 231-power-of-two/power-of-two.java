class Solution {
    public boolean isPowerOfTwo(int n) {
        // base case hoga if n ==1 return true hoga; n<=0 retrun false hona;
        if(n==1) return true;
        if(n==0 || n%2 !=0)return false;
        return isPowerOfTwo(n/2);
        
    }
}