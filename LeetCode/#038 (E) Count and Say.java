/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

At the beginning, I got confusions about what is the nth sequence. 
Well, my solution is accepted now, so I'm going to give some examples of nth sequence here. 
The following are sequence from n=1 to n=10:

 1.    1
 2.    11
 3.    21
 4.    1211
 5.    111221 
 6.    312211
 7.    13112221
 8.    1113213211
 9.    31131211131221
 10.   13211311123113112211

From the examples you can see, the (i+1)th sequence is the "count and say" of the ith sequence!
 */

public String countAndSay(int n) {
	StringBuilder result = new StringBuilder("1");
	for (int i = 1; i < n; i++) {
		char pre = result.charAt(0);
		int count = 0;
		StringBuilder sb = new StringBuilder();
		char now = result.charAt(0);
		for (int j = 0; j < result.length(); j++) {
			now = result.charAt(j);
			if (pre == now)
				count++;
			else {
				sb.append(count).append(pre);
				pre = now;
				count = 1;
			}
		}
		sb.append(count).append(now);
		result = sb;
	}
	return result.toString();
}