class Solution {
    public int fib(int n) {
        //fiba(0) =, fib(1) = yeh base case ha 
        //recussive case = fib(n)= fib(n-1)+ fib(n-2) yrh ha recrsibe case 
        if( n==0) return 0;
        if(n ==1) return 1;
        return fib(n-1)+ fib(n-2);

        
    }
}