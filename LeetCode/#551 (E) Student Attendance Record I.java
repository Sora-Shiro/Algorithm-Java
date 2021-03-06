/*
You are given a string representing an attendance record for a student. 
The record only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than 
one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False
 */

public class Solution {
    public boolean checkRecord(String s) {
        char[] ss = s.toCharArray();
        int numL = 0;
        int numA = 0;
        for(int i = 0; i < ss.length; i++) {
            if(ss[i] == 'L') {
                numL++;
            } else {
                numL = 0;
                if(ss[i] == 'A') {
                    numA++;
                }
            }
            if(numL > 2 || numA > 1) {
                return false;
            }
        }
        return true;
    }
}