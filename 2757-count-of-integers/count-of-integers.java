class Solution {
    int min, max;
    static final int MOD = 1_000_000_007;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        min = min_sum;
        max = max_sum;
        StringBuilder sb1 = new StringBuilder(num1);
        int i = sb1.length() - 1;
        while(i >= 0 && sb1.charAt(i) == '0'){
            sb1.setCharAt(i, '9');
            i--;
        }
        sb1.setCharAt(i, (char)(sb1.charAt(i) - 1));
        Integer[][][] dp1 = new Integer[num1.length()][2][199];
        Integer[][][] dp2 = new Integer[num2.length()][2][199];
        int ans = solve(num2, 0, 1, 0, dp2) - solve(sb1.toString(), 0, 1, 0, dp1);
        return (ans < 0) ? ans += MOD : ans;
    }
    public int solve(String s, int idx, int tight, int sum, Integer[][][] dp){
        if (idx == s.length()){
            return check(sum) ? 1 : 0;
        }
        
        if (dp[idx][tight][sum] != null){
            return dp[idx][tight][sum];
        }
        int res = 0;
        int ub = (tight == 1) ? s.charAt(idx) - '0' : 9;

        for (int digit = 0; digit <= ub; digit++) {
            
            int newTight = (tight == 1 && digit == ub) ? 1 : 0;
            
            res =  (res + solve(s, idx + 1, newTight, sum + digit, dp))% MOD;
        }
        return dp[idx][tight][sum] = res;
    }
    public boolean check(int sum){
        if(sum >= min && sum <= max){
            return true;
        }return false;
    }
}