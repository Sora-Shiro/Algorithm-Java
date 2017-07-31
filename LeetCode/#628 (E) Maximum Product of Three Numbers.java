/*
Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:

Input: [1,2,3]
Output: 6

Example 2:

Input: [1,2,3,4]
Output: 24

Note:

    The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
    Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

 */

public class Solution {
    public int maximumProduct(int[] nums) {
        int len = nums.length;
        if(len == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        Arrays.sort(nums);
        return Math.max(nums[len-1] * nums[len-2] * nums[len-3], nums[0] * nums[1] * nums[len-1]);
    }
}

/*
We need not necessarily sort the given numsnumsnums array to find the maximum product. 
Instead, we can only find the required 2 smallest values(min1min1min1 and min2min2min2) 
and the three largest values(max1,max2,max3max1, max2, max3max1,max2,max3) in the numsnumsnums array, 
by iterating over the numsnumsnums array only once.

At the end, again we can find out the larger value out of min1min1min1xmin2min2min2xmax1max1max1 
and max1max1max1xmax2max2max2xmax3max3max3 to find the required maximum product.
 */
public class Solution_better {
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n: nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {     // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}