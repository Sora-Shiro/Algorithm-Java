/*
Implement pow(x, n).
 */

public class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        if(n == 1 || x == 1) return x;
        if(x == -1) return (n&1) == 0 ? 1 : -1; 
        
        int total = Math.abs(n);
        double mul = n < 0 ? 1/x : x;
        double result = 1;
        
        int count;
        
        while(total != 0){
            count = 1;
            double temp = mul;
            while(count+count <= total){
                temp *= temp;
                count += count;
                if(temp == 0 || count == 0) return 0;
            }
            result *= temp;
            total -= count;
        }
        
        return result;
    }
}