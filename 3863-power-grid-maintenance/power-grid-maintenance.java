import java.util.*;

class Solution {

    // FIX 1: Define DSU as a static inner class
    static class DSU {
        int[] parent;
        TreeSet<Integer>[] onlineStations;

        @SuppressWarnings("unchecked")
        public DSU(int n) {
            parent = new int[n + 1];
            onlineStations = new TreeSet[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                onlineStations[i] = new TreeSet<>();
                onlineStations[i].add(i);
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (onlineStations[rootX].size() < onlineStations[rootY].size()) {
                    // Swap to ensure rootX is the larger/new root
                    int tempRoot = rootX;
                    rootX = rootY;
                    rootY = tempRoot;
                }

                parent[rootY] = rootX;
                onlineStations[rootX].addAll(onlineStations[rootY]);
                onlineStations[rootY] = null;
            }
        }
    }

    // FIX 2: Change return type to int[] and convert List to array
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // 1. Initialization
        DSU dsu = new DSU(c);
        for (int[] conn : connections) {
            dsu.union(conn[0], conn[1]);
        }
        
        boolean[] isOnline = new boolean[c + 1];
        Arrays.fill(isOnline, true);
        
        List<Integer> results = new ArrayList<>();
        
        // 2. Process Queries
        for (int[] query : queries) {
            int type = query[0];
            int station = query[1];
            
            if (type == 1) { // Type 1: Maintenance Check
                if (isOnline[station]) {
                    results.add(station);
                } else {
                    int root = dsu.find(station);
                    TreeSet<Integer> set = dsu.onlineStations[root];
                    
                    if (set.isEmpty()) {
                        results.add(-1);
                    } else {
                        results.add(set.first());
                    }
                }
            } else { // Type 2: Go Offline
                if (isOnline[station]) {
                    isOnline[station] = false;
                    
                    int root = dsu.find(station);
                    if (dsu.onlineStations[root] != null) {
                         dsu.onlineStations[root].remove(station);
                    }
                }
            }
        }
        
        // Convert List<Integer> to int[]
        return results.stream().mapToInt(i -> i).toArray();
    }
}