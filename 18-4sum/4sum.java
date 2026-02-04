class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num == null || num.length <4){
            return res;
        }
        int n= num.length;
        Arrays.sort(num);
        for(int i =0; i <n-3;i++ ){
            if(i >0 && num[i]==num[i-1])continue;
            for(int j =i +1; j<n-2; j++){
                if(j >i+1 && num[j]== num[j-1])continue;
                long target_2 =(long)target - num[j]-num[i];
                int fr = j+1;
                int bc = n -1;
                while(fr<bc){
                    long two_sum =(long)num[fr]+num[bc];
                    if(two_sum<target_2)fr++;
                    else if(two_sum >target_2)bc--;
                    else{
                        List<Integer> quad = new ArrayList<>();
                        quad.add(num[i]);
                        quad.add(num[j]);
                        quad.add(num[fr]);
                        quad.add(num[bc]);
                        res.add(quad);
                        while(fr < bc && num[fr]==quad.get(2))++fr;
                        while(fr<bc && num[bc]==quad.get(3))--bc;
                    }
                }
                while(j +1<n && num[j+1]== num[j])++j;
            }
            while(i +1<n && num[i+1]== num[i])++i;
        }
        return res;
    }
}