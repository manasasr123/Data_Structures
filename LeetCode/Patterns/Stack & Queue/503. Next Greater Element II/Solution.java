import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        // Initially, every answer is -1
        for (int i = 0; i < n; i++) {
            answer[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();

        // Traverse twice because the array is circular
        for (int i = 0; i < 2 * n; i++) {

            int index = i % n;

            while (!stack.isEmpty() &&
                   nums[stack.peek()] < nums[index]) {

                int previous = stack.pop();
                answer[previous] = nums[index];
            }

            // Push only during first traversal
            if (i < n) {
                stack.push(index);
            }
        }

        return answer;
    }
}