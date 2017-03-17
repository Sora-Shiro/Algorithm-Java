/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			l.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			l.add(nums2[i]);
		}
		Collections.sort(l);
		if (l.size() % 2 == 0) {
			return (double) (l.get(l.size() / 2 - 1) + l.get(l.size() / 2)) / 2;
		} else {
			return (double) l.get(l.size() / 2);
		}
    }

    public double findMedianSortedArrays_new(int[] nums1, int[] nums2) {
        ArrayList<Integer> l = new ArrayList<Integer>();
		int i = 0, j = 0;

		for (; i < nums1.length && j < nums2.length;) {
			if (nums1[i] < nums2[j]) {
				l.add(nums1[i]);
				i++;
				continue;
			} else {
				l.add(nums2[j]);
				j++;
				continue;
			}
		}
		while (i < nums1.length) {
			l.add(nums1[i]);
			i++;
		}
		while (j < nums2.length) {
			l.add(nums2[j]);
			j++;
		}

		if (l.size() % 2 == 0) {
			return (double) (l.get(l.size() / 2 - 1) + l.get(l.size() / 2)) / 2;
		} else {
			return (double) l.get(l.size() / 2);
		}
    }

}

public class Solution_Better {
    public double findMedianSortedArrays(int[] A, int[] B) {
	    int m = A.length, n = B.length;
	    int l = (m + n + 1) / 2;
	    int r = (m + n + 2) / 2;
	    return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
	}

    public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
    	if (aStart > A.length - 1) return B[bStart + k - 1];            
    	if (bStart > B.length - 1) return A[aStart + k - 1];                
    	if (k == 1) return Math.min(A[aStart], B[bStart]);
    	
    	int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
    	if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1]; 
    	if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];        
    	
    	if (aMid < bMid) 
    	    return getkth(A, aStart + k/2, B, bStart, k - k/2);// Check: aRight + bLeft 
    	else 
    		return getkth(A, aStart, B, bStart + k/2, k - k/2);// Check: bRight + aLeft
    }
}
