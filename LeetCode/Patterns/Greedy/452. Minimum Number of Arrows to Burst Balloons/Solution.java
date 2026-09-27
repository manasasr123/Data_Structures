import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {

        // Sort by ending point
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;

        // Position of the first arrow
        int arrowPosition = points[0][1];

        for (int i = 1; i < points.length; i++) {

            // Current balloon starts after arrow position
            if (points[i][0] > arrowPosition) {

                arrows++;

                // Shoot new arrow at current balloon's end
                arrowPosition = points[i][1];
            }
        }

        return arrows;
    }
}