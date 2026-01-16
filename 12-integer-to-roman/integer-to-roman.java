class Solution {
    public String intToRoman(int num) {
        String[] once= {"","I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String[] tens ={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"};
        String[] hundred={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM","M"};
        String[] thounsand={"","M","MM","MMM"};
        return thounsand[num/1000]+hundred[(num%1000)/100]+tens[(num%100)/10]+once[num%10];
        
    }
}