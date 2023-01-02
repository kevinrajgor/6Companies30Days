/*
 * Find all valid combinations of k numbers that sum up to n such that the
 * following conditions are true:
 * 
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain
 * the same combination twice, and the combinations may be returned in any
 * order.
 */

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combi(result, new ArrayList<>(), 1, 0, k, n);
        return result;
    }

    public void combi(List<List<Integer>> result, List<Integer> arr, int num, int sum, int k, int n) {
        if (k == 0 && n == sum) {
            result.add(new ArrayList<>(arr));
            return;
        }
        for (int i = num; i <= 9; i++) {
            sum += i;
            arr.add(i);
            combi(result, arr, i + 1, sum, k - 1, n);
            sum -= i;
            arr.remove(arr.size() - 1);
        }
    }
}