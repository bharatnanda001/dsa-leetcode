class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum =0;
        long reduction =0;
        for(int i = happiness.length-1; i>=0 && k >0;i--){
            long current = happiness[i]- reduction;
            if(current >0){
                sum += current;
            }
            reduction++;
            k--;
        }
        return sum;
    }
}