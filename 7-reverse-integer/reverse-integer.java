class Solution {
    public int reverse(int x) {
        return reverseHelper(x, 0);
    }

    private int reverseHelper(int x, int rev) {
        if (x == 0) return rev;

        int digit = x % 10;

        if (rev > Integer.MAX_VALUE / 10 || 
           (rev == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
        if (rev < Integer.MIN_VALUE / 10 || 
           (rev == Integer.MIN_VALUE / 10 && digit < -8)) return 0;

        return reverseHelper(x / 10, rev * 10 + digit);
    }
}
