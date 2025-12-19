class Solution {
    public int maximumWealth(int[][] a) {
        int max = 0;
        for (int[] r : a) { int s = 0; for (int x : r) s += x; max = Math.max(max, s); }
        return max;
    }
}
