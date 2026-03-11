class Solution {
    public int hammingWeight(int n) {
        
        int once =0;
        while(n != 0){
            once = once +(n &1);
            n = n>>>1;
        }
        return once;
    }
}