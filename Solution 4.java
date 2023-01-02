/*
 * You are given an integer array nums of length n.
 * 
 * Assume arrk to be an array obtained by rotating nums by k positions
 * clock-wise. We define the rotation function F on nums as follow:
 * 
 * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
 * Return the maximum value of F(0), F(1), ..., F(n-1).
 * 
 * The test cases are generated so that the answer fits in a 32-bit integer.
 */

 class Solution {
    public int maxRotateFunction(int[] nums) {
        int first = 0;
        int second = 0;
        for (int i = 0; i < nums.length; i++) {
            first = first + (i * nums[i]);
            second = second + nums[i];
        }
        int n = nums.length;
        int ans = first;
        for (int i = n - 1; i >= 1; i--) {
            first = first + second - n * nums[i];
            ans = Math.max(ans, first);
        }
        return ans;
    }
}