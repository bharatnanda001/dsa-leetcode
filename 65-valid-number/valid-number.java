class Solution {
    public boolean isNumber(String s) {
        if (s == null) return false;
        s = s.trim();
        if (s.length() == 0) return false;

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;
        boolean digitAfterExp = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                seenDigit = true;
                if (seenExp) digitAfterExp = true;

            } else if (c == '+' || c == '-') {
                if (i != 0) {
                    char prev = s.charAt(i - 1);
                    if (prev != 'e' && prev != 'E') return false;
                }

            } else if (c == 'e' || c == 'E') {
                if (seenExp || !seenDigit) return false;
                seenExp = true;
                digitAfterExp = false;

            } else if (c == '.') {
                if (seenDot || seenExp) return false;
                seenDot = true;

            } else {
                return false;
            }
        }

        return seenDigit && digitAfterExp;
    }
}
