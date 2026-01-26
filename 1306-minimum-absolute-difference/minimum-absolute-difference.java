class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1 ; i<n; i++){
            int diff = arr[i]-arr[i-1];
            if(diff<minDiff){
                minDiff=diff;
                result = new ArrayList<>();
                result.add(Arrays.asList(arr[i-1],arr[i]));

            }else if (diff== minDiff){
                result.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return result;
    }
}