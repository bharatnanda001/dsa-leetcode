class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        int []prev =new int[n];
        for(int j =0; j<n; j++){
            prev[j]= t.get(n-1).get(j);
        }       
        for(int i = n-2; i >=0;i--){
            int []curr = new int[n];
            for(int j =i; j>=0; j--){
                int down = prev[j] + t.get(i).get(j);
                int diagonal= prev[j+1]+t.get(i).get(j);
                curr[j]= Math.min(down,diagonal);

            }
            prev = curr;
            
        }
        return prev[0];
    }
}