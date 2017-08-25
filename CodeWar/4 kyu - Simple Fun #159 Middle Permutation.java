/*
http://www.codewars.com/kata/simple-fun-number-159-middle-permutation

Task

You are given a string s. Every letter in s appears once.

Consider all strings formed by rearranging the letters in s. 
After ordering these strings in dictionary order, return the middle term. 
(If the sequence has a even length n, define its middle term to be the (n/2)th term.)

Example

For s = "abc", the result should be "bac".

The permutations in order are:
"abc", "acb", "bac", "bca", "cab", "cba"
So, The middle term is "bac".
Input/Output

[input] string s

unique letters (2 < length <= 26)
[output] a string

middle permutation.
 */

// 写答案的注释，挺累的，以后自己能看懂就行orz

import java.util.*;
import java.math.*;

class MiddlePermutation {

    public static String findMidPerm(String strng) {
        // Sort given string
        char[] cc = strng.toCharArray();
        Arrays.sort(cc);
        String sortStr = "";
        for(char c : cc) {
            sortStr += c;
        }
        // If str's len <= 2, then return it directly :)
        if(sortStr.length() <= 2) {
            return sortStr;
        }
        // Because we need to calculate Factorial so many times, so put initial value in Factorial map,
        // then we can use those value that have been worked out fast
        fMap.put(0, BigInteger.valueOf(1));
        fMap.put(1, BigInteger.valueOf(1));
        // Ok, here is the core code :).
        // We need to know the mid position of the Permutation, which has N! elements.
        // For example, "abc" can generate "abc", "acb", "bac", "bca", "cab", "cba". 3! == 6.
        // Function should return "bac", whose position is 2(see it as an array, so 2 == 3!/2-1), 
        // what does that mean?
        // Before "bac" occur, "abc" and "acb" have been show, or we can say, 2 have been show.
        // 2 == 2! == (3-1)! * 1, what does the last thing mean?
        // It means, before the new character(ch) show at the 0th position in the resultStr,
        // (len(givenStr)-1)! * sortStr.indexOf(ch)(here is 1, for "abc"'s 'b' is index 1) strings have shown.
        // Or more: before the new character(ch) show at the kth position in the resultStr,
        // (len(givenStr)-(k+1))! * sortStr.indexOf(ch) strings have shown.
        // Ok, maybe that is not obvious, let's see "abcd": 
        // "abcd", "abdc", "acbd", "acdb", "adbc", "adcb",
        // "bacd", "badc"...
        // That's too long!! But it's obvious that when 1st character change("adcb" to "bacd"),
        // (4-1)! * 1 == 6 string have been show.
        // Be careful, before we focus on the next position's character in the resultStr, 
        // the sortStr should DELETE the previous position's character in the resultStr(have been used),
        // or sortStr.indexOf(ch) will not get the correct index in the future.
        // So we can figure out this:
        // Our purpose index is N!/2-1, which can be added by x!*y(x begin from N-1),
        // such as "abc", purpose == 2 == 2!*1("bac"), 
        // or "abcd", purpose == 11 == ↓
        // 3!*1("abcd"'s 'b') + 2!*2("acd"'s 'd') + 1!*1("ac"'s 'c') + 0!*0("a"'s 'a').
        // Obviously, when we get the purpose, remain characters can be appended to resultStr directly.
        // And sortStr like "a" or "bc", no position change in resultStr, so their purpose is 0.
        
        int len = strng.length();
        // 26! == 403291461126605635584000000, is greater than long value, so use BigInteger instead
        BigInteger purpose = doFactorial(len).divide(BigInteger.valueOf(2)).subtract(BigInteger.valueOf(1));
        // In (len(givenStr)-(k+1))! * sortStr.indexOf(ch), step means len(givenStr)-(k+1),
        // it start from len(givenStr)-1.
        int step = len-1;
        // i used to calculate how many step, which means sortStr.indexOf(ch)
        int i = 0;
        // Now value, need to equal with purpose
        BigInteger now = BigInteger.valueOf(0);
        // Temp value, used to add to now.
        BigInteger temp = BigInteger.valueOf(0);
        // Save sortStr.indexOf(ch) before step change, used to generate resultStr
        ArrayList<Integer> lastPosition = new ArrayList<>();
        
        while(now.compareTo(purpose) != 0) {
            temp = doFactorial(step);
            while(now.add(temp).compareTo(purpose) <= 0) {
                now = now.add(temp);
                i++;
            }
            lastPosition.add(i);
            i = 0;
            step--;
        }
        // Append directly
        while(lastPosition.size() != len) {
            lastPosition.add(0);
        }
        
        // Quickly generate resultStr
        StringBuilder sortStrSb = new StringBuilder(sortStr);
        StringBuilder result = new StringBuilder();
        for(int pos : lastPosition) {
            result.append(sortStrSb.charAt(pos));
            // Be careful! Must DELETE!
            sortStrSb.deleteCharAt(pos);
        }
        
        return result.toString();
    }
    
    private static HashMap<Integer, BigInteger> fMap = new HashMap<>(); 
    
    private static BigInteger doFactorial(int num) {
        if(fMap.get(num) != null) {
            return fMap.get(num);
        }
        BigInteger result = doFactorial(num-1).multiply(BigInteger.valueOf(num));
        fMap.put(num, result);
        return result;
    }

}