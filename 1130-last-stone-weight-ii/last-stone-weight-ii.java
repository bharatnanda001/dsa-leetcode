class Solution {//sum = j 
    int total;
    Integer[][] memo;
    int dfs(int[] stones , int i , int j ){
        if(i ==stones.length)
            return Math.abs(total-2*j);
        if(memo[i][j] != null)
            return memo[i][j];
            int take = dfs(stones,i+1, j+stones[i]);
            int skip = dfs(stones, i+1, j);
            return memo[i][j]= Math.min(take,skip);
    }
    public int lastStoneWeightII(int[] stones) {
        total =0; 
        for(int s :stones)total +=s;
        memo  = new Integer[stones.length][total+1];
        return dfs(stones,0,0);
    }
}