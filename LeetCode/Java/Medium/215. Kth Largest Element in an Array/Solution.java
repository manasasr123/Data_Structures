class Solution {

    public int findKthLargest(int[] nums, int k) {

        // kth largest = (n-k)th index in ascending order
        int target = nums.length - k;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == target) {
                return nums[pivotIndex];
            }

            if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        return -1;
    }

    public int partition(int[] nums, int left, int right) {

        int pivot = nums[right];

        int i = left;

        for (int j = left; j < right; j++) {

            if (nums[j] < pivot) {

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }
        }

        int temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;

        return i;
    }
}