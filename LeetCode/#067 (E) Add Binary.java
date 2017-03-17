/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */

public class Solution {
    int carry = 0;
    StringBuilder sb = new StringBuilder();
    
    private void add(int aBit, int bBit) {
        int sumBit = aBit + bBit + carry;
        if(sumBit >= 2){
            sb.append(sumBit - 2);
            carry = 1;
        } else {
            sb.append(sumBit);
            carry = 0;
        }
    }
    
    public String addBinary(String a, String b) {
        int i = 0;
        for(; i < a.length() && i < b.length(); i++){
            add(a.charAt(a.length()-i-1) - '0', b.charAt(b.length()-i-1) - '0');
        }
        while(i < a.length()){
            add(a.charAt(a.length()-i-1) - '0', 0);
            i++;
        }
        while(i < b.length()){
            add(b.charAt(b.length()-i-1) - '0', 0);
            i++;
        }
        if(carry == 1) add(0, 0);
        sb.reverse();
        return sb.toString();
    }
}