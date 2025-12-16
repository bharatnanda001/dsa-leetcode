
class Solution {
    private List<Integer>[] tree;
    private int[] present;
    private int[] future;
    private int budget;
    private Map<String, int[][]> memo = new HashMap<>();
    
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        // Initialize tree
        this.tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        // Build tree
        for (int[] edge : hierarchy) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            tree[u].add(v);
        }
        
        this.present = present;
        this.future = future;
        this.budget = budget;
        
        int[][] result = dfs(0, -1);
        int max = 0;
        for (int val : result[0]) {
            max = Math.max(max, val);
        }
        return max;
    }
    
    private int[][] dfs(int node, int parent) {
        String key = node + "," + parent;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int[] noDiscount = new int[budget + 1];
        int[] withDiscount = new int[budget + 1];
        
        // Process children
        for (int child : tree[node]) {
            if (child == parent) continue;
            
            int[][] childResult = dfs(child, node);
            noDiscount = merge(noDiscount, childResult[0]);
            withDiscount = merge(withDiscount, childResult[1]);
        }
        
        int[] newDp0 = Arrays.copyOf(noDiscount, budget + 1);
        int[] newDp1 = Arrays.copyOf(noDiscount, budget + 1);
        
        // Buy at full price
        int fullCost = present[node];
        if (fullCost <= budget) {
            for (int b = fullCost; b <= budget; b++) {
                int profit = future[node] - fullCost;
                newDp0[b] = Math.max(newDp0[b], withDiscount[b - fullCost] + profit);
            }
        }
        
        // Buy at half price (with discount)
        int halfCost = present[node] / 2;
        if (halfCost <= budget) {
            for (int b = halfCost; b <= budget; b++) {
                int profit = future[node] - halfCost;
                newDp1[b] = Math.max(newDp1[b], withDiscount[b - halfCost] + profit);
            }
        }
        
        int[][] result = new int[][]{newDp0, newDp1};
        memo.put(key, result);
        return result;
    }
    
    private int[] merge(int[] dpA, int[] dpB) {
        int[] merged = new int[budget + 1];
        Arrays.fill(merged, Integer.MIN_VALUE);
        
        for (int i = 0; i <= budget; i++) {
            if (dpA[i] < 0) continue;
            for (int j = 0; i + j <= budget; j++) {
                if (dpB[j] < 0) continue;
                merged[i + j] = Math.max(merged[i + j], dpA[i] + dpB[j]);
            }
        }
        return merged;
    }
}