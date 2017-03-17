/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
			return s;
		}

		String[] save = new String[numRows];
		for (int i = 0; i < numRows; i++) {
			save[i] = "";
		}

		int cycle = numRows * 2 - 2;
		for (int i = 0; i < s.length(); i++) {
			int base = i % cycle;
			if (base > numRows - 1) {
				base = numRows - (base - numRows) - 2;
			}
			save[base] += s.charAt(i);
		}

		String result = "";
		for (int i = 0; i < numRows; i++) {
			result += save[i];
		}
		return result;
    }

    public String convert_new(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
			return s;
		}

		String save = "";

		int first = 2 * numRows - 2;
		int second = 0;
		for (int j = 0; j < numRows; j++) {
			for (int i = j; i < s.length();) {
				save += s.charAt(i) + "";
				if (j == 0 || j == numRows - 1) {
					i += 2 * numRows - 2;
				} else {
					i += first;
					if(i < s.length()){
						save += s.charAt(i) + "";
					}
					i += second;
				}
			}
			first -= 2;
			second += 2;
		}

		return save;
    }

    public String convert_new2(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
			return s;
		}

		String[] save = new String[numRows];
		for (int i = 0; i < numRows; i++) {
			save[i] = "";
		}

		int j = 0;
		int len = s.length();
		while (j < len) {
	        for (int idx = 0; idx < numRows && j < len; idx++) // vertically down
	            save[idx] += (s.charAt(j++));
	        for (int idx = numRows-2; idx >= 1 && j < len; idx--) // obliquely up
	        	save[idx] += (s.charAt(j++));
	    }

		String result = "";
		for (int i = 0; i < numRows; i++) {
			result += save[i];
		}
		return result;
    }

    public String convert_better(String s, int nRows) {
	    char[] c = s.toCharArray();
	    int len = c.length;
	    StringBuffer[] sb = new StringBuffer[nRows];
	    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
	    
	    int i = 0;
	    while (i < len) {
	        for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
	            sb[idx].append(c[i++]);
	        for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
	            sb[idx].append(c[i++]);
	    }
	    for (int idx = 1; idx < sb.length; idx++)
	        sb[0].append(sb[idx]);
	    return sb[0].toString();
	}

	public String convert_new2_afterBetter(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        char[] c = s.toCharArray();
        StringBuffer sb = new StringBuffer();

        int first = 2 * numRows - 2;
        int second = 0;
        for (int j = 0; j < numRows; j++) {
            for (int i = j; i < s.length();) {
            	sb.append(c[i]);
                if (j == 0 || j == numRows - 1) {
                    i += 2 * numRows - 2;
                } else {
                    i += first;
                    if(i < s.length()){
                    	sb.append(c[i]);
                    }
                    i += second;
                }
            }
            first -= 2;
            second += 2;
        }

        return sb.toString();
    }
    
}