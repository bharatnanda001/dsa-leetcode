class Solution {

    String s;
    Integer[][][] dp;

    public int countDigitOne(int n) {
        s = String.valueOf(n);
        int len = s.length();
        dp = new Integer[len][2][len + 1];
        return solve(0, 1, 0);
    }

    private int solve(int idx, int tight, int countOne) {

        if (idx == s.length()) {
            return countOne;
        }

        if (dp[idx][tight][countOne] != null) {
            return dp[idx][tight][countOne];
        }

        int res = 0;
        int ub = (tight == 1) ? s.charAt(idx) - '0' : 9;

        for (int digit = 0; digit <= ub; digit++) {
            int newTight = (tight == 1 && digit == ub) ? 1 : 0;

            if (digit == 1) {
                res += solve(idx + 1, newTight, countOne + 1);
            } else {
                res += solve(idx + 1, newTight, countOne);
            }
        }

        return dp[idx][tight][countOne] = res;
    }
}
