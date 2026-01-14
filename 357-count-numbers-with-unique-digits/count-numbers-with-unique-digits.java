import java.util.*;

public class Solution {

    static String limit;
    static Integer[][][] dp;

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        limit = String.valueOf((int) Math.pow(10, n) - 1);
        int len = limit.length();
        dp = new Integer[len][1 << 10][2];

        return solve(0, 0, 1);
    }

    private static int solve(int pos, int mask, int tight) {

        if (pos == limit.length()) {
            return 1; 
        }

        if (dp[pos][mask][tight] != null) {
            return dp[pos][mask][tight];
        }

        int res = 0;
        int ub = tight == 1 ? limit.charAt(pos) - '0' : 9;

        for (int digit = 0; digit <= ub; digit++) {

            int newTight = (tight == 1 && digit == ub) ? 1 : 0;

            if (mask == 0 && digit == 0) {
                res += solve(pos + 1, mask, newTight);
            } 
            
            else if ((mask & (1 << digit)) != 0) {
                continue;
            } 
            else {
                res += solve(pos + 1, mask | (1 << digit), newTight);
            }
        }

        return dp[pos][mask][tight] = res;
    }

   
}
