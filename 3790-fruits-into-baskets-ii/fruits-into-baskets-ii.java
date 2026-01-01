class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n];
        int unplaced =0;
        for(int f : fruits){
            boolean placed = false;
            for(int j =0; j<n; j++){
                if(!used[j] && baskets[j]>=f){
                    used[j]=true;
                    placed = true;
                    break;
                }
            }
            if(!placed){
                unplaced++;
            }
        }
        return unplaced;
    }
}