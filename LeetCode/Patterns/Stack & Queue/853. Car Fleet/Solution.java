import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        int[][] cars = new int[n][2];

        // Store position and speed
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort by position from nearest to target
        // to farthest from target
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            int pos = cars[i][0];
            int spd = cars[i][1];

            double time = (double)(target - pos) / spd;

            // If this car takes longer, it forms
            // a new fleet
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}