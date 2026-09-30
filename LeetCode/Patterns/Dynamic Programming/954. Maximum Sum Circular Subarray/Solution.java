class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int total = 0;

        int currentMax = nums[0];
        int maxSum = nums[0];

        int currentMin = nums[0];
        int minSum = nums[0];

        for (int i = 0; i < nums.length; i++) {

            total += nums[i];

            if (i > 0) {

                // Kadane for maximum subarray
                currentMax = Math.max(nums[i], currentMax + nums[i]);
                maxSum = Math.max(maxSum, currentMax);

                // Kadane for minimum subarray
                currentMin = Math.min(nums[i], currentMin + nums[i]);
                minSum = Math.min(minSum, currentMin);
            }
        }

        // All elements are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Maximum circular sum
        int circularSum = total - minSum;

        return Math.max(maxSum, circularSum);
    }
}