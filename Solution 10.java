/*
 * Given an integer array nums, you need to find one continuous subarray that if
 * you only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order.
 * 
 * Return the shortest such subarray and output its length.
 */

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = new int[nums.length]; // Original array (extra array)
        System.arraycopy(nums, 0, arr, 0, nums.length); // Sorted array copy
        Arrays.sort(arr);
        int start = 0, end = nums.length - 1;
        // Checking inequality b/w sorted and unsorted array
        for (; start < nums.length; start++) { // Finding start index
            if (nums[start] != arr[start])
                break;
        }
        if (start >= nums.length - 1)
            return 0; // If start point is reaching the end point
        for (; end >= 0; end--) { // Finding end index
            if (nums[end] != arr[end])
                break;
        }
        return end - start + 1; // returning length
    }
}