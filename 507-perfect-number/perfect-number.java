class Solution {
    public boolean checkPerfectNumber(int num) {
       /* int total =0;
        int temp = num;
        for(int i =1; i<= num/2;i++){
            if(num %i==0) total +=i;
        }
        return (total == temp);*/
        int n = num;
        if(n <=1)return false;
        int sum =1;
        for(int i =2;i<= Math.sqrt(n);i++){
            if(n %i ==0){
                sum+=i;
                if(i != n/i)
                    sum += n/i;
            }
        }
        return sum ==n;
    }
}