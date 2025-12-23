import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        int[] h = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            h[i] = envelopes[i][1];
        }

        ArrayList<Integer> lis = new ArrayList<>();
        for (int x : h) {
            int idx = Collections.binarySearch(lis, x);
            if (idx < 0) idx = -(idx + 1);
            if (idx == lis.size()) lis.add(x);
            else lis.set(idx, x);
        }
        return lis.size();
    }
}
