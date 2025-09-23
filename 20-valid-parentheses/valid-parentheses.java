import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> St = new Stack<>();
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                St.push(')');
            } else if (ch == '{') {
                St.push('}');
            } else if (ch == '[') {
                St.push(']');
            } else {
                if (St.isEmpty() || St.pop() != ch) {
                    return false;
                }
            }
        }
        
        return St.isEmpty();
    }
}
