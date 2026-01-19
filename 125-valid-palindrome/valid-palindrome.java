class Solution {
    public boolean isPalindrome(String s) {
        return helper(s, 0, s.length() - 1);
    }

    private boolean helper(String s, int l, int r) {
        while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
        while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
        if (l >= r) return true;
        if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
            return false;
        }
        return helper(s, l + 1, r - 1);
    }
}
