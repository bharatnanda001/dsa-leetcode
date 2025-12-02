
class Solution {
    static final long MOD = 1_000_000_007L;

    public int countTrapezoids(int[][] points) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] p : points) {
            map.put(p[1], map.getOrDefault(p[1], 0) + 1);
        }

        ArrayList<Long> pairs = new ArrayList<>();
        for (int cnt : map.values()) {
            if (cnt >= 2) {
                long ways = (long) cnt * (cnt - 1) / 2;
                pairs.add(ways % MOD);
            }
        }

        if (pairs.size() < 2) return 0;
        long result = 0;
        long prefix = 0;

        for (long x : pairs) {
            result = (result + x * prefix) % MOD;
            prefix = (prefix + x) % MOD;
        }

        return (int) result;
    }
}
