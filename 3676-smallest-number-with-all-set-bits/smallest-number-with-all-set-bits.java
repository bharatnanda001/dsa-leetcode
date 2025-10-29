class Solution {
    public int smallestNumber(int n) {
        int k = Integer.toBinaryString(n).length();
        int result = (1 << k) - 1;
        return result;
    }
}
