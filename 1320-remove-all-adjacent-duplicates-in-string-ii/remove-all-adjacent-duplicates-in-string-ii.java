import java.util.Stack;

class Solution {
    public String removeDuplicates(String s, int k) {
        class Pair {
            char ch;
            int count;
            Pair(char ch, int count) {
                this.ch = ch;
                this.count = count;
            }
        }

        Stack<Pair> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && st.peek().ch == ch) {
                st.peek().count++;
                if (st.peek().count == k) {
                    st.pop();
                }
            } else {
                st.push(new Pair(ch, 1));
            }
        }

        // Build the final string
        StringBuilder sb = new StringBuilder();
        for (Pair p : st) {
            for (int i = 0; i < p.count; i++) {
                sb.append(p.ch);
            }
        }

        return sb.toString();
    }
}
