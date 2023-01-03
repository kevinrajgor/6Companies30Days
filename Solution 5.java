/*Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them. */

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int dp[] = new int[nums.length];
        int[] pos = new int[nums.length];
        Arrays.sort(nums);
        int omax = 0;
        int omaxidx = 0;
        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            int imax = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] > max) {
                        max = dp[j];
                        imax = j;
                    }
                }
            }
            dp[i] = max + 1;
            pos[i] = imax;

            if (dp[i] > omax) {
                omax = dp[i];
                omaxidx = i;
            }
        }

        while (omaxidx != -1) {
            ans.add(nums[omaxidx]);
            omaxidx = pos[omaxidx];
        }
        System.out.println(omax);
        return ans;
    }
}