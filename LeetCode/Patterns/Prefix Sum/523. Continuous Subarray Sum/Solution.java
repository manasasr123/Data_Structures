import java.util.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Remainder 0 exists before the array starts
        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            int remainder = sum % k;

            if (map.containsKey(remainder)) {

                int previousIndex = map.get(remainder);

                // Subarray must contain at least 2 elements
                if (i - previousIndex >= 2) {
                    return true;
                }

            } else {
                // Store only the earliest index
                map.put(remainder, i);
            }
        }

        return false;
    }
}