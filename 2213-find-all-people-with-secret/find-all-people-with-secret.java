class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a,b) -> a[2]-b[2]);
        boolean[] know = new boolean[n];
        know[0] = know[firstPerson] = true;

        for (int i = 0; i < meetings.length;) {
            int t = meetings[i][2];
            Map<Integer, List<Integer>> g = new HashMap<>();
            Set<Integer> people = new HashSet<>();

            while (i < meetings.length && meetings[i][2] == t) {
                int a = meetings[i][0], b = meetings[i][1];
                g.computeIfAbsent(a, k->new ArrayList<>()).add(b);
                g.computeIfAbsent(b, k->new ArrayList<>()).add(a);
                people.add(a); people.add(b);
                i++;
            }

            Queue<Integer> q = new ArrayDeque<>();
            for (int p : people)
                if (know[p]) q.offer(p);

            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : g.getOrDefault(u, List.of()))
                    if (!know[v]) {
                        know[v] = true;
                        q.offer(v);
                    }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (know[i]) ans.add(i);
        return ans;
    }
}
