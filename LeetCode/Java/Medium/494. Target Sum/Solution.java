import java.util.*;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return solve(nums, 0, 0, target, memo);
    }

    private int solve(int[] nums, int index, int sum,
                      int target, Map<String, Integer> memo) {

        // All numbers used
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }

        String key = index + "," + sum;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Choose +
        int add = solve(nums, index + 1,
                        sum + nums[index], target, memo);

        // Choose -
        int subtract = solve(nums, index + 1,
                             sum - nums[index], target, memo);

        int ways = add + subtract;

        memo.put(key, ways);

        return ways;
    }
}