class Solution {
    public int numSub(String s) {
        final int MOD = 1_000_000_007;

        long ans = 0;
        int l = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                l = i;  // reset
            ans = (ans + (i - l)) % MOD;
        }

        return (int) ans;
    }
}
