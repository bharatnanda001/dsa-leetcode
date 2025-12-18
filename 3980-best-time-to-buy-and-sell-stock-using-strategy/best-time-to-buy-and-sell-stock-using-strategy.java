class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long base = 0;
        long[] A = new long[n];
        long[] B = new long[n];

        for (int i = 0; i < n; i++) {
            A[i] = (long) strategy[i] * prices[i];
            B[i] = prices[i] - A[i];
            base += A[i];
        }

        long[] preA = new long[n + 1];
        long[] preB = new long[n + 1];

        for (int i = 0; i < n; i++) {
            preA[i + 1] = preA[i] + A[i];
            preB[i + 1] = preB[i] + B[i];
        }

        long bestGain = 0;
        int half = k / 2;

        for (int l = 0; l + k <= n; l++) {
            int mid = l + half;
            int r = l + k;

            long loss = -(preA[mid] - preA[l]);
            long gain = preB[r] - preB[mid];

            bestGain = Math.max(bestGain, loss + gain);
        }

        return base + bestGain;
    }
}
