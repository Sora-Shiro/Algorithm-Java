/*
Given two non-negative integers num1 and num2 represented as strings, 
return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length() == 1 && num1.charAt(0) == '0') return "0";
        if(num2.length() == 1 && num2.charAt(0) == '0') return "0";
        
        char[] n1 = num1.length() > num2.length() ? num1.toCharArray() : num2.toCharArray();
        char[] n2 = num1.length() <= num2.length() ? num1.toCharArray() : num2.toCharArray();
        
        int i = n1.length-1;
        int j = n2.length-1;
        
        ArrayList<StringBuilder> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int add = 0;
        
        for(j = n2.length-1; j >= 0; j--){
            int bit = (n2.length-1) - j;
            while(bit-- > 0){
                sb.append(0);
            }
            
            add = 0;
            for(i = n1.length-1; i >= 0; i--){
                int mul = (n1[i] - '0') * (n2[j] - '0') + add;
                sb.append(mul % 10);
                add = mul / 10;
            }
            if(add > 0) sb.append(add);
            
            list.add(sb.reverse());
            sb = new StringBuilder();
        }
        
        while(list.size() > 1){
            StringBuilder a = list.get(list.size()-1);
            StringBuilder b = list.get(list.size()-2);
            StringBuilder aPlusb = sum(a, b);
            list.remove(list.size()-1);
            list.remove(list.size()-1);
            list.add(aPlusb);
        }
        
        return list.get(0).toString();
        
    }
    
    private StringBuilder sum(StringBuilder a, StringBuilder b) {
        StringBuilder result = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while(i >= 0 && j >= 0){
            int add = (a.charAt(i--) - '0') + (b.charAt(j--) - '0') + carry;
            result.append(add % 10);
            carry = add / 10;
        }
        while(i >= 0) {
            int add = (a.charAt(i--) - '0') + carry;
            result.append(add % 10);
            carry = add / 10;
        }
        while(j >= 0) {
            int add = (a.charAt(j--) - '0') + carry;
            result.append(add % 10);
            carry = add / 10;
        }
        if(carry > 0) result.append(carry);
        return result.reverse();
    }
}

public class Solution_improve_faster {
    public String multiply(String num1, String num2) {
        if(num1.length() == 1 && num1.charAt(0) == '0') return "0";
        if(num2.length() == 1 && num2.charAt(0) == '0') return "0";
        
        char[] n1 = num1.length() > num2.length() ? num1.toCharArray() : num2.toCharArray();
        char[] n2 = num1.length() <= num2.length() ? num1.toCharArray() : num2.toCharArray();
        
        int i = n1.length-1;
        int j = n2.length-1;
        
        int[][] pro = new int[n2.length][n1.length+n2.length];
        
        int add;
        int mul;
        
        for(j = n2.length-1; j >= 0; j--){
            add = 0;
            
            for(i = n1.length-1; i >= 0; i--){
                mul = (n1[i] - '0') * (n2[j] - '0') + add;
                
//                pro[n2.length-1-j][n1.length+n2.length-1 - (n1.length-1-i) - (n2.length-1-j)] = mul % 10;
                pro[n2.length-1-j][i+j+1] = mul % 10;
                
                add = mul / 10;
            }
            if(add > 0) pro[n2.length-1-j][i+j+1] = add;
            
        }
        
        int[] result = new int[n1.length+n2.length];
        int window = n1.length + 1;
        
        for(i = 0; i < n2.length; i++) {
            for(j = n1.length+n2.length-1; j < n1.length+n2.length && j >= n1.length+n2.length-window; j--) {
//                result[n1.length+n2.length-1 - (n1.length+n2.length-1-j) - i] += pro[i][j-i];
                result[j-i] += pro[i][j-i];
                if(result[j-i] > 9) {
                    result[j-i-1] += result[j-i] / 10;
                    result[j-i] = result[j-i] % 10;
                }
            }
        }
        
        i = 0;
        while(result[i] == 0) i++;
        
        char[] chs = new char[result.length-i];
        
        for(j = 0; j < chs.length; j++) {
            chs[j] = (char) (result[i++] + '0');
        }
        
        return new String(chs);
        
    }
}

/*
Remember how we do multiplication?

Start from right to left, perform multiplication on every pair of digits, 
and add them together. Let's draw the process! From the following draft, 
we can immediately conclude:

 `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]` 

 pic : https://drscdn.500px.org/photo/130178585/m%3D2048/300d71f784f679d5e70fadda8ad7d68f
 */

public class Solution_better {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
       
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
    
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  
        
        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}