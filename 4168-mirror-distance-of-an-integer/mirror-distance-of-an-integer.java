class Solution {
    public int mirrorDistance(int n) {
        int o = n;
        int m =0;
        while(n!=0){
            m = m*10+(n%10);
            n = n/10;
            
            
        }
        return Math.abs(o-m);
    }
}